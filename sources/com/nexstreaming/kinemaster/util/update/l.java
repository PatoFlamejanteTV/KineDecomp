package com.nexstreaming.kinemaster.util.update;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
public class l implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f23963a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(m mVar) {
        this.f23963a = mVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f23963a.f23965b.f23967b.O();
    }
}
