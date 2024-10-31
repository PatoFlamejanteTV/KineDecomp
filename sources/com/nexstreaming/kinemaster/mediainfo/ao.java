package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThumbnailConversionTask.java */
/* loaded from: classes.dex */
public class ao implements al {

    /* renamed from: a, reason: collision with root package name */
    int f3497a;
    int b;
    Bitmap c;
    Canvas d;
    Rect e;
    Paint f;
    final /* synthetic */ an g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.g = anVar;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.al
    public void a(Bitmap bitmap, int i, int i2, int i3) {
        int[] iArr;
        if (i == 0) {
            this.f3497a = 90;
            this.b = i2 * 160;
            this.c = Bitmap.createBitmap(this.b, this.f3497a, Bitmap.Config.RGB_565);
            this.g.f = this.c;
            this.d = new Canvas(this.c);
            this.e = new Rect(0, 0, 160, 90);
            this.f = new Paint();
            this.f.setFilterBitmap(true);
            this.g.i = new int[i2];
        }
        iArr = this.g.i;
        iArr[i] = i3;
        if (bitmap == null) {
            this.e.offset(160, 0);
            return;
        }
        if (i == 0) {
            Bitmap createBitmap = Bitmap.createBitmap(640, 360, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, new Rect(0, 0, 640, 360), this.f);
            this.g.g = createBitmap;
        } else if (i == i2 - 1) {
            Bitmap createBitmap2 = Bitmap.createBitmap(640, 360, Bitmap.Config.RGB_565);
            new Canvas(createBitmap2).drawBitmap(bitmap, (Rect) null, new Rect(0, 0, 640, 360), this.f);
            this.g.h = createBitmap2;
        }
        this.d.save();
        this.d.scale(-1.0f, -1.0f, 80.0f, 45.0f);
        this.d.drawBitmap(bitmap, (Rect) null, this.e, this.f);
        this.d.restore();
        this.d.translate(160.0f, 0.0f);
    }
}
