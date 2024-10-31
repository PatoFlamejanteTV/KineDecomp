package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* compiled from: SectionalListAssetCellView.java */
/* loaded from: classes.dex */
public class Sd extends Sa {
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void b(View.OnClickListener onClickListener) {
        View a2 = a(c.a.a.a.b.e.adobe_csdk_list_menulayout);
        if (a2 != null) {
            a2.setOnClickListener(onClickListener);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public View e() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void m() {
        this.f5821h = (TextView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_assetcell_title);
        this.l = (ImageView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_assetcell_imageView);
        this.H = (ImageButton) a(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_assetcell_selectbtn);
        Boolean valueOf = Boolean.valueOf(C0455p.b(b()));
        this.E = (ImageView) a(c.a.a.a.b.e.adobe_asset_assetview_assetlist_assetcell_icon);
        this.F = (RelativeLayout) a(c.a.a.a.b.e.adobe_csdk_list_menulayout);
        if (!valueOf.booleanValue()) {
            this.E.setVisibility(4);
        }
        this.w = (LinearLayout) a(c.a.a.a.b.e.adobe_asset_assetview_assetlist_assetcell_layout);
        this.v = (RelativeLayout) a(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_assetcell_imagecontainer);
        this.G = a(c.a.a.a.b.e.adobe_csdk_list_divider);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void q() {
        this.F.setVisibility(8);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    protected boolean v() {
        return true;
    }
}
