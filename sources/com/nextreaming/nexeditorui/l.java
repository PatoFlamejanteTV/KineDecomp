package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.APCManager;
import com.nexstreaming.kinemaster.ui.a.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.kt */
/* loaded from: classes.dex */
public final class L<T> implements ResultTask.OnResultAvailableListener<APCManager.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f24061a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f24062b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f24063c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(I i, com.nexstreaming.kinemaster.ui.a.e eVar, boolean z) {
        this.f24061a = i;
        this.f24062b = eVar;
        this.f24063c = z;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<APCManager.a> resultTask, Task.Event event, APCManager.a aVar) {
        this.f24062b.dismiss();
        e.a aVar2 = new e.a(this.f24061a.u());
        aVar2.a(aVar.a(this.f24061a.u(), this.f24063c));
        aVar2.c(R.string.button_ok, K.f24050a);
        aVar2.a().show();
    }
}
