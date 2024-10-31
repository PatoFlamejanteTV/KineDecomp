package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public final class DataMatrixWriter implements Writer {
    @Override // com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Dimension dimension;
        if (!str.isEmpty()) {
            if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
                throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
            }
            if (i >= 0 && i2 >= 0) {
                SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
                Dimension dimension2 = null;
                if (map != null) {
                    SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
                    if (symbolShapeHint2 != null) {
                        symbolShapeHint = symbolShapeHint2;
                    }
                    dimension = (Dimension) map.get(EncodeHintType.MIN_SIZE);
                    if (dimension == null) {
                        dimension = null;
                    }
                    Dimension dimension3 = (Dimension) map.get(EncodeHintType.MAX_SIZE);
                    if (dimension3 != null) {
                        dimension2 = dimension3;
                    }
                } else {
                    dimension = null;
                }
                String a2 = HighLevelEncoder.a(str, symbolShapeHint, dimension, dimension2);
                SymbolInfo a3 = SymbolInfo.a(a2.length(), symbolShapeHint, dimension, dimension2, true);
                DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.a(a2, a3), a3.e(), a3.d());
                defaultPlacement.a();
                return a(defaultPlacement, a3);
            }
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        throw new IllegalArgumentException("Found empty contents");
    }

    private static BitMatrix a(DefaultPlacement defaultPlacement, SymbolInfo symbolInfo) {
        int e2 = symbolInfo.e();
        int d2 = symbolInfo.d();
        ByteMatrix byteMatrix = new ByteMatrix(symbolInfo.g(), symbolInfo.f());
        int i = 0;
        for (int i2 = 0; i2 < d2; i2++) {
            if (i2 % symbolInfo.f19120g == 0) {
                int i3 = 0;
                for (int i4 = 0; i4 < symbolInfo.g(); i4++) {
                    byteMatrix.a(i3, i, i4 % 2 == 0);
                    i3++;
                }
                i++;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < e2; i6++) {
                if (i6 % symbolInfo.f19119f == 0) {
                    byteMatrix.a(i5, i, true);
                    i5++;
                }
                byteMatrix.a(i5, i, defaultPlacement.a(i6, i2));
                i5++;
                int i7 = symbolInfo.f19119f;
                if (i6 % i7 == i7 - 1) {
                    byteMatrix.a(i5, i, i2 % 2 == 0);
                    i5++;
                }
            }
            i++;
            int i8 = symbolInfo.f19120g;
            if (i2 % i8 == i8 - 1) {
                int i9 = 0;
                for (int i10 = 0; i10 < symbolInfo.g(); i10++) {
                    byteMatrix.a(i9, i, true);
                    i9++;
                }
                i++;
            }
        }
        return a(byteMatrix);
    }

    private static BitMatrix a(ByteMatrix byteMatrix) {
        int c2 = byteMatrix.c();
        int b2 = byteMatrix.b();
        BitMatrix bitMatrix = new BitMatrix(c2, b2);
        bitMatrix.a();
        for (int i = 0; i < c2; i++) {
            for (int i2 = 0; i2 < b2; i2++) {
                if (byteMatrix.a(i, i2) == 1) {
                    bitMatrix.b(i, i2);
                }
            }
        }
        return bitMatrix;
    }
}
