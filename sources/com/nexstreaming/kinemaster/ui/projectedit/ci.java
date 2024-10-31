package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
class ci implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ce f3816a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ce ceVar) {
        this.f3816a = ceVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3816a.f = false;
        this.f3816a.g = false;
        this.f3816a.h();
        this.f3816a.a(true);
    }
}
