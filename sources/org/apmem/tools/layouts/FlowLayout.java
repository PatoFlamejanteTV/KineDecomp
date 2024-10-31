package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.b;

/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private int f4938a;
    private int b;
    private int c;
    private boolean d;

    public FlowLayout(Context context) {
        super(context);
        this.f4938a = 0;
        this.b = 0;
        this.c = 0;
        this.d = false;
        a(context, (AttributeSet) null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4938a = 0;
        this.b = 0;
        this.c = 0;
        this.d = false;
        a(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4938a = 0;
        this.b = 0;
        this.c = 0;
        this.d = false;
        a(context, attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingBottom;
        int paddingLeft;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int paddingLeft2;
        int paddingTop;
        int max;
        int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.c == 0) {
            mode2 = mode;
        } else {
            size = size2;
        }
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int childCount = getChildCount();
        int i13 = 0;
        int i14 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                max = i12;
            } else {
                a aVar = (a) childAt.getLayoutParams();
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), aVar.width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), aVar.height));
                int b = b(aVar);
                int a2 = a(aVar);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (this.c == 0) {
                    i3 = measuredWidth;
                    measuredWidth = measuredHeight;
                } else {
                    i3 = measuredHeight;
                    a2 = b;
                    b = a2;
                }
                int i15 = i10 + i3;
                int i16 = i15 + b;
                if (aVar.f || (mode2 != 0 && i15 > size)) {
                    i6 = measuredWidth;
                    i7 = measuredWidth + a2;
                    i10 = b + i3;
                    i4 = i11 + i8;
                    i5 = i3;
                } else {
                    i4 = i11;
                    i5 = i15;
                    i10 = i16;
                    i6 = i9;
                    i7 = i8;
                }
                i8 = Math.max(i7, a2 + measuredWidth);
                i9 = Math.max(i6, measuredWidth);
                if (this.c == 0) {
                    paddingLeft2 = (getPaddingLeft() + i5) - i3;
                    paddingTop = getPaddingTop() + i4;
                } else {
                    paddingLeft2 = getPaddingLeft() + i4;
                    paddingTop = (getPaddingTop() + i5) - measuredHeight;
                }
                aVar.a(paddingLeft2, paddingTop);
                max = Math.max(i12, i5);
                i14 = i4 + i9;
                i11 = i4;
            }
            i13++;
            i12 = max;
        }
        if (this.c == 0) {
            paddingBottom = getPaddingLeft() + getPaddingRight() + i12;
            paddingLeft = i14 + getPaddingBottom() + getPaddingTop();
        } else {
            paddingBottom = getPaddingBottom() + getPaddingTop() + i12;
            paddingLeft = i14 + getPaddingLeft() + getPaddingRight();
        }
        if (this.c == 0) {
            setMeasuredDimension(resolveSize(paddingBottom, i), resolveSize(paddingLeft, i2));
        } else {
            setMeasuredDimension(resolveSize(paddingLeft, i), resolveSize(paddingBottom, i2));
        }
    }

    private int a(a aVar) {
        if (!aVar.b()) {
            return this.b;
        }
        return aVar.e;
    }

    private int b(a aVar) {
        if (!aVar.a()) {
            return this.f4938a;
        }
        return aVar.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) childAt.getLayoutParams();
            childAt.layout(aVar.b, aVar.c, aVar.b + childAt.getMeasuredWidth(), aVar.c + childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        a(canvas, view);
        return drawChild;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a.FlowLayout);
        try {
            this.f4938a = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.b = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.c = obtainStyledAttributes.getInteger(0, 0);
            this.d = obtainStyledAttributes.getBoolean(3, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void a(Canvas canvas, View view) {
        if (this.d) {
            Paint a2 = a(-256);
            Paint a3 = a(-16711936);
            Paint a4 = a(-65536);
            a aVar = (a) view.getLayoutParams();
            if (aVar.d > 0) {
                float right = view.getRight();
                float height = (view.getHeight() / 2.0f) + view.getTop();
                canvas.drawLine(right, height, right + aVar.d, height, a2);
                canvas.drawLine((aVar.d + right) - 4.0f, height - 4.0f, right + aVar.d, height, a2);
                canvas.drawLine((aVar.d + right) - 4.0f, height + 4.0f, right + aVar.d, height, a2);
            } else if (this.f4938a > 0) {
                float right2 = view.getRight();
                float top = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right2, top, right2 + this.f4938a, top, a3);
                canvas.drawLine((this.f4938a + right2) - 4.0f, top - 4.0f, right2 + this.f4938a, top, a3);
                canvas.drawLine((this.f4938a + right2) - 4.0f, top + 4.0f, right2 + this.f4938a, top, a3);
            }
            if (aVar.e > 0) {
                float width = (view.getWidth() / 2.0f) + view.getLeft();
                float bottom = view.getBottom();
                canvas.drawLine(width, bottom, width, bottom + aVar.e, a2);
                canvas.drawLine(width - 4.0f, (aVar.e + bottom) - 4.0f, width, bottom + aVar.e, a2);
                canvas.drawLine(width + 4.0f, (aVar.e + bottom) - 4.0f, width, bottom + aVar.e, a2);
            } else if (this.b > 0) {
                float left = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom2 = view.getBottom();
                canvas.drawLine(left, bottom2, left, bottom2 + this.b, a3);
                canvas.drawLine(left - 4.0f, (this.b + bottom2) - 4.0f, left, bottom2 + this.b, a3);
                canvas.drawLine(left + 4.0f, (this.b + bottom2) - 4.0f, left, bottom2 + this.b, a3);
            }
            if (aVar.f) {
                if (this.c == 0) {
                    float left2 = view.getLeft();
                    float top2 = view.getTop() + (view.getHeight() / 2.0f);
                    canvas.drawLine(left2, top2 - 6.0f, left2, top2 + 6.0f, a4);
                } else {
                    float left3 = view.getLeft() + (view.getWidth() / 2.0f);
                    float top3 = view.getTop();
                    canvas.drawLine(left3 - 6.0f, top3, 6.0f + left3, top3, a4);
                }
            }
        }
    }

    private Paint a(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        private static int f4939a = -1;
        private int b;
        private int c;
        private int d;
        private int e;
        private boolean f;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.d = f4939a;
            this.e = f4939a;
            this.f = false;
            a(context, attributeSet);
        }

        public a(int i, int i2) {
            super(i, i2);
            this.d = f4939a;
            this.e = f4939a;
            this.f = false;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.d = f4939a;
            this.e = f4939a;
            this.f = false;
        }

        public boolean a() {
            return this.d != f4939a;
        }

        public boolean b() {
            return this.e != f4939a;
        }

        public void a(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        private void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a.FlowLayout_LayoutParams);
            try {
                this.d = obtainStyledAttributes.getDimensionPixelSize(1, f4939a);
                this.e = obtainStyledAttributes.getDimensionPixelSize(2, f4939a);
                this.f = obtainStyledAttributes.getBoolean(0, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }
}
