package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.birbit.android.jobqueue.persistentQueue.sqlite.SqlHelper;

/* compiled from: Where.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    static final String f8291a = Long.toString(Long.MIN_VALUE);

    /* renamed from: b */
    static final String f8292b = Long.toString(Long.MAX_VALUE);

    /* renamed from: c */
    public final long f8293c;

    /* renamed from: d */
    public final String f8294d;

    /* renamed from: e */
    public final String[] f8295e;

    /* renamed from: f */
    private SQLiteStatement f8296f;

    /* renamed from: g */
    private String f8297g;

    /* renamed from: h */
    private SQLiteStatement f8298h;
    private String i;

    public c(long j, String str, String[] strArr) {
        this.f8293c = j;
        this.f8294d = str;
        this.f8295e = strArr;
    }

    public SQLiteStatement a(SQLiteDatabase sQLiteDatabase, StringBuilder sb) {
        SQLiteStatement sQLiteStatement = this.f8296f;
        if (sQLiteStatement == null) {
            sb.setLength(0);
            sb.append("SELECT SUM(case WHEN ");
            sb.append(a.f8285d.f8269a);
            sb.append(" is null then group_cnt else 1 end) from (");
            sb.append("SELECT count(*) group_cnt, ");
            sb.append(a.f8285d.f8269a);
            sb.append(" FROM ");
            sb.append("job_holder");
            sb.append(" WHERE ");
            sb.append(this.f8294d);
            sb.append(" GROUP BY ");
            sb.append(a.f8285d.f8269a);
            sb.append(")");
            this.f8296f = sQLiteDatabase.compileStatement(sb.toString());
        } else {
            sQLiteStatement.clearBindings();
        }
        int i = 1;
        while (true) {
            String[] strArr = this.f8295e;
            if (i <= strArr.length) {
                this.f8296f.bindString(i, strArr[i - 1]);
                i++;
            } else {
                return this.f8296f;
            }
        }
    }

    public String b(SqlHelper sqlHelper) {
        if (this.i == null) {
            this.i = sqlHelper.a(this.f8294d, (Integer) 1, new SqlHelper.Order(a.f8284c, SqlHelper.Order.Type.DESC), new SqlHelper.Order(a.f8287f, SqlHelper.Order.Type.ASC), new SqlHelper.Order(a.f8282a, SqlHelper.Order.Type.ASC));
        }
        return this.i;
    }

    public SQLiteStatement a(SQLiteDatabase sQLiteDatabase, SqlHelper sqlHelper) {
        SQLiteStatement sQLiteStatement = this.f8298h;
        if (sQLiteStatement == null) {
            String a2 = sqlHelper.a(a.j.f8269a, this.f8294d, null, new SqlHelper.Order[0]);
            String a3 = sqlHelper.a(a.f8288g.f8269a, this.f8294d, null, new SqlHelper.Order[0]);
            StringBuilder sb = sqlHelper.n;
            sb.setLength(0);
            sb.append("SELECT * FROM (");
            sb.append(a2);
            sb.append(" ORDER BY 1 ASC LIMIT 1");
            sb.append(") UNION SELECT * FROM (");
            sb.append(a3);
            sb.append(" ORDER BY 1 ASC LIMIT 1");
            sb.append(") ORDER BY 1 ASC LIMIT 1");
            this.f8298h = sQLiteDatabase.compileStatement(sb.toString());
        } else {
            sQLiteStatement.clearBindings();
        }
        int i = 1;
        while (true) {
            String[] strArr = this.f8295e;
            if (i <= strArr.length) {
                int i2 = i - 1;
                this.f8298h.bindString(i, strArr[i2]);
                SQLiteStatement sQLiteStatement2 = this.f8298h;
                String[] strArr2 = this.f8295e;
                sQLiteStatement2.bindString(strArr2.length + i, strArr2[i2]);
                i++;
            } else {
                this.f8298h.bindString(1, f8292b);
                this.f8298h.bindString(this.f8295e.length + 1, f8291a);
                return this.f8298h;
            }
        }
    }

    public String a(SqlHelper sqlHelper) {
        if (this.f8297g == null) {
            this.f8297g = sqlHelper.a(this.f8294d, (Integer) null, new SqlHelper.Order[0]);
        }
        return this.f8297g;
    }

    public void a() {
        SQLiteStatement sQLiteStatement = this.f8296f;
        if (sQLiteStatement != null) {
            sQLiteStatement.close();
            this.f8296f = null;
        }
        SQLiteStatement sQLiteStatement2 = this.f8298h;
        if (sQLiteStatement2 != null) {
            sQLiteStatement2.close();
            this.f8298h = null;
        }
    }
}
