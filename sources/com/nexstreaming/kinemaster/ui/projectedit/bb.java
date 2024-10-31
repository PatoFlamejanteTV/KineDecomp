package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.a.e;

/* compiled from: MediaEditFragment.java */
/* loaded from: classes2.dex */
public class Bb implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.r f21781a;

    /* renamed from: b */
    final /* synthetic */ Mb f21782b;

    public Bb(Mb mb, com.nexstreaming.kinemaster.ui.a.r rVar) {
        this.f21782b = mb;
        this.f21781a = rVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f21781a.dismiss();
        e.a aVar = new e.a(this.f21782b.getActivity());
        aVar.c("Transcoding Failed");
        aVar.a(taskError.getMessage());
        aVar.a("OK", new Ab(this));
        aVar.a().show();
    }
}
