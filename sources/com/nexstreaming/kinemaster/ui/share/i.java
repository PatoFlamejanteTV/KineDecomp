package com.nexstreaming.kinemaster.ui.share;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
public class I implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ J f23282a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(J j) {
        this.f23282a = j;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        InterfaceC2240y interfaceC2240y;
        boolean z;
        InterfaceC2240y interfaceC2240y2;
        NexEditor nexEditor;
        Context context;
        interfaceC2240y = this.f23282a.f23285b.t;
        interfaceC2240y.a("...media task ready.", new String[0]);
        SupportLogger.Event.Export_MediaTaskNotBusy.log(new int[0]);
        z = this.f23282a.f23285b.k;
        if (z) {
            this.f23282a.f23285b.g();
            return;
        }
        interfaceC2240y2 = this.f23282a.f23285b.t;
        interfaceC2240y2.a("Detecting color format...", new String[0]);
        nexEditor = this.f23282a.f23285b.f23303c;
        context = this.f23282a.f23285b.f23302b;
        nexEditor.a(context).onComplete(new H(this));
    }
}
