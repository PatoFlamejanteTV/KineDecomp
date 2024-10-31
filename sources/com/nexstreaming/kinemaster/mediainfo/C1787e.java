package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1787e implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1788f f20739a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1787e(C1788f c1788f) {
        this.f20739a = c1788f;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        ResultTask resultTask2;
        ResultTask resultTask3;
        ResultTask resultTask4;
        if (bitmap != null) {
            resultTask3 = this.f20739a.f20740a.f20741a.G;
            resultTask3.setResult(bitmap);
            resultTask4 = this.f20739a.f20740a.f20741a.G;
            resultTask4.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
            return;
        }
        resultTask2 = this.f20739a.f20740a.f20741a.G;
        resultTask2.signalEvent(Task.Event.FAIL);
    }
}
