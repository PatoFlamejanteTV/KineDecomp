package android.arch.persistence.room;

import android.database.Cursor;
import b.a.b.a.c;
import java.util.Iterator;
import java.util.List;

/* compiled from: RoomOpenHelper.java */
/* loaded from: classes.dex */
public class h extends c.a {

    /* renamed from: b, reason: collision with root package name */
    private android.arch.persistence.room.a f124b;

    /* renamed from: c, reason: collision with root package name */
    private final a f125c;

    /* renamed from: d, reason: collision with root package name */
    private final String f126d;

    /* renamed from: e, reason: collision with root package name */
    private final String f127e;

    /* compiled from: RoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f128a;

        public a(int i) {
            this.f128a = i;
        }

        protected abstract void a(b.a.b.a.b bVar);

        protected abstract void b(b.a.b.a.b bVar);

        protected abstract void c(b.a.b.a.b bVar);

        protected abstract void d(b.a.b.a.b bVar);

        protected abstract void e(b.a.b.a.b bVar);
    }

    public h(android.arch.persistence.room.a aVar, a aVar2, String str, String str2) {
        super(aVar2.f128a);
        this.f124b = aVar;
        this.f125c = aVar2;
        this.f126d = str;
        this.f127e = str2;
    }

    private void e(b.a.b.a.b bVar) {
        if (g(bVar)) {
            Cursor a2 = bVar.a(new b.a.b.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                r1 = a2.moveToFirst() ? a2.getString(0) : null;
            } finally {
                a2.close();
            }
        }
        if (!this.f126d.equals(r1) && !this.f127e.equals(r1)) {
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
        }
    }

    private void f(b.a.b.a.b bVar) {
        bVar.b("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean g(b.a.b.a.b bVar) {
        Cursor d2 = bVar.d("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (d2.moveToFirst()) {
                if (d2.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            d2.close();
        }
    }

    private void h(b.a.b.a.b bVar) {
        f(bVar);
        bVar.b(g.a(this.f126d));
    }

    @Override // b.a.b.a.c.a
    public void a(b.a.b.a.b bVar) {
        super.a(bVar);
    }

    @Override // b.a.b.a.c.a
    public void b(b.a.b.a.b bVar, int i, int i2) {
        boolean z;
        List<android.arch.persistence.room.a.a> a2;
        android.arch.persistence.room.a aVar = this.f124b;
        if (aVar == null || (a2 = aVar.f77d.a(i, i2)) == null) {
            z = false;
        } else {
            Iterator<android.arch.persistence.room.a.a> it = a2.iterator();
            while (it.hasNext()) {
                it.next().a(bVar);
            }
            this.f125c.e(bVar);
            h(bVar);
            z = true;
        }
        if (z) {
            return;
        }
        android.arch.persistence.room.a aVar2 = this.f124b;
        if (aVar2 != null && !aVar2.a(i)) {
            this.f125c.b(bVar);
            this.f125c.a(bVar);
            return;
        }
        throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    @Override // b.a.b.a.c.a
    public void c(b.a.b.a.b bVar) {
        h(bVar);
        this.f125c.a(bVar);
        this.f125c.c(bVar);
    }

    @Override // b.a.b.a.c.a
    public void d(b.a.b.a.b bVar) {
        super.d(bVar);
        e(bVar);
        this.f125c.d(bVar);
        this.f124b = null;
    }

    @Override // b.a.b.a.c.a
    public void a(b.a.b.a.b bVar, int i, int i2) {
        b(bVar, i, i2);
    }
}
