package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class NestedScrollingParentHelper {

    /* renamed from: a */
    private final ViewGroup f1809a;

    /* renamed from: b */
    private int f1810b;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
        this.f1809a = viewGroup;
    }

    public int getNestedScrollAxes() {
        return this.f1810b;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.f1810b = i;
    }

    public void onStopNestedScroll(View view, int i) {
        this.f1810b = 0;
    }
}
