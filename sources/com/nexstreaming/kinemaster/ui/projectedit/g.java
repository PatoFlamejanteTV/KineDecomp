package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioMenuListFragment.java */
/* loaded from: classes.dex */
public class g implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f3917a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.f3917a = eVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean z;
        this.f3917a.c = false;
        e eVar = this.f3917a;
        z = this.f3917a.c;
        eVar.c(R.id.opt_voicerec_review, z);
    }
}
