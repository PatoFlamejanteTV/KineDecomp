package com.facebook.ads.redexgen.X;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.facebook.ads.redexgen.X.0K, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C0K implements C0F {
    public static byte[] A01;
    public static final String A02;
    public final ExecutorService A00 = Executors.newSingleThreadExecutor();

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:            return r3;     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 7
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:626)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long A00(java.util.List<java.io.File> r6) {
        /*
            r5 = this;
            r0 = 0
            r0 = 0
            r3 = 0
            java.util.Iterator r2 = r6.iterator()
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1a;
                case 4: goto L29;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            java.util.Iterator r2 = (java.util.Iterator) r2
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L18
            r0 = 3
            goto La
        L18:
            r0 = 4
            goto La
        L1a:
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r0 = r2.next()
            java.io.File r0 = (java.io.File) r0
            long r0 = r0.length()
            long r3 = r3 + r0
            r0 = 2
            goto La
        L29:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0K.A00(java.util.List):long");
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0K.A01
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
            r0 = r0 ^ 96
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0K.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A01 = new byte[]{60, 11, 11, 22, 11, 89, 29, 28, 21, 28, 13, 16, 23, 30, 89, 31, 16, 21, 28, 89, 11, 41, 43, 32, 45, 104, 46, 33, 36, 45, 104, 16, 86, 95, 66, 16, 68, 66, 89, 93, 93, 89, 94, 87, 16, 83, 81, 83, 88, 85, 80, 25, 3, 80, 20, 21, 28, 21, 4, 21, 20, 80, 18, 21, 19, 17, 5, 3, 21, 80, 25, 4, 80, 21, 8, 19, 21, 21, 20, 3, 80, 19, 17, 19, 24, 21, 80, 28, 25, 29, 25, 4};
    }

    public abstract boolean A06(File file, long j, int i);

    static {
        A02();
        A02 = C0K.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(File file) throws IOException {
        C0I.A03(file);
        A05(C0I.A01(file.getParentFile()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b3, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A05(java.util.List<java.io.File> r14) {
        /*
            r13 = this;
            r8 = r13
            r11 = 0
            r7 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            long r1 = r8.A00(r14)
            int r6 = r14.size()
            java.util.Iterator r9 = r14.iterator()
            r0 = 2
        L15:
            switch(r0) {
                case 2: goto La5;
                case 3: goto L8f;
                case 4: goto L7f;
                case 5: goto L4a;
                case 6: goto L19;
                case 7: goto Lb3;
                default: goto L18;
            }
        L18:
            goto L15
        L19:
            java.io.File r7 = (java.io.File) r7
            java.lang.String r10 = com.facebook.ads.redexgen.X.C0K.A02
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r4 = 0
            r3 = 20
            r0 = 25
            java.lang.String r0 = A01(r4, r3, r0)
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.StringBuilder r5 = r0.append(r7)
            r4 = 31
            r3 = 19
            r0 = 80
            java.lang.String r0 = A01(r4, r3, r0)
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r10, r0)
            r0 = 2
            goto L15
        L4a:
            java.io.File r7 = (java.io.File) r7
            int r6 = r6 + (-1)
            long r1 = r1 - r11
            java.lang.String r10 = com.facebook.ads.redexgen.X.C0K.A02
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r4 = 20
            r3 = 11
            r0 = 40
            java.lang.String r0 = A01(r4, r3, r0)
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.StringBuilder r5 = r0.append(r7)
            r4 = 50
            r3 = 42
            r0 = 16
            java.lang.String r0 = A01(r4, r3, r0)
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r10, r0)
            r0 = 2
            goto L15
        L7f:
            java.io.File r7 = (java.io.File) r7
            long r11 = r7.length()
            boolean r0 = r7.delete()
            if (r0 == 0) goto L8d
            r0 = 5
            goto L15
        L8d:
            r0 = 6
            goto L15
        L8f:
            com.facebook.ads.redexgen.X.0K r8 = (com.facebook.ads.redexgen.X.C0K) r8
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r7 = r9.next()
            java.io.File r7 = (java.io.File) r7
            boolean r0 = r8.A06(r7, r1, r6)
            if (r0 != 0) goto La2
            r0 = 4
            goto L15
        La2:
            r0 = 2
            goto L15
        La5:
            java.util.Iterator r9 = (java.util.Iterator) r9
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto Lb0
            r0 = 3
            goto L15
        Lb0:
            r0 = 7
            goto L15
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0K.A05(java.util.List):void");
    }

    @Override // com.facebook.ads.redexgen.X.C0F
    public void A8T(final File file) throws IOException {
        this.A00.submit(new Callable<Void>(file) { // from class: com.facebook.ads.redexgen.X.0J
            public final File A00;

            {
                this.A00 = file;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final Void call() throws Exception {
                C0K.this.A04(this.A00);
                return null;
            }
        });
    }
}
