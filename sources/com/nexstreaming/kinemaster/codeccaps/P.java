package com.nexstreaming.kinemaster.codeccaps;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v7.widget.ActivityChooserView;
import android.view.Surface;
import android.view.WindowManager;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.H264Level;
import com.nexstreaming.kinemaster.editorwrapper.H264Profile;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.NexAudioClip;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexRectangle;
import com.nextreaming.nexvideoeditor.NexThemeView;
import com.nextreaming.nexvideoeditor.NexVisualClip;
import com.nextreaming.nexvideoeditor.ha;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: CodecTestCase.java */
/* loaded from: classes.dex */
public class P {

    /* renamed from: a */
    private static int f20071a;
    private int A;
    private int D;
    private ResultTask<b> E;
    private ResultTask<b> F;

    /* renamed from: b */
    private final boolean f20072b;

    /* renamed from: c */
    private String f20073c;

    /* renamed from: d */
    private int f20074d;

    /* renamed from: e */
    private int f20075e;

    /* renamed from: f */
    private int f20076f;

    /* renamed from: g */
    private int f20077g;

    /* renamed from: h */
    private Object f20078h;
    private int i;
    private H264Level m;
    private H264Profile n;
    private volatile int o;
    private boolean p;
    private long s;
    private InterfaceC1716d t;
    private NexEditor.u u;
    private NexThemeView v;
    private Activity w;
    private int x;
    private long y;
    private boolean j = false;
    private boolean k = false;
    private List<a> l = new ArrayList();
    private int q = 0;
    private int r = 0;
    private boolean z = false;
    private long B = 0;
    private Handler C = new Handler();
    private Runnable G = new A(this);
    private Object H = new Object();
    private boolean I = false;
    private NexEditor.d J = new J(this);
    private NexEditor.i K = new K(this);
    private ha L = new M(this);
    private NexEditor.r M = new N(this);

    /* compiled from: CodecTestCase.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public final String f20079a;

        /* renamed from: b */
        public final int f20080b;

        /* renamed from: c */
        int f20081c;

        /* synthetic */ a(String str, int i, A a2) {
            this(str, i);
        }

