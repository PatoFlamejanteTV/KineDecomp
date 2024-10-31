package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import org.keyczar.Keyczar;

/* compiled from: VersionUtil.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f443a = Pattern.compile("[-_./;:]");
    private final Version b;

    /* JADX INFO: Access modifiers changed from: protected */
    public c() {
        Version version = null;
        try {
            version = a(getClass());
        } catch (Exception e) {
            System.err.println("ERROR: Failed to load Version information for bundle (via " + getClass().getName() + ").");
        }
        this.b = version == null ? Version.unknownVersion() : version;
    }

    public Version a() {
        return this.b;
    }

    public static Version a(Class<?> cls) {
        String str;
        String str2;
        Version version = null;
        try {
            InputStream resourceAsStream = cls.getResourceAsStream("VERSION.txt");
            if (resourceAsStream != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, Keyczar.DEFAULT_ENCODING));
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 != null) {
                            str2 = readLine2.trim();
                            str = bufferedReader.readLine();
                            if (str != null) {
                                str = str.trim();
                            }
                        } else {
                            str2 = readLine2;
                            str = null;
                        }
                    } else {
                        str = null;
                        str2 = null;
                    }
                    version = a(readLine, str2, str);
                    try {
                        resourceAsStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } catch (Throwable th) {
                    try {
                        resourceAsStream.close();
                        throw th;
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        } catch (IOException e3) {
        }
        return version == null ? Version.unknownVersion() : version;
    }

    public static Version a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        String[] split = f443a.split(trim);
        return new Version(a(split[0]), split.length > 1 ? a(split[1]) : 0, split.length > 2 ? a(split[2]) : 0, split.length > 3 ? split[3] : null, str2, str3);
    }

    protected static int a(String str) {
        String str2 = str.toString();
        int length = str2.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str2.charAt(i2);
            if (charAt > '9' || charAt < '0') {
                break;
            }
            i = (i * 10) + (charAt - '0');
        }
        return i;
    }
}
