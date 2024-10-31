package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1790h implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1791i f20742a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1790h(C1791i c1791i) {
        this.f20742a = c1791i;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        ResultTask resultTask2;
        ResultTask resultTask3;
        ResultTask resultTask4;
        if (bitmap != null) {
            resultTask3 = this.f20742a.f20743a.f20744a.H;
            resultTask3.setResult(bitmap);
            resultTask4 = this.f20742a.f20743a.f20744a.H;
            resultTask4.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
            return;
        }
        resultTask2 = this.f20742a.f20743a.f20744a.H;
        resultTask2.signalEvent(Task.Event.FAIL);
    }
}
