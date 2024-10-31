package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
public class G implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f23278a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(U u) {
        this.f23278a = u;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        SupportLogger.Event.Export_Fail.log(3);
        this.f23278a.b(NexEditor.b.kb);
    }
}
