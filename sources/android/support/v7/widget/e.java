package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.g.p;
import android.support.v7.b.a;
import android.support.v7.internal.widget.ac;
import android.support.v7.internal.widget.af;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* compiled from: LinearLayoutCompat.java */
/* loaded from: classes.dex */
public class e extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private boolean f214a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f214a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        ac a2 = ac.a(context, attributeSet, a.i.LinearLayoutCompat, i, 0);
        int a3 = a2.a(a.i.LinearLayoutCompat_android_orientation, -1);
        if (a3 >= 0) {
            setOrientation(a3);
        }
        int a4 = a2.a(a.i.LinearLayoutCompat_android_gravity, -1);
        if (a4 >= 0) {
            setGravity(a4);
        }
        boolean a5 = a2.a(a.i.LinearLayoutCompat_android_baselineAligned, true);
        if (!a5) {
            setBaselineAligned(a5);
        }
        this.g = a2.a(a.i.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = a2.a(a.i.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = a2.a(a.i.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a2.a(a.i.LinearLayoutCompat_divider));
        this.n = a2.a(a.i.LinearLayoutCompat_showDividers, 0);
        this.o = a2.d(a.i.LinearLayoutCompat_dividerPadding, 0);
        a2.b();
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.n;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.k) {
            this.k = drawable;
            if (drawable != null) {
                this.l = drawable.getIntrinsicWidth();
                this.m = drawable.getIntrinsicHeight();
            } else {
                this.l = 0;
                this.m = 0;
            }
            setWillNotDraw(drawable == null);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.k != null) {
            if (this.d == 1) {
                a(canvas);
            } else {
                b(canvas);
            }
        }
    }

    void a(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View b = b(i);
            if (b != null && b.getVisibility() != 8 && c(i)) {
                a(canvas, (b.getTop() - ((a) b.getLayoutParams()).topMargin) - this.m);
            }
        }
        if (c(virtualChildCount)) {
            View b2 = b(virtualChildCount - 1);
            if (b2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.m;
            } else {
                bottom = ((a) b2.getLayoutParams()).bottomMargin + b2.getBottom();
            }
            a(canvas, bottom);
        }
    }

    void b(Canvas canvas) {
        int right;
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean a2 = af.a(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View b = b(i);
            if (b != null && b.getVisibility() != 8 && c(i)) {
                a aVar = (a) b.getLayoutParams();
                if (a2) {
                    left = aVar.rightMargin + b.getRight();
                } else {
                    left = (b.getLeft() - aVar.leftMargin) - this.l;
                }
                b(canvas, left);
            }
        }
        if (c(virtualChildCount)) {
            View b2 = b(virtualChildCount - 1);
            if (b2 == null) {
                if (a2) {
                    right = getPaddingLeft();
                } else {
                    right = (getWidth() - getPaddingRight()) - this.l;
                }
            } else {
                a aVar2 = (a) b2.getLayoutParams();
                if (a2) {
                    right = (b2.getLeft() - aVar2.leftMargin) - this.l;
                } else {
                    right = aVar2.rightMargin + b2.getRight();
                }
            }
            b(canvas, right);
        }
    }

    void a(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    void b(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.f214a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        int i2;
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.b);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.b != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            return -1;
        }
        int i3 = this.c;
        if (this.d == 1 && (i2 = this.e & 112) != 48) {
            switch (i2) {
                case 16:
                    i = i3 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2);
                    break;
                case 80:
                    i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
                    break;
            }
            return ((a) childAt.getLayoutParams()).topMargin + i + baseline;
        }
        i = i3;
        return ((a) childAt.getLayoutParams()).topMargin + i + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.b = i;
    }

    View b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.d == 1) {
            a(i, i2);
        } else {
            b(i, i2);
        }
    }

    protected boolean c(int i) {
        if (i == 0) {
            return (this.n & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.n & 4) != 0;
        }
        if ((this.n & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    void a(int i, int i2) {
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        boolean z;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        boolean z3;
        int max;
        int i11;
        boolean z4;
        int i12;
        int i13;
        int i14;
        this.f = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        boolean z5 = true;
        float f2 = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z6 = false;
        boolean z7 = false;
        int i19 = this.b;
        boolean z8 = this.h;
        int i20 = NexEditorDeviceProfile.UNKNOWN;
        int i21 = 0;
        while (i21 < virtualChildCount) {
            View b = b(i21);
            if (b == null) {
                this.f += d(i21);
                i13 = i20;
                z4 = z7;
                z3 = z5;
                i14 = i16;
                i12 = i15;
            } else if (b.getVisibility() == 8) {
                i21 += a(b, i21);
                i13 = i20;
                z4 = z7;
                z3 = z5;
                i14 = i16;
                i12 = i15;
            } else {
                if (c(i21)) {
                    this.f += this.m;
                }
                a aVar = (a) b.getLayoutParams();
                float f3 = f2 + aVar.g;
                if (mode2 == 1073741824 && aVar.height == 0 && aVar.g > 0.0f) {
                    int i22 = this.f;
                    this.f = Math.max(i22, aVar.topMargin + i22 + aVar.bottomMargin);
                    z7 = true;
                } else {
                    int i23 = NexEditorDeviceProfile.UNKNOWN;
                    if (aVar.height == 0 && aVar.g > 0.0f) {
                        i23 = 0;
                        aVar.height = -2;
                    }
                    int i24 = i23;
                    a(b, i21, i, 0, i2, f3 == 0.0f ? this.f : 0);
                    if (i24 != Integer.MIN_VALUE) {
                        aVar.height = i24;
                    }
                    int measuredHeight = b.getMeasuredHeight();
                    int i25 = this.f;
                    this.f = Math.max(i25, i25 + measuredHeight + aVar.topMargin + aVar.bottomMargin + b(b));
                    if (z8) {
                        i20 = Math.max(measuredHeight, i20);
                    }
                }
                if (i19 >= 0 && i19 == i21 + 1) {
                    this.c = this.f;
                }
                if (i21 < i19 && aVar.g > 0.0f) {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
                boolean z9 = false;
                if (mode == 1073741824 || aVar.width != -1) {
                    z2 = z6;
                } else {
                    z2 = true;
                    z9 = true;
                }
                int i26 = aVar.rightMargin + aVar.leftMargin;
                int measuredWidth = b.getMeasuredWidth() + i26;
                int max2 = Math.max(i15, measuredWidth);
                int a2 = af.a(i16, p.c(b));
                z3 = z5 && aVar.width == -1;
                if (aVar.g > 0.0f) {
                    i11 = Math.max(i18, z9 ? i26 : measuredWidth);
                    max = i17;
                } else {
                    if (!z9) {
                        i26 = measuredWidth;
                    }
                    max = Math.max(i17, i26);
                    i11 = i18;
                }
                i21 += a(b, i21);
                z4 = z7;
                i18 = i11;
                i17 = max;
                i12 = max2;
                i13 = i20;
                i14 = a2;
                z6 = z2;
                f2 = f3;
            }
            i21++;
            i20 = i13;
            z7 = z4;
            z5 = z3;
            i16 = i14;
            i15 = i12;
        }
        if (this.f > 0 && c(virtualChildCount)) {
            this.f += this.m;
        }
        if (z8 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f = 0;
            int i27 = 0;
            while (i27 < virtualChildCount) {
                View b2 = b(i27);
                if (b2 == null) {
                    this.f += d(i27);
                    i10 = i27;
                } else if (b2.getVisibility() == 8) {
                    i10 = a(b2, i27) + i27;
                } else {
                    a aVar2 = (a) b2.getLayoutParams();
                    int i28 = this.f;
                    this.f = Math.max(i28, aVar2.bottomMargin + i28 + i20 + aVar2.topMargin + b(b2));
                    i10 = i27;
                }
                i27 = i10 + 1;
            }
        }
        this.f += getPaddingTop() + getPaddingBottom();
        int a3 = p.a(Math.max(this.f, getSuggestedMinimumHeight()), i2, 0);
        int i29 = (16777215 & a3) - this.f;
        if (z7 || (i29 != 0 && f2 > 0.0f)) {
            if (this.g > 0.0f) {
                f2 = this.g;
            }
            this.f = 0;
            int i30 = 0;
            float f4 = f2;
            boolean z10 = z5;
            int i31 = i17;
            int i32 = i16;
            int i33 = i15;
            int i34 = i29;
            while (i30 < virtualChildCount) {
                View b3 = b(i30);
                if (b3.getVisibility() == 8) {
                    i7 = i31;
                    i9 = i32;
                    i8 = i33;
                    z = z10;
                } else {
                    a aVar3 = (a) b3.getLayoutParams();
                    float f5 = aVar3.g;
                    if (f5 > 0.0f) {
                        int i35 = (int) ((i34 * f5) / f4);
                        float f6 = f4 - f5;
                        int i36 = i34 - i35;
                        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + aVar3.leftMargin + aVar3.rightMargin, aVar3.width);
                        if (aVar3.height != 0 || mode2 != 1073741824) {
                            int measuredHeight2 = i35 + b3.getMeasuredHeight();
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            b3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
                        } else {
                            if (i35 <= 0) {
                                i35 = 0;
                            }
                            b3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i35, 1073741824));
                        }
                        i5 = i36;
                        i6 = af.a(i32, p.c(b3) & (-256));
                        f = f6;
                    } else {
                        f = f4;
                        i5 = i34;
                        i6 = i32;
                    }
                    int i37 = aVar3.leftMargin + aVar3.rightMargin;
                    int measuredWidth2 = b3.getMeasuredWidth() + i37;
                    int max3 = Math.max(i33, measuredWidth2);
                    if (!(mode != 1073741824 && aVar3.width == -1)) {
                        i37 = measuredWidth2;
                    }
                    int max4 = Math.max(i31, i37);
                    z = z10 && aVar3.width == -1;
                    int i38 = this.f;
                    this.f = Math.max(i38, aVar3.bottomMargin + b3.getMeasuredHeight() + i38 + aVar3.topMargin + b(b3));
                    i7 = max4;
                    i8 = max3;
                    float f7 = f;
                    i9 = i6;
                    i34 = i5;
                    f4 = f7;
                }
                i30++;
                i31 = i7;
                i33 = i8;
                z10 = z;
                i32 = i9;
            }
            this.f += getPaddingTop() + getPaddingBottom();
            z5 = z10;
            i3 = i31;
            i16 = i32;
            i4 = i33;
        } else {
            int max5 = Math.max(i17, i18);
            if (z8 && mode2 != 1073741824) {
                int i39 = 0;
                while (true) {
                    int i40 = i39;
                    if (i40 >= virtualChildCount) {
                        break;
                    }
                    View b4 = b(i40);
                    if (b4 != null && b4.getVisibility() != 8 && ((a) b4.getLayoutParams()).g > 0.0f) {
                        b4.measure(View.MeasureSpec.makeMeasureSpec(b4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i20, 1073741824));
                    }
                    i39 = i40 + 1;
                }
            }
            i3 = max5;
            i4 = i15;
        }
        if (z5 || mode == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(p.a(Math.max(i3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, i16), a3);
        if (z6) {
            c(virtualChildCount, i2);
        }
    }

    private void c(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                a aVar = (a) b.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    void b(int i, int i2) {
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        int i7;
        boolean z;
        int i8;
        int i9;
        float f2;
        int baseline;
        int i10;
        boolean z2;
        boolean z3;
        int max;
        int i11;
        boolean z4;
        int i12;
        int i13;
        int i14;
        this.f = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        boolean z5 = true;
        float f3 = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z6 = false;
        boolean z7 = false;
        if (this.i == null || this.j == null) {
            this.i = new int[4];
            this.j = new int[4];
        }
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z8 = this.f214a;
        boolean z9 = this.h;
        boolean z10 = mode == 1073741824;
        int i19 = NexEditorDeviceProfile.UNKNOWN;
        int i20 = 0;
        while (i20 < virtualChildCount) {
            View b = b(i20);
            if (b == null) {
                this.f += d(i20);
                i13 = i19;
                z4 = z7;
                z3 = z5;
                i14 = i16;
                i12 = i15;
            } else if (b.getVisibility() == 8) {
                i20 += a(b, i20);
                i13 = i19;
                z4 = z7;
                z3 = z5;
                i14 = i16;
                i12 = i15;
            } else {
                if (c(i20)) {
                    this.f += this.l;
                }
                a aVar = (a) b.getLayoutParams();
                float f4 = f3 + aVar.g;
                if (mode == 1073741824 && aVar.width == 0 && aVar.g > 0.0f) {
                    if (z10) {
                        this.f += aVar.leftMargin + aVar.rightMargin;
                    } else {
                        int i21 = this.f;
                        this.f = Math.max(i21, aVar.leftMargin + i21 + aVar.rightMargin);
                    }
                    if (z8) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(makeMeasureSpec, makeMeasureSpec);
                    } else {
                        z7 = true;
                    }
                } else {
                    int i22 = NexEditorDeviceProfile.UNKNOWN;
                    if (aVar.width == 0 && aVar.g > 0.0f) {
                        i22 = 0;
                        aVar.width = -2;
                    }
                    int i23 = i22;
                    a(b, i20, i, f4 == 0.0f ? this.f : 0, i2, 0);
                    if (i23 != Integer.MIN_VALUE) {
                        aVar.width = i23;
                    }
                    int measuredWidth = b.getMeasuredWidth();
                    if (z10) {
                        this.f += aVar.leftMargin + measuredWidth + aVar.rightMargin + b(b);
                    } else {
                        int i24 = this.f;
                        this.f = Math.max(i24, i24 + measuredWidth + aVar.leftMargin + aVar.rightMargin + b(b));
                    }
                    if (z9) {
                        i19 = Math.max(measuredWidth, i19);
                    }
                }
                boolean z11 = false;
                if (mode2 == 1073741824 || aVar.height != -1) {
                    z2 = z6;
                } else {
                    z2 = true;
                    z11 = true;
                }
                int i25 = aVar.bottomMargin + aVar.topMargin;
                int measuredHeight = b.getMeasuredHeight() + i25;
                int a2 = af.a(i16, p.c(b));
                if (z8) {
                    int baseline2 = b.getBaseline();
                    if (baseline2 != -1) {
                        int i26 = ((((aVar.h < 0 ? this.e : aVar.h) & 112) >> 4) & (-2)) >> 1;
                        iArr[i26] = Math.max(iArr[i26], baseline2);
                        iArr2[i26] = Math.max(iArr2[i26], measuredHeight - baseline2);
                    }
                }
                int max2 = Math.max(i15, measuredHeight);
                z3 = z5 && aVar.height == -1;
                if (aVar.g > 0.0f) {
                    i11 = Math.max(i18, z11 ? i25 : measuredHeight);
                    max = i17;
                } else {
                    if (!z11) {
                        i25 = measuredHeight;
                    }
                    max = Math.max(i17, i25);
                    i11 = i18;
                }
                i20 += a(b, i20);
                z4 = z7;
                i18 = i11;
                i17 = max;
                i12 = max2;
                i13 = i19;
                i14 = a2;
                z6 = z2;
                f3 = f4;
            }
            i20++;
            i19 = i13;
            z7 = z4;
            z5 = z3;
            i16 = i14;
            i15 = i12;
        }
        if (this.f > 0 && c(virtualChildCount)) {
            this.f += this.l;
        }
        int max3 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i15 : Math.max(i15, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z9 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f = 0;
            int i27 = 0;
            while (i27 < virtualChildCount) {
                View b2 = b(i27);
                if (b2 == null) {
                    this.f += d(i27);
                    i10 = i27;
                } else if (b2.getVisibility() == 8) {
                    i10 = a(b2, i27) + i27;
                } else {
                    a aVar2 = (a) b2.getLayoutParams();
                    if (z10) {
                        this.f = aVar2.rightMargin + aVar2.leftMargin + i19 + b(b2) + this.f;
                        i10 = i27;
                    } else {
                        int i28 = this.f;
                        this.f = Math.max(i28, aVar2.rightMargin + i28 + i19 + aVar2.leftMargin + b(b2));
                        i10 = i27;
                    }
                }
                i27 = i10 + 1;
            }
        }
        this.f += getPaddingLeft() + getPaddingRight();
        int a3 = p.a(Math.max(this.f, getSuggestedMinimumWidth()), i, 0);
        int i29 = (16777215 & a3) - this.f;
        if (z7 || (i29 != 0 && f3 > 0.0f)) {
            if (this.g > 0.0f) {
                f3 = this.g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f = 0;
            int i30 = 0;
            float f5 = f3;
            boolean z12 = z5;
            int i31 = i17;
            int i32 = i16;
            int i33 = i29;
            int i34 = -1;
            while (i30 < virtualChildCount) {
                View b3 = b(i30);
                if (b3 == null) {
                    f = f5;
                    i5 = i33;
                    i6 = i34;
                    i7 = i31;
                    z = z12;
                } else if (b3.getVisibility() == 8) {
                    f = f5;
                    i5 = i33;
                    i6 = i34;
                    i7 = i31;
                    z = z12;
                } else {
                    a aVar3 = (a) b3.getLayoutParams();
                    float f6 = aVar3.g;
                    if (f6 > 0.0f) {
                        int i35 = (int) ((i33 * f6) / f5);
                        float f7 = f5 - f6;
                        i8 = i33 - i35;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + aVar3.topMargin + aVar3.bottomMargin, aVar3.height);
                        if (aVar3.width != 0 || mode != 1073741824) {
                            int measuredWidth2 = i35 + b3.getMeasuredWidth();
                            if (measuredWidth2 < 0) {
                                measuredWidth2 = 0;
                            }
                            b3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), childMeasureSpec);
                        } else {
                            if (i35 <= 0) {
                                i35 = 0;
                            }
                            b3.measure(View.MeasureSpec.makeMeasureSpec(i35, 1073741824), childMeasureSpec);
                        }
                        i9 = af.a(i32, p.c(b3) & (-16777216));
                        f2 = f7;
                    } else {
                        i8 = i33;
                        i9 = i32;
                        f2 = f5;
                    }
                    if (z10) {
                        this.f += b3.getMeasuredWidth() + aVar3.leftMargin + aVar3.rightMargin + b(b3);
                    } else {
                        int i36 = this.f;
                        this.f = Math.max(i36, b3.getMeasuredWidth() + i36 + aVar3.leftMargin + aVar3.rightMargin + b(b3));
                    }
                    boolean z13 = mode2 != 1073741824 && aVar3.height == -1;
                    int i37 = aVar3.topMargin + aVar3.bottomMargin;
                    int measuredHeight2 = b3.getMeasuredHeight() + i37;
                    int max4 = Math.max(i34, measuredHeight2);
                    int max5 = Math.max(i31, z13 ? i37 : measuredHeight2);
                    boolean z14 = z12 && aVar3.height == -1;
                    if (z8 && (baseline = b3.getBaseline()) != -1) {
                        int i38 = ((((aVar3.h < 0 ? this.e : aVar3.h) & 112) >> 4) & (-2)) >> 1;
                        iArr[i38] = Math.max(iArr[i38], baseline);
                        iArr2[i38] = Math.max(iArr2[i38], measuredHeight2 - baseline);
                    }
                    f = f2;
                    i7 = max5;
                    z = z14;
                    i32 = i9;
                    i5 = i8;
                    i6 = max4;
                }
                i30++;
                i31 = i7;
                i34 = i6;
                z12 = z;
                i33 = i5;
                f5 = f;
            }
            this.f += getPaddingLeft() + getPaddingRight();
            if (iArr[1] != -1 || iArr[0] != -1 || iArr[2] != -1 || iArr[3] != -1) {
                i34 = Math.max(i34, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            z5 = z12;
            i3 = i31;
            i16 = i32;
            i4 = i34;
        } else {
            int max6 = Math.max(i17, i18);
            if (z9 && mode != 1073741824) {
                int i39 = 0;
                while (true) {
                    int i40 = i39;
                    if (i40 >= virtualChildCount) {
                        break;
                    }
                    View b4 = b(i40);
                    if (b4 != null && b4.getVisibility() != 8 && ((a) b4.getLayoutParams()).g > 0.0f) {
                        b4.measure(View.MeasureSpec.makeMeasureSpec(i19, 1073741824), View.MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                    i39 = i40 + 1;
                }
            }
            i3 = max6;
            i4 = max3;
        }
        if (z5 || mode2 == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(((-16777216) & i16) | a3, p.a(Math.max(i3 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i16 << 16));
        if (z6) {
            d(virtualChildCount, i);
        }
    }

    private void d(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                a aVar = (a) b.getLayoutParams();
                if (aVar.height == -1) {
                    int i4 = aVar.width;
                    aVar.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    aVar.width = i4;
                }
            }
        }
    }

    int a(View view, int i) {
        return 0;
    }

    int d(int i) {
        return 0;
    }

    void a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int a(View view) {
        return 0;
    }

    int b(View view) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d == 1) {
            a(i, i2, i3, i4);
        } else {
            b(i, i2, i3, i4);
        }
    }

    void a(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i3 - i;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.e & 112;
        int i9 = this.e & 8388615;
        switch (i8) {
            case 16:
                paddingTop = getPaddingTop() + (((i4 - i2) - this.f) / 2);
                break;
            case 80:
                paddingTop = ((getPaddingTop() + i4) - i2) - this.f;
                break;
            default:
                paddingTop = getPaddingTop();
                break;
        }
        int i10 = 0;
        int i11 = paddingTop;
        while (i10 < virtualChildCount) {
            View b = b(i10);
            if (b == null) {
                i11 += d(i10);
                i5 = i10;
            } else if (b.getVisibility() != 8) {
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                a aVar = (a) b.getLayoutParams();
                int i12 = aVar.h;
                if (i12 < 0) {
                    i12 = i9;
                }
                switch (android.support.v4.g.b.a(i12, p.a(this)) & 7) {
                    case 1:
                        i6 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + aVar.leftMargin) - aVar.rightMargin;
                        break;
                    case 5:
                        i6 = (paddingRight - measuredWidth) - aVar.rightMargin;
                        break;
                    default:
                        i6 = paddingLeft + aVar.leftMargin;
                        break;
                }
                int i13 = (c(i10) ? this.m + i11 : i11) + aVar.topMargin;
                a(b, i6, i13 + a(b), measuredWidth, measuredHeight);
                i11 = i13 + aVar.bottomMargin + measuredHeight + b(b);
                i5 = a(b, i10) + i10;
            } else {
                i5 = i10;
            }
            i10 = i5 + 1;
        }
    }

    void b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean a2 = af.a(this);
        int paddingTop = getPaddingTop();
        int i10 = i4 - i2;
        int paddingBottom = i10 - getPaddingBottom();
        int paddingBottom2 = (i10 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i11 = this.e & 8388615;
        int i12 = this.e & 112;
        boolean z = this.f214a;
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        switch (android.support.v4.g.b.a(i11, p.a(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (!a2) {
            i5 = 1;
            i6 = 0;
        } else {
            i5 = -1;
            i6 = virtualChildCount - 1;
        }
        int i13 = 0;
        while (i13 < virtualChildCount) {
            int i14 = i6 + (i5 * i13);
            View b = b(i14);
            if (b == null) {
                paddingLeft += d(i14);
                i7 = i13;
            } else if (b.getVisibility() != 8) {
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                a aVar = (a) b.getLayoutParams();
                if (!z || aVar.height == -1) {
                    i8 = -1;
                } else {
                    i8 = b.getBaseline();
                }
                int i15 = aVar.h;
                if (i15 < 0) {
                    i15 = i12;
                }
                switch (i15 & 112) {
                    case 16:
                        i9 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + aVar.topMargin) - aVar.bottomMargin;
                        break;
                    case 48:
                        i9 = paddingTop + aVar.topMargin;
                        if (i8 != -1) {
                            i9 += iArr[1] - i8;
                            break;
                        }
                        break;
                    case 80:
                        i9 = (paddingBottom - measuredHeight) - aVar.bottomMargin;
                        if (i8 != -1) {
                            i9 -= iArr2[2] - (b.getMeasuredHeight() - i8);
                            break;
                        }
                        break;
                    default:
                        i9 = paddingTop;
                        break;
                }
                int i16 = (c(i14) ? this.l + paddingLeft : paddingLeft) + aVar.leftMargin;
                a(b, i16 + a(b), i9, measuredWidth, measuredHeight);
                paddingLeft = i16 + aVar.rightMargin + measuredWidth + b(b);
                i7 = a(b, i14) + i13;
            } else {
                i7 = i13;
            }
            i13 = i7 + 1;
        }
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.d;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.e & 8388615) != i2) {
            this.e = i2 | (this.e & (-8388616));
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.e & 112) != i2) {
            this.e = i2 | (this.e & (-113));
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        if (this.d == 0) {
            return new a(-2, -2);
        }
        if (this.d == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(e.class.getName());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(e.class.getName());
        }
    }

    /* compiled from: LinearLayoutCompat.java */
    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public float g;
        public int h;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i.LinearLayoutCompat_Layout);
            this.g = obtainStyledAttributes.getFloat(a.i.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = obtainStyledAttributes.getInt(a.i.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public a(int i, int i2) {
            super(i, i2);
            this.h = -1;
            this.g = 0.0f;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.h = -1;
        }
    }
}
