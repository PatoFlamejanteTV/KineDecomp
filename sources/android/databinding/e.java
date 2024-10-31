package android.databinding;

import android.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: DataBindingUtil.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    private static c f157a = new DataBinderMapperImpl();

    /* renamed from: b */
    private static d f158b = null;

    public static d a() {
        return f158b;
    }

    public static <T extends ViewDataBinding> T a(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z) {
        return (T) a(layoutInflater, i, viewGroup, z, f158b);
    }

    public static <T extends ViewDataBinding> T a(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z, d dVar) {
        boolean z2 = viewGroup != null && z;
        int childCount = z2 ? viewGroup.getChildCount() : 0;
        View inflate = layoutInflater.inflate(i, viewGroup, z);
        if (z2) {
            return (T) a(dVar, viewGroup, childCount, i);
        }
        return (T) a(dVar, inflate, i);
    }

    public static <T extends ViewDataBinding> T a(d dVar, View[] viewArr, int i) {
        return (T) f157a.a(dVar, viewArr, i);
    }

    public static <T extends ViewDataBinding> T a(d dVar, View view, int i) {
        return (T) f157a.a(dVar, view, i);
    }

    public static <T extends ViewDataBinding> T a(Activity activity, int i) {
        return (T) a(activity, i, f158b);
    }

    public static <T extends ViewDataBinding> T a(Activity activity, int i, d dVar) {
        activity.setContentView(i);
        return (T) a(dVar, (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content), 0, i);
    }

    private static <T extends ViewDataBinding> T a(d dVar, ViewGroup viewGroup, int i, int i2) {
        int childCount = viewGroup.getChildCount();
        int i3 = childCount - i;
        if (i3 == 1) {
            return (T) a(dVar, viewGroup.getChildAt(childCount - 1), i2);
        }
        View[] viewArr = new View[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            viewArr[i4] = viewGroup.getChildAt(i4 + i);
        }
        return (T) a(dVar, viewArr, i2);
    }
}
