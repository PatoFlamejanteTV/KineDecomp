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
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.text.TextPaint;
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
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.general.util.n;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.h.b;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.usage.KMUsage;
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

/* loaded from: classes.dex */
public class TimelineView extends View implements ScaleGestureDetector.OnScaleGestureListener, n.c, NexTimeline.b, NexTimelineItem.t {
    private float A;
    private float B;
    private TextPaint C;
    private RectF D;
    private com.nexstreaming.app.general.util.n E;
    private ScaleGestureDetector F;
    private float G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private NexTimeline S;
    private int T;
    private boolean U;
    private boolean V;
    private boolean W;

    /* renamed from: a, reason: collision with root package name */
    WhichTimeline f3746a;
    private boolean aA;
    private boolean aB;
    private d aC;
    private int aD;
    private int aE;
    private float aF;
    private float aG;
    private int aH;
    private NexTimelineItem aI;
    private NexTimelineItem.h aJ;
    private boolean aK;
    private int aL;
    private int aM;
    private int aN;
    private boolean aO;
    private boolean aP;
    private int aQ;
    private int aR;
    private int aS;
    private boolean aT;
    private boolean aU;
    private boolean aV;
    private int aW;
    private int aX;
    private int aY;
    private int aZ;
    private boolean aa;
    private boolean ab;
    private a[] ac;
    private int ad;
    private int ae;
    private int af;
    private ImageView ag;
    private ImageView ah;
    private WindowManager.LayoutParams ai;
    private WindowManager aj;
    private Bitmap ak;
    private NexTimelineItem al;
    private NexTimelineItem am;
    private int an;
    private int ao;
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private int at;
    private int au;
    private int av;
    private int aw;
    private int ax;
    private int ay;
    private int az;
    RectF b;
    private float bA;
    private float bB;
    private long bC;
    private boolean bD;
    private int bE;
    private int bF;
    private boolean bG;
    private boolean bH;
    private NexTimelineItem bI;
    private float bJ;
    private AnimType bK;
    private Animation bL;
    private boolean bM;
    private int bN;
    private boolean bO;
    private boolean bP;
    private int ba;
    private DisplayMetrics bb;
    private float bc;
    private float bd;
    private int be;
    private int bf;
    private int bg;
    private int bh;
    private NexTimelineItem bi;
    private boolean bj;
    private long bk;
    private float bl;
    private ArrayList<c> bm;
    private boolean bn;
    private com.nexstreaming.app.general.util.s bo;
    private boolean bp;
    private int bq;
    private boolean br;
    private boolean bs;
    private int bt;
    private NexTimelineItem bu;
    private boolean bv;
    private RectF bw;
    private Rect bx;
    private int by;
    private int bz;
    private OverScroller c;
    private ay d;
    private com.nexstreaming.kinemaster.mediaprep.a e;
    private MediaPrepManager f;
    private Path g;
    private Path h;
    private Runnable i;
    private Map<NexTimelineItem, Bitmap> j;
    private Map<Bitmap, Canvas> k;
    private f l;
    private h[] m;
    private List<com.nextreaming.nexeditorui.ef> n;
    private int o;
    private Bitmap p;
    private Bitmap q;
    private Canvas r;
    private Canvas s;
    private boolean t;
    private Point u;
    private Runnable v;
    private Runnable w;
    private int x;
    private Runnable y;
    private g z;

    /* loaded from: classes.dex */
    public enum AnimType {
        AddClip,
        DeleteClip
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public abstract void a(int i);

        public abstract void a(WhichTimeline whichTimeline, int i, int i2, NexTimelineItem nexTimelineItem);

        public abstract void a(boolean z);

        public abstract boolean a();

        public abstract boolean a(int i, int i2, NexPrimaryTimelineItem nexPrimaryTimelineItem);

        public abstract boolean a(int i, int i2, NexSecondaryTimelineItem nexSecondaryTimelineItem);

        public abstract boolean a(int i, boolean z);

        public abstract boolean a(WhichTimeline whichTimeline, int i, NexTimelineItem nexTimelineItem);

        public abstract boolean a(WhichTimeline whichTimeline, int i, NexTimelineItem nexTimelineItem, boolean z);

        public abstract void b();

        public abstract void b(boolean z);

        public abstract void c(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(Rect rect);
    }

    private void b(int i, boolean z) {
        this.c.forceFinished(true);
        if (z) {
            this.be = i;
            this.c.startScroll(this.aW, this.aY, this.be - this.aW, 0);
            postInvalidateOnAnimation();
        } else {
            this.aW = i;
            this.aD = j((getWidth() / 2) + i);
            invalidate();
        }
    }

    private void a(int i, int i2, boolean z) {
        this.c.forceFinished(true);
        if (z) {
            this.be = i;
            this.c.startScroll(this.aW, this.aY, this.be - this.aW, i2 - this.aY);
            postInvalidateOnAnimation();
        } else {
            this.aW = i;
            this.aY = i2;
            this.aD = j((getWidth() / 2) + i);
            invalidate();
        }
    }

    public int getMaxSimultaneousAudioTrackCount() {
        return this.bE;
    }

    public int a() {
        this.aD = j(this.aW + (getWidth() / 2));
        return this.aD;
    }

