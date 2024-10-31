package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.c;

/* compiled from: UMDBCreater.java */
/* loaded from: classes3.dex */
public class d extends SQLiteOpenHelper {

    /* renamed from: b */
    private static Context f25868b;

    /* renamed from: a */
    private String f25869a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMDBCreater.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        private static final d f25870a = new d(d.f25868b, f.b(d.f25868b), c.f25810b, null, 2);

        private a() {
        }
    }

    /* synthetic */ d(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i, AnonymousClass1 anonymousClass1) {
        this(context, str, str2, cursorFactory, i);
    }

    public static d a(Context context) {
        if (f25868b == null) {
            f25868b = context.getApplicationContext();
        }
        return a.f25870a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f25869a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f25869a);
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f25869a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f25869a);
        } catch (SQLException unused) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!f.a(sQLiteDatabase, c.d.f25851a, "__av")) {
            f.a(sQLiteDatabase, c.d.f25851a, "__sp", "TEXT");
            f.a(sQLiteDatabase, c.d.f25851a, "__pp", "TEXT");
            f.a(sQLiteDatabase, c.d.f25851a, "__av", "TEXT");
            f.a(sQLiteDatabase, c.d.f25851a, "__vc", "TEXT");
        }
        if (!f.a(sQLiteDatabase, c.b.f25825a, "__av")) {
            f.a(sQLiteDatabase, c.b.f25825a, "__av", "TEXT");
            f.a(sQLiteDatabase, c.b.f25825a, "__vc", "TEXT");
        }
        if (f.a(sQLiteDatabase, c.a.f25814a, "__av")) {
            return;
        }
        f.a(sQLiteDatabase, c.a.f25814a, "__av", "TEXT");
        f.a(sQLiteDatabase, c.a.f25814a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, c.d.f25851a);
        a(sQLiteDatabase, c.b.f25825a);
        a(sQLiteDatabase, c.a.f25814a);
        a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (SQLiteDatabaseCorruptException unused) {
                f.a(f25868b);
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= i || i != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                e(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            f(sQLiteDatabase);
        }
    }

    private d(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new com.umeng.analytics.pro.a(context, str), str2, cursorFactory, i);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f25869a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f25869a);
        } catch (SQLException unused) {
        }
    }

    private d(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, TextUtils.isEmpty(str) ? c.f25810b : str, cursorFactory, i);
        this.f25869a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!f.a(c.d.f25851a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!f.a(c.C0139c.f25838a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!f.a(c.b.f25825a, writableDatabase)) {
                b(writableDatabase);
            }
            if (f.a(c.a.f25814a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f25869a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f25869a);
        } catch (SQLException unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
