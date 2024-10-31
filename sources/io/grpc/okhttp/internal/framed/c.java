package io.grpc.okhttp.internal.framed;

import okio.ByteString;

/* compiled from: Header.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a */
    public static final ByteString f27908a = ByteString.encodeUtf8(":status");

    /* renamed from: b */
    public static final ByteString f27909b = ByteString.encodeUtf8(":method");

    /* renamed from: c */
    public static final ByteString f27910c = ByteString.encodeUtf8(":path");

    /* renamed from: d */
    public static final ByteString f27911d = ByteString.encodeUtf8(":scheme");

    /* renamed from: e */
    public static final ByteString f27912e = ByteString.encodeUtf8(":authority");

    /* renamed from: f */
    public static final ByteString f27913f = ByteString.encodeUtf8(":host");

    /* renamed from: g */
    public static final ByteString f27914g = ByteString.encodeUtf8(":version");

    /* renamed from: h */
    public final ByteString f27915h;
    public final ByteString i;
    final int j;

    public c(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f27915h.equals(cVar.f27915h) && this.i.equals(cVar.i);
    }

    public int hashCode() {
        return ((527 + this.f27915h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.f27915h.utf8(), this.i.utf8());
    }

    public c(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public c(ByteString byteString, ByteString byteString2) {
        this.f27915h = byteString;
        this.i = byteString2;
        this.j = byteString.size() + 32 + byteString2.size();
    }
}
