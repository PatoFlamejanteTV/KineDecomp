package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
public class bt implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f3801a;
    final /* synthetic */ bo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bo boVar, com.nexstreaming.kinemaster.ui.a.e eVar) {
        this.b = boVar;
        this.f3801a = eVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3801a.dismiss();
        new a.C0074a(this.b.getActivity()).d("Transcoding Failed").a(taskError.getMessage()).b("OK", new bu(this)).a().show();
    }
}
