package com.nextreaming.nexvideoeditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.util.Log;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexImageLoader;

/* loaded from: classes.dex */
public class NexEditorEventListener {
    private static Bitmap l = null;
    private static String m = "";

    /* renamed from: a, reason: collision with root package name */
    private NexEditor f4797a;
    private Handler c;
    private AudioManager g;
    private NexEditor.d h;
    public NexImageLoader mImage;
    private ar b = null;
    public AudioTrack mAudioTrack = null;
    private NexEditor.PlayState d = null;
    private int e = 0;
    private boolean f = false;
    private LayerRenderer i = new LayerRenderer();
    private boolean j = false;
    private boolean k = true;

    public void setWatermark(boolean z) {
        this.k = z;
    }

    public void setSyncMode(boolean z) {
        this.j = z;
    }

    public synchronized void ignoreEventsUntilTag(int i) {
        if (!this.f) {
            this.f = true;
            this.e = i;
        } else if (this.e < i) {
            this.e = i;
        }
    }

    private synchronized void a(int i) {
        if (this.f && i >= this.e) {
            this.f = false;
        }
    }

    public NexEditorEventListener(NexEditor nexEditor, Context context, a aVar, NexImageLoader.d dVar) {
        this.f4797a = null;
        this.mImage = null;
        this.c = null;
        if (context != null) {
            this.g = (AudioManager) context.getApplicationContext().getSystemService("audio");
        } else {
            this.g = null;
        }
        this.f4797a = nexEditor;
        this.mImage = new NexImageLoader(context != null ? context.getResources() : null, aVar, dVar, nexEditor.a(), nexEditor.b(), nexEditor.c());
        this.c = new Handler();
    }

    public void setContext(Context context) {
        this.mImage.setResources(context == null ? null : context.getApplicationContext().getResources());
        if (context != null) {
            this.g = (AudioManager) context.getApplicationContext().getSystemService("audio");
        } else {
            this.g = null;
        }
    }

    public void setUIListener(ar arVar) {
        this.b = arVar;
        if (this.d != null) {
            this.b.a(NexEditor.PlayState.NONE, this.d);
        }
    }

    public int callbackCapture(int i, int i2, int i3, byte[] bArr) {
        this.c.post(new t(this, i, i2, i3, bArr));
        return 0;
    }

    public int callbackThumb(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr) {
        Log.d("NexEditorEventHandler", "callbackThumb start iMode=" + i + ", iTime=" + i3 + ", iWidth=" + i4 + ", iHeight=" + i5 + ", iSize=" + i8 + ", tag=" + i2);
        this.c.post(new ae(this, i, i3, i4, i5, i8, bArr, i6, i7, i2));
        Log.d("NexEditorEventHandler", "salabara callbackThumb end");
        return 0;
    }

    public int callbackHighLightIndex(int i, int[] iArr) {
        Log.d("NexEditorEventHandler", "callbackHighLightIndex start iCount=" + i);
        this.c.post(new ak(this, i, iArr));
        Log.d("NexEditorEventHandler", "callbackHighLightIndex end");
        return 0;
    }

    public NexImage callbackGetThemeImage(String str) {
        return this.mImage.openThemeImage(str);
    }

    public NexImage callbackGetThemeImageUsingResource(String str) {
        return this.mImage.openFile(str);
    }

    public NexImage callbackGetImageUsingFile(String str) {
        return this.mImage.openFile(str);
    }

    public NexImage callbackGetImageUsingText(String str) {
        return this.mImage.openFile(str);
    }

    public void callbackReleaseImage() {
    }

    public AudioTrack callbackGetAudioTrack(int i, int i2) {
        if (this.mAudioTrack != null) {
            this.mAudioTrack.release();
        }
        int i3 = i2 != 1 ? 3 : 2;
        this.mAudioTrack = new AudioTrack(3, i, i3, 2, AudioTrack.getMinBufferSize(i, i3, 2), 1);
        return this.mAudioTrack;
    }

    public void callbackReleaseAudioTrack() {
        if (this.mAudioTrack != null) {
            this.mAudioTrack.release();
            this.mAudioTrack = null;
        }
    }

