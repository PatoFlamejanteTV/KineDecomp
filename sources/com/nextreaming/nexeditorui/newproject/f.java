package com.nextreaming.nexeditorui.newproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import c.e.a.a.f;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewProjectActivity.java */
/* loaded from: classes3.dex */
public class f implements f.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageView f24367a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NewProjectActivity f24368b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewProjectActivity newProjectActivity, ImageView imageView) {
        this.f24368b = newProjectActivity;
        this.f24367a = imageView;
    }

    @Override // c.e.a.a.f.e
    public void a() {
    }

    @Override // c.e.a.a.f.e
    public void a(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(160, 90, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, 160, 90);
        Rect rect2 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float width = rect.width() / rect.height();
        if (rect2.width() / rect2.height() < width) {
            int width2 = (int) (rect2.width() / width);
            rect2.top = rect2.centerY() - (width2 / 2);
            rect2.bottom = rect2.top + width2;
        } else {
            int height = (int) (rect2.height() * width);
            rect2.left = rect2.centerX() - (height / 2);
            rect2.right = rect2.left + height;
        }
        paint.setAntiAlias(true);
        float dimensionPixelOffset = this.f24368b.getResources().getDimensionPixelOffset(R.dimen.getStarted_tray_item_round);
        canvas.drawRoundRect(rectF, dimensionPixelOffset, dimensionPixelOffset, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect2, rect, paint);
        ImageView imageView = this.f24367a;
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f24367a.setImageBitmap(createBitmap);
        }
    }
}
