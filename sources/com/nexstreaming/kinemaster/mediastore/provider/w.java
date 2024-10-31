package com.nexstreaming.kinemaster.mediastore.provider;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveProvider.java */
/* loaded from: classes.dex */
public class w implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f21030a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ GoogleDriveProvider f21031b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(GoogleDriveProvider googleDriveProvider, Task task) {
        this.f21031b = googleDriveProvider;
        this.f21030a = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        this.f21030a.setProgress(i, i2);
    }
}
