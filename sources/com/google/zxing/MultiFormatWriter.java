package com.google.zxing;

import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.Code93Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.UPCEWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MultiFormatWriter implements Writer {
    @Override // com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        Writer eAN8Writer;
        switch (a.f18964a[barcodeFormat.ordinal()]) {
            case 1:
                eAN8Writer = new EAN8Writer();
                break;
            case 2:
                eAN8Writer = new UPCEWriter();
                break;
            case 3:
                eAN8Writer = new EAN13Writer();
                break;
            case 4:
                eAN8Writer = new UPCAWriter();
                break;
            case 5:
                eAN8Writer = new QRCodeWriter();
                break;
            case 6:
                eAN8Writer = new Code39Writer();
                break;
            case 7:
                eAN8Writer = new Code93Writer();
                break;
            case 8:
                eAN8Writer = new Code128Writer();
                break;
            case 9:
                eAN8Writer = new ITFWriter();
                break;
            case 10:
                eAN8Writer = new PDF417Writer();
                break;
            case 11:
                eAN8Writer = new CodaBarWriter();
                break;
            case 12:
                eAN8Writer = new DataMatrixWriter();
                break;
            case 13:
                eAN8Writer = new AztecWriter();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return eAN8Writer.a(str, barcodeFormat, i, i2, map);
    }
}
