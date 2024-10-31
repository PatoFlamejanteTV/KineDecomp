package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.BaseAdapter;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ProjectAdapter.java */
/* loaded from: classes2.dex */
public class P extends BaseAdapter {
    public static Bitmap a(Bitmap bitmap, Resources resources, boolean z, boolean z2) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int dimensionPixelSize3;
        int dimensionPixelSize4;
        int dimensionPixelSize5;
        int dimensionPixelSize6;
        Shader shader;
        LinearGradient linearGradient;
        if (z) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_width);
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_height);
            dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_corner);
            dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_shadow_radius);
            dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_shadow_offset);
            dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_border);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_width);
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_height);
            dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_corner);
            dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_shadow_radius);
            dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_shadow_offset);
            dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_border);
        }
        int i = dimensionPixelSize5 + dimensionPixelSize4;
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        float f2 = dimensionPixelSize2;
        LinearGradient linearGradient2 = new LinearGradient(0.0f, dimensionPixelSize2 / 8, 0.0f, f2, 0, -872415232, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        Paint paint2 = new Paint();
        float f3 = dimensionPixelSize5;
        paint2.setShadowLayer(dimensionPixelSize4, f3, f3, 855638016);
        paint2.setColor(855638016);
        RectF rectF = new RectF();
        Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (bitmap == null) {
            float f4 = i;
            rectF.set(f4, f4, dimensionPixelSize - i, dimensionPixelSize2 - i);
            paint.setColor(469762048);
            float f5 = dimensionPixelSize3;
            canvas.drawRoundRect(rectF, f5, f5, paint);
            return createBitmap;
        }
        float f6 = i;
        float f7 = dimensionPixelSize - i;
        float f8 = dimensionPixelSize2 - i;
        rectF.set(f6, f6, f7, f8);
        float f9 = dimensionPixelSize3;
        canvas.drawRoundRect(rectF, f9, f9, paint2);
        float f10 = dimensionPixelSize;
        int i2 = dimensionPixelSize6;
        canvas.saveLayer(0.0f, 0.0f, f10, f2, null, 31);
        paint.setColor(-1);
        rectF.set(f6, f6, f7, f8);
        canvas.drawRoundRect(rectF, f9, f9, paint);
        paint.setXfermode(porterDuffXfermode);
        if (bitmap == null) {
            shader = null;
        } else {
            if (z2) {
                float height = (f2 / bitmap.getHeight()) * f2;
                float f11 = (f2 - height) / 2.0f;
                rectF.set(new RectF(rectF.left, f11, rectF.right, height + f11));
                canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
                linearGradient = linearGradient2;
                shader = null;
                paint.setShader(linearGradient);
                rectF.set(f6, f6, f7, f8);
                canvas.drawRoundRect(rectF, f9, f9, paint);
                paint.setShader(shader);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(i2);
                paint.setColor(553648127);
                float f12 = i + (i2 / 2);
                rectF.set(f12, f12, r15 - r1, r15 - r1);
                canvas.drawRoundRect(rectF, f9, f9, paint);
                paint.setStyle(Paint.Style.FILL);
                paint.setXfermode(null);
                canvas.restore();
                return createBitmap;
            }
            float width = ((bitmap.getWidth() * (((dimensionPixelSize3 * 2) + dimensionPixelSize2) - (i * 2))) / bitmap.getHeight()) - f10;
            rectF.set((-width) / 2.0f, -dimensionPixelSize3, f10 + (width / 2.0f), dimensionPixelSize2 + dimensionPixelSize3);
            shader = null;
            canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
        }
        linearGradient = linearGradient2;
        paint.setShader(linearGradient);
        rectF.set(f6, f6, f7, f8);
        canvas.drawRoundRect(rectF, f9, f9, paint);
        paint.setShader(shader);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(i2);
        paint.setColor(553648127);
        float f122 = i + (i2 / 2);
        rectF.set(f122, f122, r15 - r1, r15 - r1);
        canvas.drawRoundRect(rectF, f9, f9, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(null);
        canvas.restore();
        return createBitmap;
    }
}
