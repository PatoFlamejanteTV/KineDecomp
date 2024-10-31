package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.InterfaceC0671s;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: ShapeData.java */
/* loaded from: classes.dex */
public class Oa {

    /* renamed from: a */
    private final List<L> f7669a;

    /* renamed from: b */
    private PointF f7670b;

    /* renamed from: c */
    private boolean f7671c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapeData.java */
    /* loaded from: classes.dex */
    public static class a implements InterfaceC0671s.a<Oa> {

        /* renamed from: a */
        static final a f7672a = new a();

        private a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x0027, code lost:            if (r0.has("v") != false) goto L58;     */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:            if (r0.has("v") != false) goto L58;     */
        @Override // com.airbnb.lottie.InterfaceC0671s.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.airbnb.lottie.Oa a(java.lang.Object r16, float r17) {
            /*
                Method dump skipped, instructions count: 325
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.Oa.a.a(java.lang.Object, float):com.airbnb.lottie.Oa");
        }

        private static PointF a(int i, JSONArray jSONArray) {
            if (i < jSONArray.length()) {
                JSONArray optJSONArray = jSONArray.optJSONArray(i);
                Object opt = optJSONArray.opt(0);
                Object opt2 = optJSONArray.opt(1);
                return new PointF(opt instanceof Double ? new Float(((Double) opt).doubleValue()).floatValue() : ((Integer) opt).intValue(), opt2 instanceof Double ? new Float(((Double) opt2).doubleValue()).floatValue() : ((Integer) opt2).intValue());
            }
            throw new IllegalArgumentException("Invalid index " + i + ". There are only " + jSONArray.length() + " points.");
        }
    }

    /* synthetic */ Oa(PointF pointF, boolean z, List list, Na na) {
        this(pointF, z, list);
    }

    private void a(float f2, float f3) {
        if (this.f7670b == null) {
            this.f7670b = new PointF();
        }
        this.f7670b.set(f2, f3);
    }

    public PointF b() {
        return this.f7670b;
    }

    public boolean c() {
        return this.f7671c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f7669a.size() + "closed=" + this.f7671c + '}';
    }

    private Oa(PointF pointF, boolean z, List<L> list) {
        this.f7669a = new ArrayList();
        this.f7670b = pointF;
        this.f7671c = z;
        this.f7669a.addAll(list);
    }

    public List<L> a() {
        return this.f7669a;
    }

    public void a(Oa oa, Oa oa2, float f2) {
        if (this.f7670b == null) {
            this.f7670b = new PointF();
        }
        this.f7671c = oa.c() || oa2.c();
        if (!this.f7669a.isEmpty() && this.f7669a.size() != oa.a().size() && this.f7669a.size() != oa2.a().size()) {
            throw new IllegalStateException("Curves must have the same number of control points. This: " + a().size() + "\tShape 1: " + oa.a().size() + "\tShape 2: " + oa2.a().size());
        }
        if (this.f7669a.isEmpty()) {
            for (int size = oa.a().size() - 1; size >= 0; size--) {
                this.f7669a.add(new L());
            }
        }
        PointF b2 = oa.b();
        PointF b3 = oa2.b();
        a(C0676ua.b(b2.x, b3.x, f2), C0676ua.b(b2.y, b3.y, f2));
        for (int size2 = this.f7669a.size() - 1; size2 >= 0; size2--) {
            L l = oa.a().get(size2);
            L l2 = oa2.a().get(size2);
            PointF a2 = l.a();
            PointF b4 = l.b();
            PointF c2 = l.c();
            PointF a3 = l2.a();
            PointF b5 = l2.b();
            PointF c3 = l2.c();
            this.f7669a.get(size2).a(C0676ua.b(a2.x, a3.x, f2), C0676ua.b(a2.y, a3.y, f2));
            this.f7669a.get(size2).b(C0676ua.b(b4.x, b5.x, f2), C0676ua.b(b4.y, b5.y, f2));
            this.f7669a.get(size2).c(C0676ua.b(c2.x, c3.x, f2), C0676ua.b(c2.y, c3.y, f2));
        }
    }

    public Oa() {
        this.f7669a = new ArrayList();
    }
}
