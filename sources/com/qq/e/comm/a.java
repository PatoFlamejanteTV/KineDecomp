package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public class a {
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0018. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0021. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0024. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0027. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x002a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x002d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.qq.e.comm.util.AdError a(int r5) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.a.a(int):com.qq.e.comm.util.AdError");
    }

    public static boolean a(Context context) {
        try {
            if (b(context) && a(context, Class.forName(CustomPkgConstants.getADActivityName())) && a(context, Class.forName(CustomPkgConstants.getPortraitADActivityName())) && a(context, Class.forName(CustomPkgConstants.getLandscapeADActivityName()))) {
                if (b(context, Class.forName(CustomPkgConstants.getDownLoadServiceName()))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.e("Exception While check SDK Env", th);
            return false;
        }
    }

    private static boolean a(Context context, Class<?>... clsArr) {
        for (int i = 0; i <= 0; i++) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[0]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.e(String.format("Activity[%s] is required in AndroidManifest.xml", clsArr[0].getName()));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("Exception while checking required activities", th);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(byte[] r3) {
        /*
            if (r3 == 0) goto L49
            int r0 = r3.length
            if (r0 != 0) goto L6
            goto L49
        L6:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c
            r2.write(r3)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3a
            r2.finish()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3a
            byte[] r1 = r0.toByteArray()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3a
            r2.close()     // Catch: java.lang.Exception -> L22
            r0.close()     // Catch: java.lang.Exception -> L22
            goto L39
        L22:
            r3 = move-exception
            r3.printStackTrace()
            goto L39
        L27:
            r3 = move-exception
            goto L2e
        L29:
            r3 = move-exception
            r2 = r1
            goto L3b
        L2c:
            r3 = move-exception
            r2 = r1
        L2e:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L36
            r2.close()     // Catch: java.lang.Exception -> L22
        L36:
            r0.close()     // Catch: java.lang.Exception -> L22
        L39:
            return r1
        L3a:
            r3 = move-exception
        L3b:
            if (r2 == 0) goto L40
            r2.close()     // Catch: java.lang.Exception -> L44
        L40:
            r0.close()     // Catch: java.lang.Exception -> L44
            goto L48
        L44:
            r0 = move-exception
            r0.printStackTrace()
        L48:
            throw r3
        L49:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.a.a(byte[]):byte[]");
    }

    private static boolean b(Context context) {
        String[] strArr = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        for (int i = 0; i < 5; i++) {
            try {
                String str = strArr[i];
                if (context.checkCallingOrSelfPermission(str) == -1) {
                    GDTLogger.e(String.format("Permission %s is required in AndroidManifest.xml", str));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("Check required Permissions error", th);
                return false;
            }
        }
        return true;
    }

    private static boolean b(Context context, Class<?>... clsArr) {
        for (int i = 0; i <= 0; i++) {
            try {
                Class<?> cls = clsArr[0];
                Intent intent = new Intent();
                intent.setClass(context, cls);
                if (context.getPackageManager().resolveService(intent, 65536) == null) {
                    GDTLogger.e(String.format("Service[%s] is required in AndroidManifest.xml", cls.getName()));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("Exception while checking required services", th);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.zip.GZIPInputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(byte[] r6) {
        /*
            if (r6 == 0) goto L64
            int r0 = r6.length
            if (r0 != 0) goto L6
            goto L64
        L6:
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r6)
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream
            r6.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]
            r2 = 0
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
        L1a:
            int r4 = r3.read(r1)     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L52
            r5 = -1
            if (r4 == r5) goto L26
            r5 = 0
            r6.write(r1, r5, r4)     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L52
            goto L1a
        L26:
            r6.flush()     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L52
            byte[] r2 = r6.toByteArray()     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L52
            r3.close()     // Catch: java.lang.Exception -> L37
            r0.close()     // Catch: java.lang.Exception -> L37
            r6.close()     // Catch: java.lang.Exception -> L37
            goto L51
        L37:
            r6 = move-exception
            r6.printStackTrace()
            goto L51
        L3c:
            r1 = move-exception
            goto L43
        L3e:
            r1 = move-exception
            r3 = r2
            goto L53
        L41:
            r1 = move-exception
            r3 = r2
        L43:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L52
            if (r3 == 0) goto L4b
            r3.close()     // Catch: java.lang.Exception -> L37
        L4b:
            r0.close()     // Catch: java.lang.Exception -> L37
            r6.close()     // Catch: java.lang.Exception -> L37
        L51:
            return r2
        L52:
            r1 = move-exception
        L53:
            if (r3 == 0) goto L58
            r3.close()     // Catch: java.lang.Exception -> L5f
        L58:
            r0.close()     // Catch: java.lang.Exception -> L5f
            r6.close()     // Catch: java.lang.Exception -> L5f
            goto L63
        L5f:
            r6 = move-exception
            r6.printStackTrace()
        L63:
            throw r1
        L64:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.a.b(byte[]):byte[]");
    }
}
