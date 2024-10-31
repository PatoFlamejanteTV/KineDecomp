package android.arch.persistence.room;

/* compiled from: EntityInsertionAdapter.java */
/* loaded from: classes.dex */
public abstract class c<T> extends j {
    public c(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    protected abstract void a(b.a.b.a.f fVar, T t);

    public final void a(T t) {
        b.a.b.a.f a2 = a();
        try {
            a(a2, t);
            a2.G();
        } finally {
            a(a2);
        }
    }
}
