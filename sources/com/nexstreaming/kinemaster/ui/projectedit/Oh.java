package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.PowerManager;
import android.widget.Toast;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexvideoeditor.NexClipInfo;
import java.io.File;

/* compiled from: VoiceRecordingController.java */
/* loaded from: classes2.dex */
public class Oh {

    /* renamed from: b */
    private final boolean f21988b;

    /* renamed from: f */
    private File f21992f;

    /* renamed from: g */
    private AudioRecord f21993g;

    /* renamed from: h */
    private b f21994h;
    private PowerManager.WakeLock i;
    private Context m;
    private byte[] o;

    /* renamed from: a */
    private final String f21987a = Oh.class.getSimpleName();

    /* renamed from: c */
    private volatile boolean f21989c = false;

    /* renamed from: d */
    private boolean f21990d = false;

    /* renamed from: e */
    private boolean f21991e = false;
    private boolean j = false;
    private Handler k = new Handler();
    private long l = 0;
    private VideoEditor n = null;

    /* compiled from: VoiceRecordingController.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: VoiceRecordingController.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(a aVar);

        void a(File file);

        void a(boolean z);

        void a(boolean z, boolean z2, int i);
    }

    public Oh(Context context, boolean z) {
        this.m = context;
        this.f21988b = z;
        if (this.f21988b) {
            return;
        }
        this.i = ((PowerManager) context.getSystemService("power")).newWakeLock(6, "kinemaster:VoiceRecordingController");
    }

    public void d() {
        if (this.f21989c || this.f21990d || this.f21991e || this.f21994h == null) {
            return;
        }
        if (this.f21988b || this.n != null) {
            if (this.f21988b || !this.n.B()) {
                AudioRecord audioRecord = this.f21993g;
                if (audioRecord != null) {
                    audioRecord.release();
                }
                this.f21993g = null;
                int minBufferSize = AudioRecord.getMinBufferSize(44100, 2, 2);
                if (minBufferSize == -2 || minBufferSize == -1 || minBufferSize <= 0) {
                    return;
                }
                int i = minBufferSize < 2048 ? 2048 : minBufferSize;
                byte[] bArr = this.o;
                if (bArr == null || bArr.length != i) {
                    this.o = new byte[2048];
                }
                this.f21993g = new AudioRecord(1, 44100, 16, 2, i);
                if (this.f21993g.getState() != 1) {
                    this.f21993g.release();
                    this.f21993g = null;
                }
                if (this.f21993g == null) {
                    return;
                }
                if (!this.f21988b) {
                    this.f21992f = c.d.b.m.l.b(this.m);
                    if (this.n.a(this.f21992f.getAbsolutePath(), 44100, 1, 16) != 0) {
                        return;
                    }
                }
                this.f21989c = true;
                new Thread(new Mh(this)).start();
                synchronized (this) {
                    this.f21991e = true;
                }
                if (!this.f21988b) {
                    this.i.acquire();
                }
                this.f21994h.a(this.f21991e, this.f21989c, -1);
                Nh nh = new Nh(this);
                if (this.f21988b) {
                    nh.b();
                } else {
                    this.f21994h.a(nh);
                }
            }
        }
    }

    public void a(VideoEditor videoEditor) {
        if (!this.f21988b) {
            this.n = videoEditor;
            return;
        }
        throw new IllegalStateException("Can't set editor on monitor-only recorder instance");
    }

    public boolean b() {
        return this.f21989c;
    }

    public void c() {
        this.f21990d = false;
    }

    public void a(boolean z) {
        if (this.f21989c) {
            this.f21991e = false;
            this.f21989c = false;
            while (this.j) {
                try {
                    Thread.sleep(30L);
                } catch (InterruptedException unused) {
                }
            }
            this.f21993g.stop();
            this.f21993g.release();
            this.f21993g = null;
            NexClipInfo nexClipInfo = new NexClipInfo();
            if (!this.f21988b) {
                this.n.a(nexClipInfo);
            }
            if (!z && nexClipInfo.mAudioDuration < 100) {
                if (!this.f21988b) {
                    Context context = this.m;
                    Toast.makeText(context, context.getResources().getString(R.string.voice_rec_too_short), 1).show();
                }
                z = true;
            }
            if (z) {
                File file = this.f21992f;
                if (file != null) {
                    file.delete();
                }
                b bVar = this.f21994h;
                if (bVar != null) {
                    bVar.a(z);
                }
            } else {
                b bVar2 = this.f21994h;
                if (bVar2 != null) {
                    bVar2.a(this.f21992f);
                }
            }
            if (this.f21988b) {
                return;
            }
            this.i.release();
        }
    }

    public void a(b bVar) {
        this.f21994h = bVar;
    }

    public void a(long j) {
        if (!this.f21988b) {
            this.l = ((j * 44100) / 1000) * 2;
            return;
        }
        throw new IllegalStateException();
    }

    public boolean a() {
        return this.f21991e;
    }
}
