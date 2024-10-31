package com.nexstreaming.kinemaster.ui.layereditrender;

import com.nexstreaming.app.general.task.Task;

/* compiled from: MarchingAnts.java */
/* loaded from: classes.dex */
class b implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f21632a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar) {
        this.f21632a = dVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f21632a.f21634a.N = false;
    }
}
