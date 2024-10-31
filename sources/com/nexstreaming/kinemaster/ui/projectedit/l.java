package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: AudioMenuListFragment.java */
/* loaded from: classes.dex */
class l implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f4053a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar) {
        this.f4053a = eVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean z;
        this.f4053a.c = false;
        e eVar = this.f4053a;
        z = this.f4053a.c;
        eVar.c(R.id.opt_voicerec_review, z);
    }
}
