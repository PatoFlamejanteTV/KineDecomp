package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.mr;

/* compiled from: VoiceRecorderFragment.java */
/* loaded from: classes.dex */
class mi implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ mr.a f4090a;
    final /* synthetic */ mh b;

    public mi(mh mhVar, mr.a aVar) {
        this.b = mhVar;
        this.f4090a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4090a.b();
        this.b.f4089a.d(R.id.action_play_pause, true);
        this.b.f4089a.i(true);
        this.b.f4089a.j(true);
        this.b.f4089a.k(true);
        this.b.f4089a.l(true);
        this.b.f4089a.m(true);
        this.b.f4089a.k();
    }
}
