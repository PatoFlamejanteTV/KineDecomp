package com.nexstreaming.kinemaster.util.update;

import com.nexstreaming.app.general.task.Task;

/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
class c implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f23954a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e eVar) {
        this.f23954a = eVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f23954a.f23956a.M();
    }
}
