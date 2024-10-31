package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Yc;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: StaggeredGridFolderCellView.java */
/* loaded from: classes.dex */
public class T extends Yc {
    private static final String V = "T";
    private boolean W = false;
    private View X;
    private H Y;

    public void A() {
        if (this.Y.e()) {
            this.W = !this.W;
            B();
            this.Y.a(f());
        }
    }

    private void B() {
        View view = this.X;
        if (view != null) {
            view.setVisibility(this.W ? 0 : 8);
        }
    }

    public void f(boolean z) {
        this.W = z;
        B();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    protected void k() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Yc, com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void m() {
        super.m();
        LayoutInflater layoutInflater = (LayoutInflater) g().getContext().getSystemService("layout_inflater");
        RelativeLayout relativeLayout = (RelativeLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_foldercell_imageContainer);
        ((ImageView) g().findViewById(c.a.a.a.b.e.forwardIcon)).setVisibility(8);
        this.X = layoutInflater.inflate(c.a.a.a.b.g.adobe_assetcell_selection_fragme, (ViewGroup) relativeLayout, false);
        this.X.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(this.X, 1);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void t() {
        g().setOnClickListener(new S(this));
        super.t();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Yc, com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void u() {
        this.W = false;
        super.u();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Yc, com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    protected boolean v() {
        return false;
    }

    public void a(H h2) {
        this.Y = h2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void a(View.OnClickListener onClickListener) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, V, "click listener ignored");
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Yc
    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        RelativeLayout relativeLayout = (RelativeLayout) g();
        View inflate = ((LayoutInflater) g().getContext().getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.adobe_assetcell_disable, (ViewGroup) relativeLayout, false);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (z3) {
            inflate.setVisibility(0);
            relativeLayout.addView(inflate, 1);
        } else {
            g().setEnabled(true);
            if (((RelativeLayout) relativeLayout.findViewById(c.a.a.a.b.e.adobe_assetcell_disable_view)) != null) {
                relativeLayout.removeViewAt(1);
            }
            B();
        }
        super.a(z, z2, z3, false);
    }
}
