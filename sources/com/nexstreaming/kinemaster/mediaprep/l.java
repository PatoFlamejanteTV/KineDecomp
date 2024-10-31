package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class l implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20805a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20806b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId) {
        this.f20806b = mediaPrepManager;
        this.f20805a = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        this.f20806b.a(this.f20805a, MediaPrepState.Transcoding, i, i2);
    }
}
