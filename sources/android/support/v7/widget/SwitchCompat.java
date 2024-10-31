package android.support.v7.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.g.p;
import android.support.v7.b.a;
import android.support.v7.internal.widget.ab;
import android.support.v7.internal.widget.ac;
import android.support.v7.internal.widget.af;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.widget.CompoundButton;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private static final int[] F = {R.attr.state_checked};
    private Layout A;
    private TransformationMethod B;
    private Animation C;
    private final Rect D;
    private final ab E;

    /* renamed from: a, reason: collision with root package name */
    private Drawable f204a;
    private Drawable b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private CharSequence g;
    private CharSequence h;
    private boolean i;
    private int j;
    private int k;
    private float l;
    private float m;
    private VelocityTracker n;
    private int o;
    private float p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private TextPaint x;
    private ColorStateList y;
    private Layout z;

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0016a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = VelocityTracker.obtain();
        this.D = new Rect();
        this.x = new TextPaint(1);
        Resources resources = getResources();
        this.x.density = resources.getDisplayMetrics().density;
        ac a2 = ac.a(context, attributeSet, a.i.SwitchCompat, i, 0);
        this.f204a = a2.a(a.i.SwitchCompat_android_thumb);
        if (this.f204a != null) {
            this.f204a.setCallback(this);
        }
        this.b = a2.a(a.i.SwitchCompat_track);
        if (this.b != null) {
            this.b.setCallback(this);
        }
        this.g = a2.b(a.i.SwitchCompat_android_textOn);
        this.h = a2.b(a.i.SwitchCompat_android_textOff);
        this.i = a2.a(a.i.SwitchCompat_showText, true);
        this.c = a2.d(a.i.SwitchCompat_thumbTextPadding, 0);
        this.d = a2.d(a.i.SwitchCompat_switchMinWidth, 0);
        this.e = a2.d(a.i.SwitchCompat_switchPadding, 0);
        this.f = a2.a(a.i.SwitchCompat_splitTrack, false);
        int f = a2.f(a.i.SwitchCompat_switchTextAppearance, 0);
        if (f != 0) {
            a(context, f);
        }
        this.E = a2.c();
        a2.b();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.k = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, a.i.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(a.i.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.y = colorStateList;
        } else {
            this.y = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.i.TextAppearance_android_textSize, 0);
        if (dimensionPixelSize != 0 && dimensionPixelSize != this.x.getTextSize()) {
            this.x.setTextSize(dimensionPixelSize);
            requestLayout();
        }
        a(obtainStyledAttributes.getInt(a.i.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(a.i.TextAppearance_android_textStyle, -1));
        if (obtainStyledAttributes.getBoolean(a.i.TextAppearance_textAllCaps, false)) {
            this.B = new android.support.v7.internal.a.a(getContext());
        } else {
            this.B = null;
        }
        obtainStyledAttributes.recycle();
    }

    private void a(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        a(typeface, i2);
    }

    public void a(Typeface typeface, int i) {
        Typeface create;
        if (i > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i);
            } else {
                create = Typeface.create(typeface, i);
            }
            setSwitchTypeface(create);
            int style = ((create != null ? create.getStyle() : 0) ^ (-1)) & i;
            this.x.setFakeBoldText((style & 1) != 0);
            this.x.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.x.setFakeBoldText(false);
        this.x.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.x.getTypeface() != typeface) {
            this.x.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.e = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.e;
    }

    public void setSwitchMinWidth(int i) {
        this.d = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.d;
    }

    public void setThumbTextPadding(int i) {
        this.c = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.c;
    }

    public void setTrackDrawable(Drawable drawable) {
        this.b = drawable;
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(this.E.a(i));
    }

    public Drawable getTrackDrawable() {
        return this.b;
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f204a = drawable;
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(this.E.a(i));
    }

    public Drawable getThumbDrawable() {
        return this.f204a;
    }

    public void setSplitTrack(boolean z) {
        this.f = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.f;
    }

    public CharSequence getTextOn() {
        return this.g;
    }

    public void setTextOn(CharSequence charSequence) {
        this.g = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.h;
    }

    public void setTextOff(CharSequence charSequence) {
        this.h = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.i != z) {
            this.i = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.i;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (this.i) {
            if (this.z == null) {
                this.z = a(this.g);
            }
            if (this.A == null) {
                this.A = a(this.h);
            }
        }
        Rect rect = this.D;
        if (this.f204a != null) {
            this.f204a.getPadding(rect);
            i4 = (this.f204a.getIntrinsicWidth() - rect.left) - rect.right;
            i3 = this.f204a.getIntrinsicHeight();
        } else {
            i3 = 0;
            i4 = 0;
        }
        this.s = Math.max(this.i ? Math.max(this.z.getWidth(), this.A.getWidth()) + (this.c * 2) : 0, i4);
        if (this.b != null) {
            this.b.getPadding(rect);
            i5 = this.b.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i6 = rect.left;
        int i7 = rect.right;
        if (this.f204a != null) {
            Rect a2 = android.support.v7.internal.widget.n.a(this.f204a);
            i6 = Math.max(i6, a2.left);
            i7 = Math.max(i7, a2.right);
        }
        int max = Math.max(this.d, i7 + i6 + (this.s * 2));
        int max2 = Math.max(i5, i3);
        this.q = max;
        this.r = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(p.b(this), max2);
        }
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.g : this.h;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    private Layout a(CharSequence charSequence) {
        CharSequence transformation = this.B != null ? this.B.getTransformation(charSequence, this) : charSequence;
        return new StaticLayout(transformation, this.x, transformation != null ? (int) Math.ceil(Layout.getDesiredWidth(transformation, this.x)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean a(float f, float f2) {
        if (this.f204a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f204a.getPadding(this.D);
        int i = this.u - this.k;
        int i2 = (thumbOffset + this.t) - this.k;
        return f > ((float) i2) && f < ((float) ((((this.s + i2) + this.D.left) + this.D.right) + this.k)) && f2 > ((float) i) && f2 < ((float) (this.w + this.k));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:3:0x0011 A[FALL_THROUGH] */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r6 = 2
            r1 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            r2 = 1
            android.view.VelocityTracker r0 = r7.n
            r0.addMovement(r8)
            int r0 = android.support.v4.g.n.a(r8)
            switch(r0) {
                case 0: goto L16;
                case 1: goto La2;
                case 2: goto L31;
                case 3: goto La2;
                default: goto L11;
            }
        L11:
            boolean r0 = super.onTouchEvent(r8)
        L15:
            return r0
        L16:
            float r0 = r8.getX()
            float r1 = r8.getY()
            boolean r3 = r7.isEnabled()
            if (r3 == 0) goto L11
            boolean r3 = r7.a(r0, r1)
            if (r3 == 0) goto L11
            r7.j = r2
            r7.l = r0
            r7.m = r1
            goto L11
        L31:
            int r0 = r7.j
            switch(r0) {
                case 0: goto L11;
                case 1: goto L37;
                case 2: goto L6c;
                default: goto L36;
            }
        L36:
            goto L11
        L37:
            float r0 = r8.getX()
            float r1 = r8.getY()
            float r3 = r7.l
            float r3 = r0 - r3
            float r3 = java.lang.Math.abs(r3)
            int r4 = r7.k
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L5d
            float r3 = r7.m
            float r3 = r1 - r3
            float r3 = java.lang.Math.abs(r3)
            int r4 = r7.k
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L11
        L5d:
            r7.j = r6
            android.view.ViewParent r3 = r7.getParent()
            r3.requestDisallowInterceptTouchEvent(r2)
            r7.l = r0
            r7.m = r1
            r0 = r2
            goto L15
        L6c:
            float r3 = r8.getX()
            int r0 = r7.getThumbScrollRange()
            float r4 = r7.l
            float r4 = r3 - r4
            if (r0 == 0) goto L99
            float r0 = (float) r0
            float r0 = r4 / r0
        L7d:
            boolean r4 = android.support.v7.internal.widget.af.a(r7)
            if (r4 == 0) goto L84
            float r0 = -r0
        L84:
            float r4 = r7.p
            float r0 = r0 + r4
            float r0 = a(r0, r5, r1)
            float r1 = r7.p
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 == 0) goto L96
            r7.l = r3
            r7.setThumbPosition(r0)
        L96:
            r0 = r2
            goto L15
        L99:
            int r0 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r0 <= 0) goto L9f
            r0 = r1
            goto L7d
        L9f:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L7d
        La2:
            int r0 = r7.j
            if (r0 != r6) goto Laf
            r7.b(r8)
            super.onTouchEvent(r8)
            r0 = r2
            goto L15
        Laf:
            r0 = 0
            r7.j = r0
            android.view.VelocityTracker r0 = r7.n
            r0.clear()
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void b(MotionEvent motionEvent) {
        boolean z = true;
        this.j = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.n.computeCurrentVelocity(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED);
            float xVelocity = this.n.getXVelocity();
            if (Math.abs(xVelocity) > this.o) {
                if (af.a(this)) {
                    if (xVelocity >= 0.0f) {
                        z = false;
                    }
                } else if (xVelocity <= 0.0f) {
                    z = false;
                }
            } else {
                z = getTargetCheckedState();
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
            setChecked(z);
        }
        a(motionEvent);
    }

    private void a(boolean z) {
        float f = this.p;
        this.C = new k(this, f, (z ? 1.0f : 0.0f) - f);
        this.C.setDuration(250L);
        startAnimation(this.C);
    }

    private void a() {
        if (this.C != null) {
            clearAnimation();
            this.C = null;
        }
    }

    private boolean getTargetCheckedState() {
        return this.p > 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbPosition(float f) {
        this.p = f;
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && p.j(this)) {
            a(isChecked);
        } else {
            a();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int height;
        int i8;
        int i9 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f204a != null) {
            Rect rect = this.D;
            if (this.b != null) {
                this.b.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect a2 = android.support.v7.internal.widget.n.a(this.f204a);
            i5 = Math.max(0, a2.left - rect.left);
            i9 = Math.max(0, a2.right - rect.right);
        } else {
            i5 = 0;
        }
        if (af.a(this)) {
            int paddingLeft = getPaddingLeft() + i5;
            i7 = ((this.q + paddingLeft) - i5) - i9;
            i6 = paddingLeft;
        } else {
            int width = (getWidth() - getPaddingRight()) - i9;
            i6 = i9 + i5 + (width - this.q);
            i7 = width;
        }
        switch (getGravity() & 112) {
            case 16:
                i8 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.r / 2);
                height = this.r + i8;
                break;
            case 80:
                height = getHeight() - getPaddingBottom();
                i8 = height - this.r;
                break;
            default:
                i8 = getPaddingTop();
                height = this.r + i8;
                break;
        }
        this.t = i6;
        this.u = i8;
        this.w = height;
        this.v = i7;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i2;
        int i3;
        Rect rect2 = this.D;
        int i4 = this.t;
        int i5 = this.u;
        int i6 = this.v;
        int i7 = this.w;
        int thumbOffset = i4 + getThumbOffset();
        if (this.f204a != null) {
            rect = android.support.v7.internal.widget.n.a(this.f204a);
        } else {
            rect = android.support.v7.internal.widget.n.f181a;
        }
        if (this.b != null) {
            this.b.getPadding(rect2);
            int i8 = rect2.left + thumbOffset;
            if (rect == null || rect.isEmpty()) {
                i2 = i7;
                i3 = i5;
            } else {
                if (rect.left > rect2.left) {
                    i4 += rect.left - rect2.left;
                }
                i3 = rect.top > rect2.top ? (rect.top - rect2.top) + i5 : i5;
                if (rect.right > rect2.right) {
                    i6 -= rect.right - rect2.right;
                }
                i2 = rect.bottom > rect2.bottom ? i7 - (rect.bottom - rect2.bottom) : i7;
            }
            this.b.setBounds(i4, i3, i6, i2);
            i = i8;
        } else {
            i = thumbOffset;
        }
        if (this.f204a != null) {
            this.f204a.getPadding(rect2);
            int i9 = i - rect2.left;
            int i10 = i + this.s + rect2.right;
            this.f204a.setBounds(i9, i5, i10, i7);
            Drawable background = getBackground();
            if (background != null) {
                android.support.v4.b.a.a.a(background, i9, i5, i10, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.D;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.u;
        int i2 = this.w;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.f204a;
        if (drawable != null) {
            if (this.f && drawable2 != null) {
                Rect a2 = android.support.v7.internal.widget.n.a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a2.left;
                rect.right -= a2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.z : this.A;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.y != null) {
                this.x.setColor(this.y.getColorForState(drawableState, 0));
            }
            this.x.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.right + bounds.left;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!af.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.q;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.e;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (af.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.q;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.e;
        }
        return compoundPaddingRight;
    }

    private int getThumbOffset() {
        float f;
        if (af.a(this)) {
            f = 1.0f - this.p;
        } else {
            f = this.p;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        if (this.b != null) {
            Rect rect2 = this.D;
            this.b.getPadding(rect2);
            if (this.f204a != null) {
                rect = android.support.v7.internal.widget.n.a(this.f204a);
            } else {
                rect = android.support.v7.internal.widget.n.f181a;
            }
            return ((((this.q - this.s) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, F);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.f204a != null) {
            this.f204a.setState(drawableState);
        }
        if (this.b != null) {
            this.b.setState(drawableState);
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.f204a != null) {
            android.support.v4.b.a.a.a(this.f204a, f, f2);
        }
        if (this.b != null) {
            android.support.v4.b.a.a.a(this.b, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f204a || drawable == this.b;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f204a != null) {
                this.f204a.jumpToCurrentState();
            }
            if (this.b != null) {
                this.b.jumpToCurrentState();
            }
            if (this.C != null && !this.C.hasEnded()) {
                clearAnimation();
                this.C = null;
            }
        }
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.g : this.h;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    private static float a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }
}
