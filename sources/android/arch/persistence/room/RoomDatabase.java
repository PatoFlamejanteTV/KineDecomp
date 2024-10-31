package android.arch.persistence.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import b.a.b.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public abstract class RoomDatabase {

    /* renamed from: a */
    protected volatile b.a.b.a.b f58a;

    /* renamed from: b */
    private b.a.b.a.c f59b;

    /* renamed from: d */
    private boolean f61d;

    /* renamed from: e */
    boolean f62e;

    /* renamed from: f */
    protected List<b> f63f;

    /* renamed from: g */
    private final ReentrantLock f64g = new ReentrantLock();

    /* renamed from: c */
    private final e f60c = c();

    /* loaded from: classes.dex */
    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        @SuppressLint({"NewApi"})
        JournalMode resolve(Context context) {
            ActivityManager activityManager;
            if (this != AUTOMATIC) {
                return this;
            }
            if (Build.VERSION.SDK_INT >= 16 && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && !ActivityManagerCompat.isLowRamDevice(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public void a(b.a.b.a.b bVar) {
        }

        public void b(b.a.b.a.b bVar) {
        }
    }

    protected abstract b.a.b.a.c a(android.arch.persistence.room.a aVar);

    public void a() {
        if (!this.f61d && b.a.a.a.c.b().a()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void b(android.arch.persistence.room.a aVar) {
        this.f59b = a(aVar);
        if (Build.VERSION.SDK_INT >= 16) {
            r1 = aVar.f80g == JournalMode.WRITE_AHEAD_LOGGING;
            this.f59b.a(r1);
        }
        this.f63f = aVar.f78e;
        this.f61d = aVar.f79f;
        this.f62e = r1;
    }

    protected abstract e c();

    public void d() {
        this.f59b.a().F();
        if (g()) {
            return;
        }
        this.f60c.a();
    }

    public Lock e() {
        return this.f64g;
    }

    public b.a.b.a.c f() {
        return this.f59b;
    }

    public boolean g() {
        return this.f59b.a().K();
    }

    public boolean h() {
        b.a.b.a.b bVar = this.f58a;
        return bVar != null && bVar.isOpen();
    }

    public void i() {
        this.f59b.a().E();
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        private SparseArrayCompat<SparseArrayCompat<android.arch.persistence.room.a.a>> f73a = new SparseArrayCompat<>();

        public void a(android.arch.persistence.room.a.a... aVarArr) {
            for (android.arch.persistence.room.a.a aVar : aVarArr) {
                a(aVar);
            }
        }

        private void a(android.arch.persistence.room.a.a aVar) {
            int i = aVar.f82a;
            int i2 = aVar.f83b;
            SparseArrayCompat<android.arch.persistence.room.a.a> sparseArrayCompat = this.f73a.get(i);
            if (sparseArrayCompat == null) {
                sparseArrayCompat = new SparseArrayCompat<>();
                this.f73a.put(i, sparseArrayCompat);
            }
            android.arch.persistence.room.a.a aVar2 = sparseArrayCompat.get(i2);
            if (aVar2 != null) {
                Log.w("ROOM", "Overriding migration " + aVar2 + " with " + aVar);
            }
            sparseArrayCompat.append(i2, aVar);
        }

        public List<android.arch.persistence.room.a.a> a(int i, int i2) {
            if (i == i2) {
                return Collections.emptyList();
            }
            return a(new ArrayList(), i2 > i, i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0019 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.util.List<android.arch.persistence.room.a.a> a(java.util.List<android.arch.persistence.room.a.a> r11, boolean r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = -1
                r1 = 1
                if (r12 == 0) goto L6
                r2 = -1
                goto L7
            L6:
                r2 = 1
            L7:
                if (r12 == 0) goto Lc
                if (r13 >= r14) goto L4d
                goto Le
            Lc:
                if (r13 <= r14) goto L4d
            Le:
                android.support.v4.util.SparseArrayCompat<android.support.v4.util.SparseArrayCompat<android.arch.persistence.room.a.a>> r3 = r10.f73a
                java.lang.Object r3 = r3.get(r13)
                android.support.v4.util.SparseArrayCompat r3 = (android.support.v4.util.SparseArrayCompat) r3
                r4 = 0
                if (r3 != 0) goto L1a
                return r4
            L1a:
                int r5 = r3.size()
                r6 = 0
                if (r12 == 0) goto L25
                int r5 = r5 + (-1)
                r7 = -1
                goto L27
            L25:
                r7 = r5
                r5 = 0
            L27:
                if (r5 == r7) goto L4a
                int r8 = r3.keyAt(r5)
                if (r12 == 0) goto L37
                if (r8 > r14) goto L35
                if (r8 <= r13) goto L35
            L33:
                r9 = 1
                goto L3c
            L35:
                r9 = 0
                goto L3c
            L37:
                if (r8 < r14) goto L35
                if (r8 >= r13) goto L35
                goto L33
            L3c:
                if (r9 == 0) goto L48
                java.lang.Object r13 = r3.valueAt(r5)
                r11.add(r13)
                r13 = r8
                r6 = 1
                goto L4a
            L48:
                int r5 = r5 + r2
                goto L27
            L4a:
                if (r6 != 0) goto L7
                return r4
            L4d:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: android.arch.persistence.room.RoomDatabase.c.a(java.util.List, boolean, int, int):java.util.List");
        }
    }

    public Cursor a(String str, Object[] objArr) {
        return this.f59b.a().a(new b.a.b.a.a(str, objArr));
    }

    public Cursor a(b.a.b.a.e eVar) {
        a();
        return this.f59b.a().a(eVar);
    }

    /* loaded from: classes.dex */
    public static class a<T extends RoomDatabase> {

        /* renamed from: a */
        private final Class<T> f65a;

        /* renamed from: b */
        private final String f66b;

        /* renamed from: c */
        private final Context f67c;

        /* renamed from: d */
        private ArrayList<b> f68d;

        /* renamed from: e */
        private c.InterfaceC0008c f69e;

        /* renamed from: f */
        private boolean f70f;

        /* renamed from: g */
        private JournalMode f71g = JournalMode.AUTOMATIC;

        /* renamed from: h */
        private boolean f72h = true;
        private final c i = new c();
        private Set<Integer> j;
        private Set<Integer> k;

        public a(Context context, Class<T> cls, String str) {
            this.f67c = context;
            this.f65a = cls;
            this.f66b = str;
        }

        public a<T> a(android.arch.persistence.room.a.a... aVarArr) {
            if (this.k == null) {
                this.k = new HashSet();
            }
            for (android.arch.persistence.room.a.a aVar : aVarArr) {
                this.k.add(Integer.valueOf(aVar.f82a));
                this.k.add(Integer.valueOf(aVar.f83b));
            }
            this.i.a(aVarArr);
            return this;
        }

        public T a() {
            if (this.f67c != null) {
                if (this.f65a != null) {
                    Set<Integer> set = this.k;
                    if (set != null && this.j != null) {
                        for (Integer num : set) {
                            if (this.j.contains(num)) {
                                throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                            }
                        }
                    }
                    if (this.f69e == null) {
                        this.f69e = new b.a.b.a.a.e();
                    }
                    Context context = this.f67c;
                    android.arch.persistence.room.a aVar = new android.arch.persistence.room.a(context, this.f66b, this.f69e, this.i, this.f68d, this.f70f, this.f71g.resolve(context), this.f72h, this.j);
                    T t = (T) f.a(this.f65a, "_Impl");
                    t.b(aVar);
                    return t;
                }
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }
    }

    public b.a.b.a.f a(String str) {
        a();
        return this.f59b.a().c(str);
    }

    public void b() {
        a();
        b.a.b.a.b a2 = this.f59b.a();
        this.f60c.b(a2);
        a2.C();
    }

    public void a(b.a.b.a.b bVar) {
        this.f60c.a(bVar);
    }
}
