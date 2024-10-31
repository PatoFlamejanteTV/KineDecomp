package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
class Nf implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Of f21975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Nf(Of of) {
        this.f21975a = of;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        this.f21975a.f21986a.f22205b.xa();
        rVar = this.f21975a.f21986a.f22205b.Xa;
        rVar.dismiss();
        this.f21975a.f21986a.f22205b.Pa = false;
    }
}
