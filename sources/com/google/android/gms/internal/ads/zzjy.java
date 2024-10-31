package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* loaded from: classes2.dex */
public abstract class zzjy extends zzfd {
    private static final byte[] zzatt = zzqe.zzan("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private zzfs zzaad;
    private ByteBuffer[] zzadk;
    private final zzka zzatu;
    private final zzhu<Object> zzatv;
    private final boolean zzatw;
    private final zzho zzatx;
    private final zzho zzaty;
    private final zzfu zzatz;
    private final List<Long> zzaua;
    private final MediaCodec.BufferInfo zzaub;
    private zzhs<Object> zzauc;
    private zzhs<Object> zzaud;
    private MediaCodec zzaue;
    private zzjx zzauf;
    private boolean zzaug;
    private boolean zzauh;
    private boolean zzaui;
    private boolean zzauj;
    private boolean zzauk;
    private boolean zzaul;
    private boolean zzaum;
    private boolean zzaun;
    private boolean zzauo;
    private ByteBuffer[] zzaup;
    private long zzauq;
    private int zzaur;
    private int zzaus;
    private boolean zzaut;
    private boolean zzauu;
    private int zzauv;
    private int zzauw;
    private boolean zzaux;
    private boolean zzauy;
    private boolean zzauz;
    private boolean zzava;
    private boolean zzavb;
    private boolean zzavc;
    protected zzhn zzavd;

    public zzjy(int i, zzka zzkaVar, zzhu<Object> zzhuVar, boolean z) {
        super(i);
        zzpo.checkState(zzqe.SDK_INT >= 16);
        zzpo.checkNotNull(zzkaVar);
        this.zzatu = zzkaVar;
        this.zzatv = zzhuVar;
        this.zzatw = z;
        this.zzatx = new zzho(0);
        this.zzaty = new zzho(0);
        this.zzatz = new zzfu();
        this.zzaua = new ArrayList();
        this.zzaub = new MediaCodec.BufferInfo();
        this.zzauv = 0;
        this.zzauw = 0;
    }

    private final boolean zzd(long j, long j2) throws zzff {
        boolean zza;
        boolean z;
        if (this.zzaus < 0) {
            if (this.zzaul && this.zzauy) {
                try {
                    this.zzaus = this.zzaue.dequeueOutputBuffer(this.zzaub, 0L);
                } catch (IllegalStateException unused) {
                    zzep();
                    if (this.zzava) {
                        zzen();
                    }
                    return false;
                }
            } else {
                this.zzaus = this.zzaue.dequeueOutputBuffer(this.zzaub, 0L);
            }
            int i = this.zzaus;
            if (i < 0) {
                if (i != -2) {
                    if (i == -3) {
                        this.zzadk = this.zzaue.getOutputBuffers();
                        return true;
                    }
                    if (this.zzauj && (this.zzauz || this.zzauw == 2)) {
                        zzep();
                    }
                    return false;
                }
                MediaFormat outputFormat = this.zzaue.getOutputFormat();
                if (this.zzaui && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.zzauo = true;
                } else {
                    if (this.zzaum) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.zzaue, outputFormat);
                }
                return true;
            }
            if (this.zzauo) {
                this.zzauo = false;
                this.zzaue.releaseOutputBuffer(i, false);
                this.zzaus = -1;
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.zzaub;
            if ((bufferInfo.flags & 4) != 0) {
                zzep();
                this.zzaus = -1;
                return false;
            }
            ByteBuffer byteBuffer = this.zzadk[i];
            if (byteBuffer != null) {
                byteBuffer.position(bufferInfo.offset);
                MediaCodec.BufferInfo bufferInfo2 = this.zzaub;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            long j3 = this.zzaub.presentationTimeUs;
            int size = this.zzaua.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    break;
                }
                if (this.zzaua.get(i2).longValue() == j3) {
                    this.zzaua.remove(i2);
                    z = true;
                    break;
                }
                i2++;
            }
            this.zzaut = z;
        }
        if (this.zzaul && this.zzauy) {
            try {
                zza = zza(j, j2, this.zzaue, this.zzadk[this.zzaus], this.zzaus, this.zzaub.flags, this.zzaub.presentationTimeUs, this.zzaut);
            } catch (IllegalStateException unused2) {
                zzep();
                if (this.zzava) {
                    zzen();
                }
                return false;
            }
        } else {
            MediaCodec mediaCodec = this.zzaue;
            ByteBuffer[] byteBufferArr = this.zzadk;
            int i3 = this.zzaus;
            ByteBuffer byteBuffer2 = byteBufferArr[i3];
            MediaCodec.BufferInfo bufferInfo3 = this.zzaub;
            zza = zza(j, j2, mediaCodec, byteBuffer2, i3, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.zzaut);
        }
        if (!zza) {
            return false;
        }
        long j4 = this.zzaub.presentationTimeUs;
        this.zzaus = -1;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x014b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzeo() throws com.google.android.gms.internal.ads.zzff {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjy.zzeo():boolean");
    }

    private final void zzep() throws zzff {
        if (this.zzauw == 2) {
            zzen();
            zzek();
        } else {
            this.zzava = true;
            zzdj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public boolean isReady() {
        if (this.zzaad == null || this.zzavb) {
            return false;
        }
        if (zzbo() || this.zzaus >= 0) {
            return true;
        }
        return this.zzauq != -9223372036854775807L && SystemClock.elapsedRealtime() < this.zzauq;
    }

    protected void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzff {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfd
    public void onStarted() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfd
    public void onStopped() {
    }

    protected abstract int zza(zzka zzkaVar, zzfs zzfsVar) throws zzke;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzjx zza(zzka zzkaVar, zzfs zzfsVar, boolean z) throws zzke {
        return zzkaVar.zzb(zzfsVar.zzzj, z);
    }

    protected void zza(zzho zzhoVar) {
    }

    protected abstract void zza(zzjx zzjxVar, MediaCodec mediaCodec, zzfs zzfsVar, MediaCrypto mediaCrypto) throws zzke;

    protected abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzff;

    protected boolean zza(MediaCodec mediaCodec, boolean z, zzfs zzfsVar, zzfs zzfsVar2) {
        return false;
    }

    protected boolean zza(zzjx zzjxVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzga
    public final int zzb(zzfs zzfsVar) throws zzff {
        try {
            return zza(this.zzatu, zzfsVar);
        } catch (zzke e2) {
            throw zzff.zza(e2, getIndex());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfd, com.google.android.gms.internal.ads.zzga
    public final int zzbl() {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfd
    public void zzbm() {
        this.zzaad = null;
        try {
            zzen();
            try {
                if (this.zzauc != null) {
                    this.zzatv.zza(this.zzauc);
                }
                try {
                    if (this.zzaud != null && this.zzaud != this.zzauc) {
                        this.zzatv.zza(this.zzaud);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.zzaud != null && this.zzaud != this.zzauc) {
                        this.zzatv.zza(this.zzaud);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.zzauc != null) {
                    this.zzatv.zza(this.zzauc);
                }
                try {
                    if (this.zzaud != null && this.zzaud != this.zzauc) {
                        this.zzatv.zza(this.zzaud);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.zzaud != null && this.zzaud != this.zzauc) {
                        this.zzatv.zza(this.zzaud);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    protected void zzc(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public boolean zzcj() {
        return this.zzava;
    }

    protected void zzdj() throws zzff {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:            if (r5.height == r0.height) goto L32;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void zze(com.google.android.gms.internal.ads.zzfs r5) throws com.google.android.gms.internal.ads.zzff {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzfs r0 = r4.zzaad
            r4.zzaad = r5
            com.google.android.gms.internal.ads.zzfs r5 = r4.zzaad
            com.google.android.gms.internal.ads.zzhp r5 = r5.zzzm
            r1 = 0
            if (r0 != 0) goto Ld
            r2 = r1
            goto Lf
        Ld:
            com.google.android.gms.internal.ads.zzhp r2 = r0.zzzm
        Lf:
            boolean r5 = com.google.android.gms.internal.ads.zzqe.zza(r5, r2)
            r2 = 1
            r5 = r5 ^ r2
            if (r5 == 0) goto L4d
            com.google.android.gms.internal.ads.zzfs r5 = r4.zzaad
            com.google.android.gms.internal.ads.zzhp r5 = r5.zzzm
            if (r5 == 0) goto L4b
            com.google.android.gms.internal.ads.zzhu<java.lang.Object> r5 = r4.zzatv
            if (r5 == 0) goto L3b
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.google.android.gms.internal.ads.zzfs r3 = r4.zzaad
            com.google.android.gms.internal.ads.zzhp r3 = r3.zzzm
            com.google.android.gms.internal.ads.zzhs r5 = r5.zza(r1, r3)
            r4.zzaud = r5
            com.google.android.gms.internal.ads.zzhs<java.lang.Object> r5 = r4.zzaud
            com.google.android.gms.internal.ads.zzhs<java.lang.Object> r1 = r4.zzauc
            if (r5 != r1) goto L4d
            com.google.android.gms.internal.ads.zzhu<java.lang.Object> r1 = r4.zzatv
            r1.zza(r5)
            goto L4d
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            int r0 = r4.getIndex()
            com.google.android.gms.internal.ads.zzff r5 = com.google.android.gms.internal.ads.zzff.zza(r5, r0)
            throw r5
        L4b:
            r4.zzaud = r1
        L4d:
            com.google.android.gms.internal.ads.zzhs<java.lang.Object> r5 = r4.zzaud
            com.google.android.gms.internal.ads.zzhs<java.lang.Object> r1 = r4.zzauc
            if (r5 != r1) goto L7e
            android.media.MediaCodec r5 = r4.zzaue
            if (r5 == 0) goto L7e
            com.google.android.gms.internal.ads.zzjx r1 = r4.zzauf
            boolean r1 = r1.zzatq
            com.google.android.gms.internal.ads.zzfs r3 = r4.zzaad
            boolean r5 = r4.zza(r5, r1, r0, r3)
            if (r5 == 0) goto L7e
            r4.zzauu = r2
            r4.zzauv = r2
            boolean r5 = r4.zzaui
            if (r5 == 0) goto L7a
            com.google.android.gms.internal.ads.zzfs r5 = r4.zzaad
            int r1 = r5.width
            int r3 = r0.width
            if (r1 != r3) goto L7a
            int r5 = r5.height
            int r0 = r0.height
            if (r5 != r0) goto L7a
            goto L7b
        L7a:
            r2 = 0
        L7b:
            r4.zzaun = r2
            return
        L7e:
            boolean r5 = r4.zzaux
            if (r5 == 0) goto L85
            r4.zzauw = r2
            return
        L85:
            r4.zzen()
            r4.zzek()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjy.zze(com.google.android.gms.internal.ads.zzfs):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzek() throws zzff {
        zzfs zzfsVar;
        if (this.zzaue != null || (zzfsVar = this.zzaad) == null) {
            return;
        }
        this.zzauc = this.zzaud;
        String str = zzfsVar.zzzj;
        zzhs<Object> zzhsVar = this.zzauc;
        if (zzhsVar != null) {
            int state = zzhsVar.getState();
            if (state == 0) {
                throw zzff.zza(this.zzauc.zzdv(), getIndex());
            }
            if (state == 3 || state == 4) {
                this.zzauc.zzdu();
                throw new NoSuchMethodError();
            }
            return;
        }
        if (this.zzauf == null) {
            try {
                this.zzauf = zza(this.zzatu, zzfsVar, false);
                if (this.zzauf == null) {
                    zza(new zzjz(this.zzaad, (Throwable) null, false, -49999));
                    throw null;
                }
            } catch (zzke e2) {
                zza(new zzjz(this.zzaad, (Throwable) e2, false, -49998));
                throw null;
            }
        }
        if (zza(this.zzauf)) {
            String str2 = this.zzauf.name;
            this.zzaug = zzqe.SDK_INT < 21 && this.zzaad.zzzl.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
            int i = zzqe.SDK_INT;
            this.zzauh = i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzqe.SDK_INT == 19 && zzqe.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
            this.zzaui = zzqe.SDK_INT < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzqe.DEVICE) || "flounder_lte".equals(zzqe.DEVICE) || "grouper".equals(zzqe.DEVICE) || "tilapia".equals(zzqe.DEVICE));
            this.zzauj = zzqe.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
            this.zzauk = (zzqe.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (zzqe.SDK_INT <= 19 && "hb2000".equals(zzqe.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
            this.zzaul = zzqe.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2);
            this.zzaum = zzqe.SDK_INT <= 18 && this.zzaad.zzzt == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String valueOf = String.valueOf(str2);
                zzqc.beginSection(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                this.zzaue = MediaCodec.createByCodecName(str2);
                zzqc.endSection();
                zzqc.beginSection("configureCodec");
                zza(this.zzauf, this.zzaue, this.zzaad, (MediaCrypto) null);
                zzqc.endSection();
                zzqc.beginSection("startCodec");
                this.zzaue.start();
                zzqc.endSection();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                zzc(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.zzaup = this.zzaue.getInputBuffers();
                this.zzadk = this.zzaue.getOutputBuffers();
                this.zzauq = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.zzaur = -1;
                this.zzaus = -1;
                this.zzavc = true;
                this.zzavd.zzagg++;
            } catch (Exception e3) {
                zza(new zzjz(this.zzaad, (Throwable) e3, false, str2));
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodec zzel() {
        return this.zzaue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzjx zzem() {
        return this.zzauf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzen() {
        this.zzauq = -9223372036854775807L;
        this.zzaur = -1;
        this.zzaus = -1;
        this.zzavb = false;
        this.zzaut = false;
        this.zzaua.clear();
        this.zzaup = null;
        this.zzadk = null;
        this.zzauf = null;
        this.zzauu = false;
        this.zzaux = false;
        this.zzaug = false;
        this.zzauh = false;
        this.zzaui = false;
        this.zzauj = false;
        this.zzauk = false;
        this.zzaum = false;
        this.zzaun = false;
        this.zzauo = false;
        this.zzauy = false;
        this.zzauv = 0;
        this.zzauw = 0;
        this.zzatx.zzdd = null;
        MediaCodec mediaCodec = this.zzaue;
        if (mediaCodec != null) {
            this.zzavd.zzagh++;
            try {
                mediaCodec.stop();
                try {
                    this.zzaue.release();
                    this.zzaue = null;
                    zzhs<Object> zzhsVar = this.zzauc;
                    if (zzhsVar == null || this.zzaud == zzhsVar) {
                        return;
                    }
                    try {
                        this.zzatv.zza(zzhsVar);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.zzaue = null;
                    zzhs<Object> zzhsVar2 = this.zzauc;
                    if (zzhsVar2 != null && this.zzaud != zzhsVar2) {
                        try {
                            this.zzatv.zza(zzhsVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.zzaue.release();
                    this.zzaue = null;
                    zzhs<Object> zzhsVar3 = this.zzauc;
                    if (zzhsVar3 != null && this.zzaud != zzhsVar3) {
                        try {
                            this.zzatv.zza(zzhsVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.zzaue = null;
                    zzhs<Object> zzhsVar4 = this.zzauc;
                    if (zzhsVar4 != null && this.zzaud != zzhsVar4) {
                        try {
                            this.zzatv.zza(zzhsVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    private final void zza(zzjz zzjzVar) throws zzff {
        throw zzff.zza(zzjzVar, getIndex());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfd
    public void zza(long j, boolean z) throws zzff {
        this.zzauz = false;
        this.zzava = false;
        if (this.zzaue != null) {
            this.zzauq = -9223372036854775807L;
            this.zzaur = -1;
            this.zzaus = -1;
            this.zzavc = true;
            this.zzavb = false;
            this.zzaut = false;
            this.zzaua.clear();
            this.zzaun = false;
            this.zzauo = false;
            if (!this.zzauh && (!this.zzauk || !this.zzauy)) {
                if (this.zzauw != 0) {
                    zzen();
                    zzek();
                } else {
                    this.zzaue.flush();
                    this.zzaux = false;
                }
            } else {
                zzen();
                zzek();
            }
            if (!this.zzauu || this.zzaad == null) {
                return;
            }
            this.zzauv = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfd
    public void zzb(boolean z) throws zzff {
        this.zzavd = new zzhn();
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void zzb(long j, long j2) throws zzff {
        if (this.zzava) {
            zzdj();
            return;
        }
        if (this.zzaad == null) {
            this.zzaty.clear();
            int zza = zza(this.zzatz, this.zzaty, true);
            if (zza != -5) {
                if (zza == -4) {
                    zzpo.checkState(this.zzaty.zzdp());
                    this.zzauz = true;
                    zzep();
                    return;
                }
                return;
            }
            zze(this.zzatz.zzaad);
        }
        zzek();
        if (this.zzaue != null) {
            zzqc.beginSection("drainAndFeed");
            do {
            } while (zzd(j, j2));
            do {
            } while (zzeo());
            zzqc.endSection();
        } else {
            zze(j);
            this.zzaty.clear();
            int zza2 = zza(this.zzatz, this.zzaty, false);
            if (zza2 == -5) {
                zze(this.zzatz.zzaad);
            } else if (zza2 == -4) {
                zzpo.checkState(this.zzaty.zzdp());
                this.zzauz = true;
                zzep();
            }
        }
        this.zzavd.zzds();
    }
}
