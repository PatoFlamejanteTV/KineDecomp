package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* compiled from: ThumbnailsImpl.java */
/* loaded from: classes.dex */
public class ar implements aq {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap f3498a;
    private final int b;
    private final int c;
    private final int d;
    private final int[] e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(Bitmap bitmap, int i, int i2, int[] iArr) {
        this.f3498a = bitmap;
        this.b = i;
        this.c = i2;
        this.e = iArr;
        if (bitmap == null) {
            throw new RuntimeException("bm is null");
        }
        if (iArr == null) {
            throw new RuntimeException("thumbnailTime is null");
        }
        this.d = Math.min(bitmap.getWidth() / this.b, iArr.length);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.aq
    public int b(int i) {
        return (i == 90 || i == 270) ? this.c : this.b;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.aq
    public int c(int i) {
        return (i == 90 || i == 270) ? this.b : this.c;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.aq
    public float a(int i, float f) {
        return (i == 90 || i == 270) ? (f / this.b) * this.c : (f / this.c) * this.b;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.aq
    public Bitmap a(int i, int i2, boolean z, boolean z2) {
        return c(i, i2, z, z2);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.aq
    public Bitmap b(int i, int i2, boolean z, boolean z2) {
        return c(i, i2, z, z2);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.aq
    public int a(int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.d; i4++) {
            int abs = Math.abs(this.e[i4] - i);
            if (i4 == 0 || abs < i3) {
                i2 = this.e[i4];
                i3 = abs;
            }
        }
        return i2;
    }

    private Bitmap c(int i, int i2, boolean z, boolean z2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.d; i5++) {
            int abs = Math.abs(this.e[i5] - i2);
            if (i5 == 0 || abs < i4) {
                i3 = i5;
                i4 = abs;
            }
        }
        Rect rect = new Rect(this.b * i3, 0, (i3 * this.b) + this.b, this.c);
        if (i == 180) {
            Bitmap createBitmap = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            if (z && z2) {
                canvas.scale(-1.0f, -1.0f, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2);
            } else if (z) {
                canvas.scale(-1.0f, 1.0f, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2);
            } else if (z2) {
                canvas.scale(1.0f, -1.0f, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2);
            }
            canvas.drawBitmap(this.f3498a, rect, new Rect(0, 0, this.b, this.c), (Paint) null);
            return createBitmap;
        }
        if (i == 0) {
            Bitmap createBitmap2 = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.RGB_565);
            Canvas canvas2 = new Canvas(createBitmap2);
            if (z && z2) {
                canvas2.scale(-1.0f, -1.0f, createBitmap2.getWidth() / 2, createBitmap2.getHeight() / 2);
            } else if (z) {
                canvas2.scale(-1.0f, 1.0f, createBitmap2.getWidth() / 2, createBitmap2.getHeight() / 2);
            } else if (z2) {
                canvas2.scale(1.0f, -1.0f, createBitmap2.getWidth() / 2, createBitmap2.getHeight() / 2);
            }
            canvas2.rotate(180.0f, this.b / 2, this.c / 2);
            canvas2.drawBitmap(this.f3498a, rect, new Rect(0, 0, this.b, this.c), (Paint) null);
            return createBitmap2;
        }
        if (i == 90) {
            Bitmap createBitmap3 = Bitmap.createBitmap(this.c, this.b, Bitmap.Config.RGB_565);
            Canvas canvas3 = new Canvas(createBitmap3);
            if (z && z2) {
                canvas3.scale(-1.0f, -1.0f, createBitmap3.getWidth() / 2, createBitmap3.getHeight() / 2);
            } else if (z) {
                canvas3.scale(1.0f, -1.0f, createBitmap3.getWidth() / 2, createBitmap3.getHeight() / 2);
            } else if (z2) {
                canvas3.scale(-1.0f, 1.0f, createBitmap3.getWidth() / 2, createBitmap3.getHeight() / 2);
            }
            canvas3.rotate(90.0f, 0.0f, 0.0f);
            canvas3.drawBitmap(this.f3498a, rect, new Rect(0, -this.c, this.b, 0), (Paint) null);
            return createBitmap3;
        }
        if (i != 270) {
            return null;
        }
        Bitmap createBitmap4 = Bitmap.createBitmap(this.c, this.b, Bitmap.Config.RGB_565);
        Canvas canvas4 = new Canvas(createBitmap4);
        if (z && z2) {
            canvas4.scale(-1.0f, -1.0f, createBitmap4.getWidth() / 2, createBitmap4.getHeight() / 2);
        } else if (z) {
            canvas4.scale(1.0f, -1.0f, createBitmap4.getWidth() / 2, createBitmap4.getHeight() / 2);
        } else if (z2) {
            canvas4.scale(-1.0f, 1.0f, createBitmap4.getWidth() / 2, createBitmap4.getHeight() / 2);
        }
        canvas4.rotate(270.0f, 0.0f, 0.0f);
        canvas4.drawBitmap(this.f3498a, rect, new Rect(-this.b, 0, 0, this.c), (Paint) null);
        return createBitmap4;
    }
}
