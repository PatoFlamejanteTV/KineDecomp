package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: ScrollerCompatGingerbread.java */
/* loaded from: classes.dex */
class i {
    public static Object a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public static int a(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
