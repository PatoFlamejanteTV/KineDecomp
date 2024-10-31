package com.birbit.android.jobqueue;

/* compiled from: CallbackManager.java */
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f8131a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.f8131a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8131a.f8132a.a(new c(this));
    }
}
