package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1791i implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1792j f20743a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1791i(C1792j c1792j) {
        this.f20743a = c1792j;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        File file;
        ResultTask c2;
        MediaInfo mediaInfo = this.f20743a.f20744a;
        file = mediaInfo.y;
        c2 = mediaInfo.c(file);
        c2.onResultAvailable(new C1790h(this));
    }
}
