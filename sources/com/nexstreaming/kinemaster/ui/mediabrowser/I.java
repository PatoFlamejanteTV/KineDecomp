package com.nexstreaming.kinemaster.ui.mediabrowser;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserPresenter.kt */
/* loaded from: classes.dex */
public final class I implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f21654a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(S s) {
        this.f21654a = s;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f21654a.e();
    }
}
