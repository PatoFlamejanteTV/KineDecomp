package com.nextreaming.nexvideoeditor;

import android.graphics.Rect;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
class l implements ResultTask.OnResultAvailableListener<Rect> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f4836a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f4836a = jVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Rect> resultTask, Task.Event event, Rect rect) {
        Task s;
        s = this.f4836a.c.s();
        s.setTimeout(500L).onComplete(new n(this)).onFailure(new m(this));
        this.f4836a.c.a(NexEditor.FastPreviewOption.nofx, 1, false);
    }
}
