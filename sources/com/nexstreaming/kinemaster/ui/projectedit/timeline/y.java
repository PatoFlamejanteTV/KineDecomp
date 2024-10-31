package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.BounceInterpolator;
import com.nexstreaming.kinemaster.editorwrapper.Ea;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.I;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SecondaryTrackDragDecoration.java */
/* loaded from: classes2.dex */
public class y extends I {
    private static final String z = "y";
    private final boolean A;
    private final z B;
    private float C;
    private int D;
    private int E;
    protected List<a> F;

    /* compiled from: SecondaryTrackDragDecoration.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(I i, InterfaceC2024e interfaceC2024e, int i2);

        void a(I i, InterfaceC2024e interfaceC2024e, int i2, int i3);

        void a(I i, InterfaceC2024e interfaceC2024e, int i2, int i3, int i4);
    }

    public y(UniformTimelineView uniformTimelineView, Fa fa, MotionEvent motionEvent) {
        super(uniformTimelineView, fa, motionEvent);
        this.A = c(fa) > 1;
        this.B = b(fa);
        this.D = m().getTrackIdByItem(fa);
        this.E = this.D;
    }

    private int J() {
        int round = (Math.round(this.r) - this.p.getBounds().top) + Math.round(h().u);
        if (round < 0) {
            int width = this.p.getBounds().left + (this.p.getBounds().width() / 2);
            int i = this.p.getBounds().top + round;
            int c2 = h().c(width, i);
            Log.d(z, "[findTargetTrackId]- trackId: " + c2 + ", y: " + i + ", dy: " + round + ", scrollY: " + h().u);
            return c2;
        }
        if (round <= 0) {
            return -1;
        }
        int width2 = this.p.getBounds().left + (this.p.getBounds().width() / 2);
        int i2 = this.p.getBounds().bottom + round;
        int c3 = h().c(width2, i2);
        Log.d(z, "[findTargetTrackId]+ trackId: " + c3 + ", y: " + i2 + ", dy: " + round + ", scrollY: " + h().u);
        return c3;
    }

    public static /* synthetic */ int a(y yVar) {
        return yVar.D;
    }

    public static /* synthetic */ int b(y yVar) {
        return yVar.E;
    }

    private int c(Fa fa) {
        if (fa instanceof M) {
            return ((M) fa).a().e();
        }
        if (fa instanceof Ea) {
            return ((Ea) fa).e();
        }
        if (fa instanceof NexSecondaryTimelineItem) {
            return ((NexSecondaryTimelineItem) fa).getTrack().e();
        }
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void C() {
        b(this.D, this.E);
        super.C();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void D() {
        super.D();
        h().a(new C2042x(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void H() {
        super.H();
        float g2 = (-h().u) + h().g();
        float height = (((h().w - h().u) + h().E) - (this.p.getBounds().height() - (h().G * m().getRequiredSubTrackCount()))) + (h().G / 2);
        if (this.r < g2) {
            this.r = g2;
        }
        if (this.r > height) {
            this.r = height;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void d(MotionEvent motionEvent) {
        super.d(motionEvent);
        if (s().isRunning()) {
            s().cancel();
        }
        s().start();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.A
    protected int l() {
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        z zVar;
        if (this.m && (zVar = this.B) != null && zVar.isValid()) {
            canvas.save();
            z zVar2 = this.B;
            if ((zVar2 instanceof Q) && this.A) {
                int height = zVar2.getHeight();
                int i = h().F;
                int i2 = h().G + i + (i / 2);
                float b2 = s().b();
                if (this.n) {
                    z zVar3 = this.B;
                    float f2 = this.C;
                    zVar3.a((1.0f - f2) + (f2 * b2));
                    this.B.a(i2 + ((int) ((height - i2) * b2)));
                } else {
                    this.B.a(1.0f - (this.C * b2));
                    this.B.a(height - ((int) ((height - i2) * b2)));
                }
            } else if (!this.n) {
                int width = this.B.getWidth();
                int height2 = this.B.getHeight();
                double radians = Math.toRadians(180.0d);
                double b3 = s().b();
                Double.isNaN(b3);
                float sin = (((float) Math.sin(radians * b3)) * 0.2f) + 1.0f;
                canvas.scale(sin, sin, this.q + (width / 2), this.r + (height2 / 2));
            }
            this.B.a(canvas, 0.0f, this.r);
            canvas.restore();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    protected int u() {
        if (this.t == 0) {
            return 0;
        }
        int trackIdByItem = m().getTrackIdByItem(t());
        int J = J();
        Log.d(z, "[getItemDropState] sourceTrackId: " + trackIdByItem + ", targetTrackId: " + J);
        Rect c2 = h().c(J);
        Log.d(z, "[getItemDropState] dragBounds: " + this.o + ", targetBounds: " + c2);
        if (this.t == -1) {
            if (this.o.centerY() < c2.centerY()) {
                return 5;
            }
            if (trackIdByItem != J) {
                return 6;
            }
        } else {
            if (this.o.centerY() > c2.centerY()) {
                return 6;
            }
            if (trackIdByItem != J) {
                return 5;
            }
        }
        return 0;
    }

    public static /* synthetic */ void a(y yVar, int i, int i2, int i3) {
        yVar.a(i, i2, i3);
    }

    private z b(Fa fa) {
        if (!(fa instanceof M)) {
            return null;
        }
        this.C = Math.min(c(fa) * 0.1f, 0.5f);
        return new Q(h(), ((M) fa).a());
    }

    public y a(a aVar) {
        if (this.F == null) {
            this.F = new ArrayList();
        }
        if (!this.F.contains(aVar)) {
            this.F.add(aVar);
        }
        return this;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void b(MotionEvent motionEvent) {
        motionEvent.setLocation(0.0f, motionEvent.getY());
        super.b(motionEvent);
        int J = J();
        if (J != -1) {
            this.E = J;
        }
        a(this.D, this.E, -((Math.round(this.r) - this.p.getBounds().top) + Math.round(h().u)));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    protected void a(I.a aVar) {
        if (this.A) {
            aVar.a(new FastOutSlowInInterpolator());
        } else {
            aVar.a(new BounceInterpolator());
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void c(MotionEvent motionEvent) {
        super.c(motionEvent);
        c(this.D);
    }

    private void c(int i) {
        List<a> list = this.F;
        if (list == null || i == -1) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            this.F.get(size).a(this, this.w, i);
        }
    }

    public void a(int i, int i2, int i3) {
        List<a> list = this.F;
        if (list == null || i == -1 || i2 == -1) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            this.F.get(size).a(this, this.w, i, i2, i3);
        }
    }

    private void b(int i, int i2) {
        List<a> list = this.F;
        if (list == null || i == -1) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            this.F.get(size).a(this, this.w, i, i2);
        }
    }
}
