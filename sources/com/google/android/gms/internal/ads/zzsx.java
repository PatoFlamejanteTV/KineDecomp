package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzsx extends Thread {
    private final Object mLock;
    private boolean mStarted;
    private boolean zzbm;
    private final int zzbwy;
    private final int zzbxa;
    private boolean zzbxz;
    private final zzss zzbya;
    private final int zzbyb;
    private final int zzbyc;
    private final int zzbyd;
    private final int zzbye;
    private final int zzbyf;
    private final int zzbyg;
    private final String zzbyh;
    private final boolean zzbyi;

    public zzsx() {
        this(new zzss());
    }

    @VisibleForTesting
    private final Hm zza(View view, zzsr zzsrVar) {
        boolean z;
        if (view == null) {
            return new Hm(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (!TextUtils.isEmpty(text)) {
                zzsrVar.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
                return new Hm(this, 1, 0);
            }
            return new Hm(this, 0, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzbgg)) {
            zzsrVar.zzno();
            WebView webView = (WebView) view;
            if (PlatformVersion.f()) {
                zzsrVar.zzno();
                webView.post(new Em(this, zzsrVar, webView, globalVisibleRect));
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return new Hm(this, 0, 1);
            }
            return new Hm(this, 0, 0);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                Hm zza = zza(viewGroup.getChildAt(i3), zzsrVar);
                i += zza.f11586a;
                i2 += zza.f11587b;
            }
            return new Hm(this, i, i2);
        }
        return new Hm(this, 0, 0);
    }

    @VisibleForTesting
    private static boolean zznt() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            Context context = com.google.android.gms.ads.internal.zzbv.h().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return powerManager == null ? false : powerManager.isScreenOn();
                }
            }
            return false;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzbv.i().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void zznv() {
        synchronized (this.mLock) {
            this.zzbxz = true;
            boolean z = this.zzbxz;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(z);
            zzbbd.zzdn(sb.toString());
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                if (zznt()) {
                    Activity activity = com.google.android.gms.ads.internal.zzbv.h().getActivity();
                    if (activity == null) {
                        zzbbd.zzdn("ContentFetchThread: no activity. Sleeping.");
                        zznv();
                    } else if (activity != null) {
                        View view = null;
                        try {
                            if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                                view = activity.getWindow().getDecorView().findViewById(R.id.content);
                            }
                        } catch (Exception e2) {
                            com.google.android.gms.ads.internal.zzbv.i().zza(e2, "ContentFetchTask.extractContent");
                            zzbbd.zzdn("Failed getting root view of activity. Content not extracted.");
                        }
                        if (view != null && view != null) {
                            view.post(new Dm(this, view));
                        }
                    }
                } else {
                    zzbbd.zzdn("ContentFetchTask: sleeping");
                    zznv();
                }
                Thread.sleep(this.zzbyb * 1000);
            } catch (InterruptedException e3) {
                zzbbd.zzb("Error in ContentFetchTask", e3);
            } catch (Exception e4) {
                zzbbd.zzb("Error in ContentFetchTask", e4);
                com.google.android.gms.ads.internal.zzbv.i().zza(e4, "ContentFetchTask.run");
            }
            synchronized (this.mLock) {
                while (this.zzbxz) {
                    try {
                        zzbbd.zzdn("ContentFetchTask: waiting");
                        this.mLock.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public final void wakeup() {
        synchronized (this.mLock) {
            this.zzbxz = false;
            this.mLock.notifyAll();
            zzbbd.zzdn("ContentFetchThread: wakeup");
        }
    }

    @VisibleForTesting
    public final void zzk(View view) {
        try {
            zzsr zzsrVar = new zzsr(this.zzbwy, this.zzbyc, this.zzbxa, this.zzbyd, this.zzbye, this.zzbyf, this.zzbyg);
            Context context = com.google.android.gms.ads.internal.zzbv.h().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbyh)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzwu.zzpz().zzd(zzaan.zzcqi), "id", context.getPackageName()));
                if (str != null && str.equals(this.zzbyh)) {
                    return;
                }
            }
            Hm zza = zza(view, zzsrVar);
            zzsrVar.zznp();
            if (zza.f11586a == 0 && zza.f11587b == 0) {
                return;
            }
            if (zza.f11587b == 0 && zzsrVar.zznq() == 0) {
                return;
            }
            if (zza.f11587b == 0 && this.zzbya.zza(zzsrVar)) {
                return;
            }
            this.zzbya.zzc(zzsrVar);
        } catch (Exception e2) {
            zzbbd.zzb("Exception in fetchContentOnUIThread", e2);
            com.google.android.gms.ads.internal.zzbv.i().zza(e2, "ContentFetchTask.fetchContent");
        }
    }

    public final void zzns() {
        synchronized (this.mLock) {
            if (this.mStarted) {
                zzbbd.zzdn("Content hash thread already started, quiting...");
            } else {
                this.mStarted = true;
                start();
            }
        }
    }

    public final zzsr zznu() {
        return this.zzbya.zznr();
    }

    public final boolean zznw() {
        return this.zzbxz;
    }

    @VisibleForTesting
    private zzsx(zzss zzssVar) {
        this.mStarted = false;
        this.zzbxz = false;
        this.zzbm = false;
        this.zzbya = zzssVar;
        this.mLock = new Object();
        this.zzbwy = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqa)).intValue();
        this.zzbyc = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqb)).intValue();
        this.zzbxa = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqc)).intValue();
        this.zzbyd = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqd)).intValue();
        this.zzbye = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqf)).intValue();
        this.zzbyf = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqg)).intValue();
        this.zzbyg = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqh)).intValue();
        this.zzbyb = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqe)).intValue();
        this.zzbyh = (String) zzwu.zzpz().zzd(zzaan.zzcqj);
        this.zzbyi = ((Boolean) zzwu.zzpz().zzd(zzaan.zzcqk)).booleanValue();
        setName("ContentFetchTask");
    }

    @VisibleForTesting
    public final void zza(zzsr zzsrVar, WebView webView, String str, boolean z) {
        zzsrVar.zznn();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (!this.zzbyi && !TextUtils.isEmpty(webView.getTitle())) {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzsrVar.zza(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzsrVar.zza(optString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzsrVar.zzni()) {
                this.zzbya.zzb(zzsrVar);
            }
        } catch (JSONException unused) {
            zzbbd.zzdn("Json string may be malformed.");
        } catch (Throwable th) {
            zzbbd.zza("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzbv.i().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }
}
