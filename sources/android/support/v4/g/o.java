package android.support.v4.g;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f97a;
    private int b;

    public o(ViewGroup viewGroup) {
        this.f97a = viewGroup;
    }

    public void a(View view, View view2, int i) {
        this.b = i;
    }

    public int a() {
        return this.b;
    }
}
