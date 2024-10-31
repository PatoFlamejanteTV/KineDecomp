package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpRestoreLoginInfoResponse;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class C<T> implements ResultTask.OnResultAvailableListener<CpRestoreLoginInfoResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ E f19328a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(E e2) {
        this.f19328a = e2;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<CpRestoreLoginInfoResponse> resultTask, Task.Event event, CpRestoreLoginInfoResponse cpRestoreLoginInfoResponse) {
        this.f19328a.f19330a.a(true);
    }
}
