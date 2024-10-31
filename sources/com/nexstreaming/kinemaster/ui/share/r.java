package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
public class r implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f4362a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(k kVar) {
        this.f4362a = kVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        SupportLogger.Event.Export_Fail.log(4);
        this.f4362a.a(taskError);
    }
}
