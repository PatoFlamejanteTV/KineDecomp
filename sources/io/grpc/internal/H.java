package io.grpc.internal;

import io.grpc.P;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CensusTracingModule.java */
/* loaded from: classes3.dex */
public class H implements P.d<io.opencensus.trace.i> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ io.opencensus.trace.propagation.b f27354a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ J f27355b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(J j, io.opencensus.trace.propagation.b bVar) {
        this.f27355b = j;
        this.f27354a = bVar;
    }

    @Override // io.grpc.P.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] toBytes(io.opencensus.trace.i iVar) {
        return this.f27354a.a(iVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.grpc.P.d
    public io.opencensus.trace.i a(byte[] bArr) {
        Logger logger;
        try {
            return this.f27354a.a(bArr);
        } catch (Exception e2) {
            logger = J.f27369a;
            logger.log(Level.FINE, "Failed to parse tracing header", (Throwable) e2);
            return io.opencensus.trace.i.f28074a;
        }
    }
}
