package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzbfj implements Iterable<zzbfh> {
    private final List<zzbfh> zzewn = new ArrayList();

    public static boolean zzc(zzbdz zzbdzVar) {
        zzbfh zzd = zzd(zzbdzVar);
        if (zzd == null) {
            return false;
        }
        zzd.zzewk.abort();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbfh zzd(zzbdz zzbdzVar) {
        Iterator<zzbfh> it = com.google.android.gms.ads.internal.zzbv.C().iterator();
        while (it.hasNext()) {
            zzbfh next = it.next();
            if (next.zzerw == zzbdzVar) {
                return next;
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator<zzbfh> iterator() {
        return this.zzewn.iterator();
    }

    public final void zza(zzbfh zzbfhVar) {
        this.zzewn.add(zzbfhVar);
    }

    public final int zzada() {
        return this.zzewn.size();
    }

    public final void zzb(zzbfh zzbfhVar) {
        this.zzewn.remove(zzbfhVar);
    }
}
