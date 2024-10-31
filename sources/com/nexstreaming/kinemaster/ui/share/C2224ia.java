package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareBaseActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.ia, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2224ia implements ResultTask.OnResultAvailableListener<com.nexstreaming.kinemaster.project.k> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ na f23355a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2224ia(na naVar) {
        this.f23355a = naVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<com.nexstreaming.kinemaster.project.k> resultTask, Task.Event event, com.nexstreaming.kinemaster.project.k kVar) {
        this.f23355a.a(kVar.b());
        this.f23355a.J = kVar;
        this.f23355a.J();
    }
}
