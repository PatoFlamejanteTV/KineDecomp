package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzact extends zzadl implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzacw {

    @VisibleForTesting
    static final String[] zzdcy = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, "3010"};

    @VisibleForTesting
    private zzacd zzdbj;

    @VisibleForTesting
    private View zzddc;
    private final WeakReference<View> zzddj;
    private final Object mLock = new Object();
    private final Map<String, WeakReference<View>> zzddk = new HashMap();
    private final Map<String, WeakReference<View>> zzddl = new HashMap();
    private final Map<String, WeakReference<View>> zzddm = new HashMap();

    @VisibleForTesting
    private Point zzdde = new Point();

    @VisibleForTesting
    private Point zzddf = new Point();

    @VisibleForTesting
    private WeakReference<zzsc> zzddg = new WeakReference<>(null);

    public zzact(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        com.google.android.gms.ads.internal.zzbv.D();
        zzbct.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzbv.D();
        zzbct.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        this.zzddj = new WeakReference<>(view);
        for (Map.Entry<String, View> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.zzddk.put(key, new WeakReference<>(value));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key) && !"3011".equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
        this.zzddm.putAll(this.zzddk);
        for (Map.Entry<String, View> entry2 : hashMap2.entrySet()) {
            View value2 = entry2.getValue();
            if (value2 != null) {
                this.zzddl.put(entry2.getKey(), new WeakReference<>(value2));
                value2.setOnTouchListener(this);
            }
        }
        this.zzddm.putAll(this.zzddl);
        zzaan.initialize(view.getContext());
    }

    @VisibleForTesting
    private final int zzck(int i) {
        int zzb;
        synchronized (this.mLock) {
            zzwu.zzpv();
            zzb = zzbat.zzb(this.zzdbj.getContext(), i);
        }
        return zzb;
    }

    private final void zzm(View view) {
        zzacd zzacdVar;
        synchronized (this.mLock) {
            if (this.zzdbj != null) {
                if (this.zzdbj instanceof zzacc) {
                    zzacdVar = ((zzacc) this.zzdbj).zzso();
                } else {
                    zzacdVar = this.zzdbj;
                }
                if (zzacdVar != null) {
                    zzacdVar.zzm(view);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                return;
            }
            View view2 = this.zzddj.get();
            if (view2 == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat(FragmentC2201x.f23219a, zzck(this.zzdde.x));
            bundle.putFloat("y", zzck(this.zzdde.y));
            bundle.putFloat("start_x", zzck(this.zzddf.x));
            bundle.putFloat("start_y", zzck(this.zzddf.y));
            if (this.zzddc != null && this.zzddc.equals(view)) {
                if (this.zzdbj instanceof zzacc) {
                    if (((zzacc) this.zzdbj).zzso() != null) {
                        ((zzacc) this.zzdbj).zzso().zza(view, NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, bundle, this.zzddm, view2, false);
                    }
                } else {
                    this.zzdbj.zza(view, NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, bundle, this.zzddm, view2, false);
                }
            } else {
                this.zzdbj.zza(view, this.zzddm, bundle, view2);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View view;
        synchronized (this.mLock) {
            if (this.zzdbj != null && (view = this.zzddj.get()) != null) {
                this.zzdbj.zzc(view, this.zzddm);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        View view;
        synchronized (this.mLock) {
            if (this.zzdbj != null && (view = this.zzddj.get()) != null) {
                this.zzdbj.zzc(view, this.zzddm);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                return false;
            }
            View view2 = this.zzddj.get();
            if (view2 == null) {
                return false;
            }
            view2.getLocationOnScreen(new int[2]);
            Point point = new Point((int) (motionEvent.getRawX() - r2[0]), (int) (motionEvent.getRawY() - r2[1]));
            this.zzdde = point;
            if (motionEvent.getAction() == 0) {
                this.zzddf = point;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation(point.x, point.y);
            this.zzdbj.zzd(obtain);
            obtain.recycle();
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final void unregisterNativeAd() {
        synchronized (this.mLock) {
            this.zzddc = null;
            this.zzdbj = null;
            this.zzdde = null;
            this.zzddf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final void zza(IObjectWrapper iObjectWrapper) {
        int i;
        KeyEvent.Callback callback;
        synchronized (this.mLock) {
            zzm(null);
            Object a2 = ObjectWrapper.a(iObjectWrapper);
            if (!(a2 instanceof zzach)) {
                zzbbd.zzeo("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            zzach zzachVar = (zzach) a2;
            if (!zzachVar.zzsl()) {
                zzbbd.e("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
                return;
            }
            View view = this.zzddj.get();
            if (this.zzdbj != null && view != null) {
                this.zzdbj.zzb(view, this.zzddm);
            }
            synchronized (this.mLock) {
                i = 0;
                if (this.zzdbj instanceof zzach) {
                    zzach zzachVar2 = (zzach) this.zzdbj;
                    View view2 = this.zzddj.get();
                    if (zzachVar2 != null && zzachVar2.getContext() != null && view2 != null && com.google.android.gms.ads.internal.zzbv.E().zzv(view2.getContext())) {
                        zzawv zzsu = zzachVar2.zzsu();
                        if (zzsu != null) {
                            zzsu.zzai(false);
                        }
                        zzsc zzscVar = this.zzddg.get();
                        if (zzscVar != null && zzsu != null) {
                            zzscVar.zzb(zzsu);
                        }
                    }
                }
            }
            if ((this.zzdbj instanceof zzacc) && ((zzacc) this.zzdbj).zzsn()) {
                ((zzacc) this.zzdbj).zzc(zzachVar);
            } else {
                this.zzdbj = zzachVar;
                if (zzachVar instanceof zzacc) {
                    ((zzacc) zzachVar).zzc(null);
                }
            }
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
            while (true) {
                if (i >= 2) {
                    callback = null;
                    break;
                }
                WeakReference<View> weakReference = this.zzddm.get(strArr[i]);
                if (weakReference != null) {
                    callback = (View) weakReference.get();
                    break;
                }
                i++;
            }
            if (callback == null) {
                zzbbd.zzeo("Ad choices asset view is not provided.");
            } else {
                ViewGroup viewGroup = callback instanceof ViewGroup ? (ViewGroup) callback : null;
                if (viewGroup != null) {
                    this.zzddc = zzachVar.zza((View.OnClickListener) this, true);
                    if (this.zzddc != null) {
                        this.zzddm.put(NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, new WeakReference<>(this.zzddc));
                        this.zzddk.put(NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, new WeakReference<>(this.zzddc));
                        viewGroup.removeAllViews();
                        viewGroup.addView(this.zzddc);
                    }
                }
            }
            zzachVar.zza(view, this.zzddk, this.zzddl, this, this);
            zzayh.zzelc.post(new RunnableC1173z(this, zzachVar));
            zzm(view);
            this.zzdbj.zzj(view);
            synchronized (this.mLock) {
                if (this.zzdbj instanceof zzach) {
                    zzach zzachVar3 = (zzach) this.zzdbj;
                    View view3 = this.zzddj.get();
                    if (zzachVar3 != null && zzachVar3.getContext() != null && view3 != null && com.google.android.gms.ads.internal.zzbv.E().zzv(view3.getContext())) {
                        zzsc zzscVar2 = this.zzddg.get();
                        if (zzscVar2 == null) {
                            zzscVar2 = new zzsc(view3.getContext(), view3);
                            this.zzddg = new WeakReference<>(zzscVar2);
                        }
                        zzscVar2.zza(zzachVar3.zzsu());
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final void zzc(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            this.zzdbj.setClickConfirmingView((View) ObjectWrapper.a(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final synchronized Map<String, WeakReference<View>> zzsv() {
        return this.zzddm;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final View zzsw() {
        return this.zzddj.get();
    }

    public final boolean zza(String[] strArr) {
        for (String str : strArr) {
            if (this.zzddk.get(str) != null) {
                return true;
            }
        }
        for (String str2 : strArr) {
            if (this.zzddl.get(str2) != null) {
                return false;
            }
        }
        return false;
    }

    public final void zza(zzach zzachVar) {
        View view;
        synchronized (this.mLock) {
            String[] strArr = zzdcy;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    view = null;
                    break;
                }
                WeakReference<View> weakReference = this.zzddm.get(strArr[i]);
                if (weakReference != null) {
                    view = weakReference.get();
                    break;
                }
                i++;
            }
            if (!(view instanceof FrameLayout)) {
                zzachVar.zzsr();
                return;
            }
            A a2 = new A(this, view);
            if (zzachVar instanceof zzacc) {
                zzachVar.zzb(view, a2);
            } else {
                zzachVar.zza(view, a2);
            }
        }
    }
}
