package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.os.Build;
import android.widget.RelativeLayout;

/* compiled from: AdobeUploadAssetCellViews.java */
/* loaded from: classes.dex */
public class g extends z {
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z
    protected RelativeLayout B() {
        return (RelativeLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_imageContainer);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z
    public void a(RelativeLayout.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT > 17) {
            super.a(layoutParams);
        } else {
            layoutParams.addRule(8, c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_selectbtn);
        }
    }
}
