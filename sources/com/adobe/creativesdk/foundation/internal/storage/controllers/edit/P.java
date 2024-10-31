package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: StaggeredGridAssetCellView.java */
/* loaded from: classes.dex */
public class P implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Q f6032a;

    public P(Q q) {
        this.f6032a = q;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View findViewById = this.f6032a.g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_imageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(findViewById.getMeasuredWidth(), findViewById.getMeasuredHeight());
        view = this.f6032a.U;
        view.setLayoutParams(layoutParams);
    }
}
