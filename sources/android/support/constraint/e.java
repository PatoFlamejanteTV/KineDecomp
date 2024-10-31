package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* compiled from: Constraints.java */
/* loaded from: classes.dex */
public class e extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    d f198a;

    public d getConstraintSet() {
        if (this.f198a == null) {
            this.f198a = new d();
        }
        this.f198a.a(this);
        return this.f198a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    /* compiled from: Constraints.java */
    /* loaded from: classes.dex */
    public static class a extends ConstraintLayout.a {
        public float na;
        public boolean oa;
        public float pa;
        public float qa;
        public float ra;
        public float sa;
        public float ta;
        public float ua;
        public float va;
        public float wa;
        public float xa;
        public float ya;
        public float za;

        public a(int i, int i2) {
            super(i, i2);
            this.na = 1.0f;
            this.oa = false;
            this.pa = 0.0f;
            this.qa = 0.0f;
            this.ra = 0.0f;
            this.sa = 0.0f;
            this.ta = 1.0f;
            this.ua = 1.0f;
            this.va = 0.0f;
            this.wa = 0.0f;
            this.xa = 0.0f;
            this.ya = 0.0f;
            this.za = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.na = 1.0f;
            this.oa = false;
            this.pa = 0.0f;
            this.qa = 0.0f;
            this.ra = 0.0f;
            this.sa = 0.0f;
            this.ta = 1.0f;
            this.ua = 1.0f;
            this.va = 0.0f;
            this.wa = 0.0f;
            this.xa = 0.0f;
            this.ya = 0.0f;
            this.za = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == h.ConstraintSet_android_alpha) {
                    this.na = obtainStyledAttributes.getFloat(index, this.na);
                } else if (index == h.ConstraintSet_android_elevation) {
                    this.pa = obtainStyledAttributes.getFloat(index, this.pa);
                    this.oa = true;
                } else if (index == h.ConstraintSet_android_rotationX) {
                    this.ra = obtainStyledAttributes.getFloat(index, this.ra);
                } else if (index == h.ConstraintSet_android_rotationY) {
                    this.sa = obtainStyledAttributes.getFloat(index, this.sa);
                } else if (index == h.ConstraintSet_android_rotation) {
                    this.qa = obtainStyledAttributes.getFloat(index, this.qa);
                } else if (index == h.ConstraintSet_android_scaleX) {
                    this.ta = obtainStyledAttributes.getFloat(index, this.ta);
                } else if (index == h.ConstraintSet_android_scaleY) {
                    this.ua = obtainStyledAttributes.getFloat(index, this.ua);
                } else if (index == h.ConstraintSet_android_transformPivotX) {
                    this.va = obtainStyledAttributes.getFloat(index, this.va);
                } else if (index == h.ConstraintSet_android_transformPivotY) {
                    this.wa = obtainStyledAttributes.getFloat(index, this.wa);
                } else if (index == h.ConstraintSet_android_translationX) {
                    this.xa = obtainStyledAttributes.getFloat(index, this.xa);
                } else if (index == h.ConstraintSet_android_translationY) {
                    this.ya = obtainStyledAttributes.getFloat(index, this.ya);
                } else if (index == h.ConstraintSet_android_translationZ) {
                    this.xa = obtainStyledAttributes.getFloat(index, this.za);
                }
            }
        }
    }
}
