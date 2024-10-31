package io.grpc.internal;

import io.grpc.F;

/* compiled from: Http2ClientStreamTransportState.java */
/* loaded from: classes3.dex */
class Za implements F.a<Integer> {
    @Override // io.grpc.P.g
    public /* bridge */ /* synthetic */ byte[] a(Object obj) {
        a((Integer) obj);
        throw null;
    }

    public byte[] a(Integer num) {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.P.g
    public Integer a(byte[] bArr) {
        if (bArr.length >= 3) {
            return Integer.valueOf(((bArr[0] - 48) * 100) + ((bArr[1] - 48) * 10) + (bArr[2] - 48));
        }
        throw new NumberFormatException("Malformed status code " + new String(bArr, io.grpc.F.f27090a));
    }
}
