package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class x implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ y f20763a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(y yVar) {
        this.f20763a = yVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        File file;
        ResultTask d2;
        MediaInfo mediaInfo = this.f20763a.f20764a;
        file = mediaInfo.w;
        d2 = mediaInfo.d(file);
        d2.onResultAvailable(new w(this));
    }
}
