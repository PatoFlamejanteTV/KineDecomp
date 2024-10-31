package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
public class ac implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f3575a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(l lVar) {
        this.f3575a = lVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3575a.f = false;
    }
}
