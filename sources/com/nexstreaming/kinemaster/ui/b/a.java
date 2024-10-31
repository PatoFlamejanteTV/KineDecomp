package com.nexstreaming.kinemaster.ui.b;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectPreviewFragmentBase.java */
/* loaded from: classes.dex */
public class a implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f21515a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.f21515a = cVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean z;
        if (this.f21515a.isAdded()) {
            this.f21515a.o = false;
            z = this.f21515a.p;
            if (z) {
                this.f21515a.p = false;
                this.f21515a.ua();
            } else {
                this.f21515a.va();
            }
        }
    }
}
