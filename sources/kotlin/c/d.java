package kotlin.c;

/* compiled from: Ranges.kt */
/* loaded from: classes3.dex */
public final class d extends b implements kotlin.c.a<Integer> {

    /* renamed from: f */
    public static final a f28508f = new a(null);

    /* renamed from: e */
    private static final d f28507e = new d(1, 0);

    /* compiled from: Ranges.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final d a() {
            return d.f28507e;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public d(int i, int i2) {
        super(i, i2, 1);
    }

    public Integer e() {
        return Integer.valueOf(getLast());
    }

    @Override // kotlin.c.b
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (getFirst() != dVar.getFirst() || getLast() != dVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    public Integer f() {
        return Integer.valueOf(getFirst());
    }

    @Override // kotlin.c.b
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.c.b
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // kotlin.c.b
    public String toString() {
        return getFirst() + ".." + getLast();
    }
}
