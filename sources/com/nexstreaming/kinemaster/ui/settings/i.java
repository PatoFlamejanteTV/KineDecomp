package com.nexstreaming.kinemaster.ui.settings;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccountInfoFragment.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4258a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.f4258a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4258a.b != null) {
            this.f4258a.a(this.f4258a.b, this.f4258a.b.m());
            this.f4258a.b(this.f4258a.b, this.f4258a.b.m());
            this.f4258a.c(this.f4258a.b, this.f4258a.b.m());
        }
    }
}
