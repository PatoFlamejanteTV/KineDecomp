package io.grpc.internal;

import io.grpc.internal.Kc;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: SharedResourceHolder.java */
/* loaded from: classes3.dex */
class Ic implements Kc.c {
    @Override // io.grpc.internal.Kc.c
    public ScheduledExecutorService a() {
        return Executors.newSingleThreadScheduledExecutor(GrpcUtil.a("grpc-shared-destroyer-%d", true));
    }
}
