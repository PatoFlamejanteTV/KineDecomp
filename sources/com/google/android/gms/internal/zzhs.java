package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzhs {
    public final int errorCode;
    public final int orientation;
    public final zziz zzBD;
    public final long zzEJ;
    public final boolean zzEK;
    public final long zzEL;
    public final List<String> zzEM;
    public final String zzEP;
    public final AdRequestParcel zzEn;
    public final String zzEq;
    public final long zzHA;
    public final zzh.zza zzHB;
    public final JSONObject zzHw;
    public final zzee zzHx;
    public final AdSizeParcel zzHy;
    public final long zzHz;
    public final List<String> zzyY;
    public final List<String> zzyZ;
    public final long zzzc;
    public final zzed zzzu;
    public final zzen zzzv;
    public final String zzzw;
    public final zzeg zzzx;

    @zzgr
    /* loaded from: classes.dex */
    public static final class zza {
        public final int errorCode;
        public final long zzHA;
        public final AdRequestInfoParcel zzHC;
        public final AdResponseParcel zzHD;
        public final JSONObject zzHw;
        public final zzee zzHx;
        public final long zzHz;
        public final AdSizeParcel zzqn;

        public zza(AdRequestInfoParcel adRequestInfoParcel, AdResponseParcel adResponseParcel, zzee zzeeVar, AdSizeParcel adSizeParcel, int i, long j, long j2, JSONObject jSONObject) {
            this.zzHC = adRequestInfoParcel;
            this.zzHD = adResponseParcel;
            this.zzHx = zzeeVar;
            this.zzqn = adSizeParcel;
            this.errorCode = i;
            this.zzHz = j;
            this.zzHA = j2;
            this.zzHw = jSONObject;
        }
    }

    public zzhs(AdRequestParcel adRequestParcel, zziz zzizVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, zzed zzedVar, zzen zzenVar, String str2, zzee zzeeVar, zzeg zzegVar, long j2, AdSizeParcel adSizeParcel, long j3, long j4, long j5, String str3, JSONObject jSONObject, zzh.zza zzaVar) {
        this.zzEn = adRequestParcel;
        this.zzBD = zzizVar;
        this.zzyY = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i;
        this.zzyZ = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzEM = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.orientation = i2;
        this.zzzc = j;
        this.zzEq = str;
        this.zzEK = z;
        this.zzzu = zzedVar;
        this.zzzv = zzenVar;
        this.zzzw = str2;
        this.zzHx = zzeeVar;
        this.zzzx = zzegVar;
        this.zzEL = j2;
        this.zzHy = adSizeParcel;
        this.zzEJ = j3;
        this.zzHz = j4;
        this.zzHA = j5;
        this.zzEP = str3;
        this.zzHw = jSONObject;
        this.zzHB = zzaVar;
    }

    public zzhs(zza zzaVar, zziz zzizVar, zzed zzedVar, zzen zzenVar, String str, zzeg zzegVar, zzh.zza zzaVar2) {
        this(zzaVar.zzHC.c, zzizVar, zzaVar.zzHD.d, zzaVar.errorCode, zzaVar.zzHD.f, zzaVar.zzHD.j, zzaVar.zzHD.l, zzaVar.zzHD.k, zzaVar.zzHC.i, zzaVar.zzHD.h, zzedVar, zzenVar, str, zzaVar.zzHx, zzegVar, zzaVar.zzHD.i, zzaVar.zzqn, zzaVar.zzHD.g, zzaVar.zzHz, zzaVar.zzHA, zzaVar.zzHD.o, zzaVar.zzHw, zzaVar2);
    }

    public boolean zzbY() {
        if (this.zzBD == null || this.zzBD.zzhe() == null) {
            return false;
        }
        return this.zzBD.zzhe().zzbY();
    }
}
