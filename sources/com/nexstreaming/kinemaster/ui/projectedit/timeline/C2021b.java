package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [OUT] */
/* compiled from: DecoResourceWorker.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2021b<OUT> implements ResultTask.OnResultAvailableListener<OUT> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f22663a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC2022c f22664b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2021b(AbstractC2022c abstractC2022c, WeakReference weakReference) {
        this.f22664b = abstractC2022c;
        this.f22663a = weakReference;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    public void onResultAvailable(ResultTask<OUT> resultTask, Task.Event event, OUT out) {
        InterfaceC2026g interfaceC2026g = (InterfaceC2026g) this.f22663a.get();
        if (out == null || interfaceC2026g == null || interfaceC2026g.getSerialNumber() != resultTask.getTaskId()) {
            return;
        }
        interfaceC2026g.setDecoData(out);
    }
}
