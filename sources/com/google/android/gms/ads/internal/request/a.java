package com.google.android.gms.ads.internal.request;

import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ OutputStream f626a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ LargeParcelTeleporter c;

    public a(LargeParcelTeleporter largeParcelTeleporter, OutputStream outputStream, byte[] bArr) {
        this.c = largeParcelTeleporter;
        this.f626a = outputStream;
        this.b = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r4 = this;
            r2 = 0
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L3a
            java.io.OutputStream r0 = r4.f626a     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L3a
            r1.<init>(r0)     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L3a
            byte[] r0 = r4.b     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4a
            int r0 = r0.length     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4a
            r1.writeInt(r0)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4a
            byte[] r0 = r4.b     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4a
            r1.write(r0)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4a
            if (r1 != 0) goto L1b
            java.io.OutputStream r0 = r4.f626a
            com.google.android.gms.internal.zzmt.zzb(r0)
        L1a:
            return
        L1b:
            com.google.android.gms.internal.zzmt.zzb(r1)
            goto L1a
        L1f:
            r0 = move-exception
            r1 = r2
        L21:
            java.lang.String r2 = "Error transporting the ad response"
            com.google.android.gms.ads.internal.util.client.zzb.b(r2, r0)     // Catch: java.lang.Throwable -> L48
            com.google.android.gms.internal.zzhu r2 = com.google.android.gms.ads.internal.zzp.h()     // Catch: java.lang.Throwable -> L48
            r3 = 1
            r2.zzc(r0, r3)     // Catch: java.lang.Throwable -> L48
            if (r1 != 0) goto L36
            java.io.OutputStream r0 = r4.f626a
            com.google.android.gms.internal.zzmt.zzb(r0)
            goto L1a
        L36:
            com.google.android.gms.internal.zzmt.zzb(r1)
            goto L1a
        L3a:
            r0 = move-exception
            r1 = r2
        L3c:
            if (r1 != 0) goto L44
            java.io.OutputStream r1 = r4.f626a
            com.google.android.gms.internal.zzmt.zzb(r1)
        L43:
            throw r0
        L44:
            com.google.android.gms.internal.zzmt.zzb(r1)
            goto L43
        L48:
            r0 = move-exception
            goto L3c
        L4a:
            r0 = move-exception
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.a.run():void");
    }
}
