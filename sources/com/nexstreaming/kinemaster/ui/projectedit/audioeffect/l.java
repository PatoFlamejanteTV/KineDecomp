package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import com.nexstreaming.app.general.task.Task;

/* compiled from: AudioEffectPresenter.kt */
/* loaded from: classes2.dex */
final class l implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f22241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(n nVar) {
        this.f22241a = nVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        j jVar;
        jVar = this.f22241a.f22244b.f22261h;
        if (!jVar.isActive()) {
            this.f22241a.f22244b.b(new kotlin.jvm.a.a<kotlin.k>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioEffectPresenter$editorPlay$1$1$1$1$1
                @Override // kotlin.jvm.a.a
                public /* bridge */ /* synthetic */ kotlin.k invoke() {
                    invoke2();
                    return kotlin.k.f28545a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            });
            return;
        }
        n nVar = this.f22241a;
        nVar.f22244b.a(nVar.f22243a, null);
        kotlin.jvm.a.a aVar = this.f22241a.f22245c;
        if (aVar != null) {
        }
    }
}
