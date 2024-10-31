package com.qq.e.comm.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
public class StringUtil {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String join(String str, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (str != null && i != 0) {
                    stringBuffer.append(str);
                }
                stringBuffer.append(strArr[i]);
            }
        }
        return stringBuffer.toString();
    }

    public static int parseInteger(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readAll(java.io.File r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "Exception while close bufferreader"
            r1 = 0
            if (r4 == 0) goto L4a
            boolean r2 = r4.exists()
            if (r2 != 0) goto Lc
            goto L4a
        Lc:
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L39
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L39
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L39
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L39
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L32 java.lang.Throwable -> L3e
            r1.<init>()     // Catch: java.io.IOException -> L32 java.lang.Throwable -> L3e
        L1b:
            java.lang.String r2 = r4.readLine()     // Catch: java.io.IOException -> L32 java.lang.Throwable -> L3e
            if (r2 == 0) goto L25
            r1.append(r2)     // Catch: java.io.IOException -> L32 java.lang.Throwable -> L3e
            goto L1b
        L25:
            java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> L32 java.lang.Throwable -> L3e
            r4.close()     // Catch: java.lang.Exception -> L2d
            goto L31
        L2d:
            r4 = move-exception
            com.qq.e.comm.util.GDTLogger.e(r0, r4)
        L31:
            return r1
        L32:
            r1 = move-exception
            goto L3d
        L34:
            r4 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
            goto L3f
        L39:
            r4 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
        L3d:
            throw r1     // Catch: java.lang.Throwable -> L3e
        L3e:
            r1 = move-exception
        L3f:
            if (r4 == 0) goto L49
            r4.close()     // Catch: java.lang.Exception -> L45
            goto L49
        L45:
            r4 = move-exception
            com.qq.e.comm.util.GDTLogger.e(r0, r4)
        L49:
            throw r1
        L4a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.StringUtil.readAll(java.io.File):java.lang.String");
    }

    public static void writeTo(String str, File file) throws IOException {
        if (file == null) {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(str);
        fileWriter.close();
    }
}
