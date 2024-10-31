package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.P;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Pc;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

/* compiled from: Headers.java */
/* loaded from: classes3.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    public static final io.grpc.okhttp.internal.framed.c f27976a = new io.grpc.okhttp.internal.framed.c(io.grpc.okhttp.internal.framed.c.f27911d, "https");

    /* renamed from: b, reason: collision with root package name */
    public static final io.grpc.okhttp.internal.framed.c f27977b = new io.grpc.okhttp.internal.framed.c(io.grpc.okhttp.internal.framed.c.f27909b, "POST");

    /* renamed from: c, reason: collision with root package name */
    public static final io.grpc.okhttp.internal.framed.c f27978c = new io.grpc.okhttp.internal.framed.c(io.grpc.okhttp.internal.framed.c.f27909b, "GET");

    /* renamed from: d, reason: collision with root package name */
    public static final io.grpc.okhttp.internal.framed.c f27979d = new io.grpc.okhttp.internal.framed.c(GrpcUtil.i.b(), "application/grpc");

    /* renamed from: e, reason: collision with root package name */
    public static final io.grpc.okhttp.internal.framed.c f27980e = new io.grpc.okhttp.internal.framed.c("te", "trailers");

    public static List<io.grpc.okhttp.internal.framed.c> a(P p, String str, String str2, String str3, boolean z) {
        Preconditions.a(p, "headers");
        Preconditions.a(str, "defaultPath");
        Preconditions.a(str2, "authority");
        p.a(GrpcUtil.i);
        p.a(GrpcUtil.j);
        p.a(GrpcUtil.k);
        ArrayList arrayList = new ArrayList(io.grpc.F.a(p) + 7);
        arrayList.add(f27976a);
        if (z) {
            arrayList.add(f27978c);
        } else {
            arrayList.add(f27977b);
        }
        arrayList.add(new io.grpc.okhttp.internal.framed.c(io.grpc.okhttp.internal.framed.c.f27912e, str2));
        arrayList.add(new io.grpc.okhttp.internal.framed.c(io.grpc.okhttp.internal.framed.c.f27910c, str));
        arrayList.add(new io.grpc.okhttp.internal.framed.c(GrpcUtil.k.b(), str3));
        arrayList.add(f27979d);
        arrayList.add(f27980e);
        byte[][] a2 = Pc.a(p);
        for (int i = 0; i < a2.length; i += 2) {
            ByteString of = ByteString.of(a2[i]);
            if (a(of.utf8())) {
                arrayList.add(new io.grpc.okhttp.internal.framed.c(of, ByteString.of(a2[i + 1])));
            }
        }
        return arrayList;
    }

    private static boolean a(String str) {
        return (str.startsWith(":") || GrpcUtil.i.b().equalsIgnoreCase(str) || GrpcUtil.k.b().equalsIgnoreCase(str)) ? false : true;
    }
}
