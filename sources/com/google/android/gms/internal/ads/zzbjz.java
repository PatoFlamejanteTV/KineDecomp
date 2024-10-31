package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbne;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class zzbjz<P> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private ConcurrentMap<String, List<zzbka<P>>> zzfdc = new ConcurrentHashMap();
    private zzbka<P> zzfdd;

    public final void zza(zzbka<P> zzbkaVar) {
        this.zzfdd = zzbkaVar;
    }

    public final zzbka<P> zzafq() {
        return this.zzfdd;
    }

    public final Collection<List<zzbka<P>>> zzafr() throws GeneralSecurityException {
        return this.zzfdc.values();
    }

    public final zzbka<P> zza(P p, zzbne.zzb zzbVar) throws GeneralSecurityException {
        byte[] array;
        int i = C0844bg.f12083a[zzbVar.zzajc().ordinal()];
        if (i == 1 || i == 2) {
            array = ByteBuffer.allocate(5).put((byte) 0).putInt(zzbVar.zzajb()).array();
        } else if (i == 3) {
            array = ByteBuffer.allocate(5).put((byte) 1).putInt(zzbVar.zzajb()).array();
        } else if (i == 4) {
            array = zzbjp.zzfcy;
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        zzbka<P> zzbkaVar = new zzbka<>(p, array, zzbVar.zzaja(), zzbVar.zzajc());
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzbkaVar);
        String str = new String(zzbkaVar.zzaft(), UTF_8);
        List<zzbka<P>> put = this.zzfdc.put(str, Collections.unmodifiableList(arrayList));
        if (put != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(put);
            arrayList2.add(zzbkaVar);
            this.zzfdc.put(str, Collections.unmodifiableList(arrayList2));
        }
        return zzbkaVar;
    }
}
