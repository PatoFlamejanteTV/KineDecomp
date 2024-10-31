package android.arch.persistence.room;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SharedSQLiteStatement.java */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a */
    private final AtomicBoolean f137a = new AtomicBoolean(false);

    /* renamed from: b */
    private final RoomDatabase f138b;

    /* renamed from: c */
    private volatile b.a.b.a.f f139c;

    public j(RoomDatabase roomDatabase) {
        this.f138b = roomDatabase;
    }

    private b.a.b.a.f a(boolean z) {
        if (z) {
            if (this.f139c == null) {
                this.f139c = d();
            }
            return this.f139c;
        }
        return d();
    }

    private b.a.b.a.f d() {
        return this.f138b.a(c());
    }

    protected void b() {
        this.f138b.a();
    }

    protected abstract String c();

    public b.a.b.a.f a() {
        b();
        return a(this.f137a.compareAndSet(false, true));
    }

    public void a(b.a.b.a.f fVar) {
        if (fVar == this.f139c) {
            this.f137a.set(false);
        }
    }
}
