package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzuq;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzuq<M extends zzuq<M>> extends zzuw {
    protected zzus zzbhb;

    @Override // com.google.android.gms.internal.gtm.zzuw
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzuq zzuqVar = (zzuq) super.clone();
        zzuu.zza(this, zzuqVar);
        return zzuqVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public void zza(zzuo zzuoVar) throws IOException {
        if (this.zzbhb == null) {
            return;
        }
        for (int i = 0; i < this.zzbhb.size(); i++) {
            this.zzbhb.zzce(i).a(zzuoVar);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    /* renamed from: zzry */
    public final /* synthetic */ zzuw clone() throws CloneNotSupportedException {
        return (zzuq) clone();
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public int zzy() {
        if (this.zzbhb == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzbhb.size(); i2++) {
            i += this.zzbhb.zzce(i2).a();
        }
        return i;
    }

    public final <T> T zza(zzur<M, T> zzurVar) {
        Db zzcd;
        zzus zzusVar = this.zzbhb;
        if (zzusVar == null || (zzcd = zzusVar.zzcd(zzurVar.tag >>> 3)) == null) {
            return null;
        }
        return (T) zzcd.a(zzurVar);
    }

    public final boolean zza(zzun zzunVar, int i) throws IOException {
        int position = zzunVar.getPosition();
        if (!zzunVar.zzao(i)) {
            return false;
        }
        int i2 = i >>> 3;
        Eb eb = new Eb(i, zzunVar.zzt(position, zzunVar.getPosition() - position));
        Db db = null;
        zzus zzusVar = this.zzbhb;
        if (zzusVar == null) {
            this.zzbhb = new zzus();
        } else {
            db = zzusVar.zzcd(i2);
        }
        if (db == null) {
            db = new Db();
            this.zzbhb.zza(i2, db);
        }
        db.a(eb);
        return true;
    }
}
