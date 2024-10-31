package io.grpc.okhttp;

import io.grpc.P;
import io.grpc.internal.Pc;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: Utils.java */
/* loaded from: classes3.dex */
public class F {

    /* renamed from: a */
    private static final Logger f27842a = Logger.getLogger(F.class.getName());

    private F() {
    }

    public static P a(List<io.grpc.okhttp.internal.framed.c> list) {
        return io.grpc.F.a(c(list));
    }

    public static P b(List<io.grpc.okhttp.internal.framed.c> list) {
        return io.grpc.F.a(c(list));
    }

    private static byte[][] c(List<io.grpc.okhttp.internal.framed.c> list) {
        byte[][] bArr = new byte[list.size() * 2];
        int i = 0;
        for (io.grpc.okhttp.internal.framed.c cVar : list) {
            int i2 = i + 1;
            bArr[i] = cVar.f27915h.toByteArray();
            i = i2 + 1;
            bArr[i2] = cVar.i.toByteArray();
        }
        Pc.a(bArr);
        return bArr;
    }
}
