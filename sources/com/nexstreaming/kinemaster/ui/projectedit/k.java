package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* compiled from: AudioMenuListFragment.java */
/* loaded from: classes.dex */
class k implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ i f4024a;

    public k(i iVar) {
        this.f4024a = iVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        if (!this.f4024a.b.isAdded()) {
            this.f4024a.f3970a.p();
        }
        this.f4024a.b.d = false;
    }
}
