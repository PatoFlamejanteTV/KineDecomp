package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import java.io.File;

/* loaded from: classes.dex */
class MPDbAdapter {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3004a = "CREATE TABLE " + Table.EVENTS.getName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + ShareConstants.WEB_DIALOG_PARAM_DATA + " STRING NOT NULL, created_at INTEGER NOT NULL);";
    private static final String b = "CREATE TABLE " + Table.PEOPLE.getName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + ShareConstants.WEB_DIALOG_PARAM_DATA + " STRING NOT NULL, created_at INTEGER NOT NULL);";
    private static final String c = "CREATE INDEX IF NOT EXISTS time_idx ON " + Table.EVENTS.getName() + " (created_at);";
    private static final String d = "CREATE INDEX IF NOT EXISTS time_idx ON " + Table.PEOPLE.getName() + " (created_at);";
    private final a e;

    /* loaded from: classes.dex */
    public enum Table {
        EVENTS("events"),
        PEOPLE("people");

        private final String mTableName;

        Table(String str) {
            this.mTableName = str;
        }

        public String getName() {
            return this.mTableName;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {

        /* renamed from: a, reason: collision with root package name */
        private final File f3005a;
        private final m b;

        a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
            this.f3005a = context.getDatabasePath(str);
            this.b = m.a(context);
        }

        public void a() {
            close();
            this.f3005a.delete();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (m.f3036a) {
                Log.v("MixpanelAPI.Database", "Creating a new Mixpanel events DB");
            }
            sQLiteDatabase.execSQL(MPDbAdapter.f3004a);
            sQLiteDatabase.execSQL(MPDbAdapter.b);
            sQLiteDatabase.execSQL(MPDbAdapter.c);
            sQLiteDatabase.execSQL(MPDbAdapter.d);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (m.f3036a) {
                Log.v("MixpanelAPI.Database", "Upgrading app, replacing Mixpanel events DB");
            }
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.EVENTS.getName());
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.PEOPLE.getName());
            sQLiteDatabase.execSQL(MPDbAdapter.f3004a);
            sQLiteDatabase.execSQL(MPDbAdapter.b);
            sQLiteDatabase.execSQL(MPDbAdapter.c);
            sQLiteDatabase.execSQL(MPDbAdapter.d);
        }

