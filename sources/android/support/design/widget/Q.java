package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewOffsetHelper.java */
/* loaded from: classes.dex */
public class Q {

    /* renamed from: a */
    private final View f433a;

    /* renamed from: b */
    private int f434b;

    /* renamed from: c */
    private int f435c;

    /* renamed from: d */
    private int f436d;

    /* renamed from: e */
    private int f437e;

    public Q(View view) {
        this.f433a = view;
    }

    private void c() {
        View view = this.f433a;
        ViewCompat.offsetTopAndBottom(view, this.f436d - (view.getTop() - this.f434b));
        View view2 = this.f433a;
        ViewCompat.offsetLeftAndRight(view2, this.f437e - (view2.getLeft() - this.f435c));
    }

    public boolean a(int i) {
        if (this.f437e == i) {
            return false;
        }
        this.f437e = i;
        c();
        return true;
    }

    public void b() {
        this.f434b = this.f433a.getTop();
        this.f435c = this.f433a.getLeft();
        c();
    }

    public int a() {
        return this.f436d;
    }

    public boolean b(int i) {
        if (this.f436d == i) {
            return false;
        }
        this.f436d = i;
        c();
        return true;
    }
}
