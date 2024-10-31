package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class g implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3530a;
    final /* synthetic */ MediaPrepManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaPrepManager mediaPrepManager, MSID msid) {
        this.b = mediaPrepManager;
        this.f3530a = msid;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.b.f(this.f3530a);
        this.b.a(this.f3530a, taskError, MediaPrepManager.FailType.Transcoding);
    }
}
