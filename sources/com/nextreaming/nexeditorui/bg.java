package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.tracelog.a;

/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
public class bg implements ResultTask.OnResultAvailableListener<a.C0073a> {

    /* renamed from: a */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.a f4544a;
    final /* synthetic */ ba b;

    public bg(ba baVar, com.nexstreaming.kinemaster.ui.a.a aVar) {
        this.b = baVar;
        this.f4544a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a */
    public void onResultAvailable(ResultTask<a.C0073a> resultTask, Task.Event event, a.C0073a c0073a) {
        this.f4544a.dismiss();
    }
}
