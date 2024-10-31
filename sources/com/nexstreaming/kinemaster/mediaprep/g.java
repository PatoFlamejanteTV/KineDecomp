package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class g implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20795a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20796b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId) {
        this.f20796b = mediaPrepManager;
        this.f20795a = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f20796b.b(this.f20795a);
        this.f20796b.c(this.f20795a);
    }
}
