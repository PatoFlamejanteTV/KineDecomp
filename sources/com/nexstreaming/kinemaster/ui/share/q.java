package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;

/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
class q implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f4361a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.f4361a = pVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        f fVar;
        boolean z;
        fVar = this.f4361a.f4360a.f4359a.b.t;
        fVar.a("...effect library ready.", new String[0]);
        SupportLogger.Event.Export_GetEffectLibrary.log(new int[0]);
        z = this.f4361a.f4360a.f4359a.b.k;
        if (z) {
            this.f4361a.f4360a.f4359a.b.e();
        } else {
            this.f4361a.f4360a.f4359a.b.a(this.f4361a.f4360a.f4359a.f4358a);
        }
    }
}
