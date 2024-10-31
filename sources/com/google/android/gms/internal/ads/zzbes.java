package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.nio.ByteBuffer;

@zzark
/* loaded from: classes2.dex */
public final class zzbes implements zzfh, zzll, zzpn<zzov>, zzqu {

    @VisibleForTesting
    private static int zzevp;

    @VisibleForTesting
    private static int zzevq;
    private int bytesTransferred;
    private final zzbdy zzeuo;
    private final zzfz zzevs;
    private zzfg zzevv;
    private ByteBuffer zzevw;
    private boolean zzevx;
    private zzbez zzevy;
    private final Context zzsp;
    private final zzber zzevr = new zzber();
    private final zzfz zzevt = new zzhd(zzka.zzavh);
    private final zzoj zzevu = new zzog();

    public zzbes(Context context, zzbdy zzbdyVar) {
        this.zzsp = context;
        this.zzeuo = zzbdyVar;
        this.zzevs = new zzqo(this.zzsp, zzka.zzavh, 0L, zzayh.zzelc, this, -1);
        if (zzaxz.zzza()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzaxz.v(sb.toString());
        }
        zzevp++;
        this.zzevv = zzfk.zza(new zzfz[]{this.zzevt, this.zzevs}, this.zzevu, this.zzevr);
        this.zzevv.zza(this);
    }

    public static int zzacx() {
        return zzevp;
    }

    public static int zzacy() {
        return zzevq;
    }

    @VisibleForTesting
    private final zzow zzev(final String str) {
        if (this.zzevx && this.zzevw.limit() > 0) {
            final byte[] bArr = new byte[this.zzevw.limit()];
            this.zzevw.get(bArr);
            return new zzow(bArr) { // from class: com.google.android.gms.internal.ads.ff

                /* renamed from: a, reason: collision with root package name */
                private final byte[] f12161a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12161a = bArr;
                }

                @Override // com.google.android.gms.internal.ads.zzow
                public final zzov zzgs() {
                    return new zzou(this.f12161a);
                }
            };
        }
        final zzow zzowVar = new zzow(this, str) { // from class: com.google.android.gms.internal.ads.gf

            /* renamed from: a, reason: collision with root package name */
            private final zzbes f12177a;

            /* renamed from: b, reason: collision with root package name */
            private final String f12178b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12177a = this;
                this.f12178b = str;
            }

