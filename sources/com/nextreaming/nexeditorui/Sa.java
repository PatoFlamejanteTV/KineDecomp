package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexImageLoader;

/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
class Sa implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f24170a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24171b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sa(NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.f24171b = nexVideoClipItem;
        this.f24170a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        int i;
        boolean z;
        boolean z2;
        i = this.f24171b.m_rotation;
        z = this.f24171b.m_fliph;
        z2 = this.f24171b.m_flipv;
        this.f24170a.sendResult(NexImageLoader.rotateAndFlipImage(bitmap, (360 - i) % 360, z, z2));
    }
}
