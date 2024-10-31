package io.grpc;

import io.grpc.P;
import java.nio.charset.Charset;

/* compiled from: InternalMetadata.java */
/* loaded from: classes3.dex */
public final class F {

    /* renamed from: a */
    public static final Charset f27090a = Charset.forName("US-ASCII");

    /* compiled from: InternalMetadata.java */
    /* loaded from: classes3.dex */
    public interface a<T> extends P.g<T> {
    }

    public static <T> P.e<T> a(String str, a<T> aVar) {
        boolean z = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z = true;
        }
        return P.e.a(str, z, aVar);
    }

    public static byte[][] b(P p) {
        return p.b();
    }

    public static P a(byte[]... bArr) {
        return new P(bArr);
    }

    public static int a(P p) {
        return p.a();
    }
}
