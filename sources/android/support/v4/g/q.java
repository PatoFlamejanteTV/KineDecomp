package android.support.v4.g;

import android.view.View;
import java.lang.reflect.Field;

/* compiled from: ViewCompatBase.java */
/* loaded from: classes.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    private static Field f100a;
    private static boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(View view) {
        if (!b) {
            try {
                f100a = View.class.getDeclaredField("mMinHeight");
                f100a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            b = true;
        }
        if (f100a != null) {
            try {
                return ((Integer) f100a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }
}