            @Override // com.google.android.gms.internal.ads.zzow
            public final zzov zzgs() {
                return this.f12177a.zzew(this.f12178b);
            }
        };
        final zzow zzowVar2 = this.zzeuo.zzets ? new zzow(this, zzowVar) { // from class: com.google.android.gms.internal.ads.hf

            /* renamed from: a, reason: collision with root package name */
            private final zzbes f12192a;

            /* renamed from: b, reason: collision with root package name */
            private final zzow f12193b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12192a = this;
                this.f12193b = zzowVar;
            }

            @Override // com.google.android.gms.internal.ads.zzow
            public final zzov zzgs() {
                return this.f12192a.zza(this.f12193b);
            }
        } : zzowVar;
        if (this.zzevw.limit() <= 0) {
            return zzowVar2;
        }
        final byte[] bArr2 = new byte[this.zzevw.limit()];
        this.zzevw.get(bArr2);
        return new zzow(zzowVar2, bArr2) { // from class: com.google.android.gms.internal.ads.if

            /* renamed from: a, reason: collision with root package name */
            private final zzow f12212a;

            /* renamed from: b, reason: collision with root package name */
            private final byte[] f12213b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12212a = zzowVar2;
                this.f12213b = bArr2;
            }

            @Override // com.google.android.gms.internal.ads.zzow
            public final zzov zzgs() {
                zzow zzowVar3 = this.f12212a;
                byte[] bArr3 = this.f12213b;
                return new C0984lf(new zzou(bArr3), bArr3.length, zzowVar3.zzgs());
            }
        };
    }

    public final void finalize() throws Throwable {
        zzevp--;
        if (zzaxz.zzza()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzaxz.v(sb.toString());
        }
    }

    public final long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public final void release() {
        zzfg zzfgVar = this.zzevv;
        if (zzfgVar != null) {
            zzfgVar.zzb(this);
            this.zzevv.release();
            this.zzevv = null;
            zzevq--;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(Surface surface) {
    }

    public final void zza(zzbez zzbezVar) {
        this.zzevy = zzbezVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zza(zzfy zzfyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zza(zzgc zzgcVar, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zza(zzma zzmaVar, zzoo zzooVar) {
    }

    public final zzfg zzacw() {
        return this.zzevv;
    }

    public final zzber zzacz() {
        return this.zzevr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzau(boolean z) {
        for (int i = 0; i < this.zzevv.zzbq(); i++) {
            this.zzevu.zzf(i, !z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final void zzb(IOException iOException) {
        zzbez zzbezVar = this.zzevy;
        if (zzbezVar != null) {
            zzbezVar.zza("onLoadError", iOException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zzbs() {
    }

    @Override // com.google.android.gms.internal.ads.zzpn
    public final /* synthetic */ void zzc(zzov zzovVar, int i) {
        this.bytesTransferred += i;
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zzd(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zzd(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(boolean z, long j) {
        zzbez zzbezVar = this.zzevy;
        if (zzbezVar != null) {
            zzbezVar.zzb(z, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zze(zzhn zzhnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzpn
    public final /* bridge */ /* synthetic */ void zze(zzov zzovVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzov zzew(String str) {
        zzbes zzbesVar = this.zzeuo.zzets ? null : this;
        zzbdy zzbdyVar = this.zzeuo;
        return new zzpb(str, null, zzbesVar, zzbdyVar.zzetn, zzbdyVar.zzetp, true, null);
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zzf(zzhn zzhnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zzh(int i, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zzl(zzfs zzfsVar) {
    }

    public final void zza(Uri uri, String str) {
        zza(uri, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri uri, String str, ByteBuffer byteBuffer, boolean z) {
        zzlo zzlkVar;
        this.zzevw = byteBuffer;
        this.zzevx = z;
        if (this.zzeuo.zzett) {
            zzow zzev = zzev(str);
            zzlkVar = new zzmu(uri, zzev, new zzng(zzev), zzayh.zzelc, null);
        } else {
            zzlkVar = new zzlk(uri, zzev(str), C0956jf.f12226a, -1, zzayh.zzelc, this, null, this.zzeuo.zzetq);
        }
        this.zzevv.zza(zzlkVar);
        zzevq++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(float f2, boolean z) {
        zzfj zzfjVar = new zzfj(this.zzevt, 2, Float.valueOf(f2));
        if (z) {
            this.zzevv.zzb(zzfjVar);
        } else {
            this.zzevv.zza(zzfjVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(int i, int i2, int i3, float f2) {
        zzbez zzbezVar = this.zzevy;
        if (zzbezVar != null) {
            zzbezVar.zzp(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zza(boolean z, int i) {
        zzbez zzbezVar = this.zzevy;
        if (zzbezVar != null) {
            zzbezVar.zzdd(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zza(zzff zzffVar) {
        zzbez zzbezVar = this.zzevy;
        if (zzbezVar != null) {
            zzbezVar.zza("onPlayerError", zzffVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Surface surface, boolean z) {
        zzfj zzfjVar = new zzfj(this.zzevs, 1, surface);
        if (z) {
            this.zzevv.zzb(zzfjVar);
        } else {
            this.zzevv.zza(zzfjVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpn
    public final /* synthetic */ void zza(zzov zzovVar, zzoz zzozVar) {
        this.bytesTransferred = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzov zza(zzow zzowVar) {
        return new zzbep(this.zzsp, zzowVar.zzgs(), this, new zzbeq(this) { // from class: com.google.android.gms.internal.ads.kf

            /* renamed from: a, reason: collision with root package name */
            private final zzbes f12260a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12260a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbeq
            public final void zzb(boolean z, long j) {
                this.f12260a.zzd(z, j);
            }
        });
    }
}
