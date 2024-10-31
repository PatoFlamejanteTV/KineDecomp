package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
class co implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cm f3822a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cm cmVar) {
        this.f3822a = cmVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        if (!this.f3822a.b.isAdded()) {
            this.f3822a.f3820a.p();
        }
        this.f3822a.f3820a.b(false);
        this.f3822a.b.g = false;
        this.f3822a.b.h();
    }
}
