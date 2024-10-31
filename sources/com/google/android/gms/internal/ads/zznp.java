package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zznp {
    public final zzfs zzaad;
    private final String zzbdc;
    public final String zzbde;
    private final long zzbdm;
    public final long zzbdn;
    public final List<zznm> zzbdo;
    private final zzno zzbdp;

    /* JADX INFO: Access modifiers changed from: private */
    public zznp(String str, long j, zzfs zzfsVar, String str2, zznt zzntVar, List<zznm> list) {
        List<zznm> unmodifiableList;
        this.zzbdc = str;
        this.zzbdm = j;
        this.zzaad = zzfsVar;
        this.zzbde = str2;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.zzbdo = unmodifiableList;
        this.zzbdp = zzntVar.zza(this);
        this.zzbdn = zzqe.zza(zzntVar.zzbdw, 1000000L, zzntVar.zzcr);
    }

    public abstract String zzf();

    public final zzno zzgh() {
        return this.zzbdp;
    }

    public abstract zzno zzgi();

    public abstract zznd zzgj();

    public /* synthetic */ zznp(String str, long j, zzfs zzfsVar, String str2, zznt zzntVar, List list, Ll ll) {
        this(str, j, zzfsVar, str2, zzntVar, list);
    }
}
