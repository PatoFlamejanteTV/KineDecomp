package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
public class p implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21140a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(VolleyNetworkService volleyNetworkService) {
        this.f21140a = volleyNetworkService;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        if (taskError == SessionError.TOKEN_EXPIRED) {
            this.f21140a.o = null;
        }
    }
}
