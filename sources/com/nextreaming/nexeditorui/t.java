package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.tracelog.APCManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.kt */
/* loaded from: classes.dex */
public final class T<T> implements ResultTask.OnResultAvailableListener<APCManager.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f24172a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(com.nexstreaming.kinemaster.ui.a.e eVar) {
        this.f24172a = eVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<APCManager.a> resultTask, Task.Event event, APCManager.a aVar) {
        this.f24172a.dismiss();
    }
}
