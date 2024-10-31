package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1788f implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1789g f20740a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1788f(C1789g c1789g) {
        this.f20740a = c1789g;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        File file;
        ResultTask c2;
        MediaInfo mediaInfo = this.f20740a.f20741a;
        file = mediaInfo.x;
        c2 = mediaInfo.c(file);
        c2.onResultAvailable(new C1787e(this));
    }
}
