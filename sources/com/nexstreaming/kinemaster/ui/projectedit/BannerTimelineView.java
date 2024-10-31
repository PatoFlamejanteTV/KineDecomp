package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.OverScroller;
import com.nexstreaming.kinemaster.ad.AdManager;
import com.nexstreaming.kinemaster.ad.BannerInfo;
import com.nexstreaming.kinemaster.ad.f;

/* loaded from: classes2.dex */
public class BannerTimelineView extends TimelineView {
    private com.nexstreaming.kinemaster.ad.f Tb;
    private a Ub;
    private long Vb;
    private final Rect Wb;
    private final int Xb;
    private final int Yb;
    private Context Zb;
    private com.nexstreaming.kinemaster.ad.g _b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a */
        private final OverScroller f21775a;

        /* renamed from: b */
        private boolean f21776b;

        /* renamed from: c */
        private boolean f21777c;

        /* renamed from: d */
        private float f21778d;

        /* renamed from: e */
        private float f21779e;

        a(Context context) {
            this.f21775a = new OverScroller(context, new OvershootInterpolator());
        }

        public void a(float f2, long j) {
            this.f21778d = f2;
            this.f21779e = 0.0f;
            this.f21776b = true;
            this.f21777c = true;
            BannerTimelineView.this.postOnAnimationDelayed(this, j);
        }

        public float b() {
            return this.f21779e;
        }

        public boolean c() {
            return this.f21777c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f21776b) {
                this.f21776b = false;
                this.f21775a.startScroll(0, 0, 100, 0);
                BannerTimelineView.this.postOnAnimation(this);
            } else if (this.f21775a.computeScrollOffset()) {
                float f2 = this.f21778d;
                this.f21779e = f2 + ((1.0f - f2) * (this.f21775a.getCurrX() / 100.0f));
                BannerTimelineView.this.postOnAnimation(this);
            } else {
                this.f21779e = 1.0f;
                this.f21776b = false;
                this.f21777c = false;
            }
            BannerTimelineView.this.postInvalidateOnAnimation();
        }
    }

    public BannerTimelineView(Context context) {
        this(context, null, 0);
    }

    private boolean A() {
        return z() && AdManager.a(getContext()).e();
    }

    public void B() {
        com.nexstreaming.kinemaster.ad.g gVar;
        if (this.Tb == null || (gVar = this._b) == null) {
            return;
        }
        if (gVar.isReady()) {
            if (this.Tb.g()) {
                return;
            }
            this.Tb.a(true);
            this.Ub.a(0.95f, 1000L);
            o();
            return;
        }
        this._b.addListener(new C1843aa(this));
    }

    private void k(Canvas canvas) {
        canvas.save();
        int i = this.Wb.left;
        int width = getWidth() / 2;
        Rect rect = this.Wb;
        int i2 = i + (((width - (rect.left + rect.right)) - this.Xb) / 2);
        int i3 = rect.top;
        int height = getHeight();
        Rect rect2 = this.Wb;
        int i4 = height - (rect2.top + rect2.bottom);
        int i5 = this.Yb;
        int i6 = i3 + ((i4 - i5) / 2);
        this.Tb.a(i2, i6, this.Xb + i2, i5 + i6);
        this.Tb.a(-this.Ea, 0);
        this.Tb.a(System.currentTimeMillis() - this.Vb);
        this.Tb.a(canvas);
        canvas.restore();
    }

    private boolean z() {
        com.nexstreaming.kinemaster.ad.f fVar;
        return !((getContext() instanceof com.nextreaming.nexeditorui.I) && ((com.nextreaming.nexeditorui.I) getContext()).C()) && AdManager.a(getContext()).d() && (fVar = this.Tb) != null && fVar.g();
    }

    public void o() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if ((getContext() instanceof com.nextreaming.nexeditorui.I) && !((com.nextreaming.nexeditorui.I) getContext()).C() && getWidth() > 0 && getHeight() > 0 && z()) {
            if (this.Ub.c()) {
                float b2 = this.Ub.b();
                int i = this.Xb / 2;
                Rect rect = this.Wb;
                canvas.scale(b2, b2, i + rect.left, (this.Yb / 2) + rect.top);
            }
            if (!A()) {
                k(canvas);
            }
            if (this.Tb.i()) {
                postInvalidateDelayed(this.Tb.b());
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView, com.nexstreaming.app.general.util.v.c
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        com.nexstreaming.kinemaster.ad.g gVar;
        if (z() && this.Tb.h() && this.Tb.a().contains((int) (motionEvent.getX() + this.Ea), (int) motionEvent.getY()) && (gVar = this._b) != null) {
            gVar.showDialogAd((AppCompatActivity) getContext(), (this.Tb.d() + (this.Tb.f() / 2)) - this.Ea, getTop() + this.Tb.e() + (this.Tb.c() / 2));
        }
        return super.onSingleTapUp(motionEvent);
    }

    public void setEnabledAdBanner(boolean z) {
        com.nexstreaming.kinemaster.ad.f fVar = this.Tb;
        if (fVar != null) {
            fVar.a(z);
        }
    }

    public void setProvider(com.nexstreaming.kinemaster.ad.g gVar) {
        this._b = gVar;
    }

    public BannerTimelineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(BannerInfo bannerInfo, f.a aVar) {
        com.nexstreaming.kinemaster.ad.f iVar;
        if (bannerInfo == null) {
            return;
        }
        if (bannerInfo.getType() == 2) {
            iVar = new com.nexstreaming.kinemaster.ad.l(bannerInfo);
        } else {
            iVar = new com.nexstreaming.kinemaster.ad.i(bannerInfo);
        }
        iVar.a(false);
        iVar.a(aVar);
        this.Tb = iVar;
    }

    public BannerTimelineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wb = new Rect();
        this._b = null;
        this.Zb = context;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels / 2;
        int i3 = displayMetrics.heightPixels / 3;
        int i4 = (int) (i2 * 0.2f);
        int i5 = (int) (i3 * 0.18f);
        this.Wb.set(i4, i5, i4, i5);
        Rect rect = this.Wb;
        this.Xb = i2 - (rect.left + rect.right);
        this.Yb = i3 - (rect.top + rect.bottom);
        this.Ub = new a(getContext());
        this.Vb = System.currentTimeMillis();
        int c2 = AdManager.a(context).c();
        if (c2 > 0) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            int i6 = defaultSharedPreferences.getInt("ad_index", 0);
            a(AdManager.a(context).a(i6), new Z(this));
            defaultSharedPreferences.edit().putInt("ad_index", (i6 + 1) % c2).apply();
        }
    }
}
