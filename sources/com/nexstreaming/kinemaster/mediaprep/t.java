package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class t implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3543a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ String c;
    final /* synthetic */ MediaPrepManager d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MediaPrepManager mediaPrepManager, MSID msid, MediaStoreItem mediaStoreItem, String str) {
        this.d = mediaPrepManager;
        this.f3543a = msid;
        this.b = mediaStoreItem;
        this.c = str;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.d.b(this.f3543a, this.b, this.c);
    }
}
