package io.grpc.internal;

import io.grpc.internal.Kc;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: GrpcUtil.java */
/* loaded from: classes3.dex */
class Va implements Kc.b<ScheduledExecutorService> {
    @Override // io.grpc.internal.Kc.b
    public void a(ScheduledExecutorService scheduledExecutorService) {
        scheduledExecutorService.shutdown();
    }

    @Override // io.grpc.internal.Kc.b
    public ScheduledExecutorService create() {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, GrpcUtil.a("grpc-timer-%d", true));
        try {
            newScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(newScheduledThreadPool, true);
        } catch (NoSuchMethodException unused) {
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
        return newScheduledThreadPool;
    }
}
