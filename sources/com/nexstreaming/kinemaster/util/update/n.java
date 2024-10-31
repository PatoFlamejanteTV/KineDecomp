package com.nexstreaming.kinemaster.util.update;

import android.app.Activity;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
public class n implements ResultTask.OnResultAvailableListener<InterfaceC1821j> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.app.general.nexasset.assetpackage.b f23966a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AssetUpdateActivity f23967b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AssetUpdateActivity assetUpdateActivity, com.nexstreaming.app.general.nexasset.assetpackage.b bVar) {
        this.f23967b = assetUpdateActivity;
        this.f23966a = bVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<InterfaceC1821j> resultTask, Task.Event event, InterfaceC1821j interfaceC1821j) {
        Activity u;
        String valueOf = String.valueOf(interfaceC1821j.a());
        String f2 = interfaceC1821j.f();
        String p = interfaceC1821j.p();
        String l = interfaceC1821j.l();
        u = this.f23967b.u();
        this.f23967b.w().a(new com.nexstreaming.app.general.service.download.k(valueOf, f2, p, l, c.d.a.a.d.a.d.a(u).a(interfaceC1821j.a()), interfaceC1821j.h())).onResultAvailable(new m(this, interfaceC1821j)).onFailure((Task.OnFailListener) new j(this));
    }
}
