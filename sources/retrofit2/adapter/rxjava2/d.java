package retrofit2.adapter.rxjava2;

import javax.annotation.Nullable;
import retrofit2.D;

/* compiled from: Result.java */
/* loaded from: classes3.dex */
public final class d<T> {

    /* renamed from: a */
    @Nullable
    private final D<T> f29473a;

    /* renamed from: b */
    @Nullable
    private final Throwable f29474b;

    private d(@Nullable D<T> d2, @Nullable Throwable th) {
        this.f29473a = d2;
        this.f29474b = th;
    }

    public static <T> d<T> a(Throwable th) {
        if (th != null) {
            return new d<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> d<T> a(D<T> d2) {
        if (d2 != null) {
            return new d<>(d2, null);
        }
        throw new NullPointerException("response == null");
    }
}
