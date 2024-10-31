package com.nexstreaming.kinemaster.kmpackage;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.ad;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class e implements ad.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f3449a;
    final /* synthetic */ EffectLibrary b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EffectLibrary effectLibrary, Task task) {
        this.b = effectLibrary;
        this.f3449a = task;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ad.a
    public void a(ai aiVar, boolean z) {
        this.b.a(aiVar);
        this.f3449a.signalEvent(Task.Event.COMPLETE);
        this.b.l();
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ad.a
    public void a(String str, Exception exc, boolean z) {
        if (exc instanceof MissingDependencyException) {
            this.f3449a.sendFailure(EffectLibrary.EffectLibraryTaskError.MissingDependency);
        } else {
            this.f3449a.sendFailure(Task.makeTaskError(str, exc));
        }
    }
}
