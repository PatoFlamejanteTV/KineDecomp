package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class g implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f3504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f3504a = fVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        ResultTask resultTask2;
        ResultTask resultTask3;
        ResultTask resultTask4;
        if (bitmap != null) {
            resultTask3 = this.f3504a.f3503a.f3501a.p;
            resultTask3.setResult(bitmap);
            resultTask4 = this.f3504a.f3503a.f3501a.p;
            resultTask4.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
            return;
        }
        resultTask2 = this.f3504a.f3503a.f3501a.p;
        resultTask2.signalEvent(Task.Event.FAIL);
    }
}
