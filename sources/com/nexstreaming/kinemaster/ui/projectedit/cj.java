package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
class cj implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ce f3817a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ce ceVar) {
        this.f3817a = ceVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3817a.f = false;
        this.f3817a.g = false;
        this.f3817a.d();
        this.f3817a.e();
        this.f3817a.h();
    }
}
