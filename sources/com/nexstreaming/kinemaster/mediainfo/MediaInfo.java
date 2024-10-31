package com.nexstreaming.kinemaster.mediainfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.LruCache;
import android.util.SparseArray;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.ExclusionList;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexvideoeditor.NexClipInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
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

/* loaded from: classes.dex */
public class MediaInfo {
    private static ExclusionList b;
    private static File y;
    private File c;
    private File d;
    private File e;
    private File f;
    private File g;
    private File h;
    private File i;
    private File j;
    private File k;
    private String l;
    private NexEditor.b m;
    private c<aq, f> n = null;
    private c<aj, Void> o = null;
    private ResultTask<Bitmap> p = null;
    private ResultTask<Bitmap> q = null;
    private ResultTask<int[]> r = null;
    private AsyncTask<File, Integer, int[]> s = null;
    private b t;
    private boolean x;

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, WeakReference<MediaInfo>> f3482a = null;
    private static Executor u = Executors.newSingleThreadExecutor();
    private static Executor v = Executors.newSingleThreadExecutor();
    private static LruCache<String, Bitmap> w = new LruCache<>(20);
    private static Deque<c<aq, f>> z = new ArrayDeque();
    private static int A = 0;
    private static Deque<c<aj, Void>> B = new ArrayDeque();
    private static Task C = null;
    private static SparseArray<c<?, ?>> D = new SparseArray<>();
    private static boolean E = false;
    private static boolean F = false;
    private static NexEditor.k G = new l();
    private static NexEditor.j H = new m();
    private static NexEditor.i I = new n();
    private static NexEditor.m J = new o();

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

    public static void a(Context context) {
        y = context.getApplicationContext().getCacheDir();
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
        if (f3482a == null) {
            f3482a = new HashMap();
        }
        if (b == null) {
            b = ExclusionList.exclusionListBackedBy(new File(new File(y, ".km_mediainfo"), "mediainfo_exclude.dat"));
        }
        String absolutePath = file.getAbsolutePath();
        WeakReference<MediaInfo> weakReference = f3482a.get(absolutePath);
        if (weakReference == null || (mediaInfo = weakReference.get()) == null) {
            MediaInfo mediaInfo2 = new MediaInfo(file);
            if (file.exists()) {
                f3482a.put(absolutePath, new WeakReference<>(mediaInfo2));
                return mediaInfo2;
            }
            return mediaInfo2;
        }
        return mediaInfo;
    }

    public static void a() {
        if (f3482a != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, WeakReference<MediaInfo>> entry : f3482a.entrySet()) {
                String key = entry.getKey();
                File file = key == null ? null : new File(key);
                if (file != null && !file.exists()) {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f3482a.remove((String) it.next());
            }
        }
    }

