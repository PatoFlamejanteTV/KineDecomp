package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class zzer extends zzeq {
    protected final byte[] zzsw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzer(byte[] bArr) {
        if (bArr != null) {
            this.zzsw = bArr;
            return;
        }
        throw new NullPointerException();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeh) || size() != ((zzeh) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof zzer) {
            zzer zzerVar = (zzer) obj;
            int zzfe = zzfe();
            int zzfe2 = zzerVar.zzfe();
            if (zzfe == 0 || zzfe2 == 0 || zzfe == zzfe2) {
                return zza(zzerVar, 0, size());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public int size() {
        return this.zzsw.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final void zza(zzeg zzegVar) throws IOException {
        zzegVar.zza(this.zzsw, zzff(), size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzsw, i, bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final int zzc(int i, int i2, int i3) {
        return zzfv.zza(i, this.zzsw, zzff() + i2, i3);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final zzeh zzd(int i, int i2) {
        int zzd = zzeh.zzd(i, i2, size());
        if (zzd == 0) {
            return zzeh.zzso;
        }
        return new zzem(this.zzsw, zzff() + i, zzd);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final boolean zzfb() {
        int zzff = zzff();
        return La.a(this.zzsw, zzff, size() + zzff);
    }

    protected int zzff() {
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public byte zzk(int i) {
        return this.zzsw[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public byte zzl(int i) {
        return this.zzsw[i];
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    protected final String zza(Charset charset) {
        return new String(this.zzsw, zzff(), size(), charset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final int zzb(int i, int i2, int i3) {
        int zzff = zzff() + i2;
        return La.a(i, this.zzsw, zzff, i3 + zzff);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeq
    final boolean zza(zzeh zzehVar, int i, int i2) {
        if (i2 <= zzehVar.size()) {
            int i3 = i + i2;
            if (i3 <= zzehVar.size()) {
                if (zzehVar instanceof zzer) {
                    zzer zzerVar = (zzer) zzehVar;
                    byte[] bArr = this.zzsw;
                    byte[] bArr2 = zzerVar.zzsw;
                    int zzff = zzff() + i2;
                    int zzff2 = zzff();
                    int zzff3 = zzerVar.zzff() + i;
                    while (zzff2 < zzff) {
                        if (bArr[zzff2] != bArr2[zzff3]) {
                            return false;
                        }
                        zzff2++;
                        zzff3++;
                    }
                    return true;
                }
                return zzehVar.zzd(i, i3).equals(zzd(0, i2));
            }
            int size = zzehVar.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: ");
            sb.append(i);
            sb.append(", ");
            sb.append(i2);
            sb.append(", ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i2);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }
}
