package com.adobe.creativesdk.foundation.internal.storage.controllers.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class AdobeDesignItemDynamicHeightView extends RelativeLayout {

    /* renamed from: a */
    private double f6486a;

    public AdobeDesignItemDynamicHeightView(Context context) {
        super(context);
        this.f6486a = 1.0d;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    public void setHeightRatio(double d2) {
        this.f6486a = d2;
    }

    public AdobeDesignItemDynamicHeightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6486a = 1.0d;
    }

    public AdobeDesignItemDynamicHeightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6486a = 1.0d;
    }
}
