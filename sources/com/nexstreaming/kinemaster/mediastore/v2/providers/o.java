package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.nexstreaming.app.general.task.Task;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
class o implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ Task f3590a;
    final /* synthetic */ l b;

    public o(l lVar, Task task) {
        this.b = lVar;
        this.f3590a = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3590a.signalEvent(Task.Event.CANCEL);
    }
}
