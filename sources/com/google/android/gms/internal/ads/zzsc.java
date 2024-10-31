package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

@zzark
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzsc implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzbwd = ((Long) zzwu.zzpz().zzd(zzaan.zzcsu)).longValue();
    private final Context zzbup;
    private final WindowManager zzbuv;
    private final PowerManager zzbuw;
    private final KeyguardManager zzbux;

    @VisibleForTesting
    private BroadcastReceiver zzbvf;
    private final Rect zzbvi;
    private Application zzbwe;
    private WeakReference<ViewTreeObserver> zzbwf;
    private WeakReference<View> zzbwg;
    private C1102tm zzbwh;
    private final DisplayMetrics zzbwk;
    private zzbai zzbua = new zzbai(zzbwd);
    private boolean zzbve = false;
    private int zzbwi = -1;
    private final HashSet<zzsg> zzbwj = new HashSet<>();

    public zzsc(Context context, View view) {
        this.zzbup = context.getApplicationContext();
        this.zzbuv = (WindowManager) context.getSystemService("window");
        this.zzbuw = (PowerManager) this.zzbup.getSystemService("power");
        this.zzbux = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzbup;
        if (context2 instanceof Application) {
            this.zzbwe = (Application) context2;
            this.zzbwh = new C1102tm((Application) context2, this);
        }
        this.zzbwk = context.getResources().getDisplayMetrics();
        this.zzbvi = new Rect();
        this.zzbvi.right = this.zzbuv.getDefaultDisplay().getWidth();
        this.zzbvi.bottom = this.zzbuv.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzbwg;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzf(view2);
        }
        this.zzbwg = new WeakReference<>(view);
        if (view != null) {
            if (com.google.android.gms.ads.internal.zzbv.g().isAttachedToWindow(view)) {
                zze(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final void zzap() {
        com.google.android.gms.ads.internal.zzbv.e();
        zzayh.zzelc.post(new RunnableC1074rm(this));
    }

    public final void zzbv(int i) {
        WeakReference<View> weakReference;
        boolean z;
        boolean z2;
        if (this.zzbwj.size() == 0 || (weakReference = this.zzbwg) == null) {
            return;
        }
        View view = weakReference.get();
        boolean z3 = i == 1;
        boolean z4 = view == null;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
            boolean localVisibleRect = view.getLocalVisibleRect(rect3);
            view.getHitRect(rect4);
            try {
                view.getLocationOnScreen(iArr);
                view.getLocationInWindow(iArr2);
            } catch (Exception e2) {
                zzbbd.zzb("Failure getting view location.", e2);
            }
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            z = globalVisibleRect;
            z2 = localVisibleRect;
        } else {
            z = false;
            z2 = false;
        }
        int windowVisibility = view != null ? view.getWindowVisibility() : 8;
        int i2 = this.zzbwi;
        if (i2 != -1) {
            windowVisibility = i2;
        }
        boolean z5 = !z4 && com.google.android.gms.ads.internal.zzbv.e().zza(view, this.zzbuw, this.zzbux) && z && z2 && windowVisibility == 0;
        if (z3 && !this.zzbua.tryAcquire() && z5 == this.zzbve) {
            return;
        }
        if (z5 || this.zzbve || i != 1) {
            zzsf zzsfVar = new zzsf(com.google.android.gms.ads.internal.zzbv.l().c(), this.zzbuw.isScreenOn(), view != null ? com.google.android.gms.ads.internal.zzbv.g().isAttachedToWindow(view) : false, view != null ? view.getWindowVisibility() : 8, zza(this.zzbvi), zza(rect), zza(rect2), z, zza(rect3), z2, zza(rect4), this.zzbwk.density, z5);
            Iterator<zzsg> it = this.zzbwj.iterator();
            while (it.hasNext()) {
                it.next().zza(zzsfVar);
            }
            this.zzbve = z5;
        }
    }

    private final int zzbw(int i) {
        return (int) (i / this.zzbwk.density);
    }

    private final void zze(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzbwf = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzbvf == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzbvf = new C1088sm(this);
            com.google.android.gms.ads.internal.zzbv.B().zza(this.zzbup, this.zzbvf, intentFilter);
        }
        Application application = this.zzbwe;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzbwh);
            } catch (Exception e2) {
                zzbbd.zzb("Error registering activity lifecycle callbacks.", e2);
            }
        }
    }

    private final void zzf(View view) {
        try {
            if (this.zzbwf != null) {
                ViewTreeObserver viewTreeObserver = this.zzbwf.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzbwf = null;
            }
        } catch (Exception e2) {
            zzbbd.zzb("Error while unregistering listeners from the last ViewTreeObserver.", e2);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e3) {
            zzbbd.zzb("Error while unregistering listeners from the ViewTreeObserver.", e3);
        }
        if (this.zzbvf != null) {
            try {
                com.google.android.gms.ads.internal.zzbv.B().zza(this.zzbup, this.zzbvf);
            } catch (IllegalStateException e4) {
                zzbbd.zzb("Failed trying to unregister the receiver", e4);
            } catch (Exception e5) {
                com.google.android.gms.ads.internal.zzbv.i().zza(e5, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzbvf = null;
        }
        Application application = this.zzbwe;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzbwh);
            } catch (Exception e6) {
                zzbbd.zzb("Error registering activity lifecycle callbacks.", e6);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzbv(3);
        zzap();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzbv(3);
        zzap();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzbv(3);
        zzap();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzbv(3);
        zzap();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbv(3);
        zzap();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzbv(3);
        zzap();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzbv(3);
        zzap();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzbv(2);
        zzap();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzbv(1);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzbwi = -1;
        zze(view);
        zzbv(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzbwi = -1;
        zzbv(3);
        zzap();
        zzf(view);
    }

    public final void zza(zzsg zzsgVar) {
        this.zzbwj.add(zzsgVar);
        zzbv(3);
    }

    public final void zzb(zzsg zzsgVar) {
        this.zzbwj.remove(zzsgVar);
    }

    public final void zznh() {
        zzbv(4);
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzbwg == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View view = this.zzbwg.get();
        if (view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.zzbwi = i;
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzbw(rect.left), zzbw(rect.top), zzbw(rect.right), zzbw(rect.bottom));
    }
}
