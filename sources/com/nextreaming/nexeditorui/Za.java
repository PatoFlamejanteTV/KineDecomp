package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class Za implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f24196a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24197b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Za(NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.f24197b = nexVideoClipItem;
        this.f24196a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        Bitmap createScaledBitmap;
        Bitmap bitmap2 = (bitmap.getWidth() <= 300 || (createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 300, (bitmap.getHeight() * 300) / bitmap.getWidth(), true)) == bitmap) ? bitmap : createScaledBitmap;
        if (this.f24197b.getRotation() != 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate(-this.f24197b.getRotation());
            bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
        }
        if (bitmap2 != null) {
            float f2 = ModuleDescriptor.MODULE_VERSION;
            int l = (int) (f2 / EditorGlobal.l());
            Bitmap createBitmap = Bitmap.createBitmap(ModuleDescriptor.MODULE_VERSION, l, Bitmap.Config.RGB_565);
            Rect rect = new Rect();
            float width = bitmap2.getWidth() / bitmap2.getHeight();
            if (width < EditorGlobal.l()) {
                int i = (int) (l * width);
                rect.top = 0;
                rect.bottom = l;
                rect.left = (320 - i) / 2;
                rect.right = (i + ModuleDescriptor.MODULE_VERSION) / 2;
            } else {
                int i2 = (int) (f2 / width);
                rect.left = 0;
                rect.right = ModuleDescriptor.MODULE_VERSION;
                rect.top = (l - i2) / 2;
                rect.bottom = (l + i2) / 2;
            }
            new Canvas(createBitmap).drawBitmap(bitmap2, (Rect) null, rect, (Paint) null);
            bitmap2 = createBitmap;
        }
        this.f24196a.setResult(bitmap2);
        this.f24196a.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
    }
}
