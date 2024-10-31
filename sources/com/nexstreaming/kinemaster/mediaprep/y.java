package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class y implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20843a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20844b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId) {
        this.f20844b = mediaPrepManager;
        this.f20843a = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f20844b.e(this.f20843a);
    }
}
