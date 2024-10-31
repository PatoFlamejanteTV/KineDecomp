package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class u implements ResultTask.OnResultAvailableListener<MediaStoreItem> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3544a;
    final /* synthetic */ MediaPrepManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MediaPrepManager mediaPrepManager, MSID msid) {
        this.b = mediaPrepManager;
        this.f3544a = msid;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<MediaStoreItem> resultTask, Task.Event event, MediaStoreItem mediaStoreItem) {
        boolean f;
        f = this.b.f(this.f3544a);
        if (!f) {
            this.b.a(this.f3544a, mediaStoreItem);
        }
    }
}
