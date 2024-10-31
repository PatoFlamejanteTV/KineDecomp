package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzbv {
    private final Collection<zzbu> zzug = new ArrayList();
    private final Collection<zzbu<String>> zzuh = new ArrayList();
    private final Collection<zzbu<String>> zzui = new ArrayList();

    public void zza(zzbu zzbuVar) {
        this.zzug.add(zzbuVar);
    }

    public void zzb(zzbu<String> zzbuVar) {
        this.zzuh.add(zzbuVar);
    }

    public void zzc(zzbu<String> zzbuVar) {
        this.zzui.add(zzbuVar);
    }

    public List<String> zzdf() {
        ArrayList arrayList = new ArrayList();
        Iterator<zzbu<String>> it = this.zzuh.iterator();
        while (it.hasNext()) {
            String str = it.next().get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
