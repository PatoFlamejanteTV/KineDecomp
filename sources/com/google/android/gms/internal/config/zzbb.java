package com.google.android.gms.internal.config;

import com.google.android.gms.internal.config.zzbb;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzbb<M extends zzbb<M>> extends zzbh {
    protected zzbd zzch;

    @Override // com.google.android.gms.internal.config.zzbh
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzbb zzbbVar = (zzbb) super.clone();
        zzbf.zza(this, zzbbVar);
        return zzbbVar;
    }

    @Override // com.google.android.gms.internal.config.zzbh
    public void zza(zzaz zzazVar) throws IOException {
        if (this.zzch == null) {
            return;
        }
        for (int i = 0; i < this.zzch.size(); i++) {
            this.zzch.zzp(i).a(zzazVar);
        }
    }

    @Override // com.google.android.gms.internal.config.zzbh
    /* renamed from: zzae */
    public final /* synthetic */ zzbh clone() throws CloneNotSupportedException {
        return (zzbb) clone();
    }

    @Override // com.google.android.gms.internal.config.zzbh
    public int zzu() {
        if (this.zzch == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzch.size(); i2++) {
            i += this.zzch.zzp(i2).a();
        }
        return i;
    }

    public final boolean zza(zzay zzayVar, int i) throws IOException {
        int position = zzayVar.getPosition();
        if (!zzayVar.zzh(i)) {
            return false;
        }
        int i2 = i >>> 3;
        b bVar = new b(i, zzayVar.zza(position, zzayVar.getPosition() - position));
        a aVar = null;
        zzbd zzbdVar = this.zzch;
        if (zzbdVar == null) {
            this.zzch = new zzbd();
        } else {
            aVar = zzbdVar.zzo(i2);
        }
        if (aVar == null) {
            aVar = new a();
            this.zzch.zza(i2, aVar);
        }
        aVar.a(bVar);
        return true;
    }
}
