package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzhs;

@zzgr
/* loaded from: classes.dex */
public class zzgj extends zzgi {
    private Object zzDw;
    private PopupWindow zzDx;
    private boolean zzDy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgj(Context context, zzhs.zza zzaVar, zziz zzizVar, zzgg.zza zzaVar2) {
        super(context, zzaVar, zzizVar, zzaVar2);
        this.zzDw = new Object();
        this.zzDy = false;
    }

    private void zzfA() {
        synchronized (this.zzDw) {
            this.zzDy = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzDx = null;
            }
            if (this.zzDx != null) {
                if (this.zzDx.isShowing()) {
                    this.zzDx.dismiss();
                }
                this.zzDx = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgc, com.google.android.gms.internal.zzgh
    public void cancel() {
        zzfA();
        super.cancel();
    }

    @Override // com.google.android.gms.internal.zzgi
    protected void zzfz() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) this.mContext).isDestroyed()) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(this.zzoM.getView(), -1, -1);
        synchronized (this.zzDw) {
            if (this.zzDy) {
                return;
            }
            this.zzDx = new PopupWindow((View) frameLayout, 1, 1, false);
            this.zzDx.setOutsideTouchable(true);
            this.zzDx.setClippingEnabled(false);
            com.google.android.gms.ads.internal.util.client.zzb.a("Displaying the 1x1 popup off the screen.");
            try {
                this.zzDx.showAtLocation(window.getDecorView(), 0, -1, -1);
            } catch (Exception e) {
                this.zzDx = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzgc
    public void zzz(int i) {
        zzfA();
        super.zzz(i);
    }
}
