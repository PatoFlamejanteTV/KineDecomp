package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.c;

/* loaded from: classes3.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: a */
    private int f29328a;

    /* renamed from: b */
    private int f29329b;

    /* renamed from: c */
    private int f29330c;

    /* renamed from: d */
    private boolean f29331d;

    /* loaded from: classes3.dex */
    public static class a extends ViewGroup.LayoutParams {

        /* renamed from: a */
        private static int f29332a = -1;

        /* renamed from: b */
        private int f29333b;

        /* renamed from: c */
        private int f29334c;

        /* renamed from: d */
        private int f29335d;

        /* renamed from: e */
        private int f29336e;

        /* renamed from: f */
        private boolean f29337f;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i = f29332a;
            this.f29335d = i;
            this.f29336e = i;
            this.f29337f = false;
            a(context, attributeSet);
        }

        public boolean a() {
            return this.f29335d != f29332a;
        }

        public boolean b() {
            return this.f29336e != f29332a;
        }

        public void a(int i, int i2) {
            this.f29333b = i;
            this.f29334c = i2;
        }

        private void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.FlowLayout_LayoutParams);
            try {
                this.f29335d = obtainStyledAttributes.getDimensionPixelSize(0, f29332a);
                this.f29336e = obtainStyledAttributes.getDimensionPixelSize(2, f29332a);
                this.f29337f = obtainStyledAttributes.getBoolean(1, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public a(int i, int i2) {
            super(i, i2);
            int i3 = f29332a;
            this.f29335d = i3;
            this.f29336e = i3;
            this.f29337f = false;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            int i = f29332a;
            this.f29335d = i;
            this.f29336e = i;
            this.f29337f = false;
        }
    }

    public FlowLayout(Context context) {
        super(context);
        this.f29328a = 0;
        this.f29329b = 0;
        this.f29330c = 0;
        this.f29331d = false;
        a(context, (AttributeSet) null);
    }

    private int a(a aVar) {
        if (aVar.a()) {
            return aVar.f29335d;
        }
        return this.f29328a;
    }

    private int b(a aVar) {
        if (aVar.b()) {
            return aVar.f29336e;
        }
        return this.f29329b;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        a(canvas, view);
        return drawChild;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) childAt.getLayoutParams();
            childAt.layout(aVar.f29333b, aVar.f29334c, aVar.f29333b + childAt.getMeasuredWidth(), aVar.f29334c + childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingBottom;
        int paddingLeft;
        int paddingRight;
        int i3;
        int i4;
        int paddingLeft2;
        int paddingTop;
        int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.f29330c != 0) {
            size = size2;
            mode = mode2;
        }
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                i3 = childCount;
            } else {
                a aVar = (a) childAt.getLayoutParams();
                i3 = childCount;
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((ViewGroup.LayoutParams) aVar).width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), ((ViewGroup.LayoutParams) aVar).height));
                int a2 = a(aVar);
                int b2 = b(aVar);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = a2;
                if (this.f29330c == 0) {
                    i4 = measuredHeight;
                } else {
                    i4 = measuredWidth;
                    measuredWidth = measuredHeight;
                    i12 = b2;
                    b2 = i12;
                }
                int i13 = i8 + measuredWidth;
                int i14 = i13 + i12;
                if (aVar.f29337f || (mode != 0 && i13 > size)) {
                    i11 += i9;
                    i9 = i4 + b2;
                    i14 = measuredWidth + i12;
                    i10 = i4;
                    i13 = measuredWidth;
                }
                int max = Math.max(i9, b2 + i4);
                int max2 = Math.max(i10, i4);
                if (this.f29330c == 0) {
                    paddingLeft2 = (getPaddingLeft() + i13) - measuredWidth;
                    paddingTop = getPaddingTop() + i11;
                } else {
                    paddingLeft2 = getPaddingLeft() + i11;
                    paddingTop = (getPaddingTop() + i13) - measuredHeight;
                }
                aVar.a(paddingLeft2, paddingTop);
                int max3 = Math.max(i6, i13);
                i10 = max2;
                i9 = max;
                i8 = i14;
                i7 = i11 + max2;
                i6 = max3;
            }
            i5++;
            childCount = i3;
        }
        if (this.f29330c == 0) {
            paddingBottom = i6 + getPaddingLeft() + getPaddingRight();
            paddingLeft = getPaddingBottom();
            paddingRight = getPaddingTop();
        } else {
            paddingBottom = i6 + getPaddingBottom() + getPaddingTop();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        int i15 = i7 + paddingLeft + paddingRight;
        if (this.f29330c == 0) {
            setMeasuredDimension(ViewGroup.resolveSize(paddingBottom, i), ViewGroup.resolveSize(i15, i2));
        } else {
            setMeasuredDimension(ViewGroup.resolveSize(i15, i), ViewGroup.resolveSize(paddingBottom, i2));
        }
    }

    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.FlowLayout);
        try {
            this.f29328a = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f29329b = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.f29330c = obtainStyledAttributes.getInteger(2, 0);
            this.f29331d = obtainStyledAttributes.getBoolean(0, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29328a = 0;
        this.f29329b = 0;
        this.f29330c = 0;
        this.f29331d = false;
        a(context, attributeSet);
    }

    private void a(Canvas canvas, View view) {
        if (this.f29331d) {
            Paint a2 = a(InputDeviceCompat.SOURCE_ANY);
            Paint a3 = a(-16711936);
            Paint a4 = a(SupportMenu.CATEGORY_MASK);
            a aVar = (a) view.getLayoutParams();
            if (aVar.f29335d > 0) {
                float right = view.getRight();
                float top = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right, top, right + aVar.f29335d, top, a2);
                canvas.drawLine((aVar.f29335d + right) - 4.0f, top - 4.0f, right + aVar.f29335d, top, a2);
                canvas.drawLine((aVar.f29335d + right) - 4.0f, top + 4.0f, right + aVar.f29335d, top, a2);
            } else if (this.f29328a > 0) {
                float right2 = view.getRight();
                float top2 = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right2, top2, right2 + this.f29328a, top2, a3);
                int i = this.f29328a;
                canvas.drawLine((i + right2) - 4.0f, top2 - 4.0f, right2 + i, top2, a3);
                int i2 = this.f29328a;
                canvas.drawLine((i2 + right2) - 4.0f, top2 + 4.0f, right2 + i2, top2, a3);
            }
            if (aVar.f29336e > 0) {
                float left = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom = view.getBottom();
                canvas.drawLine(left, bottom, left, bottom + aVar.f29336e, a2);
                canvas.drawLine(left - 4.0f, (aVar.f29336e + bottom) - 4.0f, left, bottom + aVar.f29336e, a2);
                canvas.drawLine(left + 4.0f, (aVar.f29336e + bottom) - 4.0f, left, bottom + aVar.f29336e, a2);
            } else if (this.f29329b > 0) {
                float left2 = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom2 = view.getBottom();
                canvas.drawLine(left2, bottom2, left2, bottom2 + this.f29329b, a3);
                int i3 = this.f29329b;
                canvas.drawLine(left2 - 4.0f, (i3 + bottom2) - 4.0f, left2, bottom2 + i3, a3);
                int i4 = this.f29329b;
                canvas.drawLine(left2 + 4.0f, (i4 + bottom2) - 4.0f, left2, bottom2 + i4, a3);
            }
            if (aVar.f29337f) {
                if (this.f29330c == 0) {
                    float left3 = view.getLeft();
                    float top3 = view.getTop() + (view.getHeight() / 2.0f);
                    canvas.drawLine(left3, top3 - 6.0f, left3, top3 + 6.0f, a4);
                } else {
                    float left4 = view.getLeft() + (view.getWidth() / 2.0f);
                    float top4 = view.getTop();
                    canvas.drawLine(left4 - 6.0f, top4, left4 + 6.0f, top4, a4);
                }
            }
        }
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29328a = 0;
        this.f29329b = 0;
        this.f29330c = 0;
        this.f29331d = false;
        a(context, attributeSet);
    }

    private Paint a(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0f);
        return paint;
    }
}
