package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
public class q implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task.OnTaskEventListener f21141a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21142b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(VolleyNetworkService volleyNetworkService, Task.OnTaskEventListener onTaskEventListener) {
        this.f21142b = volleyNetworkService;
        this.f21141a = onTaskEventListener;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Task.OnTaskEventListener onTaskEventListener = this.f21141a;
        if (onTaskEventListener != null) {
            onTaskEventListener.onTaskEvent(task, event);
        }
    }
}
