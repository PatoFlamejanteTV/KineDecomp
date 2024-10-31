package com.nextreaming.nexvideoeditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.StrictMode;
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
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class NexEditor {
    private static File F = null;
    private static NexEditor Q = null;
    private static boolean X = false;
    private static final g as = new com.nextreaming.nexvideoeditor.e();
    private int G;
    private int H;
    private int I;
    private int M;
    private Surface N;
    private m R;
    private i S;
    private r T;
    private k V;
    private l W;
    private ResultTask<Rect> aa;
    private int af;
    private int ak;
    private j at;
    private EffectLibrary b;
    private NexEditorEventListener e;
    private NexThemeView f;
    private String k;

    /* renamed from: a, reason: collision with root package name */
    private int f4792a = 1;
    private boolean c = false;
    private boolean d = false;
    private ar g = null;
    private s[] h = null;
    private a[] i = null;
    private a[] j = null;
    private boolean l = false;
    private Deque<e> m = new LinkedList();
    private Deque<e> n = new LinkedList();
    private Deque<h> o = new LinkedList();
    private Deque<n> p = new LinkedList();
    private Deque<p> q = new LinkedList();
    private Deque<g> r = new LinkedList();
    private Deque<o> s = new LinkedList();
    private Deque<o> t = new LinkedList();
    private Deque<g> u = new LinkedList();
    private Deque<g> v = new LinkedList();
    private Deque<Integer> w = new LinkedList();
    private Deque<Task> x = new ArrayDeque();
    private Deque<f> y = new LinkedList();
    private q z = null;
    private int A = 1;
    private int B = 0;
    private int C = 0;
    private b D = null;
    private int E = 0;
    private ColorFormatChecker.ColorFormat J = null;
    private int K = 0;
    private String L = null;
    private NexVisualClipChecker O = null;
    private Task P = null;
    private Task U = null;
    private boolean Y = false;
    private boolean Z = false;
    private SurfaceHolder.Callback ab = new com.nextreaming.nexvideoeditor.h(this);
    private boolean ac = false;
    private boolean ad = false;
    private boolean ae = false;
    private int ag = 0;
    private boolean ah = false;
    private boolean ai = false;
    private Task aj = null;
    private boolean al = false;
    private boolean am = false;
    private int an = 0;
    private boolean ao = false;
    private boolean ap = false;
    private int aq = 0;
    private int ar = 0;

    /* loaded from: classes.dex */
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
        swapv
    }

    /* loaded from: classes.dex */
    public static class a extends t {
    }

    /* loaded from: classes.dex */
    public interface c {
        c a(int i);

        c a(Rect rect);

        c a(FastPreviewOption fastPreviewOption, int i);

        c a(boolean z);

        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(LayerRenderer layerRenderer);
    }

    /* loaded from: classes.dex */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        int f4794a;

        public abstract void a(int i, int i2, int i3);

        public abstract void a(b bVar);
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        public abstract void a(Bitmap bitmap);

        public abstract void a(b bVar);
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        public abstract void a();

        public abstract void a(b bVar);
    }

    /* loaded from: classes.dex */
    public interface i {
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(b bVar, int i);
    }

    /* loaded from: classes.dex */
    public interface k {
        void a(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7, int i8);
    }

    /* loaded from: classes.dex */
    public interface l {
        int a(int i, int[] iArr);
    }

    /* loaded from: classes.dex */
    public interface m {
        void a();
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        public abstract void a(int i);

        public abstract void a(b bVar);
    }

    /* loaded from: classes.dex */
    public static abstract class o {
        public abstract void a();

        public abstract void a(b bVar);
    }

    /* loaded from: classes.dex */
    public static abstract class q {
        public abstract void a();
    }

    /* loaded from: classes.dex */
    public interface r {
        void a(int i, int i2, int i3);

        void a(b bVar, int i);
    }

    /* loaded from: classes.dex */
    public static class s extends t {
    }

    /* loaded from: classes.dex */
    public static abstract class t {
    }

    private native int asyncLoadList(NexVisualClip[] nexVisualClipArr, NexAudioClip[] nexAudioClipArr, int i2);

    private native int captureCurrentFrame();

    private native int clearScreen(int i2);

    private native int createEditor(String str, String str2, int i2, int i3, int[] iArr);

    private native int encodeProject(String str, int i2, int i3, int i4, long j2, int i5, int i6, int i7, int i8, int i9, int i10);

    private native int fastOptionPreview(String str, int i2);

    private native int getClipAudioThumb(String str, String str2, int i2);

    private native int getClipInfoSync(String str, NexClipInfo nexClipInfo, int i2, int i3);

    private native int getClipVideoThumb(String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    private native String getProperty(String str);

    private static native String getSystemProperty(String str);

    private native int getTexNameForClipID(int i2, int i3);

    private native int getTexNameForMask(int i2);

    private native int initUserData();

    private native int loadTheme(String str, String str2, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int prepareSurface(Surface surface);

    private native int reverseStart(String str, String str2, String str3, int i2, int i3, int i4, long j2, int i5, int i6, int i7);

    private native int reverseStop();

    private native int setBackgroundMusic(String str, int i2);

    private native int setEventHandler(NexEditorEventListener nexEditorEventListener);

    /* JADX INFO: Access modifiers changed from: private */
    public native int setProperty(String str, String str2);

    private native int setRenderToDefault(int i2);

    private native int setRenderToMask(int i2);

    private native int setTexNameForLUT(int i2, int i3, float f2, float f3);

    private native int setTime(int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public native int startPlay(int i2);

    private native int stopPlay(int i2);

    private native int transcodingStart(String str, String str2, int i2, int i3, int i4, long j2, int i5, int i6, String str3);

    private native int transcodingStop();

    public native int clearTrackCache();

    public native int createProject();

    public native int endVoiceRecorder(NexClipInfo nexClipInfo);

    public native int getVersionNumber(int i2);

    public native int processVoiceRecorder(byte[] bArr, int i2);

    public native int setBackgroundMusicVolume(int i2, int i3, int i4);

    public native int setProjectEffect(String str);

    public native int setProjectVolumeFade(int i2, int i3);

    public native int startVoiceRecorder(String str, int i2, int i3, int i4);

    static {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            System.loadLibrary("nexeditorsdk");
        } catch (UnsatisfiedLinkError e2) {
            Log.e("NexEditor.java", "[NexEditor.java] nexeditor load failed : " + e2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
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

    public Task a(Context context) {
        if (this.P == null) {
            this.P = new Task();
            if (NexEditorDeviceProfile.getDeviceProfile().getNeedsColorFormatCheck()) {
                ColorFormatChecker.a(context).onResultAvailable(new com.nextreaming.nexvideoeditor.f(this)).onFailure((Task.OnFailListener) new com.nextreaming.nexvideoeditor.c(this));
            } else {
                this.P.signalEvent(Task.Event.COMPLETE);
            }
        }
        return this.P;
    }

    public NexEditor(Context context, NexThemeView nexThemeView, String str, int i2, NexImageLoader.d dVar, int[] iArr) throws EditorInitException {
        String str2;
        this.e = null;
        this.f = null;
        Q = this;
        int i3 = i2 ^ 323655054;
        if (context.getFilesDir() == null) {
            throw new IllegalStateException("No files directory - cannot play video - relates to Android issue: 8886!");
        }
        String str3 = context.getApplicationInfo().nativeLibraryDir;
        str3 = str3.endsWith(File.separator) ? str3 : str3 + File.separator;
        if (new File(str3, "libnexeditorsdk.so").exists()) {
            str2 = str3;
        } else {
            str2 = "/system/lib/";
            if (new File("/system/lib/", "libnexeditorsdk.so").exists()) {
            }
        }
        int createEditor = createEditor(str2, str, Build.VERSION.SDK_INT, initUserData() ^ i3, iArr == null ? null : Arrays.copyOf(iArr, iArr.length + 2));
        if (createEditor != 0) {
            throw new EditorInitException("Editor Initialization Failed (result=" + createEditor + ")");
        }
        setProperty("HardWareCodecMemSize", "" + NexEditorDeviceProfile.getDeviceProfile().getHardwareCodecMemSize());
        if (!NexEditorDeviceProfile.getDeviceProfile().isUnknownDevice() && NexEditorDeviceProfile.getDeviceProfile().getSupportsVideoLayers(false)) {
            setProperty("HardWareDecMaxCount", "4");
        } else {
            setProperty("HardWareDecMaxCount", "" + NexEditorDeviceProfile.getDeviceProfile().getHardwareDecMaxCount());
        }
        setProperty("HardWareEncMaxCount", "" + NexEditorDeviceProfile.getDeviceProfile().getHardwareEncMaxCount());
        setProperty("HardWareEncMaxCount", "" + NexEditorDeviceProfile.getDeviceProfile().getHardwareEncMaxCount());
        setProperty("FeatureVersion", "3");
        setProperty("DeviceExtendMode", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        setProperty("InputMaxFPS", "" + NexEditorDeviceProfile.getDeviceProfile().getMaxSupportedFPS());
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int i4 = 1024;
        while (i4 * 2 < max) {
            i4 *= 2;
        }
        this.G = i4;
        this.H = i4;
        this.I = i4 * i4;
        setProperty("JpegMaxWidthFactor", "" + this.G);
        setProperty("JpegMaxHeightFactor", "" + this.G);
        setProperty("JpegMaxSizeFactor", "" + this.I);
        setProperty("UseAndroidJPEG", NexEditorDeviceProfile.getDeviceProfile().getUseAndroidJPEGDecoder() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        setProperty("WaitGLRenderFinish", NexEditorDeviceProfile.getDeviceProfile().getWaitToGLFinish() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        setProperty("SupportFrameTimeChecker", NexEditorDeviceProfile.getDeviceProfile().getSupportFrameTimeChecker() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (this.f != nexThemeView) {
            if (this.f != null) {
                this.f.a((NexEditor) null);
            }
            nexThemeView.a(this);
            this.f = nexThemeView;
        }
        this.b = EffectLibrary.a(context);
        this.e = new NexEditorEventListener(this, context, this.b.e(), dVar);
        setEventHandler(this.e);
    }

    public int a() {
        return this.G;
    }

    public int b() {
        return this.H;
    }

    public int c() {
        return this.I;
    }

    public NexVisualClipChecker d() {
        if (this.O == null) {
            this.O = new NexVisualClipChecker(this);
        }
        return this.O;
    }

    public void a(ar arVar) {
        this.g = arVar;
        if (this.e != null) {
            this.e.setUIListener(this.g);
        }
    }

    public void a(d dVar) {
        if (this.e != null) {
            this.e.setCustomRenderCallback(dVar);
        }
    }

    public void a(NexThemeView nexThemeView) {
        if (this.f != nexThemeView) {
            if (this.f != null) {
                this.f.a((NexEditor) null);
            }
            if (nexThemeView != null) {
                nexThemeView.a(this);
            }
            this.f = nexThemeView;
            this.e.setContext(this.f != null ? this.f.getContext() : null);
        }
    }

    public void a(NexThemeView nexThemeView, Context context) {
        if (this.f != nexThemeView) {
            if (this.f != null) {
                this.f.a((NexEditor) null);
            }
            if (nexThemeView != null) {
                nexThemeView.a(this);
            }
            this.f = nexThemeView;
            NexEditorEventListener nexEditorEventListener = this.e;
            if (this.f != null) {
                context = this.f.getContext();
            }
            nexEditorEventListener.setContext(context);
        }
    }

    public void a(m mVar) {
        this.R = mVar;
    }

    public void a(i iVar) {
        this.S = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        if (this.R != null) {
            this.R.a();
        }
    }

    public void a(r rVar) {
        this.T = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int i3, int i4) {
        if (this.T != null) {
            this.T.a(i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar, int i2) {
        if (this.Y || this.Z) {
            this.Y = false;
            this.Z = false;
            if (this.T != null) {
                this.T.a(bVar, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar) {
        if (bVar.a()) {
            Log.d("NexEditor.java", "onFastOptionPreviewDone:" + bVar.getMessage());
        }
        this.K--;
        if (this.D != b.f4793a) {
            if (this.K < 1 && this.U != null) {
                this.U.sendFailure(b.bm);
                this.U = null;
                return;
            }
            return;
        }
        if (this.L != null && this.K < 2) {
            int fastOptionPreview = fastOptionPreview(this.L, this.M);
            this.L = null;
            if (fastOptionPreview == 0) {
                this.K++;
                return;
            } else {
                Log.d("NexEditor.java", "onFastOptionPreviewDone: pending result=" + fastOptionPreview);
                return;
            }
        }
        if (this.K < 1 && this.U != null) {
            this.U.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
            this.U = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(b bVar) {
        Log.w("NexEditor.java", "onPlayError:" + bVar);
        if (this.aj != null && bVar.a()) {
            this.aj.sendFailure(bVar);
            this.aj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(b bVar) {
        if (this.aj != null && bVar.a()) {
            this.aj.sendFailure(bVar);
            this.aj = null;
            return;
        }
        this.c = true;
        if (this.s.size() >= 1) {
            o remove = this.s.remove();
            remove.a(bVar);
            if (bVar == b.f4793a) {
                this.t.add(remove);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        this.ai = false;
        if (this.t.size() >= 1) {
            this.t.remove().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(b bVar) {
        this.c = false;
        if (this.aj != null && bVar.a()) {
            this.aj.sendFailure(bVar);
            this.aj = null;
        }
        while (true) {
            g poll = this.r.poll();
            if (poll != null) {
                poll.a(bVar);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(b bVar) {
        if (this.aj != null) {
            if (bVar.a()) {
                this.aj.sendFailure(bVar);
            } else {
                this.aj.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
            }
            this.aj = null;
        }
    }

    public void a(k kVar) {
        this.V = kVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7, int i8, int i9) {
        if (this.V != null) {
            this.V.a(i2, i3, i4, i5, i6, bArr, i7, i8, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int[] iArr) {
        if (this.W != null) {
            this.W.a(i2, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(b bVar, int i2) {
        this.B = i2;
        while (true) {
            g peek = this.u.peek();
            if (peek == null || peek.f4795a > i2) {
                return;
            } else {
                this.u.remove().a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int i3, int i4, byte[] bArr) {
        if (this.y.size() >= 1) {
            if (i2 < 1 || i3 < 1 || i4 < 1 || bArr == null) {
                f(b.aU);
            }
            try {
                f remove = this.y.remove();
                byte[] bArr2 = new byte[i2 * 4];
                for (int i5 = 0; i5 < i3 / 2; i5++) {
                    System.arraycopy(bArr, i2 * i5 * 4, bArr2, 0, i2 * 4);
                    System.arraycopy(bArr, ((i3 - 1) - i5) * i2 * 4, bArr, i2 * i5 * 4, i2 * 4);
                    System.arraycopy(bArr2, 0, bArr, ((i3 - 1) - i5) * i2 * 4, i2 * 4);
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(b bVar) {
        if (this.y.size() >= 1) {
            this.y.remove().a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int i3, int i4, int i5) {
        if (i5 == 1 || i5 == 4 || i5 == 0) {
            if (this.n != null && this.n.size() >= 1) {
                for (e eVar : this.n) {
                    if (eVar.f4794a == i4) {
                        this.n.remove(eVar);
                        if (i2 == 0) {
                            eVar.a(i4, i3, i5);
                            return;
                        } else {
                            eVar.a(b.a(i2));
                            return;
                        }
                    }
                }
            } else {
                return;
            }
        }
        if ((i5 == 3 || i5 == 0) && this.m != null && this.m.size() >= 1) {
            for (e eVar2 : this.m) {
                if (eVar2.f4794a == i4) {
                    this.m.remove(eVar2);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2) {
        h remove = this.o.remove();
        if (i2 == 0) {
            remove.a();
        } else {
            remove.a(b.a(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int i3) {
        if (this.w.size() >= 1 && this.p.size() >= 1 && this.w.peek().intValue() == i3) {
            this.w.remove();
            n remove = this.p.remove();
            if (i2 == 0) {
                remove.a(i3);
            } else {
                remove.a(b.a(i2));
            }
        }
    }

    public int b(int i2, int i3) {
        return getTexNameForClipID(i2, i3);
    }

    public int b(int i2) {
        return getTexNameForMask(i2);
    }

    public int c(int i2) {
        return setRenderToMask(i2);
    }

    public int d(int i2) {
        return setRenderToDefault(i2);
    }

    public int a(int i2, int i3, float f2, float f3) {
        return setTexNameForLUT(i2, i3, f2, f3);
    }

    public int a(String str, int i2) {
        String property = getProperty(str);
        if (property != null) {
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException e2) {
                return i2;
            }
        }
        return i2;
    }

    public boolean a(String str, boolean z) {
        String property = getProperty(str);
        if (property != null) {
            if (property.trim().equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                return true;
            }
            if (property.trim().equalsIgnoreCase("false")) {
                return false;
            }
            return z;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Surface surface) {
        this.N = surface;
        if (!this.ac) {
            prepareSurface(surface);
        }
    }

    public static String a(String str) {
        try {
            return getSystemProperty(str);
        } catch (UnsatisfiedLinkError e2) {
            X = true;
            return "";
        }
    }

    public b a(String str, String str2, int i2, int i3, int i4, long j2, String str3) {
        if (this.Y || this.Z) {
            return b.K;
        }
        b a2 = b.a(transcodingStart(str, str2, i2, i3, i4, j2, 30, 0, str3));
        if (!a2.a()) {
            this.Y = true;
            return a2;
        }
        return a2;
    }

    public b a(String str, String str2, String str3, int i2, int i3, int i4, long j2, int i5, int i6) {
        if (this.Y || this.Z) {
            return b.K;
        }
        b a2 = b.a(reverseStart(str, str2, str3, i2, i3, i4, j2, i5, i6, 0));
        if (!a2.a()) {
            this.Z = true;
            return a2;
        }
        return a2;
    }

    public b g() {
        if (this.Y) {
            return b.a(transcodingStop());
        }
        if (this.Z) {
            return b.a(reverseStop());
        }
        return b.d;
    }

    public boolean h() {
        return this.Y || this.Z;
    }

    public boolean i() {
        String property = getProperty("canUseSoftwareCodec");
        if (property.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return true;
        }
        if (property.equals("false")) {
            return false;
        }
        throw new InternalError();
    }

    public c j() {
        return new com.nextreaming.nexvideoeditor.g(this);
    }

    public boolean a(FastPreviewOption fastPreviewOption, int i2, boolean z) {
        if (this.ad) {
            return false;
        }
        return b(fastPreviewOption.name() + "=" + i2, z ? 1 : 0);
    }

    private void b(FastPreviewOption fastPreviewOption, int i2, boolean z) {
        b(fastPreviewOption.name() + "=" + i2, z ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task s() {
        if (this.U == null) {
            this.U = new Task();
        }
        return this.U;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, int i2) {
        if (this.D != b.f4793a) {
            return false;
        }
        if (this.K >= 2) {
            this.L = str;
            this.M = i2;
            return true;
        }
        int fastOptionPreview = fastOptionPreview(str, i2);
        if (fastOptionPreview == 0) {
            this.K++;
        }
        return fastOptionPreview == 0;
    }

    public int k() {
        return clearScreen(1);
    }

    public b a(f fVar) {
        return a(2147418113, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<Rect> t() {
        if (this.aa == null) {
            this.aa = new ResultTask<>();
        }
        return this.aa;
    }

    public ResultTask<Bitmap> a(SurfaceView surfaceView) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        this.ac = true;
        surfaceView.getHolder().addCallback(this.ab);
        surfaceView.getHolder().setFixedSize(16, 16);
        t().setTimeout(500L).onResultAvailable(new com.nextreaming.nexvideoeditor.j(this, surfaceView, resultTask)).onFailure((Task.OnFailListener) new com.nextreaming.nexvideoeditor.i(this, surfaceView, resultTask));
        return resultTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(f fVar) {
        int captureCurrentFrame = captureCurrentFrame();
        if (captureCurrentFrame == 0) {
            this.y.add(fVar);
        }
        return captureCurrentFrame;
    }

    public boolean l() {
        return this.ad;
    }

    public b a(int i2, f fVar) {
        if (i2 == 2147418113) {
            i2 = this.C;
        } else if (i2 == 2147418114) {
        }
        if (this.ad) {
            return b.f;
        }
        this.ad = true;
        if (!this.ae) {
            this.af = (this.am || this.al) ? this.an : this.C;
        }
        com.nextreaming.nexvideoeditor.p pVar = new com.nextreaming.nexvideoeditor.p(this, fVar);
        if (i2 == 2147418114) {
            b(FastPreviewOption.nofx, 1, false);
            b(pVar);
        } else {
            a(i2, false, (p) new com.nextreaming.nexvideoeditor.r(this, i2, fVar, pVar));
        }
        return b.f4793a;
    }

    public void m() {
        a(new com.nextreaming.nexvideoeditor.s(this));
    }

    public void a(o oVar) {
        a(0, oVar);
    }

    public void b(o oVar) {
        a(1, oVar);
    }

    private void a(int i2, o oVar) {
        this.ag++;
        this.ah = true;
        this.l = false;
        b(new com.nextreaming.nexvideoeditor.d(this, this.ag, i2, oVar));
    }

    public Task a(String str, int i2, int i3, int i4, long j2, int i5, boolean z, int i6) {
        Task task = new Task();
        if (this.aj != null) {
            task.sendFailure(b.bg);
            return task;
        }
        this.ak = i5;
        int encodeProject = encodeProject(str, i2, i3, i4, j2, z ? i5 : 0, i6 <= 0 ? 3000 : i6, 1920, 1080, 44100, 0);
        if (encodeProject != 0) {
            task.sendFailure(b.a(encodeProject));
            return task;
        }
        this.aj = task;
        return this.aj;
    }

    public void a(g gVar) {
        if (this.ah) {
            Iterator<g> it = this.v.iterator();
            while (it.hasNext()) {
                it.next().a(b.bb);
            }
            this.v.clear();
        }
        this.ah = false;
        this.ai = false;
        if (!this.c && this.aj == null) {
            stopPlay(0);
            gVar.a(b.f4793a);
            return;
        }
        this.t.clear();
        int stopPlay = stopPlay(0);
        if (this.aj != null) {
            this.aj.signalEvent(Task.Event.CANCEL);
            this.aj = null;
        }
        if (stopPlay == 0) {
            this.r.add(gVar);
        } else {
            gVar.a(b.a(stopPlay));
        }
    }

    public void e(int i2) {
        a(i2, (p) null);
    }

    private void b(g gVar) {
        this.am = false;
        this.ap = false;
        if (!this.al) {
            gVar.a(b.f4793a);
        } else if (gVar != null) {
            this.v.add(gVar);
        }
    }

    public void a(int i2, p pVar) {
        a(i2, true, false, pVar);
    }

    public void b(int i2, p pVar) {
        a(i2, true, true, pVar);
    }

    public void a(int i2, boolean z, p pVar) {
        a(i2, z, false, pVar);
    }

    private void a(int i2, boolean z, boolean z2, p pVar) {
        if (pVar != null) {
            pVar.f4796a = i2;
            pVar.b = this.ar;
        }
        if (this.al) {
            if (z) {
                this.am = true;
                this.an = i2;
                this.ao = z2;
            } else {
                this.ap = true;
                this.aq = i2;
            }
        } else {
            this.l = true;
            int time = setTime(i2, z ? 1 : 0, z2 ? 1 : 0);
            if (time != 0) {
                if (pVar != null) {
                    pVar.a(b.a(time));
                    return;
                }
                return;
            } else {
                b(true);
                this.an = i2;
                if (z) {
                    this.am = false;
                } else {
                    this.ap = false;
                }
                this.ar++;
            }
        }
        if (pVar != null) {
            this.q.add(pVar);
            u();
        }
    }

    private void u() {
        int i2 = 0;
        Iterator<p> it = this.q.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                it.next();
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i2) {
        a(i2, b.f4793a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i2) {
        if (this.aj != null) {
            this.aj.setProgress(Math.min(this.ak, i2), this.ak);
        }
        this.C = i2;
    }

    protected void a(int i2, b bVar) {
        this.D = bVar;
        this.C = i2;
        LinkedList<p> linkedList = new LinkedList();
        for (p pVar : this.q) {
            if (pVar.b < this.ar) {
                linkedList.add(pVar);
            }
        }
        for (p pVar2 : linkedList) {
            if (bVar == b.f4793a) {
                pVar2.a(i2);
            } else {
                pVar2.a(bVar);
            }
        }
        this.q.removeAll(linkedList);
        u();
        b(false);
        if (this.v.size() > 0) {
            this.am = false;
            this.ap = false;
            while (this.v.size() > 0) {
                this.v.remove().a(b.f4793a);
            }
        }
        if (this.ap) {
            this.ap = false;
            a(this.aq, false, false, (p) null);
        } else if (this.am) {
            this.am = false;
            if (this.ao) {
                b(this.an, (p) null);
            } else {
                e(this.an);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        a(0, b.aS);
    }

    private void b(boolean z) {
        if (z != this.al) {
            this.al = z;
            if (this.g != null) {
                this.g.a(this.al);
            }
        }
    }

    public void b(String str, boolean z) {
        loadTheme(String.format("", new Object[0]), str, !z ? 1 : 0);
    }

    public void c(String str, boolean z) {
        Theme e2;
        ArrayList arrayList = new ArrayList();
        if (this.b != null && (e2 = this.b.e(str)) != null) {
            this.k = str;
            String[] d2 = e2.d();
            for (String str2 : d2) {
                arrayList.add(this.b.c(str2));
            }
            for (com.nexstreaming.kinemaster.kmpackage.a aVar : this.b.b(13)) {
                arrayList.add(aVar);
            }
            for (com.nexstreaming.kinemaster.kmpackage.at atVar : this.b.a(13)) {
                arrayList.add(atVar);
            }
            this.b.a(arrayList, this, z);
        }
    }

    public b a(String str, NexClipInfo nexClipInfo, boolean z, int i2) {
        return b.a(getClipInfoSync(str, nexClipInfo, z ? 1 : 0, i2));
    }

    public void a(j jVar) {
        this.at = jVar;
    }

    public void c(b bVar, int i2) {
        if (this.at != null) {
            this.at.a(bVar, i2);
        }
    }

    public void a(q qVar) {
        this.z = qVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        if (this.z != null) {
            this.z.a();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class p {

        /* renamed from: a, reason: collision with root package name */
        private int f4796a;
        private int b;

        public abstract void a(int i);

        public abstract void a(b bVar);
    }

    /* loaded from: classes.dex */
    public static abstract class g {

        /* renamed from: a, reason: collision with root package name */
        private int f4795a;

        public abstract void a(b bVar);
    }

    /* loaded from: classes.dex */
    public enum PlayState {
        NONE(0),
        IDLE(1),
        RUN(2),
        RECORD(3);

        private int mValue;

        PlayState(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }

        public static PlayState fromValue(int i) {
            for (PlayState playState : values()) {
                if (playState.getValue() == i) {
                    return playState;
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Task.TaskError, DiagnosticLogger.a {
        private final boolean bv;
        private final int bw;
        private final String bx;
        private final int by;
        private final String bz;
        private static SparseArray<b> bu = new SparseArray<>();

        /* renamed from: a, reason: collision with root package name */
        public static final b f4793a = new b("NONE", 0);
        public static final b b = new b("GENERAL", 1);
        public static final b c = new b("UNKNOWN", 2);
        public static final b d = new b("NO_ACTION", 3);
        public static final b e = new b("INVALID_INFO", 4);
        public static final b f = new b("INVALID_STATE", 5);
        public static final b g = new b("VERSION_MISMATCH", 6);
        public static final b h = new b("CREATE_FAILED", 7);
        public static final b i = new b("MEMALLOC_FAILED", 8, "Memory allocation failed", R.string.engine_error_memalloc_failed);
        public static final b j = new b("ARGUMENT_FAILED", 9);
        public static final b k = new b("NOT_ENOUGH_NEMORY", 10, "Insufficient memory", R.string.engine_error_not_enough_memory);
        public static final b l = new b("EVENTHANDLER", 11);
        public static final b m = new b("FILE_IO_FAILED", 12, "Error accessing file", R.string.engine_error_fileio_fail);
        public static final b n = new b("FILE_INVALID_SYNTAX", 13);
        public static final b o = new b("FILEREADER_CREATE_FAIL", 14, "Could not open file", R.string.engine_error_filereader_create_fail);
        public static final b p = new b("FILEWRITER_CREATE_FAIL", 15);
        public static final b q = new b("AUDIORESAMPLER_CREATE_FAIL", 16);
        public static final b r = new b("UNSUPPORT_FORMAT", 17, "Unsupported format", R.string.engine_error_unsupported_format);
        public static final b s = new b("FILEREADER_FAILED", 18, "Error reading file format", R.string.engine_error_filereader_fail);
        public static final b t = new b("PLAYSTART_FAILED", 19);
        public static final b u = new b("PLAYSTOP_FAILED", 20);
        public static final b v = new b("PROJECT_NOT_CREATE", 21);
        public static final b w = new b("PROJECT_NOT_OPEN", 22);
        public static final b x = new b("CODEC_INIT", 23, "Codec init failed", R.string.engine_error_codec_init_failed);
        public static final b y = new b("RENDERER_INIT", 24);
        public static final b z = new b("THEMESET_CREATE_FAIL", 25);
        public static final b A = new b("ADD_CLIP_FAIL", 26, "Unable to add clip", R.string.engine_error_add_clip_failed);
        public static final b B = new b("ENCODE_VIDEO_FAIL", 27);
        public static final b C = new b("INPROGRESS_GETCLIPINFO", 28);
        public static final b D = new b("THUMBNAIL_BUSY", 29);
        public static final b E = new b("UNSUPPORT_MIN_DURATION", 30);
        public static final b F = new b("UNSUPPORT_MAX_RESOLUTION", 31);
        public static final b G = new b("UNSUPPORT_MIN_RESOLUTION", 32);
        public static final b H = new b("UNSUPPORT_VIDEIO_PROFILE", 33);
        public static final b I = new b("UNSUPPORT_VIDEO_LEVEL", 34);
        public static final b J = new b("UNSUPPORT_VIDEO_FPS", 35);
        public static final b K = new b("TRANSCODING_BUSY", 36);
        public static final b L = new b("TRANSCODING_NOT_SUPPORTED_FORMAT", 37);
        public static final b M = new b("TRANSCODING_USER_CANCEL", 38);
        public static final b N = new b("TRANSCODING_NOT_ENOUGHT_DISK_SPACE", 39);
        public static final b O = new b("TRANSCODING_CODEC_FAILED", 40);
        public static final b P = new b("EXPORT_WRITER_INVAILED_HANDLE", 41);
        public static final b Q = new b("EXPORT_WRITER_INIT_FAIL", 42);
        public static final b R = new b("EXPORT_WRITER_START_FAIL", 43);
        public static final b S = new b("EXPORT_AUDIO_DEC_INIT_FAIL", 44);
        public static final b T = new b("EXPORT_VIDEO_DEC_INIT_FAIL", 45);
        public static final b U = new b("EXPORT_VIDEO_ENC_FAIL", 46);
        public static final b V = new b("EXPORT_VIDEO_RENDER_INIT_FAIL", 47);
        public static final b W = new b("EXPORT_NOT_ENOUGHT_DISK_SPACE", 48, "Not enough space", R.string.fail_enospc);
        public static final b X = new b("UNSUPPORT_AUDIO_PROFILE", 49);
        public static final b Y = new b("THUMBNAIL_INIT_FAIL", 50);
        public static final b Z = new b("UNSUPPORT_AUDIO_CODEC", 51);
        public static final b aa = new b("UNSUPPORT_VIDEO_CODEC", 52);
        public static final b ab = new b("HIGHLIGHT_FILEREADER_INIT_ERROR", 53);
        public static final b ac = new b("HIGHLIGHT_TOO_SHORT_CONTENTS", 54);
        public static final b ad = new b("HIGHLIGHT_CODEC_INIT_ERROR", 55);
        public static final b ae = new b("HIGHLIGHT_CODEC_DECODE_ERROR", 56);
        public static final b af = new b("HIGHLIGHT_RENDER_INIT_ERROR", 57);
        public static final b ag = new b("HIGHLIGHT_WRITER_INIT_ERROR", 58);
        public static final b ah = new b("HIGHLIGHT_WRITER_WRITE_ERROR", 59);
        public static final b ai = new b("HIGHLIGHT_GET_INDEX_ERROR", 60);
        public static final b aj = new b("HIGHLIGHT_USER_CANCEL", 61);
        public static final b ak = new b("GETCLIPINFO_USER_CANCEL", 62);
        public static final b al = new b("DIRECTEXPORT_CLIPLIST_ERROR", 63);
        public static final b am = new b("DIRECTEXPORT_CHECK_ERROR", 64);
        public static final b an = new b("DIRECTEXPORT_FILEREADER_INIT_ERROR", 65);
        public static final b ao = new b("DIRECTEXPORT_FILEWRITER_INIT_ERROR", 66);
        public static final b ap = new b("DIRECTEXPORT_DEC_INIT_ERROR", 67);
        public static final b aq = new b("DIRECTEXPORT_DEC_INIT_SURFACE_ERROR", 68);
        public static final b ar = new b("DIRECTEXPORT_DEC_DECODE_ERROR", 69);
        public static final b as = new b("DIRECTEXPORT_ENC_INIT_ERROR", 70);
        public static final b at = new b("DIRECTEXPORT_ENC_ENCODE_ERROR", 71);
        public static final b au = new b("DIRECTEXPORT_ENC_INPUT_SURFACE_ERROR", 72);
        public static final b av = new b("DIRECTEXPORT_ENC_FUNCTION_ERROR", 73);
        public static final b aw = new b("DIRECTEXPORT_ENC_DSI_DIFF_ERROR", 74);
        public static final b ax = new b("DIRECTEXPORT_ENC_FRAME_CONVERT_ERROR", 75);
        public static final b ay = new b("DIRECTEXPORT_RENDER_INIT_ERROR", 76);
        public static final b az = new b("DIRECTEXPORT_WRITER_WRITE_ERROR", 77);
        public static final b aA = new b("DIRECTEXPORT_WRITER_UNKNOWN_ERROR", 78);
        public static final b aB = new b("FASTPREVIEW_USER_CANCEL", 79);
        public static final b aC = new b("FASTPREVIEW_CLIPLIST_ERROR", 80);
        public static final b aD = new b("FASTPREVIEW_FIND_CLIP_ERROR", 81);
        public static final b aE = new b("FASTPREVIEW_FIND_READER_ERROR", 82);
        public static final b aF = new b("FASTPREVIEW_VIDEO_RENDERER_ERROR", 83);
        public static final b aG = new b("FASTPREVIEW_DEC_INIT_SURFACE_ERROR", 84);
        public static final b aH = new b("HW_NOT_ENOUGH_MEMORY", 85);
        public static final b aI = new b("EXPORT_USER_CANCEL", 86);
        public static final b aJ = new b("FASTPREVIEW_DEC_INIT_ERROR", 87);
        public static final b aK = new b("FASTPREVIEW_FILEREADER_INIT_ERROR", 88);
        public static final b aL = new b("FASTPREVIEW_TIME_ERROR", 89);
        public static final b aM = new b("FASTPREVIEW_RENDER_INIT_ERROR", 90);
        public static final b aN = new b("FASTPREVIEW_OUTPUTSURFACE_INIT_ERROR", 91);
        public static final b aO = new b("ERROR_FASTPREVIEW_BUSY", 92);
        public static final b aP = new b("ERROR_CODEC_DECODE", 93);
        public static final b aQ = new b("ERROR_AUDIO_RENDERER", 94);
        public static final b aR = new b("IMAGE_PROCESS", 4097);
        public static final b aS = new b("SET_TIME_IGNORED", 7001, false, "Set time ignored", R.string.error_settime_ignored);
        public static final b aT = new b("SET_TIME_CANCELED", 7002, false, "Set time canceled", R.string.error_settime_canceled);
        public static final b aU = new b("CAPTURE_FAILED", 7003, false, "Capture failed", R.string.error_capture_failed);
        public static final b aV = new b("SOURCE_FILE_NOT_FOUND", 7004, false);
        public static final b aW = new b("TRANSCODING_ABORTED", 7005, false);
        public static final b aX = new b("DESTINATION_FILE_ALREADY_EXISTS", 7006, false);
        public static final b aY = new b("TEMP_FILE_ALREADY_EXISTS", 7007, false);
        public static final b aZ = new b("NO_INSTANCE_AVAILABLE", 7008, false);
        public static final b ba = new b("EXPORT_NO_SUCCESS", 7009, false);
        public static final b bb = new b("PLAY_SUPERCEEDED", 7010, false);
        public static final b bc = new b("WRAPPER_BUSY", 7011, false);
        public static final b bd = new b("NOT_READY_TO_PLAY", 7012, false);
        public static final b be = new b("SEEKING_LOCKED", 7013, false);
        public static final b bf = new b("NO_PROJECT_LOADED", 7014, false);
        public static final b bg = new b("ALREADY_EXPORTING", 7015, false);
        public static final b bh = new b("EMPTY_PROJECT", 7016, false);
        public static final b bi = new b("MISSING_RESOURCES", 7017, false);
        public static final b bj = new b("EXPORT_UNEXPECTED_STOP", 7018, false);
        public static final b bk = new b("PROJECT_LOAD_FAIL", 7019, false);
        public static final b bl = new b("RENAME_FAIL", 7020, false);
        public static final b bm = new b("FAST_PREVIEW_IGNORED", 7021, false);
        public static final b bn = new b("DUMMY_ERROR", 7022, false);
        public static final b bo = new b("CAPTURE_FAIL_ENOSPC", 7023, false, "Not enough space", R.string.fail_enospc);
        public static final b bp = new b("CAPTURE_FAIL_OTHER", 7024, false, "Capture failed", R.string.capture_fail_other);
        public static final b bq = new b("CAPTURE_FAIL_SCANNING", 7025, false, "Media scanner failed", R.string.capture_fail_other);
        public static final b br = new b("UNRECOGNIZED_ERROR_CODE", 7026, false, "Unrecognized error code", R.string.error_unrecognized_code);
        public static final b bs = new b("EDITOR_INSTANCE_DESTROYED", 7027, false);
        public static final b bt = new b("FILE_MISSING", 7028, false);

        b(String str, int i2) {
            this.bw = i2;
            this.bx = null;
            this.by = 0;
            this.bv = true;
            this.bz = str;
            if (bu.get(i2) != null) {
                throw new IllegalStateException();
            }
            bu.put(i2, this);
        }

        b(String str, int i2, String str2, int i3) {
            this.bw = i2;
            this.bx = str2;
            this.by = i3;
            this.bv = true;
            this.bz = str;
            if (bu.get(i2) != null) {
                throw new IllegalStateException();
            }
            bu.put(i2, this);
        }

        b(String str, int i2, boolean z2, String str2, int i3) {
            this.bw = 0;
            this.bx = str2;
            this.by = i3;
            this.bv = z2;
            this.bz = str;
            if (bu.get(i2) != null) {
                throw new IllegalStateException();
            }
            bu.put(i2, this);
        }

        b(String str, int i2, boolean z2) {
            this.bw = 0;
            this.bx = null;
            this.by = 0;
            this.bv = z2;
            this.bz = str;
            if (bu.get(i2) != null) {
                throw new IllegalStateException();
            }
            bu.put(i2, this);
        }

        public boolean a() {
            return this != f4793a;
        }

        public String b() {
            return this.bx == null ? c() : this.bx;
        }

        public String a(Context context) {
            if (this.by != 0) {
                return context.getResources().getString(this.by);
            }
            if (this.bx == null) {
                return c();
            }
            return this.bx;
        }

        public String c() {
            return this.bz;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return null;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return b();
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            return a(context);
        }

        @Override // com.nexstreaming.app.general.util.DiagnosticLogger.a
        public int getIntErrorCode() {
            return d();
        }

        public int d() {
            return this.bw;
        }

        public String toString() {
            if (this == f4793a) {
                return "NONE(0)";
            }
            if (this.bw != 0) {
                return c() + "(" + this.bw + ")";
            }
            return c();
        }

        public static b a(int i2) {
            b bVar = bu.get(i2);
            if (bVar == null) {
                b bVar2 = new b("UNKNOWN_ERROR_" + i2, i2);
                bu.put(i2, bVar2);
                return bVar2;
            }
            return bVar;
        }
    }

    public void a(File file) {
        if (file == null) {
            setBackgroundMusic((String) null, 0);
            return;
        }
        String absolutePath = file.getAbsolutePath();
        int i2 = this.f4792a;
        this.f4792a = i2 + 1;
        setBackgroundMusic(absolutePath, i2);
    }

    public b a(File file, File file2, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IOException {
        return b.a(getClipVideoThumb(file.getAbsolutePath(), file2.getAbsolutePath(), i2, i3, i4, i5, i6, i7, i8));
    }

    public b a(File file, File file2, int i2) {
        return b.a(getClipAudioThumb(file.getAbsolutePath(), file2.getAbsolutePath(), i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i2) {
        Task remove = this.x.remove();
        if (i2 == 0) {
            remove.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
        } else {
            remove.sendFailure(b.a(i2));
        }
    }

    public Task a(NexVisualClip[] nexVisualClipArr, NexAudioClip[] nexAudioClipArr) {
        int i2;
        Task task = new Task();
        if (nexVisualClipArr != null) {
            i2 = 0;
            for (NexVisualClip nexVisualClip : nexVisualClipArr) {
                if (nexVisualClip != null && nexVisualClip.mClipID > i2) {
                    i2 = nexVisualClip.mClipID;
                }
            }
        } else {
            i2 = 0;
        }
        if (nexAudioClipArr != null) {
            for (NexAudioClip nexAudioClip : nexAudioClipArr) {
                if (nexAudioClip != null && nexAudioClip.mClipID > i2) {
                    i2 = nexAudioClip.mClipID;
                }
            }
        }
        this.f4792a = i2 + 1;
        int asyncLoadList = asyncLoadList(nexVisualClipArr, nexAudioClipArr, 0);
        if (asyncLoadList == 0) {
            this.x.add(task);
        } else {
            task.sendFailure(b.a(asyncLoadList));
        }
        return task;
    }

    public boolean p() {
        return this.ai || this.ah;
    }

    public EffectLibrary q() {
        return this.b;
    }

    public ColorFormatChecker.ColorFormat r() {
        return this.J;
    }

    public void a(boolean z) {
        if (this.e != null) {
            this.e.setWatermark(z);
        }
    }
}
