package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {

    /* loaded from: classes2.dex */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:            r5 = r5 + 1;     */
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean[] a(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.a(java.lang.String):boolean[]");
    }

    private static CType a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        if (charAt2 >= '0' && charAt2 <= '9') {
            return CType.TWO_DIGITS;
        }
        return CType.ONE_DIGIT;
    }

    private static int a(CharSequence charSequence, int i, int i2) {
        CType a2;
        CType a3;
        CType a4 = a(charSequence, i);
        if (a4 != CType.UNCODABLE && a4 != CType.ONE_DIGIT) {
            if (i2 == 99) {
                return i2;
            }
            if (i2 == 100) {
                if (a4 == CType.FNC_1 || (a2 = a(charSequence, i + 2)) == CType.UNCODABLE || a2 == CType.ONE_DIGIT) {
                    return i2;
                }
                if (a2 == CType.FNC_1) {
                    return a(charSequence, i + 3) == CType.TWO_DIGITS ? 99 : 100;
                }
                int i3 = i + 4;
                while (true) {
                    a3 = a(charSequence, i3);
                    if (a3 != CType.TWO_DIGITS) {
                        break;
                    }
                    i3 += 2;
                }
                return a3 == CType.ONE_DIGIT ? 100 : 99;
            }
            if (a4 == CType.FNC_1) {
                a4 = a(charSequence, i + 1);
            }
            if (a4 == CType.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }
}
