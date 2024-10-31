package b.a.b.a.a;

import android.database.sqlite.SQLiteProgram;

/* compiled from: FrameworkSQLiteProgram.java */
/* loaded from: classes.dex */
class f implements b.a.b.a.d {

    /* renamed from: a */
    private final SQLiteProgram f3250a;

    public f(SQLiteProgram sQLiteProgram) {
        this.f3250a = sQLiteProgram;
    }

    @Override // b.a.b.a.d
    public void a(int i, double d2) {
        this.f3250a.bindDouble(i, d2);
    }

    @Override // b.a.b.a.d
    public void b(int i, long j) {
        this.f3250a.bindLong(i, j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3250a.close();
    }

    @Override // b.a.b.a.d
    public void f(int i) {
        this.f3250a.bindNull(i);
    }

    @Override // b.a.b.a.d
    public void a(int i, String str) {
        this.f3250a.bindString(i, str);
    }

    @Override // b.a.b.a.d
    public void a(int i, byte[] bArr) {
        this.f3250a.bindBlob(i, bArr);
    }
}
