package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.Oh;

/* compiled from: VoiceRecorderFragment.kt */
/* loaded from: classes2.dex */
final class Hh implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ih f21895a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Oh.a f21896b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hh(Ih ih, Oh.a aVar) {
        this.f21895a = ih;
        this.f21896b = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f21896b.a();
        this.f21895a.f21906a.c(R.id.action_play_pause, true);
        this.f21895a.f21906a.l(true);
        this.f21895a.f21906a.k(true);
        this.f21895a.f21906a.j(true);
        this.f21895a.f21906a.h(true);
        this.f21895a.f21906a.i(true);
        this.f21895a.f21906a.J();
    }
}
