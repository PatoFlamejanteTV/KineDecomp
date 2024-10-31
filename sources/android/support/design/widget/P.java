package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: ViewOffsetBehavior.java */
/* loaded from: classes.dex */
class P<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a, reason: collision with root package name */
    private Q f430a;

    /* renamed from: b, reason: collision with root package name */
    private int f431b;

    /* renamed from: c, reason: collision with root package name */
    private int f432c;

    public P() {
        this.f431b = 0;
        this.f432c = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        b(coordinatorLayout, (CoordinatorLayout) v, i);
        if (this.f430a == null) {
            this.f430a = new Q(v);
        }
        this.f430a.b();
        int i2 = this.f431b;
        if (i2 != 0) {
            this.f430a.b(i2);
            this.f431b = 0;
        }
        int i3 = this.f432c;
        if (i3 == 0) {
            return true;
        }
        this.f430a.a(i3);
        this.f432c = 0;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.b(v, i);
    }

    public int b() {
        Q q = this.f430a;
        if (q != null) {
            return q.a();
        }
        return 0;
    }

    public P(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f431b = 0;
        this.f432c = 0;
    }

    public boolean a(int i) {
        Q q = this.f430a;
        if (q != null) {
            return q.b(i);
        }
        this.f431b = i;
        return false;
    }
}
