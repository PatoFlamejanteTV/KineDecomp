package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionListFragment.java */
/* loaded from: classes2.dex */
public class Uc implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Xc f22141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uc(Xc xc) {
        this.f22141a = xc;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f22141a.ra();
        this.f22141a.G();
    }
}
