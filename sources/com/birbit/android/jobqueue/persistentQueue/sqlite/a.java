package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.birbit.android.jobqueue.persistentQueue.sqlite.SqlHelper;
import com.facebook.internal.AnalyticsEvents;

/* compiled from: DbOpenHelper.java */
/* loaded from: classes.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: a */
    static final SqlHelper.b f8282a = new SqlHelper.b("insertionOrder", "integer", 0);

    /* renamed from: b */
    static final SqlHelper.b f8283b = new SqlHelper.b("_id", "text", 1, null, true);

    /* renamed from: c */
    static final SqlHelper.b f8284c = new SqlHelper.b("priority", "integer", 2);

    /* renamed from: d */
    static final SqlHelper.b f8285d = new SqlHelper.b("group_id", "text", 3);

    /* renamed from: e */
    static final SqlHelper.b f8286e = new SqlHelper.b("run_count", "integer", 4);

    /* renamed from: f */
    static final SqlHelper.b f8287f = new SqlHelper.b("created_ns", "long", 5);

    /* renamed from: g */
    static final SqlHelper.b f8288g = new SqlHelper.b("delay_until_ns", "long", 6);

    /* renamed from: h */
    static final SqlHelper.b f8289h = new SqlHelper.b("running_session_id", "long", 7);
    static final SqlHelper.b i = new SqlHelper.b("network_type", "integer", 8);
    static final SqlHelper.b j = new SqlHelper.b("deadline", "integer", 9);
    static final SqlHelper.b k = new SqlHelper.b("cancel_on_deadline", "integer", 10);
    static final SqlHelper.b l = new SqlHelper.b(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, "integer", 11);
    static final SqlHelper.b m = new SqlHelper.b("_id", "integer", 0);
    static final SqlHelper.b n = new SqlHelper.b("job_id", "text", 1, new SqlHelper.a("job_holder", f8283b.f8269a));
    static final SqlHelper.b o = new SqlHelper.b("tag_name", "text", 2);

    public a(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 12);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE job_holder ADD COLUMN " + l.f8269a + " " + l.f8270b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SqlHelper.a("job_holder", f8282a, f8283b, f8284c, f8285d, f8286e, f8287f, f8288g, f8289h, i, j, k, l));
        sQLiteDatabase.execSQL(SqlHelper.a("job_holder_tags", m, n, o));
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS TAG_NAME_INDEX ON job_holder_tags(" + o.f8269a + ")");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        onUpgrade(sQLiteDatabase, i2, i3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 == 11) {
            a(sQLiteDatabase);
            return;
        }
        sQLiteDatabase.execSQL(SqlHelper.a("job_holder"));
        sQLiteDatabase.execSQL(SqlHelper.a("job_holder_tags"));
        sQLiteDatabase.execSQL("DROP INDEX IF EXISTS TAG_NAME_INDEX");
        onCreate(sQLiteDatabase);
    }
}
