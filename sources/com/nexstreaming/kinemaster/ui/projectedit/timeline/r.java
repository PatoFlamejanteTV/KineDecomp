package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.I;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RollingEditDragDecoration.java */
/* loaded from: classes2.dex */
public class r extends I<NexTransitionItem> {
    private final int A;
    private C2027h B;
    private float C;
    private int D;
    private List<a> E;
    private NexTimeline.c F;
    private NexTimelineItem.x<NexVideoClipItem> G;
    private NexTimelineItem.x<NexVideoClipItem> H;
    private final int z;

    /* compiled from: RollingEditDragDecoration.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(r rVar);

        void a(r rVar, NexTransitionItem nexTransitionItem, int i);

        void b(r rVar);
    }

    public r(UniformTimelineView uniformTimelineView, NexTransitionItem nexTransitionItem, MotionEvent motionEvent) {
        super(uniformTimelineView, nexTransitionItem, motionEvent);
        this.z = j().getDimensionPixelSize(R.dimen.timeline3_dragItemMaxWidth);
        this.A = c(nexTransitionItem);
        this.B = a(nexTransitionItem);
    }

    private void J() {
        List<a> list = this.E;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.E.get(size).b(this);
            }
        }
    }

    private void K() {
        List<a> list = this.E;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.E.get(size).a(this);
            }
        }
    }

    private C2027h a(NexTransitionItem nexTransitionItem) {
        View b2 = b(nexTransitionItem);
        if (b2 == null) {
            return null;
        }
        int min = Math.min(b2.getWidth(), i());
        int height = b2.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(min, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.save();
        canvas.clipRect(0, 0, min, height);
        b2.draw(canvas);
        canvas.restore();
        return new C2027h(createBitmap);
    }

    private View b(NexTransitionItem nexTransitionItem) {
        int a2 = h().a((Fa) nexTransitionItem);
        if (a2 == -1) {
            return null;
        }
        return h().a(a2);
    }

    private int c(NexTransitionItem nexTransitionItem) {
        TransitionRangeView a2 = TransitionRangeView.a(b(nexTransitionItem));
        if (a2 == null) {
            return 0;
        }
        return a2.getPaddingHorizontal() / 2;
    }

    private int d(int i) {
        NexTimelineItem.x<NexVideoClipItem> xVar = this.H;
        if (xVar == null) {
            return i;
        }
        NexVideoClipItem item = xVar.getItem();
        if (item.isImage()) {
            int duration = item.getDuration() - (this.D + i);
            int max = m().getPrimaryItemCount() == 1 ? 1000 : Math.max(item.getStartOverlap() + item.getEndOverlap() + 100, 100);
            if (duration < max) {
                return Math.min(i, (max - duration) + i);
            }
            if (duration <= 1800000) {
                return i;
            }
            if (i < 0) {
                if (item.getDuration() != 1800000) {
                    return Math.max(i, duration - 1800000);
                }
            } else {
                return Math.max(i, 1800000 - item.getDuration());
            }
        } else {
            int snapToIFrame = item.snapToIFrame(this.H.b() + this.D + i);
            if (snapToIFrame >= 0) {
                int snapToIFrame2 = item.snapToIFrame((item.getDuration() - item.getTrimTimeEnd()) - Math.round((Math.max(100, (item.getStartOverlap() + item.getEndOverlap()) + 100) * item.getPlaybackSpeed()) / 100.0f));
                if (snapToIFrame <= snapToIFrame2) {
                    return i;
                }
                if (snapToIFrame2 != item.getTrimTimeStart()) {
                    return Math.min(i, i - (snapToIFrame - snapToIFrame2));
                }
            }
        }
        return 0;
    }

    private void e(int i) {
        List<a> list = this.E;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.E.get(size).a(this, t(), i);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public r F() {
        super.F();
        List<a> list = this.E;
        if (list != null) {
            list.clear();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void H() {
        super.H();
        float absStartTime = ((t().getLeftClip().getAbsStartTime() * k()) - h().t) - this.A;
        if (this.q < absStartTime) {
            this.q = absStartTime;
        } else {
            float absEndTime = (((t().getRightClip().getAbsEndTime() * k()) - this.o.width()) - h().t) + this.A;
            if (this.q > absEndTime) {
                this.q = absEndTime;
            }
        }
        this.r = h().E;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.A
    protected int l() {
        return 2;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        C2027h c2027h;
        if (this.m && (c2027h = this.B) != null && c2027h.isValid()) {
            canvas.save();
            int floor = (((int) Math.floor((t().getUIStartTime() * k()) - h().t)) + 1) - this.A;
            int i = h().E;
            if (s().isRunning()) {
                int width = this.B.getWidth();
                int height = this.B.getHeight();
                double radians = Math.toRadians(180.0d);
                double b2 = s().b();
                Double.isNaN(b2);
                float sin = (float) Math.sin(radians * b2);
                canvas.scale((((this.z * 0.2f) / width) * sin) + 1.0f, (((h().F * 0.2f) / height) * sin) + 1.0f, (width / 2) + floor, (height / 2) + i);
            } else {
                canvas.scale(1.0f, 1.0f);
            }
            this.B.a(canvas, floor, i);
            canvas.restore();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    protected int u() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    protected boolean v() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I, com.nexstreaming.kinemaster.ui.projectedit.timeline.A
    public void b() {
        super.b();
        F();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void c(MotionEvent motionEvent) {
        super.c(motionEvent);
        this.C = motionEvent.getX();
        a(true);
        this.F = m().beginTimeChange();
        NexTimelineItem.y yVar = new NexTimelineItem.y(d(), n(), h());
        this.G = t().getLeftClip().beginTrim(yVar, 2);
        this.H = t().getRightClip().beginTrim(yVar, 1);
        K();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void b(MotionEvent motionEvent) {
        int min;
        motionEvent.setLocation(motionEvent.getX(), 0.0f);
        super.b(motionEvent);
        float x = motionEvent.getX();
        float f2 = x - this.C;
        this.C = x;
        if (f2 != 0.0f) {
            int k = (int) ((f2 / k()) + 0.5f);
            int c2 = c(k);
            int d2 = d(k);
            if (c2 == 0 || d2 == 0) {
                return;
            }
            if (c2 < 0 && d2 < 0) {
                min = Math.max(c2, d2);
            } else {
                min = Math.min(c2, d2);
            }
            this.D += min;
            NexTimelineItem.x<NexVideoClipItem> xVar = this.G;
            if (xVar != null) {
                xVar.a(this.D);
            }
            NexTimelineItem.x<NexVideoClipItem> xVar2 = this.H;
            if (xVar2 != null) {
                xVar2.a(this.D);
            }
            NexTimeline.c cVar = this.F;
            if (cVar != null) {
                cVar.apply();
            }
            e(this.D);
        }
    }

    private int c(int i) {
        NexTimelineItem.x<NexVideoClipItem> xVar = this.G;
        if (xVar == null) {
            return i;
        }
        NexVideoClipItem item = xVar.getItem();
        if (item.isImage()) {
            int duration = item.getDuration() + this.D + i;
            int max = m().getPrimaryItemCount() == 1 ? 1000 : Math.max(item.getStartOverlap() + item.getEndOverlap() + 100, 100);
            if (duration < max) {
                return Math.min(i, (max - duration) + i);
            }
            if (duration <= 1800000) {
                return i;
            }
            if (i < 0) {
                return Math.max(i, duration - 1800000);
            }
            if (item.getDuration() != 1800000) {
                return Math.min(i, 1800000 - item.getDuration());
            }
        } else {
            int b2 = this.G.b() - (this.D + i);
            if (b2 >= 0) {
                int duration2 = (item.getDuration() - item.getTrimTimeStart()) - Math.round((Math.max((item.getStartOverlap() + item.getEndOverlap()) + 100, 100) * item.getPlaybackSpeed()) / 100.0f);
                if (b2 <= duration2) {
                    return i;
                }
                if (duration2 != item.getTrimTimeEnd()) {
                    if (i < 0) {
                        return Math.max(i, (b2 - duration2) + i);
                    }
                    return Math.min(i, i - (b2 - duration2));
                }
            }
        }
        return 0;
    }

    public r a(a aVar) {
        if (this.E == null) {
            this.E = new ArrayList();
        }
        this.E.add(aVar);
        return this;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    protected void a(I.a aVar) {
        aVar.a(new BounceInterpolator());
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void d(MotionEvent motionEvent) {
        NexTimelineItem.x<NexVideoClipItem> xVar = this.G;
        if (xVar != null) {
            xVar.commit();
            this.G = null;
        }
        NexTimelineItem.x<NexVideoClipItem> xVar2 = this.H;
        if (xVar2 != null) {
            xVar2.commit();
            this.H = null;
        }
        NexTimeline.c cVar = this.F;
        if (cVar != null) {
            cVar.apply();
            this.F = null;
        }
        this.C = 0.0f;
        J();
        super.d(motionEvent);
    }
}
