package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public final class EAN13Writer extends UPCEANWriter {
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] a(String str) {
        if (str.length() == 13) {
            try {
                if (UPCEANReader.a(str)) {
                    int i = EAN13Reader.i[Integer.parseInt(str.substring(0, 1))];
                    boolean[] zArr = new boolean[95];
                    int a2 = OneDimensionalCodeWriter.a(zArr, 0, UPCEANReader.f19166a, true) + 0;
                    int i2 = 1;
                    while (i2 <= 6) {
                        int i3 = i2 + 1;
                        int parseInt = Integer.parseInt(str.substring(i2, i3));
                        if (((i >> (6 - i2)) & 1) == 1) {
                            parseInt += 10;
                        }
                        a2 += OneDimensionalCodeWriter.a(zArr, a2, UPCEANReader.f19170e[parseInt], false);
                        i2 = i3;
                    }
                    int a3 = a2 + OneDimensionalCodeWriter.a(zArr, a2, UPCEANReader.f19167b, false);
                    int i4 = 7;
                    while (i4 <= 12) {
                        int i5 = i4 + 1;
                        a3 += OneDimensionalCodeWriter.a(zArr, a3, UPCEANReader.f19169d[Integer.parseInt(str.substring(i4, i5))], true);
                        i4 = i5;
                    }
                    OneDimensionalCodeWriter.a(zArr, a3, UPCEANReader.f19166a, true);
                    return zArr;
                }
                throw new IllegalArgumentException("Contents do not pass checksum");
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
    }
}
