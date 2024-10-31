package io.grpc.okhttp;

import io.grpc.internal.Tc;
import io.grpc.internal.Uc;

/* compiled from: OkHttpWritableBufferAllocator.java */
/* loaded from: classes3.dex */
class C implements Uc {
    @Override // io.grpc.internal.Uc
    public Tc a(int i) {
        return new B(new okio.g(), Math.min(1048576, Math.max(4096, i)));
    }
}
