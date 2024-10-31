package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;

/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
class u implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f4365a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.f4365a = sVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        boolean z;
        SupportLogger.Event.Export_Fail.log(5);
        z = this.f4365a.b.k;
        if (z) {
            this.f4365a.b.e();
        } else {
            this.f4365a.b.a(taskError);
        }
    }
}
