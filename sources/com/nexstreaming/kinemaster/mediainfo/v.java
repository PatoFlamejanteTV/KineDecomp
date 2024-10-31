package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class v implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f3515a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.f3515a = tVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        File file;
        ResultTask d;
        MediaInfo mediaInfo = this.f3515a.f3513a;
        file = this.f3515a.f3513a.f;
        d = mediaInfo.d(file);
        d.onResultAvailable(new w(this));
    }
}
