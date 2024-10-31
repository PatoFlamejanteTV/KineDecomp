package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class zzdu implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final Handler zztu = new Handler(Looper.getMainLooper());
    private final zzdl zzqo;
    private Application zzsg;
    private final Context zztv;
    private final PowerManager zztw;
    private final KeyguardManager zztx;
    private BroadcastReceiver zzty;
    private WeakReference<ViewTreeObserver> zztz;
    private WeakReference<View> zzua;
    private Cj zzub;
    private boolean zzuc = false;
    private int zzud = -1;
    private long zzue = -3;

    public zzdu(zzdl zzdlVar, View view) {
        this.zzqo = zzdlVar;
        this.zztv = zzdlVar.zzsp;
        this.zztw = (PowerManager) this.zztv.getSystemService("power");
        this.zztx = (KeyguardManager) this.zztv.getSystemService("keyguard");
        Context context = this.zztv;
        if (context instanceof Application) {
            this.zzsg = (Application) context;
            this.zzub = new Cj((Application) context, this);
        }
        zzd(view);
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzua == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View view = this.zzua.get();
        if (view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.zzud = i;
    }

    private final void zzap() {
        zztu.post(new Pj(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:            if (r4 == false) goto L76;     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzar() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r9.zzua
            if (r0 != 0) goto L5
            return
        L5:
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            r1 = 0
            if (r0 != 0) goto L15
            r2 = -3
            r9.zzue = r2
            r9.zzuc = r1
            return
        L15:
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            boolean r2 = r0.getGlobalVisibleRect(r2)
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            boolean r3 = r0.getLocalVisibleRect(r3)
            com.google.android.gms.internal.ads.zzdl r4 = r9.zzqo
            boolean r4 = r4.zzaj()
            r5 = 1
            if (r4 != 0) goto L5b
            android.app.KeyguardManager r4 = r9.zztx
            boolean r4 = r4.inKeyguardRestrictedInputMode()
            if (r4 == 0) goto L59
            android.app.Activity r4 = com.google.android.gms.internal.ads.zzds.zzc(r0)
            if (r4 == 0) goto L55
            android.view.Window r4 = r4.getWindow()
            if (r4 != 0) goto L46
            r4 = 0
            goto L4a
        L46:
            android.view.WindowManager$LayoutParams r4 = r4.getAttributes()
        L4a:
            if (r4 == 0) goto L55
            int r4 = r4.flags
            r6 = 524288(0x80000, float:7.34684E-40)
            r4 = r4 & r6
            if (r4 == 0) goto L55
            r4 = 1
            goto L56
        L55:
            r4 = 0
        L56:
            if (r4 == 0) goto L59
            goto L5b
        L59:
            r4 = 0
            goto L5c
        L5b:
            r4 = 1
        L5c:
            int r6 = r0.getWindowVisibility()
            int r7 = r9.zzud
            r8 = -1
            if (r7 == r8) goto L66
            r6 = r7
        L66:
            int r7 = r0.getVisibility()
            if (r7 != 0) goto L83
            boolean r0 = r0.isShown()
            if (r0 == 0) goto L83
            android.os.PowerManager r0 = r9.zztw
            boolean r0 = r0.isScreenOn()
            if (r0 == 0) goto L83
            if (r4 == 0) goto L83
            if (r3 == 0) goto L83
            if (r2 == 0) goto L83
            if (r6 != 0) goto L83
            r1 = 1
        L83:
            boolean r0 = r9.zzuc
            if (r0 == r1) goto L94
            if (r1 == 0) goto L8e
            long r2 = android.os.SystemClock.elapsedRealtime()
            goto L90
        L8e:
            r2 = -2
        L90:
            r9.zzue = r2
            r9.zzuc = r1
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdu.zzar():void");
    }

    private final void zze(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zztz = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzty == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzty = new Qj(this);
            this.zztv.registerReceiver(this.zzty, intentFilter);
        }
        Application application = this.zzsg;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzub);
            } catch (Exception unused) {
            }
        }
    }

    private final void zzf(View view) {
        try {
            if (this.zztz != null) {
                ViewTreeObserver viewTreeObserver = this.zztz.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zztz = null;
            }
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        BroadcastReceiver broadcastReceiver = this.zzty;
        if (broadcastReceiver != null) {
            try {
                this.zztv.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused3) {
            }
            this.zzty = null;
        }
        Application application = this.zzsg;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzub);
            } catch (Exception unused4) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzar();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzar();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzar();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzar();
        zzap();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzar();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzar();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzar();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzar();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzar();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzud = -1;
        zze(view);
        zzar();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzud = -1;
        zzar();
        zzap();
        zzf(view);
    }

    public final long zzaq() {
        if (this.zzue == -2 && this.zzua.get() == null) {
            this.zzue = -3L;
        }
        return this.zzue;
    }

    public final void zzd(View view) {
        WeakReference<View> weakReference = this.zzua;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzf(view2);
        }
        this.zzua = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                zze(view);
            }
            view.addOnAttachStateChangeListener(this);
            this.zzue = -2L;
            return;
        }
        this.zzue = -3L;
    }
}
