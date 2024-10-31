package com.adobe.creativesdk.foundation.internal.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

/* loaded from: classes.dex */
public class CreativeSDKEditText extends EditText {
    public CreativeSDKEditText(Context context) {
        super(context);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        super.setEllipsize(truncateAt);
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        super.setTypeface(c.a(getContext()));
    }

    public CreativeSDKEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CreativeSDKEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
