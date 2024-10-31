package com.adobe.xmp.a;

import java.io.UnsupportedEncodingException;

/* compiled from: Latin1Converter.java */
/* loaded from: classes.dex */
public class f {
    public static b a(b bVar) {
        if (!"UTF-8".equals(bVar.b())) {
            return bVar;
        }
        byte[] bArr = new byte[8];
        b bVar2 = new b((bVar.c() * 4) / 3);
        int i = 0;
        char c2 = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < bVar.c()) {
            int a2 = bVar.a(i);
            if (c2 == 11) {
                if (i2 > 0 && (a2 & 192) == 128) {
                    int i4 = i3 + 1;
                    bArr[i3] = (byte) a2;
                    i2--;
                    if (i2 == 0) {
                        bVar2.a(bArr, 0, i4);
                    } else {
                        i3 = i4;
                    }
                } else {
                    bVar2.a(a(bArr[0]));
                    i -= i3;
                }
                c2 = 0;
                i3 = 0;
            } else if (a2 < 127) {
                bVar2.a((byte) a2);
            } else if (a2 >= 192) {
                int i5 = -1;
                for (int i6 = a2; i5 < 8 && (i6 & 128) == 128; i6 <<= 1) {
                    i5++;
                }
                bArr[i3] = (byte) a2;
                i3++;
                i2 = i5;
                c2 = 11;
            } else {
                bVar2.a(a((byte) a2));
            }
            i++;
        }
        if (c2 == 11) {
            for (int i7 = 0; i7 < i3; i7++) {
                bVar2.a(a(bArr[i7]));
            }
        }
        return bVar2;
    }

    private static byte[] a(byte b2) {
        int i = b2 & 255;
        if (i >= 128) {
            try {
                if (i != 129 && i != 141 && i != 143 && i != 144 && i != 157) {
                    return new String(new byte[]{b2}, "cp1252").getBytes("UTF-8");
                }
                return new byte[]{32};
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return new byte[]{b2};
    }
}
