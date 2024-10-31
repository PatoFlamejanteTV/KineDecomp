package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.DialogInterface;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.usage.AssetDownloadResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetDetailFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.store.controller.ua, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2282ua implements ResultTask.OnResultAvailableListener<com.nexstreaming.app.general.service.download.k> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2290ya f23622a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2282ua(C2290ya c2290ya) {
        this.f23622a = c2290ya;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<com.nexstreaming.app.general.service.download.k> resultTask, Task.Event event, com.nexstreaming.app.general.service.download.k kVar) {
        InterfaceC1821j interfaceC1821j;
        InterfaceC1821j interfaceC1821j2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        c.d.a.a.d.a.d dVar;
        InterfaceC1821j interfaceC1821j3;
        interfaceC1821j = this.f23622a.w;
        if (interfaceC1821j == null || kVar == null) {
            return;
        }
        interfaceC1821j2 = this.f23622a.w;
        com.nexstreaming.kinemaster.usage.analytics.j.a(interfaceC1821j2, AssetDownloadResult.SUCCESS);
        progressBar = this.f23622a.q;
        progressBar.setVisibility(4);
        textView = this.f23622a.n;
        textView.setVisibility(4);
        textView2 = this.f23622a.o;
        textView2.setVisibility(0);
        textView3 = this.f23622a.o;
        textView3.setText(R.string.installing_assets);
        textView4 = this.f23622a.o;
        textView4.setEnabled(false);
        dVar = this.f23622a.v;
        interfaceC1821j3 = this.f23622a.w;
        dVar.a(interfaceC1821j3, this.f23622a).onComplete(new Task.OnTaskEventListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.b
            @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
            public final void onTaskEvent(Task task, Task.Event event2) {
                C2282ua.this.a(task, event2);
            }
        }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.c
            @Override // com.nexstreaming.app.general.task.Task.OnFailListener
            public final void onFail(Task task, Task.Event event2, Task.TaskError taskError) {
                C2282ua.this.a(task, event2, taskError);
            }
        });
    }

    public /* synthetic */ void a(Task task, Task.Event event) {
        InterfaceC1821j interfaceC1821j;
        C2290ya c2290ya = this.f23622a;
        interfaceC1821j = c2290ya.w;
        c2290ya.b(interfaceC1821j, false);
    }

    public /* synthetic */ void a(Task task, Task.Event event, Task.TaskError taskError) {
        boolean z;
        InterfaceC1821j interfaceC1821j;
        if (this.f23622a.getActivity() == null || this.f23622a.getActivity().isFinishing()) {
            return;
        }
        e.a aVar = new e.a(this.f23622a.getActivity());
        aVar.c(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        aVar.a(taskError.getLocalizedMessage(this.f23622a.getActivity()));
        z = this.f23622a.x;
        if (z && taskError.getException() != null) {
            aVar.b(taskError.getException().getMessage());
        }
        aVar.a().show();
        C2290ya c2290ya = this.f23622a;
        interfaceC1821j = c2290ya.w;
        c2290ya.b(interfaceC1821j, false);
    }
}
