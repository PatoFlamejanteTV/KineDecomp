package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.b.a;
import com.nexstreaming.app.general.task.Task;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class ca implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ da f19372a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(da daVar) {
        this.f19372a = daVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f19372a.f19374a.f19378a.f19382c.onNext(new a.C0096a(BillingResponse.SERVICE_DISCONNECTED.getIntErrorCode()));
    }
}
