package android.support.constraint.solver.widgets;

import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: ChainHead.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    protected ConstraintWidget f260a;

    /* renamed from: b, reason: collision with root package name */
    protected ConstraintWidget f261b;

    /* renamed from: c, reason: collision with root package name */
    protected ConstraintWidget f262c;

    /* renamed from: d, reason: collision with root package name */
    protected ConstraintWidget f263d;

    /* renamed from: e, reason: collision with root package name */
    protected ConstraintWidget f264e;

    /* renamed from: f, reason: collision with root package name */
    protected ConstraintWidget f265f;

    /* renamed from: g, reason: collision with root package name */
    protected ConstraintWidget f266g;

    /* renamed from: h, reason: collision with root package name */
    protected ArrayList<ConstraintWidget> f267h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    private int l;
    private boolean m;
    protected boolean n;
    protected boolean o;
    protected boolean p;
    private boolean q;

    public d(ConstraintWidget constraintWidget, int i, boolean z) {
        this.m = false;
        this.f260a = constraintWidget;
        this.l = i;
        this.m = z;
    }

    private static boolean a(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget.r() != 8 && constraintWidget.F[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int[] iArr = constraintWidget.f259h;
            if (iArr[i] == 0 || iArr[i] == 3) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        int i = this.l * 2;
        boolean z = false;
        ConstraintWidget constraintWidget = this.f260a;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z2 = false;
        while (!z2) {
            this.i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.sa;
            int i2 = this.l;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i2] = null;
            constraintWidget.ra[i2] = null;
            if (constraintWidget.r() != 8) {
                if (this.f261b == null) {
                    this.f261b = constraintWidget;
                }
                this.f263d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.F;
                int i3 = this.l;
                if (dimensionBehaviourArr[i3] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    int[] iArr = constraintWidget.f259h;
                    if (iArr[i3] == 0 || iArr[i3] == 3 || iArr[i3] == 2) {
                        this.j++;
                        float[] fArr = constraintWidget.qa;
                        int i4 = this.l;
                        float f2 = fArr[i4];
                        if (f2 > 0.0f) {
                            this.k += fArr[i4];
                        }
                        if (a(constraintWidget, this.l)) {
                            if (f2 < 0.0f) {
                                this.n = true;
                            } else {
                                this.o = true;
                            }
                            if (this.f267h == null) {
                                this.f267h = new ArrayList<>();
                            }
                            this.f267h.add(constraintWidget);
                        }
                        if (this.f265f == null) {
                            this.f265f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f266g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.ra[this.l] = constraintWidget;
                        }
                        this.f266g = constraintWidget;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.sa[this.l] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.D[i + 1].f247d;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f245b;
                ConstraintAnchor[] constraintAnchorArr = constraintWidget5.D;
                if (constraintAnchorArr[i].f247d != null && constraintAnchorArr[i].f247d.f245b == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z2 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        this.f262c = constraintWidget;
        if (this.l == 0 && this.m) {
            this.f264e = this.f262c;
        } else {
            this.f264e = this.f260a;
        }
        if (this.o && this.n) {
            z = true;
        }
        this.p = z;
    }

    public void a() {
        if (!this.q) {
            b();
        }
        this.q = true;
    }
}
