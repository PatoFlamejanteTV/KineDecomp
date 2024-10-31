package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;

@zzark
/* loaded from: classes2.dex */
public final class zzbas {
    private final View mView;
    private Activity zzeoa;
    private boolean zzeob;
    private boolean zzeoc;
    private boolean zzeod;
    private ViewTreeObserver.OnGlobalLayoutListener zzeoe;
    private ViewTreeObserver.OnScrollChangedListener zzeof;

    public zzbas(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzeoa = activity;
        this.mView = view;
        this.zzeoe = onGlobalLayoutListener;
        this.zzeof = onScrollChangedListener;
    }

    private final void zzaao() {
        ViewTreeObserver zzk;
        ViewTreeObserver zzk2;
        if (this.zzeob) {
            return;
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzeoe;
        if (onGlobalLayoutListener != null) {
            Activity activity = this.zzeoa;
            if (activity != null && (zzk2 = zzk(activity)) != null) {
                zzk2.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            com.google.android.gms.ads.internal.zzbv.D();
            zzbct.zza(this.mView, this.zzeoe);
        }
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.zzeof;
        if (onScrollChangedListener != null) {
            Activity activity2 = this.zzeoa;
            if (activity2 != null && (zzk = zzk(activity2)) != null) {
                zzk.addOnScrollChangedListener(onScrollChangedListener);
            }
            com.google.android.gms.ads.internal.zzbv.D();
            zzbct.zza(this.mView, this.zzeof);
        }
        this.zzeob = true;
    }

    private final void zzaap() {
        ViewTreeObserver zzk;
        ViewTreeObserver zzk2;
        Activity activity = this.zzeoa;
        if (activity != null && this.zzeob) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzeoe;
            if (onGlobalLayoutListener != null && (zzk2 = zzk(activity)) != null) {
                com.google.android.gms.ads.internal.zzbv.g().zza(zzk2, onGlobalLayoutListener);
            }
            ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.zzeof;
            if (onScrollChangedListener != null && (zzk = zzk(this.zzeoa)) != null) {
                zzk.removeOnScrollChangedListener(onScrollChangedListener);
            }
            this.zzeob = false;
        }
    }

    private static ViewTreeObserver zzk(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    public final void onAttachedToWindow() {
        this.zzeoc = true;
        if (this.zzeod) {
            zzaao();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzeoc = false;
        zzaap();
    }

    public final void zzaam() {
        this.zzeod = true;
        if (this.zzeoc) {
            zzaao();
        }
    }

    public final void zzaan() {
        this.zzeod = false;
        zzaap();
    }

    public final void zzj(Activity activity) {
        this.zzeoa = activity;
    }
}
