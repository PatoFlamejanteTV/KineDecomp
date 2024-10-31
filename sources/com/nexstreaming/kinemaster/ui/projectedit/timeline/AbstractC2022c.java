package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.lang.ref.WeakReference;

/* compiled from: DecoResourceWorker.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.c */
/* loaded from: classes2.dex */
public abstract class AbstractC2022c<IN, OUT> {
    protected abstract ResultTask<OUT> a(IN in);

    public void a(IN in, InterfaceC2026g interfaceC2026g) {
        if (in == null || interfaceC2026g == null) {
            return;
        }
        ResultTask<OUT> a2 = a(in);
        interfaceC2026g.setSerialNumber(a2.getTaskId());
        a2.onResultAvailable(new C2021b(this, new WeakReference(interfaceC2026g))).onFailure((Task.OnFailListener) new C2020a(this));
    }
}
