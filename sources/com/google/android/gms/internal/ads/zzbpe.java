package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

/* loaded from: classes2.dex */
public final class zzbpe {
    private static final AbstractC1000mh zzfkn;
    private static final int zzfko;

    /* loaded from: classes2.dex */
    static final class a extends AbstractC1000mh {
        a() {
        }

        @Override // com.google.android.gms.internal.ads.AbstractC1000mh
        public final void a(Throwable th) {
            th.printStackTrace();
        }

        @Override // com.google.android.gms.internal.ads.AbstractC1000mh
        public final void a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
    static {
        /*
            r0 = 1
            java.lang.Integer r1 = zzake()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L15
            int r2 = r1.intValue()     // Catch: java.lang.Throwable -> L2a
            r3 = 19
            if (r2 < r3) goto L15
            com.google.android.gms.internal.ads.qh r2 = new com.google.android.gms.internal.ads.qh     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L63
        L15:
            java.lang.String r2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch: java.lang.Throwable -> L2a
            r2 = r2 ^ r0
            if (r2 == 0) goto L24
            com.google.android.gms.internal.ads.ph r2 = new com.google.android.gms.internal.ads.ph     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L63
        L24:
            com.google.android.gms.internal.ads.zzbpe$a r2 = new com.google.android.gms.internal.ads.zzbpe$a     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L63
        L2a:
            r2 = move-exception
            goto L2e
        L2c:
            r2 = move-exception
            r1 = 0
        L2e:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.Class<com.google.android.gms.internal.ads.zzbpe$a> r4 = com.google.android.gms.internal.ads.zzbpe.a.class
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 132
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = "will be used. The error is: "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r3.println(r4)
            java.io.PrintStream r3 = java.lang.System.err
            r2.printStackTrace(r3)
            com.google.android.gms.internal.ads.zzbpe$a r2 = new com.google.android.gms.internal.ads.zzbpe$a
            r2.<init>()
        L63:
            com.google.android.gms.internal.ads.zzbpe.zzfkn = r2
            if (r1 != 0) goto L68
            goto L6c
        L68:
            int r0 = r1.intValue()
        L6c:
            com.google.android.gms.internal.ads.zzbpe.zzfko = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbpe.<clinit>():void");
    }

    public static void zza(Throwable th, PrintWriter printWriter) {
        zzfkn.a(th, printWriter);
    }

    private static Integer zzake() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            return null;
        }
    }

    public static void zze(Throwable th) {
        zzfkn.a(th);
    }
}
