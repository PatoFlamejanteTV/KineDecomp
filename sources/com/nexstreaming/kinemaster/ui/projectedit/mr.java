package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.PowerManager;
import android.widget.Toast;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexClipInfo;
import java.io.File;

/* compiled from: VoiceRecordingControler.java */
/* loaded from: classes.dex */
public class mr {
    private final boolean b;
    private File f;
    private AudioRecord g;
    private b h;
    private PowerManager.WakeLock i;
    private Context m;
    private byte[] o;

    /* renamed from: a, reason: collision with root package name */
    private final String f4099a = "VoiceRecordingControler";
    private volatile boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean j = false;
    private Handler k = new Handler();
    private long l = 0;
    private VideoEditor n = null;

    /* compiled from: VoiceRecordingControler.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: VoiceRecordingControler.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);

        void a(File file);

        void a(boolean z);

        void a(boolean z, boolean z2, int i);
    }

    public void a(VideoEditor videoEditor) {
        if (this.b) {
            throw new IllegalStateException("Can't set editor on monitor-only recorder instance");
        }
        this.n = videoEditor;
    }

    public void a() {
        this.d = false;
    }

    public mr(Context context, boolean z) {
        this.m = context;
        this.b = z;
        if (!this.b) {
            this.i = ((PowerManager) context.getSystemService("power")).newWakeLock(6, "VoiceRecordingControler");
        }
    }

    public void b() {
        if (!this.c && !this.d && !this.e && this.h != null) {
            if (this.b || this.n != null) {
                if (this.b || !this.n.D()) {
                    if (this.g != null) {
                        this.g.release();
                    }
                    this.g = null;
                    int minBufferSize = AudioRecord.getMinBufferSize(44100, 2, 2);
                    if (minBufferSize != -2 && minBufferSize != -1 && minBufferSize > 0) {
                        if (minBufferSize < 2048) {
                            minBufferSize = 2048;
                        }
                        if (this.o == null || this.o.length != minBufferSize) {
                            this.o = new byte[2048];
                        }
                        this.g = new AudioRecord(EditorGlobal.b(this.m, 1), 44100, 16, 2, minBufferSize);
                        if (this.g.getState() != 1) {
                            this.g.release();
                            this.g = null;
                        }
                        if (this.g != null) {
                            if (!this.b) {
                                this.f = com.nexstreaming.kinemaster.h.c.a(this.m);
                                if (this.n.a(this.f.getAbsolutePath(), 44100, 1, 16) != 0) {
                                    return;
                                }
                            }
                            this.c = true;
                            new Thread(new ms(this)).start();
                            synchronized (this) {
                                this.e = true;
                            }
                            if (!this.b) {
                                this.i.acquire();
                            }
                            this.h.a(this.e, this.c, -1);
                            mu muVar = new mu(this);
                            if (this.b) {
                                muVar.a();
                            } else {
                                this.h.a(muVar);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(boolean z) {
        if (this.c) {
            this.e = false;
            this.c = false;
            while (this.j) {
                try {
                    Thread.sleep(30L);
                } catch (InterruptedException e) {
                }
            }
            this.g.stop();
            this.g.release();
            this.g = null;
            NexClipInfo nexClipInfo = new NexClipInfo();
            if (!this.b) {
                this.n.a(nexClipInfo);
            }
            if (!z && nexClipInfo.mAudioDuration < 500) {
                if (!this.b) {
                    Toast.makeText(this.m, this.m.getResources().getString(R.string.voice_rec_too_short), 1).show();
                }
                z = true;
            }
            if (z) {
                if (this.f != null) {
                    this.f.delete();
                }
                if (this.h != null) {
                    this.h.a(z);
                }
            } else if (this.h != null) {
                this.h.a(this.f);
            }
            if (!this.b) {
                this.i.release();
            }
        }
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    public void a(long j) {
        if (this.b) {
            throw new IllegalStateException();
        }
        this.l = ((44100 * j) / 1000) * 2;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.e;
    }
}
