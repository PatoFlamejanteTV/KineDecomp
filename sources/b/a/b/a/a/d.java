package b.a.b.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import b.a.b.a.c;

/* compiled from: FrameworkSQLiteOpenHelper.java */
/* loaded from: classes.dex */
class d implements b.a.b.a.c {

    /* renamed from: a */
    private final a f3246a;

    public d(Context context, String str, c.a aVar) {
        this.f3246a = a(context, str, aVar);
    }

    private a a(Context context, String str, c.a aVar) {
        return new a(context, str, new b[1], aVar);
    }

    @Override // b.a.b.a.c
    public void a(boolean z) {
        this.f3246a.setWriteAheadLoggingEnabled(z);
    }

    @Override // b.a.b.a.c
    public b.a.b.a.b a() {
        return this.f3246a.a();
    }

    /* compiled from: FrameworkSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {

        /* renamed from: a */
        final b[] f3247a;

        /* renamed from: b */
        final c.a f3248b;

        /* renamed from: c */
        private boolean f3249c;

        a(Context context, String str, b[] bVarArr, c.a aVar) {
            super(context, str, null, aVar.f3252a, new c(bVarArr, aVar));
            this.f3248b = aVar;
            this.f3247a = bVarArr;
        }

        synchronized b.a.b.a.b a() {
            this.f3249c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f3249c) {
                close();
                return a();
            }
            return a(writableDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f3247a[0] = null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f3248b.a(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f3248b.c(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f3249c = true;
            this.f3248b.a(a(sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.f3249c) {
                return;
            }
            this.f3248b.d(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f3249c = true;
            this.f3248b.b(a(sQLiteDatabase), i, i2);
        }

        b a(SQLiteDatabase sQLiteDatabase) {
            if (this.f3247a[0] == null) {
                this.f3247a[0] = new b(sQLiteDatabase);
            }
            return this.f3247a[0];
        }
    }
}
