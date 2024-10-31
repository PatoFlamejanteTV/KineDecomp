package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class SectionalListFolderCellView extends Sa {
    private boolean R = false;
    private boolean S = false;
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
        View a2 = a(c.a.a.a.b.e.adobe_csdk_assetview_list_menulayout);
        if (a2 != null) {
            a2.setOnClickListener(onClickListener);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public View e() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void m() {
        this.f5821h = (TextView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_foldercell_title);
        this.k = (TextView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_foldercell_count);
        this.l = (ImageView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_foldercell_image);
        this.m = (ImageView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_shared_folder_image);
        Boolean valueOf = Boolean.valueOf(C0455p.b(b()));
        this.z = (ImageView) a(c.a.a.a.b.e.adobe_csdk_assetlist_forwardicon);
        this.A = (RelativeLayout) a(c.a.a.a.b.e.adobe_csdk_assetview_list_menulayout);
        if (!valueOf.booleanValue()) {
            this.z.setImageResource(c.a.a.a.b.d.folder_forward_icon);
        }
        this.C = (RelativeLayout) a(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_foldercell_imagecontainer);
        this.t = (LinearLayout) a(c.a.a.a.b.e.adobe_csdk_assetlist_listLayout);
        this.G = a(c.a.a.a.b.e.adobe_csdk_list_folder_divider);
        this.T = (int) g().getResources().getDimension(c.a.a.a.b.c.adobe_csdk_assetbrowser_list_view_folder_cell_empty_folder_layout_height);
        this.U = (int) g().getResources().getDimension(c.a.a.a.b.c.adobe_csdk_assetbrowser_list_view_folder_cell_empty_folder_layout_width);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void q() {
        this.A.setVisibility(8);
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

    public void a(boolean z, boolean z2, boolean z3) {
        e(z);
        a(z2, z3);
    }
}
