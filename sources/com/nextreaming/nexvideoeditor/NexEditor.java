package com.nextreaming.nexvideoeditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.ImageReader;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.widget.ActivityChooserView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccolorformat.ColorFormatChecker;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class NexEditor {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f24582a = false;

    /* renamed from: b, reason: collision with root package name */
    private static NexEditor f24583b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f24584c = false;

    /* renamed from: d, reason: collision with root package name */
    private static final ExecutorService f24585d = Executors.newSingleThreadExecutor();

    /* renamed from: e, reason: collision with root package name */
    private static final g f24586e = new C2355f();
    private k Ha;
    private int K;
    private int L;
    private int M;
    private int Q;
    private Surface R;
    private i S;
    private n Z;
    private j aa;
    private s ba;
    private l da;
    private m ea;
    private t fa;
    private NexEditorEventListener i;
    private ResultTask<Rect> ia;
    private NexThemeView j;
    private int na;
    private String ra;
    private int ta;

    /* renamed from: f, reason: collision with root package name */
    private int f24587f = 1;

    /* renamed from: g, reason: collision with root package name */
    private boolean f24588g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f24589h = false;
    private ha k = null;
    private v[] l = null;
    private a[] m = null;
    private a[] n = null;
    private boolean o = false;
    private Deque<e> p = new LinkedList();
    private Deque<e> q = new LinkedList();
    private Deque<h> r = new LinkedList();
    private Deque<o> s = new LinkedList();
    private Deque<q> t = new LinkedList();
    private Deque<g> u = new LinkedList();
    private Deque<p> v = new LinkedList();
    private Deque<p> w = new LinkedList();
    private Deque<g> x = new LinkedList();
    private Deque<g> y = new LinkedList();
    private Deque<Integer> z = new LinkedList();
    private Deque<Task> A = new ArrayDeque();
    private Deque<f> B = new LinkedList();
    private Deque<Object> C = new LinkedList();
    private r D = null;
    private int E = 1;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private b I = null;
    private int J = 0;
    private ColorFormatChecker.ColorFormat N = null;
    private int O = 0;
    private String P = null;
    private NexVisualClipChecker T = null;
    private int U = 1;
    private int V = 0;
    private int W = -1;
    private Thread X = null;
    private Task Y = null;
    private Task ca = null;
    private boolean ga = false;
    private boolean ha = false;
    private SurfaceHolder.Callback ja = new SurfaceHolderCallbackC2359j(this);
    private boolean ka = false;
    private boolean la = false;
    private boolean ma = false;
    private int oa = 0;
    private boolean pa = false;
    private boolean qa = false;
    private Task sa = null;
    private ImageReader ua = null;
    private BlockingQueue<Integer> va = new ArrayBlockingQueue(3);
    private boolean wa = false;
    private x xa = null;
    private Object ya = new Object();
    private boolean za = false;
    private boolean Aa = false;
    private int Ba = 0;
    private int Ca = 0;
    private boolean Da = false;
    private int Ea = 0;
    private int Fa = 0;
    private Object Ga = new Object();
    private float Ia = 1.0f;

    /* loaded from: classes3.dex */
    public enum EngineVersion {
        MAJOR(1),
        MINOR(2),
        PATCH(3),
        BUILD(4);

        private int versionType;

        EngineVersion(int i) {
            this.versionType = i;
        }
    }

    /* loaded from: classes3.dex */
    public enum FastPreviewOption {
        normal,
        brightness,
        contrast,
        saturation,
        tintColor,
        left,
        top,
        right,
        bottom,
        nofx,
        cts,
        swapv,
        video360flag,
        video360_horizontal,
        video360_vertical
    }

    /* loaded from: classes3.dex */
    public enum PerformanceCounter {
        FRAME_DROP(0),
        FRAME_WAIT_TIMEOUT(1);

        private final int value;

        PerformanceCounter(int i) {
            this.value = i;
        }

        public long get() {
            return NexEditor.getPerformanceCount(this.value);
        }

        public long since(u uVar) {
            return get() - uVar.f24602a[ordinal()];
        }

        public long get(u uVar) {
            if (uVar == null) {
                return 0L;
            }
            return uVar.f24603b[ordinal()];
        }
    }

    /* loaded from: classes3.dex */
    public enum PlayState {
        NONE(0),
        IDLE(1),
        RUN(2),
        RECORD(3),
        PAUSE(4),
        RESUME(5);

        private int mValue;

        PlayState(int i) {
            this.mValue = i;
        }

        public static PlayState fromValue(int i) {
            for (PlayState playState : values()) {
                if (playState.getValue() == i) {
                    return playState;
                }
            }
            return null;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends w {
    }

    /* loaded from: classes3.dex */
    public interface c {
        c a(int i);

        c a(Rect rect);

        c a(FastPreviewOption fastPreviewOption, int i);

        c a(boolean z);

        void a();

        void execute();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(LayerRenderer layerRenderer);
    }

    /* loaded from: classes3.dex */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        int f24598a;

        public abstract void a(int i, int i2, int i3);

        public abstract void a(b bVar);
    }

    /* loaded from: classes3.dex */
    public static abstract class f {
        public abstract void a(Bitmap bitmap);

        public abstract void a(b bVar);
    }

    /* loaded from: classes3.dex */
    public static abstract class g {

        /* renamed from: a, reason: collision with root package name */
        private int f24599a;

        public abstract void a(b bVar);
    }

    /* loaded from: classes3.dex */
    public static abstract class h {
        public abstract void a();

        public abstract void a(b bVar);
    }

    /* loaded from: classes3.dex */
    public interface i {
        void a(int i, int i2, int i3, int i4);
    }

    /* loaded from: classes3.dex */
    public interface j {
    }

    /* loaded from: classes3.dex */
    public interface k {
        void a(b bVar, int i);
    }

    /* loaded from: classes3.dex */
    public interface l {
        void a(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7, int i8);
    }

    /* loaded from: classes3.dex */
    public interface m {
        int a(int i);

        int a(int i, int[] iArr);
    }

    /* loaded from: classes3.dex */
    public interface n {
        void a();
    }

    /* loaded from: classes3.dex */
    public static abstract class o {
        public abstract void a(int i);

        public abstract void a(b bVar);
    }

    /* loaded from: classes3.dex */
    public static abstract class p {
        public abstract void a();

        public abstract void a(b bVar);
    }

    /* loaded from: classes3.dex */
    public static abstract class q {

        /* renamed from: a, reason: collision with root package name */
        private int f24600a;

        /* renamed from: b, reason: collision with root package name */
        private int f24601b;

        public abstract void a(int i, int i2);

        public abstract void a(b bVar);
    }

    /* loaded from: classes3.dex */
    public static abstract class r {
        public abstract void a();
    }

    /* loaded from: classes3.dex */
    public interface s {
        void a(int i, int i2, int i3);

        void a(b bVar, int i);
    }

    /* loaded from: classes3.dex */
    public interface t {
        int a(int i);

        int a(int i, int[] iArr, int[] iArr2);
    }

    /* loaded from: classes3.dex */
    public static class v extends w {
    }

    /* loaded from: classes3.dex */
    public static abstract class w {
    }

    /* loaded from: classes3.dex */
    public static abstract class x {
    }

    static {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                System.loadLibrary("nexeditorsdk");
            } catch (UnsatisfiedLinkError e2) {
                Log.e("NexEditor.java", "[NexEditor.java] nexeditor load failed : " + e2);
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public NexEditor(Context context, NexThemeView nexThemeView, String str, int i2, NexImageLoader.d dVar, int[] iArr) throws EditorInitException {
        String str2;
        boolean z = true;
        this.i = null;
        this.j = null;
        f24583b = this;
        int i3 = i2 ^ 323655054;
        if (context.getFilesDir() != null) {
            String findLibrary = ((BaseDexClassLoader) context.getClassLoader()).findLibrary("nexcralbody_mc_jb");
            if (findLibrary != null) {
                str2 = findLibrary.substring(0, findLibrary.lastIndexOf(File.separator)) + File.separator;
            } else {
                String str3 = context.getApplicationInfo().nativeLibraryDir;
                str3 = str3.endsWith(File.separator) ? str3 : str3 + File.separator;
                if (!new File(str3, "libnexeditorsdk.so").exists()) {
                    String property = System.getProperty("java.library.path");
                    if (property != null) {
                        String[] split = property.split(":");
                        for (int i4 = 0; i4 < split.length; i4++) {
                            if (!split[i4].endsWith("/")) {
                                split[i4] = split[i4] + "/";
                            }
                            if (new File(split[i4], "libnexeditorsdk.so").exists()) {
                                str3 = split[i4];
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                        String str4 = "/system/lib64/";
                        if (!str3.contains("/arm64") && !str3.contains("/x86_64")) {
                            str4 = "/system/lib/";
                        }
                        new File(str4, "libnexeditorsdk.so").exists();
                        str2 = str4;
                    }
                }
                str2 = str3;
            }
            c(context.getPackageName());
            check4km(context);
            int createEditor = createEditor(str2, str, Build.VERSION.SDK_INT, initUserData() ^ i3, iArr == null ? null : Arrays.copyOf(iArr, iArr.length + 2));
            if (createEditor == 0) {
                b(-1, -1, -1);
                setProperty("FeatureVersion", "3");
                setProperty("DeviceExtendMode", "1");
                setProperty("InputMaxFPS", "" + NexEditorDeviceProfile.getDeviceProfile().getMaxSupportedFPS(1280, 720));
                setProperty("UseAndroidJPEG", NexEditorDeviceProfile.getDeviceProfile().getUseAndroidJPEGDecoder() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                setProperty("WaitGLRenderFinish", NexEditorDeviceProfile.getDeviceProfile().getWaitToGLFinish() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                setProperty("SupportFrameTimeChecker", NexEditorDeviceProfile.getDeviceProfile().getSupportFrameTimeChecker() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                int i5 = 1024;
                while (true) {
                    int i6 = i5 * 2;
                    if (i6 >= Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)) {
                        break;
                    } else {
                        i5 = i6;
                    }
                }
                this.K = i5;
                this.L = i5;
                this.M = i5 * i5;
                setProperty("JpegMaxWidthFactor", "" + this.K);
                setProperty("JpegMaxHeightFactor", "" + this.K);
                setProperty("JpegMaxSizeFactor", "" + this.M);
                setProperty("supportContentDuration", "100");
                String a2 = a("ro.product.model");
                if (a2 != null && a2.toUpperCase().startsWith("VTR-AL00")) {
                    setProperty("HDR2SDR", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                NexThemeView nexThemeView2 = this.j;
                if (nexThemeView2 != nexThemeView) {
                    if (nexThemeView2 != null) {
                        nexThemeView2.a((NexEditor) null);
                    }
                    nexThemeView.a(this);
                    this.j = nexThemeView;
                }
                this.i = new NexEditorEventListener(this, context, com.nexstreaming.app.general.nexasset.assetpackage.h.a(context).f(), dVar);
                setEventHandler(this.i);
                return;
            }
            throw new EditorInitException("Editor Initialization Failed (result=" + createEditor + ")");
        }
        throw new IllegalStateException("No files directory - cannot play video - relates to Android issue: 8886!");
    }

    private native int asyncLoadList(NexVisualClip[] nexVisualClipArr, NexAudioClip[] nexAudioClipArr, int i2);

    private native int captureCurrentFrame();

    private native int check4km(Context context);

    private native int clearRenderItems(int i2);

    private native int clearScreen(int i2);

    private native void closeOutputFile(int i2);

    private native int createEditor(String str, String str2, int i2, int i3, int[] iArr);

    private native int createRenderItem(String str, int i2);

    private native int drawRenderItemOverlay(int i2, int i3, String str, int i4, int i5, int i6, int i7, float[] fArr, float f2, float f3, float f4, float f5, float f6, boolean z);

    private native int encodeProject(String str, int i2, int i3, int i4, long j2, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14);

    private native int fastOptionPreview(String str, int i2);

    private native int getClipAudioThumb(String str, String str2, int i2);

    private native int getClipVideoThumb(String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long getPerformanceCount(int i2);

    private static native String getSystemProperty(String str);

    private native int getTexNameForBlend(int i2);

    private native int getTexNameForClipID(int i2, int i3);

    private native int getTexNameForMask(int i2);

    private native int initUserData();

    private native int loadRenderItem(String str, String str2, int i2);

    private native int loadTheme(String str, String str2, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int prepareSurface(Surface surface);

    private native int pushLoadedBitmap(String str, int[] iArr, int i2, int i3, int i4);

    private native int releaseRenderItem(int i2, int i3);

    private native int removeBitmap(String str);

    private native int setEventHandler(NexEditorEventListener nexEditorEventListener);

    private static native void setPacakgeName4Protection(String str);

    private native int setPreviewScaleFactor(float f2);

    private native int setRenderToDefault(int i2);

    private native int setRenderToMask(int i2);

    private native int setTexNameForLUT(int i2, int i3, float f2, float f3);

    private native int setTime(int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public native int startPlay(int i2);

    private native int stopPlay(int i2);

    private native int swapBlendMain(int i2);

    private native int transcodingStart(String str, String str2, int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8, String str3);

    private native int transcodingStop();

    private void u() {
        String str = this.ra;
        if (str == null || !str.contains("writefd://")) {
            return;
        }
        closeOutputFile(Integer.parseInt(this.ra.substring(10)));
        this.ra = null;
    }

    private void v() {
        for (q qVar : this.t) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task w() {
        if (this.ca == null) {
            this.ca = new Task();
        }
        return this.ca;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<Rect> x() {
        if (this.ia == null) {
            this.ia = new ResultTask<>();
        }
        return this.ia;
    }

    public native int addUDTA(int i2, String str);

    public native int clearTrackCache();

    public native int clearUDTA();

    public native int closeProject();

    public native int createProject();

    public native int endVoiceRecorder(NexClipInfo nexClipInfo);

    public native int getClipInfoSync(String str, NexClipInfo nexClipInfo, int i2, int i3);

    public native String getProperty(String str);

    public native int getVersionNumber(int i2);

    public boolean l() {
        return this.ga || this.ha;
    }

    public int m(int i2) {
        return setRenderToDefault(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        n nVar = this.Z;
        if (nVar != null) {
            nVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        this.qa = false;
        if (this.w.size() < 1) {
            return;
        }
        this.w.remove().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        a(0, 0, b.Ta);
    }

    public native int processVoiceRecorder(byte[] bArr, int i2);

    public void q() {
        this.T = null;
    }

    public void r() {
        a(0, new C2353d(this));
    }

    public native int reverseStart(String str, String str2, String str3, int i2, int i3, int i4, long j2, int i5, int i6, int i7);

    public native int reverseStop();

    public void s() {
        a(new C2369u(this));
    }

    public native int setProjectEffect(String str);

    public native int setProjectManualVolumeControl(int i2);

    public native int setProjectVolume(int i2);

    public native int setProjectVolumeFade(int i2, int i3);

    public native int setProperty(String str, String str2);

    public native int startVoiceRecorder(String str, int i2, int i3, int i4);

    public b t() {
        if (this.ga) {
            return b.a(transcodingStop());
        }
        if (this.ha) {
            return b.a(reverseStop());
        }
        return b.f24594e;
    }

    /* loaded from: classes3.dex */
    public static class b implements Task.TaskError, DiagnosticLogger.a {
        private final boolean Fb;
        private final int Gb;
        private final String Hb;
        private final int Ib;
        private final String Jb;

        /* renamed from: a, reason: collision with root package name */
        private static SparseArray<b> f24590a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        public static final b f24591b = new b("NONE", 0);

        /* renamed from: c, reason: collision with root package name */
        public static final b f24592c = new b("GENERAL", 1);

        /* renamed from: d, reason: collision with root package name */
        public static final b f24593d = new b("UNKNOWN", 2);

        /* renamed from: e, reason: collision with root package name */
        public static final b f24594e = new b("NO_ACTION", 3);

        /* renamed from: f, reason: collision with root package name */
        public static final b f24595f = new b("INVALID_INFO", 4);

        /* renamed from: g, reason: collision with root package name */
        public static final b f24596g = new b("INVALID_STATE", 5);

        /* renamed from: h, reason: collision with root package name */
        public static final b f24597h = new b("VERSION_MISMATCH", 6);
        public static final b i = new b("CREATE_FAILED", 7);
        public static final b j = new b("MEMALLOC_FAILED", 8, "Memory allocation failed", R.string.engine_error_memalloc_failed);
        public static final b k = new b("ARGUMENT_FAILED", 9);
        public static final b l = new b("NOT_ENOUGH_NEMORY", 10, "Insufficient memory", R.string.engine_error_not_enough_memory);
        public static final b m = new b("EVENTHANDLER", 11);
        public static final b n = new b("FILE_IO_FAILED", 12, "Error accessing file", R.string.engine_error_fileio_fail);
        public static final b o = new b("FILE_INVALID_SYNTAX", 13);
        public static final b p = new b("FILEREADER_CREATE_FAIL", 14, "Could not open file", R.string.engine_error_filereader_create_fail);
        public static final b q = new b("FILEWRITER_CREATE_FAIL", 15);
        public static final b r = new b("AUDIORESAMPLER_CREATE_FAIL", 16);
        public static final b s = new b("UNSUPPORT_FORMAT", 17, "Unsupported format", R.string.engine_error_unsupported_format);
        public static final b t = new b("FILEREADER_FAILED", 18, "Error reading file format", R.string.engine_error_filereader_fail);
        public static final b u = new b("PLAYSTART_FAILED", 19);
        public static final b v = new b("PLAYSTOP_FAILED", 20);
        public static final b w = new b("PROJECT_NOT_CREATE", 21);
        public static final b x = new b("PROJECT_NOT_OPEN", 22);
        public static final b y = new b("CODEC_INIT", 23, "Codec init failed", R.string.engine_error_codec_init_failed);
        public static final b z = new b("RENDERER_INIT", 24);
        public static final b A = new b("THEMESET_CREATE_FAIL", 25);
        public static final b B = new b("ADD_CLIP_FAIL", 26, "Unable to add clip", R.string.engine_error_add_clip_failed);
        public static final b C = new b("ENCODE_VIDEO_FAIL", 27);
        public static final b D = new b("INPROGRESS_GETCLIPINFO", 28);
        public static final b E = new b("THUMBNAIL_BUSY", 29);
        public static final b F = new b("UNSUPPORT_MIN_DURATION", 30);
        public static final b G = new b("UNSUPPORT_MAX_RESOLUTION", 31);
        public static final b H = new b("UNSUPPORT_MIN_RESOLUTION", 32);
        public static final b I = new b("UNSUPPORT_VIDEIO_PROFILE", 33);
        public static final b J = new b("UNSUPPORT_VIDEO_LEVEL", 34);
        public static final b K = new b("UNSUPPORT_VIDEO_FPS", 35);
        public static final b L = new b("TRANSCODING_BUSY", 36);
        public static final b M = new b("TRANSCODING_NOT_SUPPORTED_FORMAT", 37);
        public static final b N = new b("TRANSCODING_USER_CANCEL", 38);
        public static final b O = new b("TRANSCODING_NOT_ENOUGHT_DISK_SPACE", 39);
        public static final b P = new b("TRANSCODING_CODEC_FAILED", 40);
        public static final b Q = new b("EXPORT_WRITER_INVAILED_HANDLE", 41);
        public static final b R = new b("EXPORT_WRITER_INIT_FAIL", 42);
        public static final b S = new b("EXPORT_WRITER_START_FAIL", 43);
        public static final b T = new b("EXPORT_AUDIO_DEC_INIT_FAIL", 44);
        public static final b U = new b("EXPORT_VIDEO_DEC_INIT_FAIL", 45);
        public static final b V = new b("EXPORT_VIDEO_ENC_FAIL", 46);
        public static final b W = new b("EXPORT_VIDEO_RENDER_INIT_FAIL", 47);
        public static final b X = new b("EXPORT_NOT_ENOUGHT_DISK_SPACE", 48, "Not enough space", R.string.fail_enospc);
        public static final b Y = new b("UNSUPPORT_AUDIO_PROFILE", 49);
        public static final b Z = new b("THUMBNAIL_INIT_FAIL", 50);
        public static final b aa = new b("UNSUPPORT_AUDIO_CODEC", 51);
        public static final b ba = new b("UNSUPPORT_VIDEO_CODEC", 52);
        public static final b ca = new b("HIGHLIGHT_FILEREADER_INIT_ERROR", 53);
        public static final b da = new b("HIGHLIGHT_TOO_SHORT_CONTENTS", 54);
        public static final b ea = new b("HIGHLIGHT_CODEC_INIT_ERROR", 55);
        public static final b fa = new b("HIGHLIGHT_CODEC_DECODE_ERROR", 56);
        public static final b ga = new b("HIGHLIGHT_RENDER_INIT_ERROR", 57);
        public static final b ha = new b("HIGHLIGHT_WRITER_INIT_ERROR", 58);
        public static final b ia = new b("HIGHLIGHT_WRITER_WRITE_ERROR", 59);
        public static final b ja = new b("HIGHLIGHT_GET_INDEX_ERROR", 60);
        public static final b ka = new b("HIGHLIGHT_USER_CANCEL", 61);
        public static final b la = new b("GETCLIPINFO_USER_CANCEL", 62);
        public static final b ma = new b("DIRECTEXPORT_CLIPLIST_ERROR", 63);
        public static final b na = new b("DIRECTEXPORT_CHECK_ERROR", 64);
        public static final b oa = new b("DIRECTEXPORT_FILEREADER_INIT_ERROR", 65);
        public static final b pa = new b("DIRECTEXPORT_FILEWRITER_INIT_ERROR", 66);
        public static final b qa = new b("DIRECTEXPORT_DEC_INIT_ERROR", 67);
        public static final b ra = new b("DIRECTEXPORT_DEC_INIT_SURFACE_ERROR", 68);
        public static final b sa = new b("DIRECTEXPORT_DEC_DECODE_ERROR", 69);
        public static final b ta = new b("DIRECTEXPORT_ENC_INIT_ERROR", 70);
        public static final b ua = new b("DIRECTEXPORT_ENC_ENCODE_ERROR", 71);
        public static final b va = new b("DIRECTEXPORT_ENC_INPUT_SURFACE_ERROR", 72);
        public static final b wa = new b("DIRECTEXPORT_ENC_FUNCTION_ERROR", 73);
        public static final b xa = new b("DIRECTEXPORT_ENC_DSI_DIFF_ERROR", 74);
        public static final b ya = new b("DIRECTEXPORT_ENC_FRAME_CONVERT_ERROR", 75);
        public static final b za = new b("DIRECTEXPORT_RENDER_INIT_ERROR", 76);
        public static final b Aa = new b("DIRECTEXPORT_WRITER_WRITE_ERROR", 77);
        public static final b Ba = new b("DIRECTEXPORT_WRITER_UNKNOWN_ERROR", 78);
        public static final b Ca = new b("FASTPREVIEW_USER_CANCEL", 79);
        public static final b Da = new b("FASTPREVIEW_CLIPLIST_ERROR", 80);
        public static final b Ea = new b("FASTPREVIEW_FIND_CLIP_ERROR", 81);
        public static final b Fa = new b("FASTPREVIEW_FIND_READER_ERROR", 82);
        public static final b Ga = new b("FASTPREVIEW_VIDEO_RENDERER_ERROR", 83);
        public static final b Ha = new b("FASTPREVIEW_DEC_INIT_SURFACE_ERROR", 84);
        public static final b Ia = new b("HW_NOT_ENOUGH_MEMORY", 85);
        public static final b Ja = new b("EXPORT_USER_CANCEL", 86);
        public static final b Ka = new b("FASTPREVIEW_DEC_INIT_ERROR", 87);
        public static final b La = new b("FASTPREVIEW_FILEREADER_INIT_ERROR", 88);
        public static final b Ma = new b("FASTPREVIEW_TIME_ERROR", 89);
        public static final b Na = new b("FASTPREVIEW_RENDER_INIT_ERROR", 90);
        public static final b Oa = new b("FASTPREVIEW_OUTPUTSURFACE_INIT_ERROR", 91);
        public static final b Pa = new b("ERROR_FASTPREVIEW_BUSY", 92);
        public static final b Qa = new b("ERROR_CODEC_DECODE", 93);
        public static final b Ra = new b("ERROR_AUDIO_RENDERER", 94);
        public static final b Sa = new b("IMAGE_PROCESS", 4097);
        public static final b Ta = new b("SET_TIME_IGNORED", 7001, false, "Set time ignored", R.string.error_settime_ignored);
        public static final b Ua = new b("SET_TIME_CANCELED", 7002, false, "Set time canceled", R.string.error_settime_canceled);
        public static final b Va = new b("CAPTURE_FAILED", 7003, false, "Capture failed", R.string.error_capture_failed);
        public static final b Wa = new b("SOURCE_FILE_NOT_FOUND", 7004, false);
        public static final b Xa = new b("TRANSCODING_ABORTED", 7005, false);
        public static final b Ya = new b("DESTINATION_FILE_ALREADY_EXISTS", 7006, false);
        public static final b Za = new b("TEMP_FILE_ALREADY_EXISTS", 7007, false);
        public static final b _a = new b("NO_INSTANCE_AVAILABLE", 7008, false);
        public static final b ab = new b("EXPORT_NO_SUCCESS", 7009, false);
        public static final b bb = new b("PLAY_SUPERCEEDED", 7010, false);
        public static final b cb = new b("WRAPPER_BUSY", 7011, false);
        public static final b db = new b("NOT_READY_TO_PLAY", 7012, false);
        public static final b eb = new b("SEEKING_LOCKED", 7013, false);
        public static final b fb = new b("NO_PROJECT_LOADED", 7014, false);
        public static final b gb = new b("ALREADY_EXPORTING", 7015, false);
        public static final b hb = new b("EMPTY_PROJECT", 7016, false);
        public static final b ib = new b("MISSING_RESOURCES", 7017, false);
        public static final b jb = new b("EXPORT_UNEXPECTED_STOP", 7018, false);
        public static final b kb = new b("PROJECT_LOAD_FAIL", 7019, false);
        public static final b lb = new b("RENAME_FAIL", 7020, false);
        public static final b mb = new b("FAST_PREVIEW_IGNORED", 7021, false);
        public static final b nb = new b("DUMMY_ERROR", 7022, false);
        public static final b ob = new b("CAPTURE_FAIL_ENOSPC", 7023, false, "Not enough space", R.string.fail_enospc);
        public static final b pb = new b("CAPTURE_FAIL_OTHER", 7024, false, "Capture failed", R.string.capture_fail_other);
        public static final b qb = new b("CAPTURE_FAIL_SCANNING", 7025, false, "Media scanner failed", R.string.capture_fail_other);
        public static final b rb = new b("UNRECOGNIZED_ERROR_CODE", 7026, false, "Unrecognized error code", R.string.error_unrecognized_code);
        public static final b sb = new b("EDITOR_INSTANCE_DESTROYED", 7027, false);
        public static final b tb = new b("FILE_MISSING", 7028, false);
        public static final b ub = new b("IN_SIM_PLAY", 7029, false);
        public static final b vb = new b("SAVE_NOT_ENOUGHT_DISK_SPACE", 7030, "Not enough space", R.string.fail_enospc);
        public static final b wb = new b("SAVE_FAILED", 7031);
        public static final b xb = new b("MEDIAINFO_EXCLUDED", 7032);
        public static final b yb = new b("BLACKLISTED", 7033);
        public static final b zb = new b("TEST_TIMEOUT", 7034);
        public static final b Ab = new b("MEDIAINFO_THUMBNAIL_EXCLUDED", 7035);
        public static final b Bb = new b("CLOUD_LOGIN_FAILED", io.fabric.sdk.android.a.b.c.MAX_BYTE_SIZE_PER_FILE);
        public static final b Cb = new b("CLOUD_LOGOUT_FAILED", 8001);
        public static final b Db = new b("CLOUD_FOLDER_CREATION_FAILED", 8002);
        public static final b Eb = new b("CLOUD_FILE_CREATION_FAILED", 8003);

        b(String str, int i2) {
            this.Gb = i2;
            this.Hb = null;
            this.Ib = 0;
            this.Fb = true;
            this.Jb = str;
            if (f24590a.get(i2) == null) {
                f24590a.put(i2, this);
                return;
            }
            throw new IllegalStateException();
        }

        public String a() {
            String str = this.Hb;
            return str == null ? d() : str;
        }

        public int b() {
            return this.Gb;
        }

        public boolean c() {
            return this != f24591b;
        }

        public String d() {
            return this.Jb;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return null;
        }

        @Override // com.nexstreaming.app.general.util.DiagnosticLogger.a
        public int getIntErrorCode() {
            return b();
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            return a(context);
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return a();
        }

        public String toString() {
            if (this == f24591b) {
                return "NONE(0)";
            }
            if (this.Gb != 0) {
                return d() + "(" + this.Gb + ")";
            }
            return d();
        }

        public String a(Context context) {
            if (this.Ib != 0) {
                return context.getResources().getString(this.Ib);
            }
            String str = this.Hb;
            return str == null ? d() : str;
        }

        public static b a(int i2) {
            b bVar = f24590a.get(i2);
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b("UNKNOWN_ERROR_" + i2, i2);
            f24590a.put(i2, bVar2);
            return bVar2;
        }

        b(String str, int i2, String str2, int i3) {
            this.Gb = i2;
            this.Hb = str2;
            this.Ib = i3;
            this.Fb = true;
            this.Jb = str;
            if (f24590a.get(i2) == null) {
                f24590a.put(i2, this);
                return;
            }
            throw new IllegalStateException();
        }

        b(String str, int i2, boolean z2, String str2, int i3) {
            this.Gb = 0;
            this.Hb = str2;
            this.Ib = i3;
            this.Fb = z2;
            this.Jb = str;
            if (f24590a.get(i2) == null) {
                f24590a.put(i2, this);
                return;
            }
            throw new IllegalStateException();
        }

        b(String str, int i2, boolean z2) {
            this.Gb = 0;
            this.Hb = null;
            this.Ib = 0;
            this.Fb = z2;
            this.Jb = str;
            if (f24590a.get(i2) == null) {
                f24590a.put(i2, this);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public int f() {
        return this.L;
    }

    public int g() {
        return this.M;
    }

    public int h() {
        return this.K;
    }

    public NexVisualClipChecker i() {
        if (this.T == null) {
            this.T = new NexVisualClipChecker(this);
        }
        return this.T;
    }

    public boolean j() {
        return this.la;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(int i2) {
        t tVar = this.fa;
        if (tVar != null) {
            tVar.a(i2);
        }
    }

    public void l(int i2) {
        a(i2, (q) null);
    }

    public void m() {
        r rVar = this.D;
        if (rVar != null) {
            rVar.a();
        }
    }

    /* loaded from: classes.dex */
    public static class EditorInitException extends Exception {
        private static final long serialVersionUID = 1;
        public final int errorCode;
        public final boolean hasErrorCode;

        public EditorInitException() {
            this.errorCode = 0;
            this.hasErrorCode = false;
        }

        public EditorInitException(String str, Throwable th) {
            super(str, th);
            this.errorCode = 0;
            this.hasErrorCode = false;
        }

        public EditorInitException(String str) {
            super(str);
            this.errorCode = 0;
            this.hasErrorCode = false;
        }

        public EditorInitException(String str, int i) {
            super(str);
            this.errorCode = i;
            this.hasErrorCode = true;
        }

        public EditorInitException(Throwable th) {
            super(th);
            this.errorCode = 0;
            this.hasErrorCode = false;
        }
    }

    public void b(int i2, int i3, int i4, int i5) {
        i iVar = this.S;
        if (iVar != null) {
            iVar.a(i2, i3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(b bVar, int i2) {
        if (this.ga || this.ha) {
            this.ga = false;
            this.ha = false;
            s sVar = this.ba;
            if (sVar != null) {
                sVar.a(bVar, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(b bVar) {
        if (this.sa != null && bVar.c()) {
            this.sa.sendFailure(bVar);
            this.sa = null;
            return;
        }
        this.f24588g = true;
        this.qa = false;
        if (this.v.size() < 1) {
            return;
        }
        p remove = this.v.remove();
        remove.a(bVar);
        if (bVar == b.f24591b) {
            this.w.add(remove);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(b bVar) {
        Log.w("NexEditor.java", "onPlayError:" + bVar);
        if (this.sa == null || !bVar.c()) {
            return;
        }
        this.sa.sendFailure(bVar);
        this.sa = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(b bVar) {
        this.f24588g = false;
        if (this.sa != null && bVar.c()) {
            this.sa.sendFailure(bVar);
            this.sa = null;
        }
        while (true) {
            g poll = this.u.poll();
            if (poll == null) {
                return;
            } else {
                poll.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i2) {
        if (this.A.size() > 0) {
            Task remove = this.A.remove();
            if (i2 == 0) {
                remove.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
            } else {
                remove.sendFailure(b.a(i2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(int i2) {
        h remove = this.r.remove();
        if (i2 == 0) {
            remove.a();
        } else {
            remove.a(b.a(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i2) {
        Task task = this.sa;
        if (task != null) {
            task.setProgress(Math.min(this.ta, i2), this.ta);
        }
        this.G = i2;
    }

    public int n(int i2) {
        return setRenderToMask(i2);
    }

    public boolean k() {
        return this.qa || this.pa;
    }

    /* loaded from: classes3.dex */
    public static class u {

        /* renamed from: a, reason: collision with root package name */
        private long[] f24602a;

        /* renamed from: b, reason: collision with root package name */
        private long[] f24603b;

        public u() {
            this.f24602a = new long[PerformanceCounter.values().length];
            this.f24603b = this.f24602a;
            for (PerformanceCounter performanceCounter : PerformanceCounter.values()) {
                this.f24602a[performanceCounter.ordinal()] = performanceCounter.get();
            }
        }

        public u(u uVar) {
            this.f24602a = new long[PerformanceCounter.values().length];
            this.f24603b = new long[PerformanceCounter.values().length];
            for (PerformanceCounter performanceCounter : PerformanceCounter.values()) {
                this.f24602a[performanceCounter.ordinal()] = uVar.f24602a[performanceCounter.ordinal()];
                this.f24603b[performanceCounter.ordinal()] = performanceCounter.get() - uVar.f24602a[performanceCounter.ordinal()];
            }
        }
    }

    public void b(int i2, int i3, int i4) {
        if (EditorGlobal.w()) {
            setProperty("HardWareCodecMemSize", String.valueOf(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
            setProperty("HardWareDecMaxCount", String.valueOf(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
            setProperty("HardWareEncMaxCount", String.valueOf(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
            return;
        }
        if (i2 <= -1) {
            if (!NexEditorDeviceProfile.getDeviceProfile().isUnknownDevice() && NexEditorDeviceProfile.getDeviceProfile().getSupportsVideoLayers(false)) {
                i2 = NexEditorDeviceProfile.getDeviceProfile().getHardwareDecMaxCount();
            } else {
                i2 = NexEditorDeviceProfile.getDeviceProfile().getHardwareDecMaxCount();
            }
        }
        if (i4 <= -1) {
            i4 = NexEditorDeviceProfile.getDeviceProfile().getHardwareCodecMemSize();
        }
        if (i3 <= -1) {
            i3 = NexEditorDeviceProfile.getDeviceProfile().getHardwareEncMaxCount();
        }
        setProperty("HardWareCodecMemSize", String.valueOf(i4));
        setProperty("HardWareDecMaxCount", String.valueOf(i2));
        setProperty("HardWareEncMaxCount", String.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i2) {
        m mVar = this.ea;
        if (mVar != null) {
            mVar.a(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(b bVar) {
        Task task;
        Task task2;
        if (bVar.c()) {
            Log.d("NexEditor.java", "onFastOptionPreviewDone:" + bVar.getMessage());
        }
        this.O--;
        if (this.I != b.f24591b) {
            if (this.O >= 1 || (task2 = this.ca) == null) {
                return;
            }
            task2.sendFailure(b.mb);
            this.ca = null;
            return;
        }
        String str = this.P;
        if (str != null && this.O < 2) {
            if (this.za) {
                Log.d("NexEditor.java", "onFastOptionPreviewDone: stat is seeking");
                this.P = null;
                return;
            }
            int fastOptionPreview = fastOptionPreview(str, this.Q);
            this.P = null;
            if (fastOptionPreview == 0) {
                this.O++;
                return;
            }
            Log.d("NexEditor.java", "onFastOptionPreviewDone: pending result=" + fastOptionPreview);
            return;
        }
        if (this.O >= 1 || (task = this.ca) == null) {
            return;
        }
        task.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
        this.ca = null;
    }

    public int e(int i2) {
        return getTexNameForMask(i2);
    }

    public HashMap<String, Integer> e() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int f2 = f(EngineVersion.MAJOR.versionType);
        int versionNumber = getVersionNumber(EngineVersion.MINOR.versionType);
        int versionNumber2 = getVersionNumber(EngineVersion.PATCH.versionType);
        int versionNumber3 = getVersionNumber(EngineVersion.BUILD.versionType);
        hashMap.put(EngineVersion.MAJOR.name(), Integer.valueOf(f2));
        hashMap.put(EngineVersion.MINOR.name(), Integer.valueOf(versionNumber));
        hashMap.put(EngineVersion.PATCH.name(), Integer.valueOf(versionNumber2));
        hashMap.put(EngineVersion.BUILD.name(), Integer.valueOf(versionNumber3));
        return hashMap;
    }

    public void a(i iVar) {
        this.S = iVar;
    }

    public int f(int i2) {
        int versionNumber = getVersionNumber(i2);
        if (versionNumber < 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("VERSION", "4.11.15.14242.GP");
            hashMap.put("MODEL", Build.MODEL);
            hashMap.put("MANUFACTURER", Build.MANUFACTURER);
            hashMap.put("PRODUCT", Build.PRODUCT);
            KMEvents.USER_VERSION.logEvent(hashMap);
        }
        return versionNumber;
    }

    public Task a(Context context) {
        if (this.Y == null) {
            this.Y = new Task();
            if (NexEditorDeviceProfile.getDeviceProfile().getNeedsColorFormatCheck()) {
                ColorFormatChecker.a(context).onResultAvailable(new C2357h(this)).onFailure((Task.OnFailListener) new C2356g(this));
            } else {
                this.Y.signalEvent(Task.Event.COMPLETE);
            }
        }
        return this.Y;
    }

    public int d(int i2) {
        return getTexNameForBlend(i2);
    }

    public int d(int i2, int i3) {
        return releaseRenderItem(i2, i3);
    }

    public void d(int i2, q qVar) {
        a(i2, true, 1, qVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(b bVar) {
        if (this.sa != null) {
            if (bVar.c()) {
                this.sa.sendFailure(bVar);
            } else {
                this.sa.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
            }
            this.sa = null;
            u();
        }
    }

    public ColorFormatChecker.ColorFormat d() {
        return this.N;
    }

    public void a(ha haVar) {
        this.k = haVar;
        NexEditorEventListener nexEditorEventListener = this.i;
        if (nexEditorEventListener != null) {
            nexEditorEventListener.setUIListener(this.k);
        }
    }

    public void a(d dVar) {
        NexEditorEventListener nexEditorEventListener = this.i;
        if (nexEditorEventListener != null) {
            nexEditorEventListener.setCustomRenderCallback(dVar);
        }
    }

    public void a(NexThemeView nexThemeView) {
        NexThemeView nexThemeView2 = this.j;
        if (nexThemeView2 != nexThemeView) {
            if (nexThemeView2 != null) {
                nexThemeView2.a((NexEditor) null);
            }
            if (nexThemeView != null) {
                nexThemeView.a(this);
            }
            this.j = nexThemeView;
            NexEditorEventListener nexEditorEventListener = this.i;
            if (nexEditorEventListener != null) {
                NexThemeView nexThemeView3 = this.j;
                nexEditorEventListener.setContext(nexThemeView3 != null ? nexThemeView3.getContext() : null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i2, int i3) {
        if (this.z.size() < 1 || this.s.size() < 1 || this.z.peek().intValue() != i3) {
            return;
        }
        this.z.remove();
        o remove = this.s.remove();
        if (i2 == 0) {
            remove.a(i3);
        } else {
            remove.a(b.a(i2));
        }
    }

    public int c(int i2) {
        return swapBlendMain(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, int i2) {
        if (this.I != b.f24591b) {
            return false;
        }
        if (this.O >= 2) {
            this.P = str;
            this.Q = i2;
            return true;
        }
        int fastOptionPreview = fastOptionPreview(str, i2);
        if (fastOptionPreview == 0) {
            this.O++;
        }
        return fastOptionPreview == 0;
    }

    public void a(NexThemeView nexThemeView, Context context) {
        NexThemeView nexThemeView2 = this.j;
        if (nexThemeView2 != nexThemeView) {
            if (nexThemeView2 != null) {
                nexThemeView2.a((NexEditor) null);
            }
            if (nexThemeView != null) {
                nexThemeView.a(this);
            }
            this.j = nexThemeView;
            NexEditorEventListener nexEditorEventListener = this.i;
            NexThemeView nexThemeView3 = this.j;
            if (nexThemeView3 != null) {
                context = nexThemeView3.getContext();
            }
            nexEditorEventListener.setContext(context);
        }
    }

    public int b(String str) {
        return removeBitmap(str);
    }

    public int b(int i2) {
        return swapBlendMain(i2);
    }

    public int b(String str, int i2) {
        String property = getProperty(str);
        if (property == null) {
            return i2;
        }
        try {
            return Integer.parseInt(property);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public boolean b() {
        String property = getProperty("canUseSoftwareCodec");
        if (property == null) {
            return false;
        }
        if (property.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return true;
        }
        if (property.equals("false")) {
            return false;
        }
        throw new InternalError();
    }

    public void a(n nVar) {
        this.Z = nVar;
    }

    public int c() {
        return clearScreen(1);
    }

    public void a(j jVar) {
        this.aa = jVar;
    }

    public void c(int i2, q qVar) {
        a(i2, true, 2, qVar);
    }

    public void a(s sVar) {
        this.ba = sVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i2, int i3) {
        a(i2, i3, b.f24591b);
    }

    private void b(FastPreviewOption fastPreviewOption, int i2, boolean z) {
        c(fastPreviewOption.name() + "=" + i2, z ? 1 : 0);
    }

    private void c(boolean z) {
        if (z == this.za) {
            return;
        }
        this.za = z;
        ha haVar = this.k;
        if (haVar != null) {
            haVar.a(this.za);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int i3, int i4) {
        s sVar = this.ba;
        if (sVar != null) {
            sVar.a(i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(f fVar) {
        int captureCurrentFrame = captureCurrentFrame();
        if (captureCurrentFrame == 0) {
            this.B.add(fVar);
        }
        return captureCurrentFrame;
    }

    public void a(l lVar) {
        this.da = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7, int i8, int i9) {
        l lVar = this.da;
        if (lVar != null) {
            lVar.a(i2, i3, i4, i5, i6, bArr, i7, i8, i9);
        }
    }

    public void b(p pVar) {
        a(1, pVar);
    }

    private void b(g gVar) {
        this.Aa = false;
        this.Da = false;
        if (!this.za) {
            gVar.a(b.f24591b);
        } else if (gVar != null) {
            this.y.add(gVar);
        }
    }

    public static void c(String str) {
        setPacakgeName4Protection(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int[] iArr) {
        m mVar = this.ea;
        if (mVar != null) {
            mVar.a(i2, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int[] iArr, int[] iArr2) {
        t tVar = this.fa;
        if (tVar != null) {
            tVar.a(i2, iArr, iArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar, int i2) {
        this.F = i2;
        while (true) {
            g peek = this.x.peek();
            if (peek == null || peek.f24599a > i2) {
                return;
            } else {
                this.x.remove().a(bVar);
            }
        }
    }

    public void b(int i2, q qVar) {
        a(i2, true, 4, qVar);
    }

    public void b(String str, boolean z) {
        loadTheme(String.format("", new Object[0]), str, !z ? 1 : 0);
    }

    public void b(b bVar, int i2) {
        k kVar = this.Ha;
        if (kVar != null) {
            kVar.a(bVar, i2);
        }
    }

    public void b(boolean z) {
        NexEditorEventListener nexEditorEventListener = this.i;
        if (nexEditorEventListener != null) {
            nexEditorEventListener.setWatermark(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int i3, int i4, byte[] bArr, boolean z) {
        if (this.B.size() < 1) {
            return;
        }
        if (i2 < 1 || i3 < 1 || i4 < 1 || bArr == null) {
            a(b.Va);
        }
        try {
            f remove = this.B.remove();
            if (z) {
                int i5 = i2 * 4;
                byte[] bArr2 = new byte[i5];
                for (int i6 = 0; i6 < i3 / 2; i6++) {
                    int i7 = i2 * i6 * 4;
                    System.arraycopy(bArr, i7, bArr2, 0, i5);
                    int i8 = ((i3 - 1) - i6) * i2 * 4;
                    System.arraycopy(bArr, i8, bArr, i7, i5);
                    System.arraycopy(bArr2, 0, bArr, i8, i5);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
            remove.a(createBitmap);
        } catch (NoSuchElementException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar) {
        if (this.B.size() < 1) {
            return;
        }
        this.B.remove().a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int i3, int i4, int i5) {
        Deque<e> deque;
        if (i5 == 1 || i5 == 4 || i5 == 0) {
            Deque<e> deque2 = this.q;
            if (deque2 == null || deque2.size() < 1) {
                return;
            }
            for (e eVar : this.q) {
                if (eVar.f24598a == i4) {
                    this.q.remove(eVar);
                    if (i2 == 0) {
                        eVar.a(i4, i3, i5);
                        return;
                    } else {
                        eVar.a(b.a(i2));
                        return;
                    }
                }
            }
        }
        if ((i5 == 3 || i5 == 0) && (deque = this.p) != null && deque.size() >= 1) {
            for (e eVar2 : this.p) {
                if (eVar2.f24598a == i4) {
                    this.p.remove(eVar2);
                    if (i2 == 0) {
                        eVar2.a(i4, i3, i5);
                        return;
                    } else {
                        eVar2.a(b.a(i2));
                        return;
                    }
                }
            }
        }
    }

    public int a(String str, int[] iArr, int i2, int i3, int i4) {
        return pushLoadedBitmap(str, iArr, i2, i3, i4);
    }

    public int a(int i2, int i3) {
        return getTexNameForClipID(i2, i3);
    }

    public int a(int i2, int i3, String str, int i4, int i5, int i6, int i7, float[] fArr, float f2, float f3, float f4, float f5, float f6, boolean z) {
        return drawRenderItemOverlay(i2, i3, str, i4, i5, i6, i7, fArr, f2, f3, f4, f5, f6, z);
    }

    public int a(String str, int i2) {
        return createRenderItem(str, i2);
    }

    public int a(int i2, int i3, float f2, float f3) {
        return setTexNameForLUT(i2, i3, f2, f3);
    }

    public boolean a(String str, boolean z) {
        String property = getProperty(str);
        if (property == null) {
            return z;
        }
        if (property.trim().equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return true;
        }
        if (property.trim().equalsIgnoreCase("false")) {
            return false;
        }
        return z;
    }

    public void a(Surface surface) {
        this.R = surface;
        if (this.la) {
            Log.d("NexEditor.java", "prepareSurface wait. image exporting...");
            return;
        }
        if (this.ka) {
            return;
        }
        if (f24582a) {
            prepareSurface(null);
        }
        if (surface != null) {
            setPreviewScaleFactor(this.Ia);
        }
        prepareSurface(surface);
    }

    public static String a(String str) {
        try {
            return getSystemProperty(str);
        } catch (UnsatisfiedLinkError unused) {
            f24584c = true;
            return "";
        }
    }

    public b a(String str, String str2, int i2, int i3, int i4, long j2, String str3) {
        if (!this.ga && !this.ha) {
            b a2 = b.a(transcodingStart(str, str2, i2, i3, i2, i3, i4, j2, 30, 0, str3));
            if (!a2.c()) {
                this.ga = true;
            }
            return a2;
        }
        return b.L;
    }

    public b a(String str, String str2, String str3, int i2, int i3, int i4, long j2, int i5, int i6) {
        if (!this.ga && !this.ha) {
            b a2 = b.a(reverseStart(str, str2, str3, i2, i3, i4, j2, i5, i6, 1));
            if (!a2.c()) {
                this.ha = true;
            }
            return a2;
        }
        return b.L;
    }

    public c a() {
        return new C2358i(this);
    }

    public boolean a(FastPreviewOption fastPreviewOption, int i2, boolean z) {
        if (this.la || this.ha) {
            return false;
        }
        return c(fastPreviewOption.name() + "=" + i2, z ? 1 : 0);
    }

    public b a(f fVar) {
        return a(2147418113, fVar);
    }

    public ResultTask<Bitmap> a(SurfaceView surfaceView) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        this.ka = true;
        surfaceView.getHolder().addCallback(this.ja);
        surfaceView.getHolder().setFixedSize(16, 16);
        x().setTimeout(500L).onResultAvailable(new C2366q(this, surfaceView, resultTask)).onFailure((Task.OnFailListener) new C2360k(this, surfaceView, resultTask));
        return resultTask;
    }

    public b a(int i2, f fVar) {
        if (i2 == 2147418113) {
            i2 = this.G;
        }
        if (this.la) {
            return b.f24596g;
        }
        this.la = true;
        if (!this.ma) {
            this.na = (this.Aa || this.za) ? this.Ba : this.G;
        }
        C2367s c2367s = new C2367s(this, fVar);
        if (i2 == 2147418114) {
            b(FastPreviewOption.nofx, 1, false);
            b(c2367s);
        } else {
            a(i2, false, (q) new C2368t(this, i2, fVar, c2367s));
        }
        return b.f24591b;
    }

    public void a(p pVar) {
        a(0, pVar);
    }

    private void a(int i2, p pVar) {
        this.oa++;
        this.pa = true;
        this.o = false;
        b(new C2354e(this, this.oa, i2, pVar));
    }

    public Task a(String str, int i2, int i3, int i4, long j2, int i5, boolean z, int i6, int i7, int i8, int i9, int i10) {
        Task task = new Task();
        if (this.sa != null) {
            task.sendFailure(b.gb);
            return task;
        }
        this.ta = i5;
        int encodeProject = encodeProject(str, i2, i3, i4, j2, z ? i5 : 0, i6 <= 0 ? 3000 : i6, 1920, 1080, i9, 131072, i7, i8, 268501760, i10);
        if (encodeProject != 0) {
            task.sendFailure(b.a(encodeProject));
            return task;
        }
        this.ra = null;
        this.sa = task;
        return this.sa;
    }

    public void a(g gVar) {
        a(2, gVar);
    }

    public void a(int i2, g gVar) {
        if (this.pa) {
            Iterator<g> it = this.y.iterator();
            while (it.hasNext()) {
                it.next().a(b.bb);
            }
            this.y.clear();
        }
        this.pa = false;
        this.qa = false;
        if (!this.f24588g && this.sa == null) {
            stopPlay(i2);
            gVar.a(b.f24591b);
            return;
        }
        this.w.clear();
        this.u.add(gVar);
        int stopPlay = stopPlay(i2);
        Task task = this.sa;
        if (task != null) {
            task.signalEvent(Task.Event.CANCEL);
            this.sa = null;
        }
        if (stopPlay != 0) {
            this.u.remove(gVar);
            gVar.a(b.a(stopPlay));
        }
    }

    public void a(int i2, q qVar) {
        a(i2, true, 0, qVar);
    }

    public void a(int i2, boolean z, q qVar) {
        a(i2, z, 0, qVar);
    }

    private void a(int i2, boolean z, int i3, q qVar) {
        synchronized (this.Ga) {
            if (qVar != null) {
                qVar.f24600a = i2;
                qVar.f24601b = this.Fa;
            }
            if (this.za) {
                if (qVar != null) {
                    this.t.add(qVar);
                }
                if (z) {
                    this.Aa = true;
                    this.Ba = i2;
                    this.Ca = i3;
                } else {
                    this.Da = true;
                    this.Ea = i2;
                }
            } else {
                this.Fa++;
                if (qVar != null) {
                    this.t.add(qVar);
                }
                this.o = true;
                c(true);
                int time = setTime(i2, z ? 1 : 0, i3);
                if (time != 0) {
                    if (qVar != null) {
                        qVar.a(b.a(time));
                    }
                    if (qVar != null) {
                        this.t.remove(qVar);
                    }
                    this.Fa--;
                    c(false);
                    return;
                }
                this.Ba = i2;
                if (z) {
                    this.Aa = false;
                } else {
                    this.Da = false;
                }
            }
        }
    }

    protected void a(int i2, int i3, b bVar) {
        synchronized (this.Ga) {
            this.I = bVar;
            this.G = i2;
            LinkedList<q> linkedList = new LinkedList();
            for (q qVar : this.t) {
                if (qVar.f24601b < this.Fa) {
                    linkedList.add(qVar);
                }
            }
            for (q qVar2 : linkedList) {
                if (bVar == b.f24591b) {
                    qVar2.a(i2, i3);
                } else {
                    qVar2.a(bVar);
                }
            }
            this.t.removeAll(linkedList);
            v();
            c(false);
        }
        if (this.y.size() > 0) {
            this.Aa = false;
            this.Da = false;
            while (this.y.size() > 0) {
                this.y.remove().a(b.f24591b);
            }
        }
        if (this.Da) {
            this.Da = false;
            a(this.Ea, false, 0, (q) null);
            return;
        }
        if (this.Aa) {
            this.Aa = false;
            int i4 = this.Ca;
            if (i4 == 0) {
                l(this.Ba);
                return;
            }
            if (i4 == 1) {
                d(this.Ba, (q) null);
            } else if (i4 == 4) {
                b(this.Ba, (q) null);
            } else {
                c(this.Ba, (q) null);
            }
        }
    }

    public void a(boolean z) {
        clearRenderItems(!z ? 1 : 0);
    }

    public void a(String str, String str2, boolean z) {
        loadRenderItem(str, str2, !z ? 1 : 0);
    }

    public b a(String str, NexClipInfo nexClipInfo, boolean z, int i2) {
        Log.d("NexEditor.java", "readClipInfoSync: path:" + str);
        String str2 = Build.MODEL;
        String str3 = Build.PRODUCT;
        String str4 = Build.HARDWARE;
        int clipInfoSync = getClipInfoSync(str, nexClipInfo, z ? 1 : 0, i2);
        Log.d("NexEditor.java", "readClipInfoSync: result:" + clipInfoSync);
        return b.a(clipInfoSync);
    }

    public void a(k kVar) {
        this.Ha = kVar;
    }

    public void a(r rVar) {
        this.D = rVar;
    }

    public b a(File file, File file2, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return b.a(getClipVideoThumb(file.getAbsolutePath(), file2.getAbsolutePath(), i2, i3, i4, i5, i6, i7, i8));
    }

    public b a(File file, File file2, int i2) {
        return b.a(getClipAudioThumb(file.getAbsolutePath(), file2.getAbsolutePath(), i2));
    }

    public Task a(NexVisualClip[] nexVisualClipArr, NexAudioClip[] nexAudioClipArr) {
        return a(nexVisualClipArr, nexAudioClipArr, 0);
    }

    public Task a(NexVisualClip[] nexVisualClipArr, NexAudioClip[] nexAudioClipArr, int i2) {
        int i3;
        int i4;
        int i5;
        Task task = new Task();
        if (nexVisualClipArr != null) {
            i3 = 0;
            for (NexVisualClip nexVisualClip : nexVisualClipArr) {
                if (nexVisualClip != null && (i5 = nexVisualClip.mClipID) > i3) {
                    i3 = i5;
                }
            }
        } else {
            i3 = 0;
        }
        if (nexAudioClipArr != null) {
            for (NexAudioClip nexAudioClip : nexAudioClipArr) {
                if (nexAudioClip != null && (i4 = nexAudioClip.mClipID) > i3) {
                    i3 = i4;
                }
            }
        }
        this.f24587f = i3 + 1;
        int asyncLoadList = asyncLoadList(nexVisualClipArr, nexAudioClipArr, i2);
        if (asyncLoadList == 0) {
            this.A.add(task);
        } else {
            task.sendFailure(b.a(asyncLoadList));
        }
        return task;
    }
}
