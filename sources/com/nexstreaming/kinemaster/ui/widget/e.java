package com.nexstreaming.kinemaster.ui.widget;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.widget.ImageCyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageCyclerView.java */
/* loaded from: classes.dex */
public class e implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageCyclerView.a f4389a;
    final /* synthetic */ ImageCyclerView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ImageCyclerView imageCyclerView, ImageCyclerView.a aVar) {
        this.b = imageCyclerView;
        this.f4389a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        Bitmap a2;
        this.f4389a.f4376a = bitmap;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 8, bitmap.getHeight() / 8, true);
        ImageCyclerView.a aVar = this.f4389a;
        a2 = this.b.a(createScaledBitmap, 10.0f);
        aVar.b = a2;
    }
}
