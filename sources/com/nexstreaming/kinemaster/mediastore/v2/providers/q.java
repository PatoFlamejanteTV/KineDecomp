package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.nexstreaming.app.general.task.Task;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
class q implements Task.OnProgressListener {

    /* renamed from: a */
    final /* synthetic */ Task f3592a;
    final /* synthetic */ l b;

    public q(l lVar, Task task) {
        this.b = lVar;
        this.f3592a = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        this.f3592a.setProgress(i, i2);
    }
}
