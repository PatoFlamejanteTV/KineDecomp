package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzald implements zzakp {
    private final Context mContext;
    private final long mStartTime;
    private final zzaba zzbln;
    private final zzalg zzbma;
    private final boolean zzbum;
    private final zzakr zzdmn;
    private final boolean zzdms;
    private final boolean zzdmt;
    private final zzasi zzdnh;
    private final long zzdni;
    private final String zzdnm;
    private zzaku zzdnr;
    private final Object mLock = new Object();
    private boolean zzdnk = false;
    private List<zzakx> zzdnn = new ArrayList();

    public zzald(Context context, zzasi zzasiVar, zzalg zzalgVar, zzakr zzakrVar, boolean z, boolean z2, String str, long j, long j2, zzaba zzabaVar, boolean z3) {
        this.mContext = context;
        this.zzdnh = zzasiVar;
        this.zzbma = zzalgVar;
        this.zzdmn = zzakrVar;
        this.zzbum = z;
        this.zzdms = z2;
        this.zzdnm = str;
        this.mStartTime = j;
        this.zzdni = j2;
        this.zzbln = zzabaVar;
        this.zzdmt = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzakp
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzdnk = true;
            if (this.zzdnr != null) {
                this.zzdnr.cancel();
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:55:0x0174
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    @Override // com.google.android.gms.internal.ads.zzakp
    public final com.google.android.gms.internal.ads.zzakx zzh(java.util.List<com.google.android.gms.internal.ads.zzakq> r32) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzald.zzh(java.util.List):com.google.android.gms.internal.ads.zzakx");
    }

    @Override // com.google.android.gms.internal.ads.zzakp
    public final List<zzakx> zzui() {
        return this.zzdnn;
    }
}
