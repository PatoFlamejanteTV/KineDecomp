package android.support.constraint.solver.widgets;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

/* compiled from: Snapshot.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private int f290a;

    /* renamed from: b, reason: collision with root package name */
    private int f291b;

    /* renamed from: c, reason: collision with root package name */
    private int f292c;

    /* renamed from: d, reason: collision with root package name */
    private int f293d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<a> f294e = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Snapshot.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private ConstraintAnchor f295a;

        /* renamed from: b, reason: collision with root package name */
        private ConstraintAnchor f296b;

        /* renamed from: c, reason: collision with root package name */
        private int f297c;

        /* renamed from: d, reason: collision with root package name */
        private ConstraintAnchor.Strength f298d;

        /* renamed from: e, reason: collision with root package name */
        private int f299e;

        public a(ConstraintAnchor constraintAnchor) {
            this.f295a = constraintAnchor;
            this.f296b = constraintAnchor.g();
            this.f297c = constraintAnchor.b();
            this.f298d = constraintAnchor.f();
            this.f299e = constraintAnchor.a();
        }

        public void a(ConstraintWidget constraintWidget) {
            constraintWidget.a(this.f295a.h()).a(this.f296b, this.f297c, this.f298d, this.f299e);
        }

        public void b(ConstraintWidget constraintWidget) {
            this.f295a = constraintWidget.a(this.f295a.h());
            ConstraintAnchor constraintAnchor = this.f295a;
            if (constraintAnchor != null) {
                this.f296b = constraintAnchor.g();
                this.f297c = this.f295a.b();
                this.f298d = this.f295a.f();
                this.f299e = this.f295a.a();
                return;
            }
            this.f296b = null;
            this.f297c = 0;
            this.f298d = ConstraintAnchor.Strength.STRONG;
            this.f299e = 0;
        }
    }

    public q(ConstraintWidget constraintWidget) {
        this.f290a = constraintWidget.v();
        this.f291b = constraintWidget.w();
        this.f292c = constraintWidget.s();
        this.f293d = constraintWidget.i();
        ArrayList<ConstraintAnchor> b2 = constraintWidget.b();
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            this.f294e.add(new a(b2.get(i)));
        }
    }

    public void a(ConstraintWidget constraintWidget) {
        constraintWidget.r(this.f290a);
        constraintWidget.s(this.f291b);
        constraintWidget.o(this.f292c);
        constraintWidget.g(this.f293d);
        int size = this.f294e.size();
        for (int i = 0; i < size; i++) {
            this.f294e.get(i).a(constraintWidget);
        }
    }

    public void b(ConstraintWidget constraintWidget) {
        this.f290a = constraintWidget.v();
        this.f291b = constraintWidget.w();
        this.f292c = constraintWidget.s();
        this.f293d = constraintWidget.i();
        int size = this.f294e.size();
        for (int i = 0; i < size; i++) {
            this.f294e.get(i).b(constraintWidget);
        }
    }
}
