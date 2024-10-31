package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
public class n implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f4358a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar, boolean z) {
        this.b = kVar;
        this.f4358a = z;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        f fVar;
        boolean z;
        f fVar2;
        fVar = this.b.t;
        if (fVar.a()) {
            this.b.d();
        }
        SupportLogger.Event.Export_ProjectLoaded.log(new int[0]);
        z = this.b.k;
        if (z) {
            this.b.e();
            return;
        }
        fVar2 = this.b.t;
        fVar2.a("Wait for media task...", new String[0]);
        MediaInfo.q().onComplete(new o(this));
    }
}
