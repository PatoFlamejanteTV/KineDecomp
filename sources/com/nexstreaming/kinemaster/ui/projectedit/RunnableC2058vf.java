package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import java.util.List;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.vf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC2058vf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22742a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2058vf(ProjectEditActivity projectEditActivity) {
        this.f22742a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<android.arch.lifecycle.s> v;
        v = this.f22742a.v();
        for (android.arch.lifecycle.s sVar : v) {
            if (sVar instanceof ProjectEditActivity.b) {
                ((ProjectEditActivity.b) sVar).a(this.f22742a);
            }
        }
    }
}
