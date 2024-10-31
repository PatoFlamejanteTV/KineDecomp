package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzhd extends zzjy implements zzps {
    private final zzgl zzaeu;
    private final zzgs zzaev;
    private boolean zzaew;
    private boolean zzaex;
    private MediaFormat zzaey;
    private long zzaez;
    private boolean zzafa;
    private int zzzt;
    private int zzzv;

    public zzhd(zzka zzkaVar) {
        this(zzkaVar, null, true);
    }

    public static void zza(int i, long j, long j2) {
    }

    public static void zzdi() {
    }

    public static void zzl(int i) {
    }

    private final boolean zzs(String str) {
        return this.zzaev.zzq(str);
    }

    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfz
    public final boolean isReady() {
        return this.zzaev.zzcw() || super.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzff {
        int[] iArr;
        int i;
        boolean z = this.zzaey != null;
        String string = z ? this.zzaey.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.zzaey;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.zzaex && integer == 6 && (i = this.zzzt) < 6) {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.zzzt; i2++) {
                iArr[i2] = i2;
            }
        } else {
            iArr = null;
        }
        try {
            this.zzaev.zza(string, integer, integer2, this.zzzv, 0, iArr);
        } catch (zzgw e2) {
            throw zzff.zza(e2, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void onStarted() {
        super.onStarted();
        this.zzaev.play();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void onStopped() {
        this.zzaev.pause();
        super.onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final int zza(zzka zzkaVar, zzfs zzfsVar) throws zzke {
        int i;
        int i2;
        String str = zzfsVar.zzzj;
        if (!zzpt.zzab(str)) {
            return 0;
        }
        int i3 = zzqe.SDK_INT >= 21 ? 16 : 0;
        if (zzs(str) && zzkaVar.zzeq() != null) {
            return i3 | 4 | 3;
        }
        zzjx zzb = zzkaVar.zzb(str, false);
        boolean z = true;
        if (zzb == null) {
            return 1;
        }
        if (zzqe.SDK_INT >= 21 && (((i = zzfsVar.zzzu) != -1 && !zzb.zzam(i)) || ((i2 = zzfsVar.zzzt) != -1 && !zzb.zzan(i2)))) {
            z = false;
        }
        return i3 | 4 | (z ? 3 : 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void zzb(boolean z) throws zzff {
        super.zzb(z);
        this.zzaeu.zzc(this.zzavd);
        int i = zzbn().zzaak;
        if (i != 0) {
            this.zzaev.zzn(i);
        } else {
            this.zzaev.zzcy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfd, com.google.android.gms.internal.ads.zzfz
    public final zzps zzbf() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void zzbm() {
        try {
            this.zzaev.release();
            try {
                super.zzbm();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.zzbm();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final void zzc(String str, long j, long j2) {
        this.zzaeu.zzb(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfz
    public final boolean zzcj() {
        return super.zzcj() && this.zzaev.zzcj();
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final zzfy zzcx() {
        return this.zzaev.zzcx();
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final long zzde() {
        long zzg = this.zzaev.zzg(zzcj());
        if (zzg != Long.MIN_VALUE) {
            if (!this.zzafa) {
                zzg = Math.max(this.zzaez, zzg);
            }
            this.zzaez = zzg;
            this.zzafa = false;
        }
        return this.zzaez;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final void zzdj() throws zzff {
        try {
            this.zzaev.zzcu();
        } catch (zzha e2) {
            throw zzff.zza(e2, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zze(zzfs zzfsVar) throws zzff {
        super.zze(zzfsVar);
        this.zzaeu.zzd(zzfsVar);
        this.zzzv = "audio/raw".equals(zzfsVar.zzzj) ? zzfsVar.zzzv : 2;
        this.zzzt = zzfsVar.zzzt;
    }

    private zzhd(zzka zzkaVar, zzhu<Object> zzhuVar, boolean z) {
        this(zzkaVar, null, true, null, null);
    }

    private zzhd(zzka zzkaVar, zzhu<Object> zzhuVar, boolean z, Handler handler, zzgk zzgkVar) {
        this(zzkaVar, null, true, null, null, null, new zzgi[0]);
    }

    private zzhd(zzka zzkaVar, zzhu<Object> zzhuVar, boolean z, Handler handler, zzgk zzgkVar, zzgh zzghVar, zzgi... zzgiVarArr) {
        super(1, zzkaVar, zzhuVar, z);
        this.zzaev = new zzgs(null, zzgiVarArr, new C1003mk(this));
        this.zzaeu = new zzgl(null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final zzfy zzb(zzfy zzfyVar) {
        return this.zzaev.zzb(zzfyVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final zzjx zza(zzka zzkaVar, zzfs zzfsVar, boolean z) throws zzke {
        zzjx zzeq;
        if (zzs(zzfsVar.zzzj) && (zzeq = zzkaVar.zzeq()) != null) {
            this.zzaew = true;
            return zzeq;
        }
        this.zzaew = false;
        return super.zza(zzkaVar, zzfsVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final void zza(zzjx zzjxVar, MediaCodec mediaCodec, zzfs zzfsVar, MediaCrypto mediaCrypto) {
        this.zzaex = zzqe.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(zzjxVar.name) && "samsung".equals(zzqe.MANUFACTURER) && (zzqe.DEVICE.startsWith("zeroflte") || zzqe.DEVICE.startsWith("herolte") || zzqe.DEVICE.startsWith("heroqlte"));
        if (this.zzaew) {
            this.zzaey = zzfsVar.zzcf();
            this.zzaey.setString("mime", "audio/raw");
            mediaCodec.configure(this.zzaey, (Surface) null, (MediaCrypto) null, 0);
            this.zzaey.setString("mime", zzfsVar.zzzj);
            return;
        }
        mediaCodec.configure(zzfsVar.zzcf(), (Surface) null, (MediaCrypto) null, 0);
        this.zzaey = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void zza(long j, boolean z) throws zzff {
        super.zza(j, z);
        this.zzaev.reset();
        this.zzaez = j;
        this.zzafa = true;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzff {
        if (this.zzaew && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzavd.zzagk++;
            this.zzaev.zzct();
            return true;
        }
        try {
            if (!this.zzaev.zza(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzavd.zzagj++;
            return true;
        } catch (zzgx | zzha e2) {
            throw zzff.zza(e2, getIndex());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfd, com.google.android.gms.internal.ads.zzfi
    public final void zza(int i, Object obj) throws zzff {
        if (i == 2) {
            this.zzaev.setVolume(((Float) obj).floatValue());
        } else if (i != 3) {
            super.zza(i, obj);
        } else {
            this.zzaev.setStreamType(((Integer) obj).intValue());
        }
    }

    public static /* synthetic */ boolean zza(zzhd zzhdVar, boolean z) {
        zzhdVar.zzafa = true;
        return true;
    }
}
