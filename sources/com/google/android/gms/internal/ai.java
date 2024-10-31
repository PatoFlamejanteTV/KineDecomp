package com.google.android.gms.internal;

import android.text.TextUtils;

/* loaded from: classes.dex */
final class ai extends zzcd {
    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        return (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }

    @Override // com.google.android.gms.internal.zzcd
    public String zzd(String str, String str2) {
        String a2 = a(str);
        String a3 = a(str2);
        return TextUtils.isEmpty(a2) ? a3 : TextUtils.isEmpty(a3) ? a2 : a2 + "," + a3;
    }
}
