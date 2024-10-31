package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;

/* compiled from: Task.java */
/* loaded from: classes.dex */
final class g implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task[] f3192a;
    final /* synthetic */ Task.Event[] b;
    final /* synthetic */ Task.MultiplexTask c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Task[] taskArr, Task.Event[] eventArr, Task.MultiplexTask multiplexTask) {
        this.f3192a = taskArr;
        this.b = eventArr;
        this.c = multiplexTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Task.Event event2 = Task.Event.COMPLETE;
        int i = 0;
        while (true) {
            if (i >= this.f3192a.length) {
                break;
            }
            if (this.f3192a[i] != task) {
                i++;
            } else {
                this.b[i] = event;
                break;
            }
        }
        for (int i2 = 0; i2 < this.f3192a.length; i2++) {
            if (this.b[i2] != null) {
                if (this.b[i2] == Task.Event.FAIL) {
                    event2 = Task.Event.FAIL;
                } else if (this.b[i2] == Task.Event.CANCEL && event2 == Task.Event.COMPLETE) {
                    event2 = Task.Event.CANCEL;
                }
            } else {
                return;
            }
        }
        this.c.signalEvent(event2);
    }
}
