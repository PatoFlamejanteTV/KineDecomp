package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzas extends zzry<zzas> {

    /* renamed from: a, reason: collision with root package name */
    public int f1135a;
    public long b;
    public long c;
    public long d;

    public zzas() {
        a();
    }

    public zzas a() {
        this.f1135a = 1;
        this.b = -1L;
        this.c = -1L;
        this.d = -1L;
        this.zzbik = null;
        this.zzbiv = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzse
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzas zzb(zzrw zzrwVar) throws IOException {
        while (true) {
            int zzFo = zzrwVar.zzFo();
            switch (zzFo) {
                case 0:
                    break;
                case 8:
                    this.f1135a = zzrwVar.zzFr();
                    break;
                case 16:
                    this.b = zzrwVar.zzFu();
                    break;
                case 24:
                    this.c = zzrwVar.zzFu();
                    break;
                case 32:
                    this.d = zzrwVar.zzFu();
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
        if (!(obj instanceof zzas)) {
            return false;
        }
        zzas zzasVar = (zzas) obj;
        if (this.f1135a == zzasVar.f1135a && this.b == zzasVar.b && this.c == zzasVar.c && this.d == zzasVar.d) {
            return (this.zzbik == null || this.zzbik.isEmpty()) ? zzasVar.zzbik == null || zzasVar.zzbik.isEmpty() : this.zzbik.equals(zzasVar.zzbik);
        }
        return false;
    }

    public int hashCode() {
        return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + ((((((((((getClass().getName().hashCode() + 527) * 31) + this.f1135a) * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31) + ((int) (this.c ^ (this.c >>> 32)))) * 31) + ((int) (this.d ^ (this.d >>> 32)))) * 31);
    }

    @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
    protected int zzB() {
        return super.zzB() + zzrx.zzA(1, this.f1135a) + zzrx.zze(2, this.b) + zzrx.zze(3, this.c) + zzrx.zze(4, this.d);
    }

    @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
    public void zza(zzrx zzrxVar) throws IOException {
        zzrxVar.zzy(1, this.f1135a);
        zzrxVar.zzc(2, this.b);
        zzrxVar.zzc(3, this.c);
        zzrxVar.zzc(4, this.d);
        super.zza(zzrxVar);
    }
}
