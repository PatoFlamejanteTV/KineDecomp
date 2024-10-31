package io.grpc.internal;

import io.grpc.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.wa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC2498wa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Status f27754a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ea f27755b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2498wa(Ea ea, Status status) {
        this.f27755b = ea;
        this.f27754a = status;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x;
        x = this.f27755b.f27264c;
        x.a(this.f27754a);
    }
}
