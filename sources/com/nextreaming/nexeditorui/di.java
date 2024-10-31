package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class di implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f4598a;
    final /* synthetic */ NexVideoClipItem b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.b = nexVideoClipItem;
        this.f4598a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        if (bitmap.getWidth() <= 300 || (bitmap2 = Bitmap.createScaledBitmap(bitmap, 300, (bitmap.getHeight() * 300) / bitmap.getWidth(), true)) == bitmap) {
            bitmap2 = bitmap;
        }
        if (this.b.getRotation() != 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate(-this.b.getRotation());
            bitmap3 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
        } else {
            bitmap3 = bitmap2;
        }
        if (bitmap3 != null) {
            int i = (int) (320 / 1.7777778f);
            bitmap4 = Bitmap.createBitmap(320, i, Bitmap.Config.RGB_565);
            Rect rect = new Rect();
            float width = bitmap3.getWidth() / bitmap3.getHeight();
            if (width < 1.7777778f) {
                int i2 = (int) (width * i);
                rect.top = 0;
                rect.bottom = i;
                rect.left = (320 - i2) / 2;
                rect.right = (320 + i2) / 2;
            } else {
                int i3 = (int) (320 / width);
                rect.left = 0;
                rect.right = 320;
                rect.top = (i - i3) / 2;
                rect.bottom = (i + i3) / 2;
            }
            new Canvas(bitmap4).drawBitmap(bitmap3, (Rect) null, rect, (Paint) null);
        } else {
            bitmap4 = bitmap3;
        }
        this.f4598a.setResult(bitmap4);
        this.f4598a.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
    }
}
