package com.nexstreaming.kinemaster.ui.store.controller;

import android.widget.ProgressBar;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GridPageFragment.java */
/* loaded from: classes2.dex */
public class Va implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ _a f23505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Va(_a _aVar) {
        this.f23505a = _aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        ProgressBar progressBar;
        gb gbVar;
        gb gbVar2;
        progressBar = this.f23505a.i;
        progressBar.setVisibility(4);
        this.f23505a.f23524f = null;
        if (this.f23505a.getActivity() != null && c.d.b.m.i.f(this.f23505a.getActivity())) {
            gbVar = this.f23505a.k;
            if (gbVar != null) {
                gbVar2 = this.f23505a.k;
                gbVar2.a(taskError);
            }
        }
    }
}
