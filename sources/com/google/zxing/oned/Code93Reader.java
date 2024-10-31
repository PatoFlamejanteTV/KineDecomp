package com.google.zxing.oned;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes2.dex */
public final class Code93Reader extends OneDReader {

    /* renamed from: a */
    private static final char[] f19153a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: b */
    static final int[] f19154b;

    /* renamed from: c */
    private static final int f19155c;

    /* renamed from: d */
    private final StringBuilder f19156d = new StringBuilder(20);

    /* renamed from: e */
    private final int[] f19157e = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, ErrorCode.NetWorkError.RETRY_TIME_NATIVE_ERROR, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, ErrorCode.NetWorkError.IMG_LOAD_ERROR, 410, 364, 358, 310, 314, ErrorCode.InitError.INIT_PLUGIN_ERROR, 468, 466, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 366, 374, 430, 294, 474, 470, 306, 350};
        f19154b = iArr;
        f19155c = iArr[47];
    }
}
