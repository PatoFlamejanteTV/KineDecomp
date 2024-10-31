package com.google.android.gms.internal.ads;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class zzoa {
    private final String[] zzbef;
    private final int[] zzbeg;
    private final String[] zzbeh;
    private final int zzbei;

    private zzoa(String[] strArr, int[] iArr, String[] strArr2, int i) {
        this.zzbef = strArr;
        this.zzbeg = iArr;
        this.zzbeh = strArr2;
        this.zzbei = i;
    }

    public static zzoa zzaa(String str) {
        String str2;
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        strArr[0] = "";
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int indexOf = str.indexOf("$", i);
            char c2 = 65535;
            if (indexOf == -1) {
                String valueOf = String.valueOf(strArr[i2]);
                String valueOf2 = String.valueOf(str.substring(i));
                strArr[i2] = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                i = str.length();
            } else if (indexOf != i) {
                String valueOf3 = String.valueOf(strArr[i2]);
                String valueOf4 = String.valueOf(str.substring(i, indexOf));
                strArr[i2] = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                i = indexOf;
            } else if (str.startsWith("$$", i)) {
                strArr[i2] = String.valueOf(strArr[i2]).concat("$");
                i += 2;
            } else {
                int i3 = i + 1;
                int indexOf2 = str.indexOf("$", i3);
                String substring = str.substring(i3, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i2] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith(com.umeng.commonsdk.proguard.e.am)) {
                            str2 = String.valueOf(str2).concat(com.umeng.commonsdk.proguard.e.am);
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    int hashCode = substring.hashCode();
                    if (hashCode != -1950496919) {
                        if (hashCode != 2606829) {
                            if (hashCode == 38199441 && substring.equals("Bandwidth")) {
                                c2 = 1;
                            }
                        } else if (substring.equals("Time")) {
                            c2 = 2;
                        }
                    } else if (substring.equals("Number")) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        iArr[i2] = 2;
                    } else if (c2 == 1) {
                        iArr[i2] = 3;
                    } else {
                        if (c2 != 2) {
                            String valueOf5 = String.valueOf(str);
                            throw new IllegalArgumentException(valueOf5.length() != 0 ? "Invalid template: ".concat(valueOf5) : new String("Invalid template: "));
                        }
                        iArr[i2] = 4;
                    }
                    strArr2[i2] = str2;
                }
                i2++;
                strArr[i2] = "";
                i = indexOf2 + 1;
            }
        }
        return new zzoa(strArr, iArr, strArr2, i2);
    }

    public final String zza(String str, int i, int i2, long j) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            int i4 = this.zzbei;
            if (i3 < i4) {
                sb.append(this.zzbef[i3]);
                int[] iArr = this.zzbeg;
                if (iArr[i3] == 1) {
                    sb.append(str);
                } else if (iArr[i3] == 2) {
                    sb.append(String.format(Locale.US, this.zzbeh[i3], Integer.valueOf(i)));
                } else if (iArr[i3] == 3) {
                    sb.append(String.format(Locale.US, this.zzbeh[i3], Integer.valueOf(i2)));
                } else if (iArr[i3] == 4) {
                    sb.append(String.format(Locale.US, this.zzbeh[i3], Long.valueOf(j)));
                }
                i3++;
            } else {
                sb.append(this.zzbef[i4]);
                return sb.toString();
            }
        }
    }
}
