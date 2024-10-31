package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;
import java.util.Iterator;
import java.util.List;

/* compiled from: Task.java */
/* loaded from: classes2.dex */
public class o implements Task.OnProgressListener {

    /* renamed from: a */
    final /* synthetic */ List f19755a;

    /* renamed from: b */
    final /* synthetic */ Task f19756b;

    public o(List list, Task task) {
        this.f19755a = list;
        this.f19756b = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        Iterator it = this.f19755a.iterator();
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            Task task2 = (Task) it.next();
            if (!task2.isProgressAvailable()) {
                break;
            }
            i3 += task2.getProgress();
            i4 += task2.getMaxProgress();
        }
        if (z) {
            this.f19756b.setProgress(i3, i4);
        }
    }
}
