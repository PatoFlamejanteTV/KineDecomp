package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class n implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20809a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f20810b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20811c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f20811c = mediaPrepManager;
        this.f20809a = mediaStoreItemId;
        this.f20810b = cVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f20811c.a(this.f20809a, this.f20810b, true, false);
    }
}
