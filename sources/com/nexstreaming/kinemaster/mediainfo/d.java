package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class D implements ResultTask.OnResultAvailableListener<L> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo.c f20662a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f20663b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(E e2, MediaInfo.c cVar) {
        this.f20663b = e2;
        this.f20662a = cVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<L> resultTask, Task.Event event, L l) {
        if (l != null) {
            this.f20662a.sendResult(l);
        } else {
            this.f20662a.sendFailure(null);
        }
    }
}
