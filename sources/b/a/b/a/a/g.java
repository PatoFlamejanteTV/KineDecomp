package b.a.b.a.a;

import android.database.sqlite.SQLiteStatement;

/* compiled from: FrameworkSQLiteStatement.java */
/* loaded from: classes.dex */
class g extends f implements b.a.b.a.f {

    /* renamed from: b */
    private final SQLiteStatement f3251b;

    public g(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f3251b = sQLiteStatement;
    }

    @Override // b.a.b.a.f
    public int D() {
        return this.f3251b.executeUpdateDelete();
    }

    @Override // b.a.b.a.f
    public long G() {
        return this.f3251b.executeInsert();
    }
}
