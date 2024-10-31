package com.google.zxing.oned;

import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes2.dex */
public final class Code39Reader extends OneDReader {

    /* renamed from: a */
    static final int[] f19147a;

    /* renamed from: b */
    static final int f19148b;

    /* renamed from: c */
    private final boolean f19149c;

    /* renamed from: d */
    private final boolean f19150d;

    /* renamed from: e */
    private final StringBuilder f19151e;

    /* renamed from: f */
    private final int[] f19152f;

    static {
        int[] iArr = {52, 289, 97, 352, 49, ErrorCode.InitError.INVALID_REQUEST_ERROR, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42};
        f19147a = iArr;
        f19148b = iArr[39];
    }

    public Code39Reader() {
        this(false);
    }

    public Code39Reader(boolean z) {
        this(z, false);
    }

    public Code39Reader(boolean z, boolean z2) {
        this.f19149c = z;
        this.f19150d = z2;
        this.f19151e = new StringBuilder(20);
        this.f19152f = new int[9];
    }
}
