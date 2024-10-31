package com.nexstreaming.kinemaster.editorwrapper;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class qb implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f20349a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f20350b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20351c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qb(VideoEditor videoEditor, NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.f20351c = videoEditor;
        this.f20349a = nexVideoClipItem;
        this.f20350b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        NexVideoClipItem nexVideoClipItem;
        nexVideoClipItem = this.f20351c.W;
        if (nexVideoClipItem == this.f20349a) {
            this.f20351c.V = bitmap;
        }
        this.f20350b.sendResult(bitmap);
    }
}
