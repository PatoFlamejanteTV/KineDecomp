package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareBaseActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.ja, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2226ja implements ResultTask.OnResultAvailableListener<com.nexstreaming.kinemaster.project.k> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ na f23357a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2226ja(na naVar) {
        this.f23357a = naVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<com.nexstreaming.kinemaster.project.k> resultTask, Task.Event event, com.nexstreaming.kinemaster.project.k kVar) {
        this.f23357a.a(kVar.b());
        this.f23357a.b(com.nexstreaming.kinemaster.ui.projectgallery.P.a(kVar.b(), this.f23357a.getResources(), true, false));
        this.f23357a.J = kVar;
        this.f23357a.J();
    }
}
