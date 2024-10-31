package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.lang.Character;
import java.util.ArrayList;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class zzbn {
    public static int zzC(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes(Keyczar.DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        return zzmw.zza(bytes, 0, bytes.length, 0);
    }

    public static String[] zzD(String str) {
        int i;
        boolean z;
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        char[] charArray = str.toCharArray();
        int length = str.length();
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            int codePointAt = Character.codePointAt(charArray, i3);
            int charCount = Character.charCount(codePointAt);
            if (zzh(codePointAt)) {
                if (z2) {
                    arrayList.add(new String(charArray, i2, i3 - i2));
                }
                arrayList.add(new String(charArray, i3, charCount));
                i = i2;
                z = false;
            } else if (Character.isLetterOrDigit(codePointAt) || Character.getType(codePointAt) == 6 || Character.getType(codePointAt) == 8) {
                if (!z2) {
                    i2 = i3;
                }
                i = i2;
                z = true;
            } else if (z2) {
                arrayList.add(new String(charArray, i2, i3 - i2));
                i = i2;
                z = false;
            } else {
                boolean z3 = z2;
                i = i2;
                z = z3;
            }
            i3 += charCount;
            boolean z4 = z;
            i2 = i;
            z2 = z4;
        }
        if (z2) {
            arrayList.add(new String(charArray, i2, i3 - i2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static boolean zza(Character.UnicodeBlock unicodeBlock) {
        return unicodeBlock == Character.UnicodeBlock.BOPOMOFO || unicodeBlock == Character.UnicodeBlock.BOPOMOFO_EXTENDED || unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY || unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || unicodeBlock == Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS || unicodeBlock == Character.UnicodeBlock.HANGUL_JAMO || unicodeBlock == Character.UnicodeBlock.HANGUL_SYLLABLES || unicodeBlock == Character.UnicodeBlock.HIRAGANA || unicodeBlock == Character.UnicodeBlock.KATAKANA || unicodeBlock == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS;
    }

    static boolean zzh(int i) {
        return Character.isLetter(i) && (zza(Character.UnicodeBlock.of(i)) || zzi(i));
    }

    private static boolean zzi(int i) {
        return (i >= 65382 && i <= 65437) || (i >= 65441 && i <= 65500);
    }
}
