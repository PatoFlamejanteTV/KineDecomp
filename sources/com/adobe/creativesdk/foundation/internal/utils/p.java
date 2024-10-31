package com.adobe.creativesdk.foundation.internal.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: BitMapUtil.java */
/* loaded from: classes.dex */
public class p {
    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() < 100 && bitmap.getHeight() < 100) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, true);
            Bitmap createBitmap2 = Bitmap.createBitmap(createScaledBitmap);
            Canvas canvas2 = new Canvas(createBitmap2);
            canvas2.drawColor(-1);
            canvas2.drawBitmap(createScaledBitmap, 0.0f, 0.0f, (Paint) null);
            canvas.drawBitmap(createBitmap2, i / 2, i2 / 2, (Paint) null);
            return createBitmap;
        }
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas3 = new Canvas(copy);
        canvas3.drawColor(-1);
        canvas3.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return copy;
    }
}
