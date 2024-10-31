package io.grpc.internal;

import io.grpc.internal.Kc;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: GrpcUtil.java */
/* loaded from: classes3.dex */
class Ua implements Kc.b<ExecutorService> {
    public String toString() {
        return "grpc-default-executor";
    }

    @Override // io.grpc.internal.Kc.b
    public void a(ExecutorService executorService) {
        executorService.shutdown();
    }

    @Override // io.grpc.internal.Kc.b
    public ExecutorService create() {
        return Executors.newCachedThreadPool(GrpcUtil.a("grpc-default-executor-%d", true));
    }
}
