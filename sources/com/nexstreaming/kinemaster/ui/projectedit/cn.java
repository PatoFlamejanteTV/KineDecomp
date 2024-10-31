package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
class cn implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cm f3821a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar) {
        this.f3821a = cmVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3821a.b.f = false;
        this.f3821a.b.g = false;
        this.f3821a.f3820a.b(false);
        this.f3821a.b.h();
        this.f3821a.b.a(true);
    }
}
