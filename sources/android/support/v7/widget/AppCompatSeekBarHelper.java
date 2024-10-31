package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* loaded from: classes.dex */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {

    /* renamed from: d */
    private final SeekBar f2655d;

    /* renamed from: e */
    private Drawable f2656e;

    /* renamed from: f */
    private ColorStateList f2657f;

    /* renamed from: g */
    private PorterDuff.Mode f2658g;

    /* renamed from: h */
    private boolean f2659h;
    private boolean i;

    public AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.f2657f = null;
        this.f2658g = null;
        this.f2659h = false;
        this.i = false;
        this.f2655d = seekBar;
    }

    private void d() {
        if (this.f2656e != null) {
            if (this.f2659h || this.i) {
                this.f2656e = DrawableCompat.wrap(this.f2656e.mutate());
                if (this.f2659h) {
                    DrawableCompat.setTintList(this.f2656e, this.f2657f);
                }
                if (this.i) {
                    DrawableCompat.setTintMode(this.f2656e, this.f2658g);
                }
                if (this.f2656e.isStateful()) {
                    this.f2656e.setState(this.f2655d.getDrawableState());
                }
            }
        }
    }

    @Override // android.support.v7.widget.AppCompatProgressBarHelper
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f2655d.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.f2655d.setThumb(drawableIfKnown);
        }
        a(obtainStyledAttributes.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f2658g = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f2658g);
            this.i = true;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f2657f = obtainStyledAttributes.getColorStateList(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f2659h = true;
        }
        obtainStyledAttributes.recycle();
        d();
    }

    public void b() {
        Drawable drawable = this.f2656e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f2655d.getDrawableState())) {
            this.f2655d.invalidateDrawable(drawable);
        }
    }

    public void c() {
        Drawable drawable = this.f2656e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void a(Drawable drawable) {
        Drawable drawable2 = this.f2656e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2656e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f2655d);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.f2655d));
            if (drawable.isStateful()) {
                drawable.setState(this.f2655d.getDrawableState());
            }
            d();
        }
        this.f2655d.invalidate();
    }

    public void a(Canvas canvas) {
        if (this.f2656e != null) {
            int max = this.f2655d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f2656e.getIntrinsicWidth();
                int intrinsicHeight = this.f2656e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f2656e.setBounds(-i, -i2, i, i2);
                float width = ((this.f2655d.getWidth() - this.f2655d.getPaddingLeft()) - this.f2655d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f2655d.getPaddingLeft(), this.f2655d.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f2656e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
