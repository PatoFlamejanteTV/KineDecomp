package com.nexstreaming.kinemaster.ui;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashActivity.kt */
/* loaded from: classes.dex */
public final class m implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SplashActivity f21640a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SplashActivity splashActivity) {
        this.f21640a = splashActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public final void onProgress(Task task, Task.Event event, int i, int i2) {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        com.nexstreaming.kinemaster.ui.a.r rVar2;
        com.nexstreaming.kinemaster.ui.a.r rVar3;
        com.nexstreaming.kinemaster.ui.a.r rVar4;
        rVar = this.f21640a.J;
        if (rVar != null) {
            rVar2 = this.f21640a.J;
            if (rVar2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (rVar2.isShowing()) {
                rVar3 = this.f21640a.J;
                if (rVar3 != null) {
                    rVar3.j(i);
                    rVar4 = this.f21640a.J;
                    if (rVar4 != null) {
                        rVar4.i(i2);
                        return;
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }
}
