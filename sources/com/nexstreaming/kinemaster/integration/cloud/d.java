package com.nexstreaming.kinemaster.integration.cloud;

import com.nexstreaming.app.general.task.Task;

/* compiled from: KMCloud.java */
/* loaded from: classes.dex */
public class d implements Task.OnProgressListener {

    /* renamed from: a */
    final /* synthetic */ KMCloud f20430a;

    public d(KMCloud kMCloud) {
        this.f20430a = kMCloud;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        KMCloud kMCloud = this.f20430a;
        kMCloud.f20419c.a(kMCloud.a(), this.f20430a.f20418b, i, i2);
    }
}
