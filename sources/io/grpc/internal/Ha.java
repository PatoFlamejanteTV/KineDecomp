package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.C2403b;
import java.net.URI;

/* compiled from: DnsNameResolverProvider.java */
/* loaded from: classes3.dex */
public final class Ha extends io.grpc.U {
    @Override // io.grpc.S.a
    public String a() {
        return "dns";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.U
    public boolean c() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.U
    public int d() {
        return 5;
    }

    @Override // io.grpc.S.a
    public Ga a(URI uri, C2403b c2403b) {
        if (!"dns".equals(uri.getScheme())) {
            return null;
        }
        String path = uri.getPath();
        Preconditions.a(path, "targetPath");
        String str = path;
        Preconditions.a(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new Ga(uri.getAuthority(), str.substring(1), c2403b, GrpcUtil.s, GrpcUtil.a());
    }
}
