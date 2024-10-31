package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2152y implements ResultTask.OnResultAvailableListener<com.nexstreaming.app.general.service.download.k> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC1821j f23001a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ O f23002b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2152y(O o, InterfaceC1821j interfaceC1821j) {
        this.f23002b = o;
        this.f23001a = interfaceC1821j;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<com.nexstreaming.app.general.service.download.k> resultTask, Task.Event event, com.nexstreaming.app.general.service.download.k kVar) {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        com.nexstreaming.kinemaster.ui.a.r rVar2;
        c.d.a.a.d.a.d dVar;
        rVar = this.f23002b.i;
        rVar.e(R.string.installing_assets);
        rVar2 = this.f23002b.i;
        rVar2.j(100);
        dVar = this.f23002b.j;
        dVar.a(this.f23001a).onComplete(new C2150x(this)).onFailure(new C2148w(this));
    }
}
