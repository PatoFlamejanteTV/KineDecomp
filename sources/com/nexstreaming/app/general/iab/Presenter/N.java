package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.b.d;
import com.nexstreaming.app.general.task.Task;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class N implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f19351a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(O o) {
        this.f19351a = o;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f19351a.f19353b.onNext(new d.a(BillingResponse.SERVICE_DISCONNECTED.getIntErrorCode()));
    }
}
