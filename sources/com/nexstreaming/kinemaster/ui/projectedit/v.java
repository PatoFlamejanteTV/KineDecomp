package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: AudioMenuListFragment.java */
/* loaded from: classes2.dex */
class V implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ X f22149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(X x) {
        this.f22149a = x;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean z;
        this.f22149a.E = false;
        X x = this.f22149a;
        z = x.E;
        x.e(R.id.opt_voicerec_review, z);
    }
}
