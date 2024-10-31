package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class m implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20807a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20808b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId) {
        this.f20808b = mediaPrepManager;
        this.f20807a = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f20808b.e(this.f20807a);
    }
}
