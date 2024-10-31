package com.nextreaming.nexeditorui.newproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: NewProjectActivity.java */
/* loaded from: classes.dex */
public class g implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a */
    final /* synthetic */ ImageView f4688a;
    final /* synthetic */ NewProjectActivity b;

    public g(NewProjectActivity newProjectActivity, ImageView imageView) {
        this.b = newProjectActivity;
        this.f4688a = imageView;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
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
            rect2.bottom = width2 + rect2.top;
        } else {
            int height = (int) (width * rect2.height());
            rect2.left = rect2.centerX() - (height / 2);
            rect2.right = height + rect2.left;
        }
        paint.setAntiAlias(true);
        int dimensionPixelOffset = this.b.getResources().getDimensionPixelOffset(R.dimen.getStarted_tray_item_round);
        canvas.drawRoundRect(rectF, dimensionPixelOffset, dimensionPixelOffset, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect2, rect, paint);
        if (this.f4688a != null) {
            this.f4688a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f4688a.setImageBitmap(createBitmap);
        }
    }
}
