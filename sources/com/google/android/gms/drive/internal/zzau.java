package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzau extends zzry<zzau> {

    /* renamed from: a, reason: collision with root package name */
    public long f1137a;
    public long b;

    public zzau() {
        a();
    }

    public zzau a() {
        this.f1137a = -1L;
        this.b = -1L;
        this.zzbik = null;
        this.zzbiv = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzse
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzau zzb(zzrw zzrwVar) throws IOException {
        while (true) {
            int zzFo = zzrwVar.zzFo();
            switch (zzFo) {
                case 0:
                    break;
                case 8:
                    this.f1137a = zzrwVar.zzFu();
                    break;
                case 16:
                    this.b = zzrwVar.zzFu();
                    break;
                default:
                    if (!zza(zzrwVar, zzFo)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzau)) {
            return false;
        }
        zzau zzauVar = (zzau) obj;
        if (this.f1137a == zzauVar.f1137a && this.b == zzauVar.b) {
            return (this.zzbik == null || this.zzbik.isEmpty()) ? zzauVar.zzbik == null || zzauVar.zzbik.isEmpty() : this.zzbik.equals(zzauVar.zzbik);
        }
        return false;
    }

    public int hashCode() {
        return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.f1137a ^ (this.f1137a >>> 32)))) * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
    public int zzB() {
        return super.zzB() + zzrx.zze(1, this.f1137a) + zzrx.zze(2, this.b);
    }

    @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
    public void zza(zzrx zzrxVar) throws IOException {
        zzrxVar.zzc(1, this.f1137a);
        zzrxVar.zzc(2, this.b);
        super.zza(zzrxVar);
    }
}
