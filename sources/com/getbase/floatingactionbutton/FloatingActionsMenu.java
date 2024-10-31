package com.getbase.floatingactionbutton;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

/* loaded from: classes.dex */
public class FloatingActionsMenu extends ViewGroup {

    /* renamed from: a */
    private static Interpolator f9833a = new OvershootInterpolator();

    /* renamed from: b */
    private static Interpolator f9834b = new DecelerateInterpolator(3.0f);

    /* renamed from: c */
    private static Interpolator f9835c = new DecelerateInterpolator();

    /* renamed from: d */
    private int f9836d;

    /* renamed from: e */
    private int f9837e;

    /* renamed from: f */
    private int f9838f;

    /* renamed from: g */
    private int f9839g;

    /* renamed from: h */
    private boolean f9840h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private AnimatorSet n;
    private AnimatorSet o;
    private com.getbase.floatingactionbutton.b p;
    private c q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private k w;
    private b x;

    /* loaded from: classes.dex */
    private class a extends ViewGroup.LayoutParams {

        /* renamed from: a */
        private ObjectAnimator f9841a;

        /* renamed from: b */
        private ObjectAnimator f9842b;

        /* renamed from: c */
        private ObjectAnimator f9843c;

        /* renamed from: d */
        private ObjectAnimator f9844d;

        /* renamed from: e */
        private boolean f9845e;

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9841a = new ObjectAnimator();
            this.f9842b = new ObjectAnimator();
            this.f9843c = new ObjectAnimator();
            this.f9844d = new ObjectAnimator();
            this.f9841a.setInterpolator(FloatingActionsMenu.f9833a);
            this.f9842b.setInterpolator(FloatingActionsMenu.f9835c);
            this.f9843c.setInterpolator(FloatingActionsMenu.f9834b);
            this.f9844d.setInterpolator(FloatingActionsMenu.f9834b);
            this.f9844d.setProperty(View.ALPHA);
            this.f9844d.setFloatValues(1.0f, 0.0f);
            this.f9842b.setProperty(View.ALPHA);
            this.f9842b.setFloatValues(0.0f, 1.0f);
            int i = FloatingActionsMenu.this.i;
            if (i == 0 || i == 1) {
                this.f9843c.setProperty(View.TRANSLATION_Y);
                this.f9841a.setProperty(View.TRANSLATION_Y);
            } else if (i == 2 || i == 3) {
                this.f9843c.setProperty(View.TRANSLATION_X);
                this.f9841a.setProperty(View.TRANSLATION_X);
            }
        }

        public void a(View view) {
            this.f9844d.setTarget(view);
            this.f9843c.setTarget(view);
            this.f9842b.setTarget(view);
            this.f9841a.setTarget(view);
            if (this.f9845e) {
                return;
            }
            FloatingActionsMenu.this.o.play(this.f9844d);
            FloatingActionsMenu.this.o.play(this.f9843c);
            FloatingActionsMenu.this.n.play(this.f9842b);
            FloatingActionsMenu.this.n.play(this.f9841a);
            this.f9845e = true;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public static class c extends LayerDrawable {

        /* renamed from: a */
        private float f9847a;

        public c(Drawable drawable) {
            super(new Drawable[]{drawable});
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.save();
            canvas.rotate(this.f9847a, getBounds().centerX(), getBounds().centerY());
            super.draw(canvas);
            canvas.restore();
        }

        public float getRotation() {
            return this.f9847a;
        }

        public void setRotation(float f2) {
            this.f9847a = f2;
            invalidateSelf();
        }
    }

    /* loaded from: classes.dex */
    public static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new f();

        /* renamed from: a */
        public boolean f9848a;

        public /* synthetic */ d(Parcel parcel, com.getbase.floatingactionbutton.d dVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f9848a ? 1 : 0);
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        private d(Parcel parcel) {
            super(parcel);
            this.f9848a = parcel.readInt() == 1;
        }
    }

    public FloatingActionsMenu(Context context) {
        this(context, null);
    }

