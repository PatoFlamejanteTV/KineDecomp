package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

/* loaded from: classes.dex */
public class SqlHelper {

    /* renamed from: a */
    String f8257a;

    /* renamed from: b */
    String f8258b;

    /* renamed from: c */
    String f8259c;

    /* renamed from: d */
    String f8260d;

    /* renamed from: e */
    String f8261e;

    /* renamed from: f */
    private SQLiteStatement f8262f;

    /* renamed from: g */
    private SQLiteStatement f8263g;

    /* renamed from: h */
    private SQLiteStatement f8264h;
    private SQLiteStatement i;
    private SQLiteStatement j;
    private SQLiteStatement k;
    private SQLiteStatement l;
    private SQLiteStatement m;
    final StringBuilder n = new StringBuilder();
    final SQLiteDatabase o;
    final String p;
    final String q;
    final int r;
    final String s;
    final int t;
    final long u;

    /* loaded from: classes.dex */
    public static class Order {

        /* renamed from: a */
        final b f8265a;

        /* renamed from: b */
        final Type f8266b;

        /* loaded from: classes.dex */
        public enum Type {
            ASC,
            DESC
        }

        public Order(b bVar, Type type) {
            this.f8265a = bVar;
            this.f8266b = type;
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        final String f8267a;

        /* renamed from: b */
        final String f8268b;

        public a(String str, String str2) {
            this.f8267a = str;
            this.f8268b = str2;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        final String f8269a;

        /* renamed from: b */
        final String f8270b;

        /* renamed from: c */
        public final int f8271c;

        /* renamed from: d */
        public final a f8272d;

        /* renamed from: e */
        public final boolean f8273e;

        public b(String str, String str2, int i) {
            this(str, str2, i, null, false);
        }

        public b(String str, String str2, int i, a aVar) {
            this(str, str2, i, aVar, false);
        }

        public b(String str, String str2, int i, a aVar, boolean z) {
            this.f8269a = str;
            this.f8270b = str2;
            this.f8271c = i;
            this.f8272d = aVar;
            this.f8273e = z;
        }
    }

    public SqlHelper(SQLiteDatabase sQLiteDatabase, String str, String str2, int i, String str3, int i2, long j) {
        this.o = sQLiteDatabase;
        this.p = str;
        this.r = i;
        this.q = str2;
        this.u = j;
        this.t = i2;
        this.s = str3;
        this.f8257a = "SELECT * FROM " + str + " WHERE " + com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8283b.f8269a + " = ?";
        this.f8258b = "SELECT * FROM " + str + " WHERE " + com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8283b.f8269a + " IN ( SELECT " + com.birbit.android.jobqueue.persistentQueue.sqlite.a.n.f8269a + " FROM " + str3 + " WHERE " + com.birbit.android.jobqueue.persistentQueue.sqlite.a.o.f8269a + " = ?)";
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8283b.f8269a);
        sb.append(" FROM ");
        sb.append(str);
        this.f8259c = sb.toString();
        this.f8260d = "SELECT " + com.birbit.android.jobqueue.persistentQueue.sqlite.a.o.f8269a + " FROM job_holder_tags WHERE " + com.birbit.android.jobqueue.persistentQueue.sqlite.a.n.f8269a + " = ?";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UPDATE ");
        sb2.append(str);
        sb2.append(" SET ");
        sb2.append(com.birbit.android.jobqueue.persistentQueue.sqlite.a.l.f8269a);
        sb2.append(" = 0");
        this.f8261e = sb2.toString();
    }

    public static String a(String str, b bVar, b... bVarArr) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(str);
        sb.append(" (");
        sb.append(bVar.f8269a);
        sb.append(" ");
        sb.append(bVar.f8270b);
        sb.append("  primary key ");
        for (b bVar2 : bVarArr) {
            sb.append(", `");
            sb.append(bVar2.f8269a);
            sb.append("` ");
            sb.append(bVar2.f8270b);
            if (bVar2.f8273e) {
                sb.append(" UNIQUE");
            }
        }
        for (b bVar3 : bVarArr) {
            a aVar = bVar3.f8272d;
            if (aVar != null) {
                sb.append(", FOREIGN KEY(`");
                sb.append(bVar3.f8269a);
                sb.append("`) REFERENCES ");
                sb.append(aVar.f8267a);
                sb.append("(`");
                sb.append(aVar.f8268b);
                sb.append("`) ON DELETE CASCADE");
            }
        }
        sb.append(" );");
        com.birbit.android.jobqueue.f.c.a(sb.toString(), new Object[0]);
        return sb.toString();
    }

    public SQLiteStatement b() {
        if (this.j == null) {
            this.j = this.o.compileStatement("DELETE FROM " + this.s + " WHERE " + com.birbit.android.jobqueue.persistentQueue.sqlite.a.n.f8269a + "= ?");
        }
        return this.j;
    }

    public SQLiteStatement c() {
        if (this.i == null) {
            this.i = this.o.compileStatement("DELETE FROM " + this.p + " WHERE " + this.q + " = ?");
        }
        return this.i;
    }

