package com.nexstreaming.kinemaster.ui;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashActivity.kt */
/* loaded from: classes.dex */
public final class o implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SplashActivity f21718a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f21719b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(SplashActivity splashActivity, long j) {
        this.f21718a = splashActivity;
        this.f21719b = j;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        KMUsage.Media_Indexing_End.logEvent("Activity", "SplashActivity", "Duration", KMUsage.bucketParamProjectTime((int) (System.currentTimeMillis() - this.f21719b)));
        SplashActivity splashActivity = this.f21718a;
        splashActivity.c(splashActivity.getIntent());
    }
}
