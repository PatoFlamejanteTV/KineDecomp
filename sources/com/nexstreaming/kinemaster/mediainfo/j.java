package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class j implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f3507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f3507a = iVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        ResultTask resultTask2;
        ResultTask resultTask3;
        ResultTask resultTask4;
        if (bitmap != null) {
            resultTask3 = this.f3507a.f3506a.f3505a.q;
            resultTask3.setResult(bitmap);
            resultTask4 = this.f3507a.f3506a.f3505a.q;
            resultTask4.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
            return;
        }
        resultTask2 = this.f3507a.f3506a.f3505a.q;
        resultTask2.signalEvent(Task.Event.FAIL);
    }
}
