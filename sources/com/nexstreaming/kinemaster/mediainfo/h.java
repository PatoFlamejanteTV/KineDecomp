package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class h implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f3505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MediaInfo mediaInfo) {
        this.f3505a = mediaInfo;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        ResultTask resultTask2;
        ResultTask resultTask3;
        if (bitmap != null) {
            resultTask2 = this.f3505a.q;
            resultTask2.setResult(bitmap);
            resultTask3 = this.f3505a.q;
            resultTask3.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
            return;
        }
        this.f3505a.b().onComplete((Task.OnTaskEventListener) new i(this));
    }
}
