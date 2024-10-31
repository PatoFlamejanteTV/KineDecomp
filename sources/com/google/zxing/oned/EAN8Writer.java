package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public final class EAN8Writer extends UPCEANWriter {
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] a(String str) {
        if (str.length() == 8) {
            boolean[] zArr = new boolean[67];
            int a2 = OneDimensionalCodeWriter.a(zArr, 0, UPCEANReader.f19166a, true) + 0;
            int i = 0;
            while (i <= 3) {
                int i2 = i + 1;
                a2 += OneDimensionalCodeWriter.a(zArr, a2, UPCEANReader.f19169d[Integer.parseInt(str.substring(i, i2))], false);
                i = i2;
            }
            int a3 = a2 + OneDimensionalCodeWriter.a(zArr, a2, UPCEANReader.f19167b, false);
            int i3 = 4;
            while (i3 <= 7) {
                int i4 = i3 + 1;
                a3 += OneDimensionalCodeWriter.a(zArr, a3, UPCEANReader.f19169d[Integer.parseInt(str.substring(i3, i4))], true);
                i3 = i4;
            }
            OneDimensionalCodeWriter.a(zArr, a3, UPCEANReader.f19166a, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
    }
}
