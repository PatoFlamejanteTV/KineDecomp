package com.nexstreaming.kinemaster.ui.b;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectPreviewFragmentBase.java */
/* loaded from: classes.dex */
public class d implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3688a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f3688a = cVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean z;
        if (this.f3688a.isAdded()) {
            this.f3688a.d = false;
            z = this.f3688a.e;
            if (z) {
                this.f3688a.e = false;
                this.f3688a.f_();
            } else {
                this.f3688a.e();
            }
        }
    }
}
