package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: StrokeSizeDrawable.java */
/* loaded from: classes2.dex */
public class Yg extends Drawable {

    /* renamed from: c */
    private final int f22185c;

    /* renamed from: d */
    private final int f22186d;

    /* renamed from: f */
    private float f22188f;

    /* renamed from: g */
    private int f22189g;

    /* renamed from: h */
    private int f22190h;
    private int i;

    /* renamed from: a */
    private int f22183a = 255;

    /* renamed from: b */
    private ColorFilter f22184b = null;

    /* renamed from: e */
    private Paint f22187e = new Paint();

    public Yg(Context context, float f2) {
        this.f22185c = context.getResources().getDimensionPixelOffset(R.dimen.colorpicker_drawable_width);
        this.f22186d = context.getResources().getDimensionPixelOffset(R.dimen.colorpicker_drawable_height);
        this.f22188f = f2;
        this.f22187e.setAntiAlias(true);
        this.f22187e.setStyle(Paint.Style.FILL);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f22187e.setColorFilter(this.f22184b);
        this.f22187e.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawCircle(this.f22189g, this.f22190h, this.i, this.f22187e);
        this.f22187e.setColorFilter(null);
        this.f22187e.setColor(-1);
        canvas.drawCircle(this.f22189g, this.f22190h, this.f22188f / 2.0f, this.f22187e);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f22186d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f22185c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f22189g = rect.centerX();
        this.f22190h = rect.centerY();
        this.i = Math.min(rect.width(), rect.height()) / 2;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f22183a = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f22184b = colorFilter;
        invalidateSelf();
    }
}
