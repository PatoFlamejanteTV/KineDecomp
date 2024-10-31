package c.d.b.m;

import android.content.Context;

/* compiled from: GridLayoutUtil.java */
/* loaded from: classes2.dex */
public class f {
    public static int a(Context context) {
        if (context == null) {
            return -1;
        }
        int i = context.getResources().getConfiguration().screenLayout & 15;
        if (i == 1) {
            return 3;
        }
        if (i != 2) {
            return i != 3 ? 6 : 5;
        }
        return 4;
    }
}
