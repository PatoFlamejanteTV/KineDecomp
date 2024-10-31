package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* compiled from: ThumbnailsImpl.java */
/* loaded from: classes.dex */
public class U implements T {

    /* renamed from: a */
    private final Bitmap f20720a;

    /* renamed from: b */
    private final int f20721b;

    /* renamed from: c */
    private final int f20722c;

    /* renamed from: d */
    private final int f20723d;

    /* renamed from: e */
    private final int[] f20724e;

    public U(Bitmap bitmap, int i, int i2, int[] iArr) {
        this.f20720a = bitmap;
        this.f20721b = i;
        this.f20722c = i2;
        this.f20724e = iArr;
        if (bitmap == null) {
            throw new RuntimeException("bm is null");
        }
        if (iArr != null) {
            if (this.f20721b == 0) {
                this.f20723d = iArr.length;
                return;
            } else {
                this.f20723d = Math.min(bitmap.getWidth() / this.f20721b, iArr.length);
                return;
            }
        }
        throw new RuntimeException("thumbnailTime is null");
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.T
    public float a(int i, float f2) {
        float f3;
        int i2;
        if (i != 90 && i != 270) {
            f3 = f2 / this.f20722c;
            i2 = this.f20721b;
        } else {
            f3 = f2 / this.f20721b;
            i2 = this.f20722c;
        }
        return f3 * i2;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.T
    public int b(int i) {
        return (i == 90 || i == 270) ? this.f20721b : this.f20722c;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.T
    public int c(int i) {
        return (i == 90 || i == 270) ? this.f20722c : this.f20721b;
    }

    private Bitmap c(int i, int i2, boolean z, boolean z2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f20723d; i5++) {
            int abs = Math.abs(this.f20724e[i5] - i2);
            if (i5 == 0 || abs < i4) {
                i3 = i5;
                i4 = abs;
            }
        }
        int i6 = this.f20721b;
        Rect rect = new Rect(i3 * i6, 0, (i3 * i6) + i6, this.f20722c);
        if (i == 180) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f20721b, this.f20722c, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            if (z && z2) {
                canvas.scale(-1.0f, -1.0f, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2);
            } else if (z) {
                canvas.scale(-1.0f, 1.0f, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2);
            } else if (z2) {
                canvas.scale(1.0f, -1.0f, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2);
            }
            canvas.drawBitmap(this.f20720a, rect, new Rect(0, 0, this.f20721b, this.f20722c), (Paint) null);
            return createBitmap;
        }
        if (i == 0) {
            Bitmap createBitmap2 = Bitmap.createBitmap(this.f20721b, this.f20722c, Bitmap.Config.RGB_565);
            Canvas canvas2 = new Canvas(createBitmap2);
            if (z && z2) {
                canvas2.scale(-1.0f, -1.0f, createBitmap2.getWidth() / 2, createBitmap2.getHeight() / 2);
            } else if (z) {
                canvas2.scale(-1.0f, 1.0f, createBitmap2.getWidth() / 2, createBitmap2.getHeight() / 2);
            } else if (z2) {
                canvas2.scale(1.0f, -1.0f, createBitmap2.getWidth() / 2, createBitmap2.getHeight() / 2);
            }
            canvas2.rotate(180.0f, this.f20721b / 2, this.f20722c / 2);
            canvas2.drawBitmap(this.f20720a, rect, new Rect(0, 0, this.f20721b, this.f20722c), (Paint) null);
            return createBitmap2;
        }
        if (i == 90) {
            Bitmap createBitmap3 = Bitmap.createBitmap(this.f20722c, this.f20721b, Bitmap.Config.RGB_565);
            Canvas canvas3 = new Canvas(createBitmap3);
            if (z && z2) {
                canvas3.scale(-1.0f, -1.0f, createBitmap3.getWidth() / 2, createBitmap3.getHeight() / 2);
            } else if (z) {
                canvas3.scale(1.0f, -1.0f, createBitmap3.getWidth() / 2, createBitmap3.getHeight() / 2);
            } else if (z2) {
                canvas3.scale(-1.0f, 1.0f, createBitmap3.getWidth() / 2, createBitmap3.getHeight() / 2);
            }
            canvas3.rotate(90.0f, 0.0f, 0.0f);
            canvas3.drawBitmap(this.f20720a, rect, new Rect(0, -this.f20722c, this.f20721b, 0), (Paint) null);
            return createBitmap3;
        }
        if (i != 270) {
            return null;
        }
        Bitmap createBitmap4 = Bitmap.createBitmap(this.f20722c, this.f20721b, Bitmap.Config.RGB_565);
        Canvas canvas4 = new Canvas(createBitmap4);
        if (z && z2) {
            canvas4.scale(-1.0f, -1.0f, createBitmap4.getWidth() / 2, createBitmap4.getHeight() / 2);
        } else if (z) {
            canvas4.scale(1.0f, -1.0f, createBitmap4.getWidth() / 2, createBitmap4.getHeight() / 2);
        } else if (z2) {
            canvas4.scale(-1.0f, 1.0f, createBitmap4.getWidth() / 2, createBitmap4.getHeight() / 2);
        }
        canvas4.rotate(270.0f, 0.0f, 0.0f);
        canvas4.drawBitmap(this.f20720a, rect, new Rect(-this.f20721b, 0, 0, this.f20722c), (Paint) null);
        return createBitmap4;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.T
    public Bitmap b(int i, int i2, boolean z, boolean z2) {
        return c(i, i2, z, z2);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.T
    public Bitmap a(int i, int i2, boolean z, boolean z2) {
        return c(i, i2, z, z2);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.T
    public int a(int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f20723d; i4++) {
            int abs = Math.abs(this.f20724e[i4] - i);
            if (i4 == 0 || abs < i3) {
                i2 = this.f20724e[i4];
                i3 = abs;
            }
        }
        return i2;
    }
}
