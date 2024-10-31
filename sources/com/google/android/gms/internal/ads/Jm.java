package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
/* loaded from: classes2.dex */
final class Jm {

    /* renamed from: a */
    @VisibleForTesting
    private ByteArrayOutputStream f11632a = new ByteArrayOutputStream(4096);

    /* renamed from: b */
    @VisibleForTesting
    private Base64OutputStream f11633b = new Base64OutputStream(this.f11632a, 10);

    public final void a(byte[] bArr) throws IOException {
        this.f11633b.write(bArr);
    }

    public final String toString() {
        try {
            this.f11633b.close();
        } catch (IOException e2) {
            zzbbd.zzb("HashManager: Unable to convert to Base64.", e2);
        }
        try {
            this.f11632a.close();
            return this.f11632a.toString();
        } catch (IOException e3) {
            zzbbd.zzb("HashManager: Unable to convert to Base64.", e3);
            return "";
        } finally {
            this.f11632a = null;
            this.f11633b = null;
        }
    }
}
