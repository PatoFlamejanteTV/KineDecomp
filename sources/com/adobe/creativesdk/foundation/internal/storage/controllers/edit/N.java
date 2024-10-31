package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.SectionalListFolderCellView;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: SectionalListFolderEditCellView.java */
/* loaded from: classes.dex */
public class N extends SectionalListFolderCellView {
    private static final String V = "N";
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

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.SectionalListFolderCellView, com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void m() {
        super.m();
        LayoutInflater layoutInflater = (LayoutInflater) g().getContext().getSystemService("layout_inflater");
        RelativeLayout relativeLayout = (RelativeLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_foldercell_imagecontainer);
        ((ImageView) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetlist_forwardicon)).setVisibility(8);
        this.X = layoutInflater.inflate(c.a.a.a.b.g.adobe_assetcell_selection_fragme, (ViewGroup) relativeLayout, false);
        this.X.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(this.X, 1);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void t() {
        g().setOnClickListener(new M(this));
        super.t();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.SectionalListFolderCellView, com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void u() {
        this.W = false;
        super.u();
    }

    public void a(H h2) {
        this.Y = h2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void a(View.OnClickListener onClickListener) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, V, "click listener ignored");
    }
}
