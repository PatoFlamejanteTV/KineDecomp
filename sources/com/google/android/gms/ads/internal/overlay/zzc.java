package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzgr
/* loaded from: classes.dex */
public class zzc extends zzi implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, String> f600a = new HashMap();
    private final zzp b;
    private int c;
    private int d;
    private MediaPlayer e;
    private Uri f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private float l;
    private boolean m;
    private boolean n;
    private int o;
    private zzh p;

    static {
        f600a.put(-1004, "MEDIA_ERROR_IO");
        f600a.put(-1007, "MEDIA_ERROR_MALFORMED");
        f600a.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        f600a.put(-110, "MEDIA_ERROR_TIMED_OUT");
        f600a.put(100, "MEDIA_ERROR_SERVER_DIED");
        f600a.put(1, "MEDIA_ERROR_UNKNOWN");
        f600a.put(1, "MEDIA_INFO_UNKNOWN");
        f600a.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        f600a.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        f600a.put(701, "MEDIA_INFO_BUFFERING_START");
        f600a.put(702, "MEDIA_INFO_BUFFERING_END");
        f600a.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        f600a.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        f600a.put(802, "MEDIA_INFO_METADATA_UPDATE");
        f600a.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        f600a.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzc(Context context, zzp zzpVar) {
        super(context);
        this.c = 0;
        this.d = 0;
        this.l = 1.0f;
        setSurfaceTextureListener(this);
        this.b = zzpVar;
        this.b.a((zzi) this);
    }

    private void a(boolean z) {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView release");
        if (this.e != null) {
            this.e.reset();
            this.e.release();
            this.e = null;
            b(0);
            if (z) {
                this.d = 0;
                c(0);
            }
            j();
        }
    }

    private void b(float f) {
        if (this.e == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        } else {
            try {
                this.e.setVolume(f, f);
            } catch (IllegalStateException e) {
            }
        }
    }

    private void b(int i) {
        if (i == 3) {
            this.b.c();
        } else if (this.c == 3 && i != 3) {
            this.b.d();
        }
        this.c = i;
    }

    private void c(int i) {
        this.d = i;
    }

    private void g() {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.f == null || surfaceTexture == null) {
            return;
        }
        a(false);
        try {
            this.e = new MediaPlayer();
            this.e.setOnBufferingUpdateListener(this);
            this.e.setOnCompletionListener(this);
            this.e.setOnErrorListener(this);
            this.e.setOnInfoListener(this);
            this.e.setOnPreparedListener(this);
            this.e.setOnVideoSizeChangedListener(this);
            this.i = 0;
            this.e.setDataSource(getContext(), this.f);
            this.e.setSurface(new Surface(surfaceTexture));
            this.e.setAudioStreamType(3);
            this.e.setScreenOnWhilePlaying(true);
            this.e.prepareAsync();
            b(1);
        } catch (IOException | IllegalArgumentException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to initialize MediaPlayer at " + this.f, e);
            onError(this.e, 1, 0);
        }
    }

    private void h() {
        if (!k() || this.e.getCurrentPosition() <= 0 || this.d == 3) {
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView nudging MediaPlayer");
        b(0.0f);
        this.e.start();
        int currentPosition = this.e.getCurrentPosition();
        long currentTimeMillis = com.google.android.gms.ads.internal.zzp.i().currentTimeMillis();
        while (k() && this.e.getCurrentPosition() == currentPosition && com.google.android.gms.ads.internal.zzp.i().currentTimeMillis() - currentTimeMillis <= 250) {
        }
        this.e.pause();
        n();
    }

    private void i() {
        AudioManager o = o();
        if (o == null || this.n) {
            return;
        }
        if (o.requestAudioFocus(this, 3, 2) == 1) {
            l();
        } else {
            com.google.android.gms.ads.internal.util.client.zzb.e("AdMediaPlayerView audio focus request failed");
        }
    }

    private void j() {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView abandon audio focus");
        AudioManager o = o();
        if (o == null || !this.n) {
            return;
        }
        if (o.abandonAudioFocus(this) == 1) {
            this.n = false;
        } else {
            com.google.android.gms.ads.internal.util.client.zzb.e("AdMediaPlayerView abandon audio focus failed");
        }
    }

    private boolean k() {
        return (this.e == null || this.c == -1 || this.c == 0 || this.c == 1) ? false : true;
    }

    private void l() {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView audio focus gained");
        this.n = true;
        n();
    }

    private void m() {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView audio focus lost");
        this.n = false;
        n();
    }

    private void n() {
        if (this.m || !this.n) {
            b(0.0f);
        } else {
            b(this.l);
        }
    }

    private AudioManager o() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public String a() {
        return "MediaPlayer";
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void a(float f) {
        this.l = f;
        n();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void a(int i) {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView seek " + i);
        if (!k()) {
            this.o = i;
        } else {
            this.e.seekTo(i);
            this.o = 0;
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void a(zzh zzhVar) {
        this.p = zzhVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void b() {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView stop");
        if (this.e != null) {
            this.e.stop();
            this.e.release();
            this.e = null;
            b(0);
            c(0);
            j();
        }
        this.b.b();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void c() {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView play");
        if (k()) {
            this.e.start();
            b(3);
            zzid.zzIE.post(new f(this));
        }
        c(3);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void d() {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView pause");
        if (k() && this.e.isPlaying()) {
            this.e.pause();
            b(4);
            zzid.zzIE.post(new g(this));
        }
        c(4);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void e() {
        this.m = true;
        n();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void f() {
        this.m = false;
        n();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public int getCurrentPosition() {
        if (k()) {
            return this.e.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public int getDuration() {
        if (k()) {
            return this.e.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public int getVideoHeight() {
        if (this.e != null) {
            return this.e.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public int getVideoWidth() {
        if (this.e != null) {
            return this.e.getVideoWidth();
        }
        return 0;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        if (i > 0) {
            l();
        } else if (i < 0) {
            m();
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.i = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView completion");
        b(5);
        c(5);
        zzid.zzIE.post(new b(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = f600a.get(Integer.valueOf(i));
        String str2 = f600a.get(Integer.valueOf(i2));
        com.google.android.gms.ads.internal.util.client.zzb.e("AdMediaPlayerView MediaPlayer error: " + str + ":" + str2);
        b(-1);
        c(-1);
        zzid.zzIE.post(new c(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView MediaPlayer info: " + f600a.get(Integer.valueOf(i)) + ":" + f600a.get(Integer.valueOf(i2)));
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.g, i);
        int defaultSize2 = getDefaultSize(this.h, i2);
        if (this.g > 0 && this.h > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.g * defaultSize2 < this.h * size) {
                    defaultSize = (this.g * defaultSize2) / this.h;
                } else if (this.g * defaultSize2 > this.h * size) {
                    defaultSize2 = (this.h * size) / this.g;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i3 = (this.h * size) / this.g;
                if (mode2 != Integer.MIN_VALUE || i3 <= defaultSize2) {
                    defaultSize2 = i3;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.g * defaultSize2) / this.h;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i4 = this.g;
                int i5 = this.h;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                    defaultSize = i4;
                } else {
                    defaultSize = (this.g * defaultSize2) / this.h;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (this.h * size) / this.g;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (Build.VERSION.SDK_INT == 16) {
            if ((this.j > 0 && this.j != defaultSize) || (this.k > 0 && this.k != defaultSize2)) {
                h();
            }
            this.j = defaultSize;
            this.k = defaultSize2;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView prepared");
        b(2);
        this.b.a();
        zzid.zzIE.post(new a(this));
        this.g = mediaPlayer.getVideoWidth();
        this.h = mediaPlayer.getVideoHeight();
        if (this.o != 0) {
            a(this.o);
        }
        h();
        com.google.android.gms.ads.internal.util.client.zzb.c("AdMediaPlayerView stream dimensions: " + this.g + " x " + this.h);
        if (this.d == 3) {
            c();
        }
        i();
        n();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView surface created");
        g();
        zzid.zzIE.post(new d(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView surface destroyed");
        if (this.e != null && this.o == 0) {
            this.o = this.e.getCurrentPosition();
        }
        zzid.zzIE.post(new e(this));
        a(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView surface changed");
        boolean z = this.d == 3;
        boolean z2 = this.g == i && this.h == i2;
        if (this.e != null && z && z2) {
            if (this.o != 0) {
                a(this.o);
            }
            c();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.b.b(this);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        com.google.android.gms.ads.internal.util.client.zzb.d("AdMediaPlayerView size changed: " + i + " x " + i2);
        this.g = mediaPlayer.getVideoWidth();
        this.h = mediaPlayer.getVideoHeight();
        if (this.g == 0 || this.h == 0) {
            return;
        }
        requestLayout();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void setMimeType(String str) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.f = uri;
        this.o = 0;
        g();
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
