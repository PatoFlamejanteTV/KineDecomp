package com.nexstreaming.kinemaster.editorwrapper;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class ck implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f3364a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ VideoEditor c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(VideoEditor videoEditor, NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.c = videoEditor;
        this.f3364a = nexVideoClipItem;
        this.b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        NexVideoClipItem nexVideoClipItem;
        nexVideoClipItem = this.c.Q;
        if (nexVideoClipItem == this.f3364a) {
            this.c.P = bitmap;
        }
        this.b.sendResult(bitmap);
    }
}
