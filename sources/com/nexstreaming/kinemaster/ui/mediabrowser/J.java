package com.nexstreaming.kinemaster.ui.mediabrowser;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserPresenter.kt */
/* loaded from: classes.dex */
public final class J implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f21655a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(S s) {
        this.f21655a = s;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        this.f21655a.f();
    }
}
