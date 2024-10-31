package com.nexstreaming.kinemaster.ui.mediabrowser;

import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaBrowserPresenter.kt */
/* loaded from: classes.dex */
final class M implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f21659a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(S s) {
        this.f21659a = s;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        InterfaceC1828f interfaceC1828f;
        InterfaceC1828f interfaceC1828f2;
        interfaceC1828f = this.f21659a.f21668c;
        if (interfaceC1828f != null) {
            interfaceC1828f.r();
        }
        interfaceC1828f2 = this.f21659a.f21668c;
        if (interfaceC1828f2 != null) {
            kotlin.jvm.internal.h.a((Object) taskError, "failureReason");
            interfaceC1828f2.a(taskError.getMessage());
        }
    }
}
