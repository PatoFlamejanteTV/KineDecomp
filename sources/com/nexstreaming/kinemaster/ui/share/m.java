package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
public class M implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f23288a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ U f23289b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(U u, Task task) {
        this.f23289b = u;
        this.f23288a = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        InterfaceC2240y interfaceC2240y;
        interfaceC2240y = this.f23289b.t;
        interfaceC2240y.a("Export completion event received.", new String[0]);
        SupportLogger.Event.Export_CompleteEventFromEngine.log(new int[0]);
        this.f23288a.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }
}
