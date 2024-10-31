package c.d.b.e;

import android.util.SparseArray;

/* compiled from: SeekableParticleSystem.java */
/* loaded from: classes.dex */
public class f implements c {

    /* renamed from: a */
    private final c f3791a;

    /* renamed from: c */
    private final int f3793c;

    /* renamed from: d */
    private int f3794d;

    /* renamed from: b */
    private int f3792b = 0;

    /* renamed from: e */
    private SparseArray<d> f3795e = new SparseArray<>();

    /* compiled from: SeekableParticleSystem.java */
    /* loaded from: classes.dex */
    private static class a implements d {

        /* renamed from: a */
        public final int f3796a;

        /* synthetic */ a(int i, e eVar) {
            this(i);
        }

        private a(int i) {
            this.f3796a = i;
        }
    }

    private f(c cVar, int i, int i2) {
        this.f3791a = cVar;
        this.f3793c = i;
        this.f3794d = i2;
        cVar.rewind();
    }

    public static f a(c cVar, int i, int i2) {
        if (cVar instanceof f) {
            f fVar = (f) cVar;
            return (fVar.f3793c == i && fVar.f3794d == i2) ? fVar : new f(fVar.f3791a, i, i2);
        }
        return new f(cVar, i, i2);
    }

    @Override // c.d.b.e.c
    public d b() {
        return new a((this.f3792b * 1000) / this.f3793c);
    }

    @Override // c.d.b.e.c
    public void c() {
        this.f3792b++;
        this.f3791a.c();
        int i = this.f3792b;
        if (i > 0 && i % 480 == 0 && this.f3795e.get(i) == null) {
            this.f3795e.put(this.f3792b, this.f3791a.b());
        }
    }

    public int d() {
        return this.f3794d;
    }

    @Override // c.d.b.e.c
    public void rewind() {
        this.f3792b = 0;
        this.f3791a.rewind();
    }

    @Override // c.d.b.e.c
    public int a() {
        return this.f3791a.a();
    }

    @Override // c.d.b.e.c
    public boolean a(int i, b bVar) {
        return this.f3791a.a(i, bVar);
    }

    @Override // c.d.b.e.c
    public void a(d dVar) {
        a(((a) dVar).f3796a);
    }

    public void a(int i) {
        int i2 = (i * this.f3793c) / 1000;
        int i3 = this.f3792b;
        if (i2 == i3) {
            return;
        }
        if (i2 < i3) {
            for (int i4 = i2 - (i2 % 480); i4 > 0; i4 -= 480) {
                d dVar = this.f3795e.get(i4);
                if (dVar != null) {
                    this.f3791a.a(dVar);
                    this.f3792b = i4;
                    while (this.f3792b < i2) {
                        c();
                    }
                    return;
                }
            }
            rewind();
        }
        while (this.f3792b < i2) {
            c();
        }
    }
}
