package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* compiled from: AudioMenuListFragment.java */
/* loaded from: classes2.dex */
class T implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f22095a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(U u) {
        this.f22095a = u;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        if (!this.f22095a.f22137b.isAdded()) {
            this.f22095a.f22136a.M();
        }
        X.b(this.f22095a.f22137b, false);
    }
}
