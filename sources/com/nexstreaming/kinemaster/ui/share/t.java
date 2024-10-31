package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
public class T implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f23299a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ U f23300b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(U u, File file) {
        this.f23300b = u;
        this.f23299a = file;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        File file;
        InterfaceC2240y interfaceC2240y;
        File file2 = this.f23299a;
        file = this.f23300b.f23308h;
        if (file2.renameTo(file)) {
            interfaceC2240y = this.f23300b.t;
            interfaceC2240y.a("Scan exported file...", new String[0]);
            this.f23300b.d();
            return;
        }
        this.f23300b.b(NexEditor.b.lb);
    }
}
