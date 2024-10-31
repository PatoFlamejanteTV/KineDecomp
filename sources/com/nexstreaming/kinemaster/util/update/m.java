package com.nexstreaming.kinemaster.util.update;

import android.app.Activity;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;

/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
class m implements ResultTask.OnResultAvailableListener<com.nexstreaming.app.general.service.download.k> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC1821j f23964a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ n f23965b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(n nVar, InterfaceC1821j interfaceC1821j) {
        this.f23965b = nVar;
        this.f23964a = interfaceC1821j;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<com.nexstreaming.app.general.service.download.k> resultTask, Task.Event event, com.nexstreaming.app.general.service.download.k kVar) {
        Activity u;
        if (kVar == null) {
            this.f23965b.f23967b.d(R.string.asset_install_failed);
            return;
        }
        AssetUpdateActivity.k(this.f23965b.f23967b);
        u = this.f23965b.f23967b.u();
        c.d.a.a.d.a.d.a(u).a(this.f23964a, kVar).onComplete(new l(this)).onFailure(new k(this));
    }
}
