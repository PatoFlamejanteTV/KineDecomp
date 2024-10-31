package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class d implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f3501a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaInfo mediaInfo) {
        this.f3501a = mediaInfo;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        ResultTask resultTask2;
        ResultTask resultTask3;
        if (bitmap != null) {
            resultTask2 = this.f3501a.p;
            resultTask2.setResult(bitmap);
            resultTask3 = this.f3501a.p;
            resultTask3.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
            return;
        }
        this.f3501a.b().onComplete((Task.OnTaskEventListener) new f(this)).onFailure((Task.OnFailListener) new e(this));
    }
}
