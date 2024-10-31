package io.grpc.internal;

import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;

/* compiled from: GrpcUtil.java */
/* loaded from: classes3.dex */
class Wa implements Supplier<Stopwatch> {
    @Override // com.google.common.base.Supplier
    public Stopwatch get() {
        return Stopwatch.b();
    }
}
