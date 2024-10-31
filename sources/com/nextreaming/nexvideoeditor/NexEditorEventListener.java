package com.nextreaming.nexvideoeditor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class NexEditorEventListener {

    /* renamed from: a */
    private static Bitmap f24604a = null;

    /* renamed from: b */
    private static String f24605b = "";

    /* renamed from: c */
    private NexEditor f24606c;

    /* renamed from: e */
    private Handler f24608e;
    private AudioManager i;
    private NexEditor.d j;
    public NexImageLoader mImage;

    /* renamed from: d */
    private ha f24607d = null;
    public AudioTrack mAudioTrack = null;

    /* renamed from: f */
    private NexEditor.PlayState f24609f = null;

    /* renamed from: g */
    private int f24610g = 0;

    /* renamed from: h */
    private boolean f24611h = false;
    private LayerRenderer k = new LayerRenderer();
    private boolean l = false;
    private boolean m = true;
    private ArrayList<a> n = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends AsyncTask<String, Void, NexImage> {

        /* renamed from: a */
        private String f24612a;

        private a() {
        }

        public void a(String str) {
            this.f24612a = str;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(NexImage nexImage) {
            NexEditorEventListener.this.n.remove(this);
        }

        /* synthetic */ a(NexEditorEventListener nexEditorEventListener, F f2) {
            this();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public NexImage doInBackground(String... strArr) {
            NexImage openThemeImage = NexEditorEventListener.this.mImage.openThemeImage(strArr[0]);
            if (openThemeImage == null) {
                return openThemeImage;
            }
            int width = openThemeImage.getWidth();
            int height = openThemeImage.getHeight();
            int loadedType = openThemeImage.getLoadedType();
            int[] iArr = new int[width * height];
            openThemeImage.getPixels(iArr);
            if (NexEditorEventListener.this.f24606c != null) {
                NexEditorEventListener.this.f24606c.a(strArr[0], iArr, width, height, loadedType);
            }
            return openThemeImage;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onCancelled(NexImage nexImage) {
            if (NexEditorEventListener.this.f24606c == null || this.f24612a == null) {
                return;
            }
            NexEditorEventListener.this.f24606c.b(this.f24612a);
        }
    }

    public NexEditorEventListener(NexEditor nexEditor, Context context, InterfaceC2350a interfaceC2350a, NexImageLoader.d dVar) {
        this.f24606c = null;
        this.mImage = null;
        this.f24608e = null;
        if (context != null) {
            this.i = (AudioManager) context.getApplicationContext().getSystemService("audio");
        } else {
            this.i = null;
        }
        this.f24606c = nexEditor;
        this.mImage = new NexImageLoader(context != null ? context.getResources() : null, interfaceC2350a, dVar, nexEditor.h(), nexEditor.f(), nexEditor.g());
        this.f24608e = new Handler(Looper.getMainLooper());
    }

    public int callbackCapture(int i, int i2, int i3, byte[] bArr) {
        this.f24608e.post(new F(this, i, i2, i3, bArr));
        return 0;
    }

    public int callbackCheckImageWorkDone() {
        return this.n.size();
    }

    public AudioManager callbackGetAudioManager() {
        return this.i;
    }

    public AudioTrack callbackGetAudioTrack(int i, int i2) {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            audioTrack.release();
        }
        int i3 = i2 != 1 ? 3 : 2;
        this.mAudioTrack = new AudioTrack(3, i, i3, 2, AudioTrack.getMinBufferSize(i, i3, 2), 1);
        return this.mAudioTrack;
    }

    public NexImage callbackGetImageUsingFile(String str, int i) {
        return this.mImage.openFile(str, i);
    }

    public NexImage callbackGetImageUsingText(String str) {
        return this.mImage.openFile(str, 0);
    }

    public byte[] callbackGetThemeFile(String str) {
        String str2;
        if (str.contains(".force_effect/")) {
            str = str.replace(".force_effect/", "/");
        }
        int indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            String substring = str.substring(0, indexOf);
            str2 = str.substring(indexOf + 1);
            str = substring;
        } else {
            str2 = "";
        }
        return this.mImage.callbackReadAssetItemFile(str, str2);
    }

    public NexImage callbackGetThemeImage(String str, int i) {
        if (i != 1 && i != 3) {
            return this.mImage.openThemeImage(str);
        }
        if (i == 3) {
            Iterator<a> it = this.n.iterator();
            while (it.hasNext()) {
                it.next().cancel(false);
            }
            this.n.clear();
        }
        a aVar = new a(this, null);
        aVar.a(str);
        this.n.add(aVar);
        aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str);
        return null;
    }

    public NexImage callbackGetThemeImageUsingResource(String str) {
        return this.mImage.openFile(str, 0);
    }

    public int callbackHighLightIndex(int i, int[] iArr) {
        Log.d("NexEditorEventHandler", "callbackHighLightIndex start iCount=" + i);
        this.f24608e.post(new aa(this, i, iArr));
        Log.d("NexEditorEventHandler", "callbackHighLightIndex end");
        return 0;
    }

    public int callbackHighLightIndexForVAS(int i, int[] iArr, int[] iArr2) {
        Log.d("NexEditorEventHandler", "callbackHighLightIndexForVAS start iCount=" + i);
        this.f24608e.post(new ba(this, i, iArr, iArr2));
        Log.d("NexEditorEventHandler", "callbackHighLightIndexForVAS end");
        return 0;
    }

    public int callbackPrepareCustomLayer(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (this.j == null) {
            return 1;
        }
        this.k.f((i16 & 1) != 0);
        this.k.a(EditorGlobal.n(), EditorGlobal.m());
        this.k.b(i17, i18);
        this.k.b(i2);
        this.k.r();
        this.j.a(this.k);
        a(c.d.b.b.i.d().h());
        this.k.q();
        return 0;
    }

    public void callbackReleaseAudioTrack() {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this.mAudioTrack = null;
        }
    }

    public void callbackReleaseImage() {
    }

    public int callbackThumb(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr) {
        Log.d("NexEditorEventHandler", "callbackThumb start iMode=" + i + ", iTime=" + i3 + ", iWidth=" + i4 + ", iHeight=" + i5 + ", iSize=" + i8 + ", tag=" + i2);
        this.f24608e.post(new Q(this, i, i3, i4, i5, i8, bArr, i6, i7, i2));
        Log.d("NexEditorEventHandler", "salabara callbackThumb end");
        return 0;
    }

    public String getAssetResourceKey(String str) {
        String substring = str.substring(12);
        int indexOf = substring.indexOf(47);
        if (indexOf < 0) {
            return str;
        }
        String substring2 = substring.substring(0, indexOf);
        String substring3 = substring.substring(indexOf + 1);
        com.nexstreaming.app.general.nexasset.assetpackage.r a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.a(KineMasterApplication.i().getApplicationContext()).a(substring2);
        if (a2 == null) {
            return str;
        }
        String str2 = "9v16";
        if (!substring2.contains("9v16")) {
            if (substring2.contains("2v1")) {
                str2 = "2v1";
            } else if (substring2.contains("1v2")) {
                str2 = "1v2";
            } else if (substring2.contains("1v1")) {
                str2 = "1v1";
            } else if (substring2.contains("4v3")) {
                str2 = "4v3";
            } else {
                str2 = substring2.contains("3v4") ? "3v4" : "16v9";
            }
        }
        return "[ThemeImage]" + a2.getAssetPackage().getAssetId() + "/" + str2 + "/" + substring3;
    }

    public int getLutTextWithID(int i, int i2) {
        LayerRenderer layerRenderer;
        ColorEffect findByLUTResourceID = ColorEffect.findByLUTResourceID(i);
        if (findByLUTResourceID == null || findByLUTResourceID.getLut() == null || (layerRenderer = this.k) == null) {
            return 0;
        }
        return layerRenderer.a(findByLUTResourceID.getLut(), i2);
    }

    public int getVignetteTexID(int i) {
        return this.k.a(ColorEffect.getBitmapForVignette(), i);
    }

    public synchronized void ignoreEventsUntilTag(int i) {
        if (!this.f24611h) {
            this.f24611h = true;
            this.f24610g = i;
        } else if (this.f24610g < i) {
            this.f24610g = i;
        }
    }

    public int notifyError(int i, int i2, int i3, int i4) {
        Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] event(%d) Param(%d %d) ", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4)));
        return 0;
    }

    public int notifyEvent(int i, int i2, int i3, int i4, int i5) {
        if (i == 18) {
            b(i2);
            this.f24608e.post(new ca(this, i2));
        }
        if (this.f24611h) {
            return 0;
        }
        if (i != 0) {
            if (i == 1) {
                this.f24608e.post(new ea(this, i2));
            } else if (i == 5) {
                this.f24608e.post(new fa(this, i2, i3, i4, i5));
            } else if (i == 6) {
                this.f24608e.post(new ga(this, i2, i3));
            } else if (i == 7) {
                this.f24608e.post(new RunnableC2370v(this, i2));
            } else if (i != 8) {
                if (i == 10) {
                    this.f24608e.post(new RunnableC2373y(this, i2, i3, i4, i5));
                } else if (i == 11) {
                    this.f24608e.post(new B(this, i2, i3, i4, i5));
                } else if (i == 13) {
                    this.f24608e.post(new RunnableC2371w(this));
                } else if (i == 14) {
                    this.f24608e.post(new RunnableC2372x(this, i2));
                } else if (i == 17) {
                    this.f24608e.post(new A(this));
                } else if (i == 51) {
                    Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_PREVIEW_PEAKMETER cts=" + i2 + ", left=" + i3 + ", right=" + i4);
                    this.f24608e.post(new V(this, i2, i3, i4));
                } else if (i != 5001) {
                    switch (i) {
                        case 19:
                            Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] VIDEO_STARTED ", new Object[0]));
                            this.f24608e.post(new C(this));
                            break;
                        case 20:
                            this.f24608e.post(new J(this, i2, i3));
                            Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_GETCLIPINFO_DONE p1=" + i2, new Object[0]));
                            break;
                        case 21:
                            Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_CAPTURE_DONE p1=" + i2, new Object[0]));
                            this.f24608e.post(new D(this, i2));
                            break;
                        case 22:
                            Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_PREPARE_CLIP_LOADING p1=" + i2, new Object[0]));
                            break;
                        case 23:
                            this.f24608e.post(new G(this, i2, i3));
                            break;
                        case 24:
                            this.f24608e.post(new E(this, i2, i3, i4));
                            break;
                        default:
                            switch (i) {
                                case 26:
                                    this.f24608e.post(new L(this, i2));
                                    break;
                                case 27:
                                    Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_MAKE_HIGHLIGHT_DONE errcode=" + i2);
                                    this.f24608e.post(new W(this, i2));
                                    break;
                                case 28:
                                    Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_MAKE_HIGHLIGHT_PROGRESS_INDEX=" + i2 + ", p2=" + i3);
                                    this.f24608e.post(new U(this, i2, i3));
                                    break;
                                default:
                                    switch (i) {
                                        case 30:
                                            Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_CHECK_DIRECT_EXPORT p1=" + i2);
                                            this.f24608e.post(new M(this, i2, i3));
                                            break;
                                        case 31:
                                            Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_DIRECT_EXPORT_DONE p1=" + i2);
                                            this.f24608e.post(new N(this, i2));
                                            break;
                                        case 32:
                                            Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_DIRECT_EXPORT_PROGRESS=" + i2);
                                            break;
                                        case 33:
                                            this.f24608e.post(new K(this, i2, i3));
                                            Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_GETCLIPINFO_STOP_DONE p1=" + i2, new Object[0]));
                                            break;
                                        case 34:
                                            this.f24608e.post(new RunnableC2374z(this, i2));
                                            break;
                                        case 35:
                                            Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_FAST_PREVIEW_START_DONE p1= " + i2 + ", p2= " + i3 + ", p3: " + i4);
                                            this.f24608e.post(new P(this, i2, i3, i4));
                                            break;
                                        case 36:
                                            Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_FAST_PREVIEW_STOP_DONE p1= " + i2);
                                            this.f24608e.post(new S(this, i2));
                                            break;
                                        case 37:
                                            Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_FAST_PREVIEW_TIME_DONE p1= " + i2);
                                            this.f24608e.post(new T(this, i2));
                                            break;
                                        case 38:
                                            Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_HIGHLIGHT_THUMBNAIL_PROGRESS=" + i2 + ", p2=" + i3);
                                            this.f24608e.post(new O(this, i2, i3));
                                            break;
                                        case 39:
                                            Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_MAKE_REVERSE_DONE p1= " + i2 + ", p2= " + i3);
                                            this.f24608e.post(new I(this, i2, i3));
                                            break;
                                        case 40:
                                            Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_MAKE_REVERSE_PROGRESS p1= " + i2 + ", p2= " + i3 + ", p3: " + i4);
                                            this.f24608e.post(new H(this, i2, i3, i4));
                                            break;
                                        case 41:
                                            Log.i("NexEditorEventHandler", "[nexEditorEventHandler.java] VIDEOEDITOR_EVENT_MAKE_VAS_HIGHLIGHT_DONE errcode=" + i2);
                                            this.f24608e.post(new X(this, i2));
                                            break;
                                        default:
                                            Log.i("NexEditorEventHandler", String.format("[nexEditorEventHandler.java] not implement event(%d) Param(%d %d %d %d) ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
                                            break;
                                    }
                            }
                    }
                } else {
                    this.f24608e.post(new Y(this, i2, i3, i4, i5));
                }
            }
        } else if (this.l) {
            NexEditor.PlayState fromValue = NexEditor.PlayState.fromValue(i2);
            NexEditor.PlayState fromValue2 = NexEditor.PlayState.fromValue(i3);
            if (fromValue2 == NexEditor.PlayState.RESUME) {
                fromValue2 = NexEditor.PlayState.RECORD;
            }
            a(fromValue, fromValue2);
        } else {
            this.f24608e.post(new da(this, i2, i3));
        }
        return 0;
    }

    public void setContext(Context context) {
        this.mImage.setResources(context == null ? null : context.getApplicationContext().getResources());
        if (context != null) {
            this.i = (AudioManager) context.getApplicationContext().getSystemService("audio");
        } else {
            this.i = null;
        }
    }

    public void setCustomRenderCallback(NexEditor.d dVar) {
        this.j = dVar;
    }

    public void setSyncMode(boolean z) {
        this.l = z;
    }

    public void setUIListener(ha haVar) {
        this.f24607d = haVar;
        NexEditor.PlayState playState = this.f24609f;
        if (playState != null) {
            this.f24607d.a(NexEditor.PlayState.NONE, playState);
        }
    }

    public void setWatermark(boolean z) {
        this.m = z;
    }

    private synchronized void b(int i) {
        if (this.f24611h && i >= this.f24610g) {
            this.f24611h = false;
        }
    }

    public void a(NexEditor.PlayState playState, NexEditor.PlayState playState2) {
        if (this.f24609f != playState2) {
            this.f24609f = playState2;
            ha haVar = this.f24607d;
            if (haVar != null) {
                haVar.a(playState, playState2);
            }
            if (playState2 == NexEditor.PlayState.IDLE) {
                this.f24606c.n();
            }
            if (playState == null || playState == NexEditor.PlayState.NONE) {
                return;
            }
            int i = Z.f24685a[playState2.ordinal()];
            if (i != 1 && i != 2) {
                this.f24606c.f(NexEditor.b.f24591b);
            } else {
                this.f24606c.d(NexEditor.b.f24591b);
            }
        }
    }

    private void a(int i) {
        if (true == this.m) {
            String language = KineMasterApplication.i().getResources().getConfiguration().locale.getLanguage();
            String[] strArr = {"EDC38BAB01415D93BAD05340E2A391E0", "89CC5C88FFA52362EC5BBAE233EAC448", "76EAAAD7634A46D3B5A22C50792EFFFF", "87B7DABA860041CF110DDE5A4E50B4A4", "6D1D7829E70A7F13178CCD91CB0B8F9D"};
            if (f24604a == null || !language.equals(f24605b)) {
                f24605b = language;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;
                Bitmap decodeResource = BitmapFactory.decodeResource(KineMasterApplication.i().getResources(), R.drawable.km_watermark, options);
                decodeResource.getPixels(new int[decodeResource.getWidth() * decodeResource.getHeight()], 0, decodeResource.getWidth(), 0, 0, decodeResource.getWidth(), decodeResource.getHeight());
                f24604a = decodeResource;
            }
            float width = f24604a.getWidth();
            float height = f24604a.getHeight();
            float f2 = this.k.k() > this.k.j() ? 0.25f : 0.35f;
            if (Resources.getSystem().getConfiguration().locale.toString().startsWith("zh")) {
                f2 = this.k.k() > this.k.j() ? 0.15f : 0.25f;
            }
            float k = (int) (this.k.k() * f2);
            float f3 = width * (k / height);
            float f4 = Resources.getSystem().getConfiguration().locale.toString().startsWith("zh") ? 0.5f : 0.15f;
            float f5 = i;
            float f6 = ((f3 * f4) * f5) / 100.0f;
            float f7 = ((k * f4) * f5) / 100.0f;
            float k2 = this.k.k();
            float f8 = (this.k.k() > this.k.j() ? 0.025f : 0.035f) * k2;
            float f9 = (k2 - f6) - f8;
            try {
                this.k.a(f24604a, f9, f8, f9 + f6, f8 + f7);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }
}
