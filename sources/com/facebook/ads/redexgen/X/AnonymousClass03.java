package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/* renamed from: com.facebook.ads.redexgen.X.03, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass03 {
    public static AnonymousClass02 A00(final C0361Eb c0361Eb, final C0A c0a, final C0X c0x) {
        return new AnonymousClass02(c0361Eb, c0a, c0x) { // from class: com.facebook.ads.redexgen.X.0C
            public static byte[] A09;
            public static final String A0A;
            public final int A00;
            public final int A01;
            public final C0A A02;
            public final C0X A04;
            public final C0361Eb A05;
            public final boolean A08;
            public final Map<String, File> A06 = Collections.synchronizedMap(new HashMap());
            public final Map<String, Semaphore> A07 = new HashMap();
            public final C0D A03 = new C0D();

            /* JADX WARN: Failed to parse debug info
            java.lang.ArrayIndexOutOfBoundsException: Index 20 out of bounds for length 19
            	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:147)
            	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
            	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:626)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
             */
            /* JADX WARN: Not initialized variable reg: 12, insn: 0x00fd: INVOKE 
  (r6v0 ?? I:com.facebook.ads.redexgen.X.0X)
  (r7v0 ?? I:java.lang.String)
  (r8v0 ?? I:int)
  (r9v0 ?? I:java.lang.String)
  (r10v0 ?? I:java.lang.Integer)
  (r11v0 ?? I:java.lang.Long)
  (r12 I:com.facebook.ads.redexgen.X.08)
 INTERFACE call: com.facebook.ads.redexgen.X.0X.A7z(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.08):void A[MD:(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.08):void (m)], block:B:49:0x00f2 */
            /* JADX WARN: Not initialized variable reg: 12, insn: 0x0122: INVOKE 
  (r6v1 ?? I:com.facebook.ads.redexgen.X.0X)
  (r7v1 ?? I:java.lang.String)
  (r8v1 ?? I:int)
  (r9v1 ?? I:java.lang.String)
  (r10v1 ?? I:java.lang.Integer)
  (r11v1 ?? I:java.lang.Long)
  (r12 I:com.facebook.ads.redexgen.X.08)
 INTERFACE call: com.facebook.ads.redexgen.X.0X.A7z(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.08):void A[MD:(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.08):void (m)], block:B:44:0x0117 */
            /* JADX WARN: Not initialized variable reg: 7, insn: 0x00fd: INVOKE 
  (r6v0 ?? I:com.facebook.ads.redexgen.X.0X)
  (r7 I:java.lang.String)
  (r8 I:int)
  (r9 I:java.lang.String)
  (r10 I:java.lang.Integer)
  (r11 I:java.lang.Long)
  (r12 I:com.facebook.ads.redexgen.X.08)
 INTERFACE call: com.facebook.ads.redexgen.X.0X.A7z(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.08):void A[MD:(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.08):void (m)], block:B:49:0x00f2 */
            /* JADX WARN: Not initialized variable reg: 7, insn: 0x0122: INVOKE 
  (r6v1 ?? I:com.facebook.ads.redexgen.X.0X)
  (r7 I:java.lang.String)
  (r8 I:int)
  (r9 I:java.lang.String)
  (r10 I:java.lang.Integer)
  (r11 I:java.lang.Long)
  (r12 I:com.facebook.ads.redexgen.X.08)
 INTERFACE call: com.facebook.ads.redexgen.X.0X.A7z(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.08):void A[MD:(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.08):void (m)], block:B:44:0x0117 */
            @Nullable
            private File A01(AnonymousClass08 anonymousClass08, String str, String str2, int i, C0B c0b) {
                String A7z;
                AnonymousClass08 A7z2;
                String A7z3;
                AnonymousClass08 A7z4;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(C0E.A00(this.A05), str2);
                    final long A0H = C0413Gc.A0H(this.A05);
                    C0S c0s = new C0S(file, new C0K(A0H) { // from class: com.facebook.ads.redexgen.X.0L
                        public static byte[] A01;
                        public final long A00;

                        static {
                            A02();
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public static java.lang.String A00(int r2, int r3, int r4) {
                            /*
                                r0 = 0
                                r0 = 0
                                byte[] r1 = com.facebook.ads.redexgen.X.C0L.A01
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
                                r0 = r0 ^ 10
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0L.A00(int, int, int):java.lang.String");
                        }

                        public static void A02() {
                            A01 = new byte[]{68, 104, 113, 41, 122, 96, 115, 108, 41, 100, 124, 122, 125, 41, 107, 108, 41, 121, 102, 122, 96, 125, 96, Byte.MAX_VALUE, 108, 41, 103, 124, 100, 107, 108, 123, 40};
                        }

                        {
                            if (A0H <= 0) {
                                throw new IllegalArgumentException(A00(0, 33, 3));
                            }
                            this.A00 = A0H;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r3;     */
                        @Override // com.facebook.ads.redexgen.X.C0K
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final boolean A06(java.io.File r5, long r6, int r8) {
                            /*
                                r4 = this;
                                r3 = 0
                                long r1 = r4.A00
                                int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
                                if (r0 > 0) goto L12
                                r0 = 2
                            L8:
                                switch(r0) {
                                    case 2: goto Lc;
                                    case 3: goto L14;
                                    case 4: goto Lf;
                                    default: goto Lb;
                                }
                            Lb:
                                goto L8
                            Lc:
                                r3 = 1
                                r0 = 3
                                goto L8
                            Lf:
                                r3 = 0
                                r0 = 3
                                goto L8
                            L12:
                                r0 = 4
                                goto L8
                            L14:
                                return r3
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0L.A06(java.io.File, long, int):boolean");
                        }

                        @Override // com.facebook.ads.redexgen.X.C0K, com.facebook.ads.redexgen.X.C0F
                        public final /* bridge */ /* synthetic */ void A8T(File file2) throws IOException {
                            super.A8T(file2);
                        }
                    });
                    if (c0s.A09()) {
                        if (this.A08) {
                            String str3 = A02(298, 21, 59) + c0s.A00.getName();
                        }
                        this.A06.put(str, file);
                        c0s.A06();
                        this.A04.A80(str, true, anonymousClass08);
                        return file;
                    }
                    if (this.A08) {
                        String str4 = A02(40, 26, 75) + c0s.A00.getName();
                    }
                    if (!c0b.A04()) {
                        return null;
                    }
                    this.A04.A80(str, false, anonymousClass08);
                    for (int i2 = 0; i2 < this.A00; i2++) {
                        try {
                            A04(this.A05, c0s, str, i, i2, currentTimeMillis);
                            break;
                        } catch (C0P e) {
                            if (i2 == this.A00 - 1) {
                                A05(c0s);
                                if (e instanceof C0R) {
                                    throw ((C0R) e);
                                }
                                if (e instanceof C0W) {
                                    throw ((C0W) e);
                                }
                            }
                        }
                    }
                    int A03 = c0s.A03();
                    c0s.A06();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    c0b.A00().A3j(file, this.A04);
                    this.A06.put(str, file);
                    this.A04.A7z(str, 2112, null, Integer.valueOf(A03), Long.valueOf(currentTimeMillis2), anonymousClass08);
                    return file;
                } catch (C0R e2) {
                    this.A04.A7z(A7z3, 2119, e2.toString(), null, null, A7z4);
                    if (this.A08) {
                        Log.e(A0A, A02(18, 22, 18), e2);
                    }
                    return null;
                } catch (C0W e3) {
                    this.A04.A7z(A7z, 2113, e3.toString(), null, null, A7z2);
                    if (this.A08) {
                        Log.e(A0A, A02(18, 22, 18), e3);
                    }
                    return null;
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public static java.lang.String A02(int r2, int r3, int r4) {
                /*
                    r0 = 0
                    r0 = 0
                    byte[] r1 = com.facebook.ads.redexgen.X.C0C.A09
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
                    int r0 = r0 + (-84)
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0C.A02(int, int, int):java.lang.String");
            }

            public static void A03() {
                A09 = new byte[]{-42, -12, 1, -70, 7, -77, 5, -8, -12, -9, -77, -12, 6, 6, -8, 7, 6, -63, -85, -40, -40, -43, -40, -122, -55, -57, -55, -50, -49, -44, -51, -122, -38, -50, -53, -122, -52, -49, -46, -53, -30, 0, 2, 7, 8, 13, 6, -65, 5, 8, 11, 4, -65, 13, 14, 19, -65, 2, 14, 12, 15, 11, 4, 19, 4, -65, -18, -32, 1, 52, 52, 37, 45, 48, 52, -6, -32, -29, 4, 11, 4, 19, 8, 13, 6, -65, 2, 0, 2, 7, 4, -65, 5, 8, 11, 4, -65, 0, 5, 19, 4, 17, -65, 4, 23, 2, 4, 4, 3, 8, 13, 6, -65, 17, 4, 19, 17, 24, -65, 0, 19, 19, 4, 12, 15, 19, 18, -39, -65, -6, -18, 52, 55, 58, 51, -18, 49, 58, 51, 47, 60, 51, 50, 8, -18, -17, 13, 20, 4, 9, 2, -69, 15, 10, -69, 13, 0, -4, -1, -69, -85, -40, -40, -43, -40, -122, -55, -46, -43, -39, -49, -44, -51, -122, -39, -43, -37, -40, -55, -53, 20, 50, 63, -8, 69, -15, 67, 54, 50, 53, -15, 61, 54, 63, 56, 69, 57, -15, 64, 55, -15, -18, -15, -12, -19, -62, -73, -73, -73, -23, -10, -20, -6, -9, -15, -20, -25, -23, -5, -5, -19, -4, -73, -122, -50, -57, -39, -122, -56, -53, -53, -44, -122, -49, -44, -38, -53, -40, -40, -37, -42, -38, -53, -54, -108, -33, -3, 10, -61, 16, -68, -1, 8, 11, 15, 1, -68, -1, -3, -1, 4, 1, -68, 2, 5, 8, 1, -54, -73, -43, -41, -36, -35, -30, -37, -108, -29, -38, -108, -41, 4, 4, 1, 4, -78, -11, -2, -9, -13, 0, -5, 0, -7, -78, -8, -5, -2, -9, -46, -16, -14, -9, -8, -3, -10, -81, -11, -8, -5, -12, -81, -14, -2, -4, -1, -5, -12, 3, -12, 48, 66, 66, 52, 67, 9, -2, -2, -2, -83, -46, -57, -45, -47, -44, -48, -55, -40, -55, -124, -42, -55, -41, -44, -45, -46, -41, -55, -110};
            }

            static {
                A03();
                A0A = C0C.class.getSimpleName();
            }

            {
                this.A05 = c0361Eb;
                this.A08 = c0a.A02();
                this.A00 = c0a.A00();
                this.A04 = c0x;
                this.A01 = c0a.A01();
                this.A02 = c0a;
            }

            public static C0M A00(Context context, String str) throws C0P {
                try {
                    InputStream open = context.getAssets().open(str);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr, 0, bArr.length);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            final byte[] byteArray = byteArrayOutputStream.toByteArray();
                            return new C0M(byteArray) { // from class: com.facebook.ads.redexgen.X.0N
                                public ByteArrayInputStream A00;
                                public final byte[] A01;

                                {
                                    this.A01 = byteArray;
                                }

                                @Override // com.facebook.ads.redexgen.X.C0M
                                public final void A7f(int i) throws C0R {
                                    this.A00 = new ByteArrayInputStream(this.A01);
                                    this.A00.skip(i);
                                }

                                @Override // com.facebook.ads.redexgen.X.C0M
                                public final void close() throws C0R {
                                }

                                @Override // com.facebook.ads.redexgen.X.C0M
                                public final int length() throws C0R {
                                    return this.A01.length;
                                }

                                @Override // com.facebook.ads.redexgen.X.C0M
                                public final int read(byte[] bArr2) throws C0R {
                                    return this.A00.read(bArr2, 0, bArr2.length);
                                }
                            };
                        }
                    }
                } catch (IOException e) {
                    throw new C0P(A02(0, 18, 63), e);
                }
            }

            /* JADX WARN: Not initialized variable reg: 11, insn: 0x016a: ARITH (r13 I:long) = (r13v0 ?? I:long) - (r11 I:long) A[Catch: all -> 0x0175], block:B:59:0x015e */
            private void A04(Context context, C0S c0s, String localUrl, int i, int i2, long j) throws C0P {
                C0M source;
                long currentTimeMillis;
                if (localUrl.startsWith(A02(201, 22, 52))) {
                    source = A00(context, localUrl.substring(A02(201, 22, 52).length()));
                } else if (localUrl.startsWith(A02(319, 9, 123))) {
                    source = A00(context, localUrl.substring(A02(319, 9, 123).length()));
                } else {
                    source = new C0T(localUrl, i);
                }
                try {
                    try {
                        if (this.A08) {
                            String str = A02(145, 15, 71) + localUrl + A02(66, 11, 108) + i2;
                        }
                        int A03 = c0s.A03();
                        int length = source.length();
                        boolean z = length < 0;
                        if (z) {
                            boolean A06 = A06(c0s);
                            if (this.A08) {
                                String str2 = A02(180, 21, 125) + localUrl + A02(129, 16, 122) + A06;
                            }
                        }
                        if (z || A03 < length) {
                            source.A7f(A03);
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = source.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    c0s.A08(bArr, read);
                                }
                            }
                        }
                        if (z) {
                            c0s.A07();
                        } else if (c0s.A03() == length) {
                            c0s.A07();
                        } else {
                            throw new C0R(A02(328, 20, 16));
                        }
                        int i3 = 0;
                        if (source instanceof C0T) {
                            i3 = ((C0T) source).A06();
                        }
                        this.A05.A06().A5d(j, System.currentTimeMillis() - j, c0s.A03(), 0L, i3, null);
                        try {
                            source.close();
                        } catch (C0P | IllegalArgumentException e) {
                            if (this.A08) {
                                Log.e(A0A, A02(160, 20, 18), e);
                            }
                        }
                    } catch (C0P e2) {
                        int i4 = 0;
                        if (source instanceof C0T) {
                            i4 = ((C0T) source).A06();
                        }
                        this.A05.A06().A5d(currentTimeMillis, System.currentTimeMillis() - currentTimeMillis, 0L, 0L, i4, null);
                        throw e2;
                    }
                } catch (Throwable th) {
                    try {
                        source.close();
                    } catch (C0P | IllegalArgumentException e3) {
                        if (this.A08) {
                            Log.e(A0A, A02(160, 20, 18), e3);
                        }
                    }
                    throw th;
                }
            }

            @SuppressLint({"CatchGeneralException"})
            private void A05(C0S c0s) {
                try {
                    File A04 = c0s.A04();
                    if (A04.exists()) {
                        c0s.A06();
                        boolean delete = A04.delete();
                        if (this.A08) {
                            Log.i(A0A, A02(77, 52, 75) + delete);
                        }
                    }
                } catch (Exception e) {
                    if (this.A08) {
                        Log.e(A0A, A02(245, 23, 72), e);
                    }
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x002e, code lost:            return r5;     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private boolean A06(com.facebook.ads.redexgen.X.C0S r7) {
                /*
                    r6 = this;
                    r5 = 0
                    r4 = 0
                    r0 = 2
                L3:
                    switch(r0) {
                        case 2: goto L1d;
                        case 3: goto L6;
                        case 4: goto La;
                        case 5: goto L7;
                        case 6: goto L6;
                        case 7: goto L2e;
                        default: goto L6;
                    }
                L6:
                    goto L3
                L7:
                    r5 = 0
                    r0 = 7
                    goto L3
                La:
                    java.lang.Throwable r4 = (java.lang.Throwable) r4
                    java.lang.String r3 = com.facebook.ads.redexgen.X.C0C.A0A
                    r2 = 279(0x117, float:3.91E-43)
                    r1 = 19
                    r0 = 62
                    java.lang.String r0 = A02(r2, r1, r0)
                    android.util.Log.e(r3, r0, r4)
                    r0 = 5
                    goto L3
                L1d:
                    com.facebook.ads.redexgen.X.0S r7 = (com.facebook.ads.redexgen.X.C0S) r7     // Catch: com.facebook.ads.redexgen.X.C0W -> L25
                    r7.A05()     // Catch: com.facebook.ads.redexgen.X.C0W -> L25
                    r5 = 1
                    r0 = 7
                    goto L3
                L25:
                    r4 = move-exception
                    boolean r0 = r6.A08
                    if (r0 == 0) goto L2c
                    r0 = 4
                    goto L3
                L2c:
                    r0 = 5
                    goto L3
                L2e:
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0C.A06(com.facebook.ads.redexgen.X.0S):boolean");
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.0B != com.facebook.ads.cache.config.CacheRequestConfig<T> */
            public final <T> AnonymousClass04<T> A07(AnonymousClass08 anonymousClass08, C0B<T> c0b) {
                Semaphore semaphore;
                AnonymousClass04<T> anonymousClass04;
                if (c0b.A03()) {
                    File file = this.A06.get(anonymousClass08.A09);
                    if (file != null) {
                        this.A04.A80(anonymousClass08.A09, true, anonymousClass08);
                        return c0b.A00().A34(file, this.A04);
                    }
                    this.A04.A80(anonymousClass08.A09, false, anonymousClass08);
                    return new AnonymousClass04<>(false, null);
                }
                String str = anonymousClass08.A09;
                String str2 = anonymousClass08.A04;
                StringBuilder sb = new StringBuilder();
                String extension = this.A03.A03(str);
                String sb2 = sb.append(extension).append(str2).toString();
                synchronized (this.A07) {
                    semaphore = this.A07.get(sb2);
                    if (semaphore == null) {
                        semaphore = new Semaphore(1);
                        this.A07.put(sb2, semaphore);
                    }
                }
                try {
                    try {
                        semaphore.acquire();
                        File A01 = A01(anonymousClass08, str, sb2, this.A01, c0b);
                        if (A01 != null) {
                            anonymousClass04 = c0b.A00().A34(A01, this.A04);
                            semaphore.release();
                            synchronized (this.A07) {
                                this.A07.remove(sb2);
                            }
                        } else {
                            anonymousClass04 = new AnonymousClass04<>(false, null);
                            semaphore.release();
                            synchronized (this.A07) {
                                this.A07.remove(sb2);
                            }
                        }
                        return anonymousClass04;
                    } catch (InterruptedException unused) {
                        if (this.A08) {
                            StringBuilder sb3 = new StringBuilder();
                            String extension2 = A02(268, 11, 32);
                            StringBuilder append = sb3.append(extension2).append(str);
                            String extension3 = A02(223, 22, 18);
                            append.append(extension3).toString();
                        }
                        AnonymousClass04<T> anonymousClass042 = new AnonymousClass04<>(false, null);
                        semaphore.release();
                        synchronized (this.A07) {
                            this.A07.remove(sb2);
                            return anonymousClass042;
                        }
                    }
                } catch (Throwable th) {
                    semaphore.release();
                    synchronized (this.A07) {
                        this.A07.remove(sb2);
                        throw th;
                    }
                }
            }

            @Override // com.facebook.ads.redexgen.X.AnonymousClass02
            public final AnonymousClass04<Bitmap> A8B(AnonymousClass08 anonymousClass08, boolean z) {
                return A07(anonymousClass08, new C0B(new AnonymousClass00<Bitmap>(anonymousClass08.A01, anonymousClass08.A00, this.A02.A04(), this.A02.A03(), z) { // from class: com.facebook.ads.redexgen.X.01
                    public static byte[] A06;
                    public final int A00;
                    public final int A01;
                    public final String A02 = AnonymousClass01.class.getSimpleName();
                    public final boolean A03;
                    public final boolean A04;
                    public final boolean A05;

                    static {
                        A02();
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public static java.lang.String A01(int r2, int r3, int r4) {
                        /*
                            r0 = 0
                            r0 = 0
                            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass01.A06
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
                            r0 = r0 ^ 68
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass01.A01(int, int, int):java.lang.String");
                    }

                    public static void A02() {
                        A06 = new byte[]{4, 47, 50, 43, 39, 54, 102, 47, 53, 102, 40, 51, 42, 42, 89, 100, Byte.MAX_VALUE, 121, 108, 104, 117, 115, 114, 60, 120, 105, 110, 117, 114, 123, 60, 122, 117, 112, 121, 60, Byte.MAX_VALUE, 115, 113, 108, 110, 121, 111, 111, 117, 115, 114, 5, 95, 70, 91};
                    }

                    {
                        this.A01 = r2;
                        this.A00 = r3;
                        this.A05 = r4;
                        this.A03 = r5;
                        this.A04 = z;
                    }

                    public static AnonymousClass04<Bitmap> A00(Throwable th) {
                        return new AnonymousClass04<>(false, null, th);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    private void A03(File file, @Nullable Bitmap bitmap) throws IOException {
                        if (bitmap == null) {
                            return;
                        }
                        FileOutputStream updatedCacheFileOS = null;
                        FileOutputStream fileOutputStream = null;
                        FileInputStream fileInputStream = null;
                        FileOutputStream fileOutputStream2 = null;
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                if (byteArrayOutputStream.size() >= 3145728) {
                                    C0Y.A07(byteArrayOutputStream);
                                    C0Y.A07(null);
                                    C0Y.A07(null);
                                    C0Y.A07(null);
                                    return;
                                }
                                String tempFileName = file.getCanonicalPath() + A01(47, 4, 111);
                                File file2 = new File(tempFileName);
                                file2.createNewFile();
                                FileOutputStream fileOutputStream3 = new FileOutputStream(tempFileName);
                                try {
                                    byteArrayOutputStream.writeTo(fileOutputStream3);
                                    fileOutputStream3.flush();
                                    FileInputStream fileInputStream2 = new FileInputStream(tempFileName);
                                    try {
                                        FileOutputStream fileOutputStream4 = new FileOutputStream(file);
                                        try {
                                            byte[] bArr = new byte[1024];
                                            while (true) {
                                                int read = fileInputStream2.read(bArr);
                                                if (read > 0) {
                                                    fileOutputStream4.write(bArr, 0, read);
                                                } else {
                                                    file2.delete();
                                                    C0Y.A07(byteArrayOutputStream);
                                                    C0Y.A07(fileOutputStream3);
                                                    C0Y.A07(fileInputStream2);
                                                    C0Y.A07(fileOutputStream4);
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            fileOutputStream2 = fileOutputStream4;
                                            fileInputStream = fileInputStream2;
                                            fileOutputStream = fileOutputStream3;
                                            updatedCacheFileOS = byteArrayOutputStream;
                                            C0Y.A07(updatedCacheFileOS);
                                            C0Y.A07(fileOutputStream);
                                            C0Y.A07(fileInputStream);
                                            C0Y.A07(fileOutputStream2);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileInputStream = fileInputStream2;
                                        fileOutputStream = fileOutputStream3;
                                        updatedCacheFileOS = byteArrayOutputStream;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = fileOutputStream3;
                                    updatedCacheFileOS = byteArrayOutputStream;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                updatedCacheFileOS = byteArrayOutputStream;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }

                    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
                    @SuppressLint({"CatchGeneralException"})
                    public final AnonymousClass04<Bitmap> A34(File file, C0X c0x2) {
                        AnonymousClass04<Bitmap> A00;
                        if (!this.A04) {
                            return new AnonymousClass04<>(true, null);
                        }
                        try {
                            Bitmap A03 = C0Y.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
                            if (A03 != null) {
                                A00 = new AnonymousClass04<>(true, A03);
                            } else {
                                c0x2.A5Q(new C0R(A01(0, 14, 2)));
                                A00 = A00(null);
                            }
                            return A00;
                        } catch (Throwable th) {
                            file.delete();
                            c0x2.A5Q(th);
                            return A00(th);
                        }
                    }

                    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
                    @SuppressLint({"CatchGeneralException"})
                    public final void A3j(File file, C0X c0x2) throws C0R {
                        if (this.A03) {
                            try {
                                Bitmap A03 = C0Y.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
                                if (A03 == null) {
                                    file.delete();
                                    throw new C0R(A01(0, 14, 2));
                                }
                                A03(file, A03);
                            } catch (C0R e) {
                                c0x2.A5Z(e);
                                throw e;
                            } catch (Throwable th) {
                                c0x2.A5Z(th);
                                throw new C0R(A01(14, 33, 88), th);
                            }
                        }
                    }
                }));
            }

            @Override // com.facebook.ads.redexgen.X.AnonymousClass02
            @Nullable
            public final String A8C(AnonymousClass08 anonymousClass08) {
                return (String) A07(anonymousClass08, new C0B(new AnonymousClass05())).A00();
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.0B != com.facebook.ads.cache.config.CacheRequestConfig<java.lang.String> */
            @Override // com.facebook.ads.redexgen.X.AnonymousClass02
            @Nullable
            public final String A8D(AnonymousClass08 anonymousClass08) {
                C0B c0b = new C0B(new AnonymousClass05());
                c0b.A01(true);
                c0b.A02(false);
                return (String) A07(anonymousClass08, c0b).A00();
            }
        };
    }
}
