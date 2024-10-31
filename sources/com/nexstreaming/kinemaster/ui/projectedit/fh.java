package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: VoiceRecorderFragment.kt */
/* loaded from: classes2.dex */
final class Fh implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Gh f21852a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fh(Gh gh) {
        this.f21852a = gh;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f21852a.f21883c.a();
        this.f21852a.f21881a.f21906a.c(R.id.action_play_pause, true);
        this.f21852a.f21881a.f21906a.l(true);
        this.f21852a.f21881a.f21906a.k(true);
        this.f21852a.f21881a.f21906a.j(true);
        this.f21852a.f21881a.f21906a.h(true);
        this.f21852a.f21881a.f21906a.i(true);
        this.f21852a.f21881a.f21906a.J();
    }
}
