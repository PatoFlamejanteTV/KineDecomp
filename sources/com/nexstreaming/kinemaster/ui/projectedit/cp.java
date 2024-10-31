package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
class cp implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ce f3823a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(ce ceVar) {
        this.f3823a = ceVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3823a.f = false;
        this.f3823a.g = false;
        this.f3823a.h();
        this.f3823a.a(true);
    }
}
