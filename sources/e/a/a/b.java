package e.a.a;

import com.google.common.primitives.Longs;
import javax.annotation.concurrent.Immutable;

/* compiled from: Timestamp.java */
@Immutable
/* loaded from: classes3.dex */
public abstract class b implements Comparable<b> {

    /* renamed from: a */
    private static final b f26734a = new a(0, 0);

    public static b a(long j, int i) {
        if (j < -315576000000L || j > 315576000000L) {
            return f26734a;
        }
        if (i >= 0 && i <= 999999999) {
            return new a(j, i);
        }
        return f26734a;
    }

    public abstract int a();

    public abstract long d();

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        int a2 = Longs.a(d(), bVar.d());
        return a2 != 0 ? a2 : Longs.a(a(), bVar.a());
    }
}
