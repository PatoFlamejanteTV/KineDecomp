package com.nexstreaming.app.general.iab;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.tracelog.APCManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class c<T> implements ResultTask.OnResultAvailableListener<APCManager.APCValidationResult> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19467a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IABManager iABManager) {
        this.f19467a = iABManager;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<APCManager.APCValidationResult> resultTask, Task.Event event, APCManager.APCValidationResult aPCValidationResult) {
        this.f19467a.G = false;
        if (aPCValidationResult == null) {
            return;
        }
        int i = b.f19436a[aPCValidationResult.ordinal()];
        if (i == 1) {
            this.f19467a.F = true;
        } else {
            if (i != 2) {
                return;
            }
            this.f19467a.j = false;
        }
    }
}
