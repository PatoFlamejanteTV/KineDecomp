package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class zzqd {
    private static String zza(StringBuilder sb, int i, int i2) {
        int i3;
        int i4;
        if (i >= i2) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int i5 = i;
        int i6 = i2;
        while (true) {
            for (int i7 = i5; i7 <= i6; i7++) {
                if (i7 == i6) {
                    i3 = i7;
                } else if (sb.charAt(i7) == '/') {
                    i3 = i7 + 1;
                }
                int i8 = i5 + 1;
                if (i7 == i8 && sb.charAt(i5) == '.') {
                    sb.delete(i5, i3);
                    i4 = i3 - i5;
                } else if (i7 == i5 + 2 && sb.charAt(i5) == '.' && sb.charAt(i8) == '.') {
                    i5 = sb.lastIndexOf("/", i5 - 2) + 1;
                    int i9 = i5 > i ? i5 : i;
                    sb.delete(i9, i3);
                    i4 = i3 - i9;
                } else {
                    i5 = i7 + 1;
                }
                i6 -= i4;
            }
            return sb.toString();
        }
    }

    private static int[] zzag(String str) {
        int i;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i2 = indexOf4 + 2;
        if (i2 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i2) == '/') {
            i = str.indexOf(47, indexOf4 + 3);
            if (i == -1 || i > indexOf2) {
                i = indexOf2;
            }
        } else {
            i = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    public static String zzc(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] zzag = zzag(str2);
        if (zzag[0] != -1) {
            sb.append(str2);
            zza(sb, zzag[1], zzag[2]);
            return sb.toString();
        }
        int[] zzag2 = zzag(str);
        if (zzag[3] == 0) {
            sb.append((CharSequence) str, 0, zzag2[3]);
            sb.append(str2);
            return sb.toString();
        }
        if (zzag[2] == 0) {
            sb.append((CharSequence) str, 0, zzag2[2]);
            sb.append(str2);
            return sb.toString();
        }
        if (zzag[1] != 0) {
            int i = zzag2[0] + 1;
            sb.append((CharSequence) str, 0, i);
            sb.append(str2);
            return zza(sb, zzag[1] + i, i + zzag[2]);
        }
        if (str2.charAt(zzag[1]) == '/') {
            sb.append((CharSequence) str, 0, zzag2[1]);
            sb.append(str2);
            return zza(sb, zzag2[1], zzag2[1] + zzag[2]);
        }
        if (zzag2[0] + 2 < zzag2[1] && zzag2[1] == zzag2[2]) {
            sb.append((CharSequence) str, 0, zzag2[1]);
            sb.append('/');
            sb.append(str2);
            return zza(sb, zzag2[1], zzag2[1] + zzag[2] + 1);
        }
        int lastIndexOf = str.lastIndexOf(47, zzag2[2] - 1);
        int i2 = lastIndexOf == -1 ? zzag2[1] : lastIndexOf + 1;
        sb.append((CharSequence) str, 0, i2);
        sb.append(str2);
        return zza(sb, zzag2[1], i2 + zzag[2]);
    }
}
