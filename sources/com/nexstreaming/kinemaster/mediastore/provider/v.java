package com.nexstreaming.kinemaster.mediastore.provider;

import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveProvider.java */
/* loaded from: classes.dex */
public class v implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f21027a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ File f21028b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ GoogleDriveProvider f21029c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(GoogleDriveProvider googleDriveProvider, Task task, File file) {
        this.f21029c = googleDriveProvider;
        this.f21027a = task;
        this.f21028b = file;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f21027a.sendFailure(Task.makeTaskError(taskError.getMessage(), taskError.getException()));
        this.f21028b.delete();
    }
}
