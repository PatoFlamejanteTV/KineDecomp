package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzat extends zzry<zzat> {

    /* renamed from: a, reason: collision with root package name */
    public int f1136a;
    public String b;
    public long c;
    public long d;
    public int e;

    public zzat() {
        a();
    }

    public zzat a() {
        this.f1136a = 1;
        this.b = "";
        this.c = -1L;
        this.d = -1L;
        this.e = -1;
        this.zzbik = null;
        this.zzbiv = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzse
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzat zzb(zzrw zzrwVar) throws IOException {
        while (true) {
            int zzFo = zzrwVar.zzFo();
            switch (zzFo) {
                case 0:
                    break;
                case 8:
                    this.f1136a = zzrwVar.zzFr();
                    break;
                case 18:
                    this.b = zzrwVar.readString();
                    break;
                case 24:
                    this.c = zzrwVar.zzFu();
                    break;
                case 32:
                    this.d = zzrwVar.zzFu();
                    break;
                case 40:
                    this.e = zzrwVar.zzFr();
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
        if (!(obj instanceof zzat)) {
            return false;
        }
        zzat zzatVar = (zzat) obj;
        if (this.f1136a != zzatVar.f1136a) {
            return false;
        }
        if (this.b == null) {
            if (zzatVar.b != null) {
                return false;
            }
        } else if (!this.b.equals(zzatVar.b)) {
            return false;
        }
        if (this.c == zzatVar.c && this.d == zzatVar.d && this.e == zzatVar.e) {
            return (this.zzbik == null || this.zzbik.isEmpty()) ? zzatVar.zzbik == null || zzatVar.zzbik.isEmpty() : this.zzbik.equals(zzatVar.zzbik);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((this.b == null ? 0 : this.b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.f1136a) * 31)) * 31) + ((int) (this.c ^ (this.c >>> 32)))) * 31) + ((int) (this.d ^ (this.d >>> 32)))) * 31) + this.e) * 31;
        if (this.zzbik != null && !this.zzbik.isEmpty()) {
            i = this.zzbik.hashCode();
        }
        return hashCode + i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
    public int zzB() {
        int zzB = super.zzB() + zzrx.zzA(1, this.f1136a) + zzrx.zzn(2, this.b) + zzrx.zze(3, this.c) + zzrx.zze(4, this.d);
        return this.e != -1 ? zzB + zzrx.zzA(5, this.e) : zzB;
    }

    @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
    public void zza(zzrx zzrxVar) throws IOException {
        zzrxVar.zzy(1, this.f1136a);
        zzrxVar.zzb(2, this.b);
        zzrxVar.zzc(3, this.c);
        zzrxVar.zzc(4, this.d);
        if (this.e != -1) {
            zzrxVar.zzy(5, this.e);
        }
        super.zza(zzrxVar);
    }
}
