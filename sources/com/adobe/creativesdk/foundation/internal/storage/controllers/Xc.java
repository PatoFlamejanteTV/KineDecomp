package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.grid.utils.DynamicHeightImageView;

/* compiled from: GenericStaggeredCellView.java */
/* loaded from: classes.dex */
public class Xc extends Td {
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void b(View.OnClickListener onClickListener) {
        View a2 = a(c.a.a.a.b.e.adobe_csdk_files_menu_icon);
        if (a2 != null) {
            a2.setOnClickListener(onClickListener);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public View e() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void m() {
        this.f5821h = (TextView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_title);
        this.l = (ImageView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_imageView);
        this.r = (LinearLayout) a(c.a.a.a.b.e.adobe_csdk_assetvire_bottom_video_layout);
        this.s = (LinearLayout) a(c.a.a.a.b.e.adobe_csdk_assetview_bottom_info_layout);
        this.q = (TextView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_video_duration);
        this.p = (ImageView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_video_indicator);
        ((DynamicHeightImageView) this.l).setHeightRatio(this.I);
        this.H = (ImageButton) a(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_selectbtn);
        this.u = (LinearLayout) g().findViewById(c.a.a.a.b.e.staggeredCellLinearLayout);
        this.v = (RelativeLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_imageContainer);
        this.w = (LinearLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_bottom_title_section_vertical);
        this.x = (RelativeLayout) a(c.a.a.a.b.e.adobe_csdk_files_menu_icon);
        this.y = (ImageView) a(c.a.a.a.b.e.adobe_csdk_asset_browser_cell_menu_icon);
        this.B = (TextView) a(c.a.a.a.b.e.adobe_csdk_assetview_file_extension);
        this.i = (TextView) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_file_size);
        this.n = (TextView) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_photo_count);
        this.o = (ImageView) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_file_icon);
        this.j = (TextView) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_file_modified_date);
        if (!Boolean.valueOf(C0455p.b(b())).booleanValue()) {
            this.x.setVisibility(8);
        } else {
            this.f5821h.setTypeface(Sa.f5814a);
            this.j.setTypeface(Sa.f5814a);
            this.i.setTypeface(Sa.f5814a);
        }
        this.f5821h.setVisibility(z() ? 0 : 8);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void q() {
        RelativeLayout relativeLayout = this.x;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    protected boolean v() {
        return true;
    }

    protected boolean z() {
        return true;
    }
}
