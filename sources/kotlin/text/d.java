package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;

/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public final class d implements Iterator<kotlin.c.d>, kotlin.jvm.internal.a.a {

    /* renamed from: a, reason: collision with root package name */
    private int f28555a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f28556b;

    /* renamed from: c, reason: collision with root package name */
    private int f28557c;

    /* renamed from: d, reason: collision with root package name */
    private kotlin.c.d f28558d;

    /* renamed from: e, reason: collision with root package name */
    private int f28559e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ e f28560f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        int i;
        CharSequence charSequence;
        int a2;
        this.f28560f = eVar;
        i = eVar.f28562b;
        charSequence = eVar.f28561a;
        a2 = kotlin.c.h.a(i, 0, charSequence.length());
        this.f28556b = a2;
        this.f28557c = this.f28556b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:            if (r0 < r4) goto L9;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b() {
        /*
            r6 = this;
            int r0 = r6.f28557c
            r1 = 0
            if (r0 >= 0) goto Lc
            r6.f28555a = r1
            r0 = 0
            r6.f28558d = r0
            goto La2
        Lc:
            kotlin.text.e r0 = r6.f28560f
            int r0 = kotlin.text.e.c(r0)
            r2 = -1
            r3 = 1
            if (r0 <= 0) goto L25
            int r0 = r6.f28559e
            int r0 = r0 + r3
            r6.f28559e = r0
            int r0 = r6.f28559e
            kotlin.text.e r4 = r6.f28560f
            int r4 = kotlin.text.e.c(r4)
            if (r0 >= r4) goto L33
        L25:
            int r0 = r6.f28557c
            kotlin.text.e r4 = r6.f28560f
            java.lang.CharSequence r4 = kotlin.text.e.b(r4)
            int r4 = r4.length()
            if (r0 <= r4) goto L49
        L33:
            int r0 = r6.f28556b
            kotlin.c.d r1 = new kotlin.c.d
            kotlin.text.e r4 = r6.f28560f
            java.lang.CharSequence r4 = kotlin.text.e.b(r4)
            int r4 = kotlin.text.w.a(r4)
            r1.<init>(r0, r4)
            r6.f28558d = r1
            r6.f28557c = r2
            goto La0
        L49:
            kotlin.text.e r0 = r6.f28560f
            kotlin.jvm.a.c r0 = kotlin.text.e.a(r0)
            kotlin.text.e r4 = r6.f28560f
            java.lang.CharSequence r4 = kotlin.text.e.b(r4)
            int r5 = r6.f28557c
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.invoke(r4, r5)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L79
            int r0 = r6.f28556b
            kotlin.c.d r1 = new kotlin.c.d
            kotlin.text.e r4 = r6.f28560f
            java.lang.CharSequence r4 = kotlin.text.e.b(r4)
            int r4 = kotlin.text.w.a(r4)
            r1.<init>(r0, r4)
            r6.f28558d = r1
            r6.f28557c = r2
            goto La0
        L79:
            java.lang.Object r2 = r0.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.component2()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r4 = r6.f28556b
            kotlin.c.d r4 = kotlin.c.e.d(r4, r2)
            r6.f28558d = r4
            int r2 = r2 + r0
            r6.f28556b = r2
            int r2 = r6.f28556b
            if (r0 != 0) goto L9d
            r1 = 1
        L9d:
            int r2 = r2 + r1
            r6.f28557c = r2
        La0:
            r6.f28555a = r3
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.d.b():void");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f28555a == -1) {
            b();
        }
        return this.f28555a == 1;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public kotlin.c.d next() {
        if (this.f28555a == -1) {
            b();
        }
        if (this.f28555a != 0) {
            kotlin.c.d dVar = this.f28558d;
            if (dVar != null) {
                this.f28558d = null;
                this.f28555a = -1;
                return dVar;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        throw new NoSuchElementException();
    }
}
