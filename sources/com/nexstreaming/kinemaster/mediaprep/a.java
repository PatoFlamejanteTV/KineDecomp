package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class A implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20766a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20767b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId) {
        this.f20767b = mediaPrepManager;
        this.f20766a = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        boolean b2;
        b2 = this.f20767b.b(this.f20766a);
        if (b2) {
            return;
        }
        this.f20767b.a(this.f20766a, taskError, MediaPrepManager.FailType.Download);
    }
}
