package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

/* loaded from: classes2.dex */
public final class QRCodeWriter implements Writer {
    @Override // com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (!str.isEmpty()) {
            if (barcodeFormat != BarcodeFormat.QR_CODE) {
                throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
            }
            if (i >= 0 && i2 >= 0) {
                ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
                int i3 = 4;
                if (map != null) {
                    if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                        errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(EncodeHintType.ERROR_CORRECTION).toString());
                    }
                    if (map.containsKey(EncodeHintType.MARGIN)) {
                        i3 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
                    }
                }
                return a(Encoder.a(str, errorCorrectionLevel, map), i, i2, i3);
            }
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        throw new IllegalArgumentException("Found empty contents");
    }

    private static BitMatrix a(QRCode qRCode, int i, int i2, int i3) {
        ByteMatrix a2 = qRCode.a();
        if (a2 != null) {
            int c2 = a2.c();
            int b2 = a2.b();
            int i4 = i3 << 1;
            int i5 = c2 + i4;
            int i6 = i4 + b2;
            int max = Math.max(i, i5);
            int max2 = Math.max(i2, i6);
            int min = Math.min(max / i5, max2 / i6);
            int i7 = (max - (c2 * min)) / 2;
            int i8 = (max2 - (b2 * min)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i9 = 0;
            while (i9 < b2) {
                int i10 = i7;
                int i11 = 0;
                while (i11 < c2) {
                    if (a2.a(i11, i9) == 1) {
                        bitMatrix.a(i10, i8, min, min);
                    }
                    i11++;
                    i10 += min;
                }
                i9++;
                i8 += min;
            }
            return bitMatrix;
        }
        throw new IllegalStateException();
    }
}
