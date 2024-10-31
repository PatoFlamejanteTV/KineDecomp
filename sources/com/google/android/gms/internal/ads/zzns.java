package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzns extends zznp {
    private final Uri uri;
    private final long zzbdr;
    private final String zzbds;
    private final zzno zzbdt;
    private final Ml zzbdu;

    public zzns(String str, long j, zzfs zzfsVar, String str2, zzny zznyVar, List<zznm> list, String str3, long j2) {
        super(str, -1L, zzfsVar, str2, zznyVar, list);
        String str4;
        this.uri = Uri.parse(str2);
        long j3 = zznyVar.zzbed;
        this.zzbdt = j3 <= 0 ? null : new zzno(null, zznyVar.zzbec, j3);
        if (str != null) {
            String str5 = zzfsVar.zzze;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(str5).length());
            sb.append(str);
            sb.append(".");
            sb.append(str5);
            sb.append(".-1");
            str4 = sb.toString();
        } else {
            str4 = null;
        }
        this.zzbds = str4;
        this.zzbdr = -1L;
        this.zzbdu = this.zzbdt == null ? new Ml(new zzno(null, 0L, -1L)) : null;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final String zzf() {
        return this.zzbds;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final zzno zzgi() {
        return this.zzbdt;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final zznd zzgj() {
        return this.zzbdu;
    }
}
