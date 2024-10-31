package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class FE {
    public static AtomicInteger A00;
    public static byte[] A01;
    public static final Object A02;
    public static final String A03;
    public static final Map<String, Integer> A04;
    public static final Set<String> A05;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.FE.A01
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            r0 = r0 ^ r4
            r0 = r0 ^ 20
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FE.A02(int, int, int):java.lang.String");
    }

    public static void A06() {
        A01 = new byte[]{99, 98, 101, 114, 96, 120, 119, 117, 98, 97, 45, 6, 23, 31, 2, 52, 48, 51, 7, 22, 27, 23, 28, 17, 23, 60, 23, 6, 5, 29, 0, 25, 65, 99, 108, 37, 118, 34, 102, 103, 110, 103, 118, 103, 34, 100, 107, 110, 103, 35, 77, 91, 77, 77, 87, 81, 80, 97, 87, 90, 61, 60, 6, 53, 54, 62, 62, 48, 55, 62, 55, 15, 13, 20, 20, 13, 10, 3, 68, 7, 11, 22, 22, 17, 20, 16, 1, 0, 68, 0, 1, 6, 17, 3, 68, 1, 18, 1, 10, 16, 68, 8, 13, 10, 1, 74, 72, 109, 106, Byte.MAX_VALUE, 125, 56, 124, 125, 122, 109, Byte.MAX_VALUE, 56, 125, 110, 125, 118, 108, 107, 56, 126, 113, 116, 125, 54, 18, 94, 113, 116, 125, 56, 107, 113, 98, 125, 34, 56, 40, 37, 44, 57, 96, 102, 113, 103, 106, 99, 118, 55, 34, 34, 51, 59, 38, 34, 22, 14, 12, 21, 21, 0, 1, 32, 19, 0, 11, 17, 22, 69, 88, 69, 64, 13, 47, 32, 105, 58, 110, 42, 43, 34, 43, 58, 43, 110, 42, 43, 44, 59, 41, 110, 43, 56, 43, 32, 58, 61, 110, 40, 39, 34, 43, 96, 38, 32, 55, 33, 44, 37, 48, 10, 54, 58, 49, 48, 50, 62, 90, 108, 113, 110, 93, 113, 107, 112, 106, 123, 108, 36, 62, 26, 31, 10, 31, 7, 17, 7, 7, 29, 27, 26, 43, 0, 29, 25, 17, 74, 75, 76, 91, 73, 66, 65, 73, 93, 57, 31, 20, 4, 3, 10, 77, 25, 2, 77, 24, 29, 9, 12, 25, 8, 77, 24, 3, 31, 8, 14, 2, 31, 9, 8, 9, 77, 9, 8, 15, 24, 10, 33, 2, 10, 40, 27, 8, 3, 25, 67, 77, 12, 9, 9, 4, 3, 10, 77, 25, 2, 77, 34, 3, 10, 2, 4, 3, 10, 40, 27, 8, 3, 25, 67, 16, 35, 48, 59, 33, 22, 58, 32, 59, 33, 119, 79, 77, 84, 84, 65, 64, 4, 65, 82, 65, 74, 80, 87, 10, 109, 96, 85, 72, 76, 68, 1, 14, 9, 14, 20, 15, 2, 3, 71, 2, 17, 2, 9, 19, 71, 20, 15, 8, 18, 11, 3, 71, 9, 8, 19, 71, 5, 2, 71, 18, 23, 3, 6, 19, 2, 3, 71, 19, 8, 71, 40, 9, 0, 8, 14, 9, 0, 34, 17, 2, 9, 19, 73};
    }

    static {
        A06();
        A03 = FE.class.getName();
        A02 = new Object();
        A05 = Collections.synchronizedSet(new HashSet());
        A04 = Collections.synchronizedMap(new HashMap());
        A00 = new AtomicInteger();
    }

    public static int A00(Context context) {
        return context.getSharedPreferences(ProcessUtils.getProcessSpecificName(A02(0, 10, 51), context), 0).getInt(A02(326, 10, 65), 0) - A05.size();
    }

    public static FD A01(String str, C0361Eb c0361Eb, Map<String, String> staticEnvironmentData) {
        try {
            FD fd = new FD(c0361Eb.A04().A01(), c0361Eb.A04().A02(), new F2(str, staticEnvironmentData, true).A02());
            try {
                A0B(fd, c0361Eb);
                return fd;
            } catch (Exception unused) {
                return fd;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static JSONArray A03(C0361Eb c0361Eb) {
        return A04(c0361Eb, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f4 A[Catch: IOException -> 0x00fd, all -> 0x012d, TryCatch #12 {IOException -> 0x00fd, blocks: (B:54:0x00ef, B:44:0x00f4, B:46:0x00f9), top: B:53:0x00ef, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f9 A[Catch: IOException -> 0x00fd, all -> 0x012d, TRY_LEAVE, TryCatch #12 {IOException -> 0x00fd, blocks: (B:54:0x00ef, B:44:0x00f4, B:46:0x00f9), top: B:53:0x00ef, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray A04(com.facebook.ads.redexgen.X.C0361Eb r10, int r11) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FE.A04(com.facebook.ads.redexgen.X.Eb, int):org.json.JSONArray");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0090, code lost:            r3 = r3;        r3.put(r1, r4);        r3.put(A02(153, 7, 66), java.lang.String.valueOf(0));     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ac, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject A05(com.facebook.ads.redexgen.X.FD r5) throws org.json.JSONException {
        /*
            r4 = 0
            r0 = 0
            r0 = 0
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r2 = 351(0x15f, float:4.92E-43)
            r1 = 2
            r0 = 16
            java.lang.String r1 = A02(r2, r1, r0)
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            r3.put(r1, r0)
            r2 = 142(0x8e, float:1.99E-43)
            r1 = 4
            r0 = 72
            java.lang.String r1 = A02(r2, r1, r0)
            java.lang.String r0 = r5.A03()
            r3.put(r1, r0)
            r2 = 353(0x161, float:4.95E-43)
            r1 = 4
            r0 = 53
            java.lang.String r2 = A02(r2, r1, r0)
            double r0 = r5.A01()
            java.lang.String r0 = com.facebook.ads.redexgen.X.K4.A02(r0)
            r3.put(r2, r0)
            r2 = 239(0xef, float:3.35E-43)
            r1 = 12
            r0 = 96
            java.lang.String r2 = A02(r2, r1, r0)
            double r0 = r5.A00()
            java.lang.String r0 = com.facebook.ads.redexgen.X.K4.A02(r0)
            r3.put(r2, r0)
            r2 = 50
            r1 = 10
            r0 = 42
            java.lang.String r1 = A02(r2, r1, r0)
            java.lang.String r0 = r5.A02()
            r3.put(r1, r0)
            r2 = 235(0xeb, float:3.3E-43)
            r1 = 4
            r0 = 106(0x6a, float:1.49E-43)
            java.lang.String r1 = A02(r2, r1, r0)
            java.util.Map r0 = r5.A04()
            if (r0 == 0) goto L8e
            r0 = 2
        L76:
            switch(r0) {
                case 2: goto L7a;
                case 3: goto L90;
                case 4: goto L87;
                default: goto L79;
            }
        L79:
            goto L76
        L7a:
            com.facebook.ads.redexgen.X.FD r5 = (com.facebook.ads.redexgen.X.FD) r5
            org.json.JSONObject r4 = new org.json.JSONObject
            java.util.Map r0 = r5.A04()
            r4.<init>(r0)
            r0 = 3
            goto L76
        L87:
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            r0 = 3
            goto L76
        L8e:
            r0 = 4
            goto L76
        L90:
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            java.lang.String r1 = (java.lang.String) r1
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r3.put(r1, r4)
            r2 = 153(0x99, float:2.14E-43)
            r1 = 7
            r0 = 66
            java.lang.String r1 = A02(r2, r1, r0)
            r0 = 0
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r3.put(r1, r0)
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FE.A05(com.facebook.ads.redexgen.X.FD):org.json.JSONObject");
    }

    public static void A07(Context context) {
        synchronized (A02) {
            File file = new File(context.getFilesDir(), ProcessUtils.getProcessSpecificName(A02(251, 9, 58), context));
            if (file.exists()) {
                file.delete();
            }
            A09(context, 0);
            A05.clear();
            A04.clear();
        }
    }

    public static void A08(Context context) {
        A09(context, context.getSharedPreferences(ProcessUtils.getProcessSpecificName(A02(0, 10, 51), context), 0).getInt(A02(326, 10, 65), 0) + 1);
    }

    public static void A09(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(ProcessUtils.getProcessSpecificName(A02(0, 10, 51), context), 0).edit();
        String A022 = A02(326, 10, 65);
        if (i < 0) {
            i = 0;
        }
        edit.putInt(A022, i).apply();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0A(com.facebook.ads.redexgen.X.C0361Eb r6, java.lang.String r7) {
        /*
            r0 = 0
            java.io.File r5 = new java.io.File
            java.io.File r0 = r6.getFilesDir()
            r5.<init>(r0, r7)
            boolean r0 = r5.exists()
            if (r0 == 0) goto L3b
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L15;
                case 3: goto L21;
                case 4: goto L3d;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            java.io.File r5 = (java.io.File) r5
            boolean r0 = r5.delete()
            if (r0 != 0) goto L1f
            r0 = 3
            goto L11
        L1f:
            r0 = 4
            goto L11
        L21:
            com.facebook.ads.redexgen.X.Eb r6 = (com.facebook.ads.redexgen.X.C0361Eb) r6
            com.facebook.ads.redexgen.X.Kf r4 = r6.A06()
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            r2 = 32
            r1 = 18
            r0 = 22
            java.lang.String r0 = A02(r2, r1, r0)
            r3.<init>(r0)
            r4.A3C(r3)
            r0 = 4
            goto L11
        L3b:
            r0 = 4
            goto L11
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FE.A0A(com.facebook.ads.redexgen.X.Eb, java.lang.String):void");
    }

    public static void A0B(FD fd, C0361Eb c0361Eb) {
        if (fd != null && c0361Eb != null) {
            synchronized (A02) {
                try {
                    String processSpecificName = ProcessUtils.getProcessSpecificName(A02(251, 9, 58), c0361Eb);
                    File file = new File(c0361Eb.getFilesDir(), processSpecificName);
                    if (file.exists()) {
                        int A07 = C0414Gd.A07(c0361Eb);
                        long length = file.length();
                        if (A07 > 0 && length > A07) {
                            boolean delete = file.delete();
                            A09(c0361Eb, 0);
                            A05.clear();
                            A04.clear();
                            if (delete) {
                                Map<String, String> A3p = c0361Eb.A02().A3p();
                                A3p.put(A02(146, 7, 7), A02(60, 10, 77));
                                A3p.put(A02(208, 12, 65), String.valueOf(2401));
                                A01(A02(106, 36, 12) + length + A02(220, 15, 10) + A00.getAndIncrement(), c0361Eb, A3p);
                                return;
                            }
                            Log.e(A02(15, 17, 102), A02(177, 31, 90));
                        }
                    }
                    JSONObject A052 = A05(fd);
                    FileOutputStream openFileOutput = c0361Eb.openFileOutput(processSpecificName, 32768);
                    openFileOutput.write((A052.toString() + A02(176, 1, 94)).getBytes());
                    openFileOutput.close();
                    A08(c0361Eb);
                } catch (Exception e) {
                    c0361Eb.A06().A3C(e);
                }
            }
        }
    }

    public static void A0C(String str) {
        A04.remove(str);
        A05.add(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:            com.facebook.ads.redexgen.X.FE.A04.put(r5, java.lang.Integer.valueOf(r4.intValue() + 1));     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0D(java.lang.String r5) {
        /*
            r0 = 0
            java.util.Map<java.lang.String, java.lang.Integer> r0 = com.facebook.ads.redexgen.X.FE.A04
            java.lang.Object r4 = r0.get(r5)
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 != 0) goto L3b
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L1a;
                case 4: goto L2b;
                case 5: goto L3d;
                case 6: goto L32;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L18
            r0 = 3
            goto Lc
        L18:
            r0 = 4
            goto Lc
        L1a:
            java.lang.String r3 = com.facebook.ads.redexgen.X.FE.A03
            r2 = 260(0x104, float:3.64E-43)
            r1 = 66
            r0 = 121(0x79, float:1.7E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            android.util.Log.e(r3, r0)
            r0 = 4
            goto Lc
        L2b:
            r0 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r0 = 5
            goto Lc
        L32:
            java.lang.String r5 = (java.lang.String) r5
            java.util.Map<java.lang.String, java.lang.Integer> r0 = com.facebook.ads.redexgen.X.FE.A04
            r0.remove(r5)
            r0 = 5
            goto Lc
        L3b:
            r0 = 6
            goto Lc
        L3d:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.util.Map<java.lang.String, java.lang.Integer> r1 = com.facebook.ads.redexgen.X.FE.A04
            int r0 = r4.intValue()
            int r0 = r0 + 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.put(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FE.A0D(java.lang.String):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    public static void A0E(String str, int i) {
        char c = A05.contains(str) ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new RuntimeException(A02(357, 53, 115));
                case 3:
                    str = str;
                    c = A04.containsKey(str) ? (char) 4 : (char) 5;
                case 4:
                    str = str;
                    A04.remove(str);
                    c = 5;
                case 5:
                    A04.put(str, Integer.valueOf(i));
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0F(com.facebook.ads.redexgen.X.C0361Eb r2) {
        /*
            r1 = 0
            boolean r0 = com.facebook.ads.redexgen.X.C0414Gd.A0N(r2)
            if (r0 == 0) goto L1c
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1e;
                case 4: goto L14;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Eb r2 = (com.facebook.ads.redexgen.X.C0361Eb) r2
            boolean r1 = A0H(r2)
            r0 = 3
            goto L8
        L14:
            com.facebook.ads.redexgen.X.Eb r2 = (com.facebook.ads.redexgen.X.C0361Eb) r2
            boolean r1 = A0G(r2)
            r0 = 3
            goto L8
        L1c:
            r0 = 4
            goto L8
        L1e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FE.A0F(com.facebook.ads.redexgen.X.Eb):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0185 A[Catch: IOException -> 0x0193, all -> 0x01d4, TryCatch #2 {IOException -> 0x0193, blocks: (B:66:0x0180, B:53:0x0185, B:55:0x018a, B:57:0x018f), top: B:65:0x0180, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x018a A[Catch: IOException -> 0x0193, all -> 0x01d4, TryCatch #2 {IOException -> 0x0193, blocks: (B:66:0x0180, B:53:0x0185, B:55:0x018a, B:57:0x018f), top: B:65:0x0180, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018f A[Catch: IOException -> 0x0193, all -> 0x01d4, TRY_LEAVE, TryCatch #2 {IOException -> 0x0193, blocks: (B:66:0x0180, B:53:0x0185, B:55:0x018a, B:57:0x018f), top: B:65:0x0180, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0G(com.facebook.ads.redexgen.X.C0361Eb r15) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FE.A0G(com.facebook.ads.redexgen.X.Eb):boolean");
    }

    public static boolean A0H(C0361Eb c0361Eb) {
        boolean z;
        synchronized (A02) {
            int i = 0;
            FileInputStream fileInputStream = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;
            FileOutputStream fileOutputStream = null;
            FileInputStream fileInputStream2 = null;
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    String processSpecificDebugFileName = ProcessUtils.getProcessSpecificName(A02(251, 9, 58), c0361Eb);
                    File file = new File(c0361Eb.getFilesDir(), processSpecificDebugFileName);
                    String str = processSpecificDebugFileName + A02(10, 5, 102);
                    A0A(c0361Eb, str);
                    if (file.exists()) {
                        fileOutputStream2 = c0361Eb.openFileOutput(str, 32768);
                        fileInputStream = c0361Eb.openFileInput(processSpecificDebugFileName);
                        InputStreamReader inputStreamReader2 = new InputStreamReader(fileInputStream);
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
                            while (true) {
                                try {
                                    String line = bufferedReader2.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    try {
                                        JSONObject jSONObject = new JSONObject(line);
                                        String string = jSONObject.getString(A02(351, 2, 16));
                                        if (!A05.contains(string)) {
                                            if (A04.containsKey(string)) {
                                                Integer num = A04.get(string);
                                                int retryLimit = num != null ? num.intValue() : 0;
                                                Integer valueOf = Integer.valueOf(retryLimit);
                                                int A022 = C0414Gd.A02(c0361Eb);
                                                if (A022 > -1) {
                                                    int retryLimit2 = A022 - 1;
                                                    if (valueOf.intValue() > retryLimit2) {
                                                        A0C(string);
                                                        i++;
                                                    }
                                                }
                                                jSONObject.put(A02(153, 7, 66), String.valueOf(valueOf));
                                                fileOutputStream2.write((jSONObject.toString() + '\n').getBytes());
                                            } else {
                                                fileOutputStream2.write((jSONObject.toString() + '\n').getBytes());
                                            }
                                        }
                                    } catch (JSONException e) {
                                        if (BuildConfigApi.isDebug()) {
                                            Log.e(A03, A02(70, 36, 112), e);
                                        }
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    bufferedReader = bufferedReader2;
                                    inputStreamReader = inputStreamReader2;
                                    c0361Eb.A06().A3C(e);
                                    z = false;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e3) {
                                            c0361Eb.A06().A3C(e3);
                                            A05.clear();
                                            A04.clear();
                                            return z;
                                        }
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (fileInputStream2 != null) {
                                        fileInputStream2.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    A05.clear();
                                    A04.clear();
                                    return z;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader = bufferedReader2;
                                    inputStreamReader = inputStreamReader2;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e4) {
                                            c0361Eb.A06().A3C(e4);
                                            A05.clear();
                                            A04.clear();
                                            throw th;
                                        }
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (fileInputStream2 != null) {
                                        fileInputStream2.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    A05.clear();
                                    A04.clear();
                                    throw th;
                                }
                            }
                            fileInputStream2 = c0361Eb.openFileInput(str);
                            fileOutputStream = c0361Eb.openFileOutput(processSpecificDebugFileName, 0);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileInputStream2.close();
                            fileOutputStream2.close();
                            A0A(c0361Eb, str);
                            bufferedReader = bufferedReader2;
                            inputStreamReader = inputStreamReader2;
                        } catch (IOException e5) {
                            e = e5;
                            inputStreamReader = inputStreamReader2;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStreamReader = inputStreamReader2;
                        }
                    }
                    A09(c0361Eb, A00(c0361Eb));
                    if (i > 0) {
                        c0361Eb.A06().A5W(A02(60, 10, 77), C0512Kc.A1i, new C0514Ke(A02(336, 15, 48), A02(160, 16, 113) + i));
                    }
                    z = true;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            c0361Eb.A06().A3C(e6);
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    A05.clear();
                    A04.clear();
                } catch (IOException e7) {
                    e = e7;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0024, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0I(java.lang.String r2) {
        /*
            r1 = 0
            java.util.Set<java.lang.String> r0 = com.facebook.ads.redexgen.X.FE.A05
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto L22
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1c;
                case 4: goto L24;
                case 5: goto L1f;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            java.lang.String r2 = (java.lang.String) r2
            java.util.Map<java.lang.String, java.lang.Integer> r0 = com.facebook.ads.redexgen.X.FE.A04
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L1a
            r0 = 3
            goto La
        L1a:
            r0 = 5
            goto La
        L1c:
            r1 = 1
            r0 = 4
            goto La
        L1f:
            r1 = 0
            r0 = 4
            goto La
        L22:
            r0 = 3
            goto La
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FE.A0I(java.lang.String):boolean");
    }
}
