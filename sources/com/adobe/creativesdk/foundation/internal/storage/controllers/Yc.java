package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* compiled from: GridFolderCellView.java */
/* loaded from: classes.dex */
public class Yc extends Sa {
    boolean R = false;
    boolean S = false;
    private int T = 0;
    private int U = 0;

    private void z() {
        if (!this.R && !this.S) {
            this.m.setImageResource(c.a.a.a.b.d.ic_vector_asset_folder);
            return;
        }
        this.m.setVisibility(0);
        if (this.S) {
            this.m.setImageResource(c.a.a.a.b.d.ic_vector_asset_folder_ro);
        } else {
            this.m.setImageResource(c.a.a.a.b.d.ic_vector_asset_folder_shared);
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.l == null) {
            return;
        }
        this.R = z;
        this.S = z2;
        z();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void b(View.OnClickListener onClickListener) {
        this.D.setOnClickListener(onClickListener);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public View e() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void m() {
        this.f5821h = (TextView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_foldercell_title);
        this.k = (TextView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_foldercell_count);
        this.l = (ImageView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_foldercell_image);
        this.m = (ImageView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_shared_folder_image);
        this.C = (RelativeLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_foldercell_imageContainer);
        this.t = (LinearLayout) g().findViewById(c.a.a.a.b.e.gridViewLinearLayout);
        Boolean valueOf = Boolean.valueOf(C0455p.b(b()));
        this.z = (ImageView) a(c.a.a.a.b.e.forwardIcon);
        this.D = (RelativeLayout) a(c.a.a.a.b.e.adobe_csdk_folder_menu_icon);
        if (!valueOf.booleanValue()) {
            this.z.setImageResource(c.a.a.a.b.d.folder_forward_icon);
        } else {
            this.k.setTypeface(Sa.f5814a);
            this.f5821h.setTypeface(Sa.f5814a);
        }
        this.T = (int) g().getResources().getDimension(c.a.a.a.b.c.adobe_csdk_assetbrowser_grid_folderViewCell_empty_folder_layout_height);
        this.U = (int) g().getResources().getDimension(c.a.a.a.b.c.adobe_csdk_assetbrowser_grid_folderViewCell_empty_folder_layout_width);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void q() {
        this.D.setVisibility(8);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void u() {
        super.u();
        this.l.setVisibility(0);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    protected boolean v() {
        return false;
    }

    public void e(boolean z) {
        this.l.requestLayout();
        if (z) {
            this.l.setVisibility(0);
            this.l.getLayoutParams().height = this.T;
            this.l.getLayoutParams().width = this.U;
            this.l.setImageResource(c.a.a.a.b.d.empty_folder);
            return;
        }
        this.l.setVisibility(4);
        this.l.getLayoutParams().height = -1;
        this.l.getLayoutParams().width = -1;
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        RelativeLayout relativeLayout = (RelativeLayout) g();
        View inflate = ((LayoutInflater) g().getContext().getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.adobe_assetcell_disable, (ViewGroup) relativeLayout, false);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (z3 && z4) {
            inflate.setVisibility(0);
            relativeLayout.addView(inflate, 1);
            ((RelativeLayout) inflate).requestDisallowInterceptTouchEvent(true);
        } else {
            g().setEnabled(true);
            if (((RelativeLayout) relativeLayout.findViewById(c.a.a.a.b.e.adobe_assetcell_disable_view)) != null) {
                relativeLayout.removeViewAt(1);
            }
        }
        e(z);
        a(z2, z3);
    }
}
