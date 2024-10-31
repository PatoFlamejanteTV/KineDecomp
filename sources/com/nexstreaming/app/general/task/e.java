package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;
import java.util.Iterator;
import java.util.List;

/* compiled from: Task.java */
/* loaded from: classes2.dex */
public class e implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ List f19742a;

    /* renamed from: b */
    final /* synthetic */ Task f19743b;

    public e(List list, Task task) {
        this.f19742a = list;
        this.f19743b = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean z;
        Iterator it = this.f19742a.iterator();
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
            this.f19743b.signalEvent(Task.Event.SUCCESS);
        }
    }
}
