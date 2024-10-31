package com.flurry.sdk;

import java.io.File;

/* loaded from: classes.dex */
public final class ao {

    /* renamed from: a, reason: collision with root package name */
    private static String f463a = ao.class.getSimpleName();

    public static boolean a(File file) {
        if (file == null || file.getAbsoluteFile() == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return true;
        }
        if (parentFile.mkdirs() || parentFile.isDirectory()) {
            return true;
        }
        as.a(6, f463a, "Unable to create persistent dir: " + parentFile);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(java.io.File r7) {
        /*
            r4 = 4
            r0 = 0
            if (r7 == 0) goto La
            boolean r1 = r7.exists()
            if (r1 != 0) goto L12
        La:
            java.lang.String r1 = com.flurry.sdk.ao.f463a
            java.lang.String r2 = "Persistent file doesn't exist."
            com.flurry.sdk.as.a(r4, r1, r2)
        L11:
            return r0
        L12:
            java.lang.String r1 = com.flurry.sdk.ao.f463a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Loading persistent data: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r7.getAbsolutePath()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.flurry.sdk.as.a(r4, r1, r2)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L64 java.lang.Throwable -> L6d
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L64 java.lang.Throwable -> L6d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6b
            r1.<init>()     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6b
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6b
        L3c:
            int r4 = r2.read(r3)     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6b
            if (r4 <= 0) goto L60
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6b
            r6 = 0
            r5.<init>(r3, r6, r4)     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6b
            r1.append(r5)     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6b
            goto L3c
        L4c:
            r1 = move-exception
        L4d:
            r3 = 6
            java.lang.String r4 = com.flurry.sdk.ao.f463a     // Catch: java.lang.Throwable -> L6b
            java.lang.String r5 = "Error when loading persistent file"
            com.flurry.sdk.as.a(r3, r4, r5, r1)     // Catch: java.lang.Throwable -> L6b
            com.flurry.sdk.bb.a(r2)
            r1 = r0
        L59:
            if (r1 == 0) goto L11
            java.lang.String r0 = r1.toString()
            goto L11
        L60:
            com.flurry.sdk.bb.a(r2)
            goto L59
        L64:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L67:
            com.flurry.sdk.bb.a(r2)
            throw r0
        L6b:
            r0 = move-exception
            goto L67
        L6d:
            r1 = move-exception
            r2 = r0
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.ao.b(java.io.File):java.lang.String");
    }
}
