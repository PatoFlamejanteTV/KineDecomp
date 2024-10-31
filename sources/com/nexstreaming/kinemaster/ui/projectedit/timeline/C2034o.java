package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.OverScroller;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.I;
import com.nexstreaming.kinemaster.ui.widget.ClipThumbView;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: PrimaryItemDragDragDecoration.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2034o extends I<NexPrimaryTimelineItem> {
    private static final String z = "o";
    private final int A;
    private final float B;
    private c C;
    private int D;
    private float E;
    private final d F;
    private List<b> G;
    private final Map<UUID, d> H;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PrimaryItemDragDragDecoration.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.o$a */
    /* loaded from: classes2.dex */
    public interface a {
        void a(float f2);
    }

    /* compiled from: PrimaryItemDragDragDecoration.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.o$b */
    /* loaded from: classes2.dex */
    public interface b {
        void a(NexPrimaryTimelineItem nexPrimaryTimelineItem, int i);

        void a(NexPrimaryTimelineItem nexPrimaryTimelineItem, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PrimaryItemDragDragDecoration.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.o$c */
    /* loaded from: classes2.dex */
    public final class c extends C2027h {
        private C2027h i;
        private boolean j;

        public c(Bitmap bitmap) {
            super(bitmap);
        }

        public void a(boolean z) {
            this.j = z;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.C2027h, com.nexstreaming.kinemaster.ui.projectedit.timeline.z
        public void a(Canvas canvas, float f2, float f3) {
            C2027h c2027h;
            super.a(canvas, f2, f3);
            if (this.j || (c2027h = this.i) == null) {
                return;
            }
            c2027h.a(canvas, (f2 + getWidth()) - (this.i.getWidth() / 2), f3 + ((getHeight() - this.i.getHeight()) / 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PrimaryItemDragDragDecoration.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.o$d */
    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        private NexPrimaryTimelineItem f22692a;

        /* renamed from: b, reason: collision with root package name */
        private int f22693b;

        /* renamed from: c, reason: collision with root package name */
        private int f22694c;

        /* renamed from: d, reason: collision with root package name */
        private int f22695d;

        /* renamed from: e, reason: collision with root package name */
        private int f22696e = 0;

        d(NexPrimaryTimelineItem nexPrimaryTimelineItem, int i, int i2, int i3) {
            this.f22692a = nexPrimaryTimelineItem;
            this.f22693b = i;
            this.f22694c = i2;
            this.f22695d = i3;
        }

        public String toString() {
            return "[" + this.f22693b + ":" + this.f22694c + "-" + this.f22695d + "]";
        }

        public int a() {
            return this.f22695d - this.f22694c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PrimaryItemDragDragDecoration.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.o$e */
    /* loaded from: classes2.dex */
    public final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final View f22698a;

        /* renamed from: b, reason: collision with root package name */
        private final OverScroller f22699b;

        /* renamed from: c, reason: collision with root package name */
        private float f22700c;

        /* renamed from: d, reason: collision with root package name */
        private float f22701d;

        /* renamed from: e, reason: collision with root package name */
        private float f22702e;

        /* renamed from: f, reason: collision with root package name */
        private a f22703f;

        e(View view) {
            this.f22698a = view;
            this.f22699b = new OverScroller(view.getContext());
        }

        public e a(a aVar) {
            this.f22703f = aVar;
            return this;
        }

        public e b(float f2) {
            this.f22701d = f2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f22699b.computeScrollOffset()) {
                this.f22702e = this.f22700c + this.f22699b.getCurrX();
                a aVar = this.f22703f;
                if (aVar != null) {
                    aVar.a(this.f22702e);
                }
                this.f22698a.postInvalidateOnAnimation();
                this.f22698a.postOnAnimation(this);
                return;
            }
            this.f22702e = this.f22701d;
            this.f22698a.postInvalidateOnAnimation();
        }

        public e a(float f2) {
            this.f22700c = f2;
            return this;
        }

        public e b() {
            this.f22702e = 0.0f;
            int i = (int) (this.f22701d - this.f22700c);
            Log.d(C2034o.z, "[SnapshotTranslator][start] from: " + this.f22700c + ", to: " + this.f22701d + ", delta: " + i);
            this.f22699b.startScroll(0, 0, i, 0);
            this.f22698a.postOnAnimation(this);
            return this;
        }
    }

    public C2034o(UniformTimelineView uniformTimelineView, NexPrimaryTimelineItem nexPrimaryTimelineItem, MotionEvent motionEvent) {
        super(uniformTimelineView, nexPrimaryTimelineItem, motionEvent);
        this.H = new HashMap();
        this.A = j().getDimensionPixelSize(R.dimen.timeline3_dragItemMaxWidth);
        this.B = r1.getDimensionPixelSize(R.dimen.timeline3_itemCornerRadius);
        this.C = a(nexPrimaryTimelineItem);
        this.E = nexPrimaryTimelineItem.getAbsStartTime() * h().f();
        this.F = b(nexPrimaryTimelineItem);
    }

    private static TransitionIconView b(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                return b((ViewGroup) childAt);
            }
            if (childAt instanceof TransitionIconView) {
                return (TransitionIconView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void C() {
        int indexOfPrimaryItem = m().getIndexOfPrimaryItem(this.F.f22692a);
        if (indexOfPrimaryItem != this.F.f22693b) {
            a(this.F.f22692a, indexOfPrimaryItem, this.F.f22693b);
        }
        super.C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void D() {
        super.D();
        h().a(new C2033n(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public C2034o F() {
        super.F();
        List<b> list = this.G;
        if (list != null) {
            list.clear();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void G() {
        super.G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void H() {
        super.H();
        float f2 = -h().t;
        float totalTime = (m().getTotalTime() * h().f()) - h().t;
        float f3 = this.q;
        if (f3 < f2) {
            this.q = f2;
        } else if (f3 > totalTime) {
            this.q = totalTime;
        }
        this.r = h().E;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void c(MotionEvent motionEvent) {
        super.c(motionEvent);
        this.D = (int) (motionEvent.getX() + 0.5f);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.A
    protected int l() {
        return 2;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        c cVar;
        if (this.m && (cVar = this.C) != null && cVar.isValid()) {
            float f2 = h().t;
            float f3 = h().u;
            this.C.a(0.25f);
            this.C.a(true);
            this.C.a(canvas, this.E - f2, (this.p.d() - this.p.a()) + (this.p.e() - f3));
            canvas.save();
            if (s().isRunning()) {
                int width = this.C.getWidth();
                int height = this.C.getHeight();
                double radians = Math.toRadians(180.0d);
                double b2 = s().b();
                Double.isNaN(b2);
                float sin = (float) Math.sin(radians * b2);
                canvas.scale((((this.A * 0.2f) / width) * sin) + 1.0f, (((h().F * 0.2f) / height) * sin) + 1.0f, this.q + (width / 2), this.r + (height / 2));
            } else {
                canvas.scale(1.0f, 1.0f);
            }
            this.C.a(1.0f);
            this.C.a(false);
            this.C.a(canvas, this.q, this.r);
            canvas.restore();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    protected int u() {
        return m().getIndexOfPrimaryItem(this.F.f22692a) != this.F.f22693b ? 4 : 0;
    }

    private d c(int i) {
        for (d dVar : this.H.values()) {
            if (i >= dVar.f22694c && i < dVar.f22695d) {
                return dVar;
            }
        }
        return b(m().findPrimaryItemByTime(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x01c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.nexstreaming.kinemaster.ui.projectedit.timeline.C2034o.c a(com.nextreaming.nexeditorui.NexPrimaryTimelineItem r25) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.timeline.C2034o.a(com.nextreaming.nexeditorui.NexPrimaryTimelineItem):com.nexstreaming.kinemaster.ui.projectedit.timeline.o$c");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I, com.nexstreaming.kinemaster.ui.projectedit.timeline.A
    public void b() {
        super.b();
        F();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void b(MotionEvent motionEvent) {
        int d2;
        d c2;
        int a2;
        int a3;
        motionEvent.setLocation(motionEvent.getX(), 0.0f);
        super.b(motionEvent);
        int o = o() - this.D;
        this.D = o();
        if (o >= 0) {
            if (o <= 0 || (c2 = c((d2 = (int) (((this.w.d() + this.w.b().getBounds().width()) + h().t) / k())))) == null || d2 < (a2 = c2.f22695d - (c2.a() / 3)) || d2 <= this.F.f22695d || c2.f22693b == this.F.f22693b) {
                return;
            }
            Log.d(z, "[dragMove][R] index: " + this.F.f22693b + " -> " + c2.f22693b + ", dragTime: " + d2 + ", targetTime: " + a2 + ", endTime: " + c2.f22695d + ", duration: " + this.F.a());
            a(c2, 1);
            return;
        }
        int d3 = (int) ((this.w.d() + h().t) / k());
        d c3 = c(d3);
        if (c3 == null || d3 >= (a3 = c3.f22694c + (c3.a() / 3)) || d3 >= this.F.f22694c || c3.f22693b == this.F.f22693b) {
            return;
        }
        Log.d(z, "[dragMove][L] index: " + this.F.f22693b + " -> " + c3.f22693b + ", dragTime: " + d3 + ", targetTime: " + a3 + ", endTime: " + c3.f22695d + ", duration: " + c3.a());
        a(c3, -1);
    }

    private d b(NexPrimaryTimelineItem nexPrimaryTimelineItem) {
        if (nexPrimaryTimelineItem == null) {
            return null;
        }
        d dVar = this.H.get(nexPrimaryTimelineItem.getUniqueId());
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(nexPrimaryTimelineItem, m().getIndexOfPrimaryItem(nexPrimaryTimelineItem), nexPrimaryTimelineItem.getAbsStartTime(), nexPrimaryTimelineItem.getAbsEndTime());
        this.H.put(nexPrimaryTimelineItem.getUniqueId(), dVar2);
        return dVar2;
    }

    private static ClipThumbView a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                return a((ViewGroup) childAt);
            }
            if (childAt instanceof ClipThumbView) {
                return (ClipThumbView) childAt;
            }
        }
        return null;
    }

    public C2034o a(b bVar) {
        if (this.G == null) {
            this.G = new ArrayList();
        }
        this.G.add(bVar);
        return this;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    protected void a(I.a aVar) {
        aVar.a(new BounceInterpolator());
    }

    private void a(d dVar, int i) {
        float f2;
        int i2;
        int i3 = this.F.f22693b;
        int i4 = this.F.f22694c;
        int i5 = this.F.f22695d;
        int i6 = i5 - i4;
        float k = k();
        float f3 = this.E;
        int i7 = (int) (dVar.f22694c * k);
        this.F.f22693b = dVar.f22693b;
        dVar.f22693b = i3;
        if (i == -1) {
            this.F.f22694c = dVar.f22694c;
            this.F.f22695d = dVar.f22694c + i6;
            dVar.f22694c = i5 - dVar.a();
            dVar.f22695d = i5;
            f2 = (int) (dVar.f22694c * k);
            i2 = (int) ((i5 - dVar.a()) * k);
        } else {
            this.F.f22694c = dVar.f22695d - i6;
            this.F.f22695d = dVar.f22695d;
            dVar.f22695d = dVar.a() + i4;
            dVar.f22694c = i4;
            f2 = (int) ((dVar.f22695d - i6) * k);
            i2 = (int) (i4 * k);
        }
        Log.d(z, "[swapPrimaryItem] " + i3 + " -> " + this.F);
        e eVar = new e(n());
        eVar.a(f3);
        eVar.b(f2);
        eVar.a(new C2031l(this, f3, f2, i2, i7, dVar));
        eVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NexPrimaryTimelineItem nexPrimaryTimelineItem, int i) {
        List<b> list = this.G;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.G.get(size).a(nexPrimaryTimelineItem, i);
            }
        }
    }

    private void a(NexPrimaryTimelineItem nexPrimaryTimelineItem, int i, int i2) {
        List<b> list = this.G;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.G.get(size).a(nexPrimaryTimelineItem, i, i2);
            }
        }
    }
}
