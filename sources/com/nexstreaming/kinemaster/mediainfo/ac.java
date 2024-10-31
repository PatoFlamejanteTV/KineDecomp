package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class ac implements ResultTask.OnResultAvailableListener<aj> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo.c f3491a;
    final /* synthetic */ ab b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, MediaInfo.c cVar) {
        this.b = abVar;
        this.f3491a = cVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<aj> resultTask, Task.Event event, aj ajVar) {
        if (ajVar != null) {
            this.f3491a.sendResult(ajVar);
        } else {
            this.f3491a.sendFailure(null);
        }
    }
}
