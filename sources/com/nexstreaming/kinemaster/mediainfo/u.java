package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class u implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f3514a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.f3514a = tVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        MediaInfo.c cVar;
        cVar = this.f3514a.f3513a.n;
        cVar.sendFailure(null);
    }
}
