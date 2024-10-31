package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexImageLoader;

/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
class dp implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f4605a;
    final /* synthetic */ NexVideoClipItem b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.b = nexVideoClipItem;
        this.f4605a = resultTask;
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
        this.f4605a.sendResult(NexImageLoader.rotateAndFlipImage(bitmap, (360 - i) % 360, z, z2));
    }
}
