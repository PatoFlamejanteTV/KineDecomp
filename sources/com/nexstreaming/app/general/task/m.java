package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Task.java */
/* loaded from: classes.dex */
public final class m implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f3196a;
    final /* synthetic */ Task b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(List list, Task task) {
        this.f3196a = list;
        this.b = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        boolean z = false;
        Iterator it = this.f3196a.iterator();
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
            i4 += task2.getProgress();
            i3 = task2.getMaxProgress() + i3;
        }
        if (z) {
            this.b.setProgress(i4, i3);
        }
    }
}
