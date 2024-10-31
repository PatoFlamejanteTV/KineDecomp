package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.OverScroller;
import c.d.b.m.k;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.general.util.v;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediaprep.C1803a;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexeditorui.WhichTimeline;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class TimelineView extends View implements InterfaceC2025f, ScaleGestureDetector.OnScaleGestureListener, v.c, NexTimelineItem.w, NexTimeline.b {
    private int A;
    private int Aa;
    private boolean Ab;
    private boolean B;
    private boolean Ba;
    private f Bb;
    private boolean C;
    private boolean Ca;
    private Runnable Cb;
    private boolean D;
    private boolean Da;
    private Map<NexTimelineItem, Bitmap> Db;
    private boolean E;
    protected int Ea;
    private Map<Bitmap, Canvas> Eb;
    private boolean F;
    private int Fa;
    private g Fb;
    private a[] G;
    protected int Ga;
    private i[] Gb;
    private int H;
    private int Ha;
    private List<com.nextreaming.nexeditorui.ob> Hb;
    private int I;
    private int Ia;
    private int Ib;
    private int J;
    private DisplayMetrics Ja;
    private Bitmap Jb;
    private ImageView K;
    private float Ka;
    private Bitmap Kb;
    private ImageView L;
    private float La;
    private Canvas Lb;
    private WindowManager.LayoutParams M;
    private int Ma;
    private Canvas Mb;
    private WindowManager N;
    private int Na;
    private boolean Nb;
    private Bitmap O;
    private int Oa;
    private Point Ob;
    private NexTimelineItem P;
    private int Pa;
    private Runnable Pb;
    private NexTimelineItem Q;
    private NexTimelineItem Qa;
    private Runnable Qb;
    private int R;
    private boolean Ra;
    private int Rb;
    private int S;
    private long Sa;
    private Runnable Sb;
    WhichTimeline T;
    private float Ta;
    private int U;
    private ArrayList<c> Ua;
    private int V;
    private boolean Va;
    private int W;
    private com.nexstreaming.app.general.util.C Wa;
    private boolean Xa;
    private int Ya;
    private boolean Za;
    private boolean _a;

    /* renamed from: a, reason: collision with root package name */
    private OverScroller f22106a;
    private int aa;
    private int ab;

    /* renamed from: b, reason: collision with root package name */
    private C1916ib f22107b;
    private int ba;
    private NexTimelineItem bb;

    /* renamed from: c, reason: collision with root package name */
    private C1803a f22108c;
    private int ca;
    private NexTimelineItem cb;

    /* renamed from: d, reason: collision with root package name */
    private MediaPrepManager f22109d;
    private int da;
    private boolean db;

    /* renamed from: e, reason: collision with root package name */
    private Path f22110e;
    private int ea;
    private RectF eb;

    /* renamed from: f, reason: collision with root package name */
    private Path f22111f;
    private int fa;
    private Rect fb;

    /* renamed from: g, reason: collision with root package name */
    private h f22112g;
    private int ga;
    private int gb;

    /* renamed from: h, reason: collision with root package name */
    private float f22113h;
    private int ha;
    private int hb;
    private float i;
    private boolean ia;
    RectF ib;
    private TextPaint j;
    private boolean ja;
    private float jb;
    private RectF k;
    private d ka;
    private float kb;
    private com.nexstreaming.app.general.util.v l;
    private int la;
    private long lb;
    private ScaleGestureDetector m;
    private int ma;
    private boolean mb;
    private float n;
    private float na;
    private int nb;
    private int o;
    private float oa;
    private int ob;
    private int p;
    private int pa;
    private boolean pb;
    private int q;
    private NexTimelineItem qa;
    private boolean qb;
    private int r;
    private NexTimelineItem.i ra;
    private NexTimelineItem rb;
    private int s;
    private boolean sa;
    private float sb;
    private int t;
    private int ta;
    private AnimType tb;
    private int u;
    private int ua;
    private Animation ub;
    private int v;
    private int va;
    private boolean vb;
    private int w;
    private boolean wa;
    private int wb;
    private int x;
    private boolean xa;
    private boolean xb;
    private int y;
    private int ya;
    private boolean yb;
    private NexTimeline z;
    private int za;
    private PurchaseType zb;

    /* loaded from: classes2.dex */
    public enum AnimType {
        AddClip,
        DeleteClip
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum TrackType {
        Text,
        VideoLayer,
        OtherLayer,
        OtherAudio,
        Other,
        Music,
        BGM;

        /* JADX INFO: Access modifiers changed from: private */
        public static TrackType a(NexSecondaryTimelineItem nexSecondaryTimelineItem) {
            if (nexSecondaryTimelineItem == null) {
                return Other;
            }
            if (nexSecondaryTimelineItem instanceof NexAudioClipItem) {
                NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) nexSecondaryTimelineItem;
                if (!nexAudioClipItem.isBGM() && !nexAudioClipItem.isLegacyBGMusic()) {
                    if (nexAudioClipItem.isThemeMusic()) {
                        return Music;
                    }
                    if (nexAudioClipItem.getIsVoiceRecording()) {
                        return OtherAudio;
                    }
                    if (nexAudioClipItem.getOriginalDuration() > 30000) {
                        return Music;
                    }
                    return OtherAudio;
                }
                return BGM;
            }
            if (nexSecondaryTimelineItem instanceof TextLayer) {
                return Text;
            }
            if (nexSecondaryTimelineItem instanceof VideoLayer) {
                return VideoLayer;
            }
            if (nexSecondaryTimelineItem instanceof NexLayerItem) {
                return OtherLayer;
            }
            return Other;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f22114a;

        /* renamed from: b, reason: collision with root package name */
        int f22115b;

        /* renamed from: c, reason: collision with root package name */
        int f22116c;

        /* renamed from: d, reason: collision with root package name */
        int f22117d;

        /* renamed from: e, reason: collision with root package name */
        int f22118e;

        /* renamed from: f, reason: collision with root package name */
        int f22119f;

        /* renamed from: g, reason: collision with root package name */
        boolean f22120g;

        private a() {
        }

        /* synthetic */ a(TimelineView timelineView, RunnableC1984ph runnableC1984ph) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        e f22125a;

        /* renamed from: b, reason: collision with root package name */
        int f22126b;

        /* renamed from: c, reason: collision with root package name */
        int f22127c;

        private c() {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class d {
        public abstract void a();

        public abstract void a(int i);

        public abstract void a(WhichTimeline whichTimeline, int i, int i2, NexTimelineItem nexTimelineItem);

        public abstract void a(boolean z);

        public abstract boolean a(int i, int i2, NexPrimaryTimelineItem nexPrimaryTimelineItem);

        public abstract boolean a(int i, int i2, NexSecondaryTimelineItem nexSecondaryTimelineItem);

        public abstract boolean a(int i, boolean z);

        public abstract boolean a(com.nexstreaming.kinemaster.editorwrapper.Ea ea);

        public abstract boolean a(WhichTimeline whichTimeline, int i, NexTimelineItem nexTimelineItem);

        public abstract boolean a(WhichTimeline whichTimeline, int i, NexTimelineItem nexTimelineItem, boolean z);

        public abstract void b();

        public abstract void b(boolean z);

        public abstract void c(boolean z);

        public abstract boolean c();

        public abstract void d(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(Rect rect);
    }

    /* loaded from: classes2.dex */
    public interface f {
        void b(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        int f22134a;

        /* renamed from: b, reason: collision with root package name */
        TrackType f22135b;

        private i() {
            this.f22134a = 0;
            this.f22135b = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f22134a = 0;
            this.f22135b = null;
        }

        /* synthetic */ i(RunnableC1984ph runnableC1984ph) {
            this();
        }
    }

    public TimelineView(Context context) {
        super(context);
        this.f22108c = new C1803a();
        this.f22110e = new Path();
        this.f22111f = new Path();
        this.f22112g = new h(this);
        this.f22113h = 1.0f;
        this.i = 1.0f;
        this.j = new TextPaint();
        this.k = new RectF();
        this.l = null;
        this.m = null;
        this.n = 40.0f;
        this.o = 5;
        this.p = 100;
        this.q = 10;
        this.r = 5;
        this.s = 5;
        this.t = 5;
        this.u = 5;
        this.v = 40;
        this.z = new NexTimeline();
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = new a[16];
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = 0;
        this.S = 0;
        this.T = null;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.ca = 0;
        this.da = 0;
        this.ea = 0;
        this.fa = 0;
        this.ga = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.ha = 0;
        this.ia = false;
        this.ja = false;
        this.ka = null;
        this.la = 0;
        this.ma = 0;
        this.na = 0.0f;
        this.oa = 0.0f;
        this.pa = 0;
        this.qa = null;
        this.ra = null;
        this.sa = false;
        this.ta = 0;
        this.ua = 0;
        this.va = 0;
        this.wa = false;
        this.xa = false;
        this.ya = 0;
        this.za = 0;
        this.Aa = 0;
        this.Ba = false;
        this.Ca = false;
        this.Da = false;
        this.Ea = 0;
        this.Fa = 0;
        this.Ga = 0;
        this.Ha = 0;
        this.Ia = 0;
        this.Ka = 0.0f;
        this.La = 0.0f;
        this.Na = -1;
        this.Oa = 0;
        this.Pa = 0;
        this.Qa = null;
        this.Ra = false;
        this.Sa = 0L;
        this.Ta = 0.0f;
        this.Ua = new ArrayList<>();
        this.Va = false;
        this.Wa = new com.nexstreaming.app.general.util.C("NexTimelineView_OnDraw", false);
        this.Xa = false;
        this.Ya = -1;
        this.bb = null;
        this.cb = null;
        this.db = false;
        this.eb = new RectF();
        this.fb = new Rect();
        this.ib = new RectF();
        this.jb = 0.0f;
        this.kb = 0.0f;
        this.mb = false;
        this.nb = -1;
        this.pb = false;
        this.yb = false;
        this.Ab = false;
        this.Cb = new RunnableC1984ph(this);
        this.Db = new WeakHashMap();
        this.Eb = new WeakHashMap();
        this.Fb = new g();
        this.Gb = new i[0];
        this.Hb = new ArrayList();
        this.Nb = false;
        this.Ob = new Point();
        this.Pb = new wh(this);
        this.Qb = new xh(this);
        this.Rb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.Sb = null;
        y();
    }

    private int f(int i2) {
        return i2;
    }

    private int getMaxScrollX() {
        if (this.ja) {
            return this.Ea;
        }
        int i2 = this.Rb;
        a t = t();
        if (t != null) {
            if (getSelectedItem() instanceof NexTransitionItem) {
                int i3 = t.f22114a;
                return Math.min(i2, (i3 + ((t.f22115b - i3) / 2)) - (getWidth() / 2));
            }
            return Math.min(i2, t.f22115b - (getWidth() / 2));
        }
        return Math.min(i2, this.V - 1);
    }

    private int getMaxScrollY() {
        if (this.ia || this.F) {
            return this.Ga;
        }
        return Math.max(0, ((((this.nb + 1) * (this.u + this.v)) + this.p) + this.t) - (this.bb == null ? getHeight() - this.r : 0));
    }

    private int getMinScrollX() {
        if (this.ja) {
            return this.Ea;
        }
        a t = t();
        if (t == null) {
            return 0;
        }
        if (getSelectedTimeline() == WhichTimeline.PRIMARY && getSelectedIndex() == 0) {
            return 0;
        }
        if (getSelectedItem() instanceof NexTransitionItem) {
            int i2 = t.f22114a;
            return (i2 + ((t.f22115b - i2) / 2)) - (getWidth() / 2);
        }
        return t.f22114a - (getWidth() / 2);
    }

    private int getMinScrollY() {
        if (this.ia || this.F) {
            return this.Ga;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSelectedTimelineInt() {
        NexTimelineItem nexTimelineItem = this.bb;
        if (nexTimelineItem == null) {
            return 0;
        }
        if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
            return 1;
        }
        return nexTimelineItem instanceof NexSecondaryTimelineItem ? 2 : 0;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void b() {
    }

    @Override // com.nextreaming.nexeditorui.NexTimeline.b
    public void b(int i2) {
    }

    @Override // com.nextreaming.nexeditorui.NexTimeline.b
    public int getCTSBeforeTimeChange() {
        if (!this.f22106a.isFinished()) {
            return g(this.f22106a.getFinalX());
        }
        return this.la;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f, com.nextreaming.nexeditorui.NexTimelineItem.w
    public int getCurrentTime() {
        return this.la;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public int getCurrentTimeAndStopFling() {
        this.f22106a.forceFinished(true);
        return this.la;
    }

    public int getEditingMode() {
        return this.Oa;
    }

    public int getInsertIndexForPrimaryItemAtTime() {
        int primaryItemCount = this.z.getPrimaryItemCount();
        int i2 = 0;
        for (int i3 = 0; i3 < primaryItemCount; i3++) {
            int representedDuration = this.z.getPrimaryItem(i3).getRepresentedDuration();
            if (this.la < i2) {
                return i3;
            }
            i2 += representedDuration;
        }
        return primaryItemCount;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public int getMSPerPixel() {
        return Math.max(1, (int) ((1.0f / this.n) * 1000.0f));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public NexTimelineItem getOldSelectedItem() {
        return this.cb;
    }

    public float getPixelsPerSecond() {
        return this.n;
    }

    public boolean getPlaying() {
        return this.xb;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public int getSelectedIndex() {
        NexTimelineItem nexTimelineItem = this.bb;
        if (nexTimelineItem == null) {
            return -1;
        }
        if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
            return this.z.getIndexOfPrimaryItem((NexPrimaryTimelineItem) nexTimelineItem);
        }
        if (nexTimelineItem instanceof NexSecondaryTimelineItem) {
            return this.z.getIndexOfSecondaryItem((NexSecondaryTimelineItem) nexTimelineItem);
        }
        return -1;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public NexTimelineItem getSelectedItem() {
        return this.bb;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public WhichTimeline getSelectedTimeline() {
        if (getSelectedTimelineInt() == 0 || getSelectedIndex() == -1) {
            return null;
        }
        return getSelectedTimelineInt() == 1 ? WhichTimeline.PRIMARY : WhichTimeline.SECONDARY;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f, com.nextreaming.nexeditorui.NexTimelineItem.w
    public NexTimeline getTimeline() {
        if (this.z == null) {
            Log.w("NexTimelineView", "getTimeline returning NULL");
        }
        return this.z;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getClass().getName());
        removeCallbacks(this.Cb);
        post(this.Cb);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f22106a.abortAnimation();
        removeCallbacks(this.Cb);
        if (this.xa) {
            this.N.removeView(this.K);
            this.xa = false;
        }
        ImageView imageView = this.L;
        if (imageView != null) {
            this.N.removeView(imageView);
            this.L = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public boolean onDown(MotionEvent motionEvent) {
        if (!this.f22106a.isFinished() && this.C) {
            this.C = false;
        }
        this.f22106a.forceFinished(true);
        if (this.Na != -1) {
            this.Na = -1;
            c(true);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dd  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDraw(android.graphics.Canvas r7) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.TimelineView.onDraw(android.graphics.Canvas):void");
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.Sb = null;
        if (!this.F && !this.E && !this.D) {
            if (this.ia) {
                if (Math.abs(f2) < 500.0f) {
                    return false;
                }
            } else if (!this.ja || Math.abs(f3) < 500.0f) {
                return false;
            }
            if (Math.abs(f2) > Math.abs(f3) && Math.abs(f2) > 1500.0f) {
                this.La = f2 < 0.0f ? 0 : 1;
            }
            if (this.Na >= 0) {
                this.Na = -2;
            }
            this.f22106a.fling(this.Ea, this.Ga, (int) ((-f2) * 0.9f), (int) ((-f3) * 0.9f), getMinScrollX(), getMaxScrollX(), getMinScrollY(), getMaxScrollY());
            postInvalidateOnAnimation();
        }
        return false;
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public void onLongPress(MotionEvent motionEvent) {
        if (isEnabled()) {
            d dVar = this.ka;
            if (dVar != null) {
                dVar.c();
            }
            ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getSize(this.Ob);
            if (this.C) {
                a(motionEvent);
            }
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        this.Rb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        float scaleFactor = this.n * scaleGestureDetector.getScaleFactor();
        if (scaleFactor < 3.0f) {
            scaleFactor = 3.0f;
        }
        if (scaleFactor > 8000.0f) {
            scaleFactor = 8000.0f;
        }
        if (Math.abs(this.n - scaleFactor) < 0.1d) {
            return false;
        }
        this.n = scaleFactor;
        x();
        this.Ea = (int) (j(this.A) - scaleGestureDetector.getFocusX());
        invalidate();
        c(true);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.A = g(this.Ea + ((int) scaleGestureDetector.getFocusX()));
        this.C = false;
        this.D = true;
        this.E = true;
        d dVar = this.ka;
        if (dVar != null) {
            dVar.b();
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.D = false;
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.Sb = null;
        if (!this.D && !this.E) {
            if (!this.ia && (this.ja || this.F || Math.abs(f2) <= Math.abs(f3))) {
                if (this.ja || (!this.ia && !this.F && Math.abs(f3) > Math.abs(f2))) {
                    this.C = false;
                    int i2 = this.Ga;
                    if (!this.ja) {
                        this.ma = -1;
                        this.ja = true;
                        this.Ia = i2;
                    }
                    this.Ia = (int) (this.Ia + f3);
                    this.Ga = this.Ia;
                    this.Ga = Math.max(getMinScrollY(), Math.min(getMaxScrollY(), this.Ga));
                    if (i2 != this.Ga) {
                        invalidate();
                    }
                    return true;
                }
            } else {
                this.C = false;
                if (!this.ia) {
                    this.ma = -1;
                    this.ia = true;
                    this.Ha = this.Ea;
                }
                this.Ha = (int) (this.Ha + f2);
                this.Ea = this.Ha;
                this.Ea = Math.max(getMinScrollX(), Math.min(getMaxScrollX(), this.Ea));
                invalidate();
                c(false);
            }
        }
        return false;
    }

    @Override // com.nexstreaming.app.general.util.v.c
    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.B) {
            this.C = false;
            return false;
        }
        if (this.C) {
            if (this.bb != null) {
                a((a) null);
                return false;
            }
            a b2 = b(((int) motionEvent.getX()) + this.Ea, ((int) motionEvent.getY()) + this.Ga);
            if (b2 != null) {
                if (getSelectedIndex() == b2.f22119f && getSelectedTimelineInt() == b2.f22118e) {
                    a((a) null);
                } else {
                    int a2 = (int) a(20.0f);
                    int i2 = b2.f22115b - b2.f22114a;
                    if (i2 >= a2) {
                        a(b2);
                    } else if (i2 > 0) {
                        this.n = Math.min(1500.0f, (this.n * a2) / i2);
                        a(b2);
                    }
                }
            } else {
                a((a) null);
                if (motionEvent.getY() < this.f22113h * 25.0f) {
                    int g2 = g(((int) motionEvent.getX()) + this.Ea);
                    int[] bookmarks = this.z.getBookmarks();
                    int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    int i4 = 0;
                    for (int i5 : bookmarks) {
                        int abs = Math.abs(g2 - i5);
                        if (abs < i3) {
                            i4 = i5;
                            i3 = abs;
                        }
                    }
                    if (i3 < ((this.f22113h * 25.0f) * 1000.0f) / this.n) {
                        d(i4);
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            return a(motionEvent, false);
        }
        return false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setEditingMode(int i2) {
        if (this.Oa == i2) {
            return;
        }
        this.Oa = i2;
        invalidate();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setEditor(VideoEditor videoEditor) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setExpanded(boolean z) {
        this.Ab = z;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setExpandingAnimation(boolean z) {
        if (this.yb == z) {
            return;
        }
        this.yb = z;
        l();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setImageWorker(FragmentManager fragmentManager) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setListener(d dVar) {
        this.ka = dVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setMediaPrepManager(MediaPrepManager mediaPrepManager) {
        this.f22109d = mediaPrepManager;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setOnTimelineScrollListener(f fVar) {
        this.Bb = fVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setPlaying(boolean z) {
        if (this.xb == z) {
            return;
        }
        this.xb = z;
        l();
        if (z) {
            return;
        }
        invalidate();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setPurchaseType(PurchaseType purchaseType) {
        this.zb = purchaseType;
        invalidate();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setSelectedItem(NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem != null) {
            if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
                e(1, this.z.getIndexOfPrimaryItem((NexPrimaryTimelineItem) nexTimelineItem));
            } else if (nexTimelineItem instanceof NexSecondaryTimelineItem) {
                e(2, this.z.getIndexOfSecondaryItem((NexSecondaryTimelineItem) nexTimelineItem));
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setSuppressScrollEvents(boolean z) {
        this.vb = z;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setTimeline(NexTimeline nexTimeline) {
        NexTimeline nexTimeline2 = this.z;
        if (nexTimeline2 != nexTimeline) {
            if (nexTimeline2 != null) {
                nexTimeline2.unregisterTimeChangeCTSCallback(this);
            }
            this.z = nexTimeline;
            NexTimeline nexTimeline3 = this.z;
            if (nexTimeline3 != null) {
                nexTimeline3.registerTimeChangeCTSCallback(this);
            }
        }
        x();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private int f22122a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f22123b;

        public b() {
            this.f22122a = 0;
            this.f22123b = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a(int i) {
            this.f22122a = i;
            this.f22123b = true;
        }

        abstract void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z);

        public final boolean b() {
            return this.f22123b;
        }

        public final int a() {
            return this.f22122a;
        }

        public b(int i) {
            this.f22122a = 0;
            this.f22123b = false;
            this.f22122a = i;
        }
    }

    private void c(int i2, boolean z) {
        this.f22106a.forceFinished(true);
        if (z) {
            this.Ma = i2;
            OverScroller overScroller = this.f22106a;
            int i3 = this.Ea;
            overScroller.startScroll(i3, this.Ga, this.Ma - i3, 0);
            postInvalidateOnAnimation();
            return;
        }
        this.Ea = i2;
        this.la = g(i2 + (getWidth() / 2));
        invalidate();
    }

    private void h(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = this.za;
        int i7 = this.Aa;
        if (i7 > Math.max(this.ba, this.aa)) {
            i7 = Math.max(this.ba, this.aa);
        }
        int color = getResources().getColor(R.color.timeline_scale_marks);
        int color2 = getResources().getColor(R.color.timeline_scale_numbers);
        this.j.reset();
        float dimension = getResources().getDimension(R.dimen.timeline3_timescale_height);
        float f2 = this.f22113h;
        float f3 = dimension / (20.0f * f2);
        int i8 = (int) (((f2 * 10.0f) * 1000.0f) / this.n);
        int i9 = 5000;
        int i10 = 500;
        int i11 = 1000;
        int i12 = 0;
        if (i8 < 33) {
            i10 = 0;
            i9 = 0;
            i11 = 33;
            i2 = 0;
        } else {
            if (i8 < 50) {
                i9 = 1000;
                i11 = 50;
                i2 = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
            } else {
                if (i8 < 100) {
                    i10 = 0;
                    i9 = 1000;
                    i11 = 100;
                } else if (i8 < 250) {
                    i10 = 0;
                    i9 = SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE;
                    i11 = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
                } else if (i8 < 500) {
                    i10 = 0;
                    i9 = LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT;
                    i11 = 500;
                    i2 = SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE;
                } else {
                    if (i8 < 1000) {
                        i10 = 0;
                    } else if (i8 < 2500) {
                        i10 = 0;
                        i11 = SemanticAnnotations.SemanticType.ST_AVOCADO_ID_VALUE;
                    } else if (i8 < 5000) {
                        i10 = 0;
                        i9 = 0;
                        i11 = 5000;
                    } else {
                        i11 = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
                        if (i8 < 10000) {
                            i10 = 0;
                            i9 = 0;
                            i2 = 30000;
                        } else if (i8 < 20000) {
                            i10 = 0;
                            i9 = 0;
                            i11 = 20000;
                            i2 = 0;
                        } else {
                            i10 = 0;
                            i9 = 0;
                            i11 = 60000;
                            i2 = 0;
                            i12 = 120000;
                        }
                    }
                    i2 = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
                }
                i2 = 500;
            }
            i12 = 60000;
        }
        this.j.setStyle(Paint.Style.FILL);
        this.j.setAntiAlias(true);
        this.j.setStyle(Paint.Style.FILL);
        int i13 = i6 - (i6 % i11);
        int j = j(i13);
        while (i13 < i7) {
            int i14 = i13 + i11;
            int j2 = j(i14);
            if (i14 > i7 || j2 - j >= 60) {
                this.j.setColor(color);
                if (i13 > this.aa) {
                    this.j.setAlpha(70);
                }
                if (i12 > 0 && i13 % i12 == 0) {
                    this.j.setColor(color2);
                    if (i13 > this.aa) {
                        this.j.setAlpha(70);
                    }
                    this.j.setTextAlign(Paint.Align.CENTER);
                    this.j.setTextSize(11.0f * f3 * this.f22113h);
                    this.j.setTypeface(Typeface.DEFAULT_BOLD);
                    i3 = i7;
                    i4 = color;
                    Double.isNaN(f3);
                    Double.isNaN(this.f22113h);
                    canvas.drawText("" + (i13 / 60000) + ":00", j, (int) (r3 * 12.5d * r11), this.j);
                    this.j.setTypeface(Typeface.DEFAULT);
                    i5 = i14;
                } else {
                    i3 = i7;
                    i4 = color;
                    if (i9 > 0 && i13 % i9 == 0) {
                        this.j.setColor(color2);
                        if (i13 > this.aa) {
                            this.j.setAlpha(70);
                        }
                        this.j.setTextAlign(Paint.Align.CENTER);
                        this.j.setTextSize(11.0f * f3 * this.f22113h);
                        float f4 = j;
                        i5 = i14;
                        Double.isNaN(f3);
                        Double.isNaN(this.f22113h);
                        canvas.drawText("" + (i13 / 1000), f4, (int) (r7 * 12.5d * r10), this.j);
                    } else {
                        i5 = i14;
                        if (i10 > 0 && i13 % i10 == 0) {
                            this.j.setColor(color2);
                            if (i13 > this.aa) {
                                this.j.setAlpha(70);
                            }
                            this.j.setTextAlign(Paint.Align.CENTER);
                            this.j.setTextSize(8.0f * f3 * this.f22113h);
                            StringBuilder sb = new StringBuilder();
                            sb.append("");
                            double d2 = i13;
                            Double.isNaN(d2);
                            sb.append(d2 / 1000.0d);
                            canvas.drawText(sb.toString(), j, (int) (11.0f * f3 * this.f22113h), this.j);
                        } else if (i2 > 0 && i13 % i2 == 0) {
                            canvas.drawCircle(j, (int) (9.0f * f3 * r7), this.f22113h * 1.5f, this.j);
                        } else {
                            canvas.drawCircle(j, (int) (9.0f * f3 * r7), this.f22113h * 1.5f, this.j);
                        }
                    }
                }
                j = j(i13);
            } else {
                i3 = i7;
                i4 = color;
                i5 = i14;
            }
            i7 = i3;
            color = i4;
            i13 = i5;
        }
    }

    private void i(Canvas canvas) {
        this.j.reset();
        this.j.setColor(this.ob);
        this.j.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, 0.0f, getWidth(), (int) (this.f22113h * 18.0f * (getResources().getDimension(R.dimen.timeline3_timescale_height) / (this.f22113h * 20.0f))), this.j);
    }

    private void j(Canvas canvas) {
        Drawable drawable = getResources().getDrawable(R.drawable.timeline_total_time_bg);
        int width = getWidth();
        int i2 = this.Ea;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.timeline3_ctsBoxWidth);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.timeline3_ctsBoxHeight);
        int i3 = i2 + (width - dimensionPixelOffset);
        int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(R.dimen.timeline3_ctsBoxTopMargin);
        drawable.setBounds(i3, dimensionPixelOffset3, i3 + dimensionPixelOffset, dimensionPixelOffset2 + dimensionPixelOffset3);
        drawable.draw(canvas);
        this.j.setTextAlign(Paint.Align.CENTER);
        this.j.setTextSize(getResources().getDimensionPixelSize(R.dimen.timeline3_ctsTextSize));
        this.j.setTypeface(Typeface.DEFAULT);
        String b2 = c.d.b.m.o.b(getTimeline().getTotalTime());
        this.j.setColor(-1);
        float f2 = i3 + (dimensionPixelOffset / 2);
        Double.isNaN(this.f22113h);
        canvas.drawText(b2, f2, r4 - ((int) (r2 * 3.5d)), this.j);
    }

    private boolean o() {
        NexLayerItem nexLayerItem;
        NexTimelineItem nexTimelineItem = this.bb;
        if (nexTimelineItem instanceof NexAudioClipItem) {
            NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) nexTimelineItem;
            if (nexAudioClipItem != null) {
                float absStartTime = nexAudioClipItem.getAbsStartTime();
                float absEndTime = nexAudioClipItem.getAbsEndTime();
                float currentTime = getCurrentTime();
                return currentTime - absStartTime > 500.0f && absEndTime - currentTime > 500.0f && !nexAudioClipItem.isLoop() && currentTime < ((float) getTimeline().getTotalTime());
            }
        } else if ((nexTimelineItem instanceof NexLayerItem) && (nexLayerItem = (NexLayerItem) nexTimelineItem) != null) {
            float absStartTime2 = nexLayerItem.getAbsStartTime();
            float absEndTime2 = nexLayerItem.getAbsEndTime();
            float currentTime2 = getCurrentTime();
            return currentTime2 - absStartTime2 > 500.0f && absEndTime2 - currentTime2 > 500.0f && currentTime2 < ((float) getTimeline().getTotalTime());
        }
        return false;
    }

    private boolean p() {
        NexTimelineItem nexTimelineItem = this.bb;
        NexSecondaryTimelineItem nexSecondaryTimelineItem = nexTimelineItem instanceof NexSecondaryTimelineItem ? (NexSecondaryTimelineItem) nexTimelineItem : null;
        if (nexSecondaryTimelineItem == null) {
            return false;
        }
        float absStartTime = nexSecondaryTimelineItem.getAbsStartTime();
        float absEndTime = nexSecondaryTimelineItem.getAbsEndTime();
        float currentTime = getCurrentTime();
        return currentTime - absStartTime > 100.0f && absEndTime - currentTime > 500.0f;
    }

    private boolean q() {
        NexTimelineItem nexTimelineItem = this.bb;
        NexSecondaryTimelineItem nexSecondaryTimelineItem = nexTimelineItem instanceof NexSecondaryTimelineItem ? (NexSecondaryTimelineItem) nexTimelineItem : null;
        if (nexSecondaryTimelineItem == null) {
            return false;
        }
        float absStartTime = nexSecondaryTimelineItem.getAbsStartTime();
        float absEndTime = nexSecondaryTimelineItem.getAbsEndTime();
        float currentTime = getCurrentTime();
        return currentTime - absStartTime > 500.0f && absEndTime - currentTime > 100.0f;
    }

    private void r() {
        this.H = 0;
    }

    private void s() {
        this.nb = 0;
        for (i iVar : this.Gb) {
            iVar.a();
        }
    }

    private a t() {
        if (this.bb == null) {
            return null;
        }
        return c(getSelectedTimelineInt(), getSelectedIndex());
    }

    private void u() {
        if (this.Ua.isEmpty() || this.H <= 0) {
            return;
        }
        Iterator<c> it = this.Ua.iterator();
        while (it.hasNext()) {
            c next = it.next();
            a c2 = c(next.f22126b, next.f22127c);
            if (c2 != null) {
                next.f22125a.a(new Rect((c2.f22114a + getLeft()) - this.Ea, c2.f22116c + getTop(), (c2.f22115b + getLeft()) - this.Ea, c2.f22117d + getTop()));
            }
        }
        this.Ua.clear();
    }

    private void v() {
        Runnable runnable = this.Sb;
        if (runnable != null) {
            runnable.run();
        }
        boolean z = true;
        boolean z2 = this.Ra && w();
        boolean z3 = this.Nb;
        this.Nb = this.f22106a.computeScrollOffset();
        if (this.Nb) {
            this.Ea = this.f22106a.getCurrX();
            this.Ga = this.f22106a.getCurrY();
            post(this.Qb);
        } else {
            if (this.Va && this.Na <= 0) {
                if (this.F && this.jb != 0.0f) {
                    long nanoTime = System.nanoTime();
                    int min = (int) ((this.jb * ((float) Math.min(this.lb - nanoTime, 100000000L))) / 3.0E7f);
                    if (min != 0) {
                        this.Ea = Math.max(getMinScrollX(), Math.min(getMaxScrollX(), this.Ea + min));
                        this.lb = nanoTime;
                    }
                } else if (this.f22106a.isFinished() && this.Ga > getMaxScrollY()) {
                    this.f22106a.startScroll(this.Ea, this.Ga, 0, getMaxScrollY() - this.Ga);
                }
            } else {
                post(this.Qb);
            }
            z = z2;
        }
        if (z) {
            postInvalidateOnAnimation();
        } else if (z3) {
            post(this.Pb);
            postInvalidateOnAnimation();
        }
        this.Fa = this.Ea;
    }

    private boolean w() {
        long nanoTime = (System.nanoTime() / 1000000) - this.Sa;
        if (nanoTime < 0) {
            return true;
        }
        if (nanoTime > 750) {
            this.Ra = false;
            this.Ta = 0.0f;
            return false;
        }
        this.Ta = ((float) (nanoTime % 375)) / 375.0f;
        double d2 = this.Ta;
        Double.isNaN(d2);
        this.Ta = (float) ((Math.cos(((d2 + 0.5d) * 2.0d) * 3.141592653589793d) / 2.0d) + 0.5d);
        return true;
    }

    private void x() {
        this.aa = this.z.getTotalTime();
        this.ba = this.z.getTotalSecondaryTime();
        int b2 = b(Math.max(this.aa, this.ba), false);
        int i2 = this.aa;
        int b3 = i2 < this.ba ? b(i2, false) : b2;
        if (this.V == b2) {
            int i3 = this.W;
        }
        this.V = b2;
        this.W = b3;
    }

    private void y() {
        this.f22107b = new C1916ib(getContext());
        this.f22106a = new OverScroller(getContext());
        this.ob = getResources().getColor(R.color.timeline_bg_color);
        setLayerType(2, null);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        int i2 = 0;
        this.Za = defaultSharedPreferences.getBoolean("show_cts_centisecond", false);
        this._a = defaultSharedPreferences.getBoolean("show_timeline_content_weight", false);
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        this.ab = deviceProfile.getMaxCodecMemSizeForVideoLayers();
        if (EditorGlobal.i() != null) {
            NexExportProfile[] supportedExportProfiles = deviceProfile.getSupportedExportProfiles(EditorGlobal.i().b());
            int length = supportedExportProfiles.length;
            int i3 = 0;
            while (i2 < length) {
                NexExportProfile nexExportProfile = supportedExportProfiles[i2];
                int height = nexExportProfile.height() * nexExportProfile.width();
                if (height > i3) {
                    i3 = height;
                }
                i2++;
            }
            i2 = i3;
        }
        this.ab -= i2;
        this.Ja = getResources().getDisplayMetrics();
        this.f22113h = this.Ja.density;
        this.i = this.f22113h * 0.65f;
        this.m = new ScaleGestureDetector(getContext(), this);
        this.l = new com.nexstreaming.app.general.util.v(getContext(), this);
        this.l.a(getResources().getDimensionPixelSize(R.dimen.timeline3_touchSlop));
        this.N = (WindowManager) getContext().getSystemService("window");
        Resources resources = getResources();
        this.n = resources.getDimensionPixelSize(R.dimen.timeline3_pixelsPerSecond);
        this.o = resources.getDimensionPixelOffset(R.dimen.timeline3_itemSpacing);
        this.p = resources.getDimensionPixelSize(R.dimen.timeline3_primaryTimelineHeight);
        this.q = resources.getDimensionPixelSize(R.dimen.timeline3_primaryTimelineMinHeight);
        this.r = resources.getDimensionPixelOffset(R.dimen.timeline3_topMargin);
        this.s = resources.getDimensionPixelOffset(R.dimen.timeline3_bottomMargin);
        this.t = resources.getDimensionPixelOffset(R.dimen.timeline3_timelineSpacing);
        this.u = resources.getDimensionPixelOffset(R.dimen.timeline3_audioTrackSpacing);
        this.v = resources.getDimensionPixelSize(R.dimen.timeline3_audioTrackHeight);
        this.w = resources.getDimensionPixelSize(R.dimen.timeline3_autoScrollMarginLeft);
        this.x = resources.getDimensionPixelSize(R.dimen.timeline3_autoScrollMarginRight);
        this.y = resources.getInteger(R.integer.timeline3_collapsedVisibleSecondaryCount);
    }

    public void d(int i2) {
        this.Sb = null;
        this.Ma = j(i2) - (getWidth() / 2);
        this.Na = i2;
        OverScroller overScroller = this.f22106a;
        int i3 = this.Ea;
        overScroller.startScroll(i3, this.Ga, this.Ma - i3, 0);
        postInvalidateOnAnimation();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void e() {
        int primaryItemCount = this.z.getPrimaryItemCount();
        if (primaryItemCount < 1) {
            a(-1, true);
        } else if (getTimeline().getTotalTime() < getCurrentTime()) {
            a((NexTimelineItem) this.z.getPrimaryItem(primaryItemCount - 1), true, false);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void f() {
        this.Db.clear();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public int g() {
        this.la = g(this.Ea + (getWidth() / 2));
        return this.la;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public boolean k() {
        return this.ya >= getTimeline().getTotalTime() + (-200);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void l() {
        this.Jb = null;
        this.Kb = null;
        this.Lb = null;
        this.Mb = null;
        this.Ib = -1;
    }

    public int m() {
        return Math.max(0, (int) (1000.0f / this.n));
    }

    public void n() {
        boolean z = this.Ba;
        boolean z2 = this.Fb.i;
        if (z != z2) {
            this.Ba = z2;
            d dVar = this.ka;
            if (dVar != null) {
                dVar.d(this.Ba);
            }
        }
        boolean z3 = this.Ca;
        boolean z4 = this.Fb.f22131g;
        if (z3 != z4) {
            this.Ca = z4;
            d dVar2 = this.ka;
            if (dVar2 != null) {
                dVar2.a(this.Ca);
            }
        }
        boolean z5 = this.Da;
        boolean z6 = this.Fb.f22132h;
        if (z5 != z6) {
            this.Da = z6;
            d dVar3 = this.ka;
            if (dVar3 != null) {
                dVar3.b(this.Da);
            }
        }
        d dVar4 = this.ka;
        if (dVar4 != null) {
            dVar4.a(this.Fb.j);
        }
        if (this.bb instanceof NexSecondaryTimelineItem) {
            boolean o = o();
            if (o != this.Ba) {
                this.Ba = o;
                d dVar5 = this.ka;
                if (dVar5 != null) {
                    dVar5.d(this.Ba);
                }
            }
            boolean p = p();
            if (p != this.Ca) {
                this.Ca = p;
                d dVar6 = this.ka;
                if (dVar6 != null) {
                    dVar6.a(this.Ca);
                }
            }
            boolean q = q();
            if (q != this.Da) {
                this.Da = q;
                d dVar7 = this.ka;
                if (dVar7 != null) {
                    dVar7.b(this.Da);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class h implements NexTimelineItem.r {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<TimelineView> f22133a;

        h(TimelineView timelineView) {
            this.f22133a = new WeakReference<>(timelineView);
        }

        @Override // com.nextreaming.nexeditorui.NexTimelineItem.r
        public void a(NexTimelineItem nexTimelineItem) {
            TimelineView timelineView = this.f22133a.get();
            if (timelineView != null) {
                timelineView.Db.remove(nexTimelineItem);
                timelineView.invalidate();
            }
        }

        @Override // com.nextreaming.nexeditorui.NexTimelineItem.r
        public void a(NexTimelineItem nexTimelineItem, NexTimelineItem nexTimelineItem2, NexTimelineItem nexTimelineItem3) {
            TimelineView timelineView = this.f22133a.get();
            if (timelineView != null) {
                timelineView.Db.remove(nexTimelineItem);
                timelineView.Db.remove(nexTimelineItem2);
                timelineView.Db.remove(nexTimelineItem3);
                timelineView.invalidate();
            }
        }
    }

    private a b(int i2, int i3) {
        int i4 = this.Ga;
        int i5 = i3 - i4;
        int i6 = this.r;
        a aVar = null;
        if (i5 < (i6 * 3) / 4) {
            return null;
        }
        if (i3 - i4 < (i6 * 6) / 5) {
            i3 = ((i6 * 6) / 5) + i4;
        }
        int a2 = (int) a(6.0f);
        for (int i7 = 0; i7 < a2 * 2; i7 += a2) {
            for (int i8 = this.H - 1; i8 >= 0; i8--) {
                a aVar2 = this.G[i8];
                if (aVar2.f22120g && this.Oa != 0) {
                    int i9 = aVar2.f22117d - aVar2.f22116c;
                    if (i9 < 0) {
                        i9 = 0;
                    }
                    int i10 = i9 / 2;
                    if (i2 >= aVar2.f22114a - i10 && i2 <= aVar2.f22115b + i10 && i3 >= aVar2.f22116c && i3 <= aVar2.f22117d) {
                        return aVar2;
                    }
                } else if (i2 >= aVar2.f22114a - i7 && i2 <= aVar2.f22115b + i7 && i3 >= aVar2.f22116c && i3 <= aVar2.f22117d) {
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }

    private void f(Canvas canvas) {
        if (this.wa) {
            this.k.left = j(this.ua);
            this.k.right = j(this.va);
            RectF rectF = this.k;
            rectF.top = this.f22113h * 15.0f;
            rectF.bottom = getHeight();
            this.j.reset();
            this.j.setColor(getResources().getColor(R.color.timeline_recording_color));
            canvas.drawRect(this.k, this.j);
            this.k.left = j(this.ta);
            this.k.right = j(this.ua);
            this.j.setColor(getResources().getColor(R.color.timeline_recording_color));
            canvas.drawRect(this.k, this.j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 804
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.TimelineView.g(android.graphics.Canvas):void");
    }

    private void e(Canvas canvas) {
        this.j.reset();
        this.j.setColor(this.ob);
        this.j.setStyle(Paint.Style.FILL);
        canvas.drawRect(this.Ea, this.r, getWidth() + this.Ea, this.r + Math.max(this.p - this.Ga, this.q), this.j);
        this.Fb.d();
        g gVar = this.Fb;
        gVar.f22129e = this.Ea;
        gVar.f22128d = this.Fa;
        gVar.f22130f = gVar.f22129e + getWidth();
        g gVar2 = this.Fb;
        gVar2.k = canvas;
        a(gVar2);
        this.Fb.c();
        this.Fb.k = null;
    }

    private void d(Canvas canvas) {
        if (this._a) {
            int i2 = this.za;
            int i3 = this.Aa;
            int i4 = (i3 - i2) / 200;
            if (i4 < 33) {
                i4 = 33;
            }
            int i5 = this.ab;
            this.j.reset();
            for (int i6 = i2 - (i2 % i4); i6 <= i3 + i4; i6 += i4) {
                int i7 = i4 / 2;
                int j = j(i6 - i7);
                int i8 = i7 + i6;
                int j2 = j(i8 + 1);
                int decoderMemoryUsageAtTime = this.z.getDecoderMemoryUsageAtTime(i8);
                if (decoderMemoryUsageAtTime <= i5) {
                    int i9 = ((decoderMemoryUsageAtTime * 230) / i5) + 25;
                    this.j.setColor(Color.rgb(i9, i9, 25));
                } else {
                    int i10 = (((decoderMemoryUsageAtTime - i5) * 230) / (i5 * 4)) + 25;
                    if (i10 > 255) {
                        i10 = 255;
                    }
                    this.j.setColor(Color.rgb(255, i10, 255 - Math.min(i10 * 4, 255)));
                }
                canvas.drawRect(j, 0.0f, j2, (int) (this.f22113h * 200.0f), this.j);
            }
        }
    }

    private int i(int i2) {
        if (i2 < 0 || i2 + 1 > this.nb) {
            return 0;
        }
        return this.Gb[i2].f22134a;
    }

    private void a(int i2, int i3, boolean z) {
        this.f22106a.forceFinished(true);
        if (z) {
            this.Ma = i2;
            OverScroller overScroller = this.f22106a;
            int i4 = this.Ea;
            int i5 = this.Ga;
            overScroller.startScroll(i4, i5, this.Ma - i4, i3 - i5);
            postInvalidateOnAnimation();
            return;
        }
        this.Ea = i2;
        this.Ga = i3;
        this.la = g(i2 + (getWidth() / 2));
        invalidate();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public int c() {
        return c(this.la);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void i() {
        this.wa = false;
        invalidate();
    }

    public int c(int i2) {
        int primaryItemCount = this.z.getPrimaryItemCount();
        int i3 = 0;
        for (int i4 = 0; i4 < primaryItemCount; i4++) {
            int representedDuration = this.z.getPrimaryItem(i4).getRepresentedDuration();
            if (i2 < (representedDuration / 2) + i3) {
                return i4;
            }
            i3 += representedDuration;
        }
        return primaryItemCount;
    }

    private void b(Canvas canvas) {
        int[] bookmarks = this.z.getBookmarks();
        int max = Math.max(1, getMSPerPixel() * 15);
        this.pb = false;
        Drawable drawable = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 : bookmarks) {
            if (i6 >= this.za && i6 < this.Aa) {
                if (Math.abs(i6 - this.ya) < max) {
                    this.pb = true;
                }
                int j = j(i6);
                if (drawable == null) {
                    drawable = getResources().getDrawable(R.drawable.timeline_bookmark);
                    i2 = (-drawable.getIntrinsicWidth()) / 2;
                    i3 = drawable.getIntrinsicWidth() + i2;
                    i4 = getResources().getDimensionPixelOffset(R.dimen.timeline3_bookmarkTopMargin);
                    i5 = drawable.getIntrinsicHeight() + i4;
                }
                drawable.setBounds(j + i2, i4, j + i3, i5);
                drawable.draw(canvas);
            }
        }
    }

    private a c(int i2, int i3) {
        for (int i4 = 0; i4 < this.H; i4++) {
            a aVar = this.G[i4];
            if (aVar.f22118e == i2 && aVar.f22119f == i3) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0128 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(android.graphics.Canvas r15) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.TimelineView.c(android.graphics.Canvas):void");
    }

    private int j(int i2) {
        return b(i2, true);
    }

    public Rect a(WhichTimeline whichTimeline, int i2) {
        a c2;
        if (whichTimeline == null || (c2 = c(whichTimeline.getInt(), i2)) == null) {
            return null;
        }
        return new Rect((c2.f22114a + getLeft()) - this.Ea, c2.f22116c + getTop(), (c2.f22115b + getLeft()) - this.Ea, c2.f22117d + getTop());
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public boolean j() {
        return this.Da;
    }

    private void e(int i2) {
        i[] iVarArr = this.Gb;
        int length = iVarArr.length;
        if (i2 > length) {
            this.Gb = (i[]) Arrays.copyOf(iVarArr, i2);
            while (length < i2) {
                this.Gb[length] = new i(null);
                length++;
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public Rect a(NexTimelineItem nexTimelineItem) {
        int indexOfSecondaryItem;
        if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
            int indexOfPrimaryItem = this.z.getIndexOfPrimaryItem((NexPrimaryTimelineItem) nexTimelineItem);
            if (indexOfPrimaryItem >= 0) {
                return a(WhichTimeline.PRIMARY, indexOfPrimaryItem);
            }
            return null;
        }
        if (!(nexTimelineItem instanceof NexSecondaryTimelineItem) || (indexOfSecondaryItem = this.z.getIndexOfSecondaryItem((NexSecondaryTimelineItem) nexTimelineItem)) < 0) {
            return null;
        }
        return a(WhichTimeline.SECONDARY, indexOfSecondaryItem);
    }

    private void d(int i2, int i3) {
        int i4 = i2 + 1;
        if (i4 > this.Gb.length) {
            e(i4);
        }
        this.Gb[i2].f22134a = i3;
        if (i4 > this.nb) {
            this.nb = i4;
        }
    }

    private void e(int i2, int i3) {
        NexTimelineItem nexTimelineItem;
        WhichTimeline whichTimeline;
        Runnable runnable = this.Sb;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.Sb = null;
        }
        if (i2 == 0 || i3 == -1) {
            i2 = 0;
            i3 = -1;
        }
        if (i2 == 1) {
            nexTimelineItem = (i3 <= -1 || i3 >= this.z.getPrimaryItemCount()) ? null : this.z.getPrimaryItem(i3);
            whichTimeline = WhichTimeline.PRIMARY;
        } else if (i2 == 2) {
            nexTimelineItem = (i3 <= -1 || i3 >= this.z.getSecondaryItemCount()) ? null : this.z.getSecondaryItem(i3);
            whichTimeline = WhichTimeline.SECONDARY;
        } else {
            nexTimelineItem = null;
            whichTimeline = null;
        }
        if (i2 == getSelectedTimelineInt() && i3 == getSelectedIndex() && nexTimelineItem == this.bb) {
            return;
        }
        this.cb = this.bb;
        this.bb = nexTimelineItem;
        if (this.bb == null) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
        d dVar = this.ka;
        if (dVar != null) {
            dVar.a(whichTimeline, getSelectedIndex(), this.bb);
        }
        invalidate();
        a(true);
    }

    private float a(float f2) {
        return TypedValue.applyDimension(1, f2, this.Ja);
    }

    public void a(int i2, int i3) {
        b(true);
    }

    private boolean a(MotionEvent motionEvent, boolean z) {
        d dVar;
        a b2;
        if (motionEvent.getActionMasked() == 0 && this.bb != null && (b2 = b(((int) motionEvent.getX()) + this.Ea, ((int) motionEvent.getY()) + this.Ga)) != null && b2.f22118e == getSelectedTimelineInt() && b2.f22119f == getSelectedIndex()) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            boolean z2 = getSelectedTimelineInt() == b2.f22118e && getSelectedIndex() == b2.f22119f;
            NexTimelineItem nexTimelineItem = this.bb;
            Context context = getContext();
            int i4 = b2.f22114a + i2;
            int i5 = this.Ea;
            int i6 = b2.f22116c + i3;
            int i7 = this.Ga;
            NexTimelineItem.k onDown = nexTimelineItem.onDown(context, this, new RectF(i4 - i5, i6 - i7, (b2.f22115b + i2) - i5, (b2.f22117d + i3) - i7), (int) (i2 + motionEvent.getX()), (int) (i3 + motionEvent.getY()), z2, this.Oa);
            if (onDown instanceof NexTimelineItem.i) {
                this.na = motionEvent.getRawX();
                this.oa = motionEvent.getRawY();
                NexTimelineItem nexTimelineItem2 = this.bb;
                this.qa = nexTimelineItem2;
                this.ra = (NexTimelineItem.i) onDown;
                this.R = b2.f22119f;
                if (nexTimelineItem2 instanceof NexPrimaryTimelineItem) {
                    this.T = WhichTimeline.PRIMARY;
                } else {
                    this.T = WhichTimeline.SECONDARY;
                }
                this.F = true;
                this.Rb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                this.C = false;
                invalidate();
                return true;
            }
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            int i8 = this.Ea;
            int i9 = this.W;
            if (i8 >= i9 - 2) {
                i9 = this.V;
            }
            this.Rb = i9;
            if (!this.F) {
                this.C = true;
            }
        }
        this.m.onTouchEvent(motionEvent);
        this.l.a(motionEvent);
        if (action == 0) {
            this.B = false;
            if (!z && (dVar = this.ka) != null) {
                this.B = dVar.c();
            }
        } else if (action == 1) {
            if (this.ia || this.ja) {
                c(true);
            }
            this.C = false;
            this.ja = false;
            this.ia = false;
            b(false);
            this.E = false;
        } else if (action == 2) {
            if (this.Na >= 0) {
                this.Na = -1;
            }
            if (!z) {
                b(motionEvent);
            }
        } else if (action == 3) {
            this.C = false;
            b(true);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:            if (r0 > (r6 - 13)) goto L19;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(int r6, boolean r7) {
        /*
            r5 = this;
            int r0 = r5.getWidth()
            int r0 = r0 / 2
            int r0 = r0 + r6
            int r0 = r5.g(r0)
            r1 = 0
            if (r0 >= 0) goto Lf
            r0 = 0
        Lf:
            int r2 = r5.Na
            if (r2 < 0) goto L37
            r2 = 10
            r3 = 1148846080(0x447a0000, float:1000.0)
            float r4 = r5.n
            float r3 = r3 / r4
            int r3 = (int) r3
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r5.Ma
            if (r6 == r3) goto L2c
            int r6 = r5.Na
            int r3 = r0 - r2
            if (r6 <= r3) goto L37
            int r2 = r2 + r0
            if (r6 >= r2) goto L37
        L2c:
            int r6 = r5.Na
            int r2 = r6 + (-7)
            if (r0 >= r2) goto L37
            int r2 = r6 + (-13)
            if (r0 <= r2) goto L37
            goto L38
        L37:
            r6 = r0
        L38:
            com.nexstreaming.kinemaster.ui.projectedit.TimelineView$f r0 = r5.Bb
            if (r0 == 0) goto L43
            int r2 = r5.la
            int r3 = r5.aa
            r0.b(r2, r3)
        L43:
            int r0 = r5.Na
            if (r0 < 0) goto L49
            r6 = r0
            goto L62
        L49:
            com.nextreaming.nexeditorui.NexTimelineItem r0 = r5.bb
            if (r0 == 0) goto L62
            int r0 = r0.getAbsEndTime()
            int r0 = r0 + (-1)
            com.nextreaming.nexeditorui.NexTimelineItem r2 = r5.bb
            int r2 = r2.getAbsStartTime()
            if (r6 >= r2) goto L5c
            r6 = r2
        L5c:
            if (r6 <= r0) goto L5f
            r6 = r0
        L5f:
            r5.n()
        L62:
            r5.la = r6
            int r0 = r5.ma
            if (r0 != r6) goto L6e
            if (r7 == 0) goto L8c
            boolean r0 = r5.Va
            if (r0 != 0) goto L8c
        L6e:
            r5.ma = r6
            r5.Va = r7
            com.nexstreaming.kinemaster.ui.projectedit.TimelineView$d r6 = r5.ka
            if (r6 == 0) goto L8c
            com.nextreaming.nexeditorui.NexTimelineItem r7 = r5.qa
            if (r7 != 0) goto L8c
            boolean r7 = r5.vb
            if (r7 == 0) goto L85
            boolean r6 = r5.Va
            if (r6 == 0) goto L8c
            r5.vb = r1
            goto L8c
        L85:
            int r7 = r5.ma
            boolean r0 = r5.Va
            r6.a(r7, r0)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d(int, boolean):void");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void b(NexTimelineItem nexTimelineItem) {
        this.Db.remove(nexTimelineItem);
        invalidate();
    }

    private void b(int i2, TrackType trackType) {
        int i3 = i2 + 1;
        if (i3 > this.Gb.length) {
            e(i3);
        }
        this.Gb[i2].f22135b = trackType;
        if (i3 > this.nb) {
            this.nb = i3;
        }
    }

    private int b(int i2, boolean z) {
        return a(z, new C2019th(this, i2));
    }

    private void b(boolean z) {
        if (this.F) {
            NexTimelineItem nexTimelineItem = this.qa;
            if (nexTimelineItem != null) {
                nexTimelineItem.onCustomDragDone_v3(this.ra, this);
                d dVar = this.ka;
                if (dVar != null) {
                    dVar.a(this.T, this.Oa, this.R, this.qa);
                    this.ka.a(this.T, this.R, this.qa, true);
                }
                this.F = false;
                this.qa = null;
                this.ra = null;
                this.sa = false;
                invalidate();
                return;
            }
            ImageView imageView = this.L;
            if (imageView != null) {
                this.N.removeView(imageView);
                this.L = null;
            }
            this.F = false;
            if ((this.T == WhichTimeline.PRIMARY && this.S < this.R) || this.S > this.R + 2) {
                d dVar2 = this.ka;
                if (dVar2 != null) {
                    dVar2.a(this.R, this.S, (NexPrimaryTimelineItem) this.P);
                }
            } else if (this.T == WhichTimeline.SECONDARY && this.pa != this.P.getAbsStartTime()) {
                d dVar3 = this.ka;
                if (dVar3 != null) {
                    dVar3.a(this.R, this.pa, (NexSecondaryTimelineItem) this.P);
                }
                this.P = null;
            } else {
                invalidate();
            }
            if (this.mb) {
                this.mb = false;
                d(this.Ea, true);
            }
        }
    }

    private TrackType h(int i2) {
        if (i2 < 0 || i2 + 1 > this.nb) {
            return null;
        }
        return this.Gb[i2].f22135b;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void d() {
        a((a) null);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public boolean h() {
        return this.Ba;
    }

    private void b(MotionEvent motionEvent) {
        int primaryItemCount;
        d dVar;
        this.jb = 0.0f;
        if (!this.mb) {
            this.kb = 0.0f;
        }
        if (this.F) {
            float rawX = motionEvent.getRawX() - this.na;
            float rawY = motionEvent.getRawY() - this.oa;
            NexTimelineItem nexTimelineItem = this.qa;
            if (nexTimelineItem != null) {
                this.sa = true;
                if (nexTimelineItem.onCustomDrag_v3(this.ra, this, rawX, rawY, this.n) && (dVar = this.ka) != null) {
                    dVar.a(this.T, this.R, this.qa, false);
                }
                this.z.requestCalcTimes();
                x();
                invalidate();
                return;
            }
            boolean z = this.T == WhichTimeline.SECONDARY;
            if (this.qb != z) {
                this.qb = z;
                this.L.setVisibility(z ? 8 : 0);
                invalidate();
            }
            if (motionEvent.getX() < this.w) {
                if (!this.mb) {
                    this.lb = System.nanoTime();
                }
                this.mb = true;
                this.jb = (-(motionEvent.getX() - this.w)) / 6.0f;
                postInvalidateOnAnimation();
            } else if (motionEvent.getX() > getWidth() - this.x) {
                if (!this.mb) {
                    this.lb = System.nanoTime();
                }
                this.mb = true;
                this.jb = (-(motionEvent.getX() - (getWidth() - this.x))) / 6.0f;
                postInvalidateOnAnimation();
            }
            this.M.x = ((int) motionEvent.getRawX()) - this.I;
            this.M.y = (((int) motionEvent.getRawY()) - this.J) - this.Ga;
            this.N.updateViewLayout(this.L, this.M);
            int x = (int) motionEvent.getX();
            WhichTimeline whichTimeline = this.T;
            if (whichTimeline == WhichTimeline.SECONDARY) {
                int g2 = g(((int) (motionEvent.getX() + this.Ea)) - this.I);
                int totalTime = this.z.getTotalTime() - 1;
                if (g2 > totalTime) {
                    g2 = totalTime;
                }
                if (this.pa != g2) {
                    this.pa = g2;
                    invalidate();
                    return;
                }
                return;
            }
            if (whichTimeline == WhichTimeline.PRIMARY) {
                int a2 = a(new C2060vh(this, this.z.getPrimaryItemCount() + 1, x)) - 1;
                if (this.Xa && a2 > this.z.getPrimaryItemCount() - 1) {
                    a2 = primaryItemCount;
                }
                if (a2 >= 0 && a2 % 2 != 0) {
                    a2++;
                }
                if (a2 < 0) {
                    a2 = 0;
                }
                if (a2 != this.S) {
                    this.S = a2;
                    invalidate();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        d(this.Ea, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(NexTimelineItem nexTimelineItem, boolean z) {
        if (nexTimelineItem != null) {
            int[] iArr = new int[2];
            if (a(nexTimelineItem, iArr)) {
                iArr[0] = iArr[0] - (getWidth() / 2);
                iArr[1] = iArr[1] - (getWidth() / 2);
                int i2 = iArr[1] - 1;
                if (!this.f22106a.isFinished() && z) {
                    if (Math.abs(this.f22106a.getFinalX() - i2) > 5) {
                        c(i2, true);
                    }
                } else if (i2 != this.Ea) {
                    c(i2, z);
                }
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f, com.nextreaming.nexeditorui.NexTimelineItem.w
    public void a(int i2, boolean z) {
        this.Sb = null;
        if (z) {
            d(i2);
        } else {
            a(i2);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f, com.nextreaming.nexeditorui.NexTimelineItem.w
    public void a(int i2) {
        this.Sb = null;
        if (i2 < 0) {
            i2 = 0;
        }
        if ((this.F && this.qa == null) || this.C) {
            return;
        }
        this.Ea = j(i2) - (getWidth() / 2);
        this.Fa = this.Ea;
        c(true);
        this.la = i2;
        postInvalidateOnAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, RectF rectF, int i4, boolean z) {
        a(i2, i3, (int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, i4, z);
    }

    private void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        a aVar;
        int i9 = this.H;
        a[] aVarArr = this.G;
        if (i9 >= aVarArr.length) {
            a[] aVarArr2 = new a[aVarArr.length + 16];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, i9);
            this.G = aVarArr2;
        }
        a[] aVarArr3 = this.G;
        int i10 = this.H;
        if (aVarArr3[i10] == null) {
            aVar = new a(this, null);
            aVarArr3[i10] = aVar;
        } else {
            aVar = aVarArr3[i10];
        }
        this.H++;
        aVar.f22114a = i4;
        aVar.f22115b = i6;
        aVar.f22116c = i5;
        aVar.f22117d = i7;
        aVar.f22118e = i2;
        aVar.f22119f = i3;
        aVar.f22120g = z;
    }

    private int g(int i2) {
        return a(new C2051uh(this, i2));
    }

    private void a(Canvas canvas) {
        canvas.drawColor(this.ob);
    }

    private int a(int i2, TrackType trackType) {
        if (i2 < 0 || i2 + 1 > this.nb) {
            return 0;
        }
        i[] iVarArr = this.Gb;
        return iVarArr[i2].f22135b == trackType ? iVarArr[i2].f22134a : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g extends b {

        /* renamed from: d, reason: collision with root package name */
        int f22128d;

        /* renamed from: e, reason: collision with root package name */
        int f22129e;

        /* renamed from: f, reason: collision with root package name */
        int f22130f;

        /* renamed from: g, reason: collision with root package name */
        boolean f22131g;

        /* renamed from: h, reason: collision with root package name */
        boolean f22132h;
        boolean i;
        int j;
        Canvas k;
        NexTimelineItem l;
        Bitmap m;
        private Rect n;
        c.d.b.m.k o;
        private int p;
        private int q;
        private int r;
        private int s;
        private int t;
        private boolean u;

        g() {
            super();
            this.f22131g = false;
            this.f22132h = false;
            this.i = false;
            this.j = 0;
            this.l = null;
            this.m = null;
            this.n = new Rect();
            this.o = new c.d.b.m.k();
        }

        private void b(NexTimelineItem nexTimelineItem) {
            if (this.q != 0 || this.u) {
                int dimensionPixelOffset = TimelineView.this.getResources().getDimensionPixelOffset(R.dimen.timeline3_itemPrepStatusInset);
                float dimensionPixelOffset2 = TimelineView.this.getResources().getDimensionPixelOffset(R.dimen.timeline3_itemCornerRadius);
                float f2 = dimensionPixelOffset;
                TimelineView.this.eb.inset(f2, f2);
                if (this.u) {
                    TimelineView.this.j.setStyle(Paint.Style.FILL);
                    TimelineView.this.j.setColor(this.s);
                    TimelineView.this.j.setAntiAlias(true);
                    if (Build.VERSION.SDK_INT >= 19) {
                        TimelineView.this.f22110e.rewind();
                        TimelineView.this.f22110e.addRect(TimelineView.this.eb.left, TimelineView.this.eb.top, TimelineView.this.eb.left + ((TimelineView.this.eb.width() * this.t) / 360.0f), TimelineView.this.eb.bottom, Path.Direction.CCW);
                        TimelineView.this.f22111f.rewind();
                        TimelineView.this.f22111f.addRoundRect(TimelineView.this.eb, dimensionPixelOffset2, dimensionPixelOffset2, Path.Direction.CCW);
                        TimelineView.this.f22110e.op(TimelineView.this.f22111f, Path.Op.INTERSECT);
                        this.k.drawPath(TimelineView.this.f22110e, TimelineView.this.j);
                    } else {
                        TimelineView.this.k.set(TimelineView.this.eb.left, TimelineView.this.eb.top, TimelineView.this.eb.left + ((TimelineView.this.eb.width() * this.t) / 360.0f), TimelineView.this.eb.bottom);
                        this.k.drawRoundRect(TimelineView.this.k, dimensionPixelOffset2, dimensionPixelOffset2, TimelineView.this.j);
                    }
                }
                if (this.q != 0) {
                    Drawable drawable = TimelineView.this.getResources().getDrawable(this.q);
                    int centerX = (int) TimelineView.this.eb.centerX();
                    int centerY = (int) TimelineView.this.eb.centerY();
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    int i = centerX - (intrinsicWidth / 2);
                    int i2 = centerY - (intrinsicHeight / 2);
                    drawable.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
                    drawable.draw(this.k);
                }
            }
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
        public void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
            int i7;
            int i8;
            int i9;
            int i10;
            Bitmap bitmap;
            Bitmap bitmap2;
            NexTimelineItem nexTimelineItem2;
            Canvas canvas;
            Bitmap bitmap3;
            boolean z2;
            boolean z3 = true;
            if ((i3 > this.f22128d && i3 < this.f22130f) || (((i7 = i3 + i4) > this.f22128d && i7 < this.f22130f) || (i3 <= (i8 = this.f22128d) && i7 > i8))) {
                boolean z4 = TimelineView.this.getSelectedTimelineInt() == 1 && TimelineView.this.getSelectedIndex() == i;
                int i11 = TimelineView.this.p;
                TimelineView timelineView = TimelineView.this;
                int max = Math.max(i11 - timelineView.Ga, timelineView.q);
                TimelineView.this.eb.left = i3;
                TimelineView.this.eb.right = i3 + i4;
                TimelineView.this.eb.top = TimelineView.this.r;
                TimelineView.this.eb.bottom = TimelineView.this.r + max;
                TimelineView.this.eb.offset(0.0f, TimelineView.this.Ga);
                if (z4) {
                    TimelineView timelineView2 = TimelineView.this;
                    timelineView2.a(1, i, timelineView2.eb, 0, true);
                } else {
                    TimelineView timelineView3 = TimelineView.this;
                    timelineView3.a(1, i, timelineView3.eb, 0, false);
                }
            }
            if ((i3 <= this.f22129e || i3 >= this.f22130f) && (((i9 = i3 + i4) <= this.f22129e || i9 >= this.f22130f) && (i3 > (i10 = this.f22129e) || i9 <= i10))) {
                return;
            }
            boolean z5 = TimelineView.this.getSelectedTimelineInt() == 1 && TimelineView.this.getSelectedIndex() == i;
            int i12 = TimelineView.this.p;
            TimelineView timelineView4 = TimelineView.this;
            int max2 = Math.max(i12 - timelineView4.Ga, timelineView4.q);
            TimelineView.this.eb.left = i3;
            TimelineView.this.eb.right = i3 + i4;
            TimelineView.this.eb.top = TimelineView.this.r;
            TimelineView.this.eb.bottom = TimelineView.this.r + max2;
            TimelineView.this.eb.offset(0.0f, TimelineView.this.Ga);
            TimelineView.this.eb.offset(0.0f, -TimelineView.this.Ga);
            Rect rect = TimelineView.this.fb;
            float f2 = TimelineView.this.gb + TimelineView.this.eb.left;
            TimelineView timelineView5 = TimelineView.this;
            int i13 = (int) (f2 - timelineView5.Ea);
            int i14 = (int) (timelineView5.hb + TimelineView.this.eb.top);
            float f3 = TimelineView.this.gb + TimelineView.this.eb.right;
            TimelineView timelineView6 = TimelineView.this;
            rect.set(i13, i14, (int) (f3 - timelineView6.Ea), (int) (timelineView6.hb + TimelineView.this.eb.bottom));
            if (TimelineView.this.ra != null && TimelineView.this.sa && TimelineView.this.qa == nexTimelineItem) {
                TimelineView.this.sa = false;
                nexTimelineItem.onCustomPostDrag_v3(TimelineView.this.ra, TimelineView.this.fb);
            }
            if (z5 && (nexTimelineItem instanceof NexVideoClipItem)) {
                NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexTimelineItem;
                int startOverlap = nexVideoClipItem.getStartOverlap();
                int endOverlap = nexVideoClipItem.getEndOverlap();
                int trimTimeStart = nexVideoClipItem.getTrimTimeStart();
                int playbackSpeed = nexVideoClipItem.getPlaybackSpeed();
                int absStartTime = TimelineView.this.ya - nexTimelineItem.getAbsStartTime();
                int snapToIFrame = ((nexVideoClipItem.snapToIFrame(((absStartTime * playbackSpeed) / 100) + trimTimeStart) - trimTimeStart) * 100) / playbackSpeed;
                int absStartTime2 = nexTimelineItem.getAbsStartTime() + snapToIFrame;
                if (absStartTime2 >= nexTimelineItem.getAbsStartTime() + startOverlap + (Math.max(10, TimelineView.this.m()) * 2) && absStartTime2 <= nexTimelineItem.getAbsEndTime() - Math.max(100, endOverlap)) {
                    this.f22131g = true;
                }
                if (TimelineView.this.ya < (nexTimelineItem.getAbsEndTime() - (Math.max(17, TimelineView.this.m()) * 2)) - 1 && TimelineView.this.ya >= nexTimelineItem.getAbsStartTime() + Math.max(startOverlap + 10, 100)) {
                    this.f22132h = true;
                }
                if (absStartTime2 >= nexTimelineItem.getAbsStartTime() + Math.max(startOverlap + 10, 100) && absStartTime2 <= nexTimelineItem.getAbsEndTime() - Math.max(endOverlap + 10, 100)) {
                    this.i = true;
                }
                if ((Math.abs(absStartTime - snapToIFrame) * 100) / nexVideoClipItem.getPlaybackSpeed() > 2000) {
                    z2 = false;
                    this.f22131g = false;
                    this.i = false;
                } else {
                    z2 = false;
                }
                if (absStartTime < 30) {
                    this.f22131g = z2;
                }
                nexTimelineItem.getDuration();
            }
            if (this.k.quickReject(TimelineView.this.eb, Canvas.EdgeType.AA)) {
                return;
            }
            int width = (int) TimelineView.this.eb.width();
            int height = (int) TimelineView.this.eb.height();
            int min = Math.min(SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE, this.k.getMaximumBitmapWidth());
            a(nexTimelineItem);
            boolean z6 = this.q != 0 || this.u;
            if ((z5 && !z6) || width > min) {
                if (z5) {
                    this.m = null;
                    this.l = nexTimelineItem;
                    TimelineView timelineView7 = TimelineView.this;
                    timelineView7.ib.set(timelineView7.eb);
                    return;
                }
                if (this.k.isHardwareAccelerated()) {
                    k.a a2 = this.o.a(TimelineView.this.getWidth(), TimelineView.this.getHeight());
                    Canvas canvas2 = a2.f3853b;
                    Bitmap bitmap4 = a2.f3852a;
                    bitmap4.eraseColor(0);
                    bitmap3 = bitmap4;
                    canvas = canvas2;
                } else {
                    canvas = this.k;
                    bitmap3 = null;
                }
                float f4 = TimelineView.this.eb.left;
                float f5 = TimelineView.this.eb.top;
                int save = canvas.save();
                if (bitmap3 != null) {
                    canvas.translate(-TimelineView.this.Ea, 0.0f);
                }
                canvas.clipRect(TimelineView.this.eb);
                canvas.translate(TimelineView.this.eb.left, TimelineView.this.eb.top);
                TimelineView.this.eb.offsetTo(0.0f, 0.0f);
                TimelineView.this.k.setEmpty();
                TimelineView.this.j.reset();
                Bitmap bitmap5 = bitmap3;
                TimelineView.this.f22107b.a(canvas, TimelineView.this.eb, TimelineView.this.k, TimelineView.this.j, z5, false, TimelineView.this.ra, false, TimelineView.this.eb.right, TimelineView.this.Oa, 0, (List<com.nextreaming.nexeditorui.ob>) null, (NexTimelineItem.r) TimelineView.this.f22112g, nexTimelineItem, TimelineView.this.zb);
                nexTimelineItem.onDraw(TimelineView.this.f22107b);
                canvas.restoreToCount(save);
                TimelineView.this.eb.offsetTo(f4, f5);
                if (bitmap5 != null) {
                    this.k.drawBitmap(bitmap5, TimelineView.this.Ea, 0.0f, (Paint) null);
                    return;
                }
                return;
            }
            Bitmap bitmap6 = (Bitmap) TimelineView.this.Db.get(nexTimelineItem);
            if (bitmap6 != null && bitmap6.getWidth() == width && bitmap6.getHeight() == height) {
                bitmap = bitmap6;
                z3 = false;
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                TimelineView.this.Db.put(nexTimelineItem, createBitmap);
                bitmap = createBitmap;
            }
            if (z3) {
                Canvas canvas3 = (Canvas) TimelineView.this.Eb.get(bitmap);
                if (canvas3 == null) {
                    canvas3 = new Canvas(bitmap);
                    TimelineView.this.Eb.put(bitmap, canvas3);
                }
                Canvas canvas4 = canvas3;
                canvas4.setBitmap(bitmap);
                float f6 = TimelineView.this.eb.left;
                float f7 = TimelineView.this.eb.top;
                TimelineView.this.eb.offsetTo(0.0f, 0.0f);
                TimelineView.this.k.setEmpty();
                TimelineView.this.j.reset();
                bitmap2 = bitmap;
                TimelineView.this.f22107b.a(canvas4, TimelineView.this.eb, TimelineView.this.k, TimelineView.this.j, z5, false, TimelineView.this.ra, false, TimelineView.this.eb.right, TimelineView.this.Oa, 0, (List<com.nextreaming.nexeditorui.ob>) null, (NexTimelineItem.r) TimelineView.this.f22112g, nexTimelineItem, TimelineView.this.zb);
                int save2 = canvas4.save();
                nexTimelineItem2 = nexTimelineItem;
                nexTimelineItem2.onDraw(TimelineView.this.f22107b);
                canvas4.restoreToCount(save2);
                canvas4.setBitmap(null);
                TimelineView.this.eb.offsetTo(f6, f7);
            } else {
                bitmap2 = bitmap;
                nexTimelineItem2 = nexTimelineItem;
            }
            if (z5) {
                this.m = bitmap2;
                this.l = nexTimelineItem2;
                TimelineView timelineView8 = TimelineView.this;
                timelineView8.ib.set(timelineView8.eb);
                return;
            }
            a(nexTimelineItem2, bitmap2, z);
        }

        void c() {
            NexTimelineItem nexTimelineItem = this.l;
            if (nexTimelineItem != null && this.m != null) {
                a(nexTimelineItem);
                TimelineView.this.eb.set(TimelineView.this.ib);
                a(this.l, this.m, false);
                TimelineView.this.eb.set(TimelineView.this.ib);
                Drawable drawable = TimelineView.this.getResources().getDrawable(R.drawable.timeline_item_border_sel);
                drawable.getPadding(this.n);
                drawable.setBounds((int) TimelineView.this.eb.left, (int) TimelineView.this.eb.top, (int) TimelineView.this.eb.right, (int) TimelineView.this.eb.bottom);
                drawable.draw(this.k);
                return;
            }
            if (this.l != null) {
                TimelineView.this.eb.set(TimelineView.this.ib);
                this.k.save();
                this.k.clipRect(TimelineView.this.eb);
                this.k.translate(TimelineView.this.eb.left, TimelineView.this.eb.top);
                TimelineView.this.eb.offsetTo(0.0f, 0.0f);
                TimelineView.this.k.setEmpty();
                TimelineView.this.j.reset();
                TimelineView.this.f22107b.a(this.k, TimelineView.this.eb, TimelineView.this.k, TimelineView.this.j, true, false, TimelineView.this.ra, false, TimelineView.this.eb.right, TimelineView.this.Oa, 0, (List<com.nextreaming.nexeditorui.ob>) null, (NexTimelineItem.r) TimelineView.this.f22112g, this.l, TimelineView.this.zb);
                this.l.onDraw(TimelineView.this.f22107b);
                this.k.restore();
            }
        }

        public void d() {
            this.f22131g = false;
            this.f22132h = false;
            this.i = false;
            this.l = null;
            this.m = null;
            this.o.a();
        }

        private void a(NexTimelineItem nexTimelineItem) {
            MediaStoreItemId mediaMSID;
            this.p = 255;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            if (TimelineView.this.f22109d == null || (mediaMSID = nexTimelineItem.getMediaMSID()) == null) {
                return;
            }
            TimelineView.this.f22109d.a(mediaMSID, TimelineView.this.f22108c);
            if (TimelineView.this.f22108c.f20781a != null) {
                switch (C1975oh.f22474a[TimelineView.this.f22108c.f20781a.ordinal()]) {
                    case 1:
                        this.p = 70;
                        this.q = R.drawable.clip_status_busy;
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        this.p = 70;
                        this.q = R.drawable.clip_status_notsupport;
                        return;
                    case 7:
                    case 8:
                    case 9:
                        this.p = 70;
                        return;
                    case 10:
                        this.p = 70;
                        this.u = true;
                        this.t = (TimelineView.this.f22108c.f20782b * 360) / TimelineView.this.f22108c.f20783c;
                        this.q = R.drawable.clip_status_downloading;
                        this.r = TimelineView.this.getResources().getColor(R.color.timeline_progress_download_bg);
                        this.s = TimelineView.this.getResources().getColor(R.color.timeline_progress_download_fg);
                        return;
                    case 11:
                        this.p = 70;
                        this.u = true;
                        this.t = (TimelineView.this.f22108c.f20782b * 360) / TimelineView.this.f22108c.f20783c;
                        this.q = R.drawable.clip_status_transcoding;
                        this.r = TimelineView.this.getResources().getColor(R.color.timeline_progress_transcode_bg);
                        this.s = TimelineView.this.getResources().getColor(R.color.timeline_progress_transcode_fg);
                        return;
                    default:
                        return;
                }
            }
        }

        private void a(NexTimelineItem nexTimelineItem, Bitmap bitmap, boolean z) {
            float f2 = TimelineView.this.eb.left;
            float f3 = TimelineView.this.eb.top;
            TimelineView.this.eb.offsetTo(0.0f, 0.0f);
            TextPaint textPaint = null;
            if (TimelineView.this.rb != null && TimelineView.this.rb == nexTimelineItem && TimelineView.this.sb < 0.995f && TimelineView.this.ub != null && TimelineView.this.ub.hasStarted()) {
                this.k.save();
                int i = C1975oh.f22475b[TimelineView.this.tb.ordinal()];
                if (i == 1) {
                    float max = Math.max(1.0E-4f, TimelineView.this.sb);
                    this.k.scale(max, max, (bitmap.getWidth() / 2) + f2, (bitmap.getHeight() / 2) + f3);
                    textPaint = TimelineView.this.j;
                    textPaint.setAlpha((((int) (max * 255.0f)) * this.p) / 255);
                } else if (i == 2) {
                    float max2 = Math.max(1.0E-4f, 1.0f - TimelineView.this.sb);
                    this.k.scale(max2, max2, (bitmap.getWidth() / 2) + f2, (bitmap.getHeight() / 2) + f3);
                    textPaint = TimelineView.this.j;
                    textPaint.setAlpha((((int) (max2 * 255.0f)) * this.p) / 255);
                }
                this.k.drawBitmap(bitmap, f2, f3, textPaint);
                this.k.restore();
            } else if (z) {
                TimelineView.this.j.reset();
                TimelineView.this.j.setAlpha((this.p * 65) / 255);
                this.k.drawBitmap(bitmap, f2, f3, TimelineView.this.j);
            } else if (this.p < 255) {
                TimelineView.this.j.reset();
                TimelineView.this.j.setAlpha(this.p);
                this.k.drawBitmap(bitmap, f2, f3, TimelineView.this.j);
            } else {
                this.k.drawBitmap(bitmap, f2, f3, (Paint) null);
            }
            TimelineView.this.eb.offsetTo(f2, f3);
            b(nexTimelineItem);
        }
    }

    private void a(int i2, int i3, TrackType trackType) {
        int i4 = i2 + 1;
        if (i4 > this.Gb.length) {
            e(i4);
        }
        i[] iVarArr = this.Gb;
        if (iVarArr[i2].f22135b != null && iVarArr[i2].f22135b != trackType) {
            StringBuilder sb = new StringBuilder();
            sb.append("Attempt to set track type ");
            sb.append(trackType == null ? "null" : trackType.name());
            sb.append(" for track that already has type ");
            sb.append(this.Gb[i2].f22135b.name());
            throw new IllegalArgumentException(sb.toString());
        }
        i[] iVarArr2 = this.Gb;
        iVarArr2[i2].f22134a = i3;
        iVarArr2[i2].f22135b = trackType;
        if (i4 > this.nb) {
            this.nb = i4;
        }
    }

    private void a(Canvas canvas, NexSecondaryTimelineItem nexSecondaryTimelineItem, int i2, int i3, int i4, int i5, int i6) {
        Bitmap bitmap;
        boolean z;
        float f2;
        float f3;
        Bitmap bitmap2;
        int i7;
        Animation animation;
        float f4;
        float f5;
        boolean z2 = this.F && this.P == nexSecondaryTimelineItem && this.ra == null;
        boolean z3 = this.bb == nexSecondaryTimelineItem;
        float j = j(i5);
        this.eb.left = j(i4);
        RectF rectF = this.eb;
        int i8 = this.r + this.p + this.t;
        int i9 = this.v;
        rectF.top = i8 + ((this.u + i9) * i3);
        rectF.bottom = rectF.top + i9;
        rectF.right = j;
        a(2, i2, rectF, i3, z3);
        Rect rect = this.fb;
        int i10 = this.gb;
        RectF rectF2 = this.eb;
        float f6 = i10 + rectF2.left;
        int i11 = this.Ea;
        int i12 = this.hb;
        rect.set((int) (f6 - i11), (int) (i12 + rectF2.top), (int) ((i10 + rectF2.right) - i11), (int) (i12 + rectF2.bottom));
        NexTimelineItem.i iVar = this.ra;
        if (iVar != null && this.sa && this.qa == nexSecondaryTimelineItem) {
            this.sa = false;
            nexSecondaryTimelineItem.onCustomPostDrag_v3(iVar, this.fb);
        }
        if (canvas.quickReject(this.eb, Canvas.EdgeType.AA)) {
            return;
        }
        int width = (int) this.eb.width();
        int height = (int) this.eb.height();
        if (width < 1 || height < 1) {
            return;
        }
        if (!z3 && !z2 && width < canvas.getMaximumBitmapWidth()) {
            Bitmap bitmap3 = this.Db.get(nexSecondaryTimelineItem);
            if (bitmap3 == null || bitmap3.getWidth() != width) {
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.Db.put(nexSecondaryTimelineItem, createBitmap);
                bitmap = createBitmap;
                z = true;
            } else {
                bitmap = bitmap3;
                z = false;
            }
            RectF rectF3 = this.eb;
            float f7 = rectF3.left;
            float f8 = rectF3.top;
            if (z) {
                Canvas canvas2 = new Canvas(bitmap);
                List<com.nextreaming.nexeditorui.ob> list = this.Hb;
                list.clear();
                list.add(new com.nextreaming.nexeditorui.ob(0, 0));
                f2 = f8;
                f3 = f7;
                bitmap2 = bitmap;
                i7 = 2;
                a(new C1993qh(this, i4, (int) this.eb.width(), nexSecondaryTimelineItem.getDuration(), list));
                list.add(new com.nextreaming.nexeditorui.ob(nexSecondaryTimelineItem.getDuration(), (int) this.eb.width()));
                RectF rectF4 = this.eb;
                float f9 = j - rectF4.left;
                rectF4.right = j;
                rectF4.offsetTo(0.0f, 0.0f);
                this.k.setEmpty();
                this.j.reset();
                if (z2) {
                    this.j.setStyle(Paint.Style.STROKE);
                    this.j.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f), new CornerPathEffect(5.0f)));
                    this.j.setColor(-5592406);
                }
                int i13 = (this.Ra && this.Qa == nexSecondaryTimelineItem) ? (int) (this.Ta * 255.0f) : 0;
                if (z2) {
                    this.j.setStyle(Paint.Style.STROKE);
                    this.j.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f), new CornerPathEffect(5.0f)));
                    this.j.setColor(-5592406);
                    this.f22107b.a(canvas2, this.eb, this.k, this.j, z3, true, this.ra, false, f9, this.Oa, i13, list, (NexTimelineItem.r) this.f22112g, (NexTimelineItem) nexSecondaryTimelineItem, this.zb);
                    nexSecondaryTimelineItem.onDraw(this.f22107b);
                } else {
                    this.f22107b.a(canvas2, this.eb, this.k, this.j, z3, z2, this.ra, false, f9, this.Oa, i13, list, (NexTimelineItem.r) this.f22112g, (NexTimelineItem) nexSecondaryTimelineItem, this.zb);
                    nexSecondaryTimelineItem.onDraw(this.f22107b);
                }
            } else {
                f2 = f8;
                f3 = f7;
                bitmap2 = bitmap;
                i7 = 2;
            }
            NexTimelineItem nexTimelineItem = this.rb;
            TextPaint textPaint = null;
            if (nexTimelineItem != null && nexTimelineItem == nexSecondaryTimelineItem && this.sb < 0.995f && (animation = this.ub) != null && animation.hasStarted()) {
                canvas.save();
                int i14 = C1975oh.f22475b[this.tb.ordinal()];
                if (i14 == 1) {
                    f4 = f2;
                    f5 = f3;
                    float max = Math.max(1.0E-4f, this.sb);
                    canvas.scale(max, max, f5 + (bitmap2.getWidth() / i7), (bitmap2.getHeight() / i7) + f4);
                    textPaint = this.j;
                    textPaint.setAlpha((int) (max * 255.0f));
                } else if (i14 != i7) {
                    f4 = f2;
                    f5 = f3;
                } else {
                    float max2 = Math.max(1.0E-4f, 1.0f - this.sb);
                    f5 = f3;
                    f4 = f2;
                    canvas.scale(max2, max2, f5 + (bitmap2.getWidth() / i7), (bitmap2.getHeight() / i7) + f4);
                    textPaint = this.j;
                    textPaint.setAlpha((int) (max2 * 255.0f));
                }
                canvas.drawBitmap(bitmap2, f5, f4, textPaint);
                canvas.restore();
                return;
            }
            canvas.drawBitmap(bitmap2, f3, f2, (Paint) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.nextreaming.nexeditorui.ob(0, 0));
        a(new C2001rh(this, i4, (int) this.eb.width(), nexSecondaryTimelineItem.getDuration(), arrayList));
        arrayList.add(new com.nextreaming.nexeditorui.ob(nexSecondaryTimelineItem.getDuration(), (int) this.eb.width()));
        if (z2 && !this.qb) {
            canvas.saveLayerAlpha(this.eb, 40, 31);
        } else {
            canvas.save();
        }
        canvas.clipRect(this.eb);
        RectF rectF5 = this.eb;
        canvas.translate(rectF5.left, rectF5.top);
        RectF rectF6 = this.eb;
        float f10 = j - rectF6.left;
        rectF6.right = j;
        rectF6.offsetTo(0.0f, 0.0f);
        this.k.setEmpty();
        this.j.reset();
        if (z2) {
            this.j.setStyle(Paint.Style.STROKE);
            this.j.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f), new CornerPathEffect(5.0f)));
            this.j.setColor(-5592406);
        }
        int i15 = (this.Ra && this.Qa == nexSecondaryTimelineItem) ? (int) (this.Ta * 255.0f) : 0;
        if (z2) {
            this.j.setStyle(Paint.Style.STROKE);
            this.j.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f), new CornerPathEffect(5.0f)));
            this.j.setColor(-5592406);
            this.f22107b.a(canvas, this.eb, this.k, this.j, z3, true, this.ra, false, f10, this.Oa, i15, (List<com.nextreaming.nexeditorui.ob>) arrayList, (NexTimelineItem.r) this.f22112g, (NexTimelineItem) nexSecondaryTimelineItem, this.zb);
            nexSecondaryTimelineItem.onDraw(this.f22107b);
        } else {
            this.f22107b.a(canvas, this.eb, this.k, this.j, z3, z2, this.ra, false, f10, this.Oa, i15, (List<com.nextreaming.nexeditorui.ob>) arrayList, (NexTimelineItem.r) this.f22112g, (NexTimelineItem) nexSecondaryTimelineItem, this.zb);
            nexSecondaryTimelineItem.onDraw(this.f22107b);
        }
        canvas.restore();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public int b(NexTimelineItem nexTimelineItem, boolean z) {
        int i2;
        int i3;
        this.Sb = null;
        if (nexTimelineItem != null) {
            a(nexTimelineItem, r1);
            int[] iArr = {iArr[0] - (getWidth() / 2), iArr[1] - (getWidth() / 2)};
            if (nexTimelineItem instanceof NexTransitionItem) {
                i2 = iArr[0] + ((iArr[1] - iArr[0]) / 2);
            } else {
                i2 = this.Ea;
                if (i2 < iArr[0] + 1) {
                    i2 = iArr[0] + 1;
                } else if (i2 > iArr[1] - 1) {
                    i2 = iArr[1] - 1;
                }
            }
            if (nexTimelineItem instanceof NexSecondaryTimelineItem) {
                if (this.Ab) {
                    i3 = 0;
                } else {
                    i3 = ((NexSecondaryTimelineItem) nexTimelineItem).getTrackMapping();
                    f(i3);
                }
                int min = Math.min(getMaxScrollY(), ((this.v + this.u) * i3) + (this.p - this.q));
                r2 = i3 != 0 ? Math.min(getMaxScrollY(), ((i3 - 1) * (this.v + this.u)) + (this.p - this.q)) : 0;
                if (Math.abs(this.Ga - min) < Math.abs(this.Ga - r2)) {
                    r2 = min;
                }
            }
            a(i2, r2, z);
        }
        return this.la;
    }

    public TimelineView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f22108c = new C1803a();
        this.f22110e = new Path();
        this.f22111f = new Path();
        this.f22112g = new h(this);
        this.f22113h = 1.0f;
        this.i = 1.0f;
        this.j = new TextPaint();
        this.k = new RectF();
        this.l = null;
        this.m = null;
        this.n = 40.0f;
        this.o = 5;
        this.p = 100;
        this.q = 10;
        this.r = 5;
        this.s = 5;
        this.t = 5;
        this.u = 5;
        this.v = 40;
        this.z = new NexTimeline();
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = new a[16];
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = 0;
        this.S = 0;
        this.T = null;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.ca = 0;
        this.da = 0;
        this.ea = 0;
        this.fa = 0;
        this.ga = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.ha = 0;
        this.ia = false;
        this.ja = false;
        this.ka = null;
        this.la = 0;
        this.ma = 0;
        this.na = 0.0f;
        this.oa = 0.0f;
        this.pa = 0;
        this.qa = null;
        this.ra = null;
        this.sa = false;
        this.ta = 0;
        this.ua = 0;
        this.va = 0;
        this.wa = false;
        this.xa = false;
        this.ya = 0;
        this.za = 0;
        this.Aa = 0;
        this.Ba = false;
        this.Ca = false;
        this.Da = false;
        this.Ea = 0;
        this.Fa = 0;
        this.Ga = 0;
        this.Ha = 0;
        this.Ia = 0;
        this.Ka = 0.0f;
        this.La = 0.0f;
        this.Na = -1;
        this.Oa = 0;
        this.Pa = 0;
        this.Qa = null;
        this.Ra = false;
        this.Sa = 0L;
        this.Ta = 0.0f;
        this.Ua = new ArrayList<>();
        this.Va = false;
        this.Wa = new com.nexstreaming.app.general.util.C("NexTimelineView_OnDraw", false);
        this.Xa = false;
        this.Ya = -1;
        this.bb = null;
        this.cb = null;
        this.db = false;
        this.eb = new RectF();
        this.fb = new Rect();
        this.ib = new RectF();
        this.jb = 0.0f;
        this.kb = 0.0f;
        this.mb = false;
        this.nb = -1;
        this.pb = false;
        this.yb = false;
        this.Ab = false;
        this.Cb = new RunnableC1984ph(this);
        this.Db = new WeakHashMap();
        this.Eb = new WeakHashMap();
        this.Fb = new g();
        this.Gb = new i[0];
        this.Hb = new ArrayList();
        this.Nb = false;
        this.Ob = new Point();
        this.Pb = new wh(this);
        this.Qb = new xh(this);
        this.Rb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.Sb = null;
        y();
    }

    protected void a(Canvas canvas, boolean z, int i2) {
        int i3 = this.Ea;
        this.Fa = i3;
        this.Ea = i2;
        a(canvas, z);
        this.Ea = i3;
    }

    protected void a(Canvas canvas, boolean z) {
        this.Wa.a();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.gb = iArr[0];
        this.hb = iArr[1];
        if (z) {
            v();
        }
        this.Wa.a(1);
        r();
        this.j.reset();
        a(canvas);
        canvas.save();
        canvas.translate(-this.Ea, 0.0f);
        d(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(-this.Ea, -this.Ga);
        g(canvas);
        canvas.restore();
        i(canvas);
        canvas.save();
        canvas.translate(-this.Ea, 0.0f);
        e(canvas);
        if (z) {
            f(canvas);
            h(canvas);
            b(canvas);
            if (this.qa == null) {
                c(canvas);
            }
            j(canvas);
        }
        canvas.restore();
        u();
        this.Wa.a(2);
    }

    public TimelineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22108c = new C1803a();
        this.f22110e = new Path();
        this.f22111f = new Path();
        this.f22112g = new h(this);
        this.f22113h = 1.0f;
        this.i = 1.0f;
        this.j = new TextPaint();
        this.k = new RectF();
        this.l = null;
        this.m = null;
        this.n = 40.0f;
        this.o = 5;
        this.p = 100;
        this.q = 10;
        this.r = 5;
        this.s = 5;
        this.t = 5;
        this.u = 5;
        this.v = 40;
        this.z = new NexTimeline();
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = new a[16];
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = 0;
        this.S = 0;
        this.T = null;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.ca = 0;
        this.da = 0;
        this.ea = 0;
        this.fa = 0;
        this.ga = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.ha = 0;
        this.ia = false;
        this.ja = false;
        this.ka = null;
        this.la = 0;
        this.ma = 0;
        this.na = 0.0f;
        this.oa = 0.0f;
        this.pa = 0;
        this.qa = null;
        this.ra = null;
        this.sa = false;
        this.ta = 0;
        this.ua = 0;
        this.va = 0;
        this.wa = false;
        this.xa = false;
        this.ya = 0;
        this.za = 0;
        this.Aa = 0;
        this.Ba = false;
        this.Ca = false;
        this.Da = false;
        this.Ea = 0;
        this.Fa = 0;
        this.Ga = 0;
        this.Ha = 0;
        this.Ia = 0;
        this.Ka = 0.0f;
        this.La = 0.0f;
        this.Na = -1;
        this.Oa = 0;
        this.Pa = 0;
        this.Qa = null;
        this.Ra = false;
        this.Sa = 0L;
        this.Ta = 0.0f;
        this.Ua = new ArrayList<>();
        this.Va = false;
        this.Wa = new com.nexstreaming.app.general.util.C("NexTimelineView_OnDraw", false);
        this.Xa = false;
        this.Ya = -1;
        this.bb = null;
        this.cb = null;
        this.db = false;
        this.eb = new RectF();
        this.fb = new Rect();
        this.ib = new RectF();
        this.jb = 0.0f;
        this.kb = 0.0f;
        this.mb = false;
        this.nb = -1;
        this.pb = false;
        this.yb = false;
        this.Ab = false;
        this.Cb = new RunnableC1984ph(this);
        this.Db = new WeakHashMap();
        this.Eb = new WeakHashMap();
        this.Fb = new g();
        this.Gb = new i[0];
        this.Hb = new ArrayList();
        this.Nb = false;
        this.Ob = new Point();
        this.Pb = new wh(this);
        this.Qb = new xh(this);
        this.Rb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.Sb = null;
        y();
    }

    private boolean a(NexTimelineItem nexTimelineItem, int[] iArr) {
        if (nexTimelineItem == null) {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
        if (nexTimelineItem.getTimeline() != this.z) {
            return false;
        }
        if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
            iArr[0] = 0;
            iArr[1] = 0;
            return a(new C2010sh(this, nexTimelineItem, iArr)) == 1;
        }
        iArr[0] = j(nexTimelineItem.getAbsStartTime());
        iArr[1] = j(nexTimelineItem.getAbsEndTime());
        return true;
    }

    private void a(MotionEvent motionEvent) {
        int i2;
        NexTimelineItem secondaryItem;
        if (this.F) {
            return;
        }
        this.mb = false;
        a b2 = b(((int) motionEvent.getX()) + this.Ea, ((int) motionEvent.getY()) + this.Ga);
        if (b2 == null) {
            return;
        }
        if (b2.f22118e == 1 && (this.z.getPrimaryItem(b2.f22119f) instanceof NexTransitionItem)) {
            return;
        }
        int i3 = b2.f22118e;
        if (i3 == 1) {
            int i4 = b2.f22119f;
            if (i4 < 0 || i4 >= this.z.getPrimaryItemCount()) {
                return;
            } else {
                secondaryItem = this.z.getPrimaryItem(b2.f22119f);
            }
        } else if (i3 != 2 || (i2 = b2.f22119f) < 0 || i2 >= this.z.getSecondaryItemCount()) {
            return;
        } else {
            secondaryItem = this.z.getSecondaryItem(b2.f22119f);
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i5 = iArr[0];
        int i6 = iArr[1];
        d();
        ((Vibrator) getContext().getSystemService("vibrator")).vibrate(30L);
        Context context = getContext();
        int i7 = b2.f22114a + i5;
        int i8 = this.Ea;
        NexTimelineItem.k onLongPress = secondaryItem.onLongPress(context, this, new RectF(i7 - i8, b2.f22116c + i6, (b2.f22115b + i5) - i8, b2.f22117d + i6), (int) (i5 + motionEvent.getX()), (int) (i6 + motionEvent.getY()), getSelectedIndex() == b2.f22119f && getSelectedTimelineInt() == b2.f22118e, this.Oa);
        this.na = motionEvent.getRawX();
        this.oa = motionEvent.getRawY();
        this.qb = true;
        if (onLongPress instanceof NexTimelineItem.i) {
            this.qa = secondaryItem;
            this.ra = (NexTimelineItem.i) onLongPress;
            this.R = b2.f22119f;
            if (secondaryItem instanceof NexPrimaryTimelineItem) {
                this.T = WhichTimeline.PRIMARY;
            } else {
                this.T = WhichTimeline.SECONDARY;
            }
            this.F = true;
            this.Rb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.C = false;
            invalidate();
            return;
        }
        if (onLongPress == NexTimelineItem.k.f24134b) {
            this.pa = secondaryItem.getAbsStartTime();
        } else if (onLongPress != NexTimelineItem.k.f24133a) {
            return;
        }
        this.Xa = false;
        boolean z = secondaryItem instanceof NexPrimaryTimelineItem;
        if (z) {
            PreferenceManager.getDefaultSharedPreferences(getContext());
        }
        this.I = (int) (motionEvent.getX() - (b2.f22114a - this.Ea));
        this.J = (int) (motionEvent.getY() - b2.f22116c);
        getWindowVisibleDisplayFrame(new Rect());
        Bitmap dragBitmap_v3 = secondaryItem.getDragBitmap_v3(getContext(), Math.min(b2.f22115b - b2.f22114a, getResources().getDimensionPixelSize(R.dimen.timeline3_dragItemMaxWidth)), b2.f22117d - b2.f22116c, b2.f22115b - b2.f22114a);
        this.L = new ImageView(getContext());
        this.L.setBackgroundColor(0);
        this.L.setVisibility(4);
        this.L.setImageBitmap(dragBitmap_v3);
        Bitmap bitmap = this.O;
        if (bitmap != null) {
            bitmap.recycle();
            this.O = null;
        }
        this.O = dragBitmap_v3;
        this.M = new WindowManager.LayoutParams();
        WindowManager.LayoutParams layoutParams = this.M;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.flags = 408;
        layoutParams.gravity = 51;
        layoutParams.x = ((int) motionEvent.getRawX()) - this.I;
        this.M.y = ((int) motionEvent.getRawY()) - this.J;
        WindowManager.LayoutParams layoutParams2 = this.M;
        layoutParams2.windowAnimations = 0;
        layoutParams2.format = -3;
        this.N.addView(this.L, layoutParams2);
        this.F = true;
        this.Rb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.R = b2.f22119f;
        this.S = this.R;
        if (z) {
            this.T = WhichTimeline.PRIMARY;
            this.P = secondaryItem;
            this.Q = ((NexPrimaryTimelineItem) secondaryItem).getTransition();
            this.L.setVisibility(0);
        } else {
            this.T = WhichTimeline.SECONDARY;
            this.P = secondaryItem;
            this.Q = null;
            this.L.setVisibility(4);
        }
        postInvalidateOnAnimation();
        b(motionEvent);
    }

    private void a(a aVar) {
        if (aVar == null) {
            e(0, -1);
        } else {
            e(aVar.f22118e, aVar.f22119f);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f, com.nextreaming.nexeditorui.NexTimelineItem.w
    public int a(boolean z) {
        return b(this.bb, z);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void a(NexTimelineItem nexTimelineItem, boolean z, boolean z2) {
        c(nexTimelineItem, z);
        if (z2) {
            this.Sb = new RunnableC1948lh(this, nexTimelineItem, z);
        } else {
            this.Sb = null;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void a(NexTimelineItem nexTimelineItem, boolean z) {
        this.Sb = null;
        if (nexTimelineItem != null) {
            a(nexTimelineItem, r1);
            int[] iArr = {iArr[0] - (getWidth() / 2), iArr[1] - (getWidth() / 2)};
            c(iArr[0] + 1, z);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void a(int i2, int i3, int i4) {
        this.wa = true;
        this.ta = i2;
        this.ua = i3;
        this.va = i4;
        invalidate();
    }

    private int a(b bVar) {
        return a(true, bVar);
    }

    private int a(boolean z, b bVar) {
        int i2;
        boolean z2;
        if (z) {
            Rect rect = new Rect();
            getLocalVisibleRect(rect);
            int width = rect.width();
            if (this.U != width) {
                this.U = width;
                x();
                invalidate();
            }
            i2 = (this.U / 2) + this.o;
        } else {
            i2 = this.o;
        }
        int primaryItemCount = this.z.getPrimaryItemCount();
        int i3 = i2;
        int i4 = 0;
        for (int i5 = 0; i5 < primaryItemCount + 2; i5++) {
            if (this.F && this.qa == null && this.T == WhichTimeline.PRIMARY) {
                int i6 = this.S;
                if (i6 == i5) {
                    if (i6 < primaryItemCount || this.R + 1 >= primaryItemCount) {
                        z2 = false;
                    } else {
                        NexPrimaryTimelineItem nexPrimaryTimelineItem = (NexPrimaryTimelineItem) this.Q;
                        int representedDuration = nexPrimaryTimelineItem.getRepresentedDuration();
                        int pixelWidth = nexPrimaryTimelineItem.getPixelWidth(this.n, this.f22113h);
                        bVar.a(this.R + 1, primaryItemCount, nexPrimaryTimelineItem, i3, pixelWidth, i4, representedDuration, true);
                        if (bVar.b()) {
                            return bVar.a();
                        }
                        i4 += representedDuration;
                        i3 += pixelWidth + this.o;
                        z2 = true;
                    }
                    NexPrimaryTimelineItem nexPrimaryTimelineItem2 = (NexPrimaryTimelineItem) this.P;
                    int representedDuration2 = nexPrimaryTimelineItem2.getRepresentedDuration();
                    int pixelWidth2 = nexPrimaryTimelineItem2.getPixelWidth(this.n, this.f22113h);
                    bVar.a(this.R, primaryItemCount, nexPrimaryTimelineItem2, i3, pixelWidth2, i4, representedDuration2, true);
                    if (bVar.b()) {
                        return bVar.a();
                    }
                    i4 += representedDuration2;
                    i3 += pixelWidth2 + this.o;
                    if (!z2) {
                        if (this.S + (this.R + 1 < primaryItemCount ? 0 : 1) < primaryItemCount) {
                            NexPrimaryTimelineItem nexPrimaryTimelineItem3 = (NexPrimaryTimelineItem) this.Q;
                            int representedDuration3 = nexPrimaryTimelineItem3.getRepresentedDuration();
                            int pixelWidth3 = nexPrimaryTimelineItem3.getPixelWidth(this.n, this.f22113h);
                            bVar.a(this.R + 1, primaryItemCount, nexPrimaryTimelineItem3, i3, pixelWidth3, i4, representedDuration3, true);
                            if (bVar.b()) {
                                return bVar.a();
                            }
                            i4 += representedDuration3;
                            i3 += pixelWidth3 + this.o;
                        }
                    }
                }
                int i7 = this.R;
                if (i7 == i5) {
                    continue;
                } else if (i7 + 1 == i5) {
                    continue;
                }
            }
            if (i5 < primaryItemCount) {
                NexPrimaryTimelineItem primaryItem = this.z.getPrimaryItem(i5);
                int representedDuration4 = primaryItem.getRepresentedDuration();
                int pixelWidth4 = primaryItem.getPixelWidth(this.n, this.f22113h);
                bVar.a(i5, primaryItemCount, primaryItem, i3, pixelWidth4, i4, representedDuration4, false);
                if (bVar.b()) {
                    return bVar.a();
                }
                i3 += pixelWidth4 + this.o;
                i4 += representedDuration4;
            } else {
                continue;
            }
        }
        return bVar.a();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public boolean a() {
        return this.Ca;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void a(NexTimelineItem nexTimelineItem, AnimType animType, int i2) {
        Animation animation = this.ub;
        if (animation != null && animation.hasStarted() && !this.ub.hasEnded()) {
            this.ub.cancel();
        }
        this.tb = animType;
        this.rb = nexTimelineItem;
        this.sb = 0.0f;
        this.ub = new C1957mh(this);
        this.ub.setAnimationListener(new AnimationAnimationListenerC1966nh(this));
        this.ub.setDuration(i2);
        startAnimation(this.ub);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void a(boolean z, Context context) {
        com.nexstreaming.app.general.nexasset.assetpackage.b c2;
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.z.getSecondaryItems()) {
            if (nexSecondaryTimelineItem instanceof NexLayerItem) {
                ((NexLayerItem) nexSecondaryTimelineItem).updateLockIconVisibility(this.zb, context);
            } else if (nexSecondaryTimelineItem instanceof NexAudioClipItem) {
                NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) nexSecondaryTimelineItem;
                String assetPackageId = nexAudioClipItem.getAssetPackageId();
                if (!TextUtils.isEmpty(assetPackageId) && (c2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().c(assetPackageId)) != null && !TextUtils.isEmpty(c2.getPriceType()) && c2.getPriceType().equalsIgnoreCase("Premium")) {
                    nexAudioClipItem.setLocked(z);
                }
            }
        }
    }
}
