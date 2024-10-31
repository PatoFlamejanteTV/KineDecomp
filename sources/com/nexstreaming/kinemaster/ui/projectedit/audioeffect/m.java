package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import com.nexstreaming.app.general.task.Task;

/* compiled from: AudioEffectPresenter.kt */
/* loaded from: classes2.dex */
final class m implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f22242a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(n nVar) {
        this.f22242a = nVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        n nVar = this.f22242a;
        nVar.f22244b.a(nVar.f22243a, AudioPlayStatus.STOP);
    }
}
