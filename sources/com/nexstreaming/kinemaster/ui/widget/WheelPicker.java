package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.C;

/* loaded from: classes2.dex */
public class WheelPicker extends View {

    /* renamed from: a */
    private LinearLayout f23845a;

    /* renamed from: b */
    private C f23846b;

    /* renamed from: c */
    private z f23847c;

    /* renamed from: d */
    private y f23848d;

    /* renamed from: e */
    private a f23849e;

    /* renamed from: f */
    private int f23850f;

    /* renamed from: g */
    private int f23851g;

    /* renamed from: h */
    private int f23852h;
    private float i;
    private int j;
    private boolean k;
    private int l;
    private float m;
    private int n;
    private boolean o;
    private C.a p;
    private DataSetObserver q;

    /* loaded from: classes2.dex */
    public interface a {
        void a(WheelPicker wheelPicker, int i, int i2);
    }

    public WheelPicker(Context context) {
        super(context, null);
        this.f23847c = new z(this);
        this.f23850f = 0;
        this.f23852h = 5;
        this.i = getResources().getDimension(R.dimen.picker_focused_text_size);
        this.j = getResources().getColor(android.R.color.white);
        this.k = false;
        this.l = getResources().getColor(android.R.color.white);
        this.m = getResources().getDimension(R.dimen.picker_item_min_height);
        this.p = new w(this);
        this.q = new x(this);
    }

    private void d() {
        if (c()) {
            b(getWidth(), 1073741824);
            c(getWidth(), getHeight());
        }
    }

    private int getItemHeight() {
        float f2 = this.m;
        if (f2 != 0.0f) {
            return (int) f2;
        }
        LinearLayout linearLayout = this.f23845a;
        if (linearLayout != null && linearLayout.getChildAt(0) != null) {
            this.m = this.f23845a.getChildAt(0).getHeight();
            return (int) this.m;
        }
        return getHeight() / this.f23852h;
    }

    private h getItemsRange() {
        if (getItemHeight() == 0) {
            return null;
        }
        int i = this.f23850f;
        int i2 = 1;
        while (getItemHeight() * i2 < getHeight()) {
            i--;
            i2 += 2;
        }
        int i3 = this.n;
        if (i3 != 0) {
            if (i3 > 0) {
                i--;
            }
            int itemHeight = this.n / getItemHeight();
            i -= itemHeight;
            double d2 = i2 + 1;
            double asin = Math.asin(itemHeight);
            Double.isNaN(d2);
            i2 = (int) (d2 + asin);
        }
        return new h(i, i2);
    }

    public int getValue() {
        return this.f23850f;
    }

