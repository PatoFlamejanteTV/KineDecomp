package com.nexstreaming.kinemaster.ui.store.controller;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.ui.store.model.c;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GridPageFragment.java */
/* loaded from: classes2.dex */
public class Wa implements ResultTask.OnResultAvailableListener<List<InterfaceC1821j>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ _a f23509a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wa(_a _aVar) {
        this.f23509a = _aVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<InterfaceC1821j>> resultTask, Task.Event event, List<InterfaceC1821j> list) {
        ProgressBar progressBar;
        ResultTask<List<InterfaceC1821j>> resultTask2;
        RecyclerView recyclerView;
        nb nbVar;
        nb nbVar2;
        ProgressBar progressBar2;
        nb nbVar3;
        if (this.f23509a.getActivity() != null) {
            resultTask2 = this.f23509a.f23524f;
            if (resultTask2 == resultTask) {
                recyclerView = this.f23509a.f23525g;
                ((GridLayoutManager) recyclerView.getLayoutManager()).setSpanCount(c.d.b.m.f.a(this.f23509a.getActivity()));
                nbVar = this.f23509a.f23523e;
                nbVar.f();
                for (InterfaceC1821j interfaceC1821j : list) {
                    nbVar3 = this.f23509a.f23523e;
                    nbVar3.a(new c.a(this.f23509a.getActivity().getApplicationContext(), interfaceC1821j).a());
                }
                nbVar2 = this.f23509a.f23523e;
                nbVar2.notifyDataSetChanged();
                progressBar2 = this.f23509a.i;
                progressBar2.setVisibility(4);
                this.f23509a.f23524f = null;
                return;
            }
        }
        progressBar = this.f23509a.i;
        progressBar.setVisibility(4);
    }
}