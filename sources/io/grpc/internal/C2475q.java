package io.grpc.internal;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AtomicLongCounter.java */
/* renamed from: io.grpc.internal.q */
/* loaded from: classes3.dex */
public final class C2475q implements InterfaceC2496vb {

    /* renamed from: a */
    private final AtomicLong f27721a = new AtomicLong();

    @Override // io.grpc.internal.InterfaceC2496vb
    public void add(long j) {
        this.f27721a.getAndAdd(j);
    }
}
