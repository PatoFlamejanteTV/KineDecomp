package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.og, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC1974og implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1974og(ProjectEditActivity projectEditActivity) {
        this.f22473a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Handler handler;
        z = ProjectEditActivity.H;
        if (z) {
            handler = this.f22473a.na;
            handler.post(new RunnableC1965ng(this));
        }
    }
}
