package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* compiled from: OptionListFragment.java */
/* loaded from: classes.dex */
public class ek implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ ed f3871a;

    public ek(ed edVar) {
        this.f3871a = edVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3871a.z();
        this.f3871a.d();
    }
}
