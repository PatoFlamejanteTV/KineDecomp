package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
public class L implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f23287a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(U u) {
        this.f23287a = u;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        boolean z;
        SupportLogger.Event.Export_Fail.log(5);
        z = this.f23287a.k;
        if (z) {
            this.f23287a.g();
        } else {
            this.f23287a.b(taskError);
        }
    }
}
