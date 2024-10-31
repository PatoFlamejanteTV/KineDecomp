package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzdu implements Iterable<zzdt> {
    private final List<zzdt> zzyb = new LinkedList();

    private zzdt zzc(zziz zzizVar) {
        Iterator<zzdt> it = com.google.android.gms.ads.internal.zzp.r().iterator();
        while (it.hasNext()) {
            zzdt next = it.next();
            if (next.zzoM == zzizVar) {
                return next;
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<zzdt> iterator() {
        return this.zzyb.iterator();
    }

    public void zza(zzdt zzdtVar) {
        this.zzyb.add(zzdtVar);
    }

    public boolean zza(zziz zzizVar) {
        zzdt zzc = zzc(zzizVar);
        if (zzc == null) {
            return false;
        }
        zzc.zzxY.abort();
        return true;
    }

    public void zzb(zzdt zzdtVar) {
        this.zzyb.remove(zzdtVar);
    }

    public boolean zzb(zziz zzizVar) {
        return zzc(zzizVar) != null;
    }
}
