package com.fasterxml.jackson.core.util;

import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class BufferRecycler {

    /* renamed from: a, reason: collision with root package name */
    protected final byte[][] f440a = new byte[ByteBufferType.values().length];
    protected final char[][] b = new char[CharBufferType.values().length];

    /* loaded from: classes.dex */
    public enum ByteBufferType {
        READ_IO_BUFFER(LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT),
        WRITE_ENCODING_BUFFER(LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT),
        WRITE_CONCAT_BUFFER(2000),
        BASE64_CODEC_BUFFER(2000);

        protected final int size;

        ByteBufferType(int i) {
            this.size = i;
        }
    }

    /* loaded from: classes.dex */
    public enum CharBufferType {
        TOKEN_BUFFER(2000),
        CONCAT_BUFFER(2000),
        TEXT_BUFFER(200),
        NAME_COPY_BUFFER(200);

        protected final int size;

        CharBufferType(int i) {
            this.size = i;
        }
    }

    public final byte[] a(ByteBufferType byteBufferType) {
        int ordinal = byteBufferType.ordinal();
        byte[] bArr = this.f440a[ordinal];
        if (bArr == null) {
            return a(byteBufferType.size);
        }
        this.f440a[ordinal] = null;
        return bArr;
    }

    public final void a(ByteBufferType byteBufferType, byte[] bArr) {
        this.f440a[byteBufferType.ordinal()] = bArr;
    }

    public final char[] a(CharBufferType charBufferType) {
        return a(charBufferType, 0);
    }

    public final char[] a(CharBufferType charBufferType, int i) {
        if (charBufferType.size > i) {
            i = charBufferType.size;
        }
        int ordinal = charBufferType.ordinal();
        char[] cArr = this.b[ordinal];
        if (cArr == null || cArr.length < i) {
            return b(i);
        }
        this.b[ordinal] = null;
        return cArr;
    }

    public final void a(CharBufferType charBufferType, char[] cArr) {
        this.b[charBufferType.ordinal()] = cArr;
    }

    private byte[] a(int i) {
        return new byte[i];
    }

    private char[] b(int i) {
        return new char[i];
    }
}
