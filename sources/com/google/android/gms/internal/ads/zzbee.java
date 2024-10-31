package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import java.nio.ByteBuffer;

@zzark
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzbee extends zzbdi implements TextureView.SurfaceTextureListener, zzbez {
    private Surface zzbjb;
    private final zzbdz zzerw;
    private final zzbea zzeum;
    private final boolean zzeun;
    private final zzbdy zzeuo;
    private zzbdh zzeup;
    private zzbes zzeuq;
    private String zzeur;
    private boolean zzeus;
    private int zzeut;
    private zzbdx zzeuu;
    private final boolean zzeuv;
    private boolean zzeuw;
    private boolean zzeux;
    private int zzeuy;
    private int zzeuz;
    private int zzeva;
    private int zzevb;
    private float zzevc;

    public zzbee(Context context, zzbea zzbeaVar, zzbdz zzbdzVar, boolean z, boolean z2, zzbdy zzbdyVar) {
        super(context);
        this.zzeut = 1;
        this.zzeun = z2;
        this.zzerw = zzbdzVar;
        this.zzeum = zzbeaVar;
        this.zzeuv = z;
        this.zzeuo = zzbdyVar;
        setSurfaceTextureListener(this);
        this.zzeum.zzb(this);
    }

    private final void zza(Surface surface, boolean z) {
        zzbes zzbesVar = this.zzeuq;
        if (zzbesVar != null) {
            zzbesVar.zza(surface, z);
        } else {
            zzbbd.zzeo("Trying to set surface before player is initalized.");
        }
    }

    private final zzbes zzach() {
        return new zzbes(this.zzerw.getContext(), this.zzeuo);
    }

    private final String zzaci() {
        return com.google.android.gms.ads.internal.zzbv.e().zzo(this.zzerw.getContext(), this.zzerw.zzabz().zzdp);
    }

    private final boolean zzacj() {
        return (this.zzeuq == null || this.zzeus) ? false : true;
    }

    private final boolean zzack() {
        return zzacj() && this.zzeut != 1;
    }

    private final void zzacl() {
        String str;
        if (this.zzeuq != null || (str = this.zzeur) == null || this.zzbjb == null) {
            return;
        }
        if (str.startsWith("cache:")) {
            zzbfk zzet = this.zzerw.zzet(this.zzeur);
            if (zzet instanceof zzbfw) {
                this.zzeuq = ((zzbfw) zzet).zzadd();
            } else if (zzet instanceof zzbfv) {
                zzbfv zzbfvVar = (zzbfv) zzet;
                String zzaci = zzaci();
                ByteBuffer byteBuffer = zzbfvVar.getByteBuffer();
                boolean zzadc = zzbfvVar.zzadc();
                String url = zzbfvVar.getUrl();
                if (url == null) {
                    zzbbd.zzeo("Stream cache URL is null.");
                    return;
                } else {
                    this.zzeuq = zzach();
                    this.zzeuq.zza(Uri.parse(url), zzaci, byteBuffer, zzadc);
                }
            } else {
                String valueOf = String.valueOf(this.zzeur);
                zzbbd.zzeo(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                return;
            }
        } else {
            this.zzeuq = zzach();
            this.zzeuq.zza(Uri.parse(this.zzeur), zzaci());
        }
        this.zzeuq.zza(this);
        zza(this.zzbjb, false);
        this.zzeut = this.zzeuq.zzacw().getPlaybackState();
        if (this.zzeut == 3) {
            zzacm();
        }
    }

    private final void zzacm() {
        if (this.zzeuw) {
            return;
        }
        this.zzeuw = true;
        zzayh.zzelc.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.We

            /* renamed from: a, reason: collision with root package name */
            private final zzbee f11921a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11921a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11921a.zzacv();
            }
        });
        zzabd();
        this.zzeum.zzcg();
        if (this.zzeux) {
            play();
        }
    }

    private final void zzacn() {
        int i = this.zzeuz;
        float f2 = i > 0 ? this.zzeuy / i : 1.0f;
        if (this.zzevc != f2) {
            this.zzevc = f2;
            requestLayout();
        }
    }

    private final void zzaco() {
        zzbes zzbesVar = this.zzeuq;
        if (zzbesVar != null) {
            zzbesVar.zzau(true);
        }
    }

    private final void zzacp() {
        zzbes zzbesVar = this.zzeuq;
        if (zzbesVar != null) {
            zzbesVar.zzau(false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getCurrentPosition() {
        if (zzack()) {
            return (int) this.zzeuq.zzacw().zzbr();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getDuration() {
        if (zzack()) {
            return (int) this.zzeuq.zzacw().getDuration();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getVideoHeight() {
        return this.zzeuz;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getVideoWidth() {
        return this.zzeuy;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = this.zzevc;
        if (f2 != 0.0f && this.zzeuu == null) {
            float f3 = measuredWidth;
            float f4 = f3 / measuredHeight;
            if (f2 > f4) {
                measuredHeight = (int) (f3 / f2);
            }
            float f5 = this.zzevc;
            if (f5 < f4) {
                measuredWidth = (int) (measuredHeight * f5);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzbdx zzbdxVar = this.zzeuu;
        if (zzbdxVar != null) {
            zzbdxVar.zzo(measuredWidth, measuredHeight);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i4 = this.zzeva;
            if (((i4 > 0 && i4 != measuredWidth) || ((i3 = this.zzevb) > 0 && i3 != measuredHeight)) && this.zzeun && zzacj()) {
                zzfg zzacw = this.zzeuq.zzacw();
                if (zzacw.zzbr() > 0 && !zzacw.zzbp()) {
                    zza(0.0f, true);
                    zzacw.zzc(true);
                    long zzbr = zzacw.zzbr();
                    long a2 = com.google.android.gms.ads.internal.zzbv.l().a();
                    while (zzacj() && zzacw.zzbr() == zzbr && com.google.android.gms.ads.internal.zzbv.l().a() - a2 <= 250) {
                    }
                    zzacw.zzc(false);
                    zzabd();
                }
            }
            this.zzeva = measuredWidth;
            this.zzevb = measuredHeight;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzeuv) {
            this.zzeuu = new zzbdx(getContext());
            this.zzeuu.zza(surfaceTexture, i, i2);
            this.zzeuu.start();
            SurfaceTexture zzabr = this.zzeuu.zzabr();
            if (zzabr != null) {
                surfaceTexture = zzabr;
            } else {
                this.zzeuu.zzabq();
                this.zzeuu = null;
            }
        }
        this.zzbjb = new Surface(surfaceTexture);
        if (this.zzeuq == null) {
            zzacl();
        } else {
            zza(this.zzbjb, true);
            if (!this.zzeuo.zzetk) {
                zzaco();
            }
        }
        zzacn();
        zzayh.zzelc.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.af

            /* renamed from: a, reason: collision with root package name */
            private final zzbee f12058a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12058a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12058a.zzacr();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbdx zzbdxVar = this.zzeuu;
        if (zzbdxVar != null) {
            zzbdxVar.zzabq();
            this.zzeuu = null;
        }
        if (this.zzeuq != null) {
            zzacp();
            Surface surface = this.zzbjb;
            if (surface != null) {
                surface.release();
            }
            this.zzbjb = null;
            zza((Surface) null, true);
        }
        zzayh.zzelc.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.cf

            /* renamed from: a, reason: collision with root package name */
            private final zzbee f12102a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12102a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12102a.zzacq();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        zzbdx zzbdxVar = this.zzeuu;
        if (zzbdxVar != null) {
            zzbdxVar.zzo(i, i2);
        }
        zzayh.zzelc.post(new Runnable(this, i, i2) { // from class: com.google.android.gms.internal.ads.bf

            /* renamed from: a, reason: collision with root package name */
            private final zzbee f12080a;

            /* renamed from: b, reason: collision with root package name */
            private final int f12081b;

            /* renamed from: c, reason: collision with root package name */
            private final int f12082c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12080a = this;
                this.f12081b = i;
                this.f12082c = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12080a.zzq(this.f12081b, this.f12082c);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeum.zzc(this);
        this.zzera.zza(surfaceTexture, this.zzeup);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzaxz.v(sb.toString());
        zzayh.zzelc.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.df

            /* renamed from: a, reason: collision with root package name */
            private final zzbee f12124a;

            /* renamed from: b, reason: collision with root package name */
            private final int f12125b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12124a = this;
                this.f12125b = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12124a.zzde(this.f12125b);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void pause() {
        if (zzack()) {
            if (this.zzeuo.zzetk) {
                zzacp();
            }
            this.zzeuq.zzacw().zzc(false);
            this.zzeum.zzace();
            this.zzerb.zzace();
            zzayh.zzelc.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads._e

                /* renamed from: a, reason: collision with root package name */
                private final zzbee f12035a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12035a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12035a.zzacs();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void play() {
        if (zzack()) {
            if (this.zzeuo.zzetk) {
                zzaco();
            }
            this.zzeuq.zzacw().zzc(true);
            this.zzeum.zzacd();
            this.zzerb.zzacd();
            this.zzera.zzabf();
            zzayh.zzelc.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.Ze

                /* renamed from: a, reason: collision with root package name */
                private final zzbee f12008a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12008a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12008a.zzact();
                }
            });
            return;
        }
        this.zzeux = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void seekTo(int i) {
        if (zzack()) {
            this.zzeuq.zzacw().seekTo(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzeur = str;
            zzacl();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void stop() {
        if (zzacj()) {
            this.zzeuq.zzacw().stop();
            if (this.zzeuq != null) {
                zza((Surface) null, true);
                zzbes zzbesVar = this.zzeuq;
                if (zzbesVar != null) {
                    zzbesVar.zza((zzbez) null);
                    this.zzeuq.release();
                    this.zzeuq = null;
                }
                this.zzeut = 1;
                this.zzeus = false;
                this.zzeuw = false;
                this.zzeux = false;
            }
        }
        this.zzeum.zzace();
        this.zzerb.zzace();
        this.zzeum.onStop();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final String zzaaz() {
        String str = this.zzeuv ? " spherical" : "";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.Ve
    public final void zzabd() {
        zza(this.zzerb.getVolume(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacq() {
        zzbdh zzbdhVar = this.zzeup;
        if (zzbdhVar != null) {
            zzbdhVar.zzabh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacr() {
        zzbdh zzbdhVar = this.zzeup;
        if (zzbdhVar != null) {
            zzbdhVar.zzabe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacs() {
        zzbdh zzbdhVar = this.zzeup;
        if (zzbdhVar != null) {
            zzbdhVar.onPaused();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzact() {
        zzbdh zzbdhVar = this.zzeup;
        if (zzbdhVar != null) {
            zzbdhVar.zzabf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacu() {
        zzbdh zzbdhVar = this.zzeup;
        if (zzbdhVar != null) {
            zzbdhVar.zzabg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacv() {
        zzbdh zzbdhVar = this.zzeup;
        if (zzbdhVar != null) {
            zzbdhVar.zzcg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zzb(final boolean z, final long j) {
        if (this.zzerw != null) {
            zzbcg.zzepo.execute(new Runnable(this, z, j) { // from class: com.google.android.gms.internal.ads.ef

                /* renamed from: a, reason: collision with root package name */
                private final zzbee f12142a;

                /* renamed from: b, reason: collision with root package name */
                private final boolean f12143b;

                /* renamed from: c, reason: collision with root package name */
                private final long f12144c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12142a = this;
                    this.f12143b = z;
                    this.f12144c = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12142a.zzc(this.f12143b, this.f12144c);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z, long j) {
        this.zzerw.zza(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzcz(int i) {
        zzbes zzbesVar = this.zzeuq;
        if (zzbesVar != null) {
            zzbesVar.zzacz().zzdf(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzda(int i) {
        zzbes zzbesVar = this.zzeuq;
        if (zzbesVar != null) {
            zzbesVar.zzacz().zzdg(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzdb(int i) {
        zzbes zzbesVar = this.zzeuq;
        if (zzbesVar != null) {
            zzbesVar.zzacz().zzdb(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzdc(int i) {
        zzbes zzbesVar = this.zzeuq;
        if (zzbesVar != null) {
            zzbesVar.zzacz().zzdc(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zzdd(int i) {
        if (this.zzeut != i) {
            this.zzeut = i;
            if (i == 3) {
                zzacm();
                return;
            }
            if (i != 4) {
                return;
            }
            if (this.zzeuo.zzetk) {
                zzacp();
            }
            this.zzeum.zzace();
            this.zzerb.zzace();
            zzayh.zzelc.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.Xe

                /* renamed from: a, reason: collision with root package name */
                private final zzbee f11956a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11956a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f11956a.zzacu();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzde(int i) {
        zzbdh zzbdhVar = this.zzeup;
        if (zzbdhVar != null) {
            zzbdhVar.onWindowVisibilityChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzeu(String str) {
        zzbdh zzbdhVar = this.zzeup;
        if (zzbdhVar != null) {
            zzbdhVar.zzi("ExoPlayerAdapter error", str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zzp(int i, int i2) {
        this.zzeuy = i;
        this.zzeuz = i2;
        zzacn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(int i, int i2) {
        zzbdh zzbdhVar = this.zzeup;
        if (zzbdhVar != null) {
            zzbdhVar.zzm(i, i2);
        }
    }

    private final void zza(float f2, boolean z) {
        zzbes zzbesVar = this.zzeuq;
        if (zzbesVar != null) {
            zzbesVar.zzb(f2, z);
        } else {
            zzbbd.zzeo("Trying to set volume before player is initalized.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(zzbdh zzbdhVar) {
        this.zzeup = zzbdhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(float f2, float f3) {
        zzbdx zzbdxVar = this.zzeuu;
        if (zzbdxVar != null) {
            zzbdxVar.zzb(f2, f3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        final String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        zzbbd.zzeo(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzeus = true;
        if (this.zzeuo.zzetk) {
            zzacp();
        }
        zzayh.zzelc.post(new Runnable(this, sb2) { // from class: com.google.android.gms.internal.ads.Ye

            /* renamed from: a, reason: collision with root package name */
            private final zzbee f11978a;

            /* renamed from: b, reason: collision with root package name */
            private final String f11979b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11978a = this;
                this.f11979b = sb2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11978a.zzeu(this.f11979b);
            }
        });
    }
}
