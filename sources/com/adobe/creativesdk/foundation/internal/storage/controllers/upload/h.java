package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.grid.utils.DynamicHeightImageView;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0455p;

/* compiled from: AdobeUploadAssetCellViews.java */
/* loaded from: classes.dex */
public class h extends z {
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z
    protected RelativeLayout B() {
        return (RelativeLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_assetcell_root);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z, com.adobe.creativesdk.foundation.internal.storage.controllers.Xc, com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void m() {
        this.f5821h = (TextView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_assetcell_title);
        this.l = (ImageView) a(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_assetcell_imageView);
        this.H = (ImageButton) a(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_assetcell_selectbtn);
        LinearLayout linearLayout = (LinearLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetlist_assetcell_container);
        linearLayout.removeView(this.l);
        DynamicHeightImageView dynamicHeightImageView = new DynamicHeightImageView(g().getContext());
        dynamicHeightImageView.setScaleType(ImageView.ScaleType.CENTER);
        int a2 = C0455p.a(44);
        dynamicHeightImageView.setLayoutParams(new LinearLayout.LayoutParams(a2, a2));
        linearLayout.addView(dynamicHeightImageView, 1);
        this.l = dynamicHeightImageView;
        c(1.0f);
        A();
    }
}
