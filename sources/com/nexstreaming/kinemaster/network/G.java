package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
public class G implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(VolleyNetworkService volleyNetworkService) {
        this.f21100a = volleyNetworkService;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Task task2;
        task2 = this.f21100a.k;
        task2.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }
}