    public y getViewAdapter() {
        return this.f23848d;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(WheelPicker.class.getName());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        y yVar = this.f23848d;
        if (yVar == null || yVar.a() <= 0) {
            return;
        }
        d();
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c(i3 - i, i4 - i2);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        a();
        int b2 = b(size, mode);
        if (mode2 != 1073741824) {
            int a2 = a(this.f23845a);
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(a2, size2) : a2;
        }
        setMeasuredDimension(b2, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int itemHeight;
        if (!isEnabled() || getViewAdapter() == null) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2 && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (!this.o) {
            int y = ((int) motionEvent.getY()) - (getHeight() / 2);
            if (y > 0) {
                itemHeight = y + (getItemHeight() / 2);
            } else {
                itemHeight = y - (getItemHeight() / 2);
            }
            int itemHeight2 = itemHeight / getItemHeight();
            if (itemHeight2 != 0 && c(this.f23850f + itemHeight2)) {
                a(this.f23850f + itemHeight2, true);
            }
        }
        return this.f23846b.a(motionEvent);
    }

    public void setOnValueChangedListener(a aVar) {
        this.f23849e = aVar;
    }

    public void setViewAdapter(y yVar) {
        y yVar2 = this.f23848d;
        if (yVar2 != null) {
            yVar2.b(this.q);
        }
        this.f23848d = yVar;
        y yVar3 = this.f23848d;
        if (yVar3 != null) {
            yVar3.a(this.q);
        }
        a(true);
    }

    private boolean c(int i) {
        y yVar = this.f23848d;
        return yVar != null && yVar.a() > 0 && i >= 0 && i < this.f23848d.a();
    }

    private boolean b(int i, boolean z) {
        View b2 = b(i);
        if (b2 == null) {
            return false;
        }
        if (z) {
            this.f23845a.addView(b2, 0);
            return true;
        }
        this.f23845a.addView(b2);
        return true;
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.WheelPicker, 0, 0);
            this.f23852h = obtainStyledAttributes.getInt(5, this.f23852h);
            this.i = obtainStyledAttributes.getDimension(3, this.i);
            this.j = obtainStyledAttributes.getColor(2, this.j);
            this.k = obtainStyledAttributes.getBoolean(0, this.k);
            this.l = obtainStyledAttributes.getColor(1, this.l);
            this.m = obtainStyledAttributes.getDimension(4, this.m);
        }
        this.f23846b = new C(getContext(), this.p);
    }

    private void c(int i, int i2) {
        this.f23845a.layout(0, 0, i - 20, i2);
    }

    private boolean c() {
        boolean z;
        h itemsRange = getItemsRange();
        LinearLayout linearLayout = this.f23845a;
        if (linearLayout != null) {
            int a2 = this.f23847c.a(linearLayout, this.f23851g, itemsRange);
            z = this.f23851g != a2;
            this.f23851g = a2;
        } else {
            b();
            z = true;
        }
        if (!z) {
            z = (this.f23851g == itemsRange.b() && this.f23845a.getChildCount() == itemsRange.a()) ? false : true;
        }
        if (this.f23851g > itemsRange.b() && this.f23851g <= itemsRange.c()) {
            for (int i = this.f23851g - 1; i >= itemsRange.b() && b(i, true); i--) {
                this.f23851g = i;
            }
        } else {
            this.f23851g = itemsRange.b();
        }
        int i2 = this.f23851g;
        for (int childCount = this.f23845a.getChildCount(); childCount < itemsRange.a(); childCount++) {
            if (!b(this.f23851g + childCount, false) && this.f23845a.getChildCount() == 0) {
                i2++;
            }
        }
        this.f23851g = i2;
        return z;
    }

    private void b() {
        if (this.f23845a == null) {
            this.f23845a = new LinearLayout(getContext());
            this.f23845a.setOrientation(1);
        }
    }

    private View b(int i) {
        y yVar = this.f23848d;
        if (yVar == null || yVar.a() == 0) {
            return null;
        }
        int a2 = this.f23848d.a();
        if (!c(i)) {
            return this.f23848d.a(this.f23847c.b(), this.f23845a);
        }
        while (i < 0) {
            i += a2;
        }
        return this.f23848d.a(i % a2, this.f23847c.c(), this.f23845a);
    }

    public WheelPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23847c = new z(this);
        this.f23850f = 0;
        this.f23852h = 5;
        this.i = getResources().getDimension(R.dimen.picker_focused_text_size);
        this.j = getResources().getColor(android.R.color.white);
        this.k = false;
        this.l = getResources().getColor(android.R.color.white);
        this.m = getResources().getDimension(R.dimen.picker_item_min_height);
        this.p = new w(this);
        this.q = new x(this);
        a(attributeSet);
    }

    public void a(int i) {
        this.n += i;
        int itemHeight = getItemHeight();
        int i2 = this.n / itemHeight;
        int i3 = this.f23850f - i2;
        int a2 = this.f23848d.a();
        int i4 = this.n % itemHeight;
        if (Math.abs(i4) <= itemHeight / 2) {
            i4 = 0;
        }
        if (i3 < 0) {
            i2 = this.f23850f;
            i3 = 0;
        } else if (i3 >= a2) {
            i2 = (this.f23850f - a2) + 1;
            i3 = a2 - 1;
        } else if (i3 > 0 && i4 > 0) {
            i3--;
            i2++;
        } else if (i3 < a2 - 1 && i4 < 0) {
            i3++;
            i2--;
        }
        int i5 = this.n;
        if (i3 != this.f23850f) {
            a(i3, false);
        } else {
            invalidate();
        }
        this.n = i5 - (i2 * itemHeight);
        if (this.n > getHeight()) {
            this.n = (this.n % getHeight()) + getHeight();
        }
    }

    private int b(int i, int i2) {
        this.f23845a.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f23845a.measure(View.MeasureSpec.makeMeasureSpec(i, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = this.f23845a.getMeasuredWidth();
        if (i2 != 1073741824) {
            int max = Math.max(measuredWidth + 20, getSuggestedMinimumWidth());
            if (i2 != Integer.MIN_VALUE || i >= max) {
                i = max;
            }
        }
        this.f23845a.measure(View.MeasureSpec.makeMeasureSpec(i - 20, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return i;
    }

    private void b(Canvas canvas) {
        canvas.save();
        canvas.translate(10.0f, (-(((this.f23850f - this.f23851g) * getItemHeight()) + ((getItemHeight() - getHeight()) / 2))) + this.n);
        this.f23845a.draw(canvas);
        canvas.restore();
    }

    public void a(int i, boolean z) {
        int i2;
        y yVar = this.f23848d;
        if (yVar == null || yVar.a() == 0) {
            return;
        }
        int a2 = this.f23848d.a();
        if (i < 0 || i >= a2 || i == (i2 = this.f23850f)) {
            return;
        }
        if (z) {
            a(i - i2, 0);
            return;
        }
        this.n = 0;
        this.f23850f = i;
        this.f23849e.a(this, i2, this.f23850f);
        invalidate();
    }

    public void a(int i, int i2) {
        this.f23846b.a((i * getItemHeight()) - this.n, i2);
    }

    private int a(LinearLayout linearLayout) {
        float f2 = this.m;
        return Math.max((int) ((this.f23852h * f2) - ((f2 * 10.0f) / 50.0f)), getSuggestedMinimumHeight());
    }

    private void a() {
        LinearLayout linearLayout = this.f23845a;
        if (linearLayout != null) {
            this.f23847c.a(linearLayout, this.f23851g, new h());
        } else {
            b();
        }
        int i = this.f23852h / 2;
        for (int i2 = this.f23850f + i; i2 >= this.f23850f - i; i2--) {
            if (b(i2, true)) {
                this.f23851g = i2;
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            this.f23847c.a();
            LinearLayout linearLayout = this.f23845a;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            this.n = 0;
        } else {
            LinearLayout linearLayout2 = this.f23845a;
            if (linearLayout2 != null) {
                this.f23847c.a(linearLayout2, this.f23851g, new h());
            }
        }
        invalidate();
    }

    private void a(Canvas canvas) {
        int height = getHeight() / 2;
        double itemHeight = getItemHeight() / 2;
        Double.isNaN(itemHeight);
        int i = (int) (itemHeight * 1.2d);
        Paint paint = new Paint();
        paint.setColor(this.l);
        paint.setStrokeWidth(getResources().getDimension(R.dimen.picker_divider_width));
        float dimension = getResources().getDimension(R.dimen.picker_divider_padding);
        float f2 = height - i;
        canvas.drawLine(dimension, f2, getWidth() - dimension, f2, paint);
        float f3 = height + i;
        canvas.drawLine(dimension, f3, getWidth() - dimension, f3, paint);
    }
}
