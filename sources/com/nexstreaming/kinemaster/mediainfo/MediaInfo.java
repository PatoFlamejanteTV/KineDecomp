package com.nexstreaming.kinemaster.mediainfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;
import android.util.SparseArray;
import com.crashlytics.android.Crashlytics;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.ExclusionList;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexvideoeditor.NexClipInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class MediaInfo {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, WeakReference<MediaInfo>> f20671a;

    /* renamed from: b, reason: collision with root package name */
    private static ExclusionList f20672b;

    /* renamed from: c, reason: collision with root package name */
    private static ExclusionList f20673c;

    /* renamed from: g, reason: collision with root package name */
    private static File f20677g;
    private File A;
    private File B;
    private String C;
    private NexEditor.b D;
    private c<T, f> E = null;
    private c<L, Void> F = null;
    private ResultTask<Bitmap> G = null;
    private ResultTask<Bitmap> H = null;
    private ResultTask<int[]> I = null;
    private AsyncTask<File, Integer, int[]> J = null;
    private b K;
    private boolean L;
    private File t;
    private File u;
    private File v;
    private File w;
    private File x;
    private File y;
    private File z;

    /* renamed from: d, reason: collision with root package name */
    private static Executor f20674d = Executors.newSingleThreadExecutor();

    /* renamed from: e, reason: collision with root package name */
    private static Executor f20675e = Executors.newSingleThreadExecutor();

    /* renamed from: f, reason: collision with root package name */
    private static LruCache<String, Bitmap> f20676f = new LruCache<>(20);

    /* renamed from: h, reason: collision with root package name */
    private static Deque<c<T, f>> f20678h = new ArrayDeque();
    private static int i = 0;
    private static Deque<c<L, Void>> j = new ArrayDeque();
    private static Task k = null;
    private static SparseArray<c<?, ?>> l = new SparseArray<>();
    private static boolean m = false;
    private static boolean n = false;
    private static ScheduledThreadPoolExecutor o = new ScheduledThreadPoolExecutor(0);
    private static NexEditor.l p = new C1795m();
    private static NexEditor.k q = new C1796n();
    private static NexEditor.j r = new C1797o();
    private static NexEditor.n s = new C1798p();

    /* loaded from: classes.dex */
    public enum MediaInfoError implements Task.TaskError {
        PCMLevelsNotAvailable,
        SeekPointsNotAvailable,
        ThumbnailsNotAvailable,
        LargeStartThumbnailNotAvailable,
        LargeEndThumbnailNotAvailable;

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return null;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            return name();
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return name();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final int f20679a;

        /* renamed from: b, reason: collision with root package name */
        final int f20680b;

        /* renamed from: c, reason: collision with root package name */
        final int[] f20681c;

        /* renamed from: d, reason: collision with root package name */
        final Bitmap f20682d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, int i2, int[] iArr, Bitmap bitmap) {
            this.f20679a = i;
            this.f20680b = i2;
            this.f20681c = iArr;
            this.f20682d = bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c<RESULT_TYPE, PARAM_TYPE> extends ResultTask<RESULT_TYPE> {

        /* renamed from: b, reason: collision with root package name */
        private final MediaInfo f20692b;

        /* renamed from: c, reason: collision with root package name */
        private final d<RESULT_TYPE, PARAM_TYPE> f20693c;

        /* renamed from: e, reason: collision with root package name */
        private final PARAM_TYPE f20695e;

        /* renamed from: a, reason: collision with root package name */
        int f20691a = 3;

        /* renamed from: d, reason: collision with root package name */
        private final e f20694d = null;

        public c(MediaInfo mediaInfo, PARAM_TYPE param_type, d<RESULT_TYPE, PARAM_TYPE> dVar) {
            this.f20693c = dVar;
            this.f20692b = mediaInfo;
            this.f20695e = param_type;
            MediaInfo.l.put(getTaskId(), this);
        }

        @Override // com.nexstreaming.app.general.task.Task
        public void sendFailure(Task.TaskError taskError) {
            if (MediaInfo.l.get(getTaskId()) != this) {
                return;
            }
            super.sendFailure(taskError);
            MediaInfo.l.remove(getTaskId());
            if (MediaInfo.l.size() != 0 || MediaInfo.k == null) {
                return;
            }
            MediaInfo.k.signalEvent(Task.Event.COMPLETE);
        }

        @Override // com.nexstreaming.app.general.task.ResultTask
        public void sendResult(RESULT_TYPE result_type) {
            if (MediaInfo.l.get(getTaskId()) != this) {
                return;
            }
            MediaInfo.l.remove(getTaskId());
            if (MediaInfo.l.size() == 0 && MediaInfo.k != null) {
                MediaInfo.k.signalEvent(Task.Event.COMPLETE);
            }
            super.sendResult(result_type);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PARAM_TYPE a() {
            return this.f20695e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(NexEditor.b bVar) {
            d<RESULT_TYPE, PARAM_TYPE> dVar;
            if (MediaInfo.l.get(getTaskId()) == this && (dVar = this.f20693c) != null) {
                dVar.a(this, bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7) {
            e eVar;
            if (MediaInfo.l.get(getTaskId()) == this && (eVar = this.f20694d) != null) {
                eVar.a(i, i2, i3, i4, i5, bArr, i6, i7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d<RESULT_TYPE, PARAM_TYPE> {
        void a(c<RESULT_TYPE, PARAM_TYPE> cVar, NexEditor.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface e {
        void a(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final File f20696a;

        /* renamed from: b, reason: collision with root package name */
        public final File f20697b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20698c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20699d;

        /* renamed from: e, reason: collision with root package name */
        public final int f20700e;

        /* renamed from: f, reason: collision with root package name */
        public final int f20701f;

        /* renamed from: g, reason: collision with root package name */
        public final int f20702g;

        /* renamed from: h, reason: collision with root package name */
        public final int f20703h;

        protected f(File file, File file2, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f20696a = file;
            this.f20697b = file2;
            this.f20698c = i;
            this.f20699d = i2;
            this.f20700e = i3;
            this.f20701f = i4;
            this.f20702g = i5;
            this.f20703h = i6;
        }
    }

    private MediaInfo(File file) {
        Gson gson;
        b bVar;
        this.D = NexEditor.b.f24591b;
        AsyncTaskC1799q asyncTaskC1799q = null;
        FileType fromFile = FileType.fromFile(file);
        if (fromFile != null && fromFile.isImage()) {
            this.t = file;
            ea();
            return;
        }
        File file2 = new File(f20677g, ".km_mediainfo");
        file2.mkdirs();
        String b2 = b(file);
        this.t = file;
        this.u = new File(file2, b2 + "_info.dat");
        this.v = new File(file2, b2 + "_seek.dat");
        this.w = new File(file2, b2 + "_vthumb.dat");
        this.x = new File(file2, b2 + "_vthumb_large.dat");
        this.y = new File(file2, b2 + "_vthumb_large_end.dat");
        this.z = new File(file2, b2 + "_vthumb_raw.dat");
        this.A = new File(file2, b2 + "_pcm.dat");
        this.B = file2;
        this.C = b2;
        if (this.u.exists()) {
            gson = new Gson();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.u));
                try {
                    bVar = (b) gson.fromJson((Reader) bufferedReader, b.class);
                    try {
                        bufferedReader.close();
                    } catch (JsonIOException | JsonSyntaxException | IOException unused) {
                    }
                } catch (Throwable th) {
                    bufferedReader.close();
                    throw th;
                }
            } catch (JsonIOException | JsonSyntaxException | IOException unused2) {
                bVar = null;
            }
            if (bVar != null && bVar.f20683a == 8) {
                this.K = bVar;
                return;
            }
        } else {
            gson = null;
        }
        ExclusionList exclusionList = f20672b;
        if (exclusionList != null && exclusionList.isExcluded(b2)) {
            this.L = true;
            return;
        }
        NexClipInfo nexClipInfo = new NexClipInfo();
        NexEditor da = da();
        if (da == null) {
            this.D = NexEditor.b._a;
            return;
        }
        f20672b.add(b2);
        this.D = da.a(file.getAbsolutePath(), nexClipInfo, false, 0);
        f20672b.remove(b2);
        this.K = new b(asyncTaskC1799q);
        if (this.D != NexEditor.b.f24591b) {
            return;
        }
        b bVar2 = this.K;
        bVar2.f20683a = 8;
        bVar2.f20684b = file.getAbsolutePath();
        this.K.f20686d = nexClipInfo.mExistAudio != 0;
        this.K.f20687e = nexClipInfo.mExistVideo != 0;
        b bVar3 = this.K;
        bVar3.f20688f = false;
        bVar3.k = nexClipInfo.mAudioDuration;
        bVar3.l = nexClipInfo.mVideoDuration;
        bVar3.f20685c = file.length();
        b bVar4 = this.K;
        int i2 = nexClipInfo.mVideoWidth;
        bVar4.i = i2;
        bVar4.j = nexClipInfo.mVideoHeight;
        int i3 = nexClipInfo.mDisplayVideoWidth;
        bVar4.f20689g = i3 != 0 ? i3 : i2;
        b bVar5 = this.K;
        int i4 = nexClipInfo.mDisplayVideoHeight;
        bVar5.f20690h = i4 == 0 ? nexClipInfo.mVideoHeight : i4;
        b bVar6 = this.K;
        bVar6.m = nexClipInfo.mSeekPointCount;
        bVar6.n = nexClipInfo.mFPS;
        bVar6.o = nexClipInfo.mVideoH264Profile;
        bVar6.p = nexClipInfo.mVideoH264Level;
        bVar6.q = nexClipInfo.mVideoH264Interlaced;
        bVar6.v = nexClipInfo.mVideoOrientation;
        bVar6.w = nexClipInfo.mVideoCodecType;
        bVar6.x = nexClipInfo.mAudioCodecType;
        bVar6.r = nexClipInfo.mVideoBitRate;
        bVar6.s = nexClipInfo.mAudioBitRate;
        bVar6.t = nexClipInfo.mAudioSampleRate;
        bVar6.u = nexClipInfo.mAudioChannels;
        bVar6.y = nexClipInfo.mVideoRenderType;
        bVar6.z = nexClipInfo.mVideoEditBoxTime;
        bVar6.A = nexClipInfo.mAudioEditBoxTime;
        bVar6.B = nexClipInfo.mVideoHDRType;
        gson = gson == null ? new Gson() : gson;
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.u));
            try {
                gson.toJson(this.K, bufferedWriter);
                bufferedWriter.close();
                this.u.setReadable(true);
            } catch (Throwable th2) {
                bufferedWriter.close();
                this.u.setReadable(true);
                throw th2;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean X() {
        return l.size() != 0;
    }

    public static Task aa() {
        boolean X = X();
        Task task = k;
        if (task == null || (task.isComplete() && X)) {
            k = new Task();
        }
        if (!X) {
            k.signalEvent(Task.Event.COMPLETE);
        }
        return k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task ba() {
        Task task = new Task();
        new File(f20677g, ".km_mediainfo").mkdirs();
        new AsyncTaskC1799q(this, this.z, this.w, this.x, this.y, task).executeOnExecutor(f20674d, 0);
        return task;
    }

    private static boolean ca() {
        if (!m) {
            NexEditor da = da();
            if (da == null) {
                return false;
            }
            n = da.b();
            m = true;
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NexEditor da() {
        if (EditorGlobal.i() == null) {
            return null;
        }
        EditorGlobal.i().a(q);
        EditorGlobal.i().a(s);
        EditorGlobal.i().a(r);
        EditorGlobal.i().a(p);
        return EditorGlobal.i();
    }

    private void ea() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.t.getAbsolutePath(), options);
        this.K = new b(null);
        b bVar = this.K;
        bVar.f20683a = 8;
        bVar.f20684b = this.t.getAbsolutePath();
        b bVar2 = this.K;
        bVar2.f20686d = false;
        bVar2.f20687e = false;
        bVar2.f20688f = true;
        bVar2.k = 0;
        bVar2.l = 0;
        bVar2.f20685c = this.t.length();
        b bVar3 = this.K;
        int i2 = options.outWidth;
        bVar3.f20689g = i2;
        int i3 = options.outHeight;
        bVar3.f20690h = i3;
        bVar3.i = i2;
        bVar3.j = i3;
        bVar3.m = 0;
        bVar3.n = 0;
        bVar3.o = 0;
        bVar3.p = 0;
        bVar3.q = 0;
        bVar3.y = 0;
        this.L = false;
        this.D = NexEditor.b.f24591b;
        bVar3.z = 0;
        bVar3.A = 0;
        bVar3.B = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<L> fa() {
        ResultTask<L> resultTask = new ResultTask<>();
        new C(this, resultTask).executeOnExecutor(f20675e, this);
        return resultTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ga() {
        NexEditor da;
        if (j.isEmpty() || (da = da()) == null) {
            return;
        }
        c<L, Void> remove = j.remove();
        da.a(((c) remove).f20692b.t, ((c) remove).f20692b.A, remove.getTaskId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ha() {
        NexEditor da;
        if (f20678h.isEmpty() || (da = da()) == null) {
            return;
        }
        c<T, f> remove = f20678h.remove();
        try {
            f fVar = (f) remove.a();
            String absolutePath = fVar.f20696a.getAbsolutePath();
            f20673c.isExcluded(fVar.f20696a.getAbsolutePath());
            f20673c.add(absolutePath);
            o.schedule(new RunnableC1794l(absolutePath), 500L, TimeUnit.MILLISECONDS);
            da.a(fVar.f20696a, fVar.f20697b, fVar.f20698c, fVar.f20699d, fVar.f20700e, fVar.f20701f, fVar.f20702g, fVar.f20703h, remove.getTaskId());
        } catch (Exception e2) {
            if (EditorGlobal.p && !(e2 instanceof IOException)) {
                Crashlytics.log(e2.getMessage());
            }
            Log.e("KineMaster_MediaInfo", "startPendingThumbnailTask error!", e2);
            if (remove != null) {
                remove.sendFailure(Task.makeTaskError(e2));
            }
        }
    }

    public ResultTask<L> A() {
        if (this.A == null) {
            return ResultTask.failedResultTask(MediaInfoError.PCMLevelsNotAvailable);
        }
        c<L, Void> cVar = this.F;
        if (cVar != null && !cVar.didSignalEvent(Task.Event.FAIL)) {
            return this.F;
        }
        this.F = new c<>(this, null, new E(this));
        fa().onResultAvailable(new C1785c(this));
        return this.F;
    }

    public File B() {
        return this.t;
    }

    public int C() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.j;
    }

    public int D() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.i;
    }

    public int E() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.m;
    }

    public ResultTask<int[]> F() {
        if (this.v == null) {
            return ResultTask.failedResultTask(MediaInfoError.SeekPointsNotAvailable);
        }
        ResultTask<int[]> resultTask = this.I;
        if (resultTask != null && !resultTask.didSignalEvent(Task.Event.FAIL)) {
            return this.I;
        }
        this.I = new ResultTask<>();
        this.J = new AsyncTaskC1793k(this).executeOnExecutor(f20675e, this.t);
        return this.I;
    }

    public int[] G() {
        if (this.J == null) {
            F();
            if (this.J == null) {
                throw new IllegalStateException();
            }
        }
        try {
            return this.J.get();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return null;
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public ResultTask<T> H() {
        int i2;
        int i3;
        if (!this.L && !this.D.c()) {
            if (this.w == null && this.z == null) {
                return ResultTask.failedResultTask(MediaInfoError.ThumbnailsNotAvailable);
            }
            c<T, f> cVar = this.E;
            if (cVar != null && !cVar.didSignalEvent(Task.Event.FAIL)) {
                return this.E;
            }
            b bVar = this.K;
            int i4 = bVar.f20690h;
            if (i4 > 0 && (i2 = bVar.f20689g) > 0) {
                try {
                    i3 = (i4 * 640) / i2;
                } catch (ArithmeticException e2) {
                    e2.printStackTrace();
                    i3 = 640;
                }
                this.E = new c<>(this, new f(this.t, this.z, 640, i3, 0, K(), 0, 0), new y(this));
                d(this.w).onResultAvailable(new z(this));
                return this.E;
            }
            return ResultTask.failedResultTask(MediaInfoError.ThumbnailsNotAvailable);
        }
        return ResultTask.failedResultTask(MediaInfoError.ThumbnailsNotAvailable);
    }

    public int I() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.r;
    }

    public CodecType J() {
        if (this.L || this.D.c()) {
            return null;
        }
        return CodecType.a(this.K.w);
    }

    public int K() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.l;
    }

    public int L() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.z;
    }

    public int M() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.p;
    }

    public int N() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.o;
    }

    public int O() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.B;
    }

    public int P() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.f20690h;
    }

    public int Q() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.f20689g;
    }

    public int R() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.f20689g;
    }

    public boolean S() {
        if (this.L || this.D.c()) {
            return false;
        }
        return this.K.f20686d;
    }

    public boolean T() {
        if (this.L || this.D.c()) {
            return false;
        }
        return this.K.f20688f;
    }

    public boolean U() {
        if (this.L || this.D.c()) {
            return false;
        }
        return this.K.f20687e;
    }

    public boolean V() {
        return this.L || this.D.c();
    }

    public boolean W() {
        return this.L;
    }

    public boolean Y() {
        if (U()) {
            return this.D != NexEditor.b.G && C() * D() <= (NexEditorDeviceProfile.getDeviceProfile().getMaxImportSize(ca()) * 110) / 100;
        }
        return true;
    }

    public boolean Z() {
        if (this.L || this.D.c() || !Y()) {
            return false;
        }
        return U() || S() || T();
    }

    public int o() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.k;
    }

    public int p() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.A;
    }

    public int q() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.t;
    }

    public int r() {
        if (this.L || this.D.c()) {
            return 0;
        }
        b bVar = this.K;
        if (bVar.f20686d) {
            return bVar.k;
        }
        return bVar.l;
    }

    public NexEditor.b s() {
        if (this.L) {
            return NexEditor.b.xb;
        }
        return this.D;
    }

    public int t() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.n;
    }

    public long u() {
        if (this.L || this.D.c()) {
            return 0L;
        }
        return this.K.f20685c;
    }

    public int v() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.f20690h;
    }

    public ResultTask<Bitmap> w() {
        if (this.y == null) {
            return ResultTask.failedResultTask(MediaInfoError.LargeEndThumbnailNotAvailable);
        }
        ResultTask<Bitmap> resultTask = this.H;
        if (resultTask != null) {
            return resultTask;
        }
        this.H = new ResultTask<>();
        c(this.y).onResultAvailable(new C1792j(this));
        return this.H;
    }

    public ResultTask<Bitmap> x() {
        if (this.x == null) {
            return ResultTask.failedResultTask(MediaInfoError.LargeStartThumbnailNotAvailable);
        }
        ResultTask<Bitmap> resultTask = this.G;
        if (resultTask != null) {
            return resultTask;
        }
        this.G = new ResultTask<>();
        c(this.x).onResultAvailable(new C1789g(this));
        return this.G;
    }

    public MediaSupportType y() {
        if (this.D.c()) {
            NexEditor.b bVar = this.D;
            return bVar == NexEditor.b.aa ? MediaSupportType.NotSupported_AudioCodec : bVar == NexEditor.b.Y ? MediaSupportType.NotSupported_AudioProfile : bVar == NexEditor.b.s ? MediaSupportType.NotSupported_Container : bVar == NexEditor.b.G ? MediaSupportType.NotSupported_ResolutionTooHigh : bVar == NexEditor.b.F ? MediaSupportType.NotSupported_DurationTooShort : bVar == NexEditor.b.H ? MediaSupportType.NotSupported_ResolutionTooLow : bVar == NexEditor.b.I ? MediaSupportType.NotSupported_VideoProfile : bVar == NexEditor.b.ba ? MediaSupportType.NotSupported_VideoCodec : bVar == NexEditor.b.K ? MediaSupportType.NotSupported_VideoFPS : bVar == NexEditor.b.J ? MediaSupportType.NotSupported_VideoLevel : MediaSupportType.NotSupported;
        }
        if (EditorGlobal.i() == null) {
            return Z() ? MediaSupportType.Supported : MediaSupportType.Unknown;
        }
        int a2 = EditorGlobal.i().i().a(N(), M(), D(), C(), t(), I(), q(), m(), L(), p(), J(), O());
        if (EditorGlobal.w() && (a2 == 1 || a2 == 4)) {
            Log.d("MediaInfo", "getMediaSupportType: path:" + this.t.getAbsolutePath() + ", error:" + a2);
            return MediaSupportType.Supported;
        }
        if (a2 == 0) {
            return MediaSupportType.Supported;
        }
        if (a2 == 1) {
            return MediaSupportType.NeedTranscodeRes;
        }
        if (a2 == 2) {
            return MediaSupportType.NeedTranscodeFPS;
        }
        if (a2 == 3) {
            return MediaSupportType.NotSupported_VideoProfile;
        }
        if (a2 == 4) {
            return MediaSupportType.NotSupported_ResolutionTooHigh;
        }
        if (a2 == 5) {
            return MediaSupportType.NotSupported;
        }
        if (a2 != 8) {
            return MediaSupportType.Unknown;
        }
        return MediaSupportType.NeedTranscodeAVSync;
    }

    public int z() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int A;
        public int B;

        /* renamed from: a, reason: collision with root package name */
        public int f20683a;

        /* renamed from: b, reason: collision with root package name */
        public String f20684b;

        /* renamed from: c, reason: collision with root package name */
        public long f20685c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f20686d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f20687e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f20688f;

        /* renamed from: g, reason: collision with root package name */
        public int f20689g;

        /* renamed from: h, reason: collision with root package name */
        public int f20690h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public int z;

        private b() {
            this.B = 1;
        }

        /* synthetic */ b(AsyncTaskC1799q asyncTaskC1799q) {
            this();
        }
    }

    public static void k() {
        if (f20671a != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, WeakReference<MediaInfo>> entry : f20671a.entrySet()) {
                String key = entry.getKey();
                File file = key == null ? null : new File(key);
                if (file != null && !file.exists()) {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f20671a.remove((String) it.next());
            }
        }
    }

    public static void l() {
        Map<String, WeakReference<MediaInfo>> map = f20671a;
        if (map != null) {
            map.clear();
        }
    }

    public int m() {
        if (this.L || this.D.c()) {
            return 0;
        }
        return this.K.u;
    }

    public CodecType n() {
        if (this.L || this.D.c()) {
            return null;
        }
        return CodecType.a(this.K.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<Bitmap> c(File file) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        new A(this, resultTask).executeOnExecutor(f20675e, file);
        return resultTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<a> d(File file) {
        ResultTask<a> resultTask = new ResultTask<>();
        new B(this, resultTask).executeOnExecutor(f20675e, file);
        return resultTask;
    }

    public static void a(Context context) {
        f20677g = context.getApplicationContext().getCacheDir();
    }

    private static String b(File file) {
        String name = file.getName();
        int hashCode = file.getAbsolutePath().hashCode();
        long lastModified = file.lastModified();
        long length = file.length();
        if (name.length() > 32) {
            name = name.substring(0, 32);
        }
        return name + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + String.format(Locale.US, "%08X", Integer.valueOf((int) ((((lastModified * 212501089) + (length * 194851861)) + hashCode) % 268435455)));
    }

    public static MediaInfo a(String str) {
        if (str == null) {
            return null;
        }
        return a(new File(str));
    }

    public static MediaInfo a(File file) {
        MediaInfo mediaInfo;
        if (file == null) {
            return null;
        }
        if (f20671a == null) {
            f20671a = new HashMap();
        }
        if (f20672b == null) {
            f20672b = ExclusionList.exclusionListBackedBy(new File(new File(f20677g, ".km_mediainfo"), "mediainfo_exclude.dat"));
        }
        if (f20673c == null) {
            f20673c = ExclusionList.exclusionListBackedBy(new File(new File(f20677g, ".km_mediainfo"), "mediainfo_thumb_exclude.dat"));
        }
        String absolutePath = file.getAbsolutePath();
        WeakReference<MediaInfo> weakReference = f20671a.get(absolutePath);
        if (weakReference != null && (mediaInfo = weakReference.get()) != null) {
            return mediaInfo;
        }
        MediaInfo mediaInfo2 = new MediaInfo(file);
        if (file.exists()) {
            f20671a.put(absolutePath, new WeakReference<>(mediaInfo2));
        }
        return mediaInfo2;
    }

    public static boolean b(String str) {
        MediaInfo a2 = a(new File(str));
        return (a2.r() - LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT) / Math.max(1, a2.E()) > 4000;
    }

    public ResultTask<Bitmap> a(int i2, int i3, int i4) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        String str = i2 + "," + i3 + "," + i4 + "," + B().getPath();
        Bitmap bitmap = f20676f.get(str);
        if (bitmap != null) {
            resultTask.setResult(bitmap);
            return resultTask;
        }
        a(i2, i3, i4, i4 + 100, 3, 0, new C1800s(this, str, resultTask));
        return resultTask;
    }

    public Task a(int i2, int i3, int i4, int i5, int i6, int i7, M m2) {
        if (!this.L && !this.D.c()) {
            if (this.w == null && this.z == null) {
                return ResultTask.failedResultTask(MediaInfoError.ThumbnailsNotAvailable);
            }
            c<T, f> cVar = this.E;
            if (cVar != null && !cVar.didSignalEvent(Task.Event.FAIL)) {
                return this.E;
            }
            i++;
            File file = new File(this.B, this.C + "_detail_" + i2 + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + i3 + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + i4 + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + i5 + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + i6 + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + i);
            c<T, f> cVar2 = new c<>(this, new f(this.t, file, i2, i3, i4, i5, i6, i7), new C1802u(this, file, i6, m2));
            boolean z = da() != null && f20678h.isEmpty();
            f20678h.add(cVar2);
            if (z) {
                ha();
            }
            return cVar2;
        }
        return ResultTask.failedResultTask(MediaInfoError.ThumbnailsNotAvailable);
    }
}