    private void h() {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.t);
        for (int i = 0; i < this.v; i++) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i);
            String title = floatingActionButton.getTitle();
            if (floatingActionButton != this.p && title != null && floatingActionButton.getTag(i.fab_label) == null) {
                TextView textView = new TextView(contextThemeWrapper);
                textView.setTextAppearance(getContext(), this.t);
                textView.setText(floatingActionButton.getTitle());
                addView(textView);
                floatingActionButton.setTag(i.fab_label, textView);
            }
        }
    }

    private boolean i() {
        int i = this.i;
        return i == 2 || i == 3;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(super.generateDefaultLayoutParams());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(super.generateLayoutParams(attributeSet));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.p);
        this.v = getChildCount();
        if (this.t != 0) {
            h();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight;
        int i5;
        int measuredWidth;
        int measuredWidth2;
        int i6 = this.i;
        int i7 = 8;
        float f2 = 0.0f;
        char c2 = 0;
        char c3 = 1;
        if (i6 != 0 && i6 != 1) {
            if (i6 == 2 || i6 == 3) {
                boolean z2 = this.i == 2;
                int measuredWidth3 = z2 ? (i3 - i) - this.p.getMeasuredWidth() : 0;
                int i8 = this.s;
                int measuredHeight2 = ((i4 - i2) - i8) + ((i8 - this.p.getMeasuredHeight()) / 2);
                com.getbase.floatingactionbutton.b bVar = this.p;
                bVar.layout(measuredWidth3, measuredHeight2, bVar.getMeasuredWidth() + measuredWidth3, this.p.getMeasuredHeight() + measuredHeight2);
                if (z2) {
                    measuredWidth2 = measuredWidth3 - this.j;
                } else {
                    measuredWidth2 = this.p.getMeasuredWidth() + measuredWidth3 + this.j;
                }
                for (int i9 = this.v - 1; i9 >= 0; i9--) {
                    View childAt = getChildAt(i9);
                    if (childAt != this.p && childAt.getVisibility() != 8) {
                        if (z2) {
                            measuredWidth2 -= childAt.getMeasuredWidth();
                        }
                        int measuredHeight3 = ((this.p.getMeasuredHeight() - childAt.getMeasuredHeight()) / 2) + measuredHeight2;
                        childAt.layout(measuredWidth2, measuredHeight3, childAt.getMeasuredWidth() + measuredWidth2, childAt.getMeasuredHeight() + measuredHeight3);
                        float f3 = measuredWidth3 - measuredWidth2;
                        childAt.setTranslationX(this.m ? 0.0f : f3);
                        childAt.setAlpha(this.m ? 1.0f : 0.0f);
                        a aVar = (a) childAt.getLayoutParams();
                        aVar.f9843c.setFloatValues(0.0f, f3);
                        aVar.f9841a.setFloatValues(f3, 0.0f);
                        aVar.a(childAt);
                        if (z2) {
                            measuredWidth2 -= this.j;
                        } else {
                            measuredWidth2 = measuredWidth2 + childAt.getMeasuredWidth() + this.j;
                        }
                    }
                }
                return;
            }
            return;
        }
        boolean z3 = this.i == 0;
        if (z) {
            this.w.a();
        }
        int measuredHeight4 = z3 ? (i4 - i2) - this.p.getMeasuredHeight() : 0;
        int i10 = this.u == 0 ? (i3 - i) - (this.r / 2) : this.r / 2;
        int measuredWidth4 = i10 - (this.p.getMeasuredWidth() / 2);
        com.getbase.floatingactionbutton.b bVar2 = this.p;
        bVar2.layout(measuredWidth4, measuredHeight4, bVar2.getMeasuredWidth() + measuredWidth4, this.p.getMeasuredHeight() + measuredHeight4);
        int i11 = (this.r / 2) + this.k;
        int i12 = this.u == 0 ? i10 - i11 : i11 + i10;
        if (z3) {
            measuredHeight = measuredHeight4 - this.j;
        } else {
            measuredHeight = this.p.getMeasuredHeight() + measuredHeight4 + this.j;
        }
        int i13 = this.v - 1;
        while (i13 >= 0) {
            View childAt2 = getChildAt(i13);
            if (childAt2 == this.p || childAt2.getVisibility() == i7) {
                i5 = measuredHeight4;
            } else {
                int measuredWidth5 = i10 - (childAt2.getMeasuredWidth() / 2);
                if (z3) {
                    measuredHeight -= childAt2.getMeasuredHeight();
                }
                childAt2.layout(measuredWidth5, measuredHeight, childAt2.getMeasuredWidth() + measuredWidth5, childAt2.getMeasuredHeight() + measuredHeight);
                float f4 = measuredHeight4 - measuredHeight;
                childAt2.setTranslationY(this.m ? 0.0f : f4);
                childAt2.setAlpha(this.m ? 1.0f : 0.0f);
                a aVar2 = (a) childAt2.getLayoutParams();
                ObjectAnimator objectAnimator = aVar2.f9843c;
                i5 = measuredHeight4;
                float[] fArr = new float[2];
                fArr[c2] = f2;
                fArr[c3] = f4;
                objectAnimator.setFloatValues(fArr);
                ObjectAnimator objectAnimator2 = aVar2.f9841a;
                float[] fArr2 = new float[2];
                fArr2[c2] = f4;
                fArr2[c3] = f2;
                objectAnimator2.setFloatValues(fArr2);
                aVar2.a(childAt2);
                View view = (View) childAt2.getTag(i.fab_label);
                if (view != null) {
                    if (this.u == 0) {
                        measuredWidth = i12 - view.getMeasuredWidth();
                    } else {
                        measuredWidth = view.getMeasuredWidth() + i12;
                    }
                    int i14 = this.u == 0 ? measuredWidth : i12;
                    if (this.u == 0) {
                        measuredWidth = i12;
                    }
                    int measuredHeight5 = (measuredHeight - this.l) + ((childAt2.getMeasuredHeight() - view.getMeasuredHeight()) / 2);
                    view.layout(i14, measuredHeight5, measuredWidth, measuredHeight5 + view.getMeasuredHeight());
                    this.w.a(new TouchDelegate(new Rect(Math.min(measuredWidth5, i14), measuredHeight - (this.j / 2), Math.max(measuredWidth5 + childAt2.getMeasuredWidth(), measuredWidth), childAt2.getMeasuredHeight() + measuredHeight + (this.j / 2)), childAt2));
                    view.setTranslationY(this.m ? 0.0f : f4);
                    view.setAlpha(this.m ? 1.0f : 0.0f);
                    a aVar3 = (a) view.getLayoutParams();
                    aVar3.f9843c.setFloatValues(0.0f, f4);
                    aVar3.f9841a.setFloatValues(f4, 0.0f);
                    aVar3.a(view);
                }
                if (z3) {
                    measuredHeight -= this.j;
                } else {
                    measuredHeight = measuredHeight + childAt2.getMeasuredHeight() + this.j;
                }
            }
            i13--;
            measuredHeight4 = i5;
            i7 = 8;
            f2 = 0.0f;
            c2 = 0;
            c3 = 1;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        TextView textView;
        measureChildren(i, i2);
        this.r = 0;
        this.s = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < this.v; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int i7 = this.i;
                if (i7 == 0 || i7 == 1) {
                    this.r = Math.max(this.r, childAt.getMeasuredWidth());
                    i4 += childAt.getMeasuredHeight();
                } else if (i7 == 2 || i7 == 3) {
                    i5 += childAt.getMeasuredWidth();
                    this.s = Math.max(this.s, childAt.getMeasuredHeight());
                }
                if (!i() && (textView = (TextView) childAt.getTag(i.fab_label)) != null) {
                    i3 = Math.max(i3, textView.getMeasuredWidth());
                }
            }
        }
        if (!i()) {
            i5 = this.r + (i3 > 0 ? this.k + i3 : 0);
        } else {
            i4 = this.s;
        }
        int i8 = this.i;
        if (i8 == 0 || i8 == 1) {
            i4 = a(i4 + (this.j * (getChildCount() - 1)));
        } else if (i8 == 2 || i8 == 3) {
            i5 = a(i5 + (this.j * (getChildCount() - 1)));
        }
        setMeasuredDimension(i5, i4);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            d dVar = (d) parcelable;
            this.m = dVar.f9848a;
            this.w.a(this.m);
            c cVar = this.q;
            if (cVar != null) {
                cVar.setRotation(this.m ? 135.0f : 0.0f);
            }
            super.onRestoreInstanceState(dVar.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f9848a = this.m;
        return dVar;
    }

    public void setOnFloatingActionsMenuUpdateListener(b bVar) {
        this.x = bVar;
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new AnimatorSet().setDuration(300L);
        this.o = new AnimatorSet().setDuration(300L);
        a(context, attributeSet);
    }

    public void d() {
        if (this.m) {
            this.m = false;
            this.w.a(false);
            this.o.start();
            this.n.cancel();
            b bVar = this.x;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void e() {
        if (this.m) {
            return;
        }
        this.m = true;
        this.w.a(true);
        this.o.cancel();
        this.n.start();
        b bVar = this.x;
        if (bVar != null) {
            bVar.b();
        }
    }

    public boolean f() {
        return this.m;
    }

    public void g() {
        if (this.m) {
            d();
        } else {
            e();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(super.generateLayoutParams(layoutParams));
    }

    private int b(int i) {
        return getResources().getColor(i);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.j = (int) ((getResources().getDimension(g.fab_actions_spacing) - getResources().getDimension(g.fab_shadow_radius)) - getResources().getDimension(g.fab_shadow_offset));
        this.k = getResources().getDimensionPixelSize(g.fab_labels_margin);
        this.l = getResources().getDimensionPixelSize(g.fab_shadow_offset);
        this.w = new k(this);
        setTouchDelegate(this.w);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.FloatingActionsMenu, 0, 0);
        this.f9836d = obtainStyledAttributes.getColor(j.FloatingActionsMenu_fab_addButtonPlusIconColor, b(R.color.white));
        this.f9837e = obtainStyledAttributes.getColor(j.FloatingActionsMenu_fab_addButtonColorNormal, b(R.color.holo_blue_dark));
        this.f9838f = obtainStyledAttributes.getColor(j.FloatingActionsMenu_fab_addButtonColorPressed, b(R.color.holo_blue_light));
        this.f9839g = obtainStyledAttributes.getInt(j.FloatingActionsMenu_fab_addButtonSize, 0);
        this.f9840h = obtainStyledAttributes.getBoolean(j.FloatingActionsMenu_fab_addButtonStrokeVisible, true);
        this.i = obtainStyledAttributes.getInt(j.FloatingActionsMenu_fab_expandDirection, 0);
        this.t = obtainStyledAttributes.getResourceId(j.FloatingActionsMenu_fab_labelStyle, 0);
        this.u = obtainStyledAttributes.getInt(j.FloatingActionsMenu_fab_labelsPosition, 0);
        obtainStyledAttributes.recycle();
        if (this.t != 0 && i()) {
            throw new IllegalStateException("Action labels in horizontal expand orientation is not supported.");
        }
        a(context);
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new AnimatorSet().setDuration(300L);
        this.o = new AnimatorSet().setDuration(300L);
        a(context, attributeSet);
    }

    private void a(Context context) {
        this.p = new com.getbase.floatingactionbutton.d(this, context);
        this.p.setId(i.fab_expand_menu_button);
        this.p.setSize(this.f9839g);
        this.p.setOnClickListener(new e(this));
        addView(this.p, super.generateDefaultLayoutParams());
    }

    private int a(int i) {
        return (i * 12) / 10;
    }
}
