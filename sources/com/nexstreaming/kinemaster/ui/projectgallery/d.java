package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;

/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
class d implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f4205a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f4205a = cVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        com.nexstreaming.kinemaster.ui.a.e eVar;
        Task task2;
        eVar = this.f4205a.b.h;
        eVar.dismiss();
        task2 = this.f4205a.b.d;
        task2.signalEvent(Task.Event.COMPLETE);
    }
}
