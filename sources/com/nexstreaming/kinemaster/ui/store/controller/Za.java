package com.nexstreaming.kinemaster.ui.store.controller;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.network.InterfaceC1822k;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GridPageFragment.java */
/* loaded from: classes2.dex */
public class Za implements ResultTask.OnResultAvailableListener<List<InterfaceC1822k>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f23517a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ _a f23518b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Za(_a _aVar, ResultTask resultTask) {
        this.f23518b = _aVar;
        this.f23517a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<InterfaceC1822k>> resultTask, Task.Event event, List<InterfaceC1822k> list) {
        int i;
        if (list == null || list.size() <= 0) {
            return;
        }
        InterfaceC1822k interfaceC1822k = null;
        Iterator<InterfaceC1822k> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            InterfaceC1822k next = it.next();
            int categoryIdx = next.getCategoryIdx();
            i = this.f23518b.f23520b;
            if (categoryIdx == i) {
                interfaceC1822k = next;
                break;
            }
        }
        if (interfaceC1822k != null) {
            this.f23517a.sendResult(interfaceC1822k);
        }
    }
}
