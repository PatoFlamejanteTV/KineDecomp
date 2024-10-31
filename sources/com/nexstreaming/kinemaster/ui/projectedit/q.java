package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ColorPickerDrawable.java */
/* loaded from: classes.dex */
public class q extends Drawable {
    private final int c;
    private final int d;
    private int f;
    private int g;
    private int h;
    private int i;

    /* renamed from: a, reason: collision with root package name */
    private int f4112a = 255;
    private ColorFilter b = null;
    private Paint e = new Paint();

    public q(Context context, int i) {
        this.c = context.getResources().getDimensionPixelOffset(R.dimen.colorpicker_drawable_width);
        this.d = context.getResources().getDimensionPixelOffset(R.dimen.colorpicker_drawable_height);
        this.f = i;
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
    }

    public q(Context context, int i, boolean z) {
        this.c = context.getResources().getDimensionPixelOffset(z ? R.dimen.colorpicker_drawable_width_large : R.dimen.colorpicker_drawable_width);
        this.d = context.getResources().getDimensionPixelOffset(z ? R.dimen.colorpicker_drawable_height_large : R.dimen.colorpicker_drawable_height);
        this.f = i;
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.g = rect.centerX();
        this.h = rect.centerY();
        this.i = Math.min(rect.width(), rect.height()) / 2;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.e.setColorFilter(this.b);
        this.e.setColor(-16777216);
        canvas.drawCircle(this.g, this.h, this.i, this.e);
        this.e.setColorFilter(null);
        this.e.setColor(this.f);
        canvas.drawCircle(this.g, this.h, (this.i * 55) / 75, this.e);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f4112a = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.c;
    }
}
