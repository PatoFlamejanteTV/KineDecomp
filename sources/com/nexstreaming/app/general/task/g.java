package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;

/* compiled from: Task.java */
/* loaded from: classes2.dex */
class g implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ Task[] f19745a;

    /* renamed from: b */
    final /* synthetic */ Task.Event[] f19746b;

    /* renamed from: c */
    final /* synthetic */ Task.MultiplexTask f19747c;

    public g(Task[] taskArr, Task.Event[] eventArr, Task.MultiplexTask multiplexTask) {
        this.f19745a = taskArr;
        this.f19746b = eventArr;
        this.f19747c = multiplexTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Task.Event event2 = Task.Event.COMPLETE;
        int i = 0;
        while (true) {
            Task[] taskArr = this.f19745a;
            if (i >= taskArr.length) {
                break;
            }
            if (taskArr[i] == task) {
                this.f19746b[i] = event;
                break;
            }
            i++;
        }
        for (int i2 = 0; i2 < this.f19745a.length; i2++) {
            Task.Event[] eventArr = this.f19746b;
            if (eventArr[i2] == null) {
                return;
            }
            Task.Event event3 = eventArr[i2];
            Task.Event event4 = Task.Event.FAIL;
            if (event3 == event4) {
                event2 = event4;
            } else if (eventArr[i2] == Task.Event.CANCEL && event2 == Task.Event.COMPLETE) {
                event2 = Task.Event.CANCEL;
            }
        }
        this.f19747c.signalEvent(event2);
    }
}
