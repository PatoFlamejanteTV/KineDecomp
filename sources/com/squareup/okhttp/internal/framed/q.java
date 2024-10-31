package com.squareup.okhttp.internal.framed;

import okio.ByteString;

/* compiled from: Header.java */
/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a */
    public static final ByteString f25355a = ByteString.encodeUtf8(":status");

    /* renamed from: b */
    public static final ByteString f25356b = ByteString.encodeUtf8(":method");

    /* renamed from: c */
    public static final ByteString f25357c = ByteString.encodeUtf8(":path");

    /* renamed from: d */
    public static final ByteString f25358d = ByteString.encodeUtf8(":scheme");

    /* renamed from: e */
    public static final ByteString f25359e = ByteString.encodeUtf8(":authority");

    /* renamed from: f */
    public static final ByteString f25360f = ByteString.encodeUtf8(":host");

    /* renamed from: g */
    public static final ByteString f25361g = ByteString.encodeUtf8(":version");

    /* renamed from: h */
    public final ByteString f25362h;
    public final ByteString i;
    final int j;

    public q(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f25362h.equals(qVar.f25362h) && this.i.equals(qVar.i);
    }

    public int hashCode() {
        return ((527 + this.f25362h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.f25362h.utf8(), this.i.utf8());
    }

    public q(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public q(ByteString byteString, ByteString byteString2) {
        this.f25362h = byteString;
        this.i = byteString2;
        this.j = byteString.size() + 32 + byteString2.size();
    }
}
