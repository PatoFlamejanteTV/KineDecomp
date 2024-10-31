package com.nextreaming.nexeditorui;

/* compiled from: RelaunchActivity.java */
/* loaded from: classes.dex */
class ed implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ec f4620a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed(ec ecVar) {
        this.f4620a = ecVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4620a.f4619a.setResult(-1);
        this.f4620a.f4619a.finish();
    }
}
