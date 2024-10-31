package com.nexstreaming.kinemaster.ui;

import android.view.View;
import android.view.Window;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashActivity.kt */
/* loaded from: classes.dex */
public final class n implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SplashActivity f21717a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SplashActivity splashActivity) {
        this.f21717a = splashActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        com.nexstreaming.kinemaster.ui.a.r rVar2;
        com.nexstreaming.kinemaster.ui.a.r rVar3;
        com.nexstreaming.kinemaster.ui.a.r rVar4;
        rVar = this.f21717a.J;
        if (rVar != null) {
            rVar2 = this.f21717a.J;
            if (rVar2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            Window window = rVar2.getWindow();
            if (window == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            View decorView = window.getDecorView();
            kotlin.jvm.internal.h.a((Object) decorView, "mediaIndexingProgressDialog!!.window!!.decorView");
            if (decorView.getParent() != null) {
                rVar3 = this.f21717a.J;
                if (rVar3 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (rVar3.isShowing()) {
                    rVar4 = this.f21717a.J;
                    if (rVar4 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    rVar4.dismiss();
                    SplashActivity splashActivity = this.f21717a;
                    splashActivity.c(splashActivity.getIntent());
                }
            }
        }
        this.f21717a.J = null;
        SplashActivity splashActivity2 = this.f21717a;
        splashActivity2.c(splashActivity2.getIntent());
    }
}
