package android.arch.persistence.room;

import java.util.Iterator;

/* compiled from: EntityDeletionOrUpdateAdapter.java */
/* loaded from: classes.dex */
public abstract class b<T> extends j {
    public b(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public final int a(T t) {
        b.a.b.a.f a2 = a();
        try {
            a(a2, t);
            return a2.D();
        } finally {
            a(a2);
        }
    }

    protected abstract void a(b.a.b.a.f fVar, T t);

    public final int a(Iterable<T> iterable) {
        b.a.b.a.f a2 = a();
        int i = 0;
        try {
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                a(a2, it.next());
                i += a2.D();
            }
            return i;
        } finally {
            a(a2);
        }
    }
}
