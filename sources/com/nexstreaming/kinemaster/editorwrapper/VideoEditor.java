package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.SurfaceView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.layer.EffectLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.usage.KMUsage;
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
    private boolean C;
    private boolean D;
    private File E;
    private com.nexstreaming.kinemaster.editorwrapper.a M;

    /* renamed from: a */
    WeakReference<NexLayerItem> f3301a;
    WeakReference<b> b;
    WeakReference<b> c;
    private final NexThemeView d;
    private ar e;
    private final boolean f;
    private final Context g;
    private final NexEditor h;
    private boolean i;
    private int u;
    private int v;
    private boolean w;
    private static final String[] q = {".nexvideoproject", ".kmproject"};
    private static final int r = a('K', 'H', 'D', 'R');
    private static final int s = a('T', 'L', 'I', 'N');
    private static final int t = a('F', 'T', 'R', 'X');
    private static Comparator<NexLayerItem> Y = new bj();
    private com.nexstreaming.app.general.util.m<e> j = new com.nexstreaming.app.general.util.m<>();
    private com.nexstreaming.app.general.util.m<g> k = new com.nexstreaming.app.general.util.m<>();
    private com.nexstreaming.app.general.util.m<f> l = new com.nexstreaming.app.general.util.m<>();
    private com.nexstreaming.app.general.util.m<i> m = new com.nexstreaming.app.general.util.m<>();
    private com.nexstreaming.app.general.util.m<h> n = new com.nexstreaming.app.general.util.m<>();
    private com.nexstreaming.app.general.util.m<d> o = new com.nexstreaming.app.general.util.m<>();
    private Task p = new Task();
    private State x = State.Busy;
    private int y = 0;
    private AtomicInteger z = new AtomicInteger(0);
    private NexEditor.PlayState A = null;
    private Handler B = new Handler(Looper.getMainLooper());
    private Object F = new Object();
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private Task J = new Task();
    private boolean K = false;
    private boolean L = false;
    private c N = null;
    private com.nexstreaming.app.general.util.y<k> O = new cg(this);
    private Bitmap P = null;
    private NexVideoClipItem Q = null;
    private int R = 0;
    private boolean S = false;
    private at T = null;
    private boolean U = false;
    private Set<NexLayerItem> V = new HashSet();
    private Set<NexLayerItem> W = new HashSet();
    private List<NexLayerItem> X = new ArrayList();
    private NexEditor.d Z = new bs(this);
    private com.nextreaming.nexvideoeditor.ar aa = new bt(this);
    private NexEditor.q ab = new j(this, null);

    /* loaded from: classes.dex */
    public enum State {
        Busy,
        Idle,
        PreparingToPlay,
        Playing,
        Exporting,
        Transcoding,
        LoadingProject,
        MakingThumbnails,
        Seeking
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void a(Context context, VideoEditor videoEditor, boolean z);

        void a(NexLayerItem nexLayerItem, LayerRenderer layerRenderer);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();

        void a(File file);
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

    public static /* synthetic */ int p(VideoEditor videoEditor) {
        int i2 = videoEditor.y;
        videoEditor.y = i2 - 1;
        return i2;
    }

    public static String a() {
        return ".kmproject";
    }

    private static final int a(char c2, char c3, char c4, char c5) {
        return ((c2 & 255) << 24) | ((c3 & 255) << 16) | ((c4 & 255) << 8) | (c5 & 255);
    }

    public VideoEditor(NexEditor nexEditor, Context context, boolean z, NexThemeView nexThemeView) {
        this.f = z;
        this.g = context.getApplicationContext();
        this.h = nexEditor;
        this.d = nexThemeView;
        this.h.a(this.aa);
        this.h.a(this.ab);
        this.h.a(this.Z);
        this.h.a(this.d, context);
        this.O.a(500000);
        this.M = new com.nexstreaming.kinemaster.editorwrapper.a(this.g);
    }

    public void b() {
        this.h.a(this.aa);
        this.h.a(this.ab);
        this.h.a(this.Z);
        this.h.a(this.d);
    }

    public void a(e eVar) {
        this.j.a((com.nexstreaming.app.general.util.m<e>) eVar);
    }

    public void b(e eVar) {
        this.j.b(eVar);
    }

    public void a(d dVar) {
        this.o.a((com.nexstreaming.app.general.util.m<d>) dVar);
    }

    public void a(g gVar) {
        this.k.a((com.nexstreaming.app.general.util.m<g>) gVar);
    }

    public void b(g gVar) {
        this.k.b(gVar);
    }

    public void a(f fVar) {
        this.l.a((com.nexstreaming.app.general.util.m<f>) fVar);
    }

    public void b(f fVar) {
        this.l.b(fVar);
    }

    public void a(h hVar) {
        this.n.a((com.nexstreaming.app.general.util.m<h>) hVar);
    }

    public void b(h hVar) {
        this.n.b(hVar);
    }

    public void a(i iVar) {
        this.m.a((com.nexstreaming.app.general.util.m<i>) iVar);
        this.B.post(new aw(this, iVar));
    }

    public boolean c() {
        return this.O.c();
    }

    public boolean d() {
        return this.O.d();
    }

    public void b(i iVar) {
        this.m.b(iVar);
    }

    public Task e() {
        return this.p;
    }

    public Task a(File file, c cVar) {
        this.N = cVar;
        return a(file);
    }

    public Task a(File file) {
        Task task = new Task();
        new bk(this, file, task).execute(new Void[0]);
        return task;
    }

    public Task a(byte[] bArr) {
        return a((InputStream) new ByteArrayInputStream(bArr), this.E, true);
    }

    public Task b(File file) {
        if (file == null) {
        }
        try {
            return a((InputStream) new FileInputStream(file), file, false);
        } catch (FileNotFoundException e2) {
            Task task = new Task();
            task.sendFailure(Task.makeTaskError("File not found", e2));
            return task;
        }
    }

    public void a(String str) {
        N().setProjectEffect(str);
        if (this.J != null) {
            this.J.signalEvent(Task.Event.COMPLETE);
            this.J = null;
        }
    }

    public static NexProjectHeader c(File file) throws IOException {
        NexProjectHeader fromProtoBuf;
        NexProjectHeader nexProjectHeader;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] bArr = new byte[4];
            bufferedInputStream.mark(bArr.length);
            int read = bufferedInputStream.read(bArr);
            bufferedInputStream.reset();
            if (read < bArr.length) {
                return null;
            }
            if (bArr[0] != -84 || bArr[1] != -19) {
                if (bArr[0] != -13 || bArr[1] != 75 || bArr[2] != 77 || bArr[3] != -22) {
                    return null;
                }
                HeaderDelimitedInputStream headerDelimitedInputStream = new HeaderDelimitedInputStream(bufferedInputStream);
                headerDelimitedInputStream.parseFileHeader();
                while (headerDelimitedInputStream.nextSection()) {
                    if (headerDelimitedInputStream.getSectionFourCC() == r && (fromProtoBuf = NexProjectHeader.fromProtoBuf((KMProto.KMProjectHeader) WireInstance.get().a(headerDelimitedInputStream, KMProto.KMProjectHeader.class))) != null) {
                        return fromProtoBuf;
                    }
                }
                return null;
            }
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            try {
                try {
                    Object readObject = objectInputStream.readObject();
                    if (readObject instanceof NexProjectHeader) {
                        nexProjectHeader = (NexProjectHeader) readObject;
                    } else {
                        bufferedInputStream.close();
                        nexProjectHeader = null;
                    }
                } catch (ClassNotFoundException e2) {
                    Log.e("VideoEditor", "readHeader - damaged", e2);
                    objectInputStream.close();
                    bufferedInputStream.close();
                    nexProjectHeader = null;
                }
                return nexProjectHeader;
            } finally {
                objectInputStream.close();
            }
        } finally {
            bufferedInputStream.close();
        }
    }

    private Task a(InputStream inputStream, File file, boolean z) {
        P();
        Task task = new Task();
        new cc(this, P(), inputStream, z, file, z, task).execute(new Void[0]);
        return task;
    }

    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a */
        final byte[] f3305a;
        final int b;

        public k(byte[] bArr, int i) {
            this.f3305a = bArr;
            this.b = i;
        }

        public String toString() {
            return "[" + Integer.toHexString(System.identityHashCode(this)) + " t=" + this.b + "]";
        }
    }

    public ar f() {
        return this.e;
    }

    public File g() {
        return this.E;
    }

    public boolean h() {
        return false;
    }

    public void i() {
        if (!this.C && !this.D) {
            if (this.y > 0) {
                this.C = true;
            } else {
                this.O.a();
            }
        }
    }

    public void j() {
        if (!this.C && !this.D) {
            if (this.y > 0) {
                this.D = true;
            } else {
                this.O.b();
            }
        }
    }

    public void k() {
        this.O.b(new k(f().a().asProtoBuf().toByteArray(), 0));
    }

    public Task l() {
        return d(false);
    }

    public Task m() {
        return d(true);
    }

    private ResultTask<Bitmap> L() {
        NexVideoClipItem nexVideoClipItem;
        int i2 = 0;
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        resultTask.makeWaitable();
        NexTimeline a2 = f().a();
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        while (true) {
            if (i3 >= a2.getPrimaryItemCount()) {
                nexVideoClipItem = null;
                break;
            }
            NexPrimaryTimelineItem primaryItem = a2.getPrimaryItem(i3);
            if (primaryItem instanceof NexVideoClipItem) {
                nexVideoClipItem = (NexVideoClipItem) primaryItem;
                if (nexVideoClipItem.isPreset()) {
                    if (!z) {
                        z = true;
                        i4 = nexVideoClipItem.getSolidColor();
                    }
                } else {
                    i2 = nexVideoClipItem.getRotation();
                    break;
                }
            }
            i3++;
        }
        if (this.Q == nexVideoClipItem && nexVideoClipItem != null && this.R == i2) {
            resultTask.sendResult(this.P);
            return resultTask;
        }
        this.Q = nexVideoClipItem;
        this.R = i2;
        if (nexVideoClipItem == null && z) {
            this.P = Bitmap.createBitmap(16, 9, Bitmap.Config.ARGB_8888);
            new Canvas(this.P).drawColor(i4);
            resultTask.sendResult(this.P);
        } else if (nexVideoClipItem == null) {
            this.P = Bitmap.createBitmap(16, 9, Bitmap.Config.ARGB_8888);
            new Canvas(this.P).drawColor(-16777216);
            resultTask.sendResult(this.P);
        } else {
            this.P = null;
            nexVideoClipItem.getThumbnail(this.g).onResultAvailable(new ck(this, nexVideoClipItem, resultTask)).onFailure((Task.OnFailListener) new cj(this, nexVideoClipItem, resultTask));
        }
        return resultTask;
    }

    public Task d(boolean z) {
        Task task = new Task();
        NexTimeline a2 = f().a();
        ResultTask<Bitmap> L = L();
        boolean z2 = !this.H && a2.getPrimaryItemCount() < 1 && a2.getSecondaryItemCount() < 1;
        NexProjectHeader nexProjectHeader = new NexProjectHeader(a2.getProjectHeader());
        nexProjectHeader.lastEditTime = new Date();
        nexProjectHeader.totalPlayTime = a2.getTotalTime();
        int u = u();
        KMProto.KMProject asProtoBuf = a2.asProtoBuf();
        this.y++;
        new cl(this, asProtoBuf, L, nexProjectHeader, this.z.incrementAndGet(), z2, z, u, task).execute(new Void[0]);
        return task;
    }

    public void b(int i2, int i3) {
        if (this.u != i2 || this.v != i3) {
            this.u = i2;
            this.v = i3;
            this.k.a(new cn(this));
        }
    }

    public void b(int i2) {
        b(this.u, i2);
    }

    private void c(int i2) {
        b(i2, this.v);
    }

    private void a(State state) {
        if (this.x != state) {
            this.x = state;
            this.l.a(new co(this));
        }
    }

    public Task n() {
        NexTimeline a2;
        ar f2 = f();
        if (f2 != null && (a2 = f2.a()) != null && a2.getPrimaryItemCount() > 0) {
            return a(u(), true);
        }
        N().k();
        Task task = new Task();
        task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
        return task;
    }

    public void o() {
        this.S = true;
    }

    public void M() {
        if (this.S) {
            n();
            this.S = false;
        }
    }

    public Task a(int i2) {
        return b(i2, false, true);
    }

    public Task a(int i2, boolean z, boolean z2) {
        Task b2 = b(i2, z, z2);
        b(true);
        return b2;
    }

    public Task a(int i2, boolean z) {
        return b(i2, z, true);
    }

    private Task b(int i2, boolean z, boolean z2) {
        SupportLogger.Event event = SupportLogger.Event.Seek;
        int[] iArr = new int[2];
        iArr[0] = i2;
        iArr[1] = (z2 ? 2 : 0) + (z ? 1 : 0);
        event.log(iArr);
        Task task = new Task();
        if (this.T != null) {
            SupportLogger.Event.SeekFail.log(8);
            task.sendFailure(NexEditor.b.bd);
        } else if (!this.I) {
            SupportLogger.Event.SeekFail.log(1);
            task.sendFailure(NexEditor.b.bd);
        } else if (this.G) {
            SupportLogger.Event.SeekFail.log(2);
            task.sendFailure(NexEditor.b.be);
        } else {
            if (i2 > 1 && Math.abs(u() - i2) < 33) {
                if (!z) {
                    task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
                } else {
                    i2 = u();
                }
            }
            if (h()) {
                SupportLogger.Event.SeekFail.log(3);
                task.sendFailure(NexEditor.b.bc);
            } else if (this.e == null) {
                SupportLogger.Event.SeekFail.log(4);
                task.sendFailure(NexEditor.b.bf);
            } else {
                c(i2);
                if (this.J != null && this.J.isRunning()) {
                    SupportLogger.Event.SeekDeferred.log(new int[0]);
                    this.J.onComplete(new ax(this, i2, z2, task));
                } else if (MediaInfo.p()) {
                    SupportLogger.Event.SeekDeferred.log(new int[0]);
                    MediaInfo.q().onComplete(new az(this, i2, z2, task));
                } else {
                    N().a(i2, z2, new bb(this, task));
                }
            }
        }
        return task;
    }

    public Task p() {
        a(false);
        Task task = new Task();
        if (!D() && t() == State.Idle) {
            task.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
        } else {
            SupportLogger.Event.Stop.log(new int[0]);
            N().a(new bc(this, task));
        }
        return task;
    }

    public boolean q() {
        return this.L;
    }

    public void a(boolean z) {
        this.L = z;
    }

    public Task r() {
        Task task = new Task();
        if (!this.I) {
            task.sendFailure(NexEditor.b.bd);
        } else if (h()) {
            task.sendFailure(NexEditor.b.bc);
        } else if (this.e == null) {
            task.sendFailure(NexEditor.b.bf);
        } else {
            N().a(new bd(this, task));
            Q();
        }
        return task;
    }

    public Task s() {
        Task task = new Task();
        if (h()) {
            task.sendFailure(NexEditor.b.bc);
        } else if (this.e == null) {
            task.sendFailure(NexEditor.b.bf);
        } else {
            N().b(new bf(this, task));
        }
        return task;
    }

    public State t() {
        return this.x;
    }

    public int u() {
        return this.u;
    }

    public int v() {
        return this.v;
    }

    public NexEditor N() {
        return this.h;
    }

    private EffectLibrary O() {
        return this.h.q();
    }

    public Context P() {
        return this.g;
    }

    public void a(int i2, int i3) {
        NexTimeline a2 = f().a();
        int primaryItemCount = a2.getPrimaryItemCount();
        int max = Math.max(0, Math.min(primaryItemCount - 1, i2));
        int max2 = Math.max(0, Math.min(primaryItemCount + 1, i3));
        int i4 = max - (max % 2);
        int i5 = max2 - (max2 % 2);
        if (i4 != i5) {
            NexTimeline.c beginTimeChange = a2.beginTimeChange();
            a2.movePrimaryItem(O(), i4, i5);
            beginTimeChange.a();
            b(f().a());
        }
    }

    public Task w() {
        Task task = null;
        if (this.T != null) {
            task = this.T.a();
        }
        if (task == null) {
            Task task2 = new Task();
            task2.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
            return task2;
        }
        return task;
    }

    public void a(NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem != null) {
            this.n.a(new bg(this, nexTimelineItem));
            if (nexTimelineItem instanceof NexLayerItem) {
                synchronized (this.F) {
                    this.W.add((NexLayerItem) nexTimelineItem);
                }
                if (nexTimelineItem instanceof VideoLayer) {
                    b(f().a());
                    return;
                }
                return;
            }
            b(f().a());
            return;
        }
        b(f().a());
    }

    public void b(NexTimelineItem nexTimelineItem) {
        NexTimeline.c beginTimeChange = f().a().beginTimeChange();
        d(nexTimelineItem);
        beginTimeChange.a();
        b(f().a());
    }

    public void c(NexTimelineItem nexTimelineItem) {
        d(nexTimelineItem);
    }

    private void d(NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem instanceof NexTransitionItem) {
            throw new IllegalArgumentException("Transitions cannot be deleted.");
        }
        NexTimeline a2 = f().a();
        if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
            a2.deletePrimaryItem(a2.getIndexOfPrimaryItem((NexPrimaryTimelineItem) nexTimelineItem));
        } else if (nexTimelineItem instanceof NexSecondaryTimelineItem) {
            a2.deleteSecondaryItem((NexSecondaryTimelineItem) nexTimelineItem);
            if (nexTimelineItem instanceof EffectLayer) {
                ((EffectLayer) nexTimelineItem).releaseTexture();
            }
        }
    }

    private void a(NexTimeline nexTimeline) {
        EffectLibrary q2;
        String effectID;
        NexEditor N = N();
        if (N != null && (q2 = N.q()) != null) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            int primaryItemCount = nexTimeline.getPrimaryItemCount();
            for (int i2 = 0; i2 < primaryItemCount; i2++) {
                NexPrimaryTimelineItem primaryItem = nexTimeline.getPrimaryItem(i2);
                if (primaryItem instanceof NexTransitionItem) {
                    String effectID2 = ((NexTransitionItem) primaryItem).getEffectID();
                    if (effectID2 != null) {
                        hashSet.add(effectID2);
                    }
                } else if ((primaryItem instanceof NexVideoClipItem) && (effectID = ((NexVideoClipItem) primaryItem).getEffectID()) != null) {
                    hashSet.add(effectID);
                }
            }
            for (com.nexstreaming.kinemaster.kmpackage.a aVar : q2.b(13)) {
                if (aVar.d()) {
                    hashSet.add(aVar.a());
                }
            }
            for (com.nexstreaming.kinemaster.kmpackage.at atVar : q2.a(13)) {
                if (atVar.d()) {
                    hashSet.add(atVar.a());
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                hashSet2.add(q2.c((String) it.next()));
            }
            q2.a(hashSet2, N, this.f);
        }
    }

    public a x() {
        return new a();
    }

    /* loaded from: classes.dex */
    public class a {
        private NexExportProfile b;
        private File c;
        private int d = 0;
        private boolean e = false;
        private int f = 0;

        protected a() {
        }

        public a a(File file) {
            this.c = file;
            return this;
        }

        public a a(NexExportProfile nexExportProfile) {
            this.b = nexExportProfile;
            return this;
        }

        public a a(int i) {
            this.f = i;
            return this;
        }

        public a b(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("durationLimit must be >0");
            }
            this.d = i;
            this.e = true;
            return this;
        }

        public Task a() {
            if (this.c == null) {
                throw new IllegalStateException("Must specify output path before exporting");
            }
            if (this.b != null) {
                return VideoEditor.this.N().a(this.c.getAbsolutePath(), this.b.width(), this.b.height(), this.b.bitrate(), com.nexstreaming.app.general.util.i.a(this.c), this.e ? this.d : VideoEditor.this.f().a().getTotalTime(), this.e, this.f);
            }
            throw new IllegalStateException("Must specify profile before exporting");
        }
    }

    public at y() {
        if (this.T == null) {
            this.T = new at(this, u());
        }
        return this.T;
    }

    public void a(at atVar, int i2) {
        if (atVar == this.T) {
            this.T = null;
            b(f().a()).onComplete(new bh(this, i2));
        }
    }

    public Task b(NexTimeline nexTimeline) {
        boolean z;
        int i2;
        Task task = new Task();
        NexEditor N = N();
        nexTimeline.recalculateResourceUsage();
        if (N == null) {
            task.sendFailure(NexEditor.b.aZ);
            return task;
        }
        EffectLibrary q2 = N.q();
        a(nexTimeline);
        nexTimeline.applyProjectSettingsToEditor(N, q2);
        if (q2 != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= nexTimeline.getPrimaryItemCount()) {
                    break;
                }
                NexPrimaryTimelineItem primaryItem = nexTimeline.getPrimaryItem(i4);
                if (primaryItem instanceof NexVideoClipItem) {
                    if (q2.d(((NexVideoClipItem) primaryItem).getEffectID()) == null) {
                        ((NexVideoClipItem) primaryItem).setEffectID(EditorGlobal.i);
                    }
                } else if ((primaryItem instanceof NexTransitionItem) && q2.b(((NexTransitionItem) primaryItem).getTransitionEffectID()) == null) {
                    ((NexTransitionItem) primaryItem).setTransitionEffectID("none");
                }
                i3 = i4 + 1;
            }
        }
        nexTimeline.requestCalcTimes();
        int primaryItemCount = (nexTimeline.getPrimaryItemCount() + 1) / 2;
        int secondaryItemCount = nexTimeline.getSecondaryItemCount();
        int i5 = 0;
        if (primaryItemCount > 0) {
            for (int i6 = 0; i6 < secondaryItemCount; i6++) {
                NexSecondaryTimelineItem secondaryItem = nexTimeline.getSecondaryItem(i6);
                if ((secondaryItem instanceof VideoLayer) && !secondaryItem.getOverLimit()) {
                    i5++;
                }
            }
        }
        int i7 = i5;
        nexTimeline.getTotalTime();
        nexTimeline.getTotalSecondaryTime();
        NexVisualClip[] nexVisualClipArr = new NexVisualClip[primaryItemCount + i7];
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i9 >= primaryItemCount) {
                break;
            }
            NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexTimeline.getPrimaryItem(i9 * 2);
            if (!nexVideoClipItem.isReadyToPlay()) {
                z2 = false;
                break;
            }
            nexVisualClipArr[i9] = nexVideoClipItem.asNexVisualClip();
            nexVisualClipArr[i9].mStartTime = i8;
            i8 = nexVisualClipArr[i9].mEndTime - nexVideoClipItem.getTransition().getTransitionOverlap();
            i9++;
        }
        if (primaryItemCount > 0) {
            if (i7 > 0) {
                int i10 = primaryItemCount + 0;
                int i11 = 0;
                while (i11 < secondaryItemCount) {
                    NexSecondaryTimelineItem secondaryItem2 = nexTimeline.getSecondaryItem(i11);
                    if (!(secondaryItem2 instanceof VideoLayer) || secondaryItem2.getOverLimit()) {
                        i2 = i10;
                    } else {
                        nexVisualClipArr[i10] = ((VideoLayer) secondaryItem2).asNexVisualClip();
                        i2 = i10 + 1;
                    }
                    i11++;
                    i10 = i2;
                }
            }
            for (int i12 = 0; i12 < secondaryItemCount; i12++) {
                NexSecondaryTimelineItem secondaryItem3 = nexTimeline.getSecondaryItem(i12);
                if (!secondaryItem3.isReadyToPlay()) {
                    z = false;
                    break;
                }
                if ((secondaryItem3 instanceof NexAudioClipItem) && !secondaryItem3.getOverLimit()) {
                    arrayList.add(((NexAudioClipItem) secondaryItem3).asNexAudioClip());
                }
            }
        }
        z = z2;
        if (!z) {
            N.a((NexVisualClip[]) null, (NexAudioClip[]) null);
            this.I = false;
            task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
            return task;
        }
        if (this.f && primaryItemCount == 1 && nexVisualClipArr[0].mClipType == 1 && nexVisualClipArr[0].mTotalTime < 1000) {
            nexVisualClipArr[0].mTotalTime = 1001;
            nexVisualClipArr[0].mEndTime = 1001;
        }
        if (nexVisualClipArr.length < 1) {
            N.a((NexVisualClip[]) null, (NexAudioClip[]) null);
            this.I = false;
            task.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
            return task;
        }
        this.I = true;
        return N.a(nexVisualClipArr, (NexAudioClip[]) arrayList.toArray(new NexAudioClip[arrayList.size()])).onComplete(new bi(this));
    }

    public NexEditor.c z() {
        return N().j();
    }

    public boolean a(NexEditor.FastPreviewOption fastPreviewOption, int i2, boolean z) {
        return N().a(fastPreviewOption, i2, z);
    }

    public ResultTask<File> a(SurfaceView surfaceView) {
        ResultTask<File> resultTask = new ResultTask<>();
        MediaInfo.q().onComplete(new bm(this, surfaceView, resultTask));
        return resultTask;
    }

    public void Q() {
        if (this.w) {
            a(State.Seeking);
            return;
        }
        if (this.A != NexEditor.PlayState.RUN && D()) {
            a(State.PreparingToPlay);
            return;
        }
        switch (this.A) {
            case IDLE:
                a(State.Idle);
                return;
            case NONE:
                a(State.Busy);
                return;
            case RUN:
                a(State.Playing);
                return;
            case RECORD:
                a(State.Exporting);
                return;
            default:
                return;
        }
    }

    public boolean A() {
        return N().i();
    }

    public int B() {
        return N().clearTrackCache();
    }

    public void C() {
        NexTimeline a2;
        ar f2 = f();
        if (f2 != null && (a2 = f2.a()) != null) {
            b(a2);
        }
    }

    public NexVideoClipItem a(int i2, MSID msid, MediaStoreItem mediaStoreItem, int i3) {
        return a(i2, msid, mediaStoreItem, i3, true);
    }

    private NexVideoClipItem a(int i2, MSID msid, MediaStoreItem mediaStoreItem, int i3, boolean z) {
        NexVideoClipItem newInstance;
        if (i2 % 2 == 1) {
            i2++;
        }
        NexTimeline a2 = f().a();
        NexTimeline.c beginTimeChange = a2.beginTimeChange();
        if (mediaStoreItem != null) {
            newInstance = NexVideoClipItem.newInstance(a2.nextAvailableEngineClipId(), mediaStoreItem, i3);
        } else {
            newInstance = NexVideoClipItem.newInstance(a2.nextAvailableEngineClipId(), msid);
        }
        if (mediaStoreItem != null && msid.getNamespace().equals(com.nexstreaming.kinemaster.mediastore.v2.providers.j.e())) {
            newInstance.applyFinalPath(msid, mediaStoreItem.h(), NexVideoClipItem.CropMode.FILL, i3);
        }
        newInstance.checkResourceState(P());
        a2.addPrimaryItem(N().q(), i2, newInstance);
        if (z) {
            beginTimeChange.a();
        }
        b(a2);
        return newInstance;
    }

    public void a(NexLayerItem nexLayerItem) {
        NexTimeline a2 = f().a();
        KMUsage.EditScreen_AddLayer.logEvent("type", nexLayerItem.getClass().getName());
        a2.addLayer(nexLayerItem);
        KMUsage.trackAddMedia(P(), false, null, nexLayerItem);
    }

    public void b(NexLayerItem nexLayerItem) {
        long frontmostLayerZOrder = f().a().getFrontmostLayerZOrder();
        if (nexLayerItem.getZOrder() < frontmostLayerZOrder) {
            nexLayerItem.setZOrder(frontmostLayerZOrder + 1);
        }
    }

    public void c(NexLayerItem nexLayerItem) {
        long backmostLayerZOrder = f().a().getBackmostLayerZOrder();
        if (nexLayerItem.getZOrder() > backmostLayerZOrder) {
            nexLayerItem.setZOrder(backmostLayerZOrder - 1);
        }
    }

    public NexAudioClipItem a(int i2, String str, boolean z) {
        NexTimeline a2 = f().a();
        NexAudioClipItem newInstance = NexAudioClipItem.newInstance(a2.nextAvailableEngineClipId(), str);
        newInstance.checkResourceState(P());
        a2.addSecondaryItem(newInstance);
        newInstance.setPinned(z);
        newInstance.moveClip(i2);
        b(a2);
        return newInstance;
    }

    public int a(String str, int i2, int i3, int i4) {
        this.i = true;
        return N().startVoiceRecorder(str, i2, i3, i4);
    }

    public int a(byte[] bArr, int i2) {
        return N().processVoiceRecorder(bArr, i2);
    }

    public int a(NexClipInfo nexClipInfo) {
        this.i = false;
        return N().endVoiceRecorder(nexClipInfo);
    }

    public void b(boolean z) {
        this.G = z;
    }

    public boolean D() {
        return N().p();
    }

    public <T extends NexSecondaryTimelineItem> T a(T t2) {
        T t3 = (T) NexTimeline.secondaryItemFromProtoBuf(t2.asProtoBuf());
        t3.setUniqueId(null);
        t3.getUniqueId();
        if (t3 instanceof NexAudioClipItem) {
            ((NexAudioClipItem) t3).setEngineClipIDAfterDuplicate(f().a().nextAvailableEngineClipId());
        } else if (t3 instanceof VideoLayer) {
            ((VideoLayer) t3).setEngineClipIDAfterDuplicate(f().a().nextAvailableEngineClipId());
        }
        if (t3 instanceof NexLayerItem) {
            ((NexLayerItem) t3).setZOrder(f().a().getFrontmostLayerZOrder() + 1);
        }
        f().a().addSecondaryItem(t3);
        t3.checkResourceState(P());
        return t3;
    }

    public <T extends NexPrimaryTimelineItem> T a(T t2) {
        return (T) a((VideoEditor) t2, false);
    }

    public <T extends NexPrimaryTimelineItem> T a(T t2, boolean z) {
        NexTimeline a2 = f().a();
        T t3 = (T) NexTimeline.primaryItemFromProtoBuf(t2.asProtoBuf());
        t3.setUniqueId(null);
        t3.getUniqueId();
        t3.onDuplicated(a2.nextAvailableEngineClipId());
        a2.addPrimaryItem(O(), (z ? 2 : 0) + a2.getIndexOfPrimaryItem(t2), t3);
        t3.checkResourceState(P());
        return t3;
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
            int trimTimeStart2 = nexVideoClipItem.isImage() ? absStartTime : nexVideoClipItem.getTrimTimeStart() - trimTimeStart;
            int i3 = ((duration - trimTimeStart2) * 100) / duration;
            rect2.left = nexVideoClipItem.calcPos(rect.left, rect2.left, i3);
            rect2.top = nexVideoClipItem.calcPos(rect.top, rect2.top, i3);
            rect2.right = nexVideoClipItem.calcPos(rect.right, rect2.right, i3);
            rect2.bottom = nexVideoClipItem.calcPos(rect.bottom, rect2.bottom, i3);
            if (nexVideoClipItem.isImage()) {
                nexVideoClipItem.setDuration(duration - trimTimeStart2);
            }
            nexVideoClipItem.setStartPositionRaw(rect2);
            int effectStartTime = nexVideoClipItem.getEffectStartTime();
            int effectEndTime = nexVideoClipItem.getEffectEndTime();
            nexVideoClipItem.checkEffectTime(effectStartTime, effectEndTime, 1);
            nexVideoClipItem.getTransition().ensureTransitionFits();
            a((NexTimelineItem) nexVideoClipItem);
            int indexOfPrimaryItem = f().a().getIndexOfPrimaryItem(nexVideoClipItem);
            if (indexOfPrimaryItem > 0) {
                int i4 = indexOfPrimaryItem - 1;
            }
            NexVideoClipItem nexVideoClipItem2 = (NexVideoClipItem) a((VideoEditor) nexVideoClipItem);
            if (nexVideoClipItem2 != null) {
                a((NexTimelineItem) nexVideoClipItem2);
                nexVideoClipItem2.checkResourceState(P());
                nexVideoClipItem2.setStartPositionRaw(rect);
                nexVideoClipItem2.setEndPositionRaw(rect2);
                if (nexVideoClipItem2.isImage()) {
                    nexVideoClipItem2.setDuration(trimTimeStart2);
                } else {
                    nexVideoClipItem2.setTrimStart(trimTimeStart);
                    nexVideoClipItem2.setTrimEnd(duration - (trimTimeStart2 + trimTimeStart));
                }
                nexVideoClipItem2.checkEffectTime(effectStartTime, effectEndTime, 2);
                a((NexTimelineItem) nexVideoClipItem2);
                EffectLibrary.a(P());
                nexVideoClipItem2.setEffectID(nexVideoClipItem.getEffectID());
                if (nexVideoClipItem2.getPreviousClip() != null) {
                    nexVideoClipItem2.getPrecedingTransition().ensureTransitionFits();
                }
            }
            n();
            l();
            task.signalEvent(Task.Event.COMPLETE);
        } else if (nexTimelineItem != null && (nexTimelineItem instanceof NexAudioClipItem)) {
            f().a();
            NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) nexTimelineItem;
            if (nexAudioClipItem.getAudioSplitState()) {
                task.signalEvent(Task.Event.FAIL);
                return task;
            }
            nexAudioClipItem.setAudioSplitState(true);
            int startTime = nexAudioClipItem.getStartTime();
            nexAudioClipItem.trimClip(i2, nexAudioClipItem.getEndTime());
            nexAudioClipItem.checkResourceState(P());
            a((NexTimelineItem) nexAudioClipItem);
            NexAudioClipItem nexAudioClipItem2 = (NexAudioClipItem) a((VideoEditor) nexAudioClipItem);
            nexAudioClipItem2.trimClip(startTime, i2);
            nexAudioClipItem2.checkResourceState(P());
            a((NexTimelineItem) nexAudioClipItem2);
            nexAudioClipItem.setAudioSplitState(false);
            n();
            l();
            task.signalEvent(Task.Event.COMPLETE);
        } else if (nexTimelineItem != null && (nexTimelineItem instanceof NexLayerItem)) {
            NexTimeline a2 = f().a();
            NexLayerItem nexLayerItem = (NexLayerItem) nexTimelineItem;
            int startTime2 = nexLayerItem.getStartTime();
            nexLayerItem.trimClip(i2, nexLayerItem.getEndTime());
            nexLayerItem.checkResourceState(P());
            a((NexTimelineItem) nexLayerItem);
            NexLayerItem nexLayerItem2 = (NexLayerItem) a((VideoEditor) nexLayerItem);
            nexLayerItem2.trimClip(startTime2, i2 - 1);
            a((NexTimelineItem) nexLayerItem2);
            nexLayerItem2.checkResourceState(P());
            a2.requestCalcTimes();
            n();
            l();
            task.signalEvent(Task.Event.COMPLETE);
        }
        return task;
    }

    public b E() {
        if (this.c == null) {
            return null;
        }
        return this.c.get();
    }

    public void a(NexLayerItem nexLayerItem, b bVar, b bVar2) {
        b bVar3 = this.b == null ? null : this.b.get();
        b bVar4 = this.c == null ? null : this.c.get();
        if (nexLayerItem == null) {
            bVar2 = null;
            bVar = null;
        }
        if (bVar3 != bVar && bVar3 != null) {
            bVar3.a();
        }
        if (bVar4 != bVar2 && bVar4 != null) {
            bVar4.a();
        }
        if (bVar3 != bVar && bVar != null) {
            bVar.a(P(), this, false);
        }
        if (bVar4 != bVar2 && bVar2 != null) {
            bVar2.a(P(), this, true);
        }
        if (nexLayerItem == null) {
            this.f3301a = null;
            this.b = null;
            this.c = null;
        } else {
            this.f3301a = new WeakReference<>(nexLayerItem);
            this.b = bVar == null ? null : new WeakReference<>(bVar);
            this.c = bVar2 != null ? new WeakReference<>(bVar2) : null;
        }
    }

    public ResultTask<File> a(Context context, File file, File file2, NexExportProfile nexExportProfile) {
        ResultTask<File> resultTask = new ResultTask<>();
        com.nexstreaming.kinemaster.g.i a2 = com.nexstreaming.kinemaster.g.b.a(context, file, file2, nexExportProfile);
        e.a aVar = new e.a(context);
        aVar.d(R.string.reverse_popup_title);
        aVar.a(R.string.reverse_popup_msg);
        aVar.b(R.string.export_est);
        aVar.a(false);
        aVar.a(R.string.button_cancel, new bv(this, a2, resultTask));
        com.nexstreaming.kinemaster.ui.a.e a3 = aVar.a();
        a3.show();
        a2.onProgress(new bw(this, a2, context, a3));
        a2.onComplete(new bx(this, a3, context, file2, resultTask));
        a2.onFailure(new ca(this, a3, context, resultTask));
        return resultTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j extends NexEditor.q {

        /* renamed from: a */
        final WeakReference<VideoEditor> f3304a;

        /* synthetic */ j(VideoEditor videoEditor, aw awVar) {
            this(videoEditor);
        }

        private j(VideoEditor videoEditor) {
            this.f3304a = new WeakReference<>(videoEditor);
        }

        @Override // com.nextreaming.nexvideoeditor.NexEditor.q
        public void a() {
            VideoEditor videoEditor = this.f3304a.get();
            if (videoEditor != null) {
                videoEditor.M();
            }
        }
    }

    public void a(ar arVar) {
        this.O.b(new k(arVar.a().asProtoBuf().toByteArray(), 0));
    }

    public boolean F() {
        return !this.I;
    }

    public void c(boolean z) {
        this.h.a(z);
    }
}
