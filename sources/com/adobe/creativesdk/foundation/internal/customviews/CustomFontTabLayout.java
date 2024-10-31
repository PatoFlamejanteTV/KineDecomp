package com.adobe.creativesdk.foundation.internal.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.F;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* loaded from: classes.dex */
public class CustomFontTabLayout extends F {
    private Typeface F;

    public CustomFontTabLayout(Context context) {
        super(context);
        h();
    }

    private void h() {
        this.F = Typeface.createFromAsset(getContext().getAssets(), "fonts/AdobeClean-SemiLight.otf");
    }

    @Override // android.support.design.widget.F
    public void a(F.e eVar, boolean z) {
        super.a(eVar, z);
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) getChildAt(0)).getChildAt(eVar.d());
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTypeface(this.F, 0);
                textView.setSingleLine(true);
                textView.setAllCaps(true);
            }
        }
    }

    public CustomFontTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    public CustomFontTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        h();
    }

    public void a(String str) {
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        F.e a2 = a();
        a2.b(str);
        a(a2);
        AppCompatTextView appCompatTextView = (AppCompatTextView) ((ViewGroup) viewGroup.getChildAt(getTabCount() - 1)).getChildAt(1);
        appCompatTextView.setTypeface(this.F, 0);
        appCompatTextView.setSingleLine(true);
        appCompatTextView.setAllCaps(true);
    }
}