        public boolean b() {
            return !this.f3005a.exists() || Math.max(this.f3005a.getUsableSpace(), (long) this.b.d()) >= this.f3005a.length();
        }
    }

    public MPDbAdapter(Context context) {
        this(context, "mixpanel");
    }

    public MPDbAdapter(Context context, String str) {
        this.e = new a(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(org.json.JSONObject r9, com.mixpanel.android.mpmetrics.MPDbAdapter.Table r10) {
        /*
            r8 = this;
            r3 = 0
            boolean r0 = r8.b()
            if (r0 != 0) goto L10
            java.lang.String r0 = "MixpanelAPI.Database"
            java.lang.String r1 = "There is not enough space left on the device to store Mixpanel data, so data was discarded"
            android.util.Log.e(r0, r1)
            r0 = -2
        Lf:
            return r0
        L10:
            java.lang.String r4 = r10.getName()
            r0 = -1
            com.mixpanel.android.mpmetrics.MPDbAdapter$a r1 = r8.e     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            java.lang.String r5 = "data"
            java.lang.String r6 = r9.toString()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            r2.put(r5, r6)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            java.lang.String r5 = "created_at"
            long r6 = java.lang.System.currentTimeMillis()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            r2.put(r5, r6)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            r5 = 0
            r1.insert(r4, r5, r2)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            java.lang.String r5 = "SELECT COUNT(*) FROM "
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            java.lang.String r2 = r2.toString()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            r5 = 0
            android.database.Cursor r2 = r1.rawQuery(r2, r5)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9b
            r2.moveToFirst()     // Catch: java.lang.Throwable -> La7 android.database.sqlite.SQLiteException -> Laa
            r1 = 0
            int r0 = r2.getInt(r1)     // Catch: java.lang.Throwable -> La7 android.database.sqlite.SQLiteException -> Laa
            if (r2 == 0) goto L5f
            r2.close()
        L5f:
            com.mixpanel.android.mpmetrics.MPDbAdapter$a r1 = r8.e
            r1.close()
            goto Lf
        L65:
            r1 = move-exception
            r2 = r3
        L67:
            java.lang.String r5 = "MixpanelAPI.Database"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La7
            r6.<init>()     // Catch: java.lang.Throwable -> La7
            java.lang.String r7 = "Could not add Mixpanel data to table "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> La7
            java.lang.StringBuilder r4 = r6.append(r4)     // Catch: java.lang.Throwable -> La7
            java.lang.String r6 = ". Re-initializing database."
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> La7
            android.util.Log.e(r5, r4, r1)     // Catch: java.lang.Throwable -> La7
            if (r2 == 0) goto Lac
            r2.close()     // Catch: java.lang.Throwable -> La7
        L8a:
            com.mixpanel.android.mpmetrics.MPDbAdapter$a r1 = r8.e     // Catch: java.lang.Throwable -> L9b
            r1.a()     // Catch: java.lang.Throwable -> L9b
            if (r3 == 0) goto L94
            r3.close()
        L94:
            com.mixpanel.android.mpmetrics.MPDbAdapter$a r1 = r8.e
            r1.close()
            goto Lf
        L9b:
            r0 = move-exception
        L9c:
            if (r3 == 0) goto La1
            r3.close()
        La1:
            com.mixpanel.android.mpmetrics.MPDbAdapter$a r1 = r8.e
            r1.close()
            throw r0
        La7:
            r0 = move-exception
            r3 = r2
            goto L9c
        Laa:
            r1 = move-exception
            goto L67
        Lac:
            r3 = r2
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.a(org.json.JSONObject, com.mixpanel.android.mpmetrics.MPDbAdapter$Table):int");
    }

    public void a(String str, Table table) {
        String name = table.getName();
        try {
            this.e.getWritableDatabase().delete(name, "_id <= " + str, null);
        } catch (SQLiteException e) {
            Log.e("MixpanelAPI.Database", "Could not clean sent Mixpanel records from " + name + ". Re-initializing database.", e);
            this.e.a();
        } finally {
            this.e.close();
        }
    }

    public void a(long j, Table table) {
        String name = table.getName();
        try {
            this.e.getWritableDatabase().delete(name, "created_at <= " + j, null);
        } catch (SQLiteException e) {
            Log.e("MixpanelAPI.Database", "Could not clean timed-out Mixpanel records from " + name + ". Re-initializing database.", e);
            this.e.a();
        } finally {
            this.e.close();
        }
    }

    public void a() {
        this.e.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String[] a(com.mixpanel.android.mpmetrics.MPDbAdapter.Table r8) {
        /*
            r7 = this;
            r1 = 0
            java.lang.String r4 = r8.getName()
            com.mixpanel.android.mpmetrics.MPDbAdapter$a r0 = r7.e     // Catch: android.database.sqlite.SQLiteException -> L8a java.lang.Throwable -> Lb7
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L8a java.lang.Throwable -> Lb7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: android.database.sqlite.SQLiteException -> L8a java.lang.Throwable -> Lb7
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> L8a java.lang.Throwable -> Lb7
            java.lang.String r3 = "SELECT * FROM "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: android.database.sqlite.SQLiteException -> L8a java.lang.Throwable -> Lb7
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: android.database.sqlite.SQLiteException -> L8a java.lang.Throwable -> Lb7
            java.lang.String r3 = " ORDER BY "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: android.database.sqlite.SQLiteException -> L8a java.lang.Throwable -> Lb7
            java.lang.String r3 = "created_at"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: android.database.sqlite.SQLiteException -> L8a java.lang.Throwable -> Lb7
            java.lang.String r3 = " ASC LIMIT 50"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: android.database.sqlite.SQLiteException -> L8a java.lang.Throwable -> Lb7
            java.lang.String r2 = r2.toString()     // Catch: android.database.sqlite.SQLiteException -> L8a java.lang.Throwable -> Lb7
            r3 = 0
            android.database.Cursor r2 = r0.rawQuery(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L8a java.lang.Throwable -> Lb7
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
            r0.<init>()     // Catch: java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
            r3 = r1
        L3b:
            boolean r5 = r2.moveToNext()     // Catch: java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
            if (r5 == 0) goto L66
            boolean r5 = r2.isLast()     // Catch: java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
            if (r5 == 0) goto L51
            java.lang.String r3 = "_id"
            int r3 = r2.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
            java.lang.String r3 = r2.getString(r3)     // Catch: java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
        L51:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L64 java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
            java.lang.String r6 = "data"
            int r6 = r2.getColumnIndex(r6)     // Catch: org.json.JSONException -> L64 java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
            java.lang.String r6 = r2.getString(r6)     // Catch: org.json.JSONException -> L64 java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
            r5.<init>(r6)     // Catch: org.json.JSONException -> L64 java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
            r0.put(r5)     // Catch: org.json.JSONException -> L64 java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
            goto L3b
        L64:
            r5 = move-exception
            goto L3b
        L66:
            int r5 = r0.length()     // Catch: java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
            if (r5 <= 0) goto Lce
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lc4 android.database.sqlite.SQLiteException -> Lc6
        L70:
            com.mixpanel.android.mpmetrics.MPDbAdapter$a r4 = r7.e
            r4.close()
            if (r2 == 0) goto Lcb
            r2.close()
            r2 = r0
            r0 = r3
        L7c:
            if (r0 == 0) goto L89
            if (r2 == 0) goto L89
            r1 = 2
            java.lang.String[] r1 = new java.lang.String[r1]
            r3 = 0
            r1[r3] = r0
            r0 = 1
            r1[r0] = r2
        L89:
            return r1
        L8a:
            r0 = move-exception
            r2 = r1
        L8c:
            java.lang.String r3 = "MixpanelAPI.Database"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc4
            r5.<init>()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "Could not pull records for Mixpanel out of database "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> Lc4
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r5 = ". Waiting to send."
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lc4
            android.util.Log.e(r3, r4, r0)     // Catch: java.lang.Throwable -> Lc4
            com.mixpanel.android.mpmetrics.MPDbAdapter$a r0 = r7.e
            r0.close()
            if (r2 == 0) goto Lc8
            r2.close()
            r0 = r1
            r2 = r1
            goto L7c
        Lb7:
            r0 = move-exception
            r2 = r1
        Lb9:
            com.mixpanel.android.mpmetrics.MPDbAdapter$a r1 = r7.e
            r1.close()
            if (r2 == 0) goto Lc3
            r2.close()
        Lc3:
            throw r0
        Lc4:
            r0 = move-exception
            goto Lb9
        Lc6:
            r0 = move-exception
            goto L8c
        Lc8:
            r0 = r1
            r2 = r1
            goto L7c
        Lcb:
            r2 = r0
            r0 = r3
            goto L7c
        Lce:
            r0 = r1
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.a(com.mixpanel.android.mpmetrics.MPDbAdapter$Table):java.lang.String[]");
    }

    protected boolean b() {
        return this.e.b();
    }
}
