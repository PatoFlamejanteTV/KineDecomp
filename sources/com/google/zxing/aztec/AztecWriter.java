package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes2.dex */
public final class AztecWriter implements Writer {

    /* renamed from: a */
    private static final Charset f18965a = Charset.forName("ISO-8859-1");

    @Override // com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i3;
        int i4;
        Charset charset2 = f18965a;
        if (map != null) {
            if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                charset2 = Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString());
            }
            int parseInt = map.containsKey(EncodeHintType.ERROR_CORRECTION) ? Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString()) : 33;
            if (map.containsKey(EncodeHintType.AZTEC_LAYERS)) {
                charset = charset2;
                i3 = parseInt;
                i4 = Integer.parseInt(map.get(EncodeHintType.AZTEC_LAYERS).toString());
                return a(str, barcodeFormat, i, i2, charset, i3, i4);
            }
            charset = charset2;
            i3 = parseInt;
        } else {
            charset = charset2;
            i3 = 33;
        }
        i4 = 0;
        return a(str, barcodeFormat, i, i2, charset, i3, i4);
    }

    private static BitMatrix a(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return a(Encoder.a(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    private static BitMatrix a(AztecCode aztecCode, int i, int i2) {
        BitMatrix a2 = aztecCode.a();
        if (a2 != null) {
            int c2 = a2.c();
            int b2 = a2.b();
            int max = Math.max(i, c2);
            int max2 = Math.max(i2, b2);
            int min = Math.min(max / c2, max2 / b2);
            int i3 = (max - (c2 * min)) / 2;
            int i4 = (max2 - (b2 * min)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i5 = 0;
            while (i5 < b2) {
                int i6 = i3;
                int i7 = 0;
                while (i7 < c2) {
                    if (a2.a(i7, i5)) {
                        bitMatrix.a(i6, i4, min, min);
                    }
                    i7++;
                    i6 += min;
                }
                i5++;
                i4 += min;
            }
            return bitMatrix;
        }
        throw new IllegalStateException();
    }
}
