package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class e implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20791a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20792b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId) {
        this.f20792b = mediaPrepManager;
        this.f20791a = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        this.f20792b.a(this.f20791a, MediaPrepState.Downloading, i, i2);
    }
}
