package com.nexstreaming.kinemaster.util.update;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
public class k implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f23962a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(m mVar) {
        this.f23962a = mVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f23962a.f23965b.f23967b.d(R.string.asset_install_failed);
    }
}
