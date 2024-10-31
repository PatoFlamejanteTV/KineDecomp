package android.support.transition;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a */
    private static final ea f569a;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            f569a = new da();
        } else {
            f569a = new ca();
        }
    }

    public static Z a(ViewGroup viewGroup) {
        return f569a.a(viewGroup);
    }

    public static void a(ViewGroup viewGroup, boolean z) {
        f569a.a(viewGroup, z);
    }
}