    public boolean getShowAutioTimeline() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).bottomMargin == 0;
    }

    public void setMediaPrepManager(MediaPrepManager mediaPrepManager) {
        this.f = mediaPrepManager;
    }

    public Rect a(WhichTimeline whichTimeline, int i) {
        a b2;
        if (whichTimeline == null || (b2 = b(whichTimeline.getInt(), i)) == null) {
            return null;
        }
        return new Rect((b2.f3748a + getLeft()) - this.aW, b2.c + getTop(), (b2.b + getLeft()) - this.aW, b2.d + getTop());
    }

    public Rect a(NexTimelineItem nexTimelineItem) {
        int indexOfSecondaryItem;
        if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
            int indexOfPrimaryItem = this.S.getIndexOfPrimaryItem((NexPrimaryTimelineItem) nexTimelineItem);
            if (indexOfPrimaryItem >= 0) {
                return a(WhichTimeline.PRIMARY, indexOfPrimaryItem);
            }
        } else if ((nexTimelineItem instanceof NexSecondaryTimelineItem) && (indexOfSecondaryItem = this.S.getIndexOfSecondaryItem((NexSecondaryTimelineItem) nexTimelineItem)) >= 0) {
            return a(WhichTimeline.SECONDARY, indexOfSecondaryItem);
        }
        return null;
    }

    public void a(int i) {
        this.y = null;
        this.be = i(i) - (getWidth() / 2);
        this.bf = i;
        this.c.startScroll(this.aW, this.aY, this.be - this.aW, 0);
        postInvalidateOnAnimation();
    }

    private float a(float f2) {
        return TypedValue.applyDimension(1, f2, this.bb);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.t
    public NexTimeline getTimeline() {
        if (this.S == null) {
            Log.w("NexTimelineView", "getTimeline returning NULL");
        }
        return this.S;
    }

    public void setTimeline(NexTimeline nexTimeline) {
        if (this.S != nexTimeline) {
            if (this.S != null) {
                this.S.unregisterTimeChangeCTSCallback(this);
            }
            this.S = nexTimeline;
            if (this.S != null) {
                this.S.registerTimeChangeCTSCallback(this);
            }
        }
        s();
        invalidate();
    }

    private void l() {
        this.d = new ay(getContext());
        this.c = new OverScroller(getContext());
        this.bF = getResources().getColor(R.color.timeline_bg_color);
        setLayerType(2, null);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        this.br = defaultSharedPreferences.getBoolean("show_cts_centisecond", false);
        this.bs = defaultSharedPreferences.getBoolean("show_timeline_content_weight", false);
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        this.bt = deviceProfile.getMaxCodecMemSizeForVideoLayers();
        NexExportProfile[] supportedExportProfiles = deviceProfile.getSupportedExportProfiles(EditorGlobal.a().i());
        int length = supportedExportProfiles.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            NexExportProfile nexExportProfile = supportedExportProfiles[i];
            int height = nexExportProfile.height() * nexExportProfile.width();
            if (height <= i2) {
                height = i2;
            }
            i++;
            i2 = height;
        }
        this.bt -= i2;
        this.bb = getResources().getDisplayMetrics();
        this.A = this.bb.density;
        this.B = this.A * 0.65f;
        this.F = new ScaleGestureDetector(getContext(), this);
        this.E = new com.nexstreaming.app.general.util.n(getContext(), this);
        this.E.a(getResources().getDimensionPixelSize(R.dimen.timeline3_touchSlop));
        this.aj = (WindowManager) getContext().getSystemService("window");
        Resources resources = getResources();
        this.G = resources.getDimensionPixelSize(R.dimen.timeline3_pixelsPerSecond);
        this.H = resources.getDimensionPixelOffset(R.dimen.timeline3_itemSpacing);
        this.I = resources.getDimensionPixelSize(R.dimen.timeline3_primaryTimelineHeight);
        this.J = resources.getDimensionPixelSize(R.dimen.timeline3_primaryTimelineMinHeight);
        this.K = resources.getDimensionPixelOffset(R.dimen.timeline3_topMargin);
        this.L = resources.getDimensionPixelOffset(R.dimen.timeline3_bottomMargin);
        this.M = resources.getDimensionPixelOffset(R.dimen.timeline3_timelineSpacing);
        this.N = resources.getDimensionPixelOffset(R.dimen.timeline3_audioTrackSpacing);
        this.O = resources.getDimensionPixelSize(R.dimen.timeline3_audioTrackHeight);
        this.P = resources.getDimensionPixelSize(R.dimen.timeline3_autoScrollMarginLeft);
        this.Q = resources.getDimensionPixelSize(R.dimen.timeline3_autoScrollMarginRight);
        this.R = resources.getInteger(R.integer.timeline3_collapsedVisibleSecondaryCount);
    }

    public void setListener(d dVar) {
        this.aC = dVar;
    }

    public int b() {
        return b(this.aD);
    }

    public int b(int i) {
        int primaryItemCount = this.S.getPrimaryItemCount();
        int i2 = 0;
        for (int i3 = 0; i3 < primaryItemCount; i3++) {
            int representedDuration = this.S.getPrimaryItem(i3).getRepresentedDuration();
            if (i >= (representedDuration / 2) + i2) {
                i2 += representedDuration;
            } else {
                return i3;
            }
        }
        return primaryItemCount;
    }

    public void a(int i, int i2) {
        b(true);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        removeCallbacks(this.i);
        post(this.i);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.c.abortAnimation();
        removeCallbacks(this.i);
        if (this.aP) {
            this.aj.removeView(this.ag);
            this.aP = false;
        }
        if (this.ah != null) {
            this.aj.removeView(this.ah);
            this.ah = null;
        }
        super.onDetachedFromWindow();
    }

    public TimelineView(Context context) {
        super(context);
        this.e = new com.nexstreaming.kinemaster.mediaprep.a();
        this.g = new Path();
        this.h = new Path();
        this.i = new lt(this);
        this.j = new WeakHashMap();
        this.k = new WeakHashMap();
        this.l = new f();
        this.m = new h[0];
        this.n = new ArrayList();
        this.t = false;
        this.u = new Point();
        this.v = new md(this);
        this.w = new me(this);
        this.x = Integer.MAX_VALUE;
        this.y = null;
        this.z = new g(this);
        this.A = 1.0f;
        this.B = 1.0f;
        this.C = new TextPaint();
        this.D = new RectF();
        this.E = null;
        this.F = null;
        this.G = 40.0f;
        this.H = 5;
        this.I = 100;
        this.J = 10;
        this.K = 5;
        this.L = 5;
        this.M = 5;
        this.N = 5;
        this.O = 40;
        this.S = new NexTimeline();
        this.U = false;
        this.V = false;
        this.W = false;
        this.aa = false;
        this.ab = false;
        this.ac = new a[16];
        this.ad = 0;
        this.ae = 0;
        this.af = 0;
        this.ak = null;
        this.al = null;
        this.am = null;
        this.an = 0;
        this.ao = 0;
        this.f3746a = null;
        this.ap = 0;
        this.aq = 0;
        this.ar = 0;
        this.au = 0;
        this.av = 0;
        this.aw = 0;
        this.ax = 0;
        this.ay = Integer.MAX_VALUE;
        this.az = 0;
        this.aA = false;
        this.aB = false;
        this.aC = null;
        this.aD = 0;
        this.aE = 0;
        this.aF = 0.0f;
        this.aG = 0.0f;
        this.aH = 0;
        this.aI = null;
        this.aJ = null;
        this.aK = false;
        this.aL = 0;
        this.aM = 0;
        this.aN = 0;
        this.aO = false;
        this.aP = false;
        this.aQ = 0;
        this.aR = 0;
        this.aS = 0;
        this.aT = false;
        this.aU = false;
        this.aV = false;
        this.aW = 0;
        this.aX = 0;
        this.aY = 0;
        this.aZ = 0;
        this.ba = 0;
        this.bc = 0.0f;
        this.bd = 0.0f;
        this.bf = -1;
        this.bg = 0;
        this.bh = 0;
        this.bi = null;
        this.bj = false;
        this.bk = 0L;
        this.bl = 0.0f;
        this.bm = new ArrayList<>();
        this.bn = false;
        this.bo = new com.nexstreaming.app.general.util.s("NexTimelineView_OnDraw", false);
        this.bp = false;
        this.bq = -1;
        this.bu = null;
        this.bv = false;
        this.bw = new RectF();
        this.bx = new Rect();
        this.b = new RectF();
        this.bA = 0.0f;
        this.bB = 0.0f;
        this.bD = false;
        this.bE = -1;
        this.bG = false;
        this.bP = false;
        l();
    }

    public TimelineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new com.nexstreaming.kinemaster.mediaprep.a();
        this.g = new Path();
        this.h = new Path();
        this.i = new lt(this);
        this.j = new WeakHashMap();
        this.k = new WeakHashMap();
        this.l = new f();
        this.m = new h[0];
        this.n = new ArrayList();
        this.t = false;
        this.u = new Point();
        this.v = new md(this);
        this.w = new me(this);
        this.x = Integer.MAX_VALUE;
        this.y = null;
        this.z = new g(this);
        this.A = 1.0f;
        this.B = 1.0f;
        this.C = new TextPaint();
        this.D = new RectF();
        this.E = null;
        this.F = null;
        this.G = 40.0f;
        this.H = 5;
        this.I = 100;
        this.J = 10;
        this.K = 5;
        this.L = 5;
        this.M = 5;
        this.N = 5;
        this.O = 40;
        this.S = new NexTimeline();
        this.U = false;
        this.V = false;
        this.W = false;
        this.aa = false;
        this.ab = false;
        this.ac = new a[16];
        this.ad = 0;
        this.ae = 0;
        this.af = 0;
        this.ak = null;
        this.al = null;
        this.am = null;
        this.an = 0;
        this.ao = 0;
        this.f3746a = null;
        this.ap = 0;
        this.aq = 0;
        this.ar = 0;
        this.au = 0;
        this.av = 0;
        this.aw = 0;
        this.ax = 0;
        this.ay = Integer.MAX_VALUE;
        this.az = 0;
        this.aA = false;
        this.aB = false;
        this.aC = null;
        this.aD = 0;
        this.aE = 0;
        this.aF = 0.0f;
        this.aG = 0.0f;
        this.aH = 0;
        this.aI = null;
        this.aJ = null;
        this.aK = false;
        this.aL = 0;
        this.aM = 0;
        this.aN = 0;
        this.aO = false;
        this.aP = false;
        this.aQ = 0;
        this.aR = 0;
        this.aS = 0;
        this.aT = false;
        this.aU = false;
        this.aV = false;
        this.aW = 0;
        this.aX = 0;
        this.aY = 0;
        this.aZ = 0;
        this.ba = 0;
        this.bc = 0.0f;
        this.bd = 0.0f;
        this.bf = -1;
        this.bg = 0;
        this.bh = 0;
        this.bi = null;
        this.bj = false;
        this.bk = 0L;
        this.bl = 0.0f;
        this.bm = new ArrayList<>();
        this.bn = false;
        this.bo = new com.nexstreaming.app.general.util.s("NexTimelineView_OnDraw", false);
        this.bp = false;
        this.bq = -1;
        this.bu = null;
        this.bv = false;
        this.bw = new RectF();
        this.bx = new Rect();
        this.b = new RectF();
        this.bA = 0.0f;
        this.bB = 0.0f;
        this.bD = false;
        this.bE = -1;
        this.bG = false;
        this.bP = false;
        l();
    }

    public TimelineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new com.nexstreaming.kinemaster.mediaprep.a();
        this.g = new Path();
        this.h = new Path();
        this.i = new lt(this);
        this.j = new WeakHashMap();
        this.k = new WeakHashMap();
        this.l = new f();
        this.m = new h[0];
        this.n = new ArrayList();
        this.t = false;
        this.u = new Point();
        this.v = new md(this);
        this.w = new me(this);
        this.x = Integer.MAX_VALUE;
        this.y = null;
        this.z = new g(this);
        this.A = 1.0f;
        this.B = 1.0f;
        this.C = new TextPaint();
        this.D = new RectF();
        this.E = null;
        this.F = null;
        this.G = 40.0f;
        this.H = 5;
        this.I = 100;
        this.J = 10;
        this.K = 5;
        this.L = 5;
        this.M = 5;
        this.N = 5;
        this.O = 40;
        this.S = new NexTimeline();
        this.U = false;
        this.V = false;
        this.W = false;
        this.aa = false;
        this.ab = false;
        this.ac = new a[16];
        this.ad = 0;
        this.ae = 0;
        this.af = 0;
        this.ak = null;
        this.al = null;
        this.am = null;
        this.an = 0;
        this.ao = 0;
        this.f3746a = null;
        this.ap = 0;
        this.aq = 0;
        this.ar = 0;
        this.au = 0;
        this.av = 0;
        this.aw = 0;
        this.ax = 0;
        this.ay = Integer.MAX_VALUE;
        this.az = 0;
        this.aA = false;
        this.aB = false;
        this.aC = null;
        this.aD = 0;
        this.aE = 0;
        this.aF = 0.0f;
        this.aG = 0.0f;
        this.aH = 0;
        this.aI = null;
        this.aJ = null;
        this.aK = false;
        this.aL = 0;
        this.aM = 0;
        this.aN = 0;
        this.aO = false;
        this.aP = false;
        this.aQ = 0;
        this.aR = 0;
        this.aS = 0;
        this.aT = false;
        this.aU = false;
        this.aV = false;
        this.aW = 0;
        this.aX = 0;
        this.aY = 0;
        this.aZ = 0;
        this.ba = 0;
        this.bc = 0.0f;
        this.bd = 0.0f;
        this.bf = -1;
        this.bg = 0;
        this.bh = 0;
        this.bi = null;
        this.bj = false;
        this.bk = 0L;
        this.bl = 0.0f;
        this.bm = new ArrayList<>();
        this.bn = false;
        this.bo = new com.nexstreaming.app.general.util.s("NexTimelineView_OnDraw", false);
        this.bp = false;
        this.bq = -1;
        this.bu = null;
        this.bv = false;
        this.bw = new RectF();
        this.bx = new Rect();
        this.b = new RectF();
        this.bA = 0.0f;
        this.bB = 0.0f;
        this.bD = false;
        this.bE = -1;
        this.bG = false;
        this.bP = false;
        l();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.t
    public int getCurrentTime() {
        return this.aD;
    }

    public int getCurrentTimeAndStopFling() {
        this.c.forceFinished(true);
        return this.aD;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime() - SystemClock.uptimeMillis();
        if (isEnabled()) {
            return a(motionEvent, false);
        }
        return false;
    }

    private boolean a(MotionEvent motionEvent, boolean z) {
        a c2;
        if (motionEvent.getActionMasked() == 0 && this.bu != null && (c2 = c(((int) motionEvent.getX()) + this.aW, ((int) motionEvent.getY()) + this.aY)) != null && c2.e == getSelectedTimelineInt() && c2.f == getSelectedIndex()) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            NexTimelineItem.i onDown = this.bu.onDown(getContext(), this, new RectF((c2.f3748a + r2) - this.aW, (c2.c + r5) - this.aY, (c2.b + r2) - this.aW, (c2.d + r5) - this.aY), (int) (iArr[0] + motionEvent.getX()), (int) (iArr[1] + motionEvent.getY()), getSelectedTimelineInt() == c2.e && getSelectedIndex() == c2.f, this.bg);
            if (onDown != null && (onDown instanceof NexTimelineItem.h)) {
                this.aF = motionEvent.getRawX();
                this.aG = motionEvent.getRawY();
                this.aI = this.bu;
                this.aJ = (NexTimelineItem.h) onDown;
                this.an = c2.f;
                if (this.bu instanceof NexPrimaryTimelineItem) {
                    this.f3746a = WhichTimeline.PRIMARY;
                } else {
                    this.f3746a = WhichTimeline.SECONDARY;
                }
                this.ab = true;
                this.x = Integer.MAX_VALUE;
                this.V = false;
                invalidate();
                return true;
            }
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.x = this.aW < this.ar + (-2) ? this.ar : this.aq;
            if (!this.ab) {
                this.V = true;
            }
        }
        this.F.onTouchEvent(motionEvent);
        this.E.a(motionEvent);
        switch (action) {
            case 0:
                this.U = false;
                if (!z && this.aC != null) {
                    this.U = this.aC.a();
                    break;
                }
                break;
            case 1:
                if (this.aA || this.aB) {
                    c(true);
                }
                this.V = false;
                this.aB = false;
                this.aA = false;
                b(false);
                this.aa = false;
                break;
            case 2:
                if (this.bf >= 0) {
                    this.bf = -1;
                }
                if (!z) {
                    f(motionEvent);
                    break;
                }
                break;
            case 3:
                this.V = false;
                b(true);
                break;
        }
        return true;
    }

    private void m() {
        this.ad = 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.t
    public void a(int i, boolean z) {
        this.y = null;
        if (z) {
            a(i);
        } else {
            c(i);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.t
    public void c(int i) {
        this.y = null;
        if (i < 0) {
            i = 0;
        }
        if ((!this.ab || this.aI != null) && !this.V) {
            this.aW = i(i) - (getWidth() / 2);
            this.aX = this.aW;
            c(true);
            this.aD = i;
            postInvalidateOnAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, RectF rectF, int i3, boolean z) {
        a(i, i2, (int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, i3, z);
    }

    private void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        a aVar;
        if (this.ad >= this.ac.length) {
            a[] aVarArr = new a[this.ac.length + 16];
            System.arraycopy(this.ac, 0, aVarArr, 0, this.ad);
            this.ac = aVarArr;
        }
        if (this.ac[this.ad] == null) {
            a[] aVarArr2 = this.ac;
            int i8 = this.ad;
            aVar = new a(this, null);
            aVarArr2[i8] = aVar;
        } else {
            aVar = this.ac[this.ad];
        }
        this.ad++;
        aVar.f3748a = i3;
        aVar.b = i5;
        aVar.c = i4;
        aVar.d = i6;
        aVar.e = i;
        aVar.f = i2;
        aVar.g = z;
    }

    private a b(int i, int i2) {
        for (int i3 = 0; i3 < this.ad; i3++) {
            a aVar = this.ac[i3];
            if (aVar.e == i && aVar.f == i2) {
                return aVar;
            }
        }
        return null;
    }

    private a c(int i, int i2) {
        a aVar = null;
        if (i2 - this.aY >= (this.K * 3) / 4) {
            if (i2 - this.aY < (this.K * 6) / 5) {
                i2 = ((this.K * 6) / 5) + this.aY;
            }
            int a2 = (int) a(6.0f);
            int i3 = 0;
            loop0: while (i3 < a2 * 2) {
                a aVar2 = aVar;
                for (int i4 = this.ad - 1; i4 >= 0; i4--) {
                    aVar = this.ac[i4];
                    if (aVar.g && this.bg != 0) {
                        int i5 = aVar.d - aVar.c;
                        if (i5 < 0) {
                            i5 = 0;
                        }
                        if (i >= aVar.f3748a - (i5 / 2)) {
                            if (i <= (i5 / 2) + aVar.b && i2 >= aVar.c && i2 <= aVar.d) {
                                break loop0;
                            }
                        } else {
                            continue;
                        }
                    } else if (i >= aVar.f3748a - i3 && i <= aVar.b + i3 && i2 >= aVar.c && i2 <= aVar.d) {
                        aVar2 = aVar;
                    }
                }
                i3 += a2;
                aVar = aVar2;
            }
        }
        return aVar;
    }

    private void a(Canvas canvas) {
        getWidth();
        canvas.drawColor(this.bF);
    }

    private void b(Canvas canvas) {
        this.C.reset();
        this.C.setColor(this.bF);
        this.C.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, 0.0f, getWidth(), (int) ((getResources().getDimension(R.dimen.timeline3_timescale_height) / (20.0f * this.A)) * 18.0f * this.A), this.C);
    }

    private void c(Canvas canvas) {
        if (this.bs) {
            int i = this.aR;
            int i2 = this.aS;
            int i3 = (i2 - i) / 200;
            int i4 = i3 < 33 ? 33 : i3;
            int i5 = this.bt;
            this.C.reset();
            int i6 = i - (i % i4);
            while (true) {
                int i7 = i6;
                if (i7 <= i2 + i4) {
                    int i8 = i(i7 - (i4 / 2));
                    int i9 = i((i4 / 2) + i7 + 1);
                    int decoderMemoryUsageAtTime = this.S.getDecoderMemoryUsageAtTime((i4 / 2) + i7);
                    if (decoderMemoryUsageAtTime <= i5) {
                        int i10 = ((decoderMemoryUsageAtTime * 230) / i5) + 25;
                        this.C.setColor(Color.rgb(i10, i10, 25));
                    } else {
                        int i11 = (((decoderMemoryUsageAtTime - i5) * 230) / (i5 * 4)) + 25;
                        if (i11 > 255) {
                            i11 = 255;
                        }
                        this.C.setColor(Color.rgb(255, i11, 255 - Math.min(i11 * 4, 255)));
                    }
                    canvas.drawRect(i8, 0.0f, i9, (int) (200.0f * this.A), this.C);
                    i(i7 + i4);
                    i6 = i7 + i4;
                } else {
                    return;
                }
            }
        }
    }

    private void d(Canvas canvas) {
        int i;
        int i2 = this.aR;
        int i3 = this.aS;
        if (i3 > Math.max(this.at, this.as)) {
            i3 = Math.max(this.at, this.as);
        }
        int color = getResources().getColor(R.color.timeline_scale_marks);
        int color2 = getResources().getColor(R.color.timeline_scale_numbers);
        this.C.reset();
        float dimension = getResources().getDimension(R.dimen.timeline3_timescale_height) / (20.0f * this.A);
        int i4 = (int) (((10.0f * this.A) * 1000.0f) / this.G);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        if (i4 < 33) {
            i = 33;
        } else if (i4 < 50) {
            i = 50;
            i5 = 60000;
            i7 = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
            i6 = 500;
            i8 = 250;
        } else if (i4 < 100) {
            i = 100;
            i5 = 60000;
            i7 = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
            i6 = 0;
            i8 = 500;
        } else if (i4 < 250) {
            i = 250;
            i5 = 60000;
            i7 = 2000;
            i6 = 0;
            i8 = 500;
        } else if (i4 < 500) {
            i = 500;
            i5 = 60000;
            i7 = LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT;
            i6 = 0;
            i8 = 2000;
        } else if (i4 < 1000) {
            i = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
            i5 = 60000;
            i7 = 5000;
            i6 = 0;
            i8 = 10000;
        } else if (i4 < 2500) {
            i = 2500;
            i5 = 60000;
            i7 = 5000;
            i6 = 0;
            i8 = 10000;
        } else if (i4 < 5000) {
            i = 5000;
            i5 = 60000;
            i7 = 0;
            i6 = 0;
            i8 = 10000;
        } else if (i4 < 10000) {
            i = 10000;
            i5 = 60000;
            i7 = 0;
            i6 = 0;
            i8 = 30000;
        } else if (i4 < 20000) {
            i = 20000;
            i5 = 60000;
        } else {
            i = 60000;
            i5 = 120000;
        }
        this.C.setStyle(Paint.Style.FILL);
        this.C.setAntiAlias(true);
        this.C.setStyle(Paint.Style.FILL);
        int i9 = i(i2 - (i2 % i));
        int i10 = i2 - (i2 % i);
        int i11 = i9;
        for (int i12 = i10; i12 < i3; i12 += i) {
            int i13 = i(i12 + i);
            if (i12 + i > i3 || i13 - i11 >= 60) {
                this.C.setColor(color);
                if (i12 > this.as) {
                    this.C.setAlpha(70);
                }
                if (i5 > 0 && i12 % i5 == 0) {
                    this.C.setColor(color2);
                    if (i12 > this.as) {
                        this.C.setAlpha(70);
                    }
                    this.C.setTextAlign(Paint.Align.CENTER);
                    this.C.setTextSize(11.0f * dimension * this.A);
                    this.C.setTypeface(Typeface.DEFAULT_BOLD);
                    canvas.drawText("" + (i12 / 60000) + ":00", i11, (int) (12.5d * dimension * this.A), this.C);
                    this.C.setTypeface(Typeface.DEFAULT);
                } else if (i7 > 0 && i12 % i7 == 0) {
                    this.C.setColor(color2);
                    if (i12 > this.as) {
                        this.C.setAlpha(70);
                    }
                    this.C.setTextAlign(Paint.Align.CENTER);
                    this.C.setTextSize(11.0f * dimension * this.A);
                    canvas.drawText("" + (i12 / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), i11, (int) (12.5d * dimension * this.A), this.C);
                } else if (i6 > 0 && i12 % i6 == 0) {
                    this.C.setColor(color2);
                    if (i12 > this.as) {
                        this.C.setAlpha(70);
                    }
                    this.C.setTextAlign(Paint.Align.CENTER);
                    this.C.setTextSize(8.0f * dimension * this.A);
                    canvas.drawText("" + (i12 / 1000.0d), i11, (int) (11.0f * dimension * this.A), this.C);
                } else if (i8 > 0 && i12 % i8 == 0) {
                    canvas.drawCircle(i11, (int) (9.0f * dimension * this.A), 1.5f * this.A, this.C);
                } else {
                    canvas.drawCircle(i11, (int) (9.0f * dimension * this.A), 1.5f * this.A, this.C);
                }
                i11 = i(i12);
            }
        }
    }

    private void e(Canvas canvas) {
        int i = 0;
        getResources().getColor(R.color.timeline_scale_bookmarks);
        int[] bookmarks = this.S.getBookmarks();
        Drawable drawable = null;
        int max = Math.max(1, getMSPerPixel() * 15);
        this.bG = false;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 : bookmarks) {
            if (i5 >= this.aR && i5 < this.aS) {
                if (Math.abs(i5 - this.aQ) < max) {
                    this.bG = true;
                }
                int i6 = i(i5);
                if (drawable == null) {
                    drawable = getResources().getDrawable(R.drawable.timeline_bookmark);
                    i4 = (-drawable.getIntrinsicWidth()) / 2;
                    i3 = i4 + drawable.getIntrinsicWidth();
                    i2 = getResources().getDimensionPixelOffset(R.dimen.timeline3_bookmarkTopMargin);
                    i = drawable.getIntrinsicHeight() + i2;
                }
                drawable.setBounds(i6 + i4, i2, i6 + i3, i);
                drawable.draw(canvas);
            }
        }
    }

    public int getMSPerPixel() {
        return Math.max(1, (int) ((1.0f / this.G) * 1000.0f));
    }

    public int c() {
        return Math.max(0, (int) (1000.0f / this.G));
    }

    public void b(NexTimelineItem nexTimelineItem) {
        this.j.remove(nexTimelineItem);
        invalidate();
    }

    @Override // com.nextreaming.nexeditorui.NexTimeline.b
    public int getCTSBeforeTimeChange() {
        return !this.c.isFinished() ? j(this.c.getFinalX()) : this.aD;
    }

    @Override // com.nextreaming.nexeditorui.NexTimeline.b
    public void d(int i) {
    }

    public void d() {
        int primaryItemCount = this.S.getPrimaryItemCount();
        if (primaryItemCount < 1) {
            a(0, true);
        } else if (getTimeline().getTotalTime() < getCurrentTime()) {
            a((NexTimelineItem) this.S.getPrimaryItem(primaryItemCount - 1), true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends b {

        /* renamed from: a, reason: collision with root package name */
        int f3751a;
        int b;
        int c;
        boolean d;
        boolean e;
        boolean g;
        int h;
        Canvas i;
        NexTimelineItem j;
        Bitmap k;
        com.nexstreaming.kinemaster.h.b l;
        private Rect n;
        private int o;
        private int p;
        private int q;
        private int r;
        private int s;
        private boolean t;

        f() {
            super();
            this.d = false;
            this.e = false;
            this.g = false;
            this.h = 0;
            this.j = null;
            this.k = null;
            this.n = new Rect();
            this.l = new com.nexstreaming.kinemaster.h.b();
        }

        public void c() {
            this.d = false;
            this.e = false;
            this.g = false;
            this.j = null;
            this.k = null;
            this.l.a();
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
        public void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
            boolean z2;
            Bitmap bitmap;
            Canvas canvas;
            Canvas canvas2;
            Bitmap bitmap2;
            if ((i3 > this.f3751a && i3 < this.c) || ((i3 + i4 > this.f3751a && i3 + i4 < this.c) || (i3 <= this.f3751a && i3 + i4 > this.f3751a))) {
                boolean z3 = TimelineView.this.getSelectedTimelineInt() == 1 && TimelineView.this.getSelectedIndex() == i;
                int max = Math.max(TimelineView.this.I - TimelineView.this.aY, TimelineView.this.J);
                TimelineView.this.bw.left = i3;
                TimelineView.this.bw.right = i3 + i4;
                TimelineView.this.bw.top = TimelineView.this.K;
                TimelineView.this.bw.bottom = max + TimelineView.this.K;
                TimelineView.this.bw.offset(0.0f, TimelineView.this.aY);
                if (z3) {
                    TimelineView.this.a(1, i, TimelineView.this.bw, 0, true);
                } else {
                    TimelineView.this.a(1, i, TimelineView.this.bw, 0, false);
                }
            }
            if ((i3 > this.b && i3 < this.c) || ((i3 + i4 > this.b && i3 + i4 < this.c) || (i3 <= this.b && i3 + i4 > this.b))) {
                boolean z4 = TimelineView.this.getSelectedTimelineInt() == 1 && TimelineView.this.getSelectedIndex() == i;
                int max2 = Math.max(TimelineView.this.I - TimelineView.this.aY, TimelineView.this.J);
                TimelineView.this.bw.left = i3;
                TimelineView.this.bw.right = i3 + i4;
                TimelineView.this.bw.top = TimelineView.this.K;
                TimelineView.this.bw.bottom = max2 + TimelineView.this.K;
                TimelineView.this.bw.offset(0.0f, TimelineView.this.aY);
                TimelineView.this.bw.offset(0.0f, -TimelineView.this.aY);
                TimelineView.this.bx.set((int) ((TimelineView.this.by + TimelineView.this.bw.left) - TimelineView.this.aW), (int) (TimelineView.this.bz + TimelineView.this.bw.top), (int) ((TimelineView.this.by + TimelineView.this.bw.right) - TimelineView.this.aW), (int) (TimelineView.this.bz + TimelineView.this.bw.bottom));
                if (TimelineView.this.aJ != null && TimelineView.this.aK && TimelineView.this.aI == nexTimelineItem) {
                    TimelineView.this.aK = false;
                    nexTimelineItem.onCustomPostDrag_v3(TimelineView.this.aJ, TimelineView.this.bx);
                }
                if (z4 && (nexTimelineItem instanceof NexVideoClipItem)) {
                    int startOverlap = ((NexVideoClipItem) nexTimelineItem).getStartOverlap();
                    int endOverlap = ((NexVideoClipItem) nexTimelineItem).getEndOverlap();
                    int trimTimeStart = ((NexVideoClipItem) nexTimelineItem).getTrimTimeStart();
                    int playbackSpeed = ((NexVideoClipItem) nexTimelineItem).getPlaybackSpeed();
                    int absStartTime = TimelineView.this.aQ - nexTimelineItem.getAbsStartTime();
                    int snapToIFrame = ((((NexVideoClipItem) nexTimelineItem).snapToIFrame(((absStartTime * playbackSpeed) / 100) + trimTimeStart) - trimTimeStart) * 100) / playbackSpeed;
                    int absStartTime2 = nexTimelineItem.getAbsStartTime() + snapToIFrame;
                    if (absStartTime2 >= nexTimelineItem.getAbsStartTime() + startOverlap + (Math.max(10, TimelineView.this.c()) * 2) && absStartTime2 <= nexTimelineItem.getAbsEndTime() - Math.max(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, endOverlap)) {
                        this.d = true;
                    }
                    if (TimelineView.this.aQ < (nexTimelineItem.getAbsEndTime() - (Math.max(17, TimelineView.this.c()) * 2)) - 1 && TimelineView.this.aQ >= nexTimelineItem.getAbsStartTime() + Math.max(startOverlap + 10, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED)) {
                        this.e = true;
                    }
                    if (absStartTime2 >= Math.max(startOverlap + 10, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) + nexTimelineItem.getAbsStartTime() && absStartTime2 <= nexTimelineItem.getAbsEndTime() - Math.max(endOverlap + 10, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED)) {
                        this.g = true;
                    }
                    if ((Math.abs(absStartTime - snapToIFrame) * 100) / ((NexVideoClipItem) nexTimelineItem).getPlaybackSpeed() > 2000) {
                        this.d = false;
                        this.g = false;
                    }
                    if (absStartTime < 30) {
                        this.d = false;
                    }
                    nexTimelineItem.getDuration();
                }
                if (!this.i.quickReject(TimelineView.this.bw, Canvas.EdgeType.AA)) {
                    int width = (int) TimelineView.this.bw.width();
                    int height = (int) TimelineView.this.bw.height();
                    int min = Math.min(2000, this.i.getMaximumBitmapWidth());
                    a(nexTimelineItem);
                    boolean z5 = this.p != 0 || this.t;
                    if ((!z4 || z5) && width <= min) {
                        Bitmap bitmap3 = (Bitmap) TimelineView.this.j.get(nexTimelineItem);
                        if (bitmap3 != null && bitmap3.getWidth() == width && bitmap3.getHeight() == height) {
                            bitmap = bitmap3;
                            z2 = false;
                        } else {
                            z2 = true;
                            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                            TimelineView.this.j.put(nexTimelineItem, createBitmap);
                            bitmap = createBitmap;
                        }
                        if (z2) {
                            Canvas canvas3 = (Canvas) TimelineView.this.k.get(bitmap);
                            if (canvas3 == null) {
                                canvas = new Canvas(bitmap);
                                TimelineView.this.k.put(bitmap, canvas);
                            } else {
                                canvas = canvas3;
                            }
                            canvas.setBitmap(bitmap);
                            float f = TimelineView.this.bw.left;
                            float f2 = TimelineView.this.bw.top;
                            TimelineView.this.bw.offsetTo(0.0f, 0.0f);
                            TimelineView.this.D.setEmpty();
                            TimelineView.this.C.reset();
                            TimelineView.this.d.a(canvas, TimelineView.this.bw, TimelineView.this.D, TimelineView.this.C, z4, false, TimelineView.this.aJ, false, TimelineView.this.bw.right, TimelineView.this.bg, 0, null, TimelineView.this.z, nexTimelineItem);
                            int save = canvas.save();
                            nexTimelineItem.onDraw(TimelineView.this.d);
                            canvas.restoreToCount(save);
                            canvas.setBitmap(null);
                            TimelineView.this.bw.offsetTo(f, f2);
                        }
                        if (z4) {
                            this.k = bitmap;
                            this.j = nexTimelineItem;
                            TimelineView.this.b.set(TimelineView.this.bw);
                            return;
                        }
                        a(nexTimelineItem, bitmap, z);
                        return;
                    }
                    if (z4) {
                        this.k = null;
                        this.j = nexTimelineItem;
                        TimelineView.this.b.set(TimelineView.this.bw);
                        return;
                    }
                    if (this.i.isHardwareAccelerated()) {
                        b.a a2 = this.l.a(TimelineView.this.getWidth(), TimelineView.this.getHeight());
                        canvas2 = a2.b;
                        Bitmap bitmap4 = a2.f3393a;
                        bitmap4.eraseColor(0);
                        bitmap2 = bitmap4;
                    } else {
                        canvas2 = this.i;
                        bitmap2 = null;
                    }
                    float f3 = TimelineView.this.bw.left;
                    float f4 = TimelineView.this.bw.top;
                    int save2 = canvas2.save();
                    if (bitmap2 != null) {
                        canvas2.translate(-TimelineView.this.aW, 0.0f);
                    }
                    canvas2.clipRect(TimelineView.this.bw);
                    canvas2.translate(TimelineView.this.bw.left, TimelineView.this.bw.top);
                    TimelineView.this.bw.offsetTo(0.0f, 0.0f);
                    TimelineView.this.D.setEmpty();
                    TimelineView.this.C.reset();
                    TimelineView.this.d.a(canvas2, TimelineView.this.bw, TimelineView.this.D, TimelineView.this.C, z4, false, TimelineView.this.aJ, false, TimelineView.this.bw.right, TimelineView.this.bg, 0, null, TimelineView.this.z, nexTimelineItem);
                    nexTimelineItem.onDraw(TimelineView.this.d);
                    canvas2.restoreToCount(save2);
                    TimelineView.this.bw.offsetTo(f3, f4);
                    if (bitmap2 != null) {
                        this.i.drawBitmap(bitmap2, TimelineView.this.aW, 0.0f, (Paint) null);
                    }
                }
            }
        }

        private void a(NexTimelineItem nexTimelineItem) {
            MSID mediaMSID;
            this.o = 255;
            this.p = 0;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = false;
            if (TimelineView.this.f != null && (mediaMSID = nexTimelineItem.getMediaMSID()) != null) {
                TimelineView.this.f.a(mediaMSID, TimelineView.this.e);
                if (TimelineView.this.e.f3523a != null) {
                    switch (TimelineView.this.e.f3523a) {
                        case Busy:
                            this.o = 70;
                            this.p = R.drawable.clip_status_busy;
                            return;
                        case FailedPermanent:
                        case FailNotSupported:
                        case FailDownload:
                        case FailTranscoding:
                        case FailedCanRetry:
                            this.o = 70;
                            this.p = R.drawable.clip_status_notsupport;
                            return;
                        case UserInterventionCancel:
                        case UserInterventionRequired:
                        case Unknown:
                            this.o = 70;
                            return;
                        case Downloading:
                            this.o = 70;
                            this.t = true;
                            this.s = (TimelineView.this.e.b * 360) / TimelineView.this.e.c;
                            this.p = R.drawable.clip_status_downloading;
                            this.q = TimelineView.this.getResources().getColor(R.color.timeline_progress_download_bg);
                            this.r = TimelineView.this.getResources().getColor(R.color.timeline_progress_download_fg);
                            return;
                        case Transcoding:
                            this.o = 70;
                            this.t = true;
                            this.s = (TimelineView.this.e.b * 360) / TimelineView.this.e.c;
                            this.p = R.drawable.clip_status_transcoding;
                            this.q = TimelineView.this.getResources().getColor(R.color.timeline_progress_transcode_bg);
                            this.r = TimelineView.this.getResources().getColor(R.color.timeline_progress_transcode_fg);
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        private void b(NexTimelineItem nexTimelineItem) {
            if (this.p != 0 || this.t) {
                int dimensionPixelOffset = TimelineView.this.getResources().getDimensionPixelOffset(R.dimen.timeline3_itemPrepStatusInset);
                float dimensionPixelOffset2 = TimelineView.this.getResources().getDimensionPixelOffset(R.dimen.timeline3_itemCornerRadius);
                TimelineView.this.bw.inset(dimensionPixelOffset, dimensionPixelOffset);
                if (this.t) {
                    TimelineView.this.C.setStyle(Paint.Style.FILL);
                    TimelineView.this.C.setColor(this.r);
                    TimelineView.this.C.setAntiAlias(true);
                    if (Build.VERSION.SDK_INT >= 19) {
                        TimelineView.this.g.rewind();
                        TimelineView.this.g.addRect(TimelineView.this.bw.left, TimelineView.this.bw.top, TimelineView.this.bw.left + ((TimelineView.this.bw.width() * this.s) / 360.0f), TimelineView.this.bw.bottom, Path.Direction.CCW);
                        TimelineView.this.h.rewind();
                        TimelineView.this.h.addRoundRect(TimelineView.this.bw, dimensionPixelOffset2, dimensionPixelOffset2, Path.Direction.CCW);
                        TimelineView.this.g.op(TimelineView.this.h, Path.Op.INTERSECT);
                        this.i.drawPath(TimelineView.this.g, TimelineView.this.C);
                    } else {
                        TimelineView.this.D.set(TimelineView.this.bw.left, TimelineView.this.bw.top, TimelineView.this.bw.left + ((TimelineView.this.bw.width() * this.s) / 360.0f), TimelineView.this.bw.bottom);
                        this.i.drawRoundRect(TimelineView.this.D, dimensionPixelOffset2, dimensionPixelOffset2, TimelineView.this.C);
                    }
                }
                if (this.p != 0) {
                    Drawable drawable = TimelineView.this.getResources().getDrawable(this.p);
                    int centerX = (int) TimelineView.this.bw.centerX();
                    int centerY = (int) TimelineView.this.bw.centerY();
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    int i = centerX - (intrinsicWidth / 2);
                    int i2 = centerY - (intrinsicHeight / 2);
                    drawable.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
                    drawable.draw(this.i);
                }
            }
        }

        private void a(NexTimelineItem nexTimelineItem, Bitmap bitmap, boolean z) {
            TextPaint textPaint = null;
            float f = TimelineView.this.bw.left;
            float f2 = TimelineView.this.bw.top;
            TimelineView.this.bw.offsetTo(0.0f, 0.0f);
            if (TimelineView.this.bI != null && TimelineView.this.bI == nexTimelineItem && TimelineView.this.bJ < 0.995f && TimelineView.this.bL != null && TimelineView.this.bL.hasStarted()) {
                this.i.save();
                switch (TimelineView.this.bK) {
                    case AddClip:
                        float max = Math.max(1.0E-4f, TimelineView.this.bJ);
                        this.i.scale(max, max, (bitmap.getWidth() / 2) + f, (bitmap.getHeight() / 2) + f2);
                        textPaint = TimelineView.this.C;
                        textPaint.setAlpha((((int) (max * 255.0f)) * this.o) / 255);
                        break;
                    case DeleteClip:
                        float max2 = Math.max(1.0E-4f, 1.0f - TimelineView.this.bJ);
                        this.i.scale(max2, max2, (bitmap.getWidth() / 2) + f, (bitmap.getHeight() / 2) + f2);
                        textPaint = TimelineView.this.C;
                        textPaint.setAlpha((((int) (max2 * 255.0f)) * this.o) / 255);
                        break;
                }
                this.i.drawBitmap(bitmap, f, f2, textPaint);
                this.i.restore();
            } else if (z) {
                TimelineView.this.C.reset();
                TimelineView.this.C.setAlpha((this.o * 65) / 255);
                this.i.drawBitmap(bitmap, f, f2, TimelineView.this.C);
            } else if (this.o < 255) {
                TimelineView.this.C.reset();
                TimelineView.this.C.setAlpha(this.o);
                this.i.drawBitmap(bitmap, f, f2, TimelineView.this.C);
            } else {
                this.i.drawBitmap(bitmap, f, f2, (Paint) null);
            }
            TimelineView.this.bw.offsetTo(f, f2);
            b(nexTimelineItem);
        }

        void d() {
            if (this.j != null && this.k != null) {
                a(this.j);
                TimelineView.this.bw.set(TimelineView.this.b);
                a(this.j, this.k, false);
                TimelineView.this.bw.set(TimelineView.this.b);
                Drawable drawable = TimelineView.this.getResources().getDrawable(R.drawable.timeline_item_border_sel);
                drawable.getPadding(this.n);
                drawable.setBounds((int) TimelineView.this.bw.left, (int) TimelineView.this.bw.top, (int) TimelineView.this.bw.right, (int) TimelineView.this.bw.bottom);
                drawable.draw(this.i);
                return;
            }
            if (this.j != null) {
                TimelineView.this.bw.set(TimelineView.this.b);
                this.i.save();
                this.i.clipRect(TimelineView.this.bw);
                this.i.translate(TimelineView.this.bw.left, TimelineView.this.bw.top);
                TimelineView.this.bw.offsetTo(0.0f, 0.0f);
                TimelineView.this.D.setEmpty();
                TimelineView.this.C.reset();
                TimelineView.this.d.a(this.i, TimelineView.this.bw, TimelineView.this.D, TimelineView.this.C, true, false, TimelineView.this.aJ, false, TimelineView.this.bw.right, TimelineView.this.bg, 0, null, TimelineView.this.z, this.j);
                this.j.onDraw(TimelineView.this.d);
                this.i.restore();
            }
        }
    }

    private void f(Canvas canvas) {
        this.C.reset();
        this.C.setColor(this.bF);
        this.C.setStyle(Paint.Style.FILL);
        canvas.drawRect(this.aW + 0, this.K, getWidth() + this.aW, Math.max(this.I - this.aY, this.J) + this.K, this.C);
        this.l.c();
        this.l.b = this.aW;
        this.l.f3751a = this.aX;
        Log.d("NexTimelineView", "m_primaryItemDrawingCB.minX=" + this.l.b);
        this.l.c = this.l.b + getWidth();
        this.l.i = canvas;
        a(this.l);
        this.l.d();
        this.l.i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
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
                if (nexAudioClipItem.isBGM() || nexAudioClipItem.isLegacyBGMusic()) {
                    return BGM;
                }
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
    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        int f3753a;
        TrackType b;

        private h() {
            this.f3753a = 0;
            this.b = null;
        }

        /* synthetic */ h(lt ltVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f3753a = 0;
            this.b = null;
        }
    }

    private void e(int i) {
        int length = this.m.length;
        if (i > length) {
            this.m = (h[]) Arrays.copyOf(this.m, i);
            for (int i2 = length; i2 < i; i2++) {
                this.m[i2] = new h(null);
            }
        }
    }

    private void n() {
        this.bE = 0;
        for (h hVar : this.m) {
            hVar.a();
        }
    }

    private void a(int i, TrackType trackType) {
        if (i + 1 > this.m.length) {
            e(i + 1);
        }
        this.m[i].b = trackType;
        if (i + 1 > this.bE) {
            this.bE = i + 1;
        }
    }

    private TrackType f(int i) {
        if (i < 0 || i + 1 > this.bE) {
            return null;
        }
        return this.m[i].b;
    }

    private int g(int i) {
        if (i < 0 || i + 1 > this.bE) {
            return 0;
        }
        return this.m[i].f3753a;
    }

    private int b(int i, TrackType trackType) {
        if (i < 0 || i + 1 > this.bE) {
            return 0;
        }
        if (this.m[i].b == trackType) {
            return this.m[i].f3753a;
        }
        return Integer.MAX_VALUE;
    }

    private void d(int i, int i2) {
        if (i + 1 > this.m.length) {
            e(i + 1);
        }
        this.m[i].f3753a = i2;
        if (i + 1 > this.bE) {
            this.bE = i + 1;
        }
    }

    private void a(int i, int i2, TrackType trackType) {
        if (i + 1 > this.m.length) {
            e(i + 1);
        }
        if (this.m[i].b != null && this.m[i].b != trackType) {
            throw new IllegalArgumentException("Attempt to set track type " + (trackType == null ? "null" : trackType.name()) + " for track that already has type " + this.m[i].b.name());
        }
        this.m[i].f3753a = i2;
        this.m[i].b = trackType;
        if (i + 1 > this.bE) {
            this.bE = i + 1;
        }
    }

    public void e() {
        this.j.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(android.graphics.Canvas r22) {
        /*
            Method dump skipped, instructions count: 1044
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.TimelineView.g(android.graphics.Canvas):void");
    }

    private int h(int i) {
        return i;
    }

    private void a(Canvas canvas, NexSecondaryTimelineItem nexSecondaryTimelineItem, int i, int i2, int i3, int i4, int i5) {
        boolean z;
        Bitmap createBitmap;
        boolean z2 = this.ab && this.al == nexSecondaryTimelineItem && this.aJ == null;
        boolean z3 = this.bu == nexSecondaryTimelineItem;
        float i6 = i(i4);
        if (i4 > i5) {
        }
        this.bw.left = i(i3);
        this.bw.top = this.K + this.I + this.M + ((this.O + this.N) * i2);
        this.bw.bottom = this.bw.top + this.O;
        this.bw.right = i6;
        a(2, i, this.bw, i2, z3);
        this.bx.set((int) ((this.by + this.bw.left) - this.aW), (int) (this.bz + this.bw.top), (int) ((this.by + this.bw.right) - this.aW), (int) (this.bz + this.bw.bottom));
        if (this.aJ != null && this.aK && this.aI == nexSecondaryTimelineItem) {
            this.aK = false;
            nexSecondaryTimelineItem.onCustomPostDrag_v3(this.aJ, this.bx);
        }
        if (!canvas.quickReject(this.bw, Canvas.EdgeType.AA)) {
            int width = (int) this.bw.width();
            int height = (int) this.bw.height();
            if (width >= 1 && height >= 1) {
                if (!z3 && !z2 && width < canvas.getMaximumBitmapWidth()) {
                    Bitmap bitmap = this.j.get(nexSecondaryTimelineItem);
                    if (bitmap != null && bitmap.getWidth() == width) {
                        createBitmap = bitmap;
                        z = false;
                    } else {
                        z = true;
                        createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                        this.j.put(nexSecondaryTimelineItem, createBitmap);
                    }
                    float f2 = this.bw.left;
                    float f3 = this.bw.top;
                    if (z) {
                        Canvas canvas2 = new Canvas(createBitmap);
                        List<com.nextreaming.nexeditorui.ef> list = this.n;
                        list.clear();
                        list.add(new com.nextreaming.nexeditorui.ef(0, 0));
                        a(new lx(this, i3, (int) this.bw.width(), nexSecondaryTimelineItem.getDuration(), list));
                        list.add(new com.nextreaming.nexeditorui.ef(nexSecondaryTimelineItem.getDuration(), (int) this.bw.width()));
                        float f4 = i6 - this.bw.left;
                        this.bw.right = i6;
                        this.bw.offsetTo(0.0f, 0.0f);
                        this.D.setEmpty();
                        this.C.reset();
                        if (z2) {
                            this.C.setStyle(Paint.Style.STROKE);
                            this.C.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f), new CornerPathEffect(5.0f)));
                            this.C.setColor(-5592406);
                        }
                        int i7 = 0;
                        if (this.bj && this.bi == nexSecondaryTimelineItem) {
                            i7 = (int) (255.0f * this.bl);
                        }
                        if (!z2) {
                            this.d.a(canvas2, this.bw, this.D, this.C, z3, z2, this.aJ, false, f4, this.bg, i7, list, this.z, nexSecondaryTimelineItem);
                            nexSecondaryTimelineItem.onDraw(this.d);
                        } else {
                            this.C.setStyle(Paint.Style.STROKE);
                            this.C.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f), new CornerPathEffect(5.0f)));
                            this.C.setColor(-5592406);
                            this.d.a(canvas2, this.bw, this.D, this.C, z3, true, this.aJ, false, f4, this.bg, i7, list, this.z, nexSecondaryTimelineItem);
                            nexSecondaryTimelineItem.onDraw(this.d);
                        }
                    }
                    if (this.bI != null && this.bI == nexSecondaryTimelineItem && this.bJ < 0.995f && this.bL != null && this.bL.hasStarted()) {
                        canvas.save();
                        TextPaint textPaint = null;
                        switch (this.bK) {
                            case AddClip:
                                float max = Math.max(1.0E-4f, this.bJ);
                                canvas.scale(max, max, (createBitmap.getWidth() / 2) + f2, (createBitmap.getHeight() / 2) + f3);
                                textPaint = this.C;
                                textPaint.setAlpha((int) (max * 255.0f));
                                break;
                            case DeleteClip:
                                float max2 = Math.max(1.0E-4f, 1.0f - this.bJ);
                                canvas.scale(max2, max2, (createBitmap.getWidth() / 2) + f2, (createBitmap.getHeight() / 2) + f3);
                                textPaint = this.C;
                                textPaint.setAlpha((int) (max2 * 255.0f));
                                break;
                        }
                        canvas.drawBitmap(createBitmap, f2, f3, textPaint);
                        canvas.restore();
                        return;
                    }
                    canvas.drawBitmap(createBitmap, f2, f3, (Paint) null);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.nextreaming.nexeditorui.ef(0, 0));
                a(new ly(this, i3, (int) this.bw.width(), nexSecondaryTimelineItem.getDuration(), arrayList));
                arrayList.add(new com.nextreaming.nexeditorui.ef(nexSecondaryTimelineItem.getDuration(), (int) this.bw.width()));
                if (z2 && !this.bH) {
                    canvas.saveLayerAlpha(this.bw, 40, 31);
                } else {
                    canvas.save();
                }
                canvas.clipRect(this.bw);
                canvas.translate(this.bw.left, this.bw.top);
                float f5 = i6 - this.bw.left;
                this.bw.right = i6;
                this.bw.offsetTo(0.0f, 0.0f);
                this.D.setEmpty();
                this.C.reset();
                if (z2) {
                    this.C.setStyle(Paint.Style.STROKE);
                    this.C.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f), new CornerPathEffect(5.0f)));
                    this.C.setColor(-5592406);
                }
                int i8 = 0;
                if (this.bj && this.bi == nexSecondaryTimelineItem) {
                    i8 = (int) (255.0f * this.bl);
                }
                if (!z2) {
                    this.d.a(canvas, this.bw, this.D, this.C, z3, z2, this.aJ, false, f5, this.bg, i8, arrayList, this.z, nexSecondaryTimelineItem);
                    nexSecondaryTimelineItem.onDraw(this.d);
                } else {
                    this.C.setStyle(Paint.Style.STROKE);
                    this.C.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f), new CornerPathEffect(5.0f)));
                    this.C.setColor(-5592406);
                    this.d.a(canvas, this.bw, this.D, this.C, z3, true, this.aJ, false, f5, this.bg, i8, arrayList, this.z, nexSecondaryTimelineItem);
                    nexSecondaryTimelineItem.onDraw(this.d);
                }
                canvas.restore();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0185 A[LOOP:0: B:32:0x0183->B:33:0x0185, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h(android.graphics.Canvas r14) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.TimelineView.h(android.graphics.Canvas):void");
    }

    private void i(Canvas canvas) {
        Drawable drawable = getResources().getDrawable(R.drawable.timeline_total_time_bg);
        int width = getWidth();
        int i = this.aW;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.timeline3_ctsBoxWidth);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.timeline3_ctsBoxHeight);
        int i2 = (width - dimensionPixelOffset) + i;
        int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(R.dimen.timeline3_ctsBoxTopMargin);
        drawable.setBounds(i2, dimensionPixelOffset3, i2 + dimensionPixelOffset, dimensionPixelOffset3 + dimensionPixelOffset2);
        drawable.draw(canvas);
        this.C.setTextAlign(Paint.Align.CENTER);
        this.C.setTextSize(getResources().getDimensionPixelSize(R.dimen.timeline3_ctsTextSize));
        this.C.setTypeface(Typeface.DEFAULT);
        String a2 = com.nexstreaming.kinemaster.h.e.a(getTimeline().getTotalTime());
        this.C.setColor(-1);
        canvas.drawText(a2, i2 + (dimensionPixelOffset / 2), (dimensionPixelOffset3 + dimensionPixelOffset2) - ((int) (3.5d * this.A)), this.C);
    }

    private void j(Canvas canvas) {
    }

    private void o() {
        if (this.aT != this.l.g) {
            this.aT = this.l.g;
            if (this.aC != null) {
                this.aC.a(this.aT);
            }
        }
        if (this.aU != this.l.d) {
            this.aU = this.l.d;
            if (this.aC != null) {
                this.aC.b(this.aU);
            }
        }
        if (this.aV != this.l.e) {
            this.aV = this.l.e;
            if (this.aC != null) {
                this.aC.c(this.aV);
            }
        }
        if (this.aC != null) {
            this.aC.a(this.l.h);
        }
        if (this.bu instanceof NexSecondaryTimelineItem) {
            boolean w = w();
            if (w != this.aT) {
                this.aT = w;
                if (this.aC != null) {
                    this.aC.a(this.aT);
                }
            }
            boolean u = u();
            if (u != this.aU) {
                this.aU = u;
                if (this.aC != null) {
                    this.aC.b(this.aU);
                }
            }
            boolean v = v();
            if (v != this.aV) {
                this.aV = v;
                if (this.aC != null) {
                    this.aC.c(this.aV);
                }
            }
        }
    }

    private void k(Canvas canvas) {
        if (this.aO) {
            this.D.left = i(this.aM);
            this.D.right = i(this.aN);
            this.D.top = 15.0f * this.A;
            this.D.bottom = getHeight();
            this.C.reset();
            this.C.setColor(getResources().getColor(R.color.timeline_recording_color));
            canvas.drawRect(this.D, this.C);
            this.D.left = i(this.aL);
            this.D.right = i(this.aM);
            this.C.setColor(getResources().getColor(R.color.timeline_recording_color));
            canvas.drawRect(this.D, this.C);
        }
    }

    public void f() {
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.o = -1;
    }

    public boolean getPlaying() {
        return this.bO;
    }

    public void setPlaying(boolean z) {
        if (this.bO != z) {
            this.bO = z;
            f();
        }
    }

    public void setExpandingAnimation(boolean z) {
        if (this.bP != z) {
            this.bP = z;
            f();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (!this.bO) {
            s();
        }
        if (this.aW < 0) {
            this.aW = 0;
        }
        if (this.aW > this.aq) {
            this.aW = this.aq;
        }
        this.aQ = j(this.aW + (width / 2));
        this.aR = j(this.aW);
        this.aS = j(this.aW + width);
        if (this.bO && !this.bP) {
            if (this.p == null || this.q == null) {
                this.p = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.q = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.r = new Canvas(this.p);
                this.s = new Canvas(this.q);
            }
            if (this.o < 0) {
                this.o = this.aW;
                a(this.r, false, this.o);
                a(this.s, false, this.o + width);
            } else if (this.aW - this.o > width) {
                Bitmap bitmap = this.p;
                this.p = this.q;
                this.q = bitmap;
                Canvas canvas2 = this.r;
                this.r = this.s;
                this.s = canvas2;
                this.o += width;
                a(this.s, false, this.o + width);
            }
            canvas.drawBitmap(this.p, this.o - this.aW, 0.0f, (Paint) null);
            canvas.drawBitmap(this.q, width + (this.o - this.aW), 0.0f, (Paint) null);
            canvas.save();
            canvas.translate(-this.aW, 0.0f);
            k(canvas);
            d(canvas);
            e(canvas);
            if (this.aI == null) {
                h(canvas);
            }
            i(canvas);
            j(canvas);
            canvas.restore();
            return;
        }
        a(canvas, true);
    }

    protected void a(Canvas canvas, boolean z, int i) {
        int i2 = this.aW;
        this.aX = this.aW;
        this.aW = i;
        a(canvas, z);
        this.aW = i2;
    }

    protected void a(Canvas canvas, boolean z) {
        this.bo.a();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.by = iArr[0];
        this.bz = iArr[1];
        if (z) {
            p();
        }
        this.bo.a(1);
        m();
        this.C.reset();
        a(canvas);
        canvas.save();
        canvas.translate(-this.aW, 0.0f);
        c(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(-this.aW, -this.aY);
        g(canvas);
        canvas.restore();
        b(canvas);
        canvas.save();
        canvas.translate(-this.aW, 0.0f);
        f(canvas);
        o();
        if (z) {
            k(canvas);
            d(canvas);
            e(canvas);
            if (this.aI == null) {
                h(canvas);
            }
            i(canvas);
            j(canvas);
        }
        canvas.restore();
        r();
        this.bo.a(2);
    }

    private void p() {
        boolean z = true;
        if (this.y != null) {
            this.y.run();
        }
        boolean z2 = this.bj && q();
        boolean z3 = this.t;
        this.t = this.c.computeScrollOffset();
        if (this.t) {
            this.aW = this.c.getCurrX();
            this.aY = this.c.getCurrY();
            post(this.w);
        } else if (!this.bn || this.bf > 0) {
            post(this.w);
            z = z2;
        } else if (this.ab && this.bA != 0.0f) {
            long nanoTime = System.nanoTime();
            int min = (int) ((this.bA * ((float) Math.min(this.bC - nanoTime, 100000000L))) / 3.0E7f);
            if (min != 0) {
                this.aW = Math.max(getMinScrollX(), Math.min(getMaxScrollX(), min + this.aW));
                this.bC = nanoTime;
            }
        } else if (!this.c.isFinished() || this.aY <= getMaxScrollY()) {
            z = z2;
        } else {
            this.c.startScroll(this.aW, this.aY, 0, getMaxScrollY() - this.aY);
        }
        if (z) {
            postInvalidateOnAnimation();
        } else if (z3) {
            post(this.v);
            postInvalidateOnAnimation();
        }
        this.aX = this.aW;
    }

    private boolean q() {
        long nanoTime = (System.nanoTime() / 1000000) - this.bk;
        if (nanoTime < 0) {
            return true;
        }
        if (nanoTime > 750) {
            this.bj = false;
            this.bl = 0.0f;
            return false;
        }
        this.bl = ((float) (nanoTime % 375)) / 375.0f;
        this.bl = (float) ((Math.cos(((this.bl + 0.5d) * 2.0d) * 3.141592653589793d) / 2.0d) + 0.5d);
        return true;
    }

    private void r() {
        if (!this.bm.isEmpty() && this.ad > 0) {
            Iterator<c> it = this.bm.iterator();
            while (it.hasNext()) {
                c next = it.next();
                a b2 = b(next.b, next.c);
                if (b2 != null) {
                    next.f3750a.a(new Rect((b2.f3748a + getLeft()) - this.aW, b2.c + getTop(), (b2.b + getLeft()) - this.aW, b2.d + getTop()));
                }
            }
            this.bm.clear();
        }
    }

    private void s() {
        this.as = this.S.getTotalTime();
        this.at = this.S.getTotalSecondaryTime();
        int c2 = c(Math.max(this.as, this.at), false);
        int c3 = this.as < this.at ? c(this.as, false) : c2;
        if (this.aq != c2 || this.ar != c3) {
        }
        this.aq = c2;
        this.ar = c3;
    }

    private boolean a(NexTimelineItem nexTimelineItem, int[] iArr) {
        if (nexTimelineItem == null) {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
        if (nexTimelineItem.getTimeline() != this.S) {
            return false;
        }
        if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
            iArr[0] = 0;
            iArr[1] = 0;
            return a(new lz(this, nexTimelineItem, iArr)) == 1;
        }
        iArr[0] = i(nexTimelineItem.getAbsStartTime());
        iArr[1] = i(nexTimelineItem.getAbsEndTime());
        return true;
    }

    private int i(int i) {
        return c(i, true);
    }

    private int c(int i, boolean z) {
        return a(z, new ma(this, i));
    }

    private int j(int i) {
        return a(new mb(this, i));
    }

    private void e(MotionEvent motionEvent) {
        NexTimelineItem secondaryItem;
        if (!this.ab) {
            this.bD = false;
            a c2 = c(((int) motionEvent.getX()) + this.aW, ((int) motionEvent.getY()) + this.aY);
            if (c2 != null) {
                if (c2.e != 1 || !(this.S.getPrimaryItem(c2.f) instanceof NexTransitionItem)) {
                    if (c2.e == 1) {
                        if (c2.f >= 0 && c2.f < this.S.getPrimaryItemCount()) {
                            secondaryItem = this.S.getPrimaryItem(c2.f);
                        } else {
                            return;
                        }
                    } else if (c2.e == 2 && c2.f >= 0 && c2.f < this.S.getSecondaryItemCount()) {
                        secondaryItem = this.S.getSecondaryItem(c2.f);
                    } else {
                        return;
                    }
                    int[] iArr = new int[2];
                    getLocationOnScreen(iArr);
                    int i = iArr[0];
                    int i2 = iArr[1];
                    k();
                    ((Vibrator) getContext().getSystemService("vibrator")).vibrate(30L);
                    NexTimelineItem.i onLongPress = secondaryItem.onLongPress(getContext(), this, new RectF((c2.f3748a + i) - this.aW, c2.c + i2, (c2.b + i) - this.aW, c2.d + i2), (int) (i + motionEvent.getX()), (int) (i2 + motionEvent.getY()), getSelectedIndex() == c2.f && getSelectedTimelineInt() == c2.e, this.bg);
                    this.aF = motionEvent.getRawX();
                    this.aG = motionEvent.getRawY();
                    this.bH = true;
                    if (onLongPress instanceof NexTimelineItem.h) {
                        this.aI = secondaryItem;
                        this.aJ = (NexTimelineItem.h) onLongPress;
                        this.an = c2.f;
                        if (secondaryItem instanceof NexPrimaryTimelineItem) {
                            this.f3746a = WhichTimeline.PRIMARY;
                        } else {
                            this.f3746a = WhichTimeline.SECONDARY;
                        }
                        this.ab = true;
                        this.x = Integer.MAX_VALUE;
                        this.V = false;
                        invalidate();
                        return;
                    }
                    if (onLongPress == NexTimelineItem.i.o) {
                        this.aH = ((NexSecondaryTimelineItem) secondaryItem).getAbsStartTime();
                    } else if (onLongPress != NexTimelineItem.i.n) {
                        return;
                    }
                    this.bp = false;
                    if (secondaryItem instanceof NexPrimaryTimelineItem) {
                        PreferenceManager.getDefaultSharedPreferences(getContext());
                    }
                    this.ae = (int) (motionEvent.getX() - (c2.f3748a - this.aW));
                    this.af = (int) (motionEvent.getY() - c2.c);
                    getWindowVisibleDisplayFrame(new Rect());
                    Bitmap dragBitmap_v3 = secondaryItem.getDragBitmap_v3(getContext(), Math.min(c2.b - c2.f3748a, getResources().getDimensionPixelSize(R.dimen.timeline3_dragItemMaxWidth)), c2.d - c2.c, c2.b - c2.f3748a);
                    this.ah = new ImageView(getContext());
                    this.ah.setBackgroundColor(0);
                    this.ah.setVisibility(4);
                    this.ah.setImageBitmap(dragBitmap_v3);
                    if (this.ak != null) {
                        this.ak.recycle();
                        this.ak = null;
                    }
                    this.ak = dragBitmap_v3;
                    this.ai = new WindowManager.LayoutParams();
                    this.ai.height = -2;
                    this.ai.width = -2;
                    this.ai.flags = 408;
                    this.ai.gravity = 51;
                    this.ai.x = ((int) motionEvent.getRawX()) - this.ae;
                    this.ai.y = ((int) motionEvent.getRawY()) - this.af;
                    this.ai.windowAnimations = 0;
                    this.ai.format = -3;
                    this.aj.addView(this.ah, this.ai);
                    this.ab = true;
                    this.x = Integer.MAX_VALUE;
                    this.an = c2.f;
                    this.ao = this.an;
                    if (secondaryItem instanceof NexPrimaryTimelineItem) {
                        this.f3746a = WhichTimeline.PRIMARY;
                        this.al = secondaryItem;
                        this.am = ((NexPrimaryTimelineItem) secondaryItem).getTransition();
                        this.ah.setVisibility(0);
                    } else {
                        this.f3746a = WhichTimeline.SECONDARY;
                        this.al = secondaryItem;
                        this.am = null;
                        this.ah.setVisibility(4);
                    }
                    postInvalidateOnAnimation();
                    f(motionEvent);
                }
            }
        }
    }

    private void b(boolean z) {
        if (this.ab) {
            if (this.aI != null) {
                this.aI.onCustomDragDone_v3(this.aJ, this);
                if (this.aC != null) {
                    this.aC.a(this.f3746a, this.bg, this.an, this.aI);
                    this.aC.a(this.f3746a, this.an, this.aI, true);
                }
                this.ab = false;
                this.aI = null;
                this.aJ = null;
                this.aK = false;
                invalidate();
                return;
            }
            if (this.ah != null) {
                this.aj.removeView(this.ah);
                this.ah = null;
            }
            this.ab = false;
            if ((this.f3746a == WhichTimeline.PRIMARY && this.ao < this.an) || this.ao > this.an + 2) {
                if (this.aC != null) {
                    this.aC.a(this.an, this.ao, (NexPrimaryTimelineItem) this.al);
                }
            } else if (this.f3746a == WhichTimeline.SECONDARY && this.aH != ((NexSecondaryTimelineItem) this.al).getAbsStartTime()) {
                if (this.aC != null) {
                    this.aC.a(this.an, this.aH, (NexSecondaryTimelineItem) this.al);
                }
                this.al = null;
            } else {
                invalidate();
            }
            if (this.bD) {
                this.bD = false;
                d(this.aW, true);
            }
        }
    }

    private void f(MotionEvent motionEvent) {
        int i;
        this.bA = 0.0f;
        if (!this.bD) {
            this.bB = 0.0f;
        }
        if (this.ab) {
            float rawX = motionEvent.getRawX() - this.aF;
            float rawY = motionEvent.getRawY() - this.aG;
            if (this.aI != null) {
                this.aK = true;
                if (this.aI.onCustomDrag_v3(this.aJ, this, rawX, rawY, this.G) && this.aC != null) {
                    this.aC.a(this.f3746a, this.an, this.aI, false);
                }
                this.S.requestCalcTimes();
                s();
                invalidate();
                return;
            }
            boolean z = this.f3746a == WhichTimeline.SECONDARY;
            if (this.bH != z) {
                this.bH = z;
                this.ah.setVisibility(z ? 8 : 0);
                invalidate();
            }
            if (motionEvent.getX() < this.P) {
                if (!this.bD) {
                    this.bC = System.nanoTime();
                }
                this.bD = true;
                this.bA = (-(motionEvent.getX() - this.P)) / 6.0f;
                postInvalidateOnAnimation();
            } else if (motionEvent.getX() > getWidth() - this.Q) {
                if (!this.bD) {
                    this.bC = System.nanoTime();
                }
                this.bD = true;
                this.bA = (-(motionEvent.getX() - (getWidth() - this.Q))) / 6.0f;
                postInvalidateOnAnimation();
            }
            this.ai.x = ((int) motionEvent.getRawX()) - this.ae;
            this.ai.y = (((int) motionEvent.getRawY()) - this.af) - this.aY;
            this.aj.updateViewLayout(this.ah, this.ai);
            int x = (int) motionEvent.getX();
            if (this.f3746a == WhichTimeline.SECONDARY) {
                int j = j(((int) (motionEvent.getX() + this.aW)) - this.ae);
                int totalTime = this.S.getTotalTime() - 1;
                if (j <= totalTime) {
                    totalTime = j;
                }
                if (this.aH != totalTime) {
                    this.aH = totalTime;
                    invalidate();
                    return;
                }
                return;
            }
            if (this.f3746a == WhichTimeline.PRIMARY) {
                int a2 = a(new mc(this, this.S.getPrimaryItemCount() + 1, x)) - 1;
                if (!this.bp || a2 <= this.S.getPrimaryItemCount() - 1) {
                    i = a2;
                }
                if (i >= 0 && i % 2 != 0) {
                    i++;
                }
                int i2 = i >= 0 ? i : 0;
                if (i2 != this.ao) {
                    this.ao = i2;
                    invalidate();
                }
            }
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        this.x = Integer.MAX_VALUE;
        float scaleFactor = this.G * scaleGestureDetector.getScaleFactor();
        float f2 = scaleFactor >= 3.0f ? scaleFactor : 3.0f;
        float f3 = f2 <= 8000.0f ? f2 : 8000.0f;
        if (Math.abs(this.G - f3) < 0.1d) {
            return false;
        }
        this.G = f3;
        s();
        this.aW = (int) (i(this.T) - scaleGestureDetector.getFocusX());
        invalidate();
        c(true);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.T = j(this.aW + ((int) scaleGestureDetector.getFocusX()));
        this.V = false;
        this.W = true;
        this.aa = true;
        if (this.aC != null) {
            this.aC.b();
        }
        KMAppUsage.a(getContext()).a(KMAppUsage.KMMetric.PinchToZoomTimeline);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.W = false;
    }

    @Override // com.nexstreaming.app.general.util.n.c
    public boolean a(MotionEvent motionEvent) {
        if (!this.c.isFinished() && this.V) {
            this.V = false;
        }
        this.c.forceFinished(true);
        if (this.bf != -1) {
            this.bf = -1;
            c(true);
        }
        return false;
    }

    @Override // com.nexstreaming.app.general.util.n.c
    public boolean b(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.y = null;
        if (!this.ab && !this.aa && !this.W && (!this.aA ? !(!this.aB || Math.abs(f3) < 500.0f) : Math.abs(f2) >= 500.0f)) {
            if (Math.abs(f2) > Math.abs(f3) && Math.abs(f2) > 1500.0f) {
                this.bd = f2 < 0.0f ? 0 : 1;
            }
            if (this.bf >= 0) {
                this.bf = -1;
            }
            this.c.fling(this.aW, this.aY, (int) ((-f2) * 0.9f), (int) ((-f3) * 0.9f), getMinScrollX(), getMaxScrollX(), getMinScrollY(), getMaxScrollY());
            postInvalidateOnAnimation();
        }
        return false;
    }

    @Override // com.nexstreaming.app.general.util.n.c
    public void d(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (this.aC != null) {
                this.aC.a();
            }
            ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getSize(this.u);
            int i = this.u.x;
            motionEvent.getX();
            getResources().getDimension(R.dimen.timeline3_scrollToEndLongPressZoneWidth);
            if (this.V) {
                e(motionEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        d(this.aW, z);
    }

    private void d(int i, boolean z) {
        int j = j((getWidth() / 2) + i);
        if (j < 0) {
            j = 0;
        }
        if (this.bf >= 0) {
            int max = Math.max(10, (int) (1000.0f / this.G));
            if ((i == this.be || (this.bf > j - max && this.bf < max + j)) && j < this.bf - 7 && j > this.bf - 13) {
                j = this.bf;
            }
        }
        if (this.bf >= 0) {
            j = this.bf;
        } else if (this.bu != null) {
            int absEndTime = this.bu.getAbsEndTime() - 1;
            int absStartTime = this.bu.getAbsStartTime();
            if (j < absStartTime) {
                j = absStartTime;
            }
            if (j > absEndTime) {
                j = absEndTime;
            }
        }
        this.aD = j;
        if (this.aE != j || (z && !this.bn)) {
            this.aE = j;
            this.bn = z;
            if (this.aC != null && this.aI == null) {
                if (this.bM) {
                    if (this.bn) {
                        this.bM = false;
                        return;
                    }
                    return;
                }
                this.aC.a(this.aE, this.bn);
            }
        }
    }

    public void setSuppressScrollEvents(boolean z) {
        this.bM = z;
    }

    private a t() {
        if (this.bu == null) {
            return null;
        }
        return b(getSelectedTimelineInt(), getSelectedIndex());
    }

    private int getMinScrollX() {
        if (this.aB) {
            return this.aW;
        }
        a t = t();
        if (t == null) {
            return 0;
        }
        if (getSelectedTimeline() == WhichTimeline.PRIMARY && getSelectedIndex() == 0) {
            return 0;
        }
        if (getSelectedItem() instanceof NexTransitionItem) {
            return (t.f3748a + ((t.b - t.f3748a) / 2)) - (getWidth() / 2);
        }
        return t.f3748a - (getWidth() / 2);
    }

    private int getMinScrollY() {
        if (this.aA || this.ab) {
            return this.aY;
        }
        return 0;
    }

    private int getMaxScrollY() {
        if (this.aA || this.ab) {
            return this.aY;
        }
        return Math.max(0, (this.M + (((this.bE + 1) * (this.N + this.O)) + this.I)) - (this.bu == null ? getHeight() - this.K : 0));
    }

    private int getMaxScrollX() {
        if (this.aB) {
            return this.aW;
        }
        int i = this.x;
        a t = t();
        if (t != null) {
            if (getSelectedItem() instanceof NexTransitionItem) {
                return Math.min(i, (((t.b - t.f3748a) / 2) + t.f3748a) - (getWidth() / 2));
            }
            return Math.min(i, t.b - (getWidth() / 2));
        }
        return Math.min(i, this.aq - 1);
    }

    @Override // com.nexstreaming.app.general.util.n.c
    public boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.y = null;
        if (this.W || this.aa) {
            return false;
        }
        if (this.aA || (!this.aB && !this.ab && Math.abs(f2) > Math.abs(f3))) {
            this.V = false;
            if (!this.aA) {
                this.aE = -1;
                this.aA = true;
                this.aZ = this.aW;
            }
            this.aZ = (int) (this.aZ + f2);
            this.aW = this.aZ;
            this.aW = Math.max(getMinScrollX(), Math.min(getMaxScrollX(), this.aW));
            invalidate();
            c(false);
        } else if (this.aB || (!this.aA && !this.ab && Math.abs(f3) > Math.abs(f2) && this.bu == null)) {
            this.V = false;
            int i = this.aY;
            if (!this.aB) {
                this.aE = -1;
                this.aB = true;
                this.ba = this.aY;
            }
            this.ba = (int) (this.ba + f3);
            this.aY = this.ba;
            this.aY = Math.max(getMinScrollY(), Math.min(getMaxScrollY(), this.aY));
            if (i == this.aY) {
                return true;
            }
            invalidate();
            return true;
        }
        return false;
    }

    @Override // com.nexstreaming.app.general.util.n.c
    public void b(MotionEvent motionEvent) {
    }

    @Override // com.nexstreaming.app.general.util.n.c
    public boolean c(MotionEvent motionEvent) {
        int i;
        if (this.U) {
            this.V = false;
        } else if (this.V) {
            if (this.bu != null) {
                a((a) null);
            } else {
                a c2 = c(((int) motionEvent.getX()) + this.aW, ((int) motionEvent.getY()) + this.aY);
                if (c2 != null) {
                    if (getSelectedIndex() == c2.f && getSelectedTimelineInt() == c2.e) {
                        a((a) null);
                    } else {
                        int a2 = (int) a(20.0f);
                        int i2 = c2.b - c2.f3748a;
                        if (i2 < a2) {
                            if (i2 > 0) {
                                this.G = Math.min(1500.0f, (a2 * this.G) / i2);
                                a(c2);
                            }
                        } else {
                            a(c2);
                        }
                    }
                } else {
                    a((a) null);
                    if (motionEvent.getY() < this.A * 25.0f) {
                        int j = j(((int) motionEvent.getX()) + this.aW);
                        int[] bookmarks = this.S.getBookmarks();
                        int i3 = Integer.MAX_VALUE;
                        int length = bookmarks.length;
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < length) {
                            int i6 = bookmarks[i4];
                            int abs = Math.abs(j - i6);
                            if (abs < i3) {
                                i = abs;
                            } else {
                                i6 = i5;
                                i = i3;
                            }
                            i4++;
                            i3 = i;
                            i5 = i6;
                        }
                        if (i3 < ((this.A * 25.0f) * 1000.0f) / this.G) {
                            KMAppUsage.a(getContext()).a(KMAppUsage.KMMetric.GoToBookmark);
                            KMUsage.EditScreen_Bookmark.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "jump from timeline");
                            a(i5);
                        }
                    }
                }
            }
        }
        return false;
    }

    private void a(a aVar) {
        if (aVar == null) {
            e(0, -1);
        } else {
            e(aVar.e, aVar.f);
        }
    }

    private void e(int i, int i2) {
        WhichTimeline whichTimeline;
        NexTimelineItem nexTimelineItem;
        if (this.y != null) {
            removeCallbacks(this.y);
            this.y = null;
        }
        if (i == 0 || i2 == -1) {
            i = 0;
            i2 = -1;
        }
        if (i == 1) {
            nexTimelineItem = (i2 <= -1 || i2 >= this.S.getPrimaryItemCount()) ? null : this.S.getPrimaryItem(i2);
            whichTimeline = WhichTimeline.PRIMARY;
        } else if (i == 2) {
            nexTimelineItem = (i2 <= -1 || i2 >= this.S.getSecondaryItemCount()) ? null : this.S.getSecondaryItem(i2);
            whichTimeline = WhichTimeline.SECONDARY;
        } else {
            whichTimeline = null;
            nexTimelineItem = null;
        }
        if (i != getSelectedTimelineInt() || i2 != getSelectedIndex() || nexTimelineItem != this.bu) {
            this.bu = nexTimelineItem;
            if (this.bu == null) {
                setLayerType(2, null);
            } else {
                setLayerType(1, null);
            }
            if (this.aC != null) {
                this.aC.a(whichTimeline, getSelectedIndex(), this.bu);
            }
            invalidate();
            a(true);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.t
    public int a(boolean z) {
        return a(this.bu, z);
    }

    public int a(NexTimelineItem nexTimelineItem, boolean z) {
        int i;
        this.y = null;
        if (nexTimelineItem != null) {
            a(nexTimelineItem, r0);
            int[] iArr = {iArr[0] - (getWidth() / 2), iArr[1] - (getWidth() / 2)};
            if (nexTimelineItem instanceof NexTransitionItem) {
                i = ((iArr[1] - iArr[0]) / 2) + iArr[0];
            } else if (this.aW < iArr[0] + 1) {
                i = iArr[0] + 1;
            } else if (this.aW > iArr[1] - 1) {
                i = iArr[1] - 1;
            } else {
                i = this.aW;
            }
            if (nexTimelineItem instanceof NexSecondaryTimelineItem) {
                int h2 = h(((NexSecondaryTimelineItem) nexTimelineItem).getTrackMapping());
                int min = Math.min(getMaxScrollY(), ((this.O + this.N) * h2) + (this.I - this.J));
                r1 = h2 != 0 ? Math.min(getMaxScrollY(), ((h2 - 1) * (this.O + this.N)) + (this.I - this.J)) : 0;
                if (Math.abs(this.aY - min) < Math.abs(this.aY - r1)) {
                    r1 = min;
                }
            }
            a(i, r1, z);
        }
        return this.aD;
    }

    public void a(NexTimelineItem nexTimelineItem, boolean z, boolean z2) {
        c(nexTimelineItem, z);
        if (z2) {
            this.y = new lu(this, nexTimelineItem, z);
        } else {
            this.y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(NexTimelineItem nexTimelineItem, boolean z) {
        if (nexTimelineItem != null) {
            int[] iArr = new int[2];
            if (a(nexTimelineItem, iArr)) {
                iArr[0] = iArr[0] - (getWidth() / 2);
                iArr[1] = iArr[1] - (getWidth() / 2);
                int i = iArr[1] - 1;
                if (this.c.isFinished() || !z) {
                    if (i != this.aW) {
                        b(i, z);
                    }
                } else if (Math.abs(this.c.getFinalX() - i) > 5) {
                    b(i, true);
                }
            }
        }
    }

    public void b(NexTimelineItem nexTimelineItem, boolean z) {
        this.y = null;
        if (nexTimelineItem != null) {
            a(nexTimelineItem, r0);
            int[] iArr = {iArr[0] - (getWidth() / 2), iArr[1] - (getWidth() / 2)};
            b(iArr[0] + 1, z);
        }
    }

    public void a(int i, int i2, int i3) {
        this.aO = true;
        this.aL = i;
        this.aM = i2;
        this.aN = i3;
        invalidate();
    }

    public void g() {
        this.aO = false;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f3748a;
        int b;
        int c;
        int d;
        int e;
        int f;
        boolean g;

        private a() {
        }

        /* synthetic */ a(TimelineView timelineView, lt ltVar) {
            this();
        }
    }

    private int a(b bVar) {
        return a(true, bVar);
    }

    private int a(boolean z, b bVar) {
        int i;
        boolean z2;
        if (z) {
            Rect rect = new Rect();
            getLocalVisibleRect(rect);
            int width = rect.width();
            if (this.ap != width) {
                this.ap = width;
                s();
                invalidate();
            }
            i = (this.ap / 2) + this.H;
        } else {
            i = this.H;
        }
        int i2 = 0;
        int primaryItemCount = this.S.getPrimaryItemCount();
        int i3 = i;
        for (int i4 = 0; i4 < primaryItemCount + 2; i4++) {
            if (this.ab && this.aI == null && this.f3746a == WhichTimeline.PRIMARY) {
                if (this.ao == i4) {
                    if (this.ao < primaryItemCount || this.an + 1 >= primaryItemCount) {
                        z2 = false;
                    } else {
                        NexPrimaryTimelineItem nexPrimaryTimelineItem = (NexPrimaryTimelineItem) this.am;
                        int representedDuration = nexPrimaryTimelineItem.getRepresentedDuration();
                        int pixelWidth = nexPrimaryTimelineItem.getPixelWidth(this.G, this.A);
                        bVar.a(this.an + 1, primaryItemCount, nexPrimaryTimelineItem, i3, pixelWidth, i2, representedDuration, true);
                        if (bVar.b()) {
                            return bVar.a();
                        }
                        i2 += representedDuration;
                        i3 += this.H + pixelWidth;
                        z2 = true;
                    }
                    NexPrimaryTimelineItem nexPrimaryTimelineItem2 = (NexPrimaryTimelineItem) this.al;
                    int representedDuration2 = nexPrimaryTimelineItem2.getRepresentedDuration();
                    int pixelWidth2 = nexPrimaryTimelineItem2.getPixelWidth(this.G, this.A);
                    bVar.a(this.an, primaryItemCount, nexPrimaryTimelineItem2, i3, pixelWidth2, i2, representedDuration2, true);
                    if (bVar.b()) {
                        return bVar.a();
                    }
                    i2 += representedDuration2;
                    i3 += this.H + pixelWidth2;
                    if (!z2) {
                        if ((this.an + 1 < primaryItemCount ? 0 : 1) + this.ao < primaryItemCount) {
                            NexPrimaryTimelineItem nexPrimaryTimelineItem3 = (NexPrimaryTimelineItem) this.am;
                            int representedDuration3 = nexPrimaryTimelineItem3.getRepresentedDuration();
                            int pixelWidth3 = nexPrimaryTimelineItem3.getPixelWidth(this.G, this.A);
                            bVar.a(this.an + 1, primaryItemCount, nexPrimaryTimelineItem3, i3, pixelWidth3, i2, representedDuration3, true);
                            if (bVar.b()) {
                                return bVar.a();
                            }
                            i2 += representedDuration3;
                            i3 += this.H + pixelWidth3;
                        }
                    }
                }
                if (this.an == i4) {
                    continue;
                } else if (this.an + 1 == i4) {
                    continue;
                }
            }
            if (i4 < primaryItemCount) {
                NexPrimaryTimelineItem primaryItem = this.S.getPrimaryItem(i4);
                int representedDuration4 = primaryItem.getRepresentedDuration();
                int pixelWidth4 = primaryItem.getPixelWidth(this.G, this.A);
                bVar.a(i4, primaryItemCount, primaryItem, i3, pixelWidth4, i2, representedDuration4, false);
                if (bVar.b()) {
                    return bVar.a();
                }
                i3 += this.H + pixelWidth4;
                i2 += representedDuration4;
            } else {
                continue;
            }
        }
        return bVar.a();
    }

    private boolean u() {
        NexSecondaryTimelineItem nexSecondaryTimelineItem = null;
        if (this.bu instanceof NexSecondaryTimelineItem) {
            nexSecondaryTimelineItem = (NexSecondaryTimelineItem) this.bu;
        }
        if (nexSecondaryTimelineItem != null) {
            float absStartTime = nexSecondaryTimelineItem.getAbsStartTime();
            float absEndTime = nexSecondaryTimelineItem.getAbsEndTime();
            float currentTime = getCurrentTime();
            if (currentTime - absStartTime > 100.0f && absEndTime - currentTime > 500.0f) {
                return true;
            }
        }
        return false;
    }

    private boolean v() {
        NexSecondaryTimelineItem nexSecondaryTimelineItem = null;
        if (this.bu instanceof NexSecondaryTimelineItem) {
            nexSecondaryTimelineItem = (NexSecondaryTimelineItem) this.bu;
        }
        if (nexSecondaryTimelineItem != null) {
            float absStartTime = nexSecondaryTimelineItem.getAbsStartTime();
            float absEndTime = nexSecondaryTimelineItem.getAbsEndTime();
            float currentTime = getCurrentTime();
            if (currentTime - absStartTime > 500.0f && absEndTime - currentTime > 100.0f) {
                return true;
            }
        }
        return false;
    }

    private boolean w() {
        NexLayerItem nexLayerItem;
        if (this.bu instanceof NexAudioClipItem) {
            NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) this.bu;
            if (nexAudioClipItem != null) {
                float absStartTime = nexAudioClipItem.getAbsStartTime();
                float absEndTime = nexAudioClipItem.getAbsEndTime();
                float currentTime = getCurrentTime();
                float totalTime = getTimeline().getTotalTime();
                if (currentTime - absStartTime > 500.0f && absEndTime - currentTime > 500.0f && !nexAudioClipItem.isLoop() && currentTime < totalTime) {
                    return true;
                }
            }
        } else if ((this.bu instanceof NexLayerItem) && (nexLayerItem = (NexLayerItem) this.bu) != null) {
            float absStartTime2 = nexLayerItem.getAbsStartTime();
            float absEndTime2 = nexLayerItem.getAbsEndTime();
            float currentTime2 = getCurrentTime();
            float totalTime2 = getTimeline().getTotalTime();
            if (currentTime2 - absStartTime2 > 500.0f && absEndTime2 - currentTime2 > 500.0f && currentTime2 < totalTime2) {
                return true;
            }
        }
        return false;
    }

    public boolean h() {
        return this.aT;
    }

    public boolean i() {
        return this.aU;
    }

    public boolean j() {
        return this.aV;
    }

    public void a(NexTimelineItem nexTimelineItem, AnimType animType, int i) {
        if (this.bL != null && this.bL.hasStarted() && !this.bL.hasEnded()) {
            this.bL.cancel();
        }
        this.bK = animType;
        this.bI = nexTimelineItem;
        this.bJ = 0.0f;
        this.bL = new lv(this);
        this.bL.setAnimationListener(new lw(this));
        this.bL.setDuration(i);
        startAnimation(this.bL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private int f3749a;
        private boolean b;

        abstract void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z);

        public b() {
            this.f3749a = 0;
            this.b = false;
        }

        public b(int i) {
            this.f3749a = 0;
            this.b = false;
            this.f3749a = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a(int i) {
            this.f3749a = i;
            this.b = true;
        }

        public final int a() {
            return this.f3749a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public void k() {
        a((a) null);
    }

    public void setEditingMode(int i) {
        if (this.bg != i) {
            this.bg = i;
            invalidate();
        }
    }

    public int getEditingMode() {
        return this.bg;
    }

    public int getSelectedIndex() {
        if (this.bu == null) {
            return -1;
        }
        if (this.bu instanceof NexPrimaryTimelineItem) {
            return this.S.getIndexOfPrimaryItem((NexPrimaryTimelineItem) this.bu);
        }
        if (this.bu instanceof NexSecondaryTimelineItem) {
            return this.S.getIndexOfSecondaryItem((NexSecondaryTimelineItem) this.bu);
        }
        return -1;
    }

    public NexTimelineItem getSelectedItem() {
        return this.bu;
    }

    public void setSelectedItem(NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
            e(1, this.S.getIndexOfPrimaryItem((NexPrimaryTimelineItem) nexTimelineItem));
        } else if (nexTimelineItem instanceof NexSecondaryTimelineItem) {
            e(2, this.S.getIndexOfSecondaryItem((NexSecondaryTimelineItem) nexTimelineItem));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSelectedTimelineInt() {
        if (this.bu == null) {
            return 0;
        }
        if (this.bu instanceof NexPrimaryTimelineItem) {
            return 1;
        }
        return this.bu instanceof NexSecondaryTimelineItem ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g implements NexTimelineItem.p {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<TimelineView> f3752a;

        g(TimelineView timelineView) {
            this.f3752a = new WeakReference<>(timelineView);
        }

        @Override // com.nextreaming.nexeditorui.NexTimelineItem.p
        public void a(NexTimelineItem nexTimelineItem) {
            TimelineView timelineView = this.f3752a.get();
            if (timelineView != null) {
                timelineView.j.remove(nexTimelineItem);
                timelineView.invalidate();
            }
        }

        @Override // com.nextreaming.nexeditorui.NexTimelineItem.p
        public void a(NexTimelineItem nexTimelineItem, NexTimelineItem nexTimelineItem2, NexTimelineItem nexTimelineItem3) {
            TimelineView timelineView = this.f3752a.get();
            if (timelineView != null) {
                timelineView.j.remove(nexTimelineItem);
                timelineView.j.remove(nexTimelineItem2);
                timelineView.j.remove(nexTimelineItem3);
                timelineView.invalidate();
            }
        }
    }

    public WhichTimeline getSelectedTimeline() {
        if (getSelectedTimelineInt() == 0 || getSelectedIndex() == -1) {
            return null;
        }
        return getSelectedTimelineInt() == 1 ? WhichTimeline.PRIMARY : WhichTimeline.SECONDARY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        e f3750a;
        int b;
        int c;

        private c() {
        }
    }

    public float getPixelsPerSecond() {
        return this.G;
    }
}
