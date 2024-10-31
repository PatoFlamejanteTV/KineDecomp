package org.keyczar.util;

import org.keyczar.exceptions.Base64DecodingException;
import org.keyczar.i18n.Messages;

/* loaded from: classes.dex */
public class Base64Coder {
    private static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
    private static final byte[] DECODE = new byte[128];
    private static final char[] WHITESPACE = {'\t', '\n', '\r', ' ', '\f'};

    static {
        for (int i = 0; i < DECODE.length; i++) {
            DECODE[i] = -1;
        }
        for (int i2 = 0; i2 < WHITESPACE.length; i2++) {
            DECODE[WHITESPACE[i2]] = -2;
        }
        for (int i3 = 0; i3 < ALPHABET.length; i3++) {
            DECODE[ALPHABET[i3]] = (byte) i3;
        }
    }

    private Base64Coder() {
    }

    @Deprecated
    public static byte[] decode(String str) throws Base64DecodingException {
        return decodeWebSafe(str);
    }

    public static byte[] decodeWebSafe(String str) throws Base64DecodingException {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        if (charArray[length - 1] == '=') {
            length--;
        }
        if (charArray[length - 1] == '=') {
            length--;
        }
        int i = 0;
        for (char c : charArray) {
            if (isWhiteSpace(c)) {
                i++;
            }
        }
        int i2 = length - i;
        int i3 = (i2 / 4) * 3;
        switch (i2 % 4) {
            case 1:
                throw new Base64DecodingException(Messages.getString("Base64Coder.IllegalLength", Integer.valueOf(i2)));
            case 2:
                i3++;
                break;
            case 3:
                i3 += 2;
                break;
        }
        byte[] bArr = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i2 + i; i7++) {
            if (!isWhiteSpace(charArray[i7])) {
                i6 = (i6 << 6) | getByte(charArray[i7]);
                i5++;
            }
            if (i5 == 4) {
                int i8 = i4 + 1;
                bArr[i4] = (byte) (i6 >> 16);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (i6 >> 8);
                i4 = i9 + 1;
                bArr[i9] = (byte) i6;
                i5 = 0;
                i6 = 0;
            }
        }
        switch (i5) {
            case 2:
                int i10 = i4 + 1;
                bArr[i4] = (byte) (i6 >> 4);
                break;
            case 3:
                int i11 = i4 + 1;
                bArr[i4] = (byte) (i6 >> 10);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (i6 >> 2);
                break;
        }
        return bArr;
    }

    public static byte[] decodeMime(String str) throws Base64DecodingException {
        return decodeWebSafe(str.replace('+', '-').replace('/', '_'));
    }

    @Deprecated
    public static String encode(byte[] bArr) {
        return encodeWebSafe(bArr);
    }

    public static String encodeWebSafe(byte[] bArr) {
        int i = 0;
        int length = bArr.length / 3;
        int length2 = bArr.length % 3;
        int i2 = length * 4;
        switch (length2) {
            case 1:
                i2 += 2;
                break;
            case 2:
                i2 += 3;
                break;
        }
        char[] cArr = new char[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = i5 + 1;
            int i7 = ((bArr[i5] & 255) << 8) | ((bArr[i] & 255) << 16);
            i = i6 + 1;
            int i8 = i7 | (bArr[i6] & 255);
            int i9 = i3 + 1;
            cArr[i3] = ALPHABET[(i8 >> 18) & 63];
            int i10 = i9 + 1;
            cArr[i9] = ALPHABET[(i8 >> 12) & 63];
            int i11 = i10 + 1;
            cArr[i10] = ALPHABET[(i8 >> 6) & 63];
            i3 = i11 + 1;
            cArr[i11] = ALPHABET[i8 & 63];
        }
        if (length2 > 0) {
            int i12 = i + 1;
            int i13 = (bArr[i] & 255) << 16;
            if (length2 == 2) {
                int i14 = i12 + 1;
                i13 |= (bArr[i12] & 255) << 8;
            }
            int i15 = i3 + 1;
            cArr[i3] = ALPHABET[(i13 >> 18) & 63];
            int i16 = i15 + 1;
            cArr[i15] = ALPHABET[(i13 >> 12) & 63];
            if (length2 == 2) {
                int i17 = i16 + 1;
                cArr[i16] = ALPHABET[(i13 >> 6) & 63];
            }
        }
        return new String(cArr);
    }

    public static String encodeMime(byte[] bArr, boolean z) {
        String replace = encodeWebSafe(bArr).replace('-', '+').replace('_', '/');
        switch (replace.length() % 4) {
            case 0:
                return replace;
            case 1:
            default:
                throw new RuntimeException("Bug in Base64 encoder");
            case 2:
                return replace + "==";
            case 3:
                return replace + "=";
        }
    }

    private static byte getByte(int i) throws Base64DecodingException {
        if (i < 0 || i > 127 || DECODE[i] == -1) {
            throw new Base64DecodingException(Messages.getString("Base64Coder.IllegalCharacter", Integer.valueOf(i)));
        }
        return DECODE[i];
    }

    private static boolean isWhiteSpace(int i) {
        return DECODE[i] == -2;
    }
}
