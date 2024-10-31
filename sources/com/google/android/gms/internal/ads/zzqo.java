package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzqo extends zzjy {
    private static final int[] zzbis = {1920, SemanticAnnotations.SemanticType.ST_ANONYMOUS_DATA_VALUE, 1440, 1280, 960, 854, 640, 540, 480};
    private int zzaak;
    private boolean zzadt;
    private final zzqs zzbit;
    private final zzqv zzbiu;
    private final long zzbiv;
    private final int zzbiw;
    private final boolean zzbix;
    private final long[] zzbiy;
    private zzfs[] zzbiz;
    private zzqq zzbja;
    private Surface zzbjb;
    private Surface zzbjc;
    private int zzbjd;
    private boolean zzbje;
    private long zzbjf;
    private long zzbjg;
    private int zzbjh;
    private int zzbji;
    private int zzbjj;
    private float zzbjk;
    private int zzbjl;
    private int zzbjm;
    private int zzbjn;
    private float zzbjo;
    private int zzbjp;
    private int zzbjq;
    private int zzbjr;
    private float zzbjs;
    Vl zzbjt;
    private long zzbju;
    private int zzbjv;
    private final Context zzsp;

    public zzqo(Context context, zzka zzkaVar, long j, Handler handler, zzqu zzquVar, int i) {
        this(context, zzkaVar, 0L, null, false, handler, zzquVar, -1);
    }

    private static boolean zzan(long j) {
        return j < -30000;
    }

    private final void zzho() {
        this.zzbjf = this.zzbiv > 0 ? SystemClock.elapsedRealtime() + this.zzbiv : -9223372036854775807L;
    }

    private final void zzhp() {
        MediaCodec zzel;
        this.zzbje = false;
        if (zzqe.SDK_INT < 23 || !this.zzadt || (zzel = zzel()) == null) {
            return;
        }
        this.zzbjt = new Vl(this, zzel);
    }

    private final void zzhr() {
        this.zzbjp = -1;
        this.zzbjq = -1;
        this.zzbjs = -1.0f;
        this.zzbjr = -1;
    }

    private final void zzhs() {
        if (this.zzbjp == this.zzbjl && this.zzbjq == this.zzbjm && this.zzbjr == this.zzbjn && this.zzbjs == this.zzbjo) {
            return;
        }
        this.zzbiu.zzb(this.zzbjl, this.zzbjm, this.zzbjn, this.zzbjo);
        this.zzbjp = this.zzbjl;
        this.zzbjq = this.zzbjm;
        this.zzbjr = this.zzbjn;
        this.zzbjs = this.zzbjo;
    }

    private final void zzht() {
        if (this.zzbjp == -1 && this.zzbjq == -1) {
            return;
        }
        this.zzbiu.zzb(this.zzbjl, this.zzbjm, this.zzbjn, this.zzbjo);
    }

    private final void zzhu() {
        if (this.zzbjh > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbiu.zzi(this.zzbjh, elapsedRealtime - this.zzbjg);
            this.zzbjh = 0;
            this.zzbjg = elapsedRealtime;
        }
    }

    private static int zzj(zzfs zzfsVar) {
        int i = zzfsVar.zzzk;
        return i != -1 ? i : zza(zzfsVar.zzzj, zzfsVar.width, zzfsVar.height);
    }

    private static int zzk(zzfs zzfsVar) {
        int i = zzfsVar.zzzo;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    private final boolean zzl(boolean z) {
        if (zzqe.SDK_INT < 23 || this.zzadt) {
            return false;
        }
        return !z || zzqk.zzb(this.zzsp);
    }

    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfz
    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.zzbje || (((surface = this.zzbjc) != null && this.zzbjb == surface) || zzel() == null))) {
            this.zzbjf = -9223372036854775807L;
            return true;
        }
        if (this.zzbjf == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.zzbjf) {
            return true;
        }
        this.zzbjf = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.zzbjl = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.zzbjm = integer2;
        this.zzbjo = this.zzbjk;
        if (zzqe.SDK_INT >= 21) {
            int i = this.zzbjj;
            if (i == 90 || i == 270) {
                int i2 = this.zzbjl;
                this.zzbjl = this.zzbjm;
                this.zzbjm = i2;
                this.zzbjo = 1.0f / this.zzbjo;
            }
        } else {
            this.zzbjn = this.zzbjj;
        }
        mediaCodec.setVideoScalingMode(this.zzbjd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void onStarted() {
        super.onStarted();
        this.zzbjh = 0;
        this.zzbjg = SystemClock.elapsedRealtime();
        this.zzbjf = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void onStopped() {
        zzhu();
        super.onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final int zza(zzka zzkaVar, zzfs zzfsVar) throws zzke {
        boolean z;
        int i;
        int i2;
        String str = zzfsVar.zzzj;
        if (!zzpt.zzac(str)) {
            return 0;
        }
        zzhp zzhpVar = zzfsVar.zzzm;
        if (zzhpVar != null) {
            z = false;
            for (int i3 = 0; i3 < zzhpVar.zzagr; i3++) {
                z |= zzhpVar.zzu(i3).zzags;
            }
        } else {
            z = false;
        }
        zzjx zzb = zzkaVar.zzb(str, z);
        if (zzb == null) {
            return 1;
        }
        boolean zzu = zzb.zzu(zzfsVar.zzzg);
        if (zzu && (i = zzfsVar.width) > 0 && (i2 = zzfsVar.height) > 0) {
            if (zzqe.SDK_INT >= 21) {
                zzu = zzb.zza(i, i2, zzfsVar.zzzn);
            } else {
                zzu = i * i2 <= zzkc.zzer();
                if (!zzu) {
                    int i4 = zzfsVar.width;
                    int i5 = zzfsVar.height;
                    String str2 = zzqe.zzbic;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i4);
                    sb.append(FragmentC2201x.f23219a);
                    sb.append(i5);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
            }
        }
        return (zzu ? 3 : 2) | (zzb.zzatq ? 8 : 4) | (zzb.zzadt ? 16 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void zzb(boolean z) throws zzff {
        super.zzb(z);
        this.zzaak = zzbn().zzaak;
        this.zzadt = this.zzaak != 0;
        this.zzbiu.zzc(this.zzavd);
        this.zzbit.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void zzbm() {
        this.zzbjl = -1;
        this.zzbjm = -1;
        this.zzbjo = -1.0f;
        this.zzbjk = -1.0f;
        this.zzbju = -9223372036854775807L;
        this.zzbjv = 0;
        zzhr();
        zzhp();
        this.zzbit.disable();
        this.zzbjt = null;
        this.zzadt = false;
        try {
            super.zzbm();
        } finally {
            this.zzavd.zzds();
            this.zzbiu.zzd(this.zzavd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final void zzc(String str, long j, long j2) {
        this.zzbiu.zzb(str, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zze(zzfs zzfsVar) throws zzff {
        super.zze(zzfsVar);
        this.zzbiu.zzd(zzfsVar);
        float f2 = zzfsVar.zzzp;
        if (f2 == -1.0f) {
            f2 = 1.0f;
        }
        this.zzbjk = f2;
        this.zzbjj = zzk(zzfsVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zzen() {
        try {
            super.zzen();
        } finally {
            Surface surface = this.zzbjc;
            if (surface != null) {
                if (this.zzbjb == surface) {
                    this.zzbjb = null;
                }
                this.zzbjc.release();
                this.zzbjc = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzhq() {
        if (this.zzbje) {
            return;
        }
        this.zzbje = true;
        this.zzbiu.zzb(this.zzbjb);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzqo(Context context, zzka zzkaVar, long j, zzhu<Object> zzhuVar, boolean z, Handler handler, zzqu zzquVar, int i) {
        super(2, zzkaVar, null, false);
        boolean z2 = false;
        this.zzbiv = 0L;
        this.zzbiw = -1;
        this.zzsp = context.getApplicationContext();
        this.zzbit = new zzqs(context);
        this.zzbiu = new zzqv(handler, zzquVar);
        if (zzqe.SDK_INT <= 22 && "foster".equals(zzqe.DEVICE) && "NVIDIA".equals(zzqe.MANUFACTURER)) {
            z2 = true;
        }
        this.zzbix = z2;
        this.zzbiy = new long[10];
        this.zzbju = -9223372036854775807L;
        this.zzbjf = -9223372036854775807L;
        this.zzbjl = -1;
        this.zzbjm = -1;
        this.zzbjo = -1.0f;
        this.zzbjk = -1.0f;
        this.zzbjd = 1;
        zzhr();
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzhs();
        zzqc.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzqc.endSection();
        this.zzavd.zzagj++;
        this.zzbji = 0;
        zzhq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfd
    public final void zza(zzfs[] zzfsVarArr, long j) throws zzff {
        this.zzbiz = zzfsVarArr;
        if (this.zzbju == -9223372036854775807L) {
            this.zzbju = j;
        } else {
            int i = this.zzbjv;
            long[] jArr = this.zzbiy;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.zzbjv = i + 1;
            }
            this.zzbiy[this.zzbjv - 1] = j;
        }
        super.zza(zzfsVarArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void zza(long j, boolean z) throws zzff {
        super.zza(j, z);
        zzhp();
        this.zzbji = 0;
        int i = this.zzbjv;
        if (i != 0) {
            this.zzbju = this.zzbiy[i - 1];
            this.zzbjv = 0;
        }
        if (z) {
            zzho();
        } else {
            this.zzbjf = -9223372036854775807L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfd, com.google.android.gms.internal.ads.zzfi
    public final void zza(int i, Object obj) throws zzff {
        if (i != 1) {
            if (i == 4) {
                this.zzbjd = ((Integer) obj).intValue();
                MediaCodec zzel = zzel();
                if (zzel != null) {
                    zzel.setVideoScalingMode(this.zzbjd);
                    return;
                }
                return;
            }
            super.zza(i, obj);
            return;
        }
        Surface surface = (Surface) obj;
        if (surface == null) {
            Surface surface2 = this.zzbjc;
            if (surface2 != null) {
                surface = surface2;
            } else {
                zzjx zzem = zzem();
                if (zzem != null && zzl(zzem.zzatr)) {
                    this.zzbjc = zzqk.zzc(this.zzsp, zzem.zzatr);
                    surface = this.zzbjc;
                }
            }
        }
        if (this.zzbjb != surface) {
            this.zzbjb = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec zzel2 = zzel();
                if (zzqe.SDK_INT >= 23 && zzel2 != null && surface != null) {
                    zzel2.setOutputSurface(surface);
                } else {
                    zzen();
                    zzek();
                }
            }
            if (surface != null && surface != this.zzbjc) {
                zzht();
                zzhp();
                if (state == 2) {
                    zzho();
                    return;
                }
                return;
            }
            zzhr();
            zzhp();
            return;
        }
        if (surface == null || surface == this.zzbjc) {
            return;
        }
        zzht();
        if (this.zzbje) {
            this.zzbiu.zzb(this.zzbjb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final boolean zza(zzjx zzjxVar) {
        return this.zzbjb != null || zzl(zzjxVar.zzatr);
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final void zza(zzjx zzjxVar, MediaCodec mediaCodec, zzfs zzfsVar, MediaCrypto mediaCrypto) throws zzke {
        zzqq zzqqVar;
        int i;
        Point point;
        float f2;
        zzfs[] zzfsVarArr = this.zzbiz;
        int i2 = zzfsVar.width;
        int i3 = zzfsVar.height;
        int zzj = zzj(zzfsVar);
        if (zzfsVarArr.length == 1) {
            zzqqVar = new zzqq(i2, i3, zzj);
        } else {
            int i4 = i3;
            int i5 = zzj;
            boolean z = false;
            int i6 = i2;
            for (zzfs zzfsVar2 : zzfsVarArr) {
                if (zza(zzjxVar.zzatq, zzfsVar, zzfsVar2)) {
                    z |= zzfsVar2.width == -1 || zzfsVar2.height == -1;
                    i6 = Math.max(i6, zzfsVar2.width);
                    int max = Math.max(i4, zzfsVar2.height);
                    i5 = Math.max(i5, zzj(zzfsVar2));
                    i4 = max;
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i6);
                sb.append(FragmentC2201x.f23219a);
                sb.append(i4);
                Log.w("MediaCodecVideoRenderer", sb.toString());
                boolean z2 = zzfsVar.height > zzfsVar.width;
                int i7 = z2 ? zzfsVar.height : zzfsVar.width;
                int i8 = z2 ? zzfsVar.width : zzfsVar.height;
                float f3 = i8 / i7;
                int[] iArr = zzbis;
                int length = iArr.length;
                int i9 = 0;
                while (i9 < length) {
                    int i10 = length;
                    int i11 = iArr[i9];
                    int[] iArr2 = iArr;
                    int i12 = (int) (i11 * f3);
                    if (i11 <= i7 || i12 <= i8) {
                        break;
                    }
                    int i13 = i7;
                    int i14 = i8;
                    if (zzqe.SDK_INT >= 21) {
                        int i15 = z2 ? i12 : i11;
                        if (z2) {
                            i12 = i11;
                        }
                        Point zzc = zzjxVar.zzc(i15, i12);
                        i = i5;
                        f2 = f3;
                        if (zzjxVar.zza(zzc.x, zzc.y, zzfsVar.zzzn)) {
                            point = zzc;
                            break;
                        }
                        i9++;
                        length = i10;
                        iArr = iArr2;
                        i7 = i13;
                        i8 = i14;
                        i5 = i;
                        f3 = f2;
                    } else {
                        i = i5;
                        f2 = f3;
                        int zzf = zzqe.zzf(i11, 16) << 4;
                        int zzf2 = zzqe.zzf(i12, 16) << 4;
                        if (zzf * zzf2 <= zzkc.zzer()) {
                            int i16 = z2 ? zzf2 : zzf;
                            if (z2) {
                                zzf2 = zzf;
                            }
                            point = new Point(i16, zzf2);
                        } else {
                            i9++;
                            length = i10;
                            iArr = iArr2;
                            i7 = i13;
                            i8 = i14;
                            i5 = i;
                            f3 = f2;
                        }
                    }
                }
                i = i5;
                point = null;
                if (point != null) {
                    i6 = Math.max(i6, point.x);
                    i4 = Math.max(i4, point.y);
                    i5 = Math.max(i, zza(zzfsVar.zzzj, i6, i4));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i6);
                    sb2.append(FragmentC2201x.f23219a);
                    sb2.append(i4);
                    Log.w("MediaCodecVideoRenderer", sb2.toString());
                } else {
                    i5 = i;
                }
            }
            zzqqVar = new zzqq(i6, i4, i5);
        }
        this.zzbja = zzqqVar;
        zzqq zzqqVar2 = this.zzbja;
        boolean z3 = this.zzbix;
        int i17 = this.zzaak;
        MediaFormat zzcf = zzfsVar.zzcf();
        zzcf.setInteger("max-width", zzqqVar2.width);
        zzcf.setInteger("max-height", zzqqVar2.height);
        int i18 = zzqqVar2.zzbjw;
        if (i18 != -1) {
            zzcf.setInteger("max-input-size", i18);
        }
        if (z3) {
            zzcf.setInteger("auto-frc", 0);
        }
        if (i17 != 0) {
            zzcf.setFeatureEnabled("tunneled-playback", true);
            zzcf.setInteger("audio-session-id", i17);
        }
        if (this.zzbjb == null) {
            zzpo.checkState(zzl(zzjxVar.zzatr));
            if (this.zzbjc == null) {
                this.zzbjc = zzqk.zzc(this.zzsp, zzjxVar.zzatr);
            }
            this.zzbjb = this.zzbjc;
        }
        mediaCodec.configure(zzcf, this.zzbjb, (MediaCrypto) null, 0);
        if (zzqe.SDK_INT < 23 || !this.zzadt) {
            return;
        }
        this.zzbjt = new Vl(this, mediaCodec);
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final void zza(zzho zzhoVar) {
        if (zzqe.SDK_INT >= 23 || !this.zzadt) {
            return;
        }
        zzhq();
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final boolean zza(MediaCodec mediaCodec, boolean z, zzfs zzfsVar, zzfs zzfsVar2) {
        if (!zza(z, zzfsVar, zzfsVar2)) {
            return false;
        }
        int i = zzfsVar2.width;
        zzqq zzqqVar = this.zzbja;
        return i <= zzqqVar.width && zzfsVar2.height <= zzqqVar.height && zzfsVar2.zzzk <= zzqqVar.zzbjw;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    protected final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (true) {
            int i3 = this.zzbjv;
            if (i3 == 0) {
                break;
            }
            long[] jArr = this.zzbiy;
            if (j3 < jArr[0]) {
                break;
            }
            this.zzbju = jArr[0];
            this.zzbjv = i3 - 1;
            System.arraycopy(jArr, 1, jArr, 0, this.zzbjv);
        }
        long j4 = j3 - this.zzbju;
        if (z) {
            zza(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.zzbjb == this.zzbjc) {
            if (!zzan(j5)) {
                return false;
            }
            zza(mediaCodec, i, j4);
            return true;
        }
        if (!this.zzbje) {
            if (zzqe.SDK_INT >= 21) {
                zza(mediaCodec, i, j4, System.nanoTime());
            } else {
                zzb(mediaCodec, i, j4);
            }
            return true;
        }
        if (getState() != 2) {
            return false;
        }
        long elapsedRealtime = j5 - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long nanoTime = System.nanoTime();
        long zzh = this.zzbit.zzh(j3, (elapsedRealtime * 1000) + nanoTime);
        long j6 = (zzh - nanoTime) / 1000;
        if (zzan(j6)) {
            zzqc.beginSection("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            zzqc.endSection();
            zzhn zzhnVar = this.zzavd;
            zzhnVar.zzagl++;
            this.zzbjh++;
            this.zzbji++;
            zzhnVar.zzagm = Math.max(this.zzbji, zzhnVar.zzagm);
            if (this.zzbjh == this.zzbiw) {
                zzhu();
            }
            return true;
        }
        if (zzqe.SDK_INT >= 21) {
            if (j6 < 50000) {
                zza(mediaCodec, i, j4, zzh);
                return true;
            }
        } else if (j6 < com.umeng.commonsdk.proguard.c.f26227d) {
            if (j6 > 11000) {
                try {
                    Thread.sleep((j6 - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            zzb(mediaCodec, i, j4);
            return true;
        }
        return false;
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzqc.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzqc.endSection();
        this.zzavd.zzagk++;
    }

    @TargetApi(21)
    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzhs();
        zzqc.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzqc.endSection();
        this.zzavd.zzagj++;
        this.zzbji = 0;
        zzhq();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int zza(String str, int i, int i2) {
        char c2;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0 && c2 != 1) {
            if (c2 == 2) {
                if ("BRAVIA 4K 2015".equals(zzqe.MODEL)) {
                    return -1;
                }
                i3 = ((zzqe.zzf(i, 16) * zzqe.zzf(i2, 16)) << 4) << 4;
                i4 = 2;
                return (i3 * 3) / (i4 * 2);
            }
            if (c2 != 3) {
                if (c2 != 4 && c2 != 5) {
                    return -1;
                }
                i3 = i * i2;
                return (i3 * 3) / (i4 * 2);
            }
        }
        i3 = i * i2;
        i4 = 2;
        return (i3 * 3) / (i4 * 2);
    }

    private static boolean zza(boolean z, zzfs zzfsVar, zzfs zzfsVar2) {
        if (!zzfsVar.zzzj.equals(zzfsVar2.zzzj) || zzk(zzfsVar) != zzk(zzfsVar2)) {
            return false;
        }
        if (z) {
            return true;
        }
        return zzfsVar.width == zzfsVar2.width && zzfsVar.height == zzfsVar2.height;
    }
}
