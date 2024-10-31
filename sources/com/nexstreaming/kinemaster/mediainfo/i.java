package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class i implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f3506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f3506a = hVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        File file;
        ResultTask c;
        MediaInfo mediaInfo = this.f3506a.f3505a;
        file = this.f3506a.f3505a.h;
        c = mediaInfo.c(file);
        c.onResultAvailable(new j(this));
    }
}
