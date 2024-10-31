package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class o implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3538a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ MediaPrepManager c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MediaPrepManager mediaPrepManager, MSID msid, MediaStoreItem mediaStoreItem) {
        this.c = mediaPrepManager;
        this.f3538a = msid;
        this.b = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.c.a(this.f3538a, this.b, true, false);
    }
}
