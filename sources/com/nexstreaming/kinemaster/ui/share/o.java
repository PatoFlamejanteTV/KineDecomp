package com.nexstreaming.kinemaster.ui.share;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
class o implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f4359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f4359a = nVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        f fVar;
        boolean z;
        f fVar2;
        NexEditor nexEditor;
        Context context;
        fVar = this.f4359a.b.t;
        fVar.a("...media task ready.", new String[0]);
        SupportLogger.Event.Export_MediaTaskNotBusy.log(new int[0]);
        z = this.f4359a.b.k;
        if (z) {
            this.f4359a.b.e();
            return;
        }
        fVar2 = this.f4359a.b.t;
        fVar2.a("Detecting color format...", new String[0]);
        nexEditor = this.f4359a.b.c;
        context = this.f4359a.b.b;
        nexEditor.a(context).onComplete(new p(this));
    }
}
