package com.nexstreaming.kinemaster.ui.layereditrender;

import com.nexstreaming.app.general.task.Task;

/* compiled from: MarchingAnts.java */
/* loaded from: classes.dex */
class c implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f3715a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3715a = bVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3715a.f3714a.I = false;
    }
}
