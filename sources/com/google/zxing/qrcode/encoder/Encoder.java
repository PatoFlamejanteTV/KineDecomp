package com.google.zxing.qrcode.encoder;

import android.support.v7.widget.ActivityChooserView;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Encoder {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f19254a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private Encoder() {
    }

    private static int a(ByteMatrix byteMatrix) {
        return c.a(byteMatrix) + c.b(byteMatrix) + c.c(byteMatrix) + c.d(byteMatrix);
    }

    static void b(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                bitArray.a((charAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    bitArray.a((charAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    bitArray.a(charAt, 4);
                }
            }
        }
    }

    public static QRCode a(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        Version a2;
        CharacterSetECI characterSetECIByName;
        String obj = (map == null || !map.containsKey(EncodeHintType.CHARACTER_SET)) ? "ISO-8859-1" : map.get(EncodeHintType.CHARACTER_SET).toString();
        Mode a3 = a(str, obj);
        BitArray bitArray = new BitArray();
        if (a3 == Mode.BYTE && !"ISO-8859-1".equals(obj) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(obj)) != null) {
            a(characterSetECIByName, bitArray);
        }
        a(a3, bitArray);
        BitArray bitArray2 = new BitArray();
        a(str, a3, bitArray2, obj);
        if (map != null && map.containsKey(EncodeHintType.QR_VERSION)) {
            a2 = Version.a(Integer.parseInt(map.get(EncodeHintType.QR_VERSION).toString()));
            if (!a(a(a3, bitArray, bitArray2, a2), a2, errorCorrectionLevel)) {
                throw new WriterException("Data too big for requested version");
            }
        } else {
            a2 = a(errorCorrectionLevel, a3, bitArray, bitArray2);
        }
        BitArray bitArray3 = new BitArray();
        bitArray3.a(bitArray);
        a(a3 == Mode.BYTE ? bitArray2.b() : str.length(), a2, a3, bitArray3);
        bitArray3.a(bitArray2);
        Version.ECBlocks a4 = a2.a(errorCorrectionLevel);
        int b2 = a2.b() - a4.d();
        a(b2, bitArray3);
        BitArray a5 = a(bitArray3, a2.b(), b2, a4.c());
        QRCode qRCode = new QRCode();
        qRCode.a(errorCorrectionLevel);
        qRCode.a(a3);
        qRCode.a(a2);
        int a6 = a2.a();
        ByteMatrix byteMatrix = new ByteMatrix(a6, a6);
        int a7 = a(a5, errorCorrectionLevel, a2, byteMatrix);
        qRCode.b(a7);
        d.a(a5, errorCorrectionLevel, a2, a7, byteMatrix);
        qRCode.a(byteMatrix);
        return qRCode;
    }

    private static Version a(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, BitArray bitArray, BitArray bitArray2) throws WriterException {
        return a(a(mode, bitArray, bitArray2, a(a(mode, bitArray, bitArray2, Version.a(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    private static int a(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        return bitArray.a() + mode.getCharacterCountBits(version) + bitArray2.a();
    }

    static int a(int i) {
        int[] iArr = f19254a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    private static Mode a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && a(str)) {
            return Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else {
                if (a(charAt) == -1) {
                    return Mode.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return Mode.ALPHANUMERIC;
        }
        if (z2) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            d.a(bitArray, errorCorrectionLevel, version, i3, byteMatrix);
            int a2 = a(byteMatrix);
            if (a2 < i) {
                i2 = i3;
                i = a2;
            }
        }
        return i2;
    }

    private static Version a(int i, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            Version a2 = Version.a(i2);
            if (a(i, a2, errorCorrectionLevel)) {
                return a2;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean a(int i, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        return version.b() - version.a(errorCorrectionLevel).d() >= (i + 7) / 8;
    }

    static void a(int i, BitArray bitArray) throws WriterException {
        int i2 = i << 3;
        if (bitArray.a() <= i2) {
            for (int i3 = 0; i3 < 4 && bitArray.a() < i2; i3++) {
                bitArray.a(false);
            }
            int a2 = bitArray.a() & 7;
            if (a2 > 0) {
                while (a2 < 8) {
                    bitArray.a(false);
                    a2++;
                }
            }
            int b2 = i - bitArray.b();
            for (int i4 = 0; i4 < b2; i4++) {
                bitArray.a((i4 & 1) == 0 ? 236 : 17, 8);
            }
            if (bitArray.a() != i2) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + bitArray.a() + " > " + i2);
    }

    static void a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 < i3) {
            int i5 = i % i3;
            int i6 = i3 - i5;
            int i7 = i / i3;
            int i8 = i7 + 1;
            int i9 = i2 / i3;
            int i10 = i9 + 1;
            int i11 = i7 - i9;
            int i12 = i8 - i10;
            if (i11 != i12) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i3 != i6 + i5) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i11;
                return;
            } else {
                iArr[0] = i10;
                iArr2[0] = i12;
                return;
            }
        }
        throw new WriterException("Block ID too large");
    }

    static BitArray a(BitArray bitArray, int i, int i2, int i3) throws WriterException {
        if (bitArray.b() == i2) {
            ArrayList arrayList = new ArrayList(i3);
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                a(i, i2, i3, i7, iArr, iArr2);
                int i8 = iArr[0];
                byte[] bArr = new byte[i8];
                bitArray.a(i4 << 3, bArr, 0, i8);
                byte[] a2 = a(bArr, iArr2[0]);
                arrayList.add(new a(bArr, a2));
                i5 = Math.max(i5, i8);
                i6 = Math.max(i6, a2.length);
                i4 += iArr[0];
            }
            if (i2 == i4) {
                BitArray bitArray2 = new BitArray();
                for (int i9 = 0; i9 < i5; i9++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] a3 = ((a) it.next()).a();
                        if (i9 < a3.length) {
                            bitArray2.a(a3[i9], 8);
                        }
                    }
                }
                for (int i10 = 0; i10 < i6; i10++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] b2 = ((a) it2.next()).b();
                        if (i10 < b2.length) {
                            bitArray2.a(b2[i10], 8);
                        }
                    }
                }
                if (i == bitArray2.b()) {
                    return bitArray2;
                }
                throw new WriterException("Interleaving error: " + i + " and " + bitArray2.b() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    static byte[] a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new ReedSolomonEncoder(GenericGF.f19082e).a(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static void a(Mode mode, BitArray bitArray) {
        bitArray.a(mode.getBits(), 4);
    }

    static void a(int i, Version version, Mode mode, BitArray bitArray) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i2 = 1 << characterCountBits;
        if (i < i2) {
            bitArray.a(i, characterCountBits);
            return;
        }
        throw new WriterException(i + " is bigger than " + (i2 - 1));
    }

    static void a(String str, Mode mode, BitArray bitArray, String str2) throws WriterException {
        int i = b.f19262a[mode.ordinal()];
        if (i == 1) {
            b(str, bitArray);
            return;
        }
        if (i == 2) {
            a((CharSequence) str, bitArray);
            return;
        }
        if (i == 3) {
            a(str, bitArray, str2);
        } else if (i == 4) {
            a(str, bitArray);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    static void a(CharSequence charSequence, BitArray bitArray) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a2 = a(charSequence.charAt(i));
            if (a2 == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int a3 = a(charSequence.charAt(i2));
                if (a3 != -1) {
                    bitArray.a((a2 * 45) + a3, 11);
                    i += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                bitArray.a(a2, 6);
                i = i2;
            }
        }
    }

    static void a(String str, BitArray bitArray, String str2) throws WriterException {
        try {
            for (byte b2 : str.getBytes(str2)) {
                bitArray.a(b2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[LOOP:0: B:4:0x0008->B:11:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.lang.String r6, com.google.zxing.common.BitArray r7) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L4d
            int r0 = r6.length
            r1 = 0
        L8:
            if (r1 >= r0) goto L4c
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L24
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L24
        L22:
            int r2 = r2 - r3
            goto L33
        L24:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L32
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L32
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L22
        L32:
            r2 = -1
        L33:
            if (r2 == r4) goto L44
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.a(r3, r2)
            int r1 = r1 + 2
            goto L8
        L44:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L4c:
            return
        L4d:
            r6 = move-exception
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            r7.<init>(r6)
            goto L55
        L54:
            throw r7
        L55:
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.a(java.lang.String, com.google.zxing.common.BitArray):void");
    }

    private static void a(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.a(Mode.ECI.getBits(), 4);
        bitArray.a(characterSetECI.getValue(), 8);
    }
}
