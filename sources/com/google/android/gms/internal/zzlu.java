package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class zzlu extends ImageView {
    private int zzaeA;
    private zza zzaeB;
    private int zzaeC;
    private float zzaeD;
    private Uri zzaey;
    private int zzaez;

    /* loaded from: classes.dex */
    public interface zza {
        Path zzk(int i, int i2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.zzaeB != null) {
            canvas.clipPath(this.zzaeB.zzk(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzaeA != 0) {
            canvas.drawColor(this.zzaeA);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        int i3;
        super.onMeasure(i, i2);
        switch (this.zzaeC) {
            case 1:
                i3 = getMeasuredHeight();
                measuredWidth = (int) (i3 * this.zzaeD);
                break;
            case 2:
                measuredWidth = getMeasuredWidth();
                i3 = (int) (measuredWidth / this.zzaeD);
                break;
            default:
                return;
        }
        setMeasuredDimension(measuredWidth, i3);
    }

    public void zzbA(int i) {
        this.zzaez = i;
    }

    public void zzj(Uri uri) {
        this.zzaey = uri;
    }

    public int zzoH() {
        return this.zzaez;
    }
}
