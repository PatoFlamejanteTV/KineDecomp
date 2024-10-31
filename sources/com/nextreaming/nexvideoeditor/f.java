package com.nextreaming.nexvideoeditor;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.codeccolorformat.ColorFormatChecker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
public class f implements ResultTask.OnResultAvailableListener<ColorFormatChecker.ColorFormat> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditor f4830a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NexEditor nexEditor) {
        this.f4830a = nexEditor;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<ColorFormatChecker.ColorFormat> resultTask, Task.Event event, ColorFormatChecker.ColorFormat colorFormat) {
        Task task;
        Task task2;
        this.f4830a.J = colorFormat;
        if (colorFormat != ColorFormatChecker.ColorFormat.UNKNOWN) {
            this.f4830a.setProperty("setExportColorFormat", colorFormat.name());
            task2 = this.f4830a.P;
            task2.signalEvent(Task.Event.COMPLETE);
        } else {
            task = this.f4830a.P;
            task.signalEvent(Task.Event.FAIL);
        }
    }
}
