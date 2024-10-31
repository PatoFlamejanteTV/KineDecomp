package com.adobe.creativesdk.foundation.internal.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public class CreativeSDKTextView extends TextView {
    public CreativeSDKTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        super.setTypeface(c.a(getContext()));
    }

    public CreativeSDKTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CreativeSDKTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public CreativeSDKTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
