package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.qq.e.comm.constants.ErrorCode;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzark
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzbcx extends zzbdi implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzeqe = new HashMap();
    private final zzbea zzeqf;
    private final boolean zzeqg;
    private int zzeqh;
    private int zzeqi;
    private MediaPlayer zzeqj;
    private Uri zzeqk;
    private int zzeql;
    private int zzeqm;
    private int zzeqn;
    private int zzeqo;
    private int zzeqp;
    private zzbdx zzeqq;
    private boolean zzeqr;
    private int zzeqs;
    private zzbdh zzeqt;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzeqe.put(-1004, "MEDIA_ERROR_IO");
            zzeqe.put(-1007, "MEDIA_ERROR_MALFORMED");
            zzeqe.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzeqe.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzeqe.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzeqe.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzeqe.put(1, "MEDIA_ERROR_UNKNOWN");
        zzeqe.put(1, "MEDIA_INFO_UNKNOWN");
        zzeqe.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzeqe.put(Integer.valueOf(ErrorCode.OtherError.VIDEO_PLAY_ERROR), "MEDIA_INFO_BUFFERING_START");
        zzeqe.put(702, "MEDIA_INFO_BUFFERING_END");
        zzeqe.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzeqe.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzeqe.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzeqe.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzeqe.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzbcx(Context context, boolean z, boolean z2, zzbdy zzbdyVar, zzbea zzbeaVar) {
        super(context);
        this.zzeqh = 0;
        this.zzeqi = 0;
        setSurfaceTextureListener(this);
        this.zzeqf = zzbeaVar;
        this.zzeqr = z;
        this.zzeqg = z2;
        this.zzeqf.zzb(this);
    }

    private final void zzaba() {
        zzaxz.v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzeqk == null || surfaceTexture == null) {
            return;
        }
        zzar(false);
        try {
            com.google.android.gms.ads.internal.zzbv.w();
            this.zzeqj = new MediaPlayer();
            this.zzeqj.setOnBufferingUpdateListener(this);
            this.zzeqj.setOnCompletionListener(this);
            this.zzeqj.setOnErrorListener(this);
            this.zzeqj.setOnInfoListener(this);
            this.zzeqj.setOnPreparedListener(this);
            this.zzeqj.setOnVideoSizeChangedListener(this);
            this.zzeqn = 0;
            if (this.zzeqr) {
                this.zzeqq = new zzbdx(getContext());
                this.zzeqq.zza(surfaceTexture, getWidth(), getHeight());
                this.zzeqq.start();
                SurfaceTexture zzabr = this.zzeqq.zzabr();
                if (zzabr != null) {
                    surfaceTexture = zzabr;
                } else {
                    this.zzeqq.zzabq();
                    this.zzeqq = null;
                }
            }
            this.zzeqj.setDataSource(getContext(), this.zzeqk);
            com.google.android.gms.ads.internal.zzbv.x();
            this.zzeqj.setSurface(new Surface(surfaceTexture));
            this.zzeqj.setAudioStreamType(3);
            this.zzeqj.setScreenOnWhilePlaying(true);
            this.zzeqj.prepareAsync();
            zzcx(1);
        } catch (IOException | IllegalArgumentException | IllegalStateException e2) {
            String valueOf = String.valueOf(this.zzeqk);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
            sb.append("Failed to initialize MediaPlayer at ");
            sb.append(valueOf);
            zzbbd.zzc(sb.toString(), e2);
            onError(this.zzeqj, 1, 0);
        }
    }

    private final void zzabb() {
        if (this.zzeqg && zzabc() && this.zzeqj.getCurrentPosition() > 0 && this.zzeqi != 3) {
            zzaxz.v("AdMediaPlayerView nudging MediaPlayer");
            zzd(0.0f);
            this.zzeqj.start();
            int currentPosition = this.zzeqj.getCurrentPosition();
            long a2 = com.google.android.gms.ads.internal.zzbv.l().a();
            while (zzabc() && this.zzeqj.getCurrentPosition() == currentPosition && com.google.android.gms.ads.internal.zzbv.l().a() - a2 <= 250) {
            }
            this.zzeqj.pause();
            zzabd();
        }
    }

    private final boolean zzabc() {
        int i;
        return (this.zzeqj == null || (i = this.zzeqh) == -1 || i == 0 || i == 1) ? false : true;
    }

    private final void zzar(boolean z) {
        zzaxz.v("AdMediaPlayerView release");
        zzbdx zzbdxVar = this.zzeqq;
        if (zzbdxVar != null) {
            zzbdxVar.zzabq();
            this.zzeqq = null;
        }
        MediaPlayer mediaPlayer = this.zzeqj;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzeqj.release();
            this.zzeqj = null;
            zzcx(0);
            if (z) {
                this.zzeqi = 0;
                this.zzeqi = 0;
            }
        }
    }

    private final void zzcx(int i) {
        if (i == 3) {
            this.zzeqf.zzacd();
            this.zzerb.zzacd();
        } else if (this.zzeqh == 3) {
            this.zzeqf.zzace();
            this.zzerb.zzace();
        }
        this.zzeqh = i;
    }

    private final void zzd(float f2) {
        MediaPlayer mediaPlayer = this.zzeqj;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f2, f2);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzbbd.zzeo("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getCurrentPosition() {
        if (zzabc()) {
            return this.zzeqj.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getDuration() {
        if (zzabc()) {
            return this.zzeqj.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.zzeqj;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.zzeqj;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzeqn = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzaxz.v("AdMediaPlayerView completion");
        zzcx(5);
        this.zzeqi = 5;
        zzayh.zzelc.post(new Ee(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzeqe.get(Integer.valueOf(i));
        String str2 = zzeqe.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzbbd.zzeo(sb.toString());
        zzcx(-1);
        this.zzeqi = -1;
        zzayh.zzelc.post(new Fe(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzeqe.get(Integer.valueOf(i));
        String str2 = zzeqe.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzaxz.v(sb.toString());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzeql
            int r0 = android.view.TextureView.getDefaultSize(r0, r6)
            int r1 = r5.zzeqm
            int r1 = android.view.TextureView.getDefaultSize(r1, r7)
            int r2 = r5.zzeql
            if (r2 <= 0) goto L88
            int r2 = r5.zzeqm
            if (r2 <= 0) goto L88
            com.google.android.gms.internal.ads.zzbdx r2 = r5.zzeqq
            if (r2 != 0) goto L88
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L48
            if (r1 != r2) goto L48
            int r0 = r5.zzeql
            int r1 = r0 * r7
            int r2 = r5.zzeqm
            int r3 = r6 * r2
            if (r1 >= r3) goto L3d
            int r0 = r0 * r7
            int r0 = r0 / r2
            r1 = r7
            goto L88
        L3d:
            int r1 = r0 * r7
            int r3 = r6 * r2
            if (r1 <= r3) goto L69
            int r2 = r2 * r6
            int r1 = r2 / r0
            goto L89
        L48:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L5a
            int r0 = r5.zzeqm
            int r0 = r0 * r6
            int r2 = r5.zzeql
            int r0 = r0 / r2
            if (r1 != r3) goto L58
            if (r0 <= r7) goto L58
            goto L67
        L58:
            r1 = r0
            goto L89
        L5a:
            if (r1 != r2) goto L6b
            int r1 = r5.zzeql
            int r1 = r1 * r7
            int r2 = r5.zzeqm
            int r1 = r1 / r2
            if (r0 != r3) goto L68
            if (r1 <= r6) goto L68
        L67:
            goto L69
        L68:
            r6 = r1
        L69:
            r1 = r7
            goto L89
        L6b:
            int r2 = r5.zzeql
            int r4 = r5.zzeqm
            if (r1 != r3) goto L78
            if (r4 <= r7) goto L78
            int r2 = r2 * r7
            int r2 = r2 / r4
            r1 = r7
            goto L79
        L78:
            r1 = r4
        L79:
            if (r0 != r3) goto L86
            if (r2 <= r6) goto L86
            int r7 = r5.zzeqm
            int r7 = r7 * r6
            int r0 = r5.zzeql
            int r1 = r7 / r0
            goto L89
        L86:
            r6 = r2
            goto L89
        L88:
            r6 = r0
        L89:
            r5.setMeasuredDimension(r6, r1)
            com.google.android.gms.internal.ads.zzbdx r7 = r5.zzeqq
            if (r7 == 0) goto L93
            r7.zzo(r6, r1)
        L93:
            int r7 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r7 != r0) goto Lac
            int r7 = r5.zzeqo
            if (r7 <= 0) goto L9f
            if (r7 != r6) goto La5
        L9f:
            int r7 = r5.zzeqp
            if (r7 <= 0) goto La8
            if (r7 == r1) goto La8
        La5:
            r5.zzabb()
        La8:
            r5.zzeqo = r6
            r5.zzeqp = r1
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcx.onMeasure(int, int):void");
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzaxz.v("AdMediaPlayerView prepared");
        zzcx(2);
        this.zzeqf.zzcg();
        zzayh.zzelc.post(new De(this));
        this.zzeql = mediaPlayer.getVideoWidth();
        this.zzeqm = mediaPlayer.getVideoHeight();
        int i = this.zzeqs;
        if (i != 0) {
            seekTo(i);
        }
        zzabb();
        int i2 = this.zzeql;
        int i3 = this.zzeqm;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzbbd.zzen(sb.toString());
        if (this.zzeqi == 3) {
            play();
        }
        zzabd();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzaxz.v("AdMediaPlayerView surface created");
        zzaba();
        zzayh.zzelc.post(new Ge(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzaxz.v("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzeqj;
        if (mediaPlayer != null && this.zzeqs == 0) {
            this.zzeqs = mediaPlayer.getCurrentPosition();
        }
        zzbdx zzbdxVar = this.zzeqq;
        if (zzbdxVar != null) {
            zzbdxVar.zzabq();
        }
        zzayh.zzelc.post(new Ie(this));
        zzar(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzaxz.v("AdMediaPlayerView surface changed");
        boolean z = this.zzeqi == 3;
        boolean z2 = this.zzeql == i && this.zzeqm == i2;
        if (this.zzeqj != null && z && z2) {
            int i3 = this.zzeqs;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzbdx zzbdxVar = this.zzeqq;
        if (zzbdxVar != null) {
            zzbdxVar.zzo(i, i2);
        }
        zzayh.zzelc.post(new He(this, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeqf.zzc(this);
        this.zzera.zza(surfaceTexture, this.zzeqt);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzaxz.v(sb.toString());
        this.zzeql = mediaPlayer.getVideoWidth();
        this.zzeqm = mediaPlayer.getVideoHeight();
        if (this.zzeql == 0 || this.zzeqm == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzaxz.v(sb.toString());
        zzayh.zzelc.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.Ce

            /* renamed from: a, reason: collision with root package name */
            private final zzbcx f11441a;

            /* renamed from: b, reason: collision with root package name */
            private final int f11442b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11441a = this;
                this.f11442b = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11441a.zzcy(this.f11442b);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void pause() {
        zzaxz.v("AdMediaPlayerView pause");
        if (zzabc() && this.zzeqj.isPlaying()) {
            this.zzeqj.pause();
            zzcx(4);
            zzayh.zzelc.post(new Ke(this));
        }
        this.zzeqi = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void play() {
        zzaxz.v("AdMediaPlayerView play");
        if (zzabc()) {
            this.zzeqj.start();
            zzcx(3);
            this.zzera.zzabf();
            zzayh.zzelc.post(new Je(this));
        }
        this.zzeqi = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzaxz.v(sb.toString());
        if (zzabc()) {
            this.zzeqj.seekTo(i);
            this.zzeqs = 0;
        } else {
            this.zzeqs = i;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzty zzd = zzty.zzd(parse);
        if (zzd != null) {
            parse = Uri.parse(zzd.url);
        }
        this.zzeqk = parse;
        this.zzeqs = 0;
        zzaba();
        requestLayout();
        invalidate();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void stop() {
        zzaxz.v("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzeqj;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzeqj.release();
            this.zzeqj = null;
            zzcx(0);
            this.zzeqi = 0;
        }
        this.zzeqf.onStop();
    }

    @Override // android.view.View
    public final String toString() {
        String name = zzbcx.class.getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(zzbdh zzbdhVar) {
        this.zzeqt = zzbdhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final String zzaaz() {
        String str = this.zzeqr ? " spherical" : "";
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.Ve
    public final void zzabd() {
        zzd(this.zzerb.getVolume());
    }

    public final /* synthetic */ void zzcy(int i) {
        zzbdh zzbdhVar = this.zzeqt;
        if (zzbdhVar != null) {
            zzbdhVar.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(float f2, float f3) {
        zzbdx zzbdxVar = this.zzeqq;
        if (zzbdxVar != null) {
            zzbdxVar.zzb(f2, f3);
        }
    }
}
