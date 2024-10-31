package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
public class n implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f3589a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.f3589a = lVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3589a.f = true;
    }
}
