package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class u implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20833a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20834b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId) {
        this.f20834b = mediaPrepManager;
        this.f20833a = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        boolean b2;
        b2 = this.f20834b.b(this.f20833a);
        if (b2) {
            return;
        }
        this.f20834b.a(this.f20833a, taskError, MediaPrepManager.FailType.Other);
    }
}
