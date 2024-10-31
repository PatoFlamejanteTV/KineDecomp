package android.support.constraint.solver.widgets;

/* compiled from: ResolutionDimension.java */
/* loaded from: classes.dex */
public class o extends p {

    /* renamed from: c */
    float f287c = 0.0f;

    public void a(int i) {
        if (this.f289b == 0 || this.f287c != i) {
            this.f287c = i;
            if (this.f289b == 1) {
                b();
            }
            a();
        }
    }

    @Override // android.support.constraint.solver.widgets.p
    public void d() {
        super.d();
        this.f287c = 0.0f;
    }

    public void f() {
        this.f289b = 2;
    }
}
