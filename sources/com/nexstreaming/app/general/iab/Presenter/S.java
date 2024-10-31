package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.b.c;
import com.nexstreaming.app.general.task.Task;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class S implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ T f19357a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(T t) {
        this.f19357a = t;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f19357a.f19359b.onNext(new c.a(BillingResponse.SERVICE_DISCONNECTED.getIntErrorCode()));
    }
}
