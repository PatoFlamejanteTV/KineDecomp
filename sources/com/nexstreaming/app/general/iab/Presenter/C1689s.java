package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.network.SubscriptionInfo;

/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1689s<T> implements ResultTask.OnResultAvailableListener<SubscriptionInfo> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC1691u f19407a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1689s(RunnableC1691u runnableC1691u) {
        this.f19407a = runnableC1691u;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<SubscriptionInfo> resultTask, Task.Event event, SubscriptionInfo subscriptionInfo) {
        RunnableC1691u runnableC1691u = this.f19407a;
        runnableC1691u.f19409a.f19411a.a(subscriptionInfo, runnableC1691u.f19410b);
    }
}
