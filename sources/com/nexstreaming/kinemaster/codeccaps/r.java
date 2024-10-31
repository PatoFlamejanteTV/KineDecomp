package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.codeccaps.CapabilityChecker;

/* compiled from: CapabilityChecker.java */
/* loaded from: classes.dex */
class r implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f20117a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(t tVar) {
        this.f20117a = tVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        CapabilityChecker.b bVar;
        bVar = this.f20117a.f20120a.z;
        bVar.log("    ...working... (" + i + " / " + i2 + ")");
    }
}
