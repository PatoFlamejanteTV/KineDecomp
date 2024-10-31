package com.nexstreaming.kinemaster.mediastore.provider;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveProvider.java */
/* loaded from: classes.dex */
public class u implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f21025a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ GoogleDriveProvider f21026b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(GoogleDriveProvider googleDriveProvider, Task task) {
        this.f21026b = googleDriveProvider;
        this.f21025a = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f21025a.signalEvent(Task.Event.CANCEL);
    }
}
