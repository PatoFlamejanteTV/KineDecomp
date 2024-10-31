package com.github.ybq.android.spinkit.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;

/* compiled from: ShapeSprite.java */
/* loaded from: classes.dex */
public abstract class e extends q {
    private Paint E;
    private int F;
    private int G;

    public e() {
        b(-1);
        this.E = new Paint();
        this.E.setAntiAlias(true);
        this.E.setColor(this.F);
    }

    private void r() {
        int alpha = getAlpha();
        int i = this.G;
        this.F = ((((i >>> 24) * (alpha + (alpha >> 7))) >> 8) << 24) | ((i << 8) >>> 8);
    }

    @Override // com.github.ybq.android.spinkit.b.q
    public int a() {
        return this.G;
    }

    public abstract void a(Canvas canvas, Paint paint);

    @Override // com.github.ybq.android.spinkit.b.q
    public void b(int i) {
        this.G = i;
        r();
    }

    @Override // com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        r();
    }

    @Override // com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.E.setColorFilter(colorFilter);
    }

    @Override // com.github.ybq.android.spinkit.b.q
    protected final void a(Canvas canvas) {
        this.E.setColor(this.F);
        a(canvas, this.E);
    }
}
