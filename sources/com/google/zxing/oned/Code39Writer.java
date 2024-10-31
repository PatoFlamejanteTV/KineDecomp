package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Code39Writer extends OneDimensionalCodeWriter {
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int i = length + 25;
            int i2 = 0;
            while (i2 < length) {
                int indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i2));
                if (indexOf >= 0) {
                    a(Code39Reader.f19147a[indexOf], iArr);
                    int i3 = i;
                    for (int i4 = 0; i4 < 9; i4++) {
                        i3 += iArr[i4];
                    }
                    i2++;
                    i = i3;
                } else {
                    throw new IllegalArgumentException("Bad contents: " + str);
                }
            }
            boolean[] zArr = new boolean[i];
            a(Code39Reader.f19148b, iArr);
            int a2 = OneDimensionalCodeWriter.a(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int a3 = a2 + OneDimensionalCodeWriter.a(zArr, a2, iArr2, false);
            for (int i5 = 0; i5 < length; i5++) {
                a(Code39Reader.f19147a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i5))], iArr);
                int a4 = a3 + OneDimensionalCodeWriter.a(zArr, a3, iArr, true);
                a3 = a4 + OneDimensionalCodeWriter.a(zArr, a4, iArr2, false);
            }
            a(Code39Reader.f19148b, iArr);
            OneDimensionalCodeWriter.a(zArr, a3, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    private static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }
}
