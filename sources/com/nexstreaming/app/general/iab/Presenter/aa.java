package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.b.a;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpLoginInfoResponse;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class aa<T> implements ResultTask.OnResultAvailableListener<CpLoginInfoResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ea f19367a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ea eaVar) {
        this.f19367a = eaVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<CpLoginInfoResponse> resultTask, Task.Event event, CpLoginInfoResponse cpLoginInfoResponse) {
        this.f19367a.f19378a.f19382c.onNext(new a.b(BillingResponse.OK.getIntErrorCode()));
    }
}