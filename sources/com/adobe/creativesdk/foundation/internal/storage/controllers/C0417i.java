package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.widget.ImageButton;

/* compiled from: AdobeAssetOneUpSinglePageCellView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.i */
/* loaded from: classes.dex */
public class C0417i extends C0402f {
    private ImageButton l;
    private int m;
    private int n;

    public String e(int i) {
        Context context = this.f6084a;
        return (context == null || context.getResources() == null) ? "" : this.f6084a.getResources().getString(i);
    }

    public void c(int i) {
        this.m = i;
    }

    public void d(int i) {
        this.n = i;
    }

    public int g() {
        return this.n;
    }

    public void h() {
        this.l.setVisibility(0);
        this.l.setOnClickListener(new ViewOnClickListenerC0412h(this));
    }

    public void i() {
        this.l = (ImageButton) a(c.a.a.a.b.e.adobe_csdk_asset_video_playBtn);
    }
}
