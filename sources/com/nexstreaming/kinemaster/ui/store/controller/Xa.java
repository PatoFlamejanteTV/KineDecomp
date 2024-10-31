package com.nexstreaming.kinemaster.ui.store.controller;

import android.widget.ProgressBar;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GridPageFragment.java */
/* loaded from: classes2.dex */
public class Xa implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ _a f23511a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xa(_a _aVar) {
        this.f23511a = _aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        ProgressBar progressBar;
        gb gbVar;
        gb gbVar2;
        progressBar = this.f23511a.i;
        progressBar.setVisibility(4);
        this.f23511a.f23524f = null;
        if (this.f23511a.getActivity() != null && c.d.b.m.i.f(this.f23511a.getActivity())) {
            gbVar = this.f23511a.k;
            if (gbVar != null) {
                gbVar2 = this.f23511a.k;
                gbVar2.a(taskError);
            }
        }
    }
}
