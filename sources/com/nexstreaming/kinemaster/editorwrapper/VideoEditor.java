package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.SurfaceView;
import com.crashlytics.android.Crashlytics;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.C1709m;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.EffectLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nexstreaming.kinemaster.wire.HeaderDelimitedInputStream;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nexstreaming.kinemaster.wire.WireInstance;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexProjectHeader;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexAudioClip;
import com.nextreaming.nexvideoeditor.NexClipInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexRectangle;
import com.nextreaming.nexvideoeditor.NexThemeView;
import com.nextreaming.nexvideoeditor.NexVisualClip;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class VideoEditor {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f20260a = {".nexvideoproject", ".kmproject"};

    /* renamed from: b, reason: collision with root package name */
    private static final int f20261b = a('K', 'H', 'D', 'R');

    /* renamed from: c, reason: collision with root package name */
    private static final int f20262c = a('T', 'L', 'I', 'N');

    /* renamed from: d, reason: collision with root package name */
    private static final int f20263d = a('F', 'T', 'R', 'X');

    /* renamed from: e, reason: collision with root package name */
    private static long f20264e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static Comparator<NexLayerItem> f20265f = new Wa();
    private boolean D;
    private boolean E;
    private File F;
    private C1730a N;
    private String O;
    WeakReference<Object> P;
    WeakReference<NexLayerItem> Q;
    WeakReference<b> R;
    WeakReference<b> S;
    private ResultTask<Bitmap> U;

    /* renamed from: g, reason: collision with root package name */
    private final NexThemeView f20266g;

    /* renamed from: h, reason: collision with root package name */
    private C1780za f20267h;
    private final boolean i;
    private final Context j;
    private final NexEditor k;
    private boolean l;
    private int v;
    private int w;
    private boolean x;
    private com.nexstreaming.app.general.util.u<e> m = new com.nexstreaming.app.general.util.u<>();
    private com.nexstreaming.app.general.util.u<g> n = new com.nexstreaming.app.general.util.u<>();
    private com.nexstreaming.app.general.util.u<f> o = new com.nexstreaming.app.general.util.u<>();
    private com.nexstreaming.app.general.util.u<i> p = new com.nexstreaming.app.general.util.u<>();
    private com.nexstreaming.app.general.util.u<h> q = new com.nexstreaming.app.general.util.u<>();
    private com.nexstreaming.app.general.util.u<d> r = new com.nexstreaming.app.general.util.u<>();
    private com.nexstreaming.app.general.util.u<c> s = new com.nexstreaming.app.general.util.u<>();
    private Task t = new Task();
    private ExportPass u = ExportPass.Combined;
    private State y = State.Busy;
    private int z = 0;
    private AtomicInteger A = new AtomicInteger(0);
    private NexEditor.PlayState B = NexEditor.PlayState.NONE;
    private Handler C = new Handler(Looper.getMainLooper());
    private Object G = new Object();
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private Task K = new Task();
    private boolean L = false;
    private boolean M = false;
    private com.nexstreaming.app.general.util.M<k> T = new ob(this);
    private Bitmap V = null;
    private NexVideoClipItem W = null;
    private int X = 0;
    private boolean Y = false;
    private int Z = 0;
    private int aa = 0;
    private int ba = 0;
    private long ca = 0;
    private boolean da = false;
    private Runnable ea = new Na(this);
    private int fa = 0;
    private boolean ga = false;
    private Da ha = null;
    private boolean ia = false;
    private int ja = 0;
    private Set<NexLayerItem> ka = new HashSet();
    private Set<NexLayerItem> la = new HashSet();
    private Set<NexLayerItem> ma = new HashSet();
    private List<NexLayerItem> na = new ArrayList();
    private NexEditor.d oa = new cb(this);
    private com.nextreaming.nexvideoeditor.ha pa = new fb(this);
    private NexEditor.r qa = new j(this, null);

    /* loaded from: classes.dex */
    public enum ExportPass {
        Primary,
        Layers,
        Combined
    }

    /* loaded from: classes.dex */
    public enum State {
        Busy,
        Idle,
        PreparingToPlay,
        Playing,
        ReversePlay,
        Exporting,
        Transcoding,
        LoadingProject,
        MakingThumbnails,
        Seeking;

        public boolean isPlaying() {
            return this == Playing || this == ReversePlay;
        }
    }

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private NexExportProfile f20268a;

        /* renamed from: b, reason: collision with root package name */
        private File f20269b;

        /* renamed from: c, reason: collision with root package name */
        private int f20270c = 0;

        /* renamed from: d, reason: collision with root package name */
        private boolean f20271d = false;

        /* renamed from: e, reason: collision with root package name */
        private int f20272e = 0;

        /* renamed from: f, reason: collision with root package name */
        private H264Level f20273f;

        /* renamed from: g, reason: collision with root package name */
        private H264Profile f20274g;

        protected a() {
        }

        public a a(File file) {
            this.f20269b = file;
            return this;
        }

        public a b(int i) {
            this.f20272e = i;
            return this;
        }

        public a a(NexExportProfile nexExportProfile) {
            this.f20268a = nexExportProfile;
            return this;
        }

        public a a(int i) {
            if (i >= 1) {
                this.f20270c = i;
                this.f20271d = true;
                return this;
            }
            throw new IllegalArgumentException("durationLimit must be >0");
        }

        public Task a() {
            if (this.f20269b != null) {
                NexExportProfile nexExportProfile = this.f20268a;
                if (nexExportProfile != null) {
                    int width = nexExportProfile.width();
                    int height = this.f20268a.height();
                    int bitrate = this.f20268a.bitrate();
                    long a2 = C1709m.a(this.f20269b);
                    int totalTime = this.f20271d ? this.f20270c : VideoEditor.this.s().a().getTotalTime();
                    VideoEditor.this.V();
                    VideoEditor.this.R().clearUDTA();
                    VideoEditor.this.R().addUDTA(1635087464, "KineMaster");
                    NexEditor R = VideoEditor.this.R();
                    String absolutePath = this.f20269b.getAbsolutePath();
                    boolean z = this.f20271d;
                    int i = this.f20272e;
                    H264Profile h264Profile = this.f20274g;
                    int i2 = h264Profile != null ? h264Profile.value : 0;
                    H264Level h264Level = this.f20273f;
                    Task a3 = R.a(absolutePath, width, height, bitrate, a2, totalTime, z, i, i2, h264Level != null ? h264Level.value : 0, 44100, 0);
                    a3.onSuccess(new wb(this)).onFailure(new vb(this));
                    return a3;
                }
                throw new IllegalStateException("Must specify profile before exporting");
            }
            throw new IllegalStateException("Must specify output path before exporting");
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void a(Context context, VideoEditor videoEditor, boolean z);

        void a(NexLayerItem nexLayerItem, LayerRenderer layerRenderer);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(int i, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(File file);

        void c();
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(State state);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(NexTimelineItem nexTimelineItem);
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(boolean z, boolean z2);
    }

    /* loaded from: classes.dex */
    private static class j extends NexEditor.r {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<VideoEditor> f20276a;

        /* synthetic */ j(VideoEditor videoEditor, Ta ta) {
            this(videoEditor);
        }

        @Override // com.nextreaming.nexvideoeditor.NexEditor.r
        public void a() {
            VideoEditor videoEditor = this.f20276a.get();
            if (videoEditor != null) {
                videoEditor.W();
            }
        }

        private j(VideoEditor videoEditor) {
            this.f20276a = new WeakReference<>(videoEditor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        final byte[] f20277a;

        /* renamed from: b, reason: collision with root package name */
        final int f20278b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr, int i) {
            this.f20277a = bArr;
            this.f20278b = i;
        }

        public String toString() {
            return "[" + Integer.toHexString(System.identityHashCode(this)) + " t=" + this.f20278b + "]";
        }
    }

    public VideoEditor(NexEditor nexEditor, Context context, boolean z, NexThemeView nexThemeView) {
        this.i = z;
        this.j = context.getApplicationContext();
        this.k = nexEditor;
        this.f20266g = nexThemeView;
        this.k.a(this.pa);
        this.k.a(this.qa);
        this.k.a(this.oa);
        this.k.a(this.f20266g, context);
        this.T.a(500000);
        this.N = new C1730a(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context Q() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NexEditor R() {
        return this.k;
    }

    private boolean S() {
        return this.fa > 0;
    }

    private ResultTask<Bitmap> T() {
        NexVideoClipItem nexVideoClipItem;
        ResultTask<Bitmap> resultTask;
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] makeProjectThumb");
        }
        NexTimeline a2 = s().a();
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        while (true) {
            if (i3 >= a2.getPrimaryItemCount()) {
                nexVideoClipItem = null;
                break;
            }
            NexPrimaryTimelineItem primaryItem = a2.getPrimaryItem(i3);
            if (primaryItem instanceof NexVideoClipItem) {
                nexVideoClipItem = (NexVideoClipItem) primaryItem;
                if (!nexVideoClipItem.isPreset()) {
                    i2 = nexVideoClipItem.getRotation();
                    break;
                }
                if (!z) {
                    i4 = nexVideoClipItem.getSolidColor();
                    z = true;
                }
            }
            i3++;
        }
        if (this.W == nexVideoClipItem && nexVideoClipItem != null && this.X == i2 && (resultTask = this.U) != null && !resultTask.isComplete()) {
            return this.U;
        }
        ResultTask<Bitmap> resultTask2 = new ResultTask<>();
        resultTask2.makeWaitable();
        this.U = resultTask2;
        this.W = nexVideoClipItem;
        this.X = i2;
        if (nexVideoClipItem == null && z) {
            this.V = Bitmap.createBitmap(16, 9, Bitmap.Config.ARGB_8888);
            new Canvas(this.V).drawColor(i4);
            resultTask2.sendResult(this.V);
        } else if (nexVideoClipItem == null) {
            this.V = Bitmap.createBitmap(16, 9, Bitmap.Config.ARGB_8888);
            new Canvas(this.V).drawColor(ViewCompat.MEASURED_STATE_MASK);
            resultTask2.sendResult(this.V);
        } else {
            this.V = null;
            nexVideoClipItem.getThumbnail(this.j).onResultAvailable(new qb(this, nexVideoClipItem, resultTask2)).onFailure((Task.OnFailListener) new pb(this, nexVideoClipItem, resultTask2));
        }
        return resultTask2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.ja--;
        int i2 = this.ja;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        this.ja++;
        int i2 = this.ja;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        if (this.Y) {
            H();
            this.Y = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (this.da) {
            if (this.Z < 0) {
                a(State.ReversePlay);
                return;
            } else {
                a(State.Playing);
                return;
            }
        }
        if (this.x && this.B != NexEditor.PlayState.RUN) {
            a(State.Seeking);
            return;
        }
        if (this.B != NexEditor.PlayState.RUN && B()) {
            a(State.PreparingToPlay);
            return;
        }
        int i2 = gb.f20317a[this.B.ordinal()];
        if (i2 == 1) {
            a(State.Idle);
            return;
        }
        if (i2 == 2) {
            a(State.Busy);
        } else if (i2 == 3) {
            a(State.Playing);
        } else {
            if (i2 != 4) {
                return;
            }
            a(State.Exporting);
        }
    }

    private static final int a(char c2, char c3, char c4, char c5) {
        return ((c2 & 255) << 24) | ((c3 & 255) << 16) | ((c4 & 255) << 8) | (c5 & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int l(VideoEditor videoEditor) {
        int i2 = videoEditor.z;
        videoEditor.z = i2 - 1;
        return i2;
    }

    public static String u() {
        return ".kmproject";
    }

    public Task P() {
        return this.t;
    }

    public boolean z() {
        return false;
    }

    public boolean A() {
        return this.M;
    }

    public boolean B() {
        return R().k();
    }

    public boolean C() {
        return !this.J;
    }

    public Task D() {
        Task task = new Task();
        if (!this.J) {
            if (EditorGlobal.p) {
                Crashlytics.log("[VideoEditor] play():NOT_READY_TO_PLAY");
            }
            task.sendFailure(NexEditor.b.db);
            return task;
        }
        if (z()) {
            if (EditorGlobal.p) {
                Crashlytics.log("[VideoEditor] play():WRAPPER_BUSY");
            }
            task.sendFailure(NexEditor.b.cb);
            return task;
        }
        if (this.f20267h == null) {
            if (EditorGlobal.p) {
                Crashlytics.log("[VideoEditor] play():NO_PROJECT_LOADED");
            }
            task.sendFailure(NexEditor.b.fb);
            return task;
        }
        if (this.da) {
            if (EditorGlobal.p) {
                Crashlytics.log("[VideoEditor] play():IN_SIM_PLAY");
            }
            task.sendFailure(NexEditor.b.ub);
            return task;
        }
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] play():startPlay()");
        }
        R().a(new Pa(this, task));
        X();
        return task;
    }

    public Task E() {
        Task task = new Task();
        if (z()) {
            task.sendFailure(NexEditor.b.cb);
            return task;
        }
        if (this.f20267h == null) {
            task.sendFailure(NexEditor.b.fb);
            return task;
        }
        R().b(new Qa(this, task));
        return task;
    }

    public void F() {
        this.k.a(this.pa);
        this.k.a(this.qa);
        this.k.a(this.oa);
        this.k.a(this.f20266g);
    }

    public void G() {
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] redo()");
        }
        if (this.D || this.E) {
            return;
        }
        if (this.z > 0) {
            this.E = true;
        } else {
            this.T.c();
        }
    }

    public Task H() {
        NexTimeline a2;
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] refreshPreview()");
        }
        C1780za s = s();
        if (s != null && (a2 = s.a()) != null && a2.getPrimaryItemCount() > 0) {
            return a(v(), true);
        }
        R().c();
        Task task = new Task();
        task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
        return task;
    }

    public void I() {
        this.Y = true;
    }

    public Task J() {
        return d(false);
    }

    public Task K() {
        return d(true);
    }

    public Da L() {
        if (this.ha == null) {
            this.ha = new Da(this, v());
        }
        return this.ha;
    }

    public Task M() {
        a(false);
        Task task = new Task();
        if (this.da) {
            this.da = false;
            X();
            task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
            return task;
        }
        if (!B() && w() == State.Idle) {
            task.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
            return task;
        }
        SupportLogger.Event.Stop.log(new int[0]);
        R().a(new Ma(this, task));
        return task;
    }

    public Task N() {
        NexTimeline a2;
        C1780za s = s();
        if (s != null && (a2 = s.a()) != null) {
            return c(a2);
        }
        return Task.COMPLETED_TASK;
    }

    public void O() {
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] undo()");
        }
        if (this.D || this.E) {
            return;
        }
        if (this.z > 0) {
            this.D = true;
        } else {
            this.T.d();
        }
    }

    public boolean h() {
        return this.T.b();
    }

    public boolean i() {
        return R().b();
    }

    public int j() {
        return R().clearTrackCache();
    }

    public void k() {
        this.T.b(new k(s().a().asProtoBuf().toByteArray(), 0));
    }

    public void l() {
        this.fa--;
        int i2 = this.fa;
        if (i2 >= 0) {
            if (i2 == 0 && this.ga) {
                this.ga = false;
                c(s().a());
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public a m() {
        return new a();
    }

    public NexEditor.c n() {
        return R().a();
    }

    public int o() {
        return this.w;
    }

    public Task p() {
        Da da = this.ha;
        Task a2 = da != null ? da.a() : null;
        if (a2 != null) {
            return a2;
        }
        Task task = new Task();
        task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
        return task;
    }

    public b q() {
        WeakReference<b> weakReference = this.S;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int r() {
        if (this.da) {
            return this.Z;
        }
        return 0;
    }

    public C1780za s() {
        return this.f20267h;
    }

    public File t() {
        return this.F;
    }

    public int v() {
        return this.v;
    }

    public State w() {
        return this.y;
    }

    public int x() {
        NexThemeView nexThemeView = this.f20266g;
        if (nexThemeView != null) {
            return nexThemeView.getHeight();
        }
        return 0;
    }

    public int y() {
        NexThemeView nexThemeView = this.f20266g;
        if (nexThemeView != null) {
            return nexThemeView.getWidth();
        }
        return 0;
    }

    public void f() {
        this.fa++;
    }

    public boolean g() {
        return this.T.a();
    }

    public static NexProjectHeader c(File file) throws IOException {
        NexProjectHeader fromProtoBuf;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] bArr = new byte[4];
            bufferedInputStream.mark(bArr.length);
            int read = bufferedInputStream.read(bArr);
            bufferedInputStream.reset();
            if (read < bArr.length) {
                bufferedInputStream.close();
                return null;
            }
            if (bArr[0] == -84 && bArr[1] == -19) {
                ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
                try {
                    Object readObject = objectInputStream.readObject();
                    if (readObject instanceof NexProjectHeader) {
                        NexProjectHeader nexProjectHeader = (NexProjectHeader) readObject;
                        bufferedInputStream.close();
                        return nexProjectHeader;
                    }
                    bufferedInputStream.close();
                    return null;
                } catch (ClassNotFoundException e2) {
                    Log.e("VideoEditor", "readHeader - damaged", e2);
                    bufferedInputStream.close();
                    return null;
                } finally {
                    objectInputStream.close();
                }
            }
            if (bArr[0] != -13 || bArr[1] != 75 || bArr[2] != 77 || bArr[3] != -22) {
                bufferedInputStream.close();
                return null;
            }
            HeaderDelimitedInputStream headerDelimitedInputStream = new HeaderDelimitedInputStream(bufferedInputStream);
            headerDelimitedInputStream.parseFileHeader();
            while (headerDelimitedInputStream.nextSection()) {
                if (headerDelimitedInputStream.getSectionFourCC() == f20261b && (fromProtoBuf = NexProjectHeader.fromProtoBuf((KMProto.KMProjectHeader) WireInstance.get().a(headerDelimitedInputStream, KMProto.KMProjectHeader.class))) != null) {
                    bufferedInputStream.close();
                    return fromProtoBuf;
                }
            }
            bufferedInputStream.close();
            return null;
        } catch (Throwable th) {
            bufferedInputStream.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task d(boolean z) {
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] saveProject:" + z);
        }
        Task task = new Task();
        NexTimeline a2 = s().a();
        ResultTask<Bitmap> T = T();
        boolean z2 = !this.I && a2.getPrimaryItemCount() < 1 && a2.getSecondaryItemCount() < 1;
        NexProjectHeader projectHeader = a2.getProjectHeader();
        StringBuilder sb = new StringBuilder();
        sb.append("v");
        String str = projectHeader.savedWithKMVersionName;
        sb.append(str == null ? "3" : str.replace(".", io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR));
        String sb2 = sb.toString();
        NexProjectHeader nexProjectHeader = new NexProjectHeader(projectHeader);
        nexProjectHeader.lastEditTime = new Date();
        nexProjectHeader.totalPlayTime = a2.getTotalTime();
        nexProjectHeader.savedWithKMVersion = 14242;
        nexProjectHeader.savedOnPlatform = KMProto.Platform.ANDROID;
        nexProjectHeader.savedWithKMVersionName = "4.11.15.14242";
        int v = v();
        KMProto.KMProject asProtoBuf = a2.asProtoBuf();
        this.z++;
        new sb(this, asProtoBuf, T, nexProjectHeader, this.A.incrementAndGet(), z2, sb2, projectHeader, z, v, task).execute(new Void[0]);
        return task;
    }

    public void e(NexLayerItem nexLayerItem) {
        long backmostLayerZOrder = s().a().getBackmostLayerZOrder();
        if (nexLayerItem.getZOrder() > backmostLayerZOrder) {
            nexLayerItem.setZOrder(backmostLayerZOrder - 1);
        }
    }

    public void b(e eVar) {
        this.m.b(eVar);
    }

    public VideoEditor b(g gVar) {
        this.n.b(gVar);
        return this;
    }

    public VideoEditor b(f fVar) {
        this.o.b(fVar);
        return this;
    }

    public void b(h hVar) {
        this.q.b(hVar);
    }

    public VideoEditor b(c cVar) {
        this.s.b(cVar);
        return this;
    }

    public void b(i iVar) {
        this.p.b(iVar);
    }

    public Task b(File file) {
        Task task = new Task();
        new hb(this, file, task).execute(new Void[0]);
        return task;
    }

    public void b(String str) {
        R().setProjectEffect(str);
        Task task = this.K;
        if (task != null) {
            task.signalEvent(Task.Event.COMPLETE);
            this.K = null;
        }
    }

    public void a(e eVar) {
        this.m.a((com.nexstreaming.app.general.util.u<e>) eVar);
    }

    public void a(d dVar) {
        this.r.a((com.nexstreaming.app.general.util.u<d>) dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, int i3) {
        if (this.v == i2 && this.w == i3) {
            return;
        }
        this.v = i2;
        this.w = i3;
        this.n.a(new ub(this));
    }

    public VideoEditor a(g gVar) {
        this.n.a((com.nexstreaming.app.general.util.u<g>) gVar);
        return this;
    }

    public VideoEditor a(f fVar) {
        this.o.a((com.nexstreaming.app.general.util.u<f>) fVar);
        return this;
    }

    public void a(h hVar) {
        this.q.a((com.nexstreaming.app.general.util.u<h>) hVar);
    }

    public VideoEditor a(c cVar) {
        this.s.a((com.nexstreaming.app.general.util.u<c>) cVar);
        return this;
    }

    public void a(i iVar) {
        this.p.a((com.nexstreaming.app.general.util.u<i>) iVar);
        this.C.post(new Ta(this, iVar));
    }

    public Task b(int i2) {
        if (this.da) {
            Task task = new Task();
            task.sendFailure(NexEditor.b.f24596g);
            return task;
        }
        return b(i2, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task a(byte[] bArr) {
        return a((InputStream) new ByteArrayInputStream(bArr), this.F, true);
    }

    private void d(int i2) {
        b(i2, this.w);
    }

    public Task a(File file) {
        try {
            return a((InputStream) new FileInputStream(file), file, false);
        } catch (FileNotFoundException e2) {
            Task task = new Task();
            task.sendFailure(Task.makeTaskError("File not found", e2));
            return task;
        }
    }

    public void d(NexLayerItem nexLayerItem) {
        synchronized (this.G) {
            this.ma.add(nexLayerItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task b(int i2, boolean z, boolean z2) {
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] seekInternal(" + i2 + "," + z + "," + z2 + ")");
        }
        SupportLogger.Event event = SupportLogger.Event.Seek;
        int[] iArr = new int[2];
        iArr[0] = i2;
        iArr[1] = (z ? 1 : 0) + (z2 ? 2 : 0);
        event.log(iArr);
        Task task = new Task();
        if (this.ha != null) {
            SupportLogger.Event.SeekFail.log(8);
            task.sendFailure(NexEditor.b.db);
            return task;
        }
        if (!this.J) {
            SupportLogger.Event.SeekFail.log(1);
            task.sendFailure(NexEditor.b.db);
            return task;
        }
        if (this.H) {
            SupportLogger.Event.SeekFail.log(2);
            task.sendFailure(NexEditor.b.eb);
            return task;
        }
        if (z()) {
            SupportLogger.Event.SeekFail.log(3);
            task.sendFailure(NexEditor.b.cb);
            return task;
        }
        if (this.f20267h == null) {
            SupportLogger.Event.SeekFail.log(4);
            task.sendFailure(NexEditor.b.fb);
            return task;
        }
        d(i2);
        Task task2 = this.K;
        if (task2 != null && task2.isRunning()) {
            SupportLogger.Event.SeekDeferred.log(new int[0]);
            this.K.onComplete(new Ia(this, i2, z2, task));
        } else if (MediaInfo.X()) {
            SupportLogger.Event.SeekDeferred.log(new int[0]);
            MediaInfo.aa().onComplete(new Ka(this, i2, z2, task));
        } else {
            R().a(i2, z2, new La(this, task));
        }
        return task;
    }

    private Task a(InputStream inputStream, File file, boolean z) {
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] loadProject");
        }
        Q();
        Task task = new Task();
        new lb(this, Q(), inputStream, z, file, z, task).execute(new Void[0]);
        return task;
    }

    private void d(NexTimelineItem nexTimelineItem) {
        if (!(nexTimelineItem instanceof NexTransitionItem)) {
            NexTimeline a2 = s().a();
            if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
                a2.deletePrimaryItem(a2.getIndexOfPrimaryItem((NexPrimaryTimelineItem) nexTimelineItem));
                return;
            } else {
                if (nexTimelineItem instanceof NexSecondaryTimelineItem) {
                    a2.deleteSecondaryItem((NexSecondaryTimelineItem) nexTimelineItem);
                    if (nexTimelineItem instanceof EffectLayer) {
                        ((EffectLayer) nexTimelineItem).releaseTexture();
                        return;
                    }
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("Transitions cannot be deleted.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Task.TaskError taskError) {
        NexThemeView nexThemeView = this.f20266g;
        if (nexThemeView == null || nexThemeView.getWindowToken() == null || SystemClock.uptimeMillis() <= f20264e + 1500) {
            return;
        }
        f20264e = SystemClock.uptimeMillis();
        Context context = this.f20266g.getContext();
        e.a aVar = new e.a(context);
        aVar.e(R.string.project_save_fail_title);
        if (taskError == NexEditor.b.vb) {
            aVar.c(R.string.project_save_fail_storage);
        } else {
            aVar.c(R.string.project_save_fail_other);
            aVar.b(taskError.getLocalizedMessage(context));
        }
        aVar.c(R.string.button_ok, new tb(this));
        aVar.a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        b(this.v, i2);
    }

    public void c(NexLayerItem nexLayerItem) {
        synchronized (this.G) {
            this.la.add(nexLayerItem);
        }
    }

    public void c(NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem != null) {
            this.q.a(new Ra(this, nexTimelineItem));
            if (nexTimelineItem instanceof NexLayerItem) {
                synchronized (this.G) {
                    this.la.add((NexLayerItem) nexTimelineItem);
                }
                if (nexTimelineItem instanceof VideoLayer) {
                    c(s().a());
                    return;
                }
                return;
            }
            c(s().a());
            return;
        }
        c(s().a());
    }

    private void a(State state) {
        if (this.y != state) {
            this.y = state;
            this.o.a(new Ga(this));
        }
    }

    public Task a(int i2, boolean z, boolean z2) {
        Task b2 = b(i2, z, z2);
        b(true);
        return b2;
    }

    public Task a(int i2, boolean z) {
        if (this.da) {
            Task task = new Task();
            task.sendFailure(NexEditor.b.f24596g);
            return task;
        }
        return b(i2, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task c(NexTimeline nexTimeline) {
        int i2;
        boolean z;
        if (S()) {
            this.ga = true;
            return Task.COMPLETED_TASK;
        }
        Task task = new Task();
        NexEditor R = R();
        nexTimeline.recalculateResourceUsage();
        if (R == null) {
            task.sendFailure(NexEditor.b._a);
            return task;
        }
        a(nexTimeline);
        nexTimeline.applyProjectSettingsToEditor(R, this.u);
        nexTimeline.requestCalcTimes();
        int primaryItemCount = this.u == ExportPass.Layers ? 1 : (nexTimeline.getPrimaryItemCount() + 1) / 2;
        int secondaryItemCount = nexTimeline.getSecondaryItemCount();
        if (primaryItemCount > 0) {
            i2 = 0;
            for (int i3 = 0; i3 < secondaryItemCount; i3++) {
                NexSecondaryTimelineItem secondaryItem = nexTimeline.getSecondaryItem(i3);
                if ((secondaryItem instanceof VideoLayer) && !secondaryItem.getOverLimit()) {
                    i2++;
                }
            }
        } else {
            i2 = 0;
        }
        int totalTime = nexTimeline.getTotalTime();
        nexTimeline.getTotalSecondaryTime();
        NexVisualClip[] nexVisualClipArr = new NexVisualClip[(this.u == ExportPass.Primary ? 0 : i2) + primaryItemCount];
        ArrayList arrayList = new ArrayList();
        if (this.u == ExportPass.Layers) {
            NexVisualClip nexVisualClip = new NexVisualClip();
            nexVisualClip.mClipID = 10;
            nexVisualClip.mTotalTime = totalTime;
            nexVisualClip.mStartTime = 0;
            nexVisualClip.mEndTime = nexVisualClip.mTotalTime;
            nexVisualClip.mClipType = 4;
            nexVisualClip.mClipPath = this.O;
            nexVisualClip.mStartRect = new NexRectangle(0, 0, NexVideoClipItem.ABSTRACT_DIMENSION, NexVideoClipItem.ABSTRACT_DIMENSION);
            nexVisualClip.mEndRect = new NexRectangle(0, 0, NexVideoClipItem.ABSTRACT_DIMENSION, NexVideoClipItem.ABSTRACT_DIMENSION);
            nexVisualClip.mClipEffectID = NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
            nexVisualClip.mVolumeEnvelopeLevel = new int[]{100, 100};
            nexVisualClip.mVolumeEnvelopeTime = new int[]{0, nexVisualClip.mTotalTime};
            nexVisualClip.mClipVolume = 100;
            nexVisualClip.mAudioOnOff = 1;
            nexVisualClipArr[0] = nexVisualClip;
        } else {
            int i4 = 0;
            for (int i5 = 0; i5 < primaryItemCount; i5++) {
                NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexTimeline.getPrimaryItem(i5 * 2);
                if (!nexVideoClipItem.isReadyToPlay()) {
                    z = false;
                    break;
                }
                nexVisualClipArr[i5] = nexVideoClipItem.asNexVisualClip();
                nexVisualClipArr[i5].mStartTime = i4;
                i4 = nexVisualClipArr[i5].mEndTime - nexVideoClipItem.getTransition().getTransitionOverlap();
                if (!nexVideoClipItem.getTransition().isSet() && nexVideoClipItem.getTrimTimeEnd() > 0 && nexVideoClipItem.getNextClip() != null && nexVideoClipItem.getClipVolume() > 0 && !nexVideoClipItem.getMuteAudio() && (nexVideoClipItem.calcSplitClipFadeFlags() & NexVideoClipItem.FLAG_FADE_OUT) != 0) {
                    nexVisualClipArr[i5].mAudioOnOff = 0;
                    arrayList.add(nexVideoClipItem.asNexAudioClip());
                }
            }
        }
        z = true;
        if (primaryItemCount > 0) {
            if (i2 > 0) {
                int i6 = primaryItemCount + 0;
                for (int i7 = 0; i7 < secondaryItemCount; i7++) {
                    NexSecondaryTimelineItem secondaryItem2 = nexTimeline.getSecondaryItem(i7);
                    if ((secondaryItem2 instanceof VideoLayer) && !secondaryItem2.getOverLimit()) {
                        if (this.u == ExportPass.Primary) {
                            arrayList.add(((VideoLayer) secondaryItem2).asNexAudioClip());
                        } else {
                            nexVisualClipArr[i6] = ((VideoLayer) secondaryItem2).asNexVisualClip();
                            if (this.u == ExportPass.Layers) {
                                nexVisualClipArr[i6].mClipVolume = 0;
                            }
                            i6++;
                        }
                    }
                }
            }
            if (this.u != ExportPass.Layers) {
                int i8 = 0;
                while (true) {
                    if (i8 >= secondaryItemCount) {
                        break;
                    }
                    NexSecondaryTimelineItem secondaryItem3 = nexTimeline.getSecondaryItem(i8);
                    if (!secondaryItem3.isReadyToPlay()) {
                        z = false;
                        break;
                    }
                    if ((secondaryItem3 instanceof NexAudioClipItem) && !secondaryItem3.getOverLimit() && secondaryItem3.checkResourceState(this.j)) {
                        arrayList.add(((NexAudioClipItem) secondaryItem3).asNexAudioClip());
                    }
                    i8++;
                }
            }
        }
        if (!z) {
            R.a((NexVisualClip[]) null, (NexAudioClip[]) null);
            this.J = false;
            task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
            return task;
        }
        if (this.i && primaryItemCount == 1 && nexVisualClipArr[0].mClipType == 1 && nexVisualClipArr[0].mTotalTime < 1000) {
            nexVisualClipArr[0].mTotalTime = 1001;
            nexVisualClipArr[0].mEndTime = 1001;
        }
        if (nexVisualClipArr.length < 1) {
            R.a((NexVisualClip[]) null, (NexAudioClip[]) null);
            R.c();
            this.J = false;
            task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
            return task;
        }
        this.J = true;
        Task onComplete = R.a(nexVisualClipArr, (NexAudioClip[]) arrayList.toArray(new NexAudioClip[arrayList.size()])).onComplete(new Va(this));
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] syncEditorToTimeline");
        }
        return onComplete;
    }

    public void a(boolean z) {
        this.M = z;
    }

    public void a(int i2) {
        M();
        this.Z = i2;
        this.da = true;
        this.aa = v();
        this.ca = System.nanoTime();
        this.ba = s().a().getTotalTime();
        this.C.removeCallbacks(this.ea);
        this.C.post(this.ea);
        X();
    }

    public void b(NexTimelineItem nexTimelineItem) {
        d(nexTimelineItem);
    }

    private void b(NexTimeline nexTimeline) {
        String effectItemID;
        NexEditor R = R();
        if (R == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        int primaryItemCount = nexTimeline.getPrimaryItemCount();
        for (int i2 = 0; i2 < primaryItemCount; i2++) {
            NexPrimaryTimelineItem primaryItem = nexTimeline.getPrimaryItem(i2);
            if (primaryItem instanceof NexTransitionItem) {
                String effectItemID2 = ((NexTransitionItem) primaryItem).getEffectItemID();
                if (effectItemID2 != null) {
                    hashSet.add(effectItemID2);
                }
            } else if ((primaryItem instanceof NexVideoClipItem) && (effectItemID = ((NexVideoClipItem) primaryItem).getEffectItemID()) != null) {
                hashSet.add(effectItemID);
            }
        }
        com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(hashSet, R, this.i);
        com.nexstreaming.app.general.nexasset.assetpackage.h.e().b(hashSet, R, this.i);
    }

    public void a(int i2, int i3) {
        NexTimeline a2 = s().a();
        int primaryItemCount = a2.getPrimaryItemCount();
        int max = Math.max(0, Math.min(primaryItemCount - 1, i2));
        int max2 = Math.max(0, Math.min(primaryItemCount + 1, i3));
        int i4 = max - (max % 2);
        int i5 = max2 - (max2 % 2);
        if (i4 == i5) {
            return;
        }
        NexTimeline.c beginTimeChange = a2.beginTimeChange();
        a2.movePrimaryItem(i4, i5);
        beginTimeChange.apply();
        c(s().a());
    }

    public void b(NexLayerItem nexLayerItem) {
        long frontmostLayerZOrder = s().a().getFrontmostLayerZOrder();
        if (nexLayerItem.getZOrder() < frontmostLayerZOrder) {
            nexLayerItem.setZOrder(frontmostLayerZOrder + 1);
        }
    }

    public void b(NexLayerItem nexLayerItem, int i2) {
        if (nexLayerItem == null || s() == null || s().a() == null) {
            return;
        }
        List<NexSecondaryTimelineItem> secondaryItems = s().a().getSecondaryItems();
        long zOrder = nexLayerItem.getZOrder();
        NexLayerItem nexLayerItem2 = null;
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : secondaryItems) {
            if (nexSecondaryTimelineItem instanceof NexLayerItem) {
                NexLayerItem nexLayerItem3 = (NexLayerItem) nexSecondaryTimelineItem;
                if (i2 >= nexLayerItem3.getAbsStartTime() && i2 <= nexLayerItem3.getAbsEndTime() && nexLayerItem3.getZOrder() < zOrder && (nexLayerItem2 == null || nexLayerItem2.getZOrder() < nexLayerItem3.getZOrder())) {
                    nexLayerItem2 = nexLayerItem3;
                }
            }
        }
        if (nexLayerItem2 != null) {
            long zOrder2 = nexLayerItem2.getZOrder();
            nexLayerItem2.setZOrder(nexLayerItem.getZOrder());
            nexLayerItem.setZOrder(zOrder2);
        }
    }

    public void a(NexTimelineItem nexTimelineItem) {
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] deleteClip");
        }
        NexTimeline.c beginTimeChange = s().a().beginTimeChange();
        d(nexTimelineItem);
        beginTimeChange.apply();
        c(s().a());
    }

    private void a(NexTimeline nexTimeline) {
        b(nexTimeline);
    }

    public Task a(ExportPass exportPass) {
        this.u = exportPass;
        return N();
    }

    public void a(String str) {
        this.O = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Da da, int i2) {
        if (da == this.ha) {
            this.ha = null;
            c(s().a()).onComplete(new Sa(this, i2));
        }
    }

    public boolean a(NexEditor.FastPreviewOption fastPreviewOption, int i2, boolean z) {
        return R().a(fastPreviewOption, i2, z);
    }

    public ResultTask<File> a(SurfaceView surfaceView) {
        ResultTask<File> resultTask = new ResultTask<>();
        MediaInfo.aa().onComplete(new bb(this, surfaceView, resultTask));
        return resultTask;
    }

    public void b(boolean z) {
        this.H = z;
    }

    public NexVideoClipItem a(int i2, MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, int i3, boolean z) {
        return a(i2, mediaStoreItemId, cVar, i3, z, true);
    }

    private NexVideoClipItem a(int i2, MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, int i3, boolean z, boolean z2) {
        NexVideoClipItem newInstance;
        if (i2 % 2 == 1) {
            i2++;
        }
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] addVisualClipInternal");
        }
        NexTimeline a2 = s().a();
        NexTimeline.c beginTimeChange = a2.beginTimeChange();
        if (cVar != null) {
            newInstance = NexVideoClipItem.newInstance(a2.nextAvailableEngineClipId(), cVar, i3, z);
        } else {
            newInstance = NexVideoClipItem.newInstance(a2.nextAvailableEngineClipId(), mediaStoreItemId, z);
        }
        if (cVar != null && mediaStoreItemId.getNamespace().equals("Backgrounds")) {
            newInstance.applyFinalPath(mediaStoreItemId, cVar.getPath(), NexVideoClipItem.CropMode.FILL, i3);
        }
        newInstance.checkResourceState(Q());
        a2.addPrimaryItem(i2, newInstance);
        if (z2) {
            beginTimeChange.apply();
        }
        c(a2);
        return newInstance;
    }

    public NexVideoClipItem a(NexVideoClipItem nexVideoClipItem, int i2, MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, boolean z, boolean z2) {
        NexVideoClipItem newInstance;
        if (i2 % 2 == 1) {
            i2++;
        }
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] replaceVisualClipInternal");
        }
        NexTimeline a2 = s().a();
        NexTimeline.c beginTimeChange = a2.beginTimeChange();
        int absEndTime = nexVideoClipItem.getAbsEndTime() - nexVideoClipItem.getAbsStartTime();
        if (cVar != null) {
            newInstance = NexVideoClipItem.newInstance(a2.nextAvailableEngineClipId(), cVar, absEndTime, z);
        } else {
            newInstance = NexVideoClipItem.newInstance(a2.nextAvailableEngineClipId(), mediaStoreItemId, z);
        }
        newInstance.applyFinalPath(mediaStoreItemId, cVar.getPath(), NexVideoClipItem.CropMode.FILL, absEndTime);
        newInstance.checkResourceState(Q());
        newInstance.copyOptions(nexVideoClipItem);
        b(nexVideoClipItem);
        a2.addPrimaryItem(i2, newInstance);
        if (z2) {
            beginTimeChange.apply();
        }
        c(a2);
        return newInstance;
    }

    public void a(NexLayerItem nexLayerItem) {
        String str;
        if (EditorGlobal.p) {
            if (("[VideoEditor] addLayer: " + nexLayerItem) == null) {
                str = "null";
            } else {
                str = Integer.toString(nexLayerItem.getDuration()) + " unlimited_layers:" + EditorGlobal.w();
            }
            Crashlytics.log(str);
        }
        C1780za s = s();
        if (s != null) {
            s.a().addLayer(nexLayerItem);
            KMEvents.EDIT_ADD_LAYER.trackAddLayer(nexLayerItem, "Success");
        } else {
            Crashlytics.log("[VideoEditor] addLayer(project is null");
        }
    }

    public void c(boolean z) {
        this.k.b(z);
    }

    public void a(NexLayerItem nexLayerItem, int i2) {
        if (nexLayerItem == null || s() == null || s().a() == null) {
            return;
        }
        List<NexSecondaryTimelineItem> secondaryItems = s().a().getSecondaryItems();
        long zOrder = nexLayerItem.getZOrder();
        NexLayerItem nexLayerItem2 = null;
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : secondaryItems) {
            if (nexSecondaryTimelineItem instanceof NexLayerItem) {
                NexLayerItem nexLayerItem3 = (NexLayerItem) nexSecondaryTimelineItem;
                if (i2 >= nexLayerItem3.getAbsStartTime() && i2 <= nexLayerItem3.getAbsEndTime() && nexLayerItem3.getZOrder() > zOrder && (nexLayerItem2 == null || nexLayerItem2.getZOrder() > nexLayerItem3.getZOrder())) {
                    nexLayerItem2 = nexLayerItem3;
                }
            }
        }
        if (nexLayerItem2 != null) {
            long zOrder2 = nexLayerItem2.getZOrder();
            nexLayerItem2.setZOrder(nexLayerItem.getZOrder());
            nexLayerItem.setZOrder(zOrder2);
        }
    }

    public NexAudioClipItem a(int i2, String str, boolean z) {
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] addAudioClip");
        }
        NexTimeline a2 = s().a();
        NexAudioClipItem newInstance = NexAudioClipItem.newInstance(a2.nextAvailableEngineClipId(), str);
        newInstance.checkResourceState(Q());
        a2.addSecondaryItem(newInstance);
        newInstance.setPinned(z);
        newInstance.moveClip(i2);
        c(a2);
        return newInstance;
    }

    public int a(String str, int i2, int i3, int i4) {
        this.l = true;
        return R().startVoiceRecorder(str, i2, i3, i4);
    }

    public int a(byte[] bArr, int i2) {
        return R().processVoiceRecorder(bArr, i2);
    }

    public int a(NexClipInfo nexClipInfo) {
        this.l = false;
        return R().endVoiceRecorder(nexClipInfo);
    }

    public <T extends NexSecondaryTimelineItem> T a(T t) {
        T t2 = (T) NexTimeline.secondaryItemFromProtoBuf(t.asProtoBuf());
        t2.setUniqueId(null);
        t2.getUniqueId();
        if (t2 instanceof NexAudioClipItem) {
            ((NexAudioClipItem) t2).setEngineClipIDAfterDuplicate(s().a().nextAvailableEngineClipId());
        } else if (t2 instanceof VideoLayer) {
            ((VideoLayer) t2).setEngineClipIDAfterDuplicate(s().a().nextAvailableEngineClipId());
        }
        if (t2 instanceof NexLayerItem) {
            ((NexLayerItem) t2).setZOrder(s().a().getFrontmostLayerZOrder() + 1);
        }
        s().a().addSecondaryItem(t2);
        t2.checkResourceState(Q());
        return t2;
    }

    public <T extends NexPrimaryTimelineItem> T a(T t) {
        return (T) a((VideoEditor) t, false);
    }

    public <T extends NexPrimaryTimelineItem> T a(T t, boolean z) {
        NexTimeline a2 = s().a();
        T t2 = (T) NexTimeline.primaryItemFromProtoBuf(t.asProtoBuf());
        t2.setUniqueId(null);
        t2.getUniqueId();
        t2.onDuplicated(a2.nextAvailableEngineClipId());
        a2.addPrimaryItem(a2.getIndexOfPrimaryItem(t) + (z ? 2 : 0), t2);
        t2.checkResourceState(Q());
        return t2;
    }

    public Task a(NexTimelineItem nexTimelineItem, int i2, MediaStore mediaStore) {
        Task task = new Task();
        if (nexTimelineItem == null) {
            task.signalEvent(Task.Event.FAIL);
            return task;
        }
        if (nexTimelineItem != null && (nexTimelineItem instanceof NexVideoClipItem)) {
            NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexTimelineItem;
            int trimTimeStart = nexVideoClipItem.getTrimTimeStart();
            int duration = nexVideoClipItem.getDuration();
            int absStartTime = i2 - nexVideoClipItem.getAbsStartTime();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            nexVideoClipItem.getStartPositionRaw(rect);
            nexVideoClipItem.getEndPositionRaw(rect2);
            if (!nexVideoClipItem.isImage()) {
                nexVideoClipItem.setTrimStart(((nexVideoClipItem.getPlaybackSpeed() * absStartTime) / 100) + trimTimeStart);
            }
            if (!nexVideoClipItem.isImage()) {
                absStartTime = nexVideoClipItem.getTrimTimeStart() - trimTimeStart;
            }
            int i3 = (absStartTime * 100) / duration;
            rect2.left = nexVideoClipItem.calcPos(rect.left, rect2.left, i3);
            rect2.top = nexVideoClipItem.calcPos(rect.top, rect2.top, i3);
            rect2.right = nexVideoClipItem.calcPos(rect.right, rect2.right, i3);
            rect2.bottom = nexVideoClipItem.calcPos(rect.bottom, rect2.bottom, i3);
            if (nexVideoClipItem.isImage()) {
                nexVideoClipItem.setDuration(duration - absStartTime);
            }
            if (nexVideoClipItem.isCropLink()) {
                nexVideoClipItem.setStartPositionRaw(rect);
            } else {
                nexVideoClipItem.setStartPositionRaw(rect2);
            }
            int effectStartTime = nexVideoClipItem.getEffectStartTime();
            int effectEndTime = nexVideoClipItem.getEffectEndTime();
            nexVideoClipItem.checkEffectTime(effectStartTime, effectEndTime, 1);
            nexVideoClipItem.getTransition().ensureTransitionFits();
            c(nexVideoClipItem);
            s().a().getIndexOfPrimaryItem(nexVideoClipItem);
            NexVideoClipItem nexVideoClipItem2 = (NexVideoClipItem) a((VideoEditor) nexVideoClipItem);
            if (nexVideoClipItem2 != null) {
                c(nexVideoClipItem2);
                nexVideoClipItem2.checkResourceState(Q());
                nexVideoClipItem2.setStartPositionRaw(rect);
                nexVideoClipItem2.setEndPositionRaw(rect2);
                if (nexVideoClipItem2.isImage()) {
                    nexVideoClipItem2.setDuration(absStartTime);
                } else {
                    nexVideoClipItem2.setTrimStart(trimTimeStart);
                    nexVideoClipItem2.setTrimEnd(duration - (trimTimeStart + absStartTime));
                }
                nexVideoClipItem2.checkEffectTime(effectStartTime, effectEndTime, 2);
                c(nexVideoClipItem2);
                nexVideoClipItem2.setEffectID(nexVideoClipItem.getEffectID());
                if (nexVideoClipItem2.getPreviousClip() != null) {
                    nexVideoClipItem2.getPrecedingTransition().ensureTransitionFits();
                }
            }
            task.signalEvent(Task.Event.COMPLETE);
        } else if (nexTimelineItem != null && (nexTimelineItem instanceof NexAudioClipItem)) {
            s().a();
            NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) nexTimelineItem;
            if (nexAudioClipItem.getAudioSplitState()) {
                task.signalEvent(Task.Event.FAIL);
                return task;
            }
            nexAudioClipItem.setAudioSplitState(true);
            int startTime = nexAudioClipItem.getStartTime();
            nexAudioClipItem.trimClip(i2, nexAudioClipItem.getEndTime());
            nexAudioClipItem.checkResourceState(Q());
            c(nexAudioClipItem);
            NexAudioClipItem nexAudioClipItem2 = (NexAudioClipItem) a((VideoEditor) nexAudioClipItem);
            nexAudioClipItem2.trimClip(startTime, i2);
            nexAudioClipItem2.checkResourceState(Q());
            c(nexAudioClipItem2);
            nexAudioClipItem.setAudioSplitState(false);
            task.signalEvent(Task.Event.COMPLETE);
        } else if (nexTimelineItem != null && (nexTimelineItem instanceof NexLayerItem)) {
            NexTimeline a2 = s().a();
            NexLayerItem nexLayerItem = (NexLayerItem) nexTimelineItem;
            int startTime2 = nexLayerItem.getStartTime();
            List<NexLayerItem.b> keyFramesIgnoreSplitScreen = nexLayerItem.getKeyFramesIgnoreSplitScreen();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            NexLayerItem.b interpolatedKeyframeIgnoreSplitScreen = nexLayerItem.getInterpolatedKeyframeIgnoreSplitScreen((i2 - startTime2) / nexLayerItem.getDuration());
            if (keyFramesIgnoreSplitScreen != null && keyFramesIgnoreSplitScreen.size() > 1) {
                Log.d("VideoEditor", "splitClip interpolate key frame : " + interpolatedKeyframeIgnoreSplitScreen.toString());
                for (NexLayerItem.b bVar : keyFramesIgnoreSplitScreen) {
                    Log.d("VideoEditor", "splitClip key frame: " + bVar.toString());
                    if (bVar.f20230a < interpolatedKeyframeIgnoreSplitScreen.f20230a) {
                        NexLayerItem.b bVar2 = new NexLayerItem.b(bVar);
                        bVar2.f20230a /= interpolatedKeyframeIgnoreSplitScreen.f20230a;
                        arrayList.add(bVar2);
                    } else {
                        if (arrayList2.size() <= 0) {
                            NexLayerItem.b bVar3 = new NexLayerItem.b(interpolatedKeyframeIgnoreSplitScreen);
                            bVar3.f20230a = 0.0f;
                            arrayList2.add(bVar3);
                        }
                        NexLayerItem.b bVar4 = new NexLayerItem.b(bVar);
                        float f2 = bVar4.f20230a;
                        float f3 = interpolatedKeyframeIgnoreSplitScreen.f20230a;
                        bVar4.f20230a = (f2 - f3) / (1.0f - f3);
                        arrayList2.add(bVar4);
                    }
                }
                NexLayerItem.b bVar5 = new NexLayerItem.b(interpolatedKeyframeIgnoreSplitScreen);
                bVar5.f20230a = 1.0f;
                arrayList.add(bVar5);
            } else {
                NexLayerItem.b closestKeyframe = nexLayerItem.getClosestKeyframe(0.0f);
                if (keyFramesIgnoreSplitScreen.size() == 1) {
                    closestKeyframe = keyFramesIgnoreSplitScreen.get(0);
                }
                arrayList.add(closestKeyframe);
                arrayList2.add(new NexLayerItem.b(closestKeyframe));
            }
            nexLayerItem.trimClip(i2, nexLayerItem.getEndTime());
            nexLayerItem.removeAllKeyframe();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                nexLayerItem.addKeyframeWithoutCheck((NexLayerItem.b) it.next());
            }
            nexLayerItem.checkResourceState(Q());
            c((NexTimelineItem) nexLayerItem);
            NexLayerItem nexLayerItem2 = (NexLayerItem) a((VideoEditor) nexLayerItem);
            nexLayerItem2.trimClip(startTime2, i2 - 1);
            nexLayerItem2.removeAllKeyframe();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                nexLayerItem2.addKeyframeWithoutCheck((NexLayerItem.b) it2.next());
            }
            c((NexTimelineItem) nexLayerItem2);
            nexLayerItem2.checkResourceState(Q());
            a2.requestCalcTimes();
            task.signalEvent(Task.Event.COMPLETE);
        }
        return task;
    }

    public void a(Object obj, NexLayerItem nexLayerItem, b bVar, b bVar2) {
        WeakReference<Object> weakReference = this.P;
        Object obj2 = weakReference == null ? null : weakReference.get();
        WeakReference<b> weakReference2 = this.R;
        b bVar3 = weakReference2 == null ? null : weakReference2.get();
        WeakReference<b> weakReference3 = this.S;
        b bVar4 = weakReference3 == null ? null : weakReference3.get();
        if (nexLayerItem == null) {
            if (obj != obj2 && obj2 != null) {
                return;
            }
            bVar = null;
            bVar2 = null;
        }
        if (bVar3 != bVar && bVar3 != null) {
            bVar3.a();
        }
        if (bVar4 != bVar2 && bVar4 != null) {
            bVar4.a();
        }
        if (bVar3 != bVar && bVar != null) {
            bVar.a(Q(), this, false);
        }
        if (bVar4 != bVar2 && bVar2 != null) {
            bVar2.a(Q(), this, true);
        }
        if (nexLayerItem == null) {
            this.Q = null;
            this.R = null;
            this.S = null;
        } else {
            this.P = obj == null ? null : new WeakReference<>(obj);
            this.Q = new WeakReference<>(nexLayerItem);
            this.R = bVar == null ? null : new WeakReference<>(bVar);
            this.S = bVar2 != null ? new WeakReference<>(bVar2) : null;
        }
    }

    public void a(C1780za c1780za) {
        this.T.b(new k(c1780za.a().asProtoBuf().toByteArray(), 0));
    }
}
