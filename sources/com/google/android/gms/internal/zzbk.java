package com.google.android.gms.internal;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzbk extends Thread {
    private final zzbj zzsa;
    private final zzbi zzsb;
    private final zzgq zzsc;
    private boolean mStarted = false;
    private boolean zzrZ = false;
    private boolean zzam = false;
    private final Object zzpd = new Object();
    private final int zzrN = zzby.zzuU.get().intValue();
    private final int zzse = zzby.zzuV.get().intValue();
    private final int zzrP = zzby.zzuW.get().intValue();
    private final int zzsf = zzby.zzuX.get().intValue();
    private final int zzsd = zzby.zzuY.get().intValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    @zzgr
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        final int f1686a;
        final int b;

        a(int i, int i2) {
            this.f1686a = i;
            this.b = i2;
        }
    }

    public zzbk(zzbj zzbjVar, zzbi zzbiVar, zzgq zzgqVar) {
        this.zzsa = zzbjVar;
        this.zzsb = zzbiVar;
        this.zzsc = zzgqVar;
        setName("ContentFetchTask");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.zzam) {
            try {
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzb.b("Error in ContentFetchTask", th);
                this.zzsc.zza(th, true);
            }
            if (zzcu()) {
                Activity activity = this.zzsa.getActivity();
                if (activity == null) {
                    com.google.android.gms.ads.internal.util.client.zzb.a("ContentFetchThread: no activity");
                } else {
                    zza(activity);
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.a("ContentFetchTask: sleeping");
                zzcw();
            }
            Thread.sleep(this.zzsd * LicenseErrCode.LICENSE_STATUS_NOT_LICENSED);
            synchronized (this.zzpd) {
                while (this.zzrZ) {
                    try {
                        com.google.android.gms.ads.internal.util.client.zzb.a("ContentFetchTask: waiting");
                        this.zzpd.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.zzpd) {
            this.zzrZ = false;
            this.zzpd.notifyAll();
            com.google.android.gms.ads.internal.util.client.zzb.a("ContentFetchThread: wakeup");
        }
    }

    a zza(View view, zzbh zzbhVar) {
        if (view == null) {
            return new a(0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new a(0, 0);
            }
            zzbhVar.zzw(text.toString());
            return new a(1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zziz)) {
            zzbhVar.zzcp();
            return zza((WebView) view, zzbhVar) ? new a(0, 1) : new a(0, 0);
        }
        if (!(view instanceof ViewGroup)) {
            return new a(0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            a zza = zza(viewGroup.getChildAt(i3), zzbhVar);
            i2 += zza.f1686a;
            i += zza.b;
        }
        return new a(i2, i);
    }

    void zza(Activity activity) {
        if (activity == null) {
            return;
        }
        View view = null;
        if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            view = activity.getWindow().getDecorView().findViewById(R.id.content);
        }
        if (view != null) {
            zzf(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(zzbh zzbhVar, WebView webView, String str) {
        zzbhVar.zzco();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    zzbhVar.zzv(optString);
                } else {
                    zzbhVar.zzv(webView.getTitle() + "\n" + optString);
                }
            }
            if (zzbhVar.zzcl()) {
                this.zzsb.zzb(zzbhVar);
            }
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.a("Json string may be malformed.");
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.a("Failed to get webview content.", th);
            this.zzsc.zza(th, true);
        }
    }

    boolean zza(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    boolean zza(WebView webView, zzbh zzbhVar) {
        if (!zzmx.zzqB()) {
            return false;
        }
        zzbhVar.zzcp();
        webView.post(new w(this, zzbhVar, webView));
        return true;
    }

    public void zzct() {
        synchronized (this.zzpd) {
            if (this.mStarted) {
                com.google.android.gms.ads.internal.util.client.zzb.a("Content hash thread already started, quiting...");
            } else {
                this.mStarted = true;
                start();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:            if (zza(r0) == false) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:            if (r1.inKeyguardRestrictedInputMode() != false) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:            if (zzr(r3) == false) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:            return true;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean zzcu() {
        /*
            r7 = this;
            r2 = 0
            com.google.android.gms.internal.zzbj r0 = r7.zzsa     // Catch: java.lang.Throwable -> L57
            android.content.Context r3 = r0.getContext()     // Catch: java.lang.Throwable -> L57
            if (r3 != 0) goto Lb
            r0 = r2
        La:
            return r0
        Lb:
            java.lang.String r0 = "activity"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch: java.lang.Throwable -> L57
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch: java.lang.Throwable -> L57
            java.lang.String r1 = "keyguard"
            java.lang.Object r1 = r3.getSystemService(r1)     // Catch: java.lang.Throwable -> L57
            android.app.KeyguardManager r1 = (android.app.KeyguardManager) r1     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L1f
            if (r1 != 0) goto L21
        L1f:
            r0 = r2
            goto La
        L21:
            java.util.List r0 = r0.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L57
            if (r0 != 0) goto L29
            r0 = r2
            goto La
        L29:
            java.util.Iterator r4 = r0.iterator()     // Catch: java.lang.Throwable -> L57
        L2d:
            boolean r0 = r4.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L55
            java.lang.Object r0 = r4.next()     // Catch: java.lang.Throwable -> L57
            android.app.ActivityManager$RunningAppProcessInfo r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0     // Catch: java.lang.Throwable -> L57
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L57
            int r6 = r0.pid     // Catch: java.lang.Throwable -> L57
            if (r5 != r6) goto L2d
            boolean r0 = r7.zza(r0)     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L55
            boolean r0 = r1.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L57
            if (r0 != 0) goto L55
            boolean r0 = r7.zzr(r3)     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L55
            r0 = 1
            goto La
        L55:
            r0 = r2
            goto La
        L57:
            r0 = move-exception
            r0 = r2
            goto La
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbk.zzcu():boolean");
    }

    public zzbh zzcv() {
        return this.zzsb.zzcs();
    }

    public void zzcw() {
        synchronized (this.zzpd) {
            this.zzrZ = true;
            com.google.android.gms.ads.internal.util.client.zzb.a("ContentFetchThread: paused, mPause = " + this.zzrZ);
        }
    }

    public boolean zzcx() {
        return this.zzrZ;
    }

    boolean zzf(View view) {
        if (view == null) {
            return false;
        }
        view.post(new v(this, view));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzg(View view) {
        try {
            zzbh zzbhVar = new zzbh(this.zzrN, this.zzse, this.zzrP, this.zzsf);
            a zza = zza(view, zzbhVar);
            zzbhVar.zzcq();
            if (zza.f1686a == 0 && zza.b == 0) {
                return;
            }
            if (zza.b == 0 && zzbhVar.zzcr() == 0) {
                return;
            }
            if (zza.b == 0 && this.zzsb.zza(zzbhVar)) {
                return;
            }
            this.zzsb.zzc(zzbhVar);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Exception in fetchContentOnUIThread", e);
            this.zzsc.zza(e, true);
        }
    }

    boolean zzr(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }
}
