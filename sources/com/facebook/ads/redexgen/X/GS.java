package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class GS implements GP {

    @Nullable
    public static String A02;
    public static byte[] A03;
    public static final JX A04;
    public static final AtomicBoolean A05;
    public static final AtomicInteger A06;
    public static final AtomicReference<Map<String, String>> A07;
    public final C0361Eb A00;
    public final C0399Fn A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.GS.A03
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
            int r0 = r0 - r4
            int r0 = r0 + (-60)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GS.A01(int, int, int):java.lang.String");
    }

    public static void A07() {
        A03 = new byte[]{-89, -91, -105, -92, -79, -109, -103, -105, -96, -90, -15, -31, -16, -29, -29, -20, -3, -11, -25, -30, -14, -26, -32, -30, -30, -28, -14, -14, -24, -31, -24, -21, -24, -13, -8, -2, -28, -19, -32, -31, -21, -28, -29, -79, -74, -64, -18, -33, -26, -6, -34, -36, -21, -36, -35, -28, -25, -28, -17, -12, -97, -102, -100, -105, -84, -66, -76, -81, -74, -86, -76, -82, -119, -127, Byte.MIN_VALUE, -123, 125, -112, -123, -117, -118, -101, -113, -127, -114, -110, -123, Byte.MAX_VALUE, -127, -105, -114, -99, -96, -104, -101, -108, -88, -99, -94, -103, -114, -86, -91, -64, -92, -94, -92, -87, -90, -64, -75, -76, -64, -82, -76, -116, -97, -104, -114, -106, -113, -56, -61, -34, -46, -50, -44, -47, -62, -60, -63, -70, -75, -64, -59, -83, -68, -68, -53, -71, -75, -70, -53, -65, -80, -73, -53, -62, -79, -66, -65, -75, -69, -70, -83, -104, -93, -89, -104, -87, -104, -92, -86, 14, 0, 14, 14, 4, 10, 9, 26, 15, 4, 8, 0, -92, -94, -77, -77, -86, -90, -77, 124, -93, -88, -83, -82, -101, -90, -90, -97, -84, -19, -35, -20, -33, -33, -24, -7, -30, -33, -29, -31, -30, -18, -61, -65, -66, -31, -51, -17, -30, -29, -16, -92, -94, -85, -94, -81, -90, -96, -123, -104, -104, -106, -115, -122, -103, -104, -115, -109, -110, -93, -115, -120, -54, -49, -39, -60, -56, -29, -21, -18, -25, -26, -94, -10, -15, -94, -28, -9, -21, -18, -26, -94, -9, -11, -25, -12, -94, -10, -15, -19, -25, -16, -73, -55, -66, -73, -55, -12, 1, -12, -1, 2, -6, -90, -89, -80, -75, -85, -74, -69, -5, -2, -14, -16, -5, -12, -59, -62, -62, -57, -72, -73};
    }

    static {
        A07();
        A05 = new AtomicBoolean();
        A06 = new AtomicInteger(0);
        A02 = null;
        A04 = JY.A00();
        A07 = new AtomicReference<>();
    }

    public GS(C0361Eb c0361Eb, boolean z) {
        this.A00 = c0361Eb;
        this.A01 = new C0399Fn(c0361Eb);
        A08(c0361Eb, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:            return r5;     */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(com.facebook.ads.redexgen.X.C0361Eb r6, java.lang.String r7) {
        /*
            r0 = 0
            r5 = 0
            r4 = 0
            r3 = 0
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L8;
                case 5: goto L8;
                case 6: goto L8;
                case 7: goto L8;
                case 8: goto L2d;
                case 9: goto L46;
                case 10: goto L4a;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.Eb r6 = (com.facebook.ads.redexgen.X.C0361Eb) r6     // Catch: java.lang.Exception -> L1d
            android.content.pm.PackageManager r1 = r6.getPackageManager()     // Catch: java.lang.Exception -> L1d
            r0 = 0
            android.content.pm.ApplicationInfo r0 = r1.getApplicationInfo(r7, r0)     // Catch: java.lang.Exception -> L1d
            java.lang.String r0 = r0.sourceDir     // Catch: java.lang.Exception -> L1d
            java.lang.String r5 = com.facebook.ads.redexgen.X.C0488Jd.A02(r0)     // Catch: java.lang.Exception -> L1d
            r0 = 10
            goto L5
        L1d:
            r4 = move-exception
            java.util.concurrent.atomic.AtomicBoolean r1 = com.facebook.ads.redexgen.X.GS.A05
            r0 = 1
            boolean r0 = r1.compareAndSet(r3, r0)
            if (r0 == 0) goto L2a
            r0 = 8
            goto L5
        L2a:
            r0 = 9
            goto L5
        L2d:
            com.facebook.ads.redexgen.X.Eb r6 = (com.facebook.ads.redexgen.X.C0361Eb) r6
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r2 = 214(0xd6, float:3.0E-43)
            r1 = 7
            r0 = 1
            java.lang.String r2 = A01(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A11
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r4)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r6, r2, r1, r0)
            r0 = 9
            goto L5
        L46:
            r5 = 0
            r0 = 10
            goto L5
        L4a:
            java.lang.String r5 = (java.lang.String) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GS.A02(com.facebook.ads.redexgen.X.Eb, java.lang.String):java.lang.String");
    }

    @Nullable
    public static Map<String, String> A05() {
        return A07.get();
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A08(C0361Eb c0361Eb, boolean z) {
        if (!A06.compareAndSet(0, 1)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = c0361Eb.getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(205, 9, 65), c0361Eb), 0);
            String str = A01(235, 4, 77) + new C0399Fn(c0361Eb).A05();
            A02 = sharedPreferences.getString(str, null);
            FutureTask<Boolean> initialiser = new FutureTask<>(new GR(c0361Eb, sharedPreferences, str));
            Executors.newSingleThreadExecutor().submit(initialiser);
            if (!z) {
                return;
            }
            initialiser.get();
        } catch (Exception unused) {
            A06.set(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x028b, code lost:            r3 = r3;        com.facebook.ads.redexgen.X.GS.A07.set(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0294, code lost:            return r3;     */
    @Override // com.facebook.ads.redexgen.X.GP
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, java.lang.String> A4c() {
        /*
            Method dump skipped, instructions count: 688
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GS.A4c():java.util.Map");
    }

    @Override // com.facebook.ads.redexgen.X.GP
    public final String A4y() {
        return A4z(GO.A00());
    }

    @Override // com.facebook.ads.redexgen.X.GP
    public final String A4z(GL gl) {
        Base64OutputStream base64OutputStream;
        DeflaterOutputStream deflaterOutputStream;
        A08(this.A00, true);
        ByteArrayOutputStream byteArrayOutputStream = null;
        Base64OutputStream base64OutputStream2 = null;
        DeflaterOutputStream deflaterOutputStream2 = null;
        try {
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                try {
                    base64OutputStream = new Base64OutputStream(out, 0);
                    try {
                        deflaterOutputStream = new DeflaterOutputStream(base64OutputStream);
                    } catch (IOException e) {
                        e = e;
                        base64OutputStream2 = base64OutputStream;
                        byteArrayOutputStream = out;
                    } catch (Throwable th) {
                        th = th;
                        base64OutputStream2 = base64OutputStream;
                        byteArrayOutputStream = out;
                    }
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream = out;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = out;
                }
                try {
                    Map<String, String> A4c = A4c();
                    if (TextUtils.isEmpty(C02379g.A00().A03())) {
                        C02379g.A07(this.A00);
                    }
                    A4c.put(A01(60, 4, 26), C02379g.A00().A03());
                    A4c.put(A01(0, 10, 22), GV.A06(this.A01, this.A00, false));
                    Iterator<Map.Entry<String, String>> it = A4c.entrySet().iterator();
                    while (it.hasNext()) {
                        if (!gl.A2N(it.next().getKey())) {
                            it.remove();
                        }
                    }
                    JSONObject envParameters = new JSONObject(A4c);
                    deflaterOutputStream.write(envParameters.toString().getBytes());
                    deflaterOutputStream.close();
                    String replaceAll = out.toString().replaceAll(A01(182, 1, 54), A01(68, 0, 83));
                    if (deflaterOutputStream != null) {
                        try {
                            deflaterOutputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (base64OutputStream != null) {
                        base64OutputStream.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                    return replaceAll;
                } catch (IOException e3) {
                    e = e3;
                    deflaterOutputStream2 = deflaterOutputStream;
                    base64OutputStream2 = base64OutputStream;
                    byteArrayOutputStream = out;
                    throw new RuntimeException(A01(239, 26, 70), e);
                } catch (Throwable th3) {
                    th = th3;
                    deflaterOutputStream2 = deflaterOutputStream;
                    base64OutputStream2 = base64OutputStream;
                    byteArrayOutputStream = out;
                    if (deflaterOutputStream2 != null) {
                        try {
                            deflaterOutputStream2.close();
                        } catch (IOException unused2) {
                            throw th;
                        }
                    }
                    if (base64OutputStream2 != null) {
                        base64OutputStream2.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e4) {
            e = e4;
        }
    }
}
