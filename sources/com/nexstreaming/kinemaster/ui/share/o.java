package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;

/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
class O implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ P f23293a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(P p) {
        this.f23293a = p;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        File file;
        InterfaceC2240y interfaceC2240y;
        S s = this.f23293a.f23294a.f23295a;
        File file2 = s.f23297b;
        file = s.f23298c.f23308h;
        if (file2.renameTo(file)) {
            interfaceC2240y = this.f23293a.f23294a.f23295a.f23298c.t;
            interfaceC2240y.a("Scan exported file...", new String[0]);
            this.f23293a.f23294a.f23295a.f23298c.d();
            return;
        }
        this.f23293a.f23294a.f23295a.f23298c.b(NexEditor.b.lb);
    }
}
