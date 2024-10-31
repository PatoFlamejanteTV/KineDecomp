package com.adobe.creativesdk.foundation.internal.utils;

import android.support.v4.view.ViewCompat;
import android.util.Property;

/* compiled from: DrawShadowRelativeLayout.java */
/* loaded from: classes.dex */
class r extends Property<DrawShadowRelativeLayout, Float> {
    public r(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(DrawShadowRelativeLayout drawShadowRelativeLayout) {
        float f2;
        f2 = drawShadowRelativeLayout.j;
        return Float.valueOf(f2);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(DrawShadowRelativeLayout drawShadowRelativeLayout, Float f2) {
        drawShadowRelativeLayout.j = f2.floatValue();
        ViewCompat.postInvalidateOnAnimation(drawShadowRelativeLayout);
    }
}
