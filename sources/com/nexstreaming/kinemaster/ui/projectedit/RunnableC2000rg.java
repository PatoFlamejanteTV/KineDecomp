package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.rg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC2000rg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f22509a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22510b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2000rg(ProjectEditActivity projectEditActivity, boolean z) {
        this.f22510b = projectEditActivity;
        this.f22509a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f22510b.isFinishing()) {
            return;
        }
        this.f22510b.g(this.f22509a);
    }
}
