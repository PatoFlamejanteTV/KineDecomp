package com.flurry.sdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f485a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, int i) {
        this.b = gVar;
        this.f485a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        w c;
        if (this.f485a == 200 && (c = a.a().c()) != null) {
            c.b();
        }
    }
}
