package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;
import java.util.Iterator;
import java.util.List;

/* compiled from: Task.java */
/* loaded from: classes2.dex */
public class p implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ List f19757a;

    /* renamed from: b */
    final /* synthetic */ Task f19758b;

    public p(List list, Task task) {
        this.f19757a = list;
        this.f19758b = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean z;
        Iterator it = this.f19757a.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (!((Task) it.next()).didSignalEvent(Task.Event.COMPLETE)) {
                z = false;
                break;
            }
        }
        if (z) {
            this.f19758b.signalEvent(Task.Event.COMPLETE);
        }
    }
}
