package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1789g implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f20741a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1789g(MediaInfo mediaInfo) {
        this.f20741a = mediaInfo;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        ResultTask resultTask2;
        ResultTask resultTask3;
        if (bitmap != null) {
            resultTask2 = this.f20741a.G;
            resultTask2.setResult(bitmap);
            resultTask3 = this.f20741a.G;
            resultTask3.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
            return;
        }
        this.f20741a.H().onComplete((Task.OnTaskEventListener) new C1788f(this)).onFailure((Task.OnFailListener) new C1786d(this));
    }
}
