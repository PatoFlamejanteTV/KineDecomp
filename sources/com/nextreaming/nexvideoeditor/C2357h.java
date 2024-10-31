package com.nextreaming.nexvideoeditor;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.codeccolorformat.ColorFormatChecker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2357h implements ResultTask.OnResultAvailableListener<ColorFormatChecker.ColorFormat> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditor f24715a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2357h(NexEditor nexEditor) {
        this.f24715a = nexEditor;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<ColorFormatChecker.ColorFormat> resultTask, Task.Event event, ColorFormatChecker.ColorFormat colorFormat) {
        Task task;
        Task task2;
        this.f24715a.N = colorFormat;
        if (colorFormat == ColorFormatChecker.ColorFormat.UNKNOWN) {
            task = this.f24715a.Y;
            task.signalEvent(Task.Event.FAIL);
        } else {
            this.f24715a.setProperty("setExportColorFormat", colorFormat.name());
            task2 = this.f24715a.Y;
            task2.signalEvent(Task.Event.COMPLETE);
        }
    }
}