    private void U() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.c.getAbsolutePath(), options);
        this.t = new b(null);
        this.t.f3484a = 7;
        this.t.b = this.c.getAbsolutePath();
        this.t.d = false;
        this.t.e = false;
        this.t.f = true;
        this.t.i = 0;
        this.t.j = 0;
        this.t.c = this.c.length();
        this.t.g = options.outWidth;
        this.t.h = options.outHeight;
        this.t.k = 0;
        this.t.l = 0;
        this.t.m = 0;
        this.t.n = 0;
        this.x = false;
        this.m = NexEditor.b.f4793a;
    }

    private MediaInfo(File file) {
        Gson gson;
        b bVar;
        BufferedReader bufferedReader;
        com.nexstreaming.kinemaster.mediainfo.b bVar2 = null;
        this.m = NexEditor.b.f4793a;
        FileType fromFile = FileType.fromFile(file);
        if (fromFile != null && fromFile.isImage()) {
            this.c = file;
            U();
            return;
        }
        File file2 = new File(y, ".km_mediainfo");
        file2.mkdirs();
        String b2 = b(file);
        this.c = file;
        this.d = new File(file2, b2 + "_info.dat");
        this.e = new File(file2, b2 + "_seek.dat");
        this.f = new File(file2, b2 + "_vthumb.dat");
        this.g = new File(file2, b2 + "_vthumb_large.dat");
        this.h = new File(file2, b2 + "_vthumb_large_end.dat");
        this.i = new File(file2, b2 + "_vthumb_raw.dat");
        this.j = new File(file2, b2 + "_pcm.dat");
        this.k = file2;
        this.l = b2;
        if (this.d.exists()) {
            gson = 0 == 0 ? new Gson() : null;
            try {
                bufferedReader = new BufferedReader(new FileReader(this.d));
            } catch (JsonIOException e2) {
                bVar = null;
            } catch (JsonSyntaxException e3) {
                bVar = null;
            } catch (IOException e4) {
                bVar = null;
            }
            try {
                bVar = (b) gson.fromJson((Reader) bufferedReader, b.class);
                try {
                    bufferedReader.close();
                } catch (JsonIOException e5) {
                } catch (JsonSyntaxException e6) {
                } catch (IOException e7) {
                }
                if (bVar != null && bVar.f3484a == 7) {
                    this.t = bVar;
                    return;
                }
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } else {
            gson = null;
        }
        if (b != null && b.isExcluded(b2)) {
            this.x = true;
            return;
        }
        NexClipInfo nexClipInfo = new NexClipInfo();
        NexEditor X = X();
        if (X == null) {
            this.m = NexEditor.b.aZ;
            return;
        }
        b.add(b2);
        this.m = X.a(file.getAbsolutePath(), nexClipInfo, false, 0);
        b.remove(b2);
        this.t = new b(bVar2);
        if (this.m == NexEditor.b.f4793a) {
            this.t.f3484a = 7;
            this.t.b = file.getAbsolutePath();
            this.t.d = nexClipInfo.mExistAudio != 0;
            this.t.e = nexClipInfo.mExistVideo != 0;
            this.t.f = false;
            this.t.i = nexClipInfo.mAudioDuration;
            this.t.j = nexClipInfo.mVideoDuration;
            this.t.c = file.length();
            this.t.g = nexClipInfo.mVideoWidth;
            this.t.h = nexClipInfo.mVideoHeight;
            this.t.k = nexClipInfo.mSeekPointCount;
            this.t.l = nexClipInfo.mFPS;
            this.t.m = nexClipInfo.mVideoH264Profile;
            this.t.n = nexClipInfo.mVideoH264Level;
            this.t.s = nexClipInfo.mVideoOrientation;
            this.t.t = nexClipInfo.mVideoCodecType;
            this.t.u = nexClipInfo.mAudioCodecType;
            this.t.o = nexClipInfo.mVideoBitRate;
            this.t.p = nexClipInfo.mAudioBitRate;
            this.t.q = nexClipInfo.mAudioSampleRate;
            this.t.r = nexClipInfo.mAudioChannels;
            gson = gson == null ? new Gson() : gson;
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.d));
                try {
                    gson.toJson(this.t, bufferedWriter);
                } finally {
                    bufferedWriter.close();
                    this.d.setReadable(true);
                }
            } catch (IOException e8) {
                e8.printStackTrace();
            }
        }
    }

    private static String b(File file) {
        String name = file.getName();
        int hashCode = file.getAbsolutePath().hashCode();
        long lastModified = file.lastModified();
        long length = file.length();
        if (name.length() > 32) {
            name = name.substring(0, 32);
        }
        return name + "_" + String.format(Locale.US, "%08X", Integer.valueOf((int) ((((lastModified * 212501089) + (length * 194851861)) + hashCode) % 268435455)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final File f3486a;
        public final File b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;

        protected f(File file, File file2, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f3486a = file;
            this.b = file2;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task V() {
        Task task = new Task();
        new File(y, ".km_mediainfo").mkdirs();
        new com.nexstreaming.kinemaster.mediainfo.b(this, this.i, this.f, this.g, this.h, task).executeOnExecutor(u, new Integer[]{0});
        return task;
    }

    public ResultTask<Bitmap> a(int i, int i2, int i3) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        String str = i + "," + i2 + "," + i3 + "," + h().getPath();
        Bitmap bitmap = w.get(str);
        if (bitmap != null) {
            resultTask.setResult(bitmap);
            return resultTask;
        }
        a(i, i2, i3, i3 + 100, 3, 0, new p(this, str, resultTask));
        return resultTask;
    }

    public Task a(int i, int i2, int i3, int i4, int i5, int i6, ak akVar) {
        A++;
        File file = new File(this.k, this.l + "_detail_" + i + "_" + i2 + "_" + i3 + "_" + i4 + "_" + i5 + "_" + A);
        c<aq, f> cVar = new c<>(this, new f(this.c, file, i, i2, i3, i4, i5, i6), new r(this, file, i5, akVar));
        boolean z2 = X() != null && z.isEmpty();
        z.add(cVar);
        if (z2) {
            aa();
        }
        return cVar;
    }

    public ResultTask<aq> b() {
        if (this.x || this.m.a()) {
            return ResultTask.failedResultTask(MediaInfoError.ThumbnailsNotAvailable);
        }
        if (this.f == null && this.i == null) {
            return ResultTask.failedResultTask(MediaInfoError.ThumbnailsNotAvailable);
        }
        if (this.n != null && !this.n.didSignalEvent(Task.Event.FAIL)) {
            return this.n;
        }
        this.n = new c<>(this, new f(this.c, this.i, 640, 360, 0, 0, 0, 0), new t(this));
        d(this.f).onResultAvailable(new x(this));
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<Bitmap> c(File file) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        new y(this, resultTask).executeOnExecutor(v, file);
        return resultTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final int f3483a;
        final int b;
        final int[] c;
        final Bitmap d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, int i2, int[] iArr, Bitmap bitmap) {
            this.f3483a = i;
            this.b = i2;
            this.c = iArr;
            this.d = bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<a> d(File file) {
        ResultTask<a> resultTask = new ResultTask<>();
        new z(this, resultTask).executeOnExecutor(v, file);
        return resultTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultTask<aj> W() {
        ResultTask<aj> resultTask = new ResultTask<>();
        new aa(this, resultTask).executeOnExecutor(v, this);
        return resultTask;
    }

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
        public String getMessage() {
            return name();
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            return name();
        }
    }

    public ResultTask<aj> c() {
        if (this.j == null) {
            return ResultTask.failedResultTask(MediaInfoError.PCMLevelsNotAvailable);
        }
        if (this.o != null && !this.o.didSignalEvent(Task.Event.FAIL)) {
            return this.o;
        }
        this.o = new c<>(this, null, new ab(this));
        W().onResultAvailable(new com.nexstreaming.kinemaster.mediainfo.c(this));
        return this.o;
    }

    public ResultTask<Bitmap> d() {
        if (this.g == null) {
            return ResultTask.failedResultTask(MediaInfoError.LargeStartThumbnailNotAvailable);
        }
        if (this.p != null) {
            return this.p;
        }
        this.p = new ResultTask<>();
        c(this.g).onResultAvailable(new com.nexstreaming.kinemaster.mediainfo.d(this));
        return this.p;
    }

    public ResultTask<Bitmap> e() {
        if (this.h == null) {
            return ResultTask.failedResultTask(MediaInfoError.LargeEndThumbnailNotAvailable);
        }
        if (this.q != null) {
            return this.q;
        }
        this.q = new ResultTask<>();
        c(this.h).onResultAvailable(new h(this));
        return this.q;
    }

    public int[] f() {
        if (this.s == null) {
            g();
            if (this.s == null) {
                throw new IllegalStateException();
            }
        }
        try {
            return this.s.get();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return null;
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public ResultTask<int[]> g() {
        if (this.e == null) {
            return ResultTask.failedResultTask(MediaInfoError.SeekPointsNotAvailable);
        }
        if (this.r != null && !this.r.didSignalEvent(Task.Event.FAIL)) {
            return this.r;
        }
        this.r = new ResultTask<>();
        this.s = new k(this).executeOnExecutor(v, this.c);
        return this.r;
    }

    public File h() {
        return this.c;
    }

    public long i() {
        if (this.x || this.m.a()) {
            return 0L;
        }
        return this.t.c;
    }

    public int j() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.k;
    }

    public boolean k() {
        return this.m != NexEditor.b.F && v() * u() <= (NexEditorDeviceProfile.getDeviceProfile().getMaxImportSize(Y()) * 110) / 100;
    }

    public boolean l() {
        if (this.x || this.m.a() || !k()) {
            return false;
        }
        return s() || r() || t();
    }

    public boolean m() {
        return this.x || this.m.a();
    }

    public MediaStoreItem.MediaSupportType n() {
        if (this.m.a()) {
            return this.m == NexEditor.b.Z ? MediaStoreItem.MediaSupportType.NotSupported_AudioCodec : this.m == NexEditor.b.X ? MediaStoreItem.MediaSupportType.NotSupported_AudioProfile : this.m == NexEditor.b.r ? MediaStoreItem.MediaSupportType.NotSupported_Container : this.m == NexEditor.b.F ? MediaStoreItem.MediaSupportType.NotSupported_ResolutionTooHigh : this.m == NexEditor.b.E ? MediaStoreItem.MediaSupportType.NotSupported_DurationTooShort : this.m == NexEditor.b.G ? MediaStoreItem.MediaSupportType.NotSupported_ResolutionTooLow : this.m == NexEditor.b.H ? MediaStoreItem.MediaSupportType.NotSupported_VideoProfile : this.m == NexEditor.b.aa ? MediaStoreItem.MediaSupportType.NotSupported_VideoCodec : this.m == NexEditor.b.J ? MediaStoreItem.MediaSupportType.NotSupported_VideoFPS : this.m == NexEditor.b.I ? MediaStoreItem.MediaSupportType.NotSupported_VideoLevel : MediaStoreItem.MediaSupportType.NotSupported;
        }
        if (EditorGlobal.a() == null) {
            return l() ? MediaStoreItem.MediaSupportType.Supported : MediaStoreItem.MediaSupportType.Unknown;
        }
        switch (EditorGlobal.a().d().a(D(), E(), u(), v(), B(), F(), H(), I())) {
            case 0:
                return MediaStoreItem.MediaSupportType.Supported;
            case 1:
                return MediaStoreItem.MediaSupportType.NeedTranscodeRes;
            case 2:
                return MediaStoreItem.MediaSupportType.NeedTranscodeFPS;
            case 3:
                return MediaStoreItem.MediaSupportType.NotSupported_VideoProfile;
            case 4:
                return MediaStoreItem.MediaSupportType.NotSupported_ResolutionTooHigh;
            case 5:
                return MediaStoreItem.MediaSupportType.NotSupported;
            default:
                return MediaStoreItem.MediaSupportType.Unknown;
        }
    }

    public boolean o() {
        return this.x;
    }

    public static boolean p() {
        return D.size() != 0;
    }

    public static Task q() {
        boolean p = p();
        if (C == null || (C.isComplete() && p)) {
            C = new Task();
        }
        if (!p) {
            C.signalEvent(Task.Event.COMPLETE);
        }
        return C;
    }

    public boolean r() {
        if (this.x || this.m.a()) {
            return false;
        }
        return this.t.d;
    }

    public boolean s() {
        if (this.x || this.m.a()) {
            return false;
        }
        return this.t.e;
    }

    public boolean t() {
        if (this.x || this.m.a()) {
            return false;
        }
        return this.t.f;
    }

    public int u() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.g;
    }

    public int v() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.h;
    }

    public int w() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.g;
    }

    public int x() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.h;
    }

    public int y() {
        if (this.x || this.m.a()) {
            return 0;
        }
        if (this.t.d) {
            return this.t.i;
        }
        return this.t.j;
    }

    public int z() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.i;
    }

    public int A() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.j;
    }

    public int B() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.l;
    }

    public int C() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.s;
    }

    public int D() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.m;
    }

    public int E() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.n;
    }

    public int F() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.o;
    }

    public int G() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.p;
    }

    public int H() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.q;
    }

    public int I() {
        if (this.x || this.m.a()) {
            return 0;
        }
        return this.t.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f3484a;
        public String b;
        public long c;
        public boolean d;
        public boolean e;
        public boolean f;
        public int g;
        public int h;
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

        private b() {
        }

        /* synthetic */ b(com.nexstreaming.kinemaster.mediainfo.b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c<RESULT_TYPE, PARAM_TYPE> extends ResultTask<RESULT_TYPE> {
        private final MediaInfo b;
        private final d<RESULT_TYPE, PARAM_TYPE> c;
        private final PARAM_TYPE e;

        /* renamed from: a, reason: collision with root package name */
        int f3485a = 3;
        private final e d = null;

        public c(MediaInfo mediaInfo, PARAM_TYPE param_type, d<RESULT_TYPE, PARAM_TYPE> dVar) {
            this.c = dVar;
            this.b = mediaInfo;
            this.e = param_type;
            MediaInfo.D.put(getTaskId(), this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PARAM_TYPE a() {
            return this.e;
        }

        @Override // com.nexstreaming.app.general.task.ResultTask
        public void sendResult(RESULT_TYPE result_type) {
            if (MediaInfo.D.get(getTaskId()) == this) {
                MediaInfo.D.remove(getTaskId());
                if (MediaInfo.D.size() == 0 && MediaInfo.C != null) {
                    MediaInfo.C.signalEvent(Task.Event.COMPLETE);
                }
                super.sendResult(result_type);
            }
        }

        @Override // com.nexstreaming.app.general.task.Task
        public void sendFailure(Task.TaskError taskError) {
            if (MediaInfo.D.get(getTaskId()) == this) {
                super.sendFailure(taskError);
                MediaInfo.D.remove(getTaskId());
                if (MediaInfo.D.size() == 0 && MediaInfo.C != null) {
                    MediaInfo.C.signalEvent(Task.Event.COMPLETE);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(NexEditor.b bVar) {
            if (MediaInfo.D.get(getTaskId()) == this && this.c != null) {
                this.c.a(this, bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7) {
            if (MediaInfo.D.get(getTaskId()) == this && this.d != null) {
                this.d.a(i, i2, i3, i4, i5, bArr, i6, i7);
            }
        }
    }

    public CodecType J() {
        if (this.x || this.m.a()) {
            return null;
        }
        return CodecType.a(this.t.t);
    }

    public CodecType K() {
        if (this.x || this.m.a()) {
            return null;
        }
        return CodecType.a(this.t.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NexEditor X() {
        if (EditorGlobal.a() == null) {
            return null;
        }
        EditorGlobal.a().a(H);
        EditorGlobal.a().a(J);
        EditorGlobal.a().a(I);
        EditorGlobal.a().a(G);
        return EditorGlobal.a();
    }

    private static boolean Y() {
        if (!E) {
            NexEditor X = X();
            if (X == null) {
                return false;
            }
            F = X.i();
            E = true;
        }
        return F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Z() {
        NexEditor X;
        if (!B.isEmpty() && (X = X()) != null) {
            c<aj, Void> remove = B.remove();
            X.a(((c) remove).b.c, ((c) remove).b.j, remove.getTaskId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aa() {
        NexEditor X;
        if (!z.isEmpty() && (X = X()) != null) {
            c<aq, f> remove = z.remove();
            f fVar = (f) remove.a();
            try {
                X.a(fVar.f3486a, fVar.b, fVar.c, fVar.d, fVar.e, fVar.f, fVar.g, fVar.h, remove.getTaskId());
            } catch (IOException e2) {
                remove.sendFailure(Task.makeTaskError(e2));
            }
        }
    }
}
