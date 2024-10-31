package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;

/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
class H implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f23280a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(I i) {
        this.f23280a = i;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        InterfaceC2240y interfaceC2240y;
        boolean z;
        boolean z2;
        interfaceC2240y = this.f23280a.f23282a.f23285b.t;
        interfaceC2240y.a("...done.", new String[0]);
        SupportLogger.Event.Export_DetectAndSetColorFormat.log(new int[0]);
        z = this.f23280a.f23282a.f23285b.k;
        if (z) {
            this.f23280a.f23282a.f23285b.g();
            return;
        }
        SupportLogger.Event.Export_GetEffectLibrary.log(new int[0]);
        z2 = this.f23280a.f23282a.f23285b.k;
        if (z2) {
            this.f23280a.f23282a.f23285b.g();
        } else {
            J j = this.f23280a.f23282a;
            j.f23285b.a(j.f23284a);
        }
    }
}
