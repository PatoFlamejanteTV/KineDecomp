package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: assets/audience_network.dex */
public final class K2 extends Drawable {
    public int A00;
    public int A01;
    public Path A02;
    public Rect A03 = new Rect();
    public final Paint A04 = new Paint();

    public K2(int i) {
        this.A04.setColor(i);
        this.A04.setAntiAlias(true);
    }

    private void A00() {
        this.A02 = new Path();
        this.A02.setFillType(Path.FillType.EVEN_ODD);
        this.A02.moveTo(20.0f, 20.0f);
        this.A02.rLineTo(40.0f, 0.0f);
        this.A02.rLineTo(-20.0f, -20.0f);
        this.A02.rLineTo(-20.0f, 20.0f);
        this.A02.close();
    }

    public final void A01(int i, int i2, int i3, int i4) {
        this.A03.left = i;
        this.A03.top = i2;
        this.A03.right = i3;
        this.A03.bottom = i4;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.drawRoundRect(new RectF(0.0f, 20.0f, this.A01, this.A00), 20.0f, 20.0f, this.A04);
        A00();
        canvas.drawPath(this.A02, this.A04);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        rect.set(this.A03);
        rect.top += 20;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.A01 = rect.width();
        this.A00 = getBounds().height();
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.A04.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.A04.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
