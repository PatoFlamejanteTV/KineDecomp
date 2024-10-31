package com.nexstreaming.kinemaster.ui.mediabrowser;

import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaBrowserPresenter.kt */
/* loaded from: classes.dex */
final class N implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f21660a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f21661b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(S s, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f21660a = s;
        this.f21661b = cVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        this.f21660a.j(this.f21661b);
    }
}
