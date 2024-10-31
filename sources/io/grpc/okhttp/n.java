package io.grpc.okhttp;

import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Kc;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: OkHttpChannelBuilder.java */
/* loaded from: classes3.dex */
class n implements Kc.b<ExecutorService> {
    @Override // io.grpc.internal.Kc.b
    public void a(ExecutorService executorService) {
        executorService.shutdown();
    }

    @Override // io.grpc.internal.Kc.b
    public ExecutorService create() {
        return Executors.newCachedThreadPool(GrpcUtil.a("grpc-okhttp-%d", true));
    }
}
