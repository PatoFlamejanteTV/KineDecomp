package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class B implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20768a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f20769b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f20770c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20771d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, boolean z) {
        this.f20771d = mediaPrepManager;
        this.f20768a = mediaStoreItemId;
        this.f20769b = cVar;
        this.f20770c = z;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean b2;
        b2 = this.f20771d.b(this.f20768a);
        if (b2) {
            return;
        }
        this.f20771d.d(this.f20768a);
        this.f20771d.a(this.f20768a, this.f20769b, this.f20770c, true);
    }
}
