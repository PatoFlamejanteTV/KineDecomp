package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* compiled from: ThumbnailConversionTask.java */
/* loaded from: classes.dex */
public class P implements N {

    /* renamed from: a */
    int f20704a;

    /* renamed from: b */
    int f20705b;

    /* renamed from: c */
    int f20706c;

    /* renamed from: d */
    int f20707d;

    /* renamed from: e */
    Bitmap f20708e;

    /* renamed from: f */
    Canvas f20709f;

    /* renamed from: g */
    Rect f20710g;

    /* renamed from: h */
    Paint f20711h;
    final /* synthetic */ Q i;

    public P(Q q) {
        this.i = q;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.N
    public void a(Bitmap bitmap, int i, int i2, int i3, int i4, int i5) {
        int[] iArr;
        if (i3 == 0) {
            this.f20707d = 90;
            this.f20706c = (i * 90) / i2;
            this.f20704a = this.f20707d;
            this.f20705b = this.f20706c * i4;
            this.f20708e = Bitmap.createBitmap(this.f20705b, this.f20704a, Bitmap.Config.RGB_565);
            this.i.f20717f = this.f20708e;
            this.f20709f = new Canvas(this.f20708e);
            this.f20710g = new Rect(0, 0, this.f20706c, this.f20707d);
            this.f20711h = new Paint();
            this.f20711h.setFilterBitmap(true);
            this.i.i = new int[i4];
        }
        iArr = this.i.i;
        iArr[i3] = i5;
        if (bitmap == null) {
            this.f20710g.offset(this.f20706c, 0);
            return;
        }
        if (i3 == 0) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, new Rect(0, 0, i, i2), this.f20711h);
            this.i.f20718g = createBitmap;
        } else if (i3 == i4 - 1) {
            Bitmap createBitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
            new Canvas(createBitmap2).drawBitmap(bitmap, (Rect) null, new Rect(0, 0, i, i2), this.f20711h);
            this.i.f20719h = createBitmap2;
        }
        this.f20709f.save();
        this.f20709f.scale(-1.0f, -1.0f, this.f20706c / 2, this.f20707d / 2);
        this.f20709f.drawBitmap(bitmap, (Rect) null, this.f20710g, this.f20711h);
        this.f20709f.restore();
        this.f20709f.translate(this.f20706c, 0.0f);
    }
}
