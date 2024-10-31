package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import java.util.Arrays;
import java.util.logging.Logger;

/* compiled from: TransportFrameUtil.java */
/* loaded from: classes3.dex */
public final class Pc {

    /* renamed from: a */
    private static final Logger f27465a = Logger.getLogger(Pc.class.getName());

    /* renamed from: b */
    private static final byte[] f27466b = "-bin".getBytes(Charsets.f15076a);

    private Pc() {
    }

    public static byte[][] a(io.grpc.P p) {
        byte[][] b2 = io.grpc.F.b(p);
        if (b2 == null) {
            return new byte[0];
        }
        int i = 0;
        for (int i2 = 0; i2 < b2.length; i2 += 2) {
            byte[] bArr = b2[i2];
            byte[] bArr2 = b2[i2 + 1];
            if (a(bArr, f27466b)) {
                b2[i] = bArr;
                b2[i + 1] = BaseEncoding.b().a(bArr2).getBytes(Charsets.f15076a);
            } else if (a(bArr2)) {
                b2[i] = bArr;
                b2[i + 1] = bArr2;
            } else {
                String str = new String(bArr, Charsets.f15076a);
                f27465a.warning("Metadata key=" + str + ", value=" + Arrays.toString(bArr2) + " contains invalid ASCII characters");
            }
            i += 2;
        }
        return i == b2.length ? b2 : (byte[][]) Arrays.copyOfRange(b2, 0, i);
    }

    public static byte[][] a(byte[][] bArr) {
        for (int i = 0; i < bArr.length; i += 2) {
            byte[] bArr2 = bArr[i];
            int i2 = i + 1;
            byte[] bArr3 = bArr[i2];
            bArr[i] = bArr2;
            if (a(bArr2, f27466b)) {
                bArr[i2] = BaseEncoding.b().a(new String(bArr3, Charsets.f15076a));
            }
        }
        return bArr;
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i = length; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i - length]) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(byte[] bArr) {
        for (byte b2 : bArr) {
            if (b2 < 32 || b2 > 126) {
                return false;
            }
        }
        return true;
    }
}
