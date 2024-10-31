package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.google.android.gms.internal.zzgr;
import java.util.Locale;

@zzgr
/* loaded from: classes.dex */
public class zzh {

    /* renamed from: a, reason: collision with root package name */
    private static final String f617a = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time");
    private static final Object c = new Object();
    private static zzh d;
    private final zza b;

    /* loaded from: classes.dex */
    public class zza extends SQLiteOpenHelper {
        public zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(zzh.f617a);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            com.google.android.gms.ads.internal.util.client.zzb.c("Database updated from version " + i + " to version " + i2);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(sQLiteDatabase);
        }
    }

    zzh(Context context) {
        this.b = new zza(context, "google_inapp_purchase.db");
    }

    public static zzh a(Context context) {
        zzh zzhVar;
        synchronized (c) {
            if (d == null) {
                d = new zzh(context);
            }
            zzhVar = d;
        }
        return zzhVar;
    }

    public SQLiteDatabase a() {
        try {
            return this.b.getWritableDatabase();
        } catch (SQLiteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Error opening writable conversion tracking database");
            return null;
        }
    }

    public zzf a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new zzf(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:            if (r1.moveToFirst() != false) goto L16;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:            r9.add(a(r1));     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:            if (r1.moveToNext() != false) goto L46;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:            if (r1 == null) goto L20;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:            r1.close();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.google.android.gms.ads.internal.purchase.zzf> a(long r14) {
        /*
            r13 = this;
            r10 = 0
            java.lang.Object r11 = com.google.android.gms.ads.internal.purchase.zzh.c
            monitor-enter(r11)
            java.util.LinkedList r9 = new java.util.LinkedList     // Catch: java.lang.Throwable -> L69
            r9.<init>()     // Catch: java.lang.Throwable -> L69
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 > 0) goto L12
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L69
            r0 = r9
        L11:
            return r0
        L12:
            android.database.sqlite.SQLiteDatabase r0 = r13.a()     // Catch: java.lang.Throwable -> L69
            if (r0 != 0) goto L1b
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L69
            r0 = r9
            goto L11
        L1b:
            java.lang.String r7 = "record_time ASC"
            java.lang.String r1 = "InAppPurchase"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r8 = java.lang.String.valueOf(r14)     // Catch: android.database.sqlite.SQLiteException -> L47 java.lang.Throwable -> L6c
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: android.database.sqlite.SQLiteException -> L47 java.lang.Throwable -> L6c
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            if (r0 == 0) goto L3f
        L32:
            com.google.android.gms.ads.internal.purchase.zzf r0 = r13.a(r1)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            r9.add(r0)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            if (r0 != 0) goto L32
        L3f:
            if (r1 == 0) goto L44
            r1.close()     // Catch: java.lang.Throwable -> L69
        L44:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L69
            r0 = r9
            goto L11
        L47:
            r0 = move-exception
            r1 = r10
        L49:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r2.<init>()     // Catch: java.lang.Throwable -> L74
            java.lang.String r3 = "Error extracing purchase info: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L74
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L74
            com.google.android.gms.ads.internal.util.client.zzb.e(r0)     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L44
            r1.close()     // Catch: java.lang.Throwable -> L69
            goto L44
        L69:
            r0 = move-exception
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L69
            throw r0
        L6c:
            r0 = move-exception
            r1 = r10
        L6e:
            if (r1 == 0) goto L73
            r1.close()     // Catch: java.lang.Throwable -> L69
        L73:
            throw r0     // Catch: java.lang.Throwable -> L69
        L74:
            r0 = move-exception
            goto L6e
        L76:
            r0 = move-exception
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzh.a(long):java.util.List");
    }

    public void a(zzf zzfVar) {
        if (zzfVar == null) {
            return;
        }
        synchronized (c) {
            SQLiteDatabase a2 = a();
            if (a2 != null) {
                a2.delete("InAppPurchase", String.format(Locale.US, "%s = %d", "purchase_id", Long.valueOf(zzfVar.f615a)), null);
            }
        }
    }

    public int b() {
        Cursor cursor = null;
        int i = 0;
        synchronized (c) {
            SQLiteDatabase a2 = a();
            try {
                if (a2 != null) {
                    try {
                        cursor = a2.rawQuery("select count(*) from InAppPurchase", null);
                    } catch (SQLiteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.e("Error getting record count" + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                    if (cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                    } else if (cursor != null) {
                        cursor.close();
                    }
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    public void b(zzf zzfVar) {
        if (zzfVar == null) {
            return;
        }
        synchronized (c) {
            SQLiteDatabase a2 = a();
            if (a2 == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("product_id", zzfVar.c);
            contentValues.put("developer_payload", zzfVar.b);
            contentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
            zzfVar.f615a = a2.insert("InAppPurchase", null, contentValues);
            if (b() > 20000) {
                c();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005a A[Catch: all -> 0x0031, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:13:0x002c, B:14:0x002f, B:29:0x005a, B:30:0x005d, B:25:0x0052), top: B:3:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            r11 = this;
            r9 = 0
            java.lang.Object r10 = com.google.android.gms.ads.internal.purchase.zzh.c
            monitor-enter(r10)
            android.database.sqlite.SQLiteDatabase r0 = r11.a()     // Catch: java.lang.Throwable -> L31
            if (r0 != 0) goto Lc
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L31
        Lb:
            return
        Lc:
            java.lang.String r7 = "record_time ASC"
            java.lang.String r1 = "InAppPurchase"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r8 = "1"
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: android.database.sqlite.SQLiteException -> L34 java.lang.Throwable -> L56
            if (r1 == 0) goto L2a
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            if (r0 == 0) goto L2a
            com.google.android.gms.ads.internal.purchase.zzf r0 = r11.a(r1)     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            r11.a(r0)     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
        L2a:
            if (r1 == 0) goto L2f
            r1.close()     // Catch: java.lang.Throwable -> L31
        L2f:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L31
            goto Lb
        L31:
            r0 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L31
            throw r0
        L34:
            r0 = move-exception
            r1 = r9
        L36:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e
            r2.<init>()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r3 = "Error remove oldest record"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L5e
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L5e
            com.google.android.gms.ads.internal.util.client.zzb.e(r0)     // Catch: java.lang.Throwable -> L5e
            if (r1 == 0) goto L2f
            r1.close()     // Catch: java.lang.Throwable -> L31
            goto L2f
        L56:
            r0 = move-exception
            r1 = r9
        L58:
            if (r1 == 0) goto L5d
            r1.close()     // Catch: java.lang.Throwable -> L31
        L5d:
            throw r0     // Catch: java.lang.Throwable -> L31
        L5e:
            r0 = move-exception
            goto L58
        L60:
            r0 = move-exception
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzh.c():void");
    }
}
