package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzfd implements zzfz, zzga {
    private int index;
    private int state;
    private final int zzwg;
    private zzgb zzwh;
    private zzlv zzwi;
    private long zzwj;
    private boolean zzwk = true;
    private boolean zzwl;

    public zzfd(int i) {
        this.zzwg = i;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void disable() {
        zzpo.checkState(this.state == 1);
        this.state = 0;
        this.zzwi = null;
        this.zzwl = false;
        zzbm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.gms.internal.ads.zzfz, com.google.android.gms.internal.ads.zzga
    public final int getTrackType() {
        return this.zzwg;
    }

    protected void onStarted() throws zzff {
    }

    protected void onStopped() throws zzff {
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void start() throws zzff {
        zzpo.checkState(this.state == 1);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void stop() throws zzff {
        zzpo.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzfi
    public void zza(int i, Object obj) throws zzff {
    }

    protected void zza(long j, boolean z) throws zzff {
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void zza(zzgb zzgbVar, zzfs[] zzfsVarArr, zzlv zzlvVar, long j, boolean z, long j2) throws zzff {
        zzpo.checkState(this.state == 0);
        this.zzwh = zzgbVar;
        this.state = 1;
        zzb(z);
        zza(zzfsVarArr, zzlvVar, j2);
        zza(j, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zza(zzfs[] zzfsVarArr, long j) throws zzff {
    }

    protected void zzb(boolean z) throws zzff {
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final zzga zzbe() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public zzps zzbf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final zzlv zzbg() {
        return this.zzwi;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final boolean zzbh() {
        return this.zzwk;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void zzbi() {
        this.zzwl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final boolean zzbj() {
        return this.zzwl;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void zzbk() throws IOException {
        this.zzwi.zzev();
    }

    @Override // com.google.android.gms.internal.ads.zzga
    public int zzbl() throws zzff {
        return 0;
    }

    protected void zzbm() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzgb zzbn() {
        return this.zzwh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzbo() {
        return this.zzwk ? this.zzwl : this.zzwi.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void zzd(long j) throws zzff {
        this.zzwl = false;
        this.zzwk = false;
        zza(j, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zze(long j) {
        this.zzwi.zzz(j - this.zzwj);
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void zza(zzfs[] zzfsVarArr, zzlv zzlvVar, long j) throws zzff {
        zzpo.checkState(!this.zzwl);
        this.zzwi = zzlvVar;
        this.zzwk = false;
        this.zzwj = j;
        zza(zzfsVarArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zza(zzfu zzfuVar, zzho zzhoVar, boolean z) {
        int zzb = this.zzwi.zzb(zzfuVar, zzhoVar, z);
        if (zzb == -4) {
            if (zzhoVar.zzdp()) {
                this.zzwk = true;
                return this.zzwl ? -4 : -3;
            }
            zzhoVar.zzago += this.zzwj;
        } else if (zzb == -5) {
            zzfs zzfsVar = zzfuVar.zzaad;
            long j = zzfsVar.zzzy;
            if (j != Long.MAX_VALUE) {
                zzfuVar.zzaad = zzfsVar.zzj(j + this.zzwj);
            }
        }
        return zzb;
    }
}
