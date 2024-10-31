package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Xc;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: StaggeredGridAssetCellView.java */
/* loaded from: classes.dex */
public class Q extends Xc {
    private static final String S = "Q";
    private boolean T = false;
    private View U;
    private H V;

    public void B() {
        if (this.V.e()) {
            this.T = !this.T;
            C();
            this.V.a(f());
        }
    }

    private void C() {
        View view = this.U;
        if (view != null) {
            view.setVisibility(this.T ? 0 : 8);
        }
    }

    public void A() {
        com.adobe.creativesdk.foundation.internal.utils.o.a().postDelayed(new P(this), 100L);
    }

    public void e(boolean z) {
        this.T = z;
        C();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void i() {
        super.i();
        A();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Xc, com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void m() {
        super.m();
        LayoutInflater layoutInflater = (LayoutInflater) g().getContext().getSystemService("layout_inflater");
        this.v = (RelativeLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_imageContainer);
        this.w = (LinearLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_bottom_title_section_vertical);
        this.x = (RelativeLayout) a(c.a.a.a.b.e.adobe_csdk_files_menu_icon);
        this.y = (ImageView) a(c.a.a.a.b.e.adobe_csdk_asset_browser_cell_menu_icon);
        this.u = (LinearLayout) g().findViewById(c.a.a.a.b.e.staggeredCellLinearLayout);
        this.U = layoutInflater.inflate(c.a.a.a.b.g.adobe_assetcell_selection_fragme, (ViewGroup) this.v, false);
        this.U.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.l.getHeight()));
        this.v.addView(this.U, 1);
        this.x.setVisibility(8);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void t() {
        g().setOnClickListener(new O(this));
        super.t();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void u() {
        this.T = false;
        super.u();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Xc, com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    protected boolean v() {
        return false;
    }

    public void a(H h2) {
        this.V = h2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void a(View.OnClickListener onClickListener) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, S, "click listener ignored");
    }
}
