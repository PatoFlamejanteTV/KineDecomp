package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: VoiceRecorderFragment.java */
/* loaded from: classes.dex */
class mk implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ mj f4092a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mk(mj mjVar) {
        this.f4092a = mjVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4092a.b.b();
        this.f4092a.c.f4089a.d(R.id.action_play_pause, true);
        this.f4092a.c.f4089a.i(true);
        this.f4092a.c.f4089a.j(true);
        this.f4092a.c.f4089a.k(true);
        this.f4092a.c.f4089a.l(true);
        this.f4092a.c.f4089a.m(true);
        this.f4092a.c.f4089a.k();
    }
}
