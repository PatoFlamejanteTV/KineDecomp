package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Sd;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: SectionalListAssetEditCellView.java */
/* loaded from: classes.dex */
public class L extends Sd {
    private static final String R = "L";
    private boolean S = false;
    private View T;
    private H U;

    private void A() {
        View view = this.T;
        if (view != null) {
            view.setVisibility(this.S ? 0 : 8);
        }
    }

    public void z() {
        if (this.U.e()) {
            this.S = !this.S;
            A();
            this.U.a(f());
        }
    }

    public void e(boolean z) {
        this.S = z;
        A();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sd, com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void m() {
        super.m();
        LayoutInflater layoutInflater = (LayoutInflater) g().getContext().getSystemService("layout_inflater");
        RelativeLayout relativeLayout = (RelativeLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_assetcell_imagecontainer);
        ((ImageView) g().findViewById(c.a.a.a.b.e.adobe_asset_assetview_assetlist_assetcell_icon)).setVisibility(8);
        this.T = layoutInflater.inflate(c.a.a.a.b.g.adobe_assetcell_selection_fragme, (ViewGroup) relativeLayout, false);
        this.T.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(this.T, 1);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void t() {
        g().setOnClickListener(new K(this));
        super.t();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void u() {
        this.S = false;
        super.u();
    }

    public void a(H h2) {
        this.U = h2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void a(View.OnClickListener onClickListener) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, R, "click listener ignored");
    }
}