        private a(String str, int i) {
            this.f20079a = str;
            this.f20080b = i;
        }
    }

    /* compiled from: CodecTestCase.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        private boolean f20082a = false;

        /* renamed from: b */
        private final Object f20083b;

        /* renamed from: c */
        private Task.TaskError f20084c;

        /* renamed from: d */
        private int f20085d;

        /* renamed from: e */
        private int f20086e;

        /* renamed from: f */
        private long f20087f;

        /* renamed from: g */
        private MediaInfo f20088g;

        /* renamed from: h */
        private int f20089h;
        private int i;
        private int j;
        private int k;
        private int l;
        private NexEditor.u m;

        public b(Object obj) {
            this.f20083b = obj;
        }

        public static /* synthetic */ b a(b bVar, int i) {
            bVar.b(i);
            return bVar;
        }

        public static /* synthetic */ b b(b bVar, int i) {
            bVar.a(i);
            return bVar;
        }

        private b n() {
            this.f20082a = true;
            return this;
        }

        public long c() {
            return this.f20087f;
        }

        public int d() {
            return this.k;
        }

        public Task.TaskError e() {
            return this.f20084c;
        }

        public int f() {
            return this.i;
        }

        public MediaInfo g() {
            return this.f20088g;
        }

        public int h() {
            return this.j;
        }

        public NexEditor.u i() {
            return this.m;
        }

        public int j() {
            return this.f20086e;
        }

        public Object k() {
            return this.f20083b;
        }

        public int l() {
            return this.f20085d;
        }

        public boolean m() {
            return this.f20082a;
        }

        public static /* synthetic */ b a(b bVar, Task.TaskError taskError) {
            bVar.a(taskError);
            return bVar;
        }

        public int b() {
            return this.l;
        }

        public static /* synthetic */ b a(b bVar) {
            bVar.n();
            return bVar;
        }

        private b b(int i) {
            this.k = i;
            return this;
        }

        public static /* synthetic */ b a(b bVar, MediaInfo mediaInfo) {
            bVar.a(mediaInfo);
            return bVar;
        }

        public static /* synthetic */ b a(b bVar, NexEditor.u uVar) {
            bVar.a(uVar);
            return bVar;
        }

        public static /* synthetic */ b a(b bVar, int i, int i2, long j, int i3) {
            bVar.a(i, i2, j, i3);
            return bVar;
        }

        public static /* synthetic */ b a(b bVar, int i, int i2) {
            bVar.a(i, i2);
            return bVar;
        }

        public int a() {
            return this.f20089h;
        }

        private b a(Task.TaskError taskError) {
            this.f20084c = taskError;
            return this;
        }

        private b a(int i, int i2, long j, int i3) {
            this.f20086e = i;
            this.f20085d = i2;
            this.f20087f = j;
            this.l = i3;
            return this;
        }

        private b a(int i, int i2) {
            this.i = i;
            this.j = i2;
            return this;
        }

        private b a(MediaInfo mediaInfo) {
            this.f20088g = mediaInfo;
            return this;
        }

        private b a(int i) {
            this.f20089h = i;
            return this;
        }

        private b a(NexEditor.u uVar) {
            this.m = uVar;
            return this;
        }
    }

    private P(boolean z) {
        int i = f20071a;
        this.D = i;
        f20071a = i + 1;
        this.f20072b = z;
    }

    private float a(int i) {
        return (i == 90 || i == 270) ? 0.5625f : 1.7777778f;
    }

    private static int a(int i, int i2) {
        return (((i - 1) | 15) + 1) * (((i2 - 1) | 15) + 1);
    }

    public static /* synthetic */ int n(P p) {
        int i = p.o;
        p.o = i + 1;
        return i;
    }

    public NexEditor d() {
        return KineMasterApplication.f24056d.r();
    }

    public void c() {
        synchronized (this.H) {
            this.C.removeCallbacks(this.G);
            this.k = true;
            this.F = null;
            this.t.a();
            if (this.w != null) {
                if (this.v != null) {
                    d().a((Surface) null);
                    d().a((NexThemeView) null);
                    if (this.I) {
                        this.w.getWindowManager().removeView(this.v);
                    }
                    this.v = null;
                }
                this.w = null;
            }
            d().a((NexEditor.i) null);
            d().closeProject();
            d().b(-1, -1, -1);
            d().createProject();
            d().q();
        }
    }

    public Object b() {
        return this.f20078h;
    }

    public static P a(Object obj, int i, String str, int i2, int i3, int i4, int i5, H264Profile h264Profile, H264Level h264Level) {
        P p = new P(true);
        p.f20078h = obj;
        p.i = i;
        p.f20073c = str;
        p.f20074d = i2;
        p.f20075e = i3;
        p.f20076f = i4;
        p.n = h264Profile;
        p.m = h264Level;
        if (i5 <= 0) {
            p.f20077g = (int) (((((((float) (i2 * i3)) * 30.0f) * 2.0f) * 0.07f) / 1000.0f) * 1024.0f);
        } else {
            p.f20077g = i5;
        }
        p.q = a(i2, i3);
        return p;
    }

    public static P a(Object obj, int i) {
        P p = new P(false);
        p.f20078h = obj;
        p.i = i;
        p.q = 0;
        return p;
    }

    public void a(String str, int i) {
        this.l.add(new a(str, i, null));
    }

    public ResultTask<b> a(InterfaceC1716d interfaceC1716d, Activity activity) {
        if (!this.j && !this.p) {
            int i = 1;
            this.j = true;
            this.s = System.nanoTime();
            ResultTask<b> resultTask = new ResultTask<>();
            InterfaceC1716d interfaceC1716d2 = interfaceC1716d == null ? C1719g.f20098a : interfaceC1716d;
            this.t = interfaceC1716d2;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Random random = new Random();
            this.x = Color.argb(255, random.nextInt(150), random.nextInt(75), random.nextInt(200));
            int i2 = 0;
            Rect rect = new Rect(0, 0, 1280, 720);
            NexVisualClip nexVisualClip = new NexVisualClip();
            nexVisualClip.mClipID = 33554431;
            nexVisualClip.mClipPath = String.format("@solid:%08X.jpg", Integer.valueOf(this.x));
            nexVisualClip.mClipType = 1;
            nexVisualClip.mStartTime = 0;
            nexVisualClip.mWidth = 1280;
            nexVisualClip.mHeight = 720;
            int i3 = this.i;
            nexVisualClip.mTotalTime = i3;
            nexVisualClip.mTotalAudioTime = i3;
            nexVisualClip.mTotalVideoTime = i3;
            nexVisualClip.mExistAudio = 0;
            nexVisualClip.mExistVideo = 1;
            nexVisualClip.mSpeedControl = 100;
            nexVisualClip.mEndTime = nexVisualClip.mStartTime + nexVisualClip.mTotalTime;
            nexVisualClip.mVolumeEnvelopeLevel = new int[]{100};
            nexVisualClip.mVolumeEnvelopeTime = new int[]{0};
            nexVisualClip.mRotateState = 0;
            nexVisualClip.mStartRect = a(rect, nexVisualClip.mWidth, nexVisualClip.mHeight, nexVisualClip.mRotateState);
            nexVisualClip.mEndRect = a(rect, nexVisualClip.mWidth, nexVisualClip.mHeight, nexVisualClip.mRotateState);
            arrayList.add(nexVisualClip);
            File b2 = EditorGlobal.b();
            if (!b2.exists()) {
                b2.mkdir();
            }
            File file = new File(b2, "dci_audio");
            if (!file.exists()) {
                try {
                    InputStream open = KineMasterApplication.f24056d.getApplicationContext().getAssets().open("DCI/dci_audio");
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int read = open.read(bArr);
                        if (read <= -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                    open.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    file.delete();
                }
            }
            if (file.exists()) {
                NexAudioClip nexAudioClip = new NexAudioClip();
                nexAudioClip.mClipPath = file.getAbsolutePath();
                nexAudioClip.mClipID = 50331647;
                int i4 = this.i;
                nexAudioClip.mTotalTime = i4;
                nexAudioClip.mStartTime = 0;
                nexAudioClip.mEndTime = i4;
                if (this.f20072b) {
                    nexAudioClip.mClipVolume = 100;
                }
                nexAudioClip.mSpeedControl = 100;
                nexAudioClip.mAudioOnOff = 1;
                nexAudioClip.mAutoEnvelop = 0;
                nexAudioClip.mVolumeEnvelopeLevel = new int[]{100};
                nexAudioClip.mVolumeEnvelopeTime = new int[]{0};
                arrayList2.add(nexAudioClip);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f20072b) {
                sb.append("E[" + this.f20074d + FragmentC2201x.f23219a + this.f20075e + "@" + this.f20076f + "fps/" + this.f20077g + ">>" + this.i + "]");
            } else {
                sb.append('P');
            }
            int i5 = this.D * 1000;
            for (a aVar : this.l) {
                if (!new File(aVar.f20079a).exists()) {
                    b bVar = new b(this.f20078h);
                    b.a(bVar, this.r, this.f20075e);
                    b.b(bVar, this.q);
                    b.a(bVar, (int) ((System.nanoTime() - this.s) / 1000000));
                    b.a(bVar, NexEditor.b.Wa);
                    resultTask.sendResult(bVar);
                    return resultTask;
                }
                MediaInfo a2 = MediaInfo.a(aVar.f20079a);
                if (a2.V()) {
                    b bVar2 = new b(this.f20078h);
                    b.a(bVar2, this.r, this.f20075e);
                    b.b(bVar2, this.q);
                    b.a(bVar2, (int) ((System.nanoTime() - this.s) / 1000000));
                    b.a(bVar2, a2.s());
                    resultTask.sendResult(bVar2);
                    return resultTask;
                }
                Rect rect2 = new Rect(i2, i2, a2.R(), a2.v());
                a(rect2, a(a2.z()));
                NexVisualClip nexVisualClip2 = new NexVisualClip();
                i5 += i;
                aVar.f20081c = i5;
                nexVisualClip2.mClipID = i5;
                nexVisualClip2.mClipPath = aVar.f20079a;
                nexVisualClip2.mClipType = 7;
                nexVisualClip2.mStartTime = aVar.f20080b;
                nexVisualClip2.mWidth = a2.R();
                nexVisualClip2.mHeight = a2.v();
                nexVisualClip2.mTotalTime = a2.r();
                nexVisualClip2.mTotalAudioTime = a2.o();
                nexVisualClip2.mTotalVideoTime = a2.K();
                nexVisualClip2.mExistAudio = a2.S() ? 1 : 0;
                nexVisualClip2.mExistVideo = a2.U() ? 1 : 0;
                nexVisualClip2.mAudioOnOff = nexVisualClip2.mExistAudio;
                nexVisualClip2.mSpeedControl = 100;
                nexVisualClip2.mEndTime = Math.min(nexVisualClip2.mStartTime + nexVisualClip2.mTotalTime, this.i);
                int[] iArr = new int[i];
                iArr[0] = 100;
                nexVisualClip2.mVolumeEnvelopeLevel = iArr;
                int[] iArr2 = new int[i];
                iArr2[0] = 0;
                nexVisualClip2.mVolumeEnvelopeTime = iArr2;
                nexVisualClip2.mRotateState = a2.z();
                nexVisualClip2.mStartRect = a(rect2, nexVisualClip2.mWidth, nexVisualClip2.mHeight, nexVisualClip2.mRotateState);
                nexVisualClip2.mEndRect = a(rect2, nexVisualClip2.mWidth, nexVisualClip2.mHeight, nexVisualClip2.mRotateState);
                nexVisualClip2.mTotalTime = nexVisualClip2.mEndTime - nexVisualClip2.mStartTime;
                this.A = Math.max(this.A, aVar.f20080b);
                arrayList.add(nexVisualClip2);
                sb.append("[" + nexVisualClip2.mWidth + FragmentC2201x.f23219a + nexVisualClip2.mHeight + "@" + nexVisualClip2.mStartTime + ">>" + nexVisualClip2.mTotalTime + "]");
                this.q = this.q + a(a2.R(), a2.v());
                this.r = Math.max(this.r, a2.v());
                i = 1;
                i2 = 0;
            }
            String sb2 = sb.toString();
            if (interfaceC1716d2.c(sb2)) {
                b bVar3 = new b(this.f20078h);
                b.a(bVar3, this.r, this.f20075e);
                b.b(bVar3, this.q);
                b.a(bVar3, (int) ((System.nanoTime() - this.s) / 1000000));
                b.a(bVar3, NexEditor.b.yb);
                resultTask.sendResult(bVar3);
                return resultTask;
            }
            interfaceC1716d2.b(sb2);
            this.o = 0;
            synchronized (this.H) {
                if (this.v == null) {
                    this.w = activity;
                    this.v = new NexThemeView(activity);
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                    layoutParams.x = 10;
                    layoutParams.y = 10;
                    layoutParams.width = 640;
                    layoutParams.height = 360;
                    layoutParams.flags = 904;
                    layoutParams.windowAnimations = 0;
                    layoutParams.format = -3;
                    layoutParams.alpha = 0.01f;
                    this.v.addOnAttachStateChangeListener(new B(this));
                    activity.getWindowManager().addView(this.v, layoutParams);
                }
            }
            this.C.removeCallbacks(this.G);
            this.C.postDelayed(this.G, this.i * 10);
            d().clearTrackCache();
            d().a(this.L);
            d().a(this.M);
            d().a(this.J);
            d().a(this.v);
            d().b(16, 1, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            resultTask.onResultAvailable(new C(this));
            d().createProject();
            d().clearTrackCache();
            d().a(this.K);
            Task a3 = d().a((NexVisualClip[]) arrayList.toArray(new NexVisualClip[arrayList.size()]), (NexAudioClip[]) arrayList2.toArray(new NexAudioClip[arrayList2.size()]));
            NexThemeView nexThemeView = this.v;
            if (nexThemeView != null) {
                this.F = resultTask;
                nexThemeView.setNotify(new I(this, a3, resultTask));
            }
            resultTask.setCancellable(true);
            return resultTask;
        }
        throw new IllegalStateException();
    }

    private NexRectangle a(Rect rect, int i, int i2, int i3) {
        if (i3 != 90 && i3 != 270) {
            return new NexRectangle((rect.left * NexVideoClipItem.ABSTRACT_DIMENSION) / i, (rect.top * NexVideoClipItem.ABSTRACT_DIMENSION) / i2, (rect.right * NexVideoClipItem.ABSTRACT_DIMENSION) / i, (rect.bottom * NexVideoClipItem.ABSTRACT_DIMENSION) / i2);
        }
        return new NexRectangle((rect.top * NexVideoClipItem.ABSTRACT_DIMENSION) / i2, (rect.left * NexVideoClipItem.ABSTRACT_DIMENSION) / i, (rect.bottom * NexVideoClipItem.ABSTRACT_DIMENSION) / i2, (rect.right * NexVideoClipItem.ABSTRACT_DIMENSION) / i);
    }

    private static void a(Rect rect, float f2) {
        if (rect.width() / rect.height() < f2) {
            int height = (int) (rect.height() * f2);
            rect.left = rect.centerX() - (height / 2);
            rect.right = rect.left + height;
        } else {
            int width = (int) (rect.width() / f2);
            rect.top = rect.centerY() - (width / 2);
            rect.bottom = rect.top + width;
        }
    }

    public void a() {
        if (this.j || this.p) {
            this.E = null;
            this.p = true;
            d().a(new O(this));
        }
    }
}
