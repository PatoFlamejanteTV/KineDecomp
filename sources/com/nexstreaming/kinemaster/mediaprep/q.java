package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class q implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20818a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f20819b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f20820c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20821d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, String str) {
        this.f20821d = mediaPrepManager;
        this.f20818a = mediaStoreItemId;
        this.f20819b = cVar;
        this.f20820c = str;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f20821d.b(this.f20818a, this.f20819b, this.f20820c);
    }
}
