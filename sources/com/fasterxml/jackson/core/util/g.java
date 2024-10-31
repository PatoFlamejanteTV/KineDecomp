package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import java.util.regex.Pattern;

/* compiled from: VersionUtil.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    private static final Pattern f9823a = Pattern.compile("[-_./;:]");

    public static Version a(String str, String str2, String str3) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() > 0) {
                String[] split = f9823a.split(trim);
                return new Version(a(split[0]), split.length > 1 ? a(split[1]) : 0, split.length > 2 ? a(split[2]) : 0, split.length > 3 ? split[3] : null, str2, str3);
            }
        }
        return Version.unknownVersion();
    }

    protected static int a(String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt > '9' || charAt < '0') {
                break;
            }
            i = (i * 10) + (charAt - '0');
        }
        return i;
    }

    public static final void a() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }
}
