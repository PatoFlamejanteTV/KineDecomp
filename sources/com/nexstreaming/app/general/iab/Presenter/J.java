package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.b.f;
import com.nexstreaming.app.general.task.Task;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class J implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ K f19344a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(K k) {
        this.f19344a = k;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f19344a.f19346b.onNext(new f.a(BillingResponse.SERVICE_DISCONNECTED.getIntErrorCode()));
    }
}
