package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
class ck implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ce f3818a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ce ceVar) {
        this.f3818a = ceVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3818a.f = false;
        this.f3818a.g = false;
        this.f3818a.h();
        this.f3818a.d();
        this.f3818a.a(true);
    }
}
