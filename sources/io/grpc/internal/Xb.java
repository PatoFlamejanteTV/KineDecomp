package io.grpc.internal;

import io.grpc.C2403b;
import io.grpc.S;
import java.net.URI;
import javax.annotation.Nullable;

/* compiled from: OverrideAuthorityNameResolverFactory.java */
/* loaded from: classes3.dex */
final class Xb extends S.a {

    /* renamed from: b */
    private final S.a f27536b;

    /* renamed from: c */
    private final String f27537c;

    public Xb(S.a aVar, String str) {
        this.f27536b = aVar;
        this.f27537c = str;
    }

    @Override // io.grpc.S.a
    @Nullable
    public io.grpc.S a(URI uri, C2403b c2403b) {
        io.grpc.S a2 = this.f27536b.a(uri, c2403b);
        if (a2 == null) {
            return null;
        }
        return new Wb(this, a2);
    }

    @Override // io.grpc.S.a
    public String a() {
        return this.f27536b.a();
    }
}
