package com.google.android.gms.nearby.messages.devices;

import java.util.Arrays;

/* loaded from: classes.dex */
abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f2108a = "0123456789abcdef".toCharArray();
    private final byte[] b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(byte[] bArr) {
        this.b = bArr;
    }

    static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(f2108a[(b >> 4) & 15]).append(f2108a[b & 15]);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return a(this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass().isAssignableFrom(getClass())) {
            return Arrays.equals(this.b, ((a) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.b);
    }

    public String toString() {
        return a(this.b);
    }
}
