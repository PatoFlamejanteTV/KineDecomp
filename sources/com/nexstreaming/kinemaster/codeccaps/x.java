package com.nexstreaming.kinemaster.codeccaps;

import com.google.android.gms.tasks.OnFailureListener;
import com.nexstreaming.app.general.task.Task;

/* compiled from: CapabilityReporter.java */
/* loaded from: classes.dex */
class x implements OnFailureListener {

    /* renamed from: a */
    final /* synthetic */ Task f20138a;

    public x(Task task) {
        this.f20138a = task;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        this.f20138a.sendFailure(Task.makeTaskError(exc));
    }
}
