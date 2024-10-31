package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.tagmanager.DataLayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements DataLayer.zzc {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2218a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");
    private final Executor b;
    private final Context c;
    private a d;
    private zzmn e;
    private int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends SQLiteOpenHelper {
        a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str : rawQuery.getColumnNames()) {
                    hashSet.add(str);
                }
                rawQuery.close();
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                }
                if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean a(java.lang.String r11, android.database.sqlite.SQLiteDatabase r12) {
            /*
                r10 = this;
                r8 = 0
                r9 = 0
                java.lang.String r1 = "SQLITE_MASTER"
                r0 = 1
                java.lang.String[] r2 = new java.lang.String[r0]     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L45
                r0 = 0
                java.lang.String r3 = "name"
                r2[r0] = r3     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L45
                java.lang.String r3 = "name=?"
                r0 = 1
                java.lang.String[] r4 = new java.lang.String[r0]     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L45
                r0 = 0
                r4[r0] = r11     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L45
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r12
                android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L45
                boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteException -> L53
                if (r1 == 0) goto L25
                r1.close()
            L25:
                return r0
            L26:
                r0 = move-exception
                r0 = r9
            L28:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
                r1.<init>()     // Catch: java.lang.Throwable -> L4f
                java.lang.String r2 = "Error querying for table "
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L4f
                java.lang.StringBuilder r1 = r1.append(r11)     // Catch: java.lang.Throwable -> L4f
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L4f
                com.google.android.gms.tagmanager.zzbg.b(r1)     // Catch: java.lang.Throwable -> L4f
                if (r0 == 0) goto L43
                r0.close()
            L43:
                r0 = r8
                goto L25
            L45:
                r0 = move-exception
            L46:
                if (r9 == 0) goto L4b
                r9.close()
            L4b:
                throw r0
            L4c:
                r0 = move-exception
                r9 = r1
                goto L46
            L4f:
                r1 = move-exception
                r9 = r0
                r0 = r1
                goto L46
            L53:
                r0 = move-exception
                r0 = r1
                goto L28
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.ar.a.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                ar.this.c.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            j.a(sQLiteDatabase.getPath());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (a("datalayer", sQLiteDatabase)) {
                a(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(ar.f2218a);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final String f2220a;
        final byte[] b;

        b(String str, byte[] bArr) {
            this.f2220a = str;
            this.b = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.f2220a + " serialized hash = " + Arrays.hashCode(this.b);
        }
    }

    public ar(Context context) {
        this(context, zzmp.zzqt(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    ar(Context context, zzmn zzmnVar, String str, int i, Executor executor) {
        this.c = context;
        this.e = zzmnVar;
        this.f = i;
        this.b = executor;
        this.d = new a(this.c, str);
    }

    private SQLiteDatabase a(String str) {
        try {
            return this.d.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.b(str);
            return null;
        }
    }

    private Object a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Throwable th;
        Object obj = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
        } catch (IOException e) {
            objectInputStream = null;
        } catch (ClassNotFoundException e2) {
            objectInputStream = null;
        } catch (Throwable th2) {
            objectInputStream = null;
            th = th2;
        }
        try {
            obj = objectInputStream.readObject();
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e3) {
                }
            }
            byteArrayInputStream.close();
        } catch (IOException e4) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e5) {
                }
            }
            byteArrayInputStream.close();
            return obj;
        } catch (ClassNotFoundException e6) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e7) {
                }
            }
            byteArrayInputStream.close();
            return obj;
        } catch (Throwable th3) {
            th = th3;
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e8) {
                    throw th;
                }
            }
            byteArrayInputStream.close();
            throw th;
        }
        return obj;
    }

    private List<DataLayer.a> a(List<b> list) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            arrayList.add(new DataLayer.a(bVar.f2220a, a(bVar.b)));
        }
        return arrayList;
    }

    private void a(int i) {
        int d = (d() - this.f) + i;
        if (d > 0) {
            List<String> b2 = b(d);
            zzbg.c("DataLayer store full, deleting " + b2.size() + " entries to make room.");
            a((String[]) b2.toArray(new String[0]));
        }
    }

    private void a(long j) {
        SQLiteDatabase a2 = a("Error opening database for deleteOlderThan.");
        if (a2 == null) {
            return;
        }
        try {
            zzbg.d("Deleted " + a2.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
        } catch (SQLiteException e) {
            zzbg.b("Error deleting old entries.");
        }
    }

    private void a(String[] strArr) {
        SQLiteDatabase a2;
        if (strArr == null || strArr.length == 0 || (a2 = a("Error opening database for deleteEntries.")) == null) {
            return;
        }
        try {
            a2.delete("datalayer", String.format("%s in (%s)", "ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
        } catch (SQLiteException e) {
            zzbg.b("Error deleting entries " + Arrays.toString(strArr));
        }
    }

    private byte[] a(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] bArr = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (IOException e) {
            objectOutputStream = null;
        } catch (Throwable th2) {
            objectOutputStream = null;
            th = th2;
        }
        try {
            objectOutputStream.writeObject(obj);
            bArr = byteArrayOutputStream.toByteArray();
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e2) {
                }
            }
            byteArrayOutputStream.close();
        } catch (IOException e3) {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e4) {
                }
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            th = th3;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e5) {
                    throw th;
                }
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DataLayer.a> b() {
        try {
            a(this.e.currentTimeMillis());
            return a(c());
        } finally {
            e();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:            if (r1.moveToFirst() != false) goto L12;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:            r9.add(java.lang.String.valueOf(r1.getLong(0)));     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:            if (r1.moveToNext() != false) goto L37;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:            if (r1 == null) goto L16;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:            r1.close();     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<java.lang.String> b(int r14) {
        /*
            r13 = this;
            r10 = 0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            if (r14 > 0) goto Lf
            java.lang.String r0 = "Invalid maxEntries specified. Skipping."
            com.google.android.gms.tagmanager.zzbg.b(r0)
            r0 = r9
        Le:
            return r0
        Lf:
            java.lang.String r0 = "Error opening database for peekEntryIds."
            android.database.sqlite.SQLiteDatabase r0 = r13.a(r0)
            if (r0 != 0) goto L19
            r0 = r9
            goto Le
        L19:
            java.lang.String r1 = "datalayer"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: android.database.sqlite.SQLiteException -> L5c java.lang.Throwable -> L7e
            r3 = 0
            java.lang.String r4 = "ID"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L5c java.lang.Throwable -> L7e
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "%s ASC"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: android.database.sqlite.SQLiteException -> L5c java.lang.Throwable -> L7e
            r11 = 0
            java.lang.String r12 = "ID"
            r8[r11] = r12     // Catch: android.database.sqlite.SQLiteException -> L5c java.lang.Throwable -> L7e
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch: android.database.sqlite.SQLiteException -> L5c java.lang.Throwable -> L7e
            java.lang.String r8 = java.lang.Integer.toString(r14)     // Catch: android.database.sqlite.SQLiteException -> L5c java.lang.Throwable -> L7e
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: android.database.sqlite.SQLiteException -> L5c java.lang.Throwable -> L7e
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L88
            if (r0 == 0) goto L55
        L43:
            r0 = 0
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L88
            r9.add(r0)     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L88
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L88
            if (r0 != 0) goto L43
        L55:
            if (r1 == 0) goto L5a
            r1.close()
        L5a:
            r0 = r9
            goto Le
        L5c:
            r0 = move-exception
            r1 = r10
        L5e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L86
            r2.<init>()     // Catch: java.lang.Throwable -> L86
            java.lang.String r3 = "Error in peekEntries fetching entryIds: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L86
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.tagmanager.zzbg.b(r0)     // Catch: java.lang.Throwable -> L86
            if (r1 == 0) goto L5a
            r1.close()
            goto L5a
        L7e:
            r0 = move-exception
            r1 = r10
        L80:
            if (r1 == 0) goto L85
            r1.close()
        L85:
            throw r0
        L86:
            r0 = move-exception
            goto L80
        L88:
            r0 = move-exception
            goto L5e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.ar.b(int):java.util.List");
    }

    private List<b> b(List<DataLayer.a> list) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.a aVar : list) {
            arrayList.add(new b(aVar.f2204a, a(aVar.b)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(List<b> list, long j) {
        try {
            long currentTimeMillis = this.e.currentTimeMillis();
            a(currentTimeMillis);
            a(list.size());
            c(list, currentTimeMillis + j);
        } finally {
            e();
        }
    }

    private List<b> c() {
        SQLiteDatabase a2 = a("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (a2 == null) {
            return arrayList;
        }
        Cursor query = a2.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private void c(List<b> list, long j) {
        SQLiteDatabase a2 = a("Error opening database for writeEntryToDatabase.");
        if (a2 == null) {
            return;
        }
        for (b bVar : list) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("expires", Long.valueOf(j));
            contentValues.put("key", bVar.f2220a);
            contentValues.put("value", bVar.b);
            a2.insert("datalayer", null, contentValues);
        }
    }

    private int d() {
        Cursor cursor = null;
        SQLiteDatabase a2 = a("Error opening database for getNumStoredEntries.");
        try {
            if (a2 != null) {
                try {
                    cursor = a2.rawQuery("SELECT COUNT(*) from datalayer", null);
                    r0 = cursor.moveToFirst() ? (int) cursor.getLong(0) : 0;
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteException e) {
                    zzbg.b("Error getting numStoredEntries");
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            return r0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private void e() {
        try {
            this.d.close();
        } catch (SQLiteException e) {
        }
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void a(DataLayer.zzc.zza zzaVar) {
        this.b.execute(new at(this, zzaVar));
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void a(List<DataLayer.a> list, long j) {
        this.b.execute(new as(this, b(list), j));
    }
}
