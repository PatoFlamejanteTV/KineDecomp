package android.arch.persistence.room;

import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.util.Log;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* compiled from: InvalidationTracker.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f106a = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: c, reason: collision with root package name */
    private String[] f108c;

    /* renamed from: d, reason: collision with root package name */
    long[] f109d;

    /* renamed from: g, reason: collision with root package name */
    private final RoomDatabase f112g;
    private volatile b.a.b.a.f j;
    private a k;

    /* renamed from: e, reason: collision with root package name */
    private Object[] f110e = new Object[1];

    /* renamed from: f, reason: collision with root package name */
    private long f111f = 0;

    /* renamed from: h, reason: collision with root package name */
    AtomicBoolean f113h = new AtomicBoolean(false);
    private volatile boolean i = false;
    final b.a.a.b.c<b, c> l = new b.a.a.b.c<>();
    Runnable m = new d(this);

    /* renamed from: b, reason: collision with root package name */
    ArrayMap<String, Integer> f107b = new ArrayMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final long[] f114a;

        /* renamed from: b, reason: collision with root package name */
        final boolean[] f115b;

        /* renamed from: c, reason: collision with root package name */
        final int[] f116c;

        /* renamed from: d, reason: collision with root package name */
        boolean f117d;

        /* renamed from: e, reason: collision with root package name */
        boolean f118e;

        a(int i) {
            this.f114a = new long[i];
            this.f115b = new boolean[i];
            this.f116c = new int[i];
            Arrays.fill(this.f114a, 0L);
            Arrays.fill(this.f115b, false);
        }

        int[] a() {
            synchronized (this) {
                if (this.f117d && !this.f118e) {
                    int length = this.f114a.length;
                    int i = 0;
                    while (true) {
                        int i2 = 1;
                        if (i < length) {
                            boolean z = this.f114a[i] > 0;
                            if (z != this.f115b[i]) {
                                int[] iArr = this.f116c;
                                if (!z) {
                                    i2 = 2;
                                }
                                iArr[i] = i2;
                            } else {
                                this.f116c[i] = 0;
                            }
                            this.f115b[i] = z;
                            i++;
                        } else {
                            this.f118e = true;
                            this.f117d = false;
                            return this.f116c;
                        }
                    }
                }
                return null;
            }
        }

        void b() {
            synchronized (this) {
                this.f118e = false;
            }
        }
    }

    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract void a(Set<String> set);
    }

    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    static class c {

        /* renamed from: a, reason: collision with root package name */
        final int[] f119a;

        /* renamed from: b, reason: collision with root package name */
        private final String[] f120b;

        /* renamed from: c, reason: collision with root package name */
        private final long[] f121c;

        /* renamed from: d, reason: collision with root package name */
        final b f122d;

        /* renamed from: e, reason: collision with root package name */
        private final Set<String> f123e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(long[] jArr) {
            int length = this.f119a.length;
            Set<String> set = null;
            for (int i = 0; i < length; i++) {
                long j = jArr[this.f119a[i]];
                long[] jArr2 = this.f121c;
                if (jArr2[i] < j) {
                    jArr2[i] = j;
                    if (length == 1) {
                        set = this.f123e;
                    } else {
                        if (set == null) {
                            set = new ArraySet<>(length);
                        }
                        set.add(this.f120b[i]);
                    }
                }
            }
            if (set != null) {
                this.f122d.a(set);
            }
        }
    }

    public e(RoomDatabase roomDatabase, String... strArr) {
        this.f112g = roomDatabase;
        this.k = new a(strArr.length);
        int length = strArr.length;
        this.f108c = new String[length];
        for (int i = 0; i < length; i++) {
            String lowerCase = strArr[i].toLowerCase(Locale.US);
            this.f107b.put(lowerCase, Integer.valueOf(i));
            this.f108c[i] = lowerCase;
        }
        this.f109d = new long[strArr.length];
        Arrays.fill(this.f109d, 0L);
    }

    private void b(b.a.b.a.b bVar, int i) {
        String str = this.f108c[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f106a) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            a(sb, str, str2);
            bVar.b(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b.a.b.a.b bVar) {
        synchronized (this) {
            if (this.i) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.C();
            try {
                bVar.b("PRAGMA temp_store = MEMORY;");
                bVar.b("PRAGMA recursive_triggers='ON';");
                bVar.b("CREATE TEMP TABLE room_table_modification_log(version INTEGER PRIMARY KEY AUTOINCREMENT, table_id INTEGER)");
                bVar.E();
                bVar.F();
                b(bVar);
                this.j = bVar.c("DELETE FROM room_table_modification_log WHERE version NOT IN( SELECT MAX(version) FROM room_table_modification_log GROUP BY table_id)");
                this.i = true;
            } catch (Throwable th) {
                bVar.F();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        if (!this.f112g.h()) {
            return false;
        }
        if (!this.i) {
            this.f112g.f().a();
        }
        if (this.i) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(b.a.b.a.b bVar) {
        if (bVar.K()) {
            return;
        }
        while (true) {
            try {
                Lock e2 = this.f112g.e();
                e2.lock();
                try {
                    int[] a2 = this.k.a();
                    if (a2 == null) {
                        return;
                    }
                    int length = a2.length;
                    try {
                        bVar.C();
                        for (int i = 0; i < length; i++) {
                            int i2 = a2[i];
                            if (i2 == 1) {
                                a(bVar, i);
                            } else if (i2 == 2) {
                                b(bVar, i);
                            }
                        }
                        bVar.E();
                        bVar.F();
                        this.k.b();
                    } finally {
                    }
                } finally {
                    e2.unlock();
                }
            } catch (SQLiteException | IllegalStateException e3) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e3);
                return;
            }
        }
    }

    private static void a(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append(io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
        sb.append(str2);
        sb.append("`");
    }

    private void a(b.a.b.a.b bVar, int i) {
        String str = this.f108c[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f106a) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            a(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN INSERT OR REPLACE INTO ");
            sb.append("room_table_modification_log");
            sb.append(" VALUES(null, ");
            sb.append(i);
            sb.append("); END");
            bVar.b(sb.toString());
        }
    }

    public void a() {
        if (this.f113h.compareAndSet(false, true)) {
            b.a.a.a.c.b().a(this.m);
        }
    }
}
