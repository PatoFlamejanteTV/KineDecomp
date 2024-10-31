package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Task.java */
/* loaded from: classes.dex */
public final class o implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f3198a;
    final /* synthetic */ Task b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(List list, Task task) {
        this.f3198a = list;
        this.b = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean z;
        Iterator it = this.f3198a.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (!((Task) it.next()).didSignalEvent(Task.Event.SUCCESS)) {
                z = false;
                break;
            }
        }
        if (z) {
            this.b.signalEvent(Task.Event.SUCCESS);
        }
    }
}
