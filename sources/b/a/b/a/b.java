package b.a.b.a;

import android.database.Cursor;
import android.database.SQLException;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* compiled from: SupportSQLiteDatabase.java */
/* loaded from: classes.dex */
public interface b extends Closeable {
    void C();

    void E();

    void F();

    List<Pair<String, String>> J();

    boolean K();

    Cursor a(e eVar);

    void b(String str) throws SQLException;

    f c(String str);

    Cursor d(String str);

    String getPath();

    boolean isOpen();
}
