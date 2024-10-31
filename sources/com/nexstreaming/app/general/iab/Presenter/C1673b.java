package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.b.e;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import java.util.List;

/* compiled from: IABBasePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1673b<T> implements ResultTask.OnResultAvailableListener<List<? extends InterfaceC1821j>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC1674c f19368a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1673b(RunnableC1674c runnableC1674c) {
        this.f19368a = runnableC1674c;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<List<InterfaceC1821j>> resultTask, Task.Event event, List<? extends InterfaceC1821j> list) {
        this.f19368a.f19371b.onNext(new e.a(BillingResponse.OK.getIntErrorCode(), list));
    }
}
