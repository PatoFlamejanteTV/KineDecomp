package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
public class m implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f4357a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.f4357a = kVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        SupportLogger.Event.Export_Fail.log(3);
        this.f4357a.a(NexEditor.b.bk);
    }
}
