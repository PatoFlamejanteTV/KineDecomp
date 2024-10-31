package com.nexstreaming.kinemaster.ui.mediabrowser;

import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaBrowserPresenter.kt */
/* loaded from: classes.dex */
final class K implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f21656a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(S s) {
        this.f21656a = s;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public final void onProgress(Task task, Task.Event event, int i, int i2) {
        InterfaceC1828f interfaceC1828f;
        interfaceC1828f = this.f21656a.f21668c;
        if (interfaceC1828f != null) {
            interfaceC1828f.j(i);
        }
    }
}
