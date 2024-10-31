package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.b.a;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: AppCompatTextView.java */
/* loaded from: classes.dex */
public class d extends TextView {
    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i.AppCompatTextView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(a.i.AppCompatTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, a.i.TextAppearance);
            if (obtainStyledAttributes2.hasValue(a.i.TextAppearance_textAllCaps)) {
                setAllCaps(obtainStyledAttributes2.getBoolean(a.i.TextAppearance_textAllCaps, false));
            }
            obtainStyledAttributes2.recycle();
        }
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, a.i.AppCompatTextView, i, 0);
        if (obtainStyledAttributes3.hasValue(a.i.AppCompatTextView_textAllCaps)) {
            setAllCaps(obtainStyledAttributes3.getBoolean(a.i.AppCompatTextView_textAllCaps, false));
        }
        obtainStyledAttributes3.recycle();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        setTransformationMethod(z ? new android.support.v7.internal.a.a(getContext()) : null);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, a.i.TextAppearance);
        if (obtainStyledAttributes.hasValue(a.i.TextAppearance_textAllCaps)) {
            setAllCaps(obtainStyledAttributes.getBoolean(a.i.TextAppearance_textAllCaps, false));
        }
        obtainStyledAttributes.recycle();
    }
}
