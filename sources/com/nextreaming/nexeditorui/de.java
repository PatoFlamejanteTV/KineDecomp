package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexImageLoader;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class de implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f4594a;
    final /* synthetic */ NexVideoClipItem b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.b = nexVideoClipItem;
        this.f4594a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        int i;
        boolean z;
        boolean z2;
        i = this.b.m_rotation;
        z = this.b.m_fliph;
        z2 = this.b.m_flipv;
        this.f4594a.sendResult(NexImageLoader.rotateAndFlipImage(bitmap, (360 - i) % 360, z, z2));
    }
}
