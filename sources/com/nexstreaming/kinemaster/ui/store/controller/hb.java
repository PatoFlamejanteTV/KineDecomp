package com.nexstreaming.kinemaster.ui.store.controller;

/* compiled from: StoreActivity.java */
/* loaded from: classes2.dex */
class hb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f23564a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ StoreActivity f23565b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hb(StoreActivity storeActivity, boolean z) {
        this.f23565b = storeActivity;
        this.f23564a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f23565b.isFinishing()) {
            return;
        }
        this.f23565b.g(this.f23564a);
    }
}
