package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class f implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f3503a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.f3503a = dVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        File file;
        ResultTask c;
        MediaInfo mediaInfo = this.f3503a.f3501a;
        file = this.f3503a.f3501a.g;
        c = mediaInfo.c(file);
        c.onResultAvailable(new g(this));
    }
}
