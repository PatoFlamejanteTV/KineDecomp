package b.a.b.a.a;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FrameworkSQLiteDatabase.java */
/* loaded from: classes.dex */
public class b implements b.a.b.a.b {

    /* renamed from: a */
    private static final String[] f3241a = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: b */
    private static final String[] f3242b = new String[0];

    /* renamed from: c */
    private final SQLiteDatabase f3243c;

    public b(SQLiteDatabase sQLiteDatabase) {
        this.f3243c = sQLiteDatabase;
    }

    @Override // b.a.b.a.b
    public void C() {
        this.f3243c.beginTransaction();
    }

    @Override // b.a.b.a.b
    public void E() {
        this.f3243c.setTransactionSuccessful();
    }

    @Override // b.a.b.a.b
    public void F() {
        this.f3243c.endTransaction();
    }

    @Override // b.a.b.a.b
    public List<Pair<String, String>> J() {
        return this.f3243c.getAttachedDbs();
    }

    @Override // b.a.b.a.b
    public boolean K() {
        return this.f3243c.inTransaction();
    }

    @Override // b.a.b.a.b
    public Cursor a(b.a.b.a.e eVar) {
        return this.f3243c.rawQueryWithFactory(new a(this, eVar), eVar.a(), f3242b, null);
    }

    @Override // b.a.b.a.b
    public void b(String str) throws SQLException {
        this.f3243c.execSQL(str);
    }

    @Override // b.a.b.a.b
    public b.a.b.a.f c(String str) {
        return new g(this.f3243c.compileStatement(str));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3243c.close();
    }

    @Override // b.a.b.a.b
    public Cursor d(String str) {
        return a(new b.a.b.a.a(str));
    }

    @Override // b.a.b.a.b
    public String getPath() {
        return this.f3243c.getPath();
    }

    @Override // b.a.b.a.b
    public boolean isOpen() {
        return this.f3243c.isOpen();
    }
}
