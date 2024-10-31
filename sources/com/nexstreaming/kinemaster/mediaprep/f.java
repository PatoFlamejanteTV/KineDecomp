package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class f implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3529a;
    final /* synthetic */ MediaPrepManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaPrepManager mediaPrepManager, MSID msid) {
        this.b = mediaPrepManager;
        this.f3529a = msid;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        this.b.a(this.f3529a, MediaPrepState.Downloading, i, i2);
    }
}
