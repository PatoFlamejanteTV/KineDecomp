package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class f implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20793a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20794b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId) {
        this.f20794b = mediaPrepManager;
        this.f20793a = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f20794b.b(this.f20793a);
        this.f20794b.a(this.f20793a, taskError, MediaPrepManager.FailType.Transcoding);
    }
}
