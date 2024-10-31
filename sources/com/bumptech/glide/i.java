package com.bumptech.glide;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f8521a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(j jVar) {
        this.f8521a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVar = this.f8521a;
        jVar.f8527f.b(jVar);
    }
}
