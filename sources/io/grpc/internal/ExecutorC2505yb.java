package io.grpc.internal;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ManagedChannelImpl.java */
/* renamed from: io.grpc.internal.yb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ExecutorC2505yb implements Executor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fb f27801a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorC2505yb(Fb fb) {
        this.f27801a = fb;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f27801a.o.a(runnable);
        this.f27801a.o.a();
    }
}
