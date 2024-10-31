package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzrg implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final Context zzbup;
    private final WeakReference<zzaxf> zzbur;
    private final zzsq zzbut;
    protected final zzre zzbuu;
    private final WindowManager zzbuv;
    private final PowerManager zzbuw;
    private final KeyguardManager zzbux;
    private final DisplayMetrics zzbuy;
    private zzrn zzbuz;
    private boolean zzbva;
    private boolean zzbvd;

    @VisibleForTesting
    private BroadcastReceiver zzbvf;
    private float zzbvk;
    private final Object mLock = new Object();
    private boolean zzbqq = false;
    private boolean zzbvb = false;
    private final HashSet<zzrd> zzbvg = new HashSet<>();
    private final HashSet<zzsb> zzbvh = new HashSet<>();
    private final Rect zzbvi = new Rect();
    private WeakReference<ViewTreeObserver> zzbus = new WeakReference<>(null);
    private boolean zzbvc = true;
    private boolean zzbve = false;
    private zzbai zzbua = new zzbai(200);
    private final C0894em zzbvj = new C0894em(this, new Handler());

    public zzrg(Context context, zzwf zzwfVar, zzaxf zzaxfVar, zzbbi zzbbiVar, zzsq zzsqVar) {
        this.zzbur = new WeakReference<>(zzaxfVar);
        this.zzbut = zzsqVar;
        this.zzbuu = new zzre(UUID.randomUUID().toString(), zzbbiVar, zzwfVar.zzckk, zzaxfVar.zzehh, zzaxfVar.zzmu(), zzwfVar.zzckn);
        this.zzbuv = (WindowManager) context.getSystemService("window");
        this.zzbuw = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.zzbux = (KeyguardManager) context.getSystemService("keyguard");
        this.zzbup = context;
        this.zzbup.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.zzbvj);
        this.zzbuy = context.getResources().getDisplayMetrics();
        Display defaultDisplay = this.zzbuv.getDefaultDisplay();
        this.zzbvi.right = defaultDisplay.getWidth();
        this.zzbvi.bottom = defaultDisplay.getHeight();
        zzmw();
    }

    @VisibleForTesting
    private final boolean isScreenOn() {
        if (Build.VERSION.SDK_INT >= 20) {
            return this.zzbuw.isInteractive();
        }
        return this.zzbuw.isScreenOn();
    }

    private static int zza(int i, DisplayMetrics displayMetrics) {
        return (int) (i / displayMetrics.density);
    }

    private final void zzmy() {
        zzrn zzrnVar = this.zzbuz;
        if (zzrnVar != null) {
            zzrnVar.zza(this);
        }
    }

    private final void zzna() {
        ViewTreeObserver viewTreeObserver = this.zzbus.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this);
        viewTreeObserver.removeGlobalOnLayoutListener(this);
    }

    private final JSONObject zznb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.zzbuu.zzmr()).put("activeViewJSON", this.zzbuu.zzms()).put("timestamp", com.google.android.gms.ads.internal.zzbv.l().c()).put("adFormat", this.zzbuu.zzmq()).put("hashCode", this.zzbuu.zzmt()).put("isMraid", this.zzbuu.zzmu()).put("isStopped", this.zzbvb).put("isPaused", this.zzbqq).put("isNative", this.zzbuu.zzmv()).put("isScreenOn", isScreenOn()).put("appMuted", com.google.android.gms.ads.internal.zzbv.j().zzkk()).put("appVolume", com.google.android.gms.ads.internal.zzbv.j().zzkj()).put("deviceVolume", this.zzbvk);
        return jSONObject;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzbu(2);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzbu(1);
    }

    public final void pause() {
        synchronized (this.mLock) {
            this.zzbqq = true;
            zzbu(3);
        }
    }

    public final void resume() {
        synchronized (this.mLock) {
            this.zzbqq = false;
            zzbu(3);
        }
    }

    public final void stop() {
        synchronized (this.mLock) {
            this.zzbvb = true;
            zzbu(3);
        }
    }

    public final void zzb(zzsb zzsbVar) {
        this.zzbvh.remove(zzsbVar);
        zzsbVar.zzng();
        if (this.zzbvh.isEmpty()) {
            synchronized (this.mLock) {
                zzna();
                synchronized (this.mLock) {
                    if (this.zzbvf != null) {
                        try {
                            com.google.android.gms.ads.internal.zzbv.B().zza(this.zzbup, this.zzbvf);
                        } catch (IllegalStateException e2) {
                            zzbbd.zzb("Failed trying to unregister the receiver", e2);
                        } catch (Exception e3) {
                            com.google.android.gms.ads.internal.zzbv.i().zza(e3, "ActiveViewUnit.stopScreenStatusMonitoring");
                        }
                        this.zzbvf = null;
                    }
                }
                this.zzbup.getContentResolver().unregisterContentObserver(this.zzbvj);
                int i = 0;
                this.zzbvc = false;
                zzmy();
                ArrayList arrayList = new ArrayList(this.zzbvh);
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zzb((zzsb) obj);
                }
            }
        }
    }

    public final void zzbu(int i) {
        boolean z;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        synchronized (this.mLock) {
            Iterator<zzsb> it = this.zzbvh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().zznf()) {
                    z = true;
                    break;
                }
            }
            if (z && this.zzbvc) {
                View zznc = this.zzbut.zznc();
                boolean z2 = zznc != null && com.google.android.gms.ads.internal.zzbv.e().zza(zznc, this.zzbuw, this.zzbux);
                boolean z3 = zznc != null && z2 && zznc.getGlobalVisibleRect(new Rect(), null);
                if (this.zzbut.zznd()) {
                    zzmx();
                    return;
                }
                if (i == 1 && !this.zzbua.tryAcquire() && z3 == this.zzbve) {
                    return;
                }
                if (z3 || this.zzbve || i != 1) {
                    try {
                        zza(zza(zznc, Boolean.valueOf(z2)), false);
                        this.zzbve = z3;
                    } catch (RuntimeException | JSONException e2) {
                        zzbbd.zza("Active view update failed.", e2);
                    }
                    View zznc2 = this.zzbut.zzne().zznc();
                    if (zznc2 != null && (viewTreeObserver2 = zznc2.getViewTreeObserver()) != (viewTreeObserver = this.zzbus.get())) {
                        zzna();
                        if (!this.zzbva || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
                            this.zzbva = true;
                            viewTreeObserver2.addOnScrollChangedListener(this);
                            viewTreeObserver2.addOnGlobalLayoutListener(this);
                        }
                        this.zzbus = new WeakReference<>(viewTreeObserver2);
                    }
                    zzmy();
                }
            }
        }
    }

    public final boolean zzc(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzbuu.zzmt());
    }

    public final void zzd(Map<String, String> map) {
        zzbu(3);
    }

    public final void zze(Map<String, String> map) {
        if (map.containsKey("isVisible")) {
            boolean z = "1".equals(map.get("isVisible")) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(map.get("isVisible"));
            Iterator<zzrd> it = this.zzbvg.iterator();
            while (it.hasNext()) {
                it.next().zza(this, z);
            }
        }
    }

    public final void zzmw() {
        this.zzbvk = zzaza.zzbb(this.zzbup);
    }

    public final void zzmx() {
        synchronized (this.mLock) {
            if (this.zzbvc) {
                this.zzbvd = true;
                try {
                    try {
                        JSONObject zznb = zznb();
                        zznb.put("doneReasonCode", com.facebook.appevents.u.f9225a);
                        zza(zznb, true);
                    } catch (JSONException e2) {
                        zzbbd.zzb("JSON failure while processing active view data.", e2);
                    }
                } catch (RuntimeException e3) {
                    zzbbd.zzb("Failure while processing active view data.", e3);
                }
                String valueOf = String.valueOf(this.zzbuu.zzmt());
                zzbbd.zzdn(valueOf.length() != 0 ? "Untracking ad unit: ".concat(valueOf) : new String("Untracking ad unit: "));
            }
        }
    }

    public final boolean zzmz() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzbvc;
        }
        return z;
    }

    public final void zza(zzsb zzsbVar, Map<String, String> map) {
        String valueOf = String.valueOf(this.zzbuu.zzmt());
        zzbbd.zzdn(valueOf.length() != 0 ? "Received request to untrack: ".concat(valueOf) : new String("Received request to untrack: "));
        zzb(zzsbVar);
    }

    private static JSONObject zza(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }

    private final void zza(JSONObject jSONObject, boolean z) {
        try {
            JSONObject zza = zza(jSONObject);
            ArrayList arrayList = new ArrayList(this.zzbvh);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((zzsb) obj).zzb(zza, z);
            }
        } catch (Throwable th) {
            zzbbd.zzb("Skipping active view message.", th);
        }
    }

    public final void zza(zzsb zzsbVar) {
        if (this.zzbvh.isEmpty()) {
            synchronized (this.mLock) {
                if (this.zzbvf == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    this.zzbvf = new C0880dm(this);
                    com.google.android.gms.ads.internal.zzbv.B().zza(this.zzbup, this.zzbvf, intentFilter);
                }
            }
            zzbu(3);
        }
        this.zzbvh.add(zzsbVar);
        try {
            zzsbVar.zzb(zza(zza(this.zzbut.zznc(), (Boolean) null)), false);
        } catch (JSONException e2) {
            zzbbd.zzb("Skipping measurement update for new client.", e2);
        }
    }

    private final JSONObject zza(View view, Boolean bool) throws JSONException {
        if (view == null) {
            return zznb().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
        }
        boolean isAttachedToWindow = com.google.android.gms.ads.internal.zzbv.g().isAttachedToWindow(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Exception e2) {
            zzbbd.zzb("Failure getting view location.", e2);
        }
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect2, null);
        Rect rect3 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect3);
        Rect rect4 = new Rect();
        view.getHitRect(rect4);
        JSONObject zznb = zznb();
        zznb.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", isAttachedToWindow).put("viewBox", new JSONObject().put("top", zza(this.zzbvi.top, this.zzbuy)).put("bottom", zza(this.zzbvi.bottom, this.zzbuy)).put("left", zza(this.zzbvi.left, this.zzbuy)).put("right", zza(this.zzbvi.right, this.zzbuy))).put("adBox", new JSONObject().put("top", zza(rect.top, this.zzbuy)).put("bottom", zza(rect.bottom, this.zzbuy)).put("left", zza(rect.left, this.zzbuy)).put("right", zza(rect.right, this.zzbuy))).put("globalVisibleBox", new JSONObject().put("top", zza(rect2.top, this.zzbuy)).put("bottom", zza(rect2.bottom, this.zzbuy)).put("left", zza(rect2.left, this.zzbuy)).put("right", zza(rect2.right, this.zzbuy))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", zza(rect3.top, this.zzbuy)).put("bottom", zza(rect3.bottom, this.zzbuy)).put("left", zza(rect3.left, this.zzbuy)).put("right", zza(rect3.right, this.zzbuy))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", zza(rect4.top, this.zzbuy)).put("bottom", zza(rect4.bottom, this.zzbuy)).put("left", zza(rect4.left, this.zzbuy)).put("right", zza(rect4.right, this.zzbuy))).put("screenDensity", this.zzbuy.density);
        zznb.put("isVisible", (bool == null ? Boolean.valueOf(com.google.android.gms.ads.internal.zzbv.e().zza(view, this.zzbuw, this.zzbux)) : bool).booleanValue());
        return zznb;
    }

    public final void zza(zzrn zzrnVar) {
        synchronized (this.mLock) {
            this.zzbuz = zzrnVar;
        }
    }
}
