package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class v implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ y f20761a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(y yVar) {
        this.f20761a = yVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        MediaInfo.c cVar;
        cVar = this.f20761a.f20764a.E;
        cVar.sendFailure(null);
    }
}
