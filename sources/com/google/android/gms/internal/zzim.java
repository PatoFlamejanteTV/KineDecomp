package com.google.android.gms.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class zzim {
    private Activity zzJn;
    private boolean zzJo;
    private boolean zzJp;
    private boolean zzJq;
    private ViewTreeObserver.OnGlobalLayoutListener zzJr;
    private ViewTreeObserver.OnScrollChangedListener zzJs;

    public zzim(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzJn = activity;
        this.zzJr = onGlobalLayoutListener;
        this.zzJs = onScrollChangedListener;
    }

    private void zzgQ() {
        if (this.zzJn == null || this.zzJo) {
            return;
        }
        if (this.zzJr != null) {
            com.google.android.gms.ads.internal.zzp.e().zza(this.zzJn, this.zzJr);
        }
        if (this.zzJs != null) {
            com.google.android.gms.ads.internal.zzp.e().zza(this.zzJn, this.zzJs);
        }
        this.zzJo = true;
    }

    private void zzgR() {
        if (this.zzJn != null && this.zzJo) {
            if (this.zzJr != null) {
                com.google.android.gms.ads.internal.zzp.g().zzb(this.zzJn, this.zzJr);
            }
            if (this.zzJs != null) {
                com.google.android.gms.ads.internal.zzp.e().zzb(this.zzJn, this.zzJs);
            }
            this.zzJo = false;
        }
    }

    public void onAttachedToWindow() {
        this.zzJp = true;
        if (this.zzJq) {
            zzgQ();
        }
    }

    public void onDetachedFromWindow() {
        this.zzJp = false;
        zzgR();
    }

    public void zzgO() {
        this.zzJq = true;
        if (this.zzJp) {
            zzgQ();
        }
    }

    public void zzgP() {
        this.zzJq = false;
        zzgR();
    }

    public void zzk(Activity activity) {
        this.zzJn = activity;
    }
}
