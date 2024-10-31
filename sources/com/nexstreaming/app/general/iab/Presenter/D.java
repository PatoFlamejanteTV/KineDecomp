package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.task.Task;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class D implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ E f19329a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(E e2) {
        this.f19329a = e2;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f19329a.f19330a.a(false);
    }
}
