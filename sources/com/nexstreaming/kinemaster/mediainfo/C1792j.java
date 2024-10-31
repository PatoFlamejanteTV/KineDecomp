package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1792j implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f20744a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1792j(MediaInfo mediaInfo) {
        this.f20744a = mediaInfo;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        ResultTask resultTask2;
        ResultTask resultTask3;
        if (bitmap != null) {
            resultTask2 = this.f20744a.H;
            resultTask2.setResult(bitmap);
            resultTask3 = this.f20744a.H;
            resultTask3.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
            return;
        }
        this.f20744a.H().onComplete((Task.OnTaskEventListener) new C1791i(this));
    }
}
