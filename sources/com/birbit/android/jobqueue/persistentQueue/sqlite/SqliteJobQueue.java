package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteStatement;
import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.h;
import com.birbit.android.jobqueue.p;
import com.birbit.android.jobqueue.v;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class SqliteJobQueue implements v {

    /* renamed from: a, reason: collision with root package name */
    private com.birbit.android.jobqueue.persistentQueue.sqlite.a f8274a;

    /* renamed from: b, reason: collision with root package name */
    private final long f8275b;

    /* renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f8276c;

    /* renamed from: d, reason: collision with root package name */
    private SqlHelper f8277d;

    /* renamed from: e, reason: collision with root package name */
    private b f8278e;

    /* renamed from: f, reason: collision with root package name */
    private com.birbit.android.jobqueue.persistentQueue.sqlite.b f8279f;

    /* renamed from: g, reason: collision with root package name */
    private final StringBuilder f8280g = new StringBuilder();

    /* renamed from: h, reason: collision with root package name */
    private final e f8281h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InvalidJobException extends Exception {
        InvalidJobException(String str) {
            super(str);
        }

        InvalidJobException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes.dex */
    public static class a implements b {
        @Override // com.birbit.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue.b
        public <T extends Job> T a(byte[] bArr) throws IOException, ClassNotFoundException {
            ObjectInputStream objectInputStream;
            ObjectInputStream objectInputStream2 = null;
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
            } catch (Throwable th) {
                th = th;
            }
            try {
                T t = (T) objectInputStream.readObject();
                objectInputStream.close();
                return t;
            } catch (Throwable th2) {
                th = th2;
                objectInputStream2 = objectInputStream;
                if (objectInputStream2 != null) {
                    objectInputStream2.close();
                }
                throw th;
            }
        }

        @Override // com.birbit.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue.b
        public byte[] serialize(Object obj) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream;
            if (obj == null) {
                return null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        <T extends Job> T a(byte[] bArr) throws IOException, ClassNotFoundException;

        byte[] serialize(Object obj) throws IOException;
    }

    public SqliteJobQueue(com.birbit.android.jobqueue.c.b bVar, long j, b bVar2) {
        String str;
        this.f8275b = j;
        this.f8279f = new com.birbit.android.jobqueue.persistentQueue.sqlite.b(bVar.b(), "jobs_" + bVar.f());
        this.f8281h = new e(j);
        Context b2 = bVar.b();
        if (bVar.p()) {
            str = null;
        } else {
            str = "db_" + bVar.f();
        }
        this.f8274a = new com.birbit.android.jobqueue.persistentQueue.sqlite.a(b2, str);
        this.f8276c = this.f8274a.getWritableDatabase();
        this.f8277d = new SqlHelper(this.f8276c, "job_holder", com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8283b.f8269a, 12, "job_holder_tags", 3, j);
        this.f8278e = bVar2;
        if (bVar.q()) {
            this.f8277d.a(Long.MIN_VALUE);
        }
        b();
        a();
    }

    private void a() {
        Cursor rawQuery = this.f8276c.rawQuery(this.f8277d.f8259c, null);
        HashSet hashSet = new HashSet();
        while (rawQuery.moveToNext()) {
            try {
                hashSet.add(rawQuery.getString(0));
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }
        rawQuery.close();
        this.f8279f.a(hashSet);
    }

    private void b() {
        this.f8276c.execSQL(this.f8277d.f8261e);
    }

    private boolean e(p pVar) {
        SQLiteStatement e2 = this.f8277d.e();
        SQLiteStatement f2 = this.f8277d.f();
        this.f8276c.beginTransaction();
        try {
            try {
                e2.clearBindings();
                a(e2, pVar);
                if (e2.executeInsert() != -1) {
                    for (String str : pVar.m()) {
                        f2.clearBindings();
                        a(f2, pVar.e(), str);
                        f2.executeInsert();
                    }
                    this.f8276c.setTransactionSuccessful();
                    return true;
                }
            } catch (Throwable th) {
                com.birbit.android.jobqueue.f.c.a(th, "error while inserting job with tags", new Object[0]);
            }
            return false;
        } finally {
            this.f8276c.endTransaction();
        }
    }

    private void f(p pVar) {
        try {
            this.f8279f.a(pVar.e(), this.f8278e.serialize(pVar.g()));
        } catch (IOException e2) {
            throw new RuntimeException("cannot save job to disk", e2);
        }
    }

    private void g(p pVar) {
        SQLiteStatement h2 = this.f8277d.h();
        pVar.c(pVar.k() + 1);
        pVar.c(this.f8275b);
        h2.clearBindings();
        h2.bindLong(1, pVar.k());
        h2.bindLong(2, this.f8275b);
        h2.bindString(3, pVar.e());
        h2.execute();
    }

    @Override // com.birbit.android.jobqueue.v
    public int c(h hVar) {
        return (int) e(hVar).a(this.f8276c, this.f8280g).simpleQueryForLong();
    }

    @Override // com.birbit.android.jobqueue.v
    public void clear() {
        this.f8277d.i();
        a();
    }

    @Override // com.birbit.android.jobqueue.v
    public int count() {
        SQLiteStatement a2 = this.f8277d.a();
        a2.clearBindings();
        a2.bindLong(1, this.f8275b);
        return (int) a2.simpleQueryForLong();
    }

    @Override // com.birbit.android.jobqueue.v
    public boolean d(p pVar) {
        if (pVar.f() == null) {
            return a(pVar);
        }
        f(pVar);
        pVar.c(Long.MIN_VALUE);
        SQLiteStatement d2 = this.f8277d.d();
        d2.clearBindings();
        a(d2, pVar);
        boolean z = d2.executeInsert() != -1;
        com.birbit.android.jobqueue.f.c.a("reinsert job result %s", Boolean.valueOf(z));
        return z;
    }

    @Override // com.birbit.android.jobqueue.v
    public void b(p pVar) {
        b(pVar.e());
    }

    private void b(String str) {
        this.f8276c.beginTransaction();
        try {
            SQLiteStatement c2 = this.f8277d.c();
            c2.clearBindings();
            c2.bindString(1, str);
            c2.execute();
            SQLiteStatement b2 = this.f8277d.b();
            b2.bindString(1, str);
            b2.execute();
            this.f8276c.setTransactionSuccessful();
            this.f8279f.a(str);
        } finally {
            this.f8276c.endTransaction();
        }
    }

    @Override // com.birbit.android.jobqueue.v
    public void c(p pVar) {
        SQLiteStatement g2 = this.f8277d.g();
        g2.clearBindings();
        g2.bindString(1, pVar.e());
        g2.execute();
    }

    private Set<String> c(String str) {
        Cursor rawQuery = this.f8276c.rawQuery(this.f8277d.f8260d, new String[]{str});
        try {
            if (rawQuery.getCount() == 0) {
                return Collections.EMPTY_SET;
            }
            HashSet hashSet = new HashSet();
            while (rawQuery.moveToNext()) {
                hashSet.add(rawQuery.getString(0));
            }
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    @Override // com.birbit.android.jobqueue.v
    public boolean a(p pVar) {
        f(pVar);
        if (pVar.q()) {
            return e(pVar);
        }
        SQLiteStatement e2 = this.f8277d.e();
        e2.clearBindings();
        a(e2, pVar);
        long executeInsert = e2.executeInsert();
        pVar.b(executeInsert);
        return executeInsert != -1;
    }

    @Override // com.birbit.android.jobqueue.v
    public p d(h hVar) {
        c e2 = e(hVar);
        String b2 = e2.b(this.f8277d);
        while (true) {
            Cursor rawQuery = this.f8276c.rawQuery(b2, e2.f8295e);
            try {
                if (!rawQuery.moveToNext()) {
                    return null;
                }
                p a2 = a(rawQuery);
                g(a2);
                return a2;
            } catch (InvalidJobException unused) {
                String string = rawQuery.getString(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8283b.f8271c);
                if (string == null) {
                    com.birbit.android.jobqueue.f.c.b("cannot find job id on a retrieved job", new Object[0]);
                } else {
                    b(string);
                }
            } finally {
                rawQuery.close();
            }
        }
    }

    @Override // com.birbit.android.jobqueue.v
    public Long b(h hVar) {
        try {
            long simpleQueryForLong = e(hVar).a(this.f8276c, this.f8277d).simpleQueryForLong();
            if (simpleQueryForLong == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(simpleQueryForLong);
        } catch (SQLiteDoneException unused) {
            return null;
        }
    }

    private c e(h hVar) {
        return this.f8281h.a(hVar, this.f8280g);
    }

    @Override // com.birbit.android.jobqueue.v
    public void a(p pVar, p pVar2) {
        this.f8276c.beginTransaction();
        try {
            b(pVar2);
            a(pVar);
            this.f8276c.setTransactionSuccessful();
        } finally {
            this.f8276c.endTransaction();
        }
    }

    private void a(SQLiteStatement sQLiteStatement, String str, String str2) {
        sQLiteStatement.bindString(com.birbit.android.jobqueue.persistentQueue.sqlite.a.n.f8271c + 1, str);
        sQLiteStatement.bindString(com.birbit.android.jobqueue.persistentQueue.sqlite.a.o.f8271c + 1, str2);
    }

    private void a(SQLiteStatement sQLiteStatement, p pVar) {
        if (pVar.f() != null) {
            sQLiteStatement.bindLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8282a.f8271c + 1, pVar.f().longValue());
        }
        sQLiteStatement.bindString(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8283b.f8271c + 1, pVar.e());
        sQLiteStatement.bindLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8284c.f8271c + 1, pVar.h());
        if (pVar.d() != null) {
            sQLiteStatement.bindString(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8285d.f8271c + 1, pVar.d());
        }
        sQLiteStatement.bindLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8286e.f8271c + 1, pVar.k());
        sQLiteStatement.bindLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8287f.f8271c + 1, pVar.a());
        sQLiteStatement.bindLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8288g.f8271c + 1, pVar.c());
        sQLiteStatement.bindLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8289h.f8271c + 1, pVar.l());
        sQLiteStatement.bindLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.i.f8271c + 1, pVar.i());
        sQLiteStatement.bindLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.j.f8271c + 1, pVar.b());
        sQLiteStatement.bindLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.k.f8271c + 1, pVar.v() ? 1L : 0L);
        sQLiteStatement.bindLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.l.f8271c + 1, pVar.r() ? 1L : 0L);
    }

    @Override // com.birbit.android.jobqueue.v
    public p a(String str) {
        Cursor rawQuery = this.f8276c.rawQuery(this.f8277d.f8257a, new String[]{str});
        try {
            if (rawQuery.moveToFirst()) {
                return a(rawQuery);
            }
            return null;
        } catch (InvalidJobException e2) {
            com.birbit.android.jobqueue.f.c.a(e2, "invalid job on findJobById", new Object[0]);
            return null;
        } finally {
            rawQuery.close();
        }
    }

    @Override // com.birbit.android.jobqueue.v
    public Set<p> a(h hVar) {
        c e2 = e(hVar);
        Cursor rawQuery = this.f8276c.rawQuery(e2.a(this.f8277d), e2.f8295e);
        HashSet hashSet = new HashSet();
        while (rawQuery.moveToNext()) {
            try {
                try {
                    hashSet.add(a(rawQuery));
                } catch (InvalidJobException e3) {
                    com.birbit.android.jobqueue.f.c.a(e3, "invalid job found by tags.", new Object[0]);
                }
            } finally {
                rawQuery.close();
            }
        }
        return hashSet;
    }

    private p a(Cursor cursor) throws InvalidJobException {
        String string = cursor.getString(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8283b.f8271c);
        try {
            Job a2 = a(this.f8279f.b(string));
            if (a2 != null) {
                Set<String> c2 = c(string);
                p.a aVar = new p.a();
                aVar.c(cursor.getLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8282a.f8271c));
                aVar.a(cursor.getInt(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8284c.f8271c));
                aVar.a(cursor.getString(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8285d.f8271c));
                aVar.c(cursor.getInt(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8286e.f8271c));
                aVar.a(a2);
                aVar.b(string);
                aVar.a(c2);
                aVar.a(true);
                aVar.a(cursor.getLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.j.f8271c), cursor.getInt(com.birbit.android.jobqueue.persistentQueue.sqlite.a.k.f8271c) == 1);
                aVar.a(cursor.getLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8287f.f8271c));
                aVar.b(cursor.getLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8288g.f8271c));
                aVar.d(cursor.getLong(com.birbit.android.jobqueue.persistentQueue.sqlite.a.f8289h.f8271c));
                aVar.b(cursor.getInt(com.birbit.android.jobqueue.persistentQueue.sqlite.a.i.f8271c));
                return aVar.a();
            }
            throw new InvalidJobException("null job");
        } catch (IOException e2) {
            throw new InvalidJobException("cannot load job from disk", e2);
        }
    }

    private Job a(byte[] bArr) {
        try {
            return this.f8278e.a(bArr);
        } catch (Throwable th) {
            com.birbit.android.jobqueue.f.c.a(th, "error while deserializing job", new Object[0]);
            return null;
        }
    }
}
