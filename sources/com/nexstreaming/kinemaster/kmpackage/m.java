package com.nexstreaming.kinemaster.kmpackage;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class m implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EffectLibrary f3457a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EffectLibrary effectLibrary) {
        this.f3457a = effectLibrary;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean z;
        Task task2;
        z = this.f3457a.K;
        if (z) {
            this.f3457a.K = false;
            EffectLibrary effectLibrary = this.f3457a;
            task2 = this.f3457a.ad;
            effectLibrary.a(task2);
        }
    }
}
