package com.nexstreaming.kinemaster.util.update;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
class d implements ResultTask.OnResultAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f23955a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.f23955a = eVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    public void onResultAvailable(ResultTask resultTask, Task.Event event, Object obj) {
        this.f23955a.f23956a.M();
    }
}
