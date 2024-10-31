package com.nexstreaming.kinemaster.mediastore.v2;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaStore.java */
/* loaded from: classes.dex */
public class j implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f3565a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f3565a = iVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        this.f3565a.publishProgress(Long.valueOf((i << 32) | (i2 & 4294967295L)));
    }
}