    public SQLiteStatement d() {
        if (this.f8264h == null) {
            this.n.setLength(0);
            StringBuilder sb = this.n;
            sb.append("INSERT OR REPLACE INTO ");
            sb.append(this.p);
            this.n.append(" VALUES (");
            for (int i = 0; i < this.r; i++) {
                if (i != 0) {
                    this.n.append(",");
                }
                this.n.append("?");
            }
            this.n.append(")");
            this.f8264h = this.o.compileStatement(this.n.toString());
        }
        return this.f8264h;
    }

    public SQLiteStatement e() {
        if (this.f8262f == null) {
            this.n.setLength(0);
            StringBuilder sb = this.n;
            sb.append("INSERT INTO ");
            sb.append(this.p);
            this.n.append(" VALUES (");
            for (int i = 0; i < this.r; i++) {
                if (i != 0) {
                    this.n.append(",");
                }
                this.n.append("?");
            }
            this.n.append(")");
            this.f8262f = this.o.compileStatement(this.n.toString());
        }
        return this.f8262f;
    }

    public SQLiteStatement f() {
        if (this.f8263g == null) {
            this.n.setLength(0);
            StringBuilder sb = this.n;
            sb.append("INSERT INTO ");
            sb.append("job_holder_tags");
            this.n.append(" VALUES (");
            for (int i = 0; i < this.t; i++) {
                if (i != 0) {
                    this.n.append(",");
                }
                this.n.append("?");
            }
            this.n.append(")");
            this.f8263g = this.o.compileStatement(this.n.toString());
        }
        return this.f8263g;
    }

    public SQLiteStatement g() {
        if (this.m == null) {
            this.m = this.o.compileStatement("UPDATE " + this.p + " SET " + com.birbit.android.jobqueue.persistentQueue.sqlite.a.l.f8269a + " = 1  WHERE " + this.q + " = ? ");
        }
        return this.m;
    }

    public SQLiteStatement h() {
        if (this.k == null) {
            this.k = this.o.compileStatement("UPDATE " + this.p + " SET " + com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8286e.f8269a + " = ? , " + com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8289h.f8269a + " = ?  WHERE " + this.q + " = ? ");
        }
        return this.k;
    }

    public void i() {
        this.o.execSQL("DELETE FROM job_holder");
        this.o.execSQL("DELETE FROM job_holder_tags");
        j();
    }

    public void j() {
        this.o.execSQL("VACUUM");
    }

    public static String a(String str) {
        return "DROP TABLE IF EXISTS " + str;
    }

    public SQLiteStatement a() {
        if (this.l == null) {
            this.l = this.o.compileStatement("SELECT COUNT(*) FROM " + this.p + " WHERE " + com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8289h.f8269a + " != ?");
        }
        return this.l;
    }

    public String a(String str, Integer num, Order... orderArr) {
        this.n.setLength(0);
        this.n.append("SELECT * FROM ");
        this.n.append(this.p);
        if (str != null) {
            StringBuilder sb = this.n;
            sb.append(" WHERE ");
            sb.append(str);
        }
        int length = orderArr.length;
        int i = 0;
        boolean z = true;
        while (i < length) {
            Order order = orderArr[i];
            if (z) {
                this.n.append(" ORDER BY ");
            } else {
                this.n.append(",");
            }
            StringBuilder sb2 = this.n;
            sb2.append(order.f8265a.f8269a);
            sb2.append(" ");
            sb2.append(order.f8266b);
            i++;
            z = false;
        }
        if (num != null) {
            StringBuilder sb3 = this.n;
            sb3.append(" LIMIT ");
            sb3.append(num);
        }
        return this.n.toString();
    }

    public String a(String str, String str2, Integer num, Order... orderArr) {
        this.n.setLength(0);
        StringBuilder sb = this.n;
        sb.append("SELECT ");
        sb.append(str);
        sb.append(" FROM ");
        sb.append(this.p);
        if (str2 != null) {
            StringBuilder sb2 = this.n;
            sb2.append(" WHERE ");
            sb2.append(str2);
        }
        int length = orderArr.length;
        int i = 0;
        boolean z = true;
        while (i < length) {
            Order order = orderArr[i];
            if (z) {
                this.n.append(" ORDER BY ");
            } else {
                this.n.append(",");
            }
            StringBuilder sb3 = this.n;
            sb3.append(order.f8265a.f8269a);
            sb3.append(" ");
            sb3.append(order.f8266b);
            i++;
            z = false;
        }
        if (num != null) {
            StringBuilder sb4 = this.n;
            sb4.append(" LIMIT ");
            sb4.append(num);
        }
        return this.n.toString();
    }

    public static void a(StringBuilder sb, int i) {
        if (i != 0) {
            sb.append("?");
            for (int i2 = 1; i2 < i; i2++) {
                sb.append(",?");
            }
            return;
        }
        throw new IllegalArgumentException("cannot create placeholders for 0 items");
    }

    public void a(long j) {
        this.o.execSQL("UPDATE job_holder SET " + com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8288g.f8269a + "=?", new Object[]{Long.valueOf(j)});
    }
}
