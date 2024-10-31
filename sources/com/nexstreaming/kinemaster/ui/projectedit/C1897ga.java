package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ColorPickerDrawable.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ga */
/* loaded from: classes2.dex */
public class C1897ga extends Drawable {

    /* renamed from: c */
    private final int f22342c;

    /* renamed from: d */
    private final int f22343d;

    /* renamed from: f */
    private int f22345f;

    /* renamed from: g */
    private int f22346g;

    /* renamed from: h */
    private int f22347h;
    private int i;

    /* renamed from: a */
    private int f22340a = 255;

    /* renamed from: b */
    private ColorFilter f22341b = null;

    /* renamed from: e */
    private Paint f22344e = new Paint();

    public C1897ga(Context context, int i) {
        this.f22342c = context.getResources().getDimensionPixelOffset(R.dimen.colorpicker_drawable_width);
        this.f22343d = context.getResources().getDimensionPixelOffset(R.dimen.colorpicker_drawable_height);
        this.f22345f = i;
        this.f22344e.setAntiAlias(true);
        this.f22344e.setStyle(Paint.Style.FILL);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f22344e.setColorFilter(this.f22341b);
        this.f22344e.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawCircle(this.f22346g, this.f22347h, this.i, this.f22344e);
        this.f22344e.setColorFilter(null);
        this.f22344e.setColor(this.f22345f);
        canvas.drawCircle(this.f22346g, this.f22347h, (this.i * 55) / 75, this.f22344e);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f22343d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f22342c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f22346g = rect.centerX();
        this.f22347h = rect.centerY();
        this.i = Math.min(rect.width(), rect.height()) / 2;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f22340a = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f22341b = colorFilter;
        invalidateSelf();
    }

    public C1897ga(Context context, int i, boolean z) {
        this.f22342c = context.getResources().getDimensionPixelOffset(z ? R.dimen.colorpicker_drawable_width_large : R.dimen.colorpicker_drawable_width);
        this.f22343d = context.getResources().getDimensionPixelOffset(z ? R.dimen.colorpicker_drawable_height_large : R.dimen.colorpicker_drawable_height);
        this.f22345f = i;
        this.f22344e.setAntiAlias(true);
        this.f22344e.setStyle(Paint.Style.FILL);
    }
}
