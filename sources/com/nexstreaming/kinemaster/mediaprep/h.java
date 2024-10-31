package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class h implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3531a;
    final /* synthetic */ MediaPrepManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MediaPrepManager mediaPrepManager, MSID msid) {
        this.b = mediaPrepManager;
        this.f3531a = msid;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.b.f(this.f3531a);
        this.b.c(this.f3531a);
    }
}
