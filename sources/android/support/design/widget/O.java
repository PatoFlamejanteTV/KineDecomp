package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;

/* compiled from: ThemeUtils.java */
/* loaded from: classes.dex */
class O {

    /* renamed from: a */
    private static final int[] f429a = {R.attr.colorPrimary};

    public static void a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f429a);
        boolean z = !obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
