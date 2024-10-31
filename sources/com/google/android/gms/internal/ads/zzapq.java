package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

@zzark
@TargetApi(19)
/* loaded from: classes2.dex */
public final class zzapq extends zzapn {
    private Object zzdst;
    private PopupWindow zzdsu;
    private boolean zzdsv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapq(Context context, zzaxg zzaxgVar, zzbgg zzbggVar, zzapm zzapmVar) {
        super(context, zzaxgVar, zzbggVar, zzapmVar);
        this.zzdst = new Object();
        this.zzdsv = false;
    }

    private final void zzwc() {
        synchronized (this.zzdst) {
            this.zzdsv = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzdsu = null;
            }
            if (this.zzdsu != null) {
                if (this.zzdsu.isShowing()) {
                    this.zzdsu.dismiss();
                }
                this.zzdsu = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapf, com.google.android.gms.internal.ads.zzazb
    public final void cancel() {
        zzwc();
        super.cancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzapf
    public final void zzcq(int i) {
        zzwc();
        super.zzcq(i);
    }

    @Override // com.google.android.gms.internal.ads.zzapn
    protected final void zzwb() {
        Context context = this.mContext;
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) this.mContext).isDestroyed()) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(this.zzdin.getView(), -1, -1);
        synchronized (this.zzdst) {
            if (this.zzdsv) {
                return;
            }
            this.zzdsu = new PopupWindow((View) frameLayout, 1, 1, false);
            this.zzdsu.setOutsideTouchable(true);
            this.zzdsu.setClippingEnabled(false);
            zzbbd.zzdn("Displaying the 1x1 popup off the screen.");
            try {
                this.zzdsu.showAtLocation(window.getDecorView(), 0, -1, -1);
            } catch (Exception unused) {
                this.zzdsu = null;
            }
        }
    }
}
