package com.google.android.gms.internal;

import com.google.android.gms.internal.zzry;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class zzry<M extends zzry<M>> extends zzse {
    protected zzsa zzbik;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzse
    public int zzB() {
        if (this.zzbik == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzbik.size(); i2++) {
            i += this.zzbik.zzlS(i2).a();
        }
        return i;
    }

    @Override // com.google.android.gms.internal.zzse
    /* renamed from: zzFF, reason: merged with bridge method [inline-methods] */
    public M clone() throws CloneNotSupportedException {
        M m = (M) super.clone();
        zzsc.zza(this, m);
        return m;
    }

    public final <T> T zza(zzrz<M, T> zzrzVar) {
        jl zzlR;
        if (this.zzbik == null || (zzlR = this.zzbik.zzlR(zzsh.zzlV(zzrzVar.tag))) == null) {
            return null;
        }
        return (T) zzlR.a(zzrzVar);
    }

    @Override // com.google.android.gms.internal.zzse
    public void zza(zzrx zzrxVar) throws IOException {
        if (this.zzbik == null) {
            return;
        }
        for (int i = 0; i < this.zzbik.size(); i++) {
            this.zzbik.zzlS(i).a(zzrxVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zza(zzrw zzrwVar, int i) throws IOException {
        int position = zzrwVar.getPosition();
        if (!zzrwVar.zzlA(i)) {
            return false;
        }
        int zzlV = zzsh.zzlV(i);
        jm jmVar = new jm(i, zzrwVar.zzx(position, zzrwVar.getPosition() - position));
        jl jlVar = null;
        if (this.zzbik == null) {
            this.zzbik = new zzsa();
        } else {
            jlVar = this.zzbik.zzlR(zzlV);
        }
        if (jlVar == null) {
            jlVar = new jl();
            this.zzbik.zza(zzlV, jlVar);
        }
        jlVar.a(jmVar);
        return true;
    }
}
