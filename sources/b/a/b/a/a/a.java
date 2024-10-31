package b.a.b.a.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

/* compiled from: FrameworkSQLiteDatabase.java */
/* loaded from: classes.dex */
public class a implements SQLiteDatabase.CursorFactory {

    /* renamed from: a */
    final /* synthetic */ b.a.b.a.e f3239a;

    /* renamed from: b */
    final /* synthetic */ b f3240b;

    public a(b bVar, b.a.b.a.e eVar) {
        this.f3240b = bVar;
        this.f3239a = eVar;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this.f3239a.a(new f(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }
}
