package io.grpc.internal;

import io.grpc.P;
import io.opencensus.tags.propagation.TagContextSerializationException;
import java.util.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CensusStatsModule.java */
/* loaded from: classes3.dex */
public class D implements P.d<e.a.e.f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ io.opencensus.tags.propagation.a f27221a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ e.a.e.j f27222b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ E f27223c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(E e2, io.opencensus.tags.propagation.a aVar, e.a.e.j jVar) {
        this.f27223c = e2;
        this.f27221a = aVar;
        this.f27222b = jVar;
    }

    @Override // io.grpc.P.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] toBytes(e.a.e.f fVar) {
        try {
            return this.f27221a.a(fVar);
        } catch (TagContextSerializationException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.grpc.P.d
    public e.a.e.f a(byte[] bArr) {
        try {
            return this.f27221a.a(bArr);
        } catch (Exception e2) {
            E.f27235a.log(Level.FINE, "Failed to parse stats header", (Throwable) e2);
            return this.f27222b.a();
        }
    }
}
