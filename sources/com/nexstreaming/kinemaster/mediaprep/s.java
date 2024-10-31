package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class s implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20827a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f20828b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f20829c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20830d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, String str) {
        this.f20830d = mediaPrepManager;
        this.f20827a = mediaStoreItemId;
        this.f20828b = cVar;
        this.f20829c = str;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f20830d.b(this.f20827a, this.f20828b, this.f20829c);
    }
}
