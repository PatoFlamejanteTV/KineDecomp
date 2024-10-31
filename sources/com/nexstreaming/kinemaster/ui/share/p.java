package com.nexstreaming.kinemaster.ui.share;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;

/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
class p implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f4360a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f4360a = oVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        f fVar;
        boolean z;
        f fVar2;
        Context context;
        fVar = this.f4360a.f4359a.b.t;
        fVar.a("...done.", new String[0]);
        SupportLogger.Event.Export_DetectAndSetColorFormat.log(new int[0]);
        z = this.f4360a.f4359a.b.k;
        if (z) {
            this.f4360a.f4359a.b.e();
            return;
        }
        fVar2 = this.f4360a.f4359a.b.t;
        fVar2.a("Wait for effect library...", new String[0]);
        context = this.f4360a.f4359a.b.b;
        EffectLibrary.a(context).b().onComplete(new q(this));
    }
}
