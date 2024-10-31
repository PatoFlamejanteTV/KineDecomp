package com.getbase.floatingactionbutton;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.TextView;

/* loaded from: classes.dex */
public class FloatingActionButton extends ImageButton {

    /* renamed from: a */
    int f9824a;

    /* renamed from: b */
    int f9825b;

    /* renamed from: c */
    int f9826c;

    /* renamed from: d */
    String f9827d;

    /* renamed from: e */
    private int f9828e;

    /* renamed from: f */
    private Drawable f9829f;

    /* renamed from: g */
    private int f9830g;

    /* renamed from: h */
    private float f9831h;
    private float i;
    private float j;
    private int k;
    boolean l;

    /* loaded from: classes.dex */
    public static class a extends LayerDrawable {

        /* renamed from: a */
        private final int f9832a;

        public a(int i, Drawable... drawableArr) {
            super(drawableArr);
            this.f9832a = i;
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, this.f9832a, 31);
            super.draw(canvas);
            canvas.restore();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private void b() {
        this.f9831h = b(this.f9830g == 0 ? g.fab_size_normal : g.fab_size_mini);
    }

    private int c(float f2) {
        return (int) (f2 * 255.0f);
    }

    private void c() {
        this.k = (int) (this.f9831h + (this.i * 2.0f));
    }

    private int d(int i) {
        return Color.argb(Color.alpha(i) / 2, Color.red(i), Color.green(i), Color.blue(i));
    }

    private int e(int i) {
        return a(i, 1.1f);
    }

    private int f(int i) {
        return Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }

    @SuppressLint({"NewApi"})
    private void setBackgroundCompat(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    public void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.FloatingActionButton, 0, 0);
        this.f9824a = obtainStyledAttributes.getColor(j.FloatingActionButton_fab_colorNormal, a(R.color.holo_blue_dark));
        this.f9825b = obtainStyledAttributes.getColor(j.FloatingActionButton_fab_colorPressed, a(R.color.holo_blue_light));
        this.f9826c = obtainStyledAttributes.getColor(j.FloatingActionButton_fab_colorDisabled, a(R.color.darker_gray));
        this.f9830g = obtainStyledAttributes.getInt(j.FloatingActionButton_fab_size, 0);
        this.f9828e = obtainStyledAttributes.getResourceId(j.FloatingActionButton_fab_icon, 0);
        this.f9827d = obtainStyledAttributes.getString(j.FloatingActionButton_fab_title);
        this.l = obtainStyledAttributes.getBoolean(j.FloatingActionButton_fab_stroke_visible, true);
        obtainStyledAttributes.recycle();
        b();
        this.i = b(g.fab_shadow_radius);
        this.j = b(g.fab_shadow_offset);
        c();
        a();
    }

    public int getColorDisabled() {
        return this.f9826c;
    }

    public int getColorNormal() {
        return this.f9824a;
    }

    public int getColorPressed() {
        return this.f9825b;
    }

    Drawable getIconDrawable() {
        Drawable drawable = this.f9829f;
        if (drawable != null) {
            return drawable;
        }
        if (this.f9828e != 0) {
            return getResources().getDrawable(this.f9828e);
        }
        return new ColorDrawable(0);
    }

    TextView getLabelView() {
        return (TextView) getTag(i.fab_label);
    }

    public int getSize() {
        return this.f9830g;
    }

    public String getTitle() {
        return this.f9827d;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.k;
        setMeasuredDimension(i3, i3);
    }

    public void setColorDisabled(int i) {
        if (this.f9826c != i) {
            this.f9826c = i;
            a();
        }
    }

    public void setColorDisabledResId(int i) {
        setColorDisabled(a(i));
    }

    public void setColorNormal(int i) {
        if (this.f9824a != i) {
            this.f9824a = i;
            a();
        }
    }

    public void setColorNormalResId(int i) {
        setColorNormal(a(i));
    }

    public void setColorPressed(int i) {
        if (this.f9825b != i) {
            this.f9825b = i;
            a();
        }
    }

    public void setColorPressedResId(int i) {
        setColorPressed(a(i));
    }

    public void setIcon(int i) {
        if (this.f9828e != i) {
            this.f9828e = i;
            this.f9829f = null;
            a();
        }
    }

    public void setIconDrawable(Drawable drawable) {
        if (this.f9829f != drawable) {
            this.f9828e = 0;
            this.f9829f = drawable;
            a();
        }
    }

    public void setSize(int i) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("Use @FAB_SIZE constants only!");
        }
        if (this.f9830g != i) {
            this.f9830g = i;
            b();
            c();
            a();
        }
    }

    public void setStrokeVisible(boolean z) {
        if (this.l != z) {
            this.l = z;
            a();
        }
    }

    public void setTitle(String str) {
        this.f9827d = str;
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i);
        }
        super.setVisibility(i);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private int c(int i) {
        return a(i, 0.9f);
    }

    public float b(int i) {
        return getResources().getDimension(i);
    }

    private Drawable b(int i, float f2) {
        int alpha = Color.alpha(i);
        int f3 = f(i);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setColor(f3);
        Drawable[] drawableArr = {shapeDrawable, c(f3, f2)};
        LayerDrawable layerDrawable = (alpha == 255 || !this.l) ? new LayerDrawable(drawableArr) : new a(alpha, drawableArr);
        int i2 = (int) (f2 / 2.0f);
        layerDrawable.setLayerInset(1, i2, i2, i2, i2);
        return layerDrawable;
    }

    private Drawable c(int i, float f2) {
        if (!this.l) {
            return new ColorDrawable(0);
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        int c2 = c(i);
        int d2 = d(c2);
        int e2 = e(i);
        int d3 = d(e2);
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f2);
        paint.setStyle(Paint.Style.STROKE);
        shapeDrawable.setShaderFactory(new c(this, e2, d3, i, d2, c2));
        return shapeDrawable;
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private Drawable b(float f2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setAlpha(c(0.02f));
        return shapeDrawable;
    }

    public int a(int i) {
        return getResources().getColor(i);
    }

    public void a() {
        float b2 = b(g.fab_stroke_width);
        float f2 = b2 / 2.0f;
        Drawable[] drawableArr = new Drawable[4];
        drawableArr[0] = getResources().getDrawable(this.f9830g == 0 ? h.fab_bg_normal : h.fab_bg_mini);
        drawableArr[1] = a(b2);
        drawableArr[2] = b(b2);
        drawableArr[3] = getIconDrawable();
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        int b3 = ((int) (this.f9831h - b(g.fab_icon_size))) / 2;
        float f3 = this.i;
        int i = (int) f3;
        float f4 = this.j;
        int i2 = (int) (f3 - f4);
        int i3 = (int) (f3 + f4);
        layerDrawable.setLayerInset(1, i, i2, i, i3);
        int i4 = (int) (i - f2);
        layerDrawable.setLayerInset(2, i4, (int) (i2 - f2), i4, (int) (i3 - f2));
        int i5 = i + b3;
        layerDrawable.setLayerInset(3, i5, i2 + b3, i5, i3 + b3);
        setBackgroundCompat(layerDrawable);
    }

    private StateListDrawable a(float f2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, b(this.f9826c, f2));
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, b(this.f9825b, f2));
        stateListDrawable.addState(new int[0], b(this.f9824a, f2));
        return stateListDrawable;
    }

    private int a(int i, float f2) {
        Color.colorToHSV(i, r0);
        float[] fArr = {0.0f, 0.0f, Math.min(fArr[2] * f2, 1.0f)};
        return Color.HSVToColor(Color.alpha(i), fArr);
    }
}
