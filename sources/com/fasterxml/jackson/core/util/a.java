package com.fasterxml.jackson.core.util;

import com.google.protos.datapol.SemanticAnnotations;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* compiled from: BufferRecycler.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static final int[] f9798a = {io.fabric.sdk.android.a.b.c.MAX_BYTE_SIZE_PER_FILE, io.fabric.sdk.android.a.b.c.MAX_BYTE_SIZE_PER_FILE, SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE, SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE};

    /* renamed from: b */
    private static final int[] f9799b = {LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT, LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT, 200, 200};

    /* renamed from: c */
    protected final byte[][] f9800c;

    /* renamed from: d */
    protected final char[][] f9801d;

    public a() {
        this(4, 4);
    }

    public final byte[] a(int i) {
        return a(i, 0);
    }

    public final char[] b(int i) {
        return b(i, 0);
    }

    protected byte[] c(int i) {
        return new byte[i];
    }

    protected int d(int i) {
        return f9798a[i];
    }

    protected char[] e(int i) {
        return new char[i];
    }

    protected int f(int i) {
        return f9799b[i];
    }

    protected a(int i, int i2) {
        this.f9800c = new byte[i];
        this.f9801d = new char[i2];
    }

    public byte[] a(int i, int i2) {
        int d2 = d(i);
        if (i2 < d2) {
            i2 = d2;
        }
        byte[][] bArr = this.f9800c;
        byte[] bArr2 = bArr[i];
        if (bArr2 != null && bArr2.length >= i2) {
            bArr[i] = null;
            return bArr2;
        }
        return c(i2);
    }

    public char[] b(int i, int i2) {
        int f2 = f(i);
        if (i2 < f2) {
            i2 = f2;
        }
        char[][] cArr = this.f9801d;
        char[] cArr2 = cArr[i];
        if (cArr2 != null && cArr2.length >= i2) {
            cArr[i] = null;
            return cArr2;
        }
        return e(i2);
    }

    public void a(int i, byte[] bArr) {
        this.f9800c[i] = bArr;
    }

    public void a(int i, char[] cArr) {
        this.f9801d[i] = cArr;
    }
}
