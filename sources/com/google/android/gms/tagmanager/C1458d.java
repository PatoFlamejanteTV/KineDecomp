package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzdf;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.protos.datapol.SemanticAnnotations;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tagmanager.d */
/* loaded from: classes2.dex */
public final class C1458d implements DataLayer.c {

    /* renamed from: a */
    private static final String f14190a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");

    /* renamed from: b */
    private final Executor f14191b;

    /* renamed from: c */
    private final Context f14192c;

    /* renamed from: d */
    private C1461g f14193d;

    /* renamed from: e */
    private Clock f14194e;

    /* renamed from: f */
    private int f14195f;

    public C1458d(Context context) {
        this(context, DefaultClock.d(), "google_tagmanager.db", SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE, zzdf.zzgp().zzr(com.google.android.gms.internal.gtm.zzdi.zzadg));
    }

    public final List<DataLayer.a> b() {
        try {
            a(this.f14194e.a());
            List<h> c2 = c();
            ArrayList arrayList = new ArrayList();
            for (h hVar : c2) {
                arrayList.add(new DataLayer.a(hVar.f14202a, a(hVar.f14203b)));
            }
            return arrayList;
        } finally {
            e();
        }
    }

    private final List<h> c() {
        SQLiteDatabase a2 = a("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (a2 == null) {
            return arrayList;
        }
        Cursor query = a2.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new h(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private final int d() {
        SQLiteDatabase a2 = a("Error opening database for getNumStoredEntries.");
        if (a2 == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = a2.rawQuery("SELECT COUNT(*) from datalayer", null);
                r1 = cursor.moveToFirst() ? (int) cursor.getLong(0) : 0;
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException unused) {
                zzdi.b("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            }
            return r1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final void e() {
        try {
            this.f14193d.close();
        } catch (SQLiteException unused) {
        }
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.c
    public final void a(List<DataLayer.a> list, long j) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.a aVar : list) {
            arrayList.add(new h(aVar.f14171a, a(aVar.f14172b)));
        }
        this.f14191b.execute(new RunnableC1459e(this, arrayList, j));
    }

    @VisibleForTesting
    private C1458d(Context context, Clock clock, String str, int i, Executor executor) {
        this.f14192c = context;
        this.f14194e = clock;
        this.f14195f = SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE;
        this.f14191b = executor;
        this.f14193d = new C1461g(this, this.f14192c, str);
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.c
    public final void a(zzaq zzaqVar) {
        this.f14191b.execute(new RunnableC1460f(this, zzaqVar));
    }

    private static Object a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2 = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
        } catch (IOException unused) {
            objectInputStream = null;
        } catch (ClassNotFoundException unused2) {
            objectInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Object readObject = objectInputStream.readObject();
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (IOException unused3) {
            }
            return readObject;
        } catch (IOException unused4) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException unused5) {
                    return null;
                }
            }
            byteArrayInputStream.close();
            return null;
        } catch (ClassNotFoundException unused6) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException unused7) {
                    return null;
                }
            }
            byteArrayInputStream.close();
            return null;
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            if (objectInputStream2 != null) {
                try {
                    objectInputStream2.close();
                } catch (IOException unused8) {
                    throw th;
                }
            }
            byteArrayInputStream.close();
            throw th;
        }
    }

    public final synchronized void b(List<h> list, long j) {
        SQLiteDatabase a2;
        try {
            long a3 = this.f14194e.a();
            a(a3);
            int d2 = (d() - this.f14195f) + list.size();
            if (d2 > 0) {
                List<String> a4 = a(d2);
                int size = a4.size();
                StringBuilder sb = new StringBuilder(64);
                sb.append("DataLayer store full, deleting ");
                sb.append(size);
                sb.append(" entries to make room.");
                zzdi.d(sb.toString());
                String[] strArr = (String[]) a4.toArray(new String[0]);
                if (strArr != null && strArr.length != 0 && (a2 = a("Error opening database for deleteEntries.")) != null) {
                    try {
                        a2.delete("datalayer", String.format("%s in (%s)", "ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
                    } catch (SQLiteException unused) {
                        String valueOf = String.valueOf(Arrays.toString(strArr));
                        zzdi.b(valueOf.length() != 0 ? "Error deleting entries ".concat(valueOf) : new String("Error deleting entries "));
                    }
                }
            }
            long j2 = a3 + j;
            SQLiteDatabase a5 = a("Error opening database for writeEntryToDatabase.");
            if (a5 != null) {
                for (h hVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("expires", Long.valueOf(j2));
                    contentValues.put("key", hVar.f14202a);
                    contentValues.put("value", hVar.f14203b);
                    a5.insert("datalayer", null, contentValues);
                }
            }
        } finally {
            e();
        }
    }

    private static byte[] a(Object obj) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (IOException unused) {
            objectOutputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(obj);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                objectOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException unused2) {
            }
            return byteArray;
        } catch (IOException unused3) {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException unused4) {
                    return null;
                }
            }
            byteArrayOutputStream.close();
            return null;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused5) {
                    throw th;
                }
            }
            byteArrayOutputStream.close();
            throw th;
        }
    }

    private final void a(long j) {
        SQLiteDatabase a2 = a("Error opening database for deleteOlderThan.");
        if (a2 == null) {
            return;
        }
        try {
            int delete = a2.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)});
            StringBuilder sb = new StringBuilder(33);
            sb.append("Deleted ");
            sb.append(delete);
            sb.append(" expired items");
            zzdi.a(sb.toString());
        } catch (SQLiteException unused) {
            zzdi.b("Error deleting old entries.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:            if (r2.moveToFirst() != false) goto L48;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:            r1.add(java.lang.String.valueOf(r2.getLong(0)));     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:            if (r2.moveToNext() != false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:            if (r2 == null) goto L62;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:            r2.close();     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<java.lang.String> a(int r14) {
        /*
            r13 = this;
            java.lang.String r0 = "ID"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r14 > 0) goto Lf
            java.lang.String r14 = "Invalid maxEntries specified. Skipping."
            com.google.android.gms.tagmanager.zzdi.b(r14)
            return r1
        Lf:
            java.lang.String r2 = "Error opening database for peekEntryIds."
            android.database.sqlite.SQLiteDatabase r3 = r13.a(r2)
            if (r3 != 0) goto L18
            return r1
        L18:
            r2 = 0
            java.lang.String r4 = "datalayer"
            r5 = 1
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            r12 = 0
            r6[r12] = r0     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            java.lang.String r11 = "%s ASC"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            r5[r12] = r0     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            java.lang.String r0 = java.lang.String.format(r11, r5)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            java.lang.String r11 = java.lang.Integer.toString(r14)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            boolean r14 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            if (r14 == 0) goto L54
        L43:
            long r3 = r2.getLong(r12)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            java.lang.String r14 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            r1.add(r14)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            boolean r14 = r2.moveToNext()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            if (r14 != 0) goto L43
        L54:
            if (r2 == 0) goto L7f
            r2.close()
            goto L7f
        L5a:
            r14 = move-exception
            goto L80
        L5c:
            r14 = move-exception
            java.lang.String r0 = "Error in peekEntries fetching entryIds: "
            java.lang.String r14 = r14.getMessage()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> L5a
            int r3 = r14.length()     // Catch: java.lang.Throwable -> L5a
            if (r3 == 0) goto L72
            java.lang.String r14 = r0.concat(r14)     // Catch: java.lang.Throwable -> L5a
            goto L77
        L72:
            java.lang.String r14 = new java.lang.String     // Catch: java.lang.Throwable -> L5a
            r14.<init>(r0)     // Catch: java.lang.Throwable -> L5a
        L77:
            com.google.android.gms.tagmanager.zzdi.b(r14)     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L7f
            r2.close()
        L7f:
            return r1
        L80:
            if (r2 == 0) goto L85
            r2.close()
        L85:
            goto L87
        L86:
            throw r14
        L87:
            goto L86
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1458d.a(int):java.util.List");
    }

    private final SQLiteDatabase a(String str) {
        try {
            return this.f14193d.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdi.b(str);
            return null;
        }
    }
}
