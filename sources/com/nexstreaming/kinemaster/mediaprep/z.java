package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class z implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20845a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20846b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId) {
        this.f20846b = mediaPrepManager;
        this.f20845a = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean b2;
        b2 = this.f20846b.b(this.f20845a);
        if (b2) {
        }
    }
}
