package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbut;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzbut<M extends zzbut<M>> extends zzbuz {
    protected zzbuv zzfwk;

    @Override // com.google.android.gms.internal.ads.zzbuz
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzbut zzbutVar = (zzbut) super.clone();
        zzbux.zza(this, zzbutVar);
        return zzbutVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public void zza(zzbur zzburVar) throws IOException {
        if (this.zzfwk == null) {
            return;
        }
        for (int i = 0; i < this.zzfwk.size(); i++) {
            this.zzfwk.zzgg(i).a(zzburVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    /* renamed from: zzapm */
    public final /* synthetic */ zzbuz clone() throws CloneNotSupportedException {
        return (zzbut) clone();
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public int zzt() {
        if (this.zzfwk == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzfwk.size(); i2++) {
            i += this.zzfwk.zzgg(i2).a();
        }
        return i;
    }

    public final boolean zza(zzbuq zzbuqVar, int i) throws IOException {
        int position = zzbuqVar.getPosition();
        if (!zzbuqVar.zzep(i)) {
            return false;
        }
        int i2 = i >>> 3;
        Zi zi = new Zi(i, zzbuqVar.zzam(position, zzbuqVar.getPosition() - position));
        Yi yi = null;
        zzbuv zzbuvVar = this.zzfwk;
        if (zzbuvVar == null) {
            this.zzfwk = new zzbuv();
        } else {
            yi = zzbuvVar.zzgf(i2);
        }
        if (yi == null) {
            yi = new Yi();
            this.zzfwk.zza(i2, yi);
        }
        yi.a(zi);
        return true;
    }
}