    public AudioManager callbackGetAudioManager() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NexEditor.PlayState playState, NexEditor.PlayState playState2) {
        if (this.d != playState2) {
            this.d = playState2;
            if (this.b != null) {
                this.b.a(playState, playState2);
            }
            if (playState2 == NexEditor.PlayState.IDLE) {
                this.f4797a.e();
            }
            if (playState != null && playState != NexEditor.PlayState.NONE) {
                switch (playState2) {
                    case RUN:
                    case RECORD:
                        this.f4797a.c(NexEditor.b.f4793a);
                        return;
                    default:
                        this.f4797a.d(NexEditor.b.f4793a);
                        return;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int notifyEvent(int i, int i2, int i3, int i4, int i5) {
        if (i == 18) {
            a(i2);
            this.c.post(new al(this, i2));
        }
        if (!this.f) {
            switch (i) {
                case 0:
                    this.c.post(new am(this, i2, i3));
                    break;
                case 1:
                    this.c.post(new an(this, i2));
                    break;
                case 5:
                    this.c.post(new ao(this, i2, i3, i4, i5));
                    break;
                case 6:
                    this.c.post(new ap(this, i2, i3));
                    break;
                case 7:
                    this.c.post(new aq(this, i2));
                    break;
                case 10:
                    this.c.post(new w(this, i3, i4, i2));
                    break;
                case 11:
                    this.c.post(new z(this, i3, i4));
                    break;
                case 13:
                    this.c.post(new u(this));
                    break;
                case 14:
                    this.c.post(new v(this, i2));
                    break;
                case 17:
                    this.c.post(new y(this));
                    break;
                case 19:
                    Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] VIDEO_STARTED ", new Object[0]));
                    this.c.post(new aa(this));
                    break;
                case 20:
                    this.c.post(new ah(this, i2, i3));
                    Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_GETCLIPINFO_DONE p1=" + i2, new Object[0]));
                    break;
                case 21:
                    Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_CAPTURE_DONE p1=" + i2, new Object[0]));
                    this.c.post(new ab(this, i2));
                    break;
                case 22:
                    Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_PREPARE_CLIP_LOADING p1=" + i2, new Object[0]));
                    break;
                case 23:
                    this.c.post(new ad(this, i2, i3));
                    break;
                case 24:
                    this.c.post(new ac(this, i2, i3, i4));
                    break;
                case 26:
                    this.c.post(new aj(this, i2));
                    break;
                case 32:
                    this.c.post(new ai(this));
                    Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_GETCLIPINFO_DONE p1=" + i2, new Object[0]));
                    break;
                case 34:
                    this.c.post(new x(this, i2));
                    break;
                case 39:
                    this.c.post(new ag(this, i2, i3));
                    break;
                case 40:
                    this.c.post(new af(this, i2, i3, i4));
                    break;
            }
        }
        return 0;
    }

    public int notifyError(int i, int i2, int i3, int i4) {
        Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] event(%d) Param(%d %d) ", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4)));
        return 0;
    }

    private void a() {
        if (true == this.k) {
            String language = KineMasterApplication.a().getResources().getConfiguration().locale.getLanguage();
            if (l == null || language != m) {
                m = language;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;
                l = BitmapFactory.decodeResource(KineMasterApplication.a().getResources(), R.drawable.km_watermark, options);
            }
            float b = this.i.b() / 1080.0f;
            float a2 = 0.96484375f * this.i.a();
            float b2 = 0.048611112f * this.i.b();
            this.i.a(l, a2 - (l.getWidth() * b), b2, a2, (l.getHeight() * b) + b2);
        }
    }

    public int callbackPrepareCustomLayer(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (this.h == null) {
            return 1;
        }
        this.i.g((i16 & 1) != 0);
        this.i.a(1280, 720);
        this.i.b(i17, i18);
        this.i.a(i2);
        this.i.u();
        this.h.a(this.i);
        a();
        this.i.v();
        return 0;
    }

    public void setCustomRenderCallback(NexEditor.d dVar) {
        this.h = dVar;
    }

    public int getLutTextWithID(int i, int i2) {
        ColorEffect findByLUTResourceID = ColorEffect.findByLUTResourceID(i);
        if (findByLUTResourceID == null || findByLUTResourceID.getLut() == null || this.i == null) {
            return 0;
        }
        return this.i.a(findByLUTResourceID.getLut(), i2);
    }

    public int getVignetteTexID(int i) {
        return this.i.a(ColorEffect.getBitmapForVignette(), i);
    }
}
