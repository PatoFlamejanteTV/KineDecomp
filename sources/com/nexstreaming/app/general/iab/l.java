package com.nexstreaming.app.general.iab;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.tracelog.APCManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class l<T> implements ResultTask.OnResultAvailableListener<APCManager.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19478a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f19479b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(IABManager iABManager, ResultTask resultTask) {
        this.f19478a = iABManager;
        this.f19479b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<APCManager.a> resultTask, Task.Event event, APCManager.a aVar) {
        this.f19479b.sendResult(aVar);
        IABManager iABManager = this.f19478a;
        kotlin.jvm.internal.h.a((Object) aVar, "result");
        iABManager.j = aVar.b();
        this.f19478a.x();
    }
}
