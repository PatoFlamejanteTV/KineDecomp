package b.a.b.a.a;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import b.a.b.a.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FrameworkSQLiteOpenHelper.java */
/* loaded from: classes.dex */
public class c implements DatabaseErrorHandler {

    /* renamed from: a */
    final /* synthetic */ b[] f3244a;

    /* renamed from: b */
    final /* synthetic */ c.a f3245b;

    public c(b[] bVarArr, c.a aVar) {
        this.f3244a = bVarArr;
        this.f3245b = aVar;
    }

    @Override // android.database.DatabaseErrorHandler
    public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        b bVar = this.f3244a[0];
        if (bVar != null) {
            this.f3245b.b(bVar);
        }
    }
}
