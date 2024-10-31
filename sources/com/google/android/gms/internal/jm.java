package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
final class jm {

    /* renamed from: a, reason: collision with root package name */
    final int f1653a;
    final byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jm(int i, byte[] bArr) {
        this.f1653a = i;
        this.b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return 0 + zzrx.zzlO(this.f1653a) + this.b.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(zzrx zzrxVar) throws IOException {
        zzrxVar.zzlN(this.f1653a);
        zzrxVar.zzF(this.b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof jm)) {
            return false;
        }
        jm jmVar = (jm) obj;
        return this.f1653a == jmVar.f1653a && Arrays.equals(this.b, jmVar.b);
    }

    public int hashCode() {
        return ((this.f1653a + 527) * 31) + Arrays.hashCode(this.b);
    }
}
