package android.support.v7.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ActionBar.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: ActionBar.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract Drawable a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract void d();

        public abstract CharSequence e();
    }

    /* compiled from: ActionBar.java */
    /* renamed from: android.support.v7.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f116a;

        public C0015a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f116a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i.ActionBarLayout);
            this.f116a = obtainStyledAttributes.getInt(a.i.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0015a(int i, int i2) {
            super(i, i2);
            this.f116a = 0;
            this.f116a = 8388627;
        }

        public C0015a(C0015a c0015a) {
            super((ViewGroup.MarginLayoutParams) c0015a);
            this.f116a = 0;
            this.f116a = c0015a.f116a;
        }

        public C0015a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f116a = 0;
        }
    }
}
