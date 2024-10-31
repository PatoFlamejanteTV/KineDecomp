package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpk;
import com.google.android.gms.internal.zzrx;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class m extends ac {

    /* renamed from: a */
    private final a f2037a;
    private final k b;

    /* loaded from: classes.dex */
    public class a extends SQLiteOpenHelper {
        a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        private void a(SQLiteDatabase sQLiteDatabase, String str, String str2) throws SQLiteException {
            Set<String> b = b(sQLiteDatabase, str);
            for (String str3 : str2.split(",")) {
                if (!b.remove(str3)) {
                    throw new SQLiteException("Database " + str + " is missing required column: " + str3);
                }
            }
            if (!b.isEmpty()) {
                throw new SQLiteException("Database " + str + " table has extra columns");
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) throws SQLiteException {
            if (!a(sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                a(sQLiteDatabase, str, str3);
            } catch (SQLiteException e) {
                m.this.l().b().a("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean a(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
            /*
                r10 = this;
                r8 = 0
                r9 = 0
                java.lang.String r1 = "SQLITE_MASTER"
                r0 = 1
                java.lang.String[] r2 = new java.lang.String[r0]     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L3e
                r0 = 0
                java.lang.String r3 = "name"
                r2[r0] = r3     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L3e
                java.lang.String r3 = "name=?"
                r0 = 1
                java.lang.String[] r4 = new java.lang.String[r0]     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L3e
                r0 = 0
                r4[r0] = r12     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L3e
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r11
                android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L3e
                boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
                if (r1 == 0) goto L25
                r1.close()
            L25:
                return r0
            L26:
                r0 = move-exception
                r1 = r9
            L28:
                com.google.android.gms.measurement.internal.m r2 = com.google.android.gms.measurement.internal.m.this     // Catch: java.lang.Throwable -> L45
                com.google.android.gms.measurement.internal.zzp r2 = r2.l()     // Catch: java.lang.Throwable -> L45
                com.google.android.gms.measurement.internal.zzp$zza r2 = r2.o()     // Catch: java.lang.Throwable -> L45
                java.lang.String r3 = "Error querying for table"
                r2.a(r3, r12, r0)     // Catch: java.lang.Throwable -> L45
                if (r1 == 0) goto L3c
                r1.close()
            L3c:
                r0 = r8
                goto L25
            L3e:
                r0 = move-exception
            L3f:
                if (r9 == 0) goto L44
                r9.close()
            L44:
                throw r0
            L45:
                r0 = move-exception
                r9 = r1
                goto L3f
            L48:
                r0 = move-exception
                goto L28
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.m.a.a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
        }

        private Set<String> b(SQLiteDatabase sQLiteDatabase, String str) {
            HashSet hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            try {
                for (String str2 : rawQuery.getColumnNames()) {
                    hashSet.add(str2);
                }
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (!m.this.b.a(m.this.n().r())) {
                throw new SQLiteException("Database open failed");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                m.this.b.a();
                m.this.l().b().a("Opening the database failed, dropping and recreating it");
                m.this.i().getDatabasePath(m.this.u()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    m.this.b.b();
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    m.this.l().b().a("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
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
            a(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp");
            a(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value");
            a(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp");
            a(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public m(zzv zzvVar) {
        super(zzvVar);
        this.b = new k(h());
        this.f2037a = new a(i(), u());
    }

    static int a(Cursor cursor, int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        if (window.isNull(position, i)) {
            return 0;
        }
        if (window.isLong(position, i)) {
            return 1;
        }
        if (window.isFloat(position, i)) {
            return 2;
        }
        if (window.isString(position, i)) {
            return 3;
        }
        return window.isBlob(position, i) ? 4 : -1;
    }

    private long a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = q().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    j = cursor.getLong(0);
                } else if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                l().b().a("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public String u() {
        if (n().z() && !n().A()) {
            l().p().a("Using secondary database");
            return n().x();
        }
        return n().w();
    }

    private void z() {
        e();
        x();
        long a2 = m().f.a();
        long elapsedRealtime = h().elapsedRealtime();
        if (Math.abs(elapsedRealtime - a2) > n().C()) {
            m().f.a(elapsedRealtime);
            s();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.measurement.internal.p a(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r10 = 0
            com.google.android.gms.common.internal.zzx.a(r13)
            com.google.android.gms.common.internal.zzx.a(r14)
            r12.e()
            r12.x()
            android.database.sqlite.SQLiteDatabase r0 = r12.q()     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            java.lang.String r1 = "events"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            r3 = 0
            java.lang.String r4 = "lifetime_count"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            r3 = 1
            java.lang.String r4 = "current_bundle_count"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            r3 = 2
            java.lang.String r4 = "last_fire_timestamp"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            java.lang.String r3 = "app_id=? and name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            r5 = 0
            r4[r5] = r13     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            r5 = 1
            r4[r5] = r14     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            boolean r0 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            if (r0 != 0) goto L44
            if (r11 == 0) goto L42
            r11.close()
        L42:
            r1 = r10
        L43:
            return r1
        L44:
            r0 = 0
            long r4 = r11.getLong(r0)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            r0 = 1
            long r6 = r11.getLong(r0)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            r0 = 2
            long r8 = r11.getLong(r0)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            com.google.android.gms.measurement.internal.p r1 = new com.google.android.gms.measurement.internal.p     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            r2 = r13
            r3 = r14
            r1.<init>(r2, r3, r4, r6, r8)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            boolean r0 = r11.moveToNext()     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            if (r0 == 0) goto L6d
            com.google.android.gms.measurement.internal.zzp r0 = r12.l()     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.b()     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            java.lang.String r2 = "Got multiple records for event aggregates, expected one"
            r0.a(r2)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
        L6d:
            if (r11 == 0) goto L43
            r11.close()
            goto L43
        L73:
            r0 = move-exception
            r1 = r10
        L75:
            com.google.android.gms.measurement.internal.zzp r2 = r12.l()     // Catch: java.lang.Throwable -> L93
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.b()     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = "Error querying events"
            r2.a(r3, r13, r14, r0)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L87
            r1.close()
        L87:
            r1 = r10
            goto L43
        L89:
            r0 = move-exception
        L8a:
            if (r10 == 0) goto L8f
            r10.close()
        L8f:
            throw r0
        L90:
            r0 = move-exception
            r10 = r11
            goto L8a
        L93:
            r0 = move-exception
            r10 = r1
            goto L8a
        L96:
            r0 = move-exception
            r1 = r11
            goto L75
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.m.a(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.p");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.google.android.gms.measurement.internal.l> a(java.lang.String r12) {
        /*
            r11 = this;
            r10 = 0
            com.google.android.gms.common.internal.zzx.a(r12)
            r11.e()
            r11.x()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r11.q()     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> Ld0
            java.lang.String r1 = "user_attributes"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> Ld0
            r3 = 0
            java.lang.String r4 = "name"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> Ld0
            r3 = 1
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> Ld0
            r3 = 2
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> Ld0
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> Ld0
            r5 = 0
            r4[r5] = r12     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> Ld0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            com.google.android.gms.measurement.internal.zzc r8 = r11.n()     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> Ld0
            int r8 = r8.q()     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> Ld0
            int r8 = r8 + 1
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> Ld0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> Ld0
            boolean r0 = r7.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            if (r0 != 0) goto L52
            if (r7 == 0) goto L50
            r7.close()
        L50:
            r0 = r9
        L51:
            return r0
        L52:
            r0 = 0
            java.lang.String r3 = r7.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            r0 = 1
            long r4 = r7.getLong(r0)     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            r0 = 2
            java.lang.Object r6 = r11.b(r7, r0)     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            if (r6 != 0) goto La3
            com.google.android.gms.measurement.internal.zzp r0 = r11.l()     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.b()     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            java.lang.String r1 = "Read invalid user attribute value, ignoring it"
            r0.a(r1)     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
        L70:
            boolean r0 = r7.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            if (r0 != 0) goto L52
            int r0 = r9.size()     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.zzc r1 = r11.n()     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            int r1 = r1.q()     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            if (r0 <= r1) goto L9c
            com.google.android.gms.measurement.internal.zzp r0 = r11.l()     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.b()     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            java.lang.String r1 = "Loaded too many user attributes"
            r0.a(r1)     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.zzc r0 = r11.n()     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            int r0 = r0.q()     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            r9.remove(r0)     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
        L9c:
            if (r7 == 0) goto La1
            r7.close()
        La1:
            r0 = r9
            goto L51
        La3:
            com.google.android.gms.measurement.internal.l r1 = new com.google.android.gms.measurement.internal.l     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            r2 = r12
            r1.<init>(r2, r3, r4, r6)     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            r9.add(r1)     // Catch: android.database.sqlite.SQLiteException -> Lad java.lang.Throwable -> Lcb
            goto L70
        Lad:
            r0 = move-exception
            r1 = r7
        Laf:
            com.google.android.gms.measurement.internal.zzp r2 = r11.l()     // Catch: java.lang.Throwable -> Lcd
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.b()     // Catch: java.lang.Throwable -> Lcd
            java.lang.String r3 = "Error querying user attributes"
            r2.a(r3, r12, r0)     // Catch: java.lang.Throwable -> Lcd
            if (r1 == 0) goto Lc1
            r1.close()
        Lc1:
            r0 = r10
            goto L51
        Lc3:
            r0 = move-exception
            r7 = r10
        Lc5:
            if (r7 == 0) goto Lca
            r7.close()
        Lca:
            throw r0
        Lcb:
            r0 = move-exception
            goto Lc5
        Lcd:
            r0 = move-exception
            r7 = r1
            goto Lc5
        Ld0:
            r0 = move-exception
            r1 = r10
            goto Laf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.m.a(java.lang.String):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<android.util.Pair<com.google.android.gms.internal.zzpk.zzd, java.lang.Long>> a(java.lang.String r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.m.a(java.lang.String, int, int):java.util.List");
    }

    @Override // com.google.android.gms.measurement.internal.ac
    protected void a() {
    }

    public void a(long j) {
        e();
        x();
        if (q().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            l().b().a("Deleted fewer rows from queue than expected");
        }
    }

    void a(ContentValues contentValues, String str, Object obj) {
        zzx.a(str);
        zzx.a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (!(obj instanceof Float)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(str, (Float) obj);
        }
    }

    public void a(zzpk.zzd zzdVar) {
        e();
        x();
        zzx.a(zzdVar);
        zzx.a(zzdVar.zzaOX);
        zzx.a(zzdVar.zzaOP);
        z();
        long currentTimeMillis = h().currentTimeMillis();
        if (zzdVar.zzaOP.longValue() < currentTimeMillis - n().B() || zzdVar.zzaOP.longValue() > n().B() + currentTimeMillis) {
            l().o().a("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(currentTimeMillis), zzdVar.zzaOP);
        }
        try {
            byte[] bArr = new byte[zzdVar.zzFR()];
            zzrx zzC = zzrx.zzC(bArr);
            zzdVar.zza(zzC);
            zzC.zzFE();
            byte[] a2 = j().a(bArr);
            l().t().a("Saving bundle, size", Integer.valueOf(a2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzdVar.zzaOX);
            contentValues.put("bundle_end_timestamp", zzdVar.zzaOP);
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, a2);
            try {
                if (q().insert("queue", null, contentValues) == -1) {
                    l().b().a("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                l().b().a("Error storing bundle", e);
            }
        } catch (IOException e2) {
            l().b().a("Data loss. Failed to serialize bundle", e2);
        }
    }

    public void a(b bVar) {
        zzx.a(bVar);
        e();
        x();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", bVar.f2026a);
        contentValues.put("app_instance_id", bVar.b);
        contentValues.put("gmp_app_id", bVar.c);
        contentValues.put("resettable_device_id_hash", bVar.d);
        contentValues.put("last_bundle_index", Long.valueOf(bVar.e));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(bVar.f));
        try {
            if (q().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                l().b().a("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            l().b().a("Error storing app", e);
        }
    }

    public void a(l lVar) {
        zzx.a(lVar);
        e();
        x();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", lVar.f2036a);
        contentValues.put("name", lVar.b);
        contentValues.put("set_timestamp", Long.valueOf(lVar.c));
        a(contentValues, "value", lVar.d);
        try {
            if (q().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                l().b().a("Failed to insert/update user attribute (got -1)");
            }
        } catch (SQLiteException e) {
            l().b().a("Error storing user attribute", e);
        }
    }

    public void a(p pVar) {
        zzx.a(pVar);
        e();
        x();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", pVar.f2041a);
        contentValues.put("name", pVar.b);
        contentValues.put("lifetime_count", Long.valueOf(pVar.c));
        contentValues.put("current_bundle_count", Long.valueOf(pVar.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(pVar.e));
        try {
            if (q().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                l().b().a("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            l().b().a("Error storing event aggregates", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.measurement.internal.b b(java.lang.String r13) {
        /*
            r12 = this;
            r10 = 0
            com.google.android.gms.common.internal.zzx.a(r13)
            r12.e()
            r12.x()
            android.database.sqlite.SQLiteDatabase r0 = r12.q()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L96
            java.lang.String r1 = "apps"
            r2 = 5
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L96
            r3 = 0
            java.lang.String r4 = "app_instance_id"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L96
            r3 = 1
            java.lang.String r4 = "gmp_app_id"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L96
            r3 = 2
            java.lang.String r4 = "resettable_device_id_hash"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L96
            r3 = 3
            java.lang.String r4 = "last_bundle_index"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L96
            r3 = 4
            java.lang.String r4 = "last_bundle_end_timestamp"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L96
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L96
            r5 = 0
            r4[r5] = r13     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L96
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L96
            boolean r0 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La3
            if (r0 != 0) goto L48
            if (r11 == 0) goto L46
            r11.close()
        L46:
            r1 = r10
        L47:
            return r1
        L48:
            r0 = 0
            java.lang.String r3 = r11.getString(r0)     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La3
            r0 = 1
            java.lang.String r4 = r11.getString(r0)     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La3
            r0 = 2
            java.lang.String r5 = r11.getString(r0)     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La3
            r0 = 3
            long r6 = r11.getLong(r0)     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La3
            r0 = 4
            long r8 = r11.getLong(r0)     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La3
            com.google.android.gms.measurement.internal.b r1 = new com.google.android.gms.measurement.internal.b     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La3
            r2 = r13
            r1.<init>(r2, r3, r4, r5, r6, r8)     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La3
            boolean r0 = r11.moveToNext()     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La3
            if (r0 == 0) goto L7a
            com.google.android.gms.measurement.internal.zzp r0 = r12.l()     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La3
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.b()     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La3
            java.lang.String r2 = "Got multiple records for app, expected one"
            r0.a(r2)     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La3
        L7a:
            if (r11 == 0) goto L47
            r11.close()
            goto L47
        L80:
            r0 = move-exception
            r1 = r10
        L82:
            com.google.android.gms.measurement.internal.zzp r2 = r12.l()     // Catch: java.lang.Throwable -> La0
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.b()     // Catch: java.lang.Throwable -> La0
            java.lang.String r3 = "Error querying app"
            r2.a(r3, r13, r0)     // Catch: java.lang.Throwable -> La0
            if (r1 == 0) goto L94
            r1.close()
        L94:
            r1 = r10
            goto L47
        L96:
            r0 = move-exception
        L97:
            if (r10 == 0) goto L9c
            r10.close()
        L9c:
            throw r0
        L9d:
            r0 = move-exception
            r10 = r11
            goto L97
        La0:
            r0 = move-exception
            r10 = r1
            goto L97
        La3:
            r0 = move-exception
            r1 = r11
            goto L82
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.m.b(java.lang.String):com.google.android.gms.measurement.internal.b");
    }

    Object b(Cursor cursor, int i) {
        int a2 = a(cursor, i);
        switch (a2) {
            case 0:
                l().b().a("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Float.valueOf(cursor.getFloat(i));
            case 3:
                return cursor.getString(i);
            case 4:
                l().b().a("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                l().b().a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(a2));
                return null;
        }
    }

    public void b() {
        x();
        q().beginTransaction();
    }

    public void b(String str, String str2) {
        zzx.a(str);
        zzx.a(str2);
        e();
        x();
        try {
            l().t().a("Deleted user attribute rows:", Integer.valueOf(q().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            l().b().a("Error deleting user attribute", str, str2, e);
        }
    }

    public void o() {
        x();
        q().setTransactionSuccessful();
    }

    public void p() {
        x();
        q().endTransaction();
    }

    SQLiteDatabase q() {
        e();
        try {
            return this.f2037a.getWritableDatabase();
        } catch (SQLiteException e) {
            l().o().a("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String r() {
        /*
            r10 = this;
            r9 = 0
            android.database.sqlite.SQLiteDatabase r0 = r10.q()
            java.lang.String r1 = "queue"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: android.database.sqlite.SQLiteException -> L33 java.lang.Throwable -> L49
            r3 = 0
            java.lang.String r4 = "app_id"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L33 java.lang.Throwable -> L49
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            java.lang.String r8 = "1"
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: android.database.sqlite.SQLiteException -> L33 java.lang.Throwable -> L49
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteException -> L53
            if (r0 == 0) goto L2c
            r0 = 0
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteException -> L53
            if (r1 == 0) goto L2b
            r1.close()
        L2b:
            return r0
        L2c:
            if (r1 == 0) goto L31
            r1.close()
        L31:
            r0 = r9
            goto L2b
        L33:
            r0 = move-exception
            r1 = r9
        L35:
            com.google.android.gms.measurement.internal.zzp r2 = r10.l()     // Catch: java.lang.Throwable -> L50
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.b()     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = "Database error getting next bundle app id"
            r2.a(r3, r0)     // Catch: java.lang.Throwable -> L50
            if (r1 == 0) goto L47
            r1.close()
        L47:
            r0 = r9
            goto L2b
        L49:
            r0 = move-exception
        L4a:
            if (r9 == 0) goto L4f
            r9.close()
        L4f:
            throw r0
        L50:
            r0 = move-exception
            r9 = r1
            goto L4a
        L53:
            r0 = move-exception
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.m.r():java.lang.String");
    }

    void s() {
        e();
        x();
        int delete = q().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(h().currentTimeMillis()), String.valueOf(n().B())});
        if (delete > 0) {
            l().t().a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
        }
    }

    public long t() {
        return a("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }
}
