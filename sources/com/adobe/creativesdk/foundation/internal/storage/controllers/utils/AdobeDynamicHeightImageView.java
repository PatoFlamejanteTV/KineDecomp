package com.adobe.creativesdk.foundation.internal.storage.controllers.utils;

import android.content.Context;
import android.util.AttributeSet;
import com.adobe.creativesdk.foundation.internal.grid.utils.DynamicHeightImageView;

/* loaded from: classes.dex */
public class AdobeDynamicHeightImageView extends DynamicHeightImageView {
    public AdobeDynamicHeightImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.utils.DynamicHeightImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < getSuggestedMinimumHeight() || getMeasuredWidth() < getSuggestedMinimumWidth()) {
            setMeasuredDimension(Math.max(getMeasuredWidth(), getSuggestedMinimumWidth()), Math.max(getMeasuredHeight(), getSuggestedMinimumHeight()));
        }
    }

    public AdobeDynamicHeightImageView(Context context) {
        super(context);
    }
}
