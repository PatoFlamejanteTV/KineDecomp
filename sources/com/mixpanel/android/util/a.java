package com.mixpanel.android.util;

import android.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

/* compiled from: ActivityImageUtils.java */
/* loaded from: classes.dex */
public class a {
    public static Bitmap a(Activity activity, int i, int i2, boolean z) {
        View rootView = activity.findViewById(R.id.content).getRootView();
        boolean isDrawingCacheEnabled = rootView.isDrawingCacheEnabled();
        rootView.setDrawingCacheEnabled(true);
        rootView.buildDrawingCache(true);
        Bitmap drawingCache = rootView.getDrawingCache();
        Bitmap bitmap = null;
        if (drawingCache != null && drawingCache.getWidth() > 0 && drawingCache.getHeight() > 0) {
            if (z) {
                i = drawingCache.getWidth() / i;
                i2 = drawingCache.getHeight() / i2;
            }
            if (i > 0 && i2 > 0) {
                try {
                    bitmap = Bitmap.createScaledBitmap(drawingCache, i, i2, false);
                } catch (OutOfMemoryError e) {
                    Log.i("MixpanelAPI.ActImgUtils", "Not enough memory to produce scaled image, returning a null screenshot");
                }
            }
        }
        if (!isDrawingCacheEnabled) {
            rootView.setDrawingCacheEnabled(false);
        }
        return bitmap;
    }

    public static int a(Activity activity) {
        int i = -16777216;
        Bitmap a2 = a(activity, 1, 1, false);
        if (a2 != null) {
            i = a2.getPixel(0, 0);
        }
        return a(i);
    }

    public static int a(Bitmap bitmap) {
        int i = -16777216;
        if (bitmap != null) {
            i = Bitmap.createScaledBitmap(bitmap, 1, 1, false).getPixel(0, 0);
        }
        return a(i);
    }

    public static int a(int i) {
        Color.colorToHSV(i, r0);
        float[] fArr = {0.0f, 0.0f, 0.3f};
        return Color.HSVToColor(242, fArr);
    }
}
