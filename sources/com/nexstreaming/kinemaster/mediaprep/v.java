package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class v implements ResultTask.OnResultAvailableListener<com.nexstreaming.kinemaster.mediastore.item.c> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20835a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20836b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId) {
        this.f20836b = mediaPrepManager;
        this.f20835a = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<com.nexstreaming.kinemaster.mediastore.item.c> resultTask, Task.Event event, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        boolean b2;
        b2 = this.f20836b.b(this.f20835a);
        if (b2) {
            return;
        }
        this.f20836b.a(this.f20835a, cVar);
    }
}
