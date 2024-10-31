package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class aa implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3524a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ boolean c;
    final /* synthetic */ MediaPrepManager d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MediaPrepManager mediaPrepManager, MSID msid, MediaStoreItem mediaStoreItem, boolean z) {
        this.d = mediaPrepManager;
        this.f3524a = msid;
        this.b = mediaStoreItem;
        this.c = z;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean f;
        f = this.d.f(this.f3524a);
        if (!f) {
            this.d.d(this.f3524a);
            this.d.a(this.f3524a, this.b, this.c, true);
        }
    }
}
