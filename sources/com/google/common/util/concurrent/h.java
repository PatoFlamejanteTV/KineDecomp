package com.google.common.util.concurrent;

/* compiled from: AbstractService.java */
/* loaded from: classes2.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f2978a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f2978a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2978a.f2977a.f2955a.a(this.f2978a.b, this.f2978a.c);
    }
}
