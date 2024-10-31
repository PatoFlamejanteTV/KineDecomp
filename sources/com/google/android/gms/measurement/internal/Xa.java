package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzxz;
import com.google.android.gms.internal.measurement.zzya;
import com.google.protos.datapol.SemanticAnnotations;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Xa extends La {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f13713d = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f13714e = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f13715f = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;"};

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f13716g = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f13717h = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] i = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final Za j;
    private final Ia k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xa(zzfo zzfoVar) {
        super(zzfoVar);
        this.k = new Ia(a());
        this.j = new Za(this, getContext(), "google_app_measurement.db");
    }

    private final boolean J() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }

    private final long a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = t().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e2) {
                b().q().a("Database error", str, e2);
                throw e2;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final long b(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = t().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e2) {
                b().q().a("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean A() {
        return b("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean B() {
        return b("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long C() {
        Cursor cursor = null;
        try {
            try {
                cursor = t().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1L;
                }
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e2) {
                b().q().a("Error querying raw events", e2);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void c(String str, String str2) {
        Preconditions.b(str);
        Preconditions.b(str2);
        c();
        o();
        try {
            b().y().a("Deleted user attribute rows", Integer.valueOf(t().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e2) {
            b().q().a("Error deleting user attribute. appId", zzas.a(str), g().c(str2), e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.Qa d(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.b(r19)
            com.google.android.gms.common.internal.Preconditions.b(r20)
            r18.c()
            r18.o()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.t()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r11 = "user_attributes"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = "set_timestamp"
            r1 = 0
            r12[r1] = r0     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = "value"
            r2 = 1
            r12[r2] = r0     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = "origin"
            r3 = 2
            r12[r3] = r0     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r13 = "app_id=? and name=?"
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            r14[r1] = r19     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            r14[r2] = r8     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7f
            if (r0 != 0) goto L44
            if (r10 == 0) goto L43
            r10.close()
        L43:
            return r9
        L44:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7f
            r11 = r18
            java.lang.Object r7 = r11.a(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            java.lang.String r3 = r10.getString(r3)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.Qa r0 = new com.google.android.gms.measurement.internal.Qa     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            if (r1 == 0) goto L73
            com.google.android.gms.measurement.internal.zzas r1 = r18.b()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzau r1 = r1.q()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzas.a(r19)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            r1.a(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
        L73:
            if (r10 == 0) goto L78
            r10.close()
        L78:
            return r0
        L79:
            r0 = move-exception
            goto L8c
        L7b:
            r0 = move-exception
            r11 = r18
            goto Lac
        L7f:
            r0 = move-exception
            r11 = r18
            goto L8c
        L83:
            r0 = move-exception
            r11 = r18
            r10 = r9
            goto Lac
        L88:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L8c:
            com.google.android.gms.measurement.internal.zzas r1 = r18.b()     // Catch: java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzau r1 = r1.q()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzas.a(r19)     // Catch: java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzaq r4 = r18.g()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r4 = r4.c(r8)     // Catch: java.lang.Throwable -> Lab
            r1.a(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> Lab
            if (r10 == 0) goto Laa
            r10.close()
        Laa:
            return r9
        Lab:
            r0 = move-exception
        Lac:
            if (r10 == 0) goto Lb1
            r10.close()
        Lb1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Xa.d(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.Qa");
    }

    public final zzo e(String str, String str2) {
        Cursor cursor;
        Preconditions.b(str);
        Preconditions.b(str2);
        c();
        o();
        try {
            try {
                cursor = t().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            } catch (SQLiteException e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                try {
                    Object a2 = a(cursor, 1);
                    boolean z = cursor.getInt(2) != 0;
                    zzo zzoVar = new zzo(str, string, new zzfv(str2, cursor.getLong(8), a2, string), cursor.getLong(6), z, cursor.getString(3), (zzag) k().a(cursor.getBlob(5), zzag.CREATOR), cursor.getLong(4), (zzag) k().a(cursor.getBlob(7), zzag.CREATOR), cursor.getLong(9), (zzag) k().a(cursor.getBlob(10), zzag.CREATOR));
                    if (cursor.moveToNext()) {
                        b().q().a("Got multiple records for conditional property, expected one", zzas.a(str), g().c(str2));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzoVar;
                } catch (SQLiteException e3) {
                    e = e3;
                    b().q().a("Error querying conditional property", zzas.a(str), g().c(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e4) {
                e = e4;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final int f(String str, String str2) {
        Preconditions.b(str);
        Preconditions.b(str2);
        c();
        o();
        try {
            return t().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            b().q().a("Error deleting conditional property", zzas.a(str), g().c(str2), e2);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzfj>> g(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.o()
            r12.c()
            com.google.android.gms.common.internal.Preconditions.b(r13)
            com.google.android.gms.common.internal.Preconditions.b(r14)
            android.support.v4.util.ArrayMap r0 = new android.support.v4.util.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.t()
            r9 = 0
            java.lang.String r2 = "event_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            java.lang.String r5 = "app_id=? AND event_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            r6[r10] = r13     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            r6[r11] = r14     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            if (r1 != 0) goto L48
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            if (r14 == 0) goto L47
            r14.close()
        L47:
            return r13
        L48:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            int r2 = r1.length     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            com.google.android.gms.internal.measurement.zzxz r1 = com.google.android.gms.internal.measurement.zzxz.zzj(r1, r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            com.google.android.gms.internal.measurement.zzfj r2 = new com.google.android.gms.internal.measurement.zzfj     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            r2.zza(r1)     // Catch: java.io.IOException -> L79 android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            int r1 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            if (r3 != 0) goto L75
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            r0.put(r1, r3)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
        L75:
            r3.add(r2)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            goto L8b
        L79:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzas r2 = r12.b()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            com.google.android.gms.measurement.internal.zzau r2 = r2.q()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzas.a(r13)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            r2.a(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
        L8b:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            if (r1 != 0) goto L48
            if (r14 == 0) goto L96
            r14.close()
        L96:
            return r0
        L97:
            r0 = move-exception
            goto L9e
        L99:
            r13 = move-exception
            r14 = r9
            goto Lb6
        L9c:
            r0 = move-exception
            r14 = r9
        L9e:
            com.google.android.gms.measurement.internal.zzas r1 = r12.b()     // Catch: java.lang.Throwable -> Lb5
            com.google.android.gms.measurement.internal.zzau r1 = r1.q()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzas.a(r13)     // Catch: java.lang.Throwable -> Lb5
            r1.a(r2, r13, r0)     // Catch: java.lang.Throwable -> Lb5
            if (r14 == 0) goto Lb4
            r14.close()
        Lb4:
            return r9
        Lb5:
            r13 = move-exception
        Lb6:
            if (r14 == 0) goto Lbb
            r14.close()
        Lbb:
            goto Lbd
        Lbc:
            throw r13
        Lbd:
            goto Lbc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Xa.g(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzfm>> h(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.o()
            r12.c()
            com.google.android.gms.common.internal.Preconditions.b(r13)
            com.google.android.gms.common.internal.Preconditions.b(r14)
            android.support.v4.util.ArrayMap r0 = new android.support.v4.util.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.t()
            r9 = 0
            java.lang.String r2 = "property_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            java.lang.String r5 = "app_id=? AND property_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            r6[r10] = r13     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            r6[r11] = r14     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> L9c
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            if (r1 != 0) goto L48
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            if (r14 == 0) goto L47
            r14.close()
        L47:
            return r13
        L48:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            int r2 = r1.length     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            com.google.android.gms.internal.measurement.zzxz r1 = com.google.android.gms.internal.measurement.zzxz.zzj(r1, r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            com.google.android.gms.internal.measurement.zzfm r2 = new com.google.android.gms.internal.measurement.zzfm     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            r2.zza(r1)     // Catch: java.io.IOException -> L79 android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            int r1 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            if (r3 != 0) goto L75
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            r0.put(r1, r3)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
        L75:
            r3.add(r2)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            goto L8b
        L79:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzas r2 = r12.b()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            com.google.android.gms.measurement.internal.zzau r2 = r2.q()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzas.a(r13)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            r2.a(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
        L8b:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L97 java.lang.Throwable -> Lb5
            if (r1 != 0) goto L48
            if (r14 == 0) goto L96
            r14.close()
        L96:
            return r0
        L97:
            r0 = move-exception
            goto L9e
        L99:
            r13 = move-exception
            r14 = r9
            goto Lb6
        L9c:
            r0 = move-exception
            r14 = r9
        L9e:
            com.google.android.gms.measurement.internal.zzas r1 = r12.b()     // Catch: java.lang.Throwable -> Lb5
            com.google.android.gms.measurement.internal.zzau r1 = r1.q()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzas.a(r13)     // Catch: java.lang.Throwable -> Lb5
            r1.a(r2, r13, r0)     // Catch: java.lang.Throwable -> Lb5
            if (r14 == 0) goto Lb4
            r14.close()
        Lb4:
            return r9
        Lb5:
            r13 = move-exception
        Lb6:
            if (r14 == 0) goto Lbb
            r14.close()
        Lbb:
            goto Lbd
        Lbc:
            throw r13
        Lbd:
            goto Lbc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Xa.h(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final long i(String str, String str2) {
        long j;
        StringBuilder sb;
        ContentValues contentValues;
        Preconditions.b(str);
        Preconditions.b(str2);
        c();
        o();
        SQLiteDatabase t = t();
        t.beginTransaction();
        try {
            sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
        } catch (SQLiteException e2) {
            e = e2;
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                j = a(sb.toString(), new String[]{str}, -1L);
                if (j == -1) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put("first_open_count", (Integer) 0);
                    contentValues2.put("previous_install_count", (Integer) 0);
                    if (t.insertWithOnConflict("app2", null, contentValues2, 5) == -1) {
                        b().q().a("Failed to insert column (got -1). appId", zzas.a(str), str2);
                        t.endTransaction();
                        return -1L;
                    }
                    j = 0;
                }
                try {
                    contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put(str2, Long.valueOf(1 + j));
                } catch (SQLiteException e3) {
                    e = e3;
                    b().q().a("Error inserting column. appId", zzas.a(str), str2, e);
                    t.endTransaction();
                    return j;
                }
            } catch (Throwable th2) {
                th = th2;
                t.endTransaction();
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            j = 0;
            b().q().a("Error inserting column. appId", zzas.a(str), str2, e);
            t.endTransaction();
            return j;
        }
        if (t.update("app2", contentValues, "app_id = ?", new String[]{str}) == 0) {
            b().q().a("Failed to update column (got 0). appId", zzas.a(str), str2);
            t.endTransaction();
            return -1L;
        }
        t.setTransactionSuccessful();
        t.endTransaction();
        return j;
    }

    @Override // com.google.android.gms.measurement.internal.La
    protected final boolean p() {
        return false;
    }

    public final void r() {
        o();
        t().beginTransaction();
    }

    public final void s() {
        o();
        t().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final SQLiteDatabase t() {
        c();
        try {
            return this.j.getWritableDatabase();
        } catch (SQLiteException e2) {
            b().t().a("Error opening database", e2);
            throw e2;
        }
    }

    public final void u() {
        o();
        t().setTransactionSuccessful();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String v() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.t()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L24 android.database.sqlite.SQLiteException -> L29
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r2 == 0) goto L1c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r0 == 0) goto L1b
            r0.close()
        L1b:
            return r1
        L1c:
            if (r0 == 0) goto L21
            r0.close()
        L21:
            return r1
        L22:
            r2 = move-exception
            goto L2b
        L24:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3f
        L29:
            r2 = move-exception
            r0 = r1
        L2b:
            com.google.android.gms.measurement.internal.zzas r3 = r6.b()     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.zzau r3 = r3.q()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.a(r4, r2)     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L3d
            r0.close()
        L3d:
            return r1
        L3e:
            r1 = move-exception
        L3f:
            if (r0 == 0) goto L44
            r0.close()
        L44:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Xa.v():java.lang.String");
    }

    public final boolean w() {
        return b("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void x() {
        int delete;
        c();
        o();
        if (J()) {
            long a2 = i().i.a();
            long c2 = a().c();
            if (Math.abs(c2 - a2) > zzai.M.a().longValue()) {
                i().i.a(c2);
                c();
                o();
                if (!J() || (delete = t().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(a().a()), String.valueOf(zzq.p())})) <= 0) {
                    return;
                }
                b().y().a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public final long y() {
        return a("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    public final long z() {
        return a("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final void a(C1404a c1404a) {
        Preconditions.a(c1404a);
        c();
        o();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c1404a.f13730a);
        contentValues.put("name", c1404a.f13731b);
        contentValues.put("lifetime_count", Long.valueOf(c1404a.f13732c));
        contentValues.put("current_bundle_count", Long.valueOf(c1404a.f13733d));
        contentValues.put("last_fire_timestamp", Long.valueOf(c1404a.f13734e));
        contentValues.put("last_bundled_timestamp", Long.valueOf(c1404a.f13735f));
        contentValues.put("last_bundled_day", c1404a.f13736g);
        contentValues.put("last_sampled_complex_event_id", c1404a.f13737h);
        contentValues.put("last_sampling_rate", c1404a.i);
        Boolean bool = c1404a.j;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (t().insertWithOnConflict(com.umeng.analytics.pro.b.ao, null, contentValues, 5) == -1) {
                b().q().a("Failed to insert/update event aggregates (got -1). appId", zzas.a(c1404a.f13730a));
            }
        } catch (SQLiteException e2) {
            b().q().a("Error storing event aggregates. appId", zzas.a(c1404a.f13730a), e2);
        }
    }

    public final C1404a b(String str, String str2) {
        Cursor cursor;
        Cursor cursor2;
        Cursor query;
        Boolean bool;
        Preconditions.b(str);
        Preconditions.b(str2);
        c();
        o();
        try {
            try {
                query = t().query(com.umeng.analytics.pro.b.ao, new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            } catch (SQLiteException e2) {
                e = e2;
                cursor2 = null;
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (!query.moveToFirst()) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                long j = query.getLong(0);
                long j2 = query.getLong(1);
                long j3 = query.getLong(2);
                long j4 = query.isNull(3) ? 0L : query.getLong(3);
                Long valueOf = query.isNull(4) ? null : Long.valueOf(query.getLong(4));
                Long valueOf2 = query.isNull(5) ? null : Long.valueOf(query.getLong(5));
                Long valueOf3 = query.isNull(6) ? null : Long.valueOf(query.getLong(6));
                if (query.isNull(7)) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(query.getLong(7) == 1);
                }
                cursor2 = query;
                try {
                    C1404a c1404a = new C1404a(str, str2, j, j2, j3, j4, valueOf, valueOf2, valueOf3, bool);
                    if (cursor2.moveToNext()) {
                        b().q().a("Got multiple records for event aggregates, expected one. appId", zzas.a(str));
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return c1404a;
                } catch (SQLiteException e3) {
                    e = e3;
                    b().q().a("Error querying events. appId", zzas.a(str), g().a(str2), e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return null;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor2 = query;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final long f(String str) {
        Preconditions.b(str);
        return a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final long c(String str) {
        Preconditions.b(str);
        c();
        o();
        try {
            return t().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, j().b(str, zzai.D))))});
        } catch (SQLiteException e2) {
            b().q().a("Error deleting over the limit events. appId", zzas.a(str), e2);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] d(java.lang.String r12) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.b(r12)
            r11.c()
            r11.o()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.t()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            java.lang.String r2 = "apps"
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            java.lang.String r5 = "remote_config"
            r9 = 0
            r4[r9] = r5     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            r6[r9] = r12     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            r7 = 0
            r8 = 0
            r10 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            if (r2 != 0) goto L37
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            if (r3 == 0) goto L52
            com.google.android.gms.measurement.internal.zzas r3 = r11.b()     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            com.google.android.gms.measurement.internal.zzau r3 = r3.q()     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzas.a(r12)     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            r3.a(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
        L52:
            if (r1 == 0) goto L57
            r1.close()
        L57:
            return r2
        L58:
            r2 = move-exception
            goto L5f
        L5a:
            r12 = move-exception
            r1 = r0
            goto L77
        L5d:
            r2 = move-exception
            r1 = r0
        L5f:
            com.google.android.gms.measurement.internal.zzas r3 = r11.b()     // Catch: java.lang.Throwable -> L76
            com.google.android.gms.measurement.internal.zzau r3 = r3.q()     // Catch: java.lang.Throwable -> L76
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzas.a(r12)     // Catch: java.lang.Throwable -> L76
            r3.a(r4, r12, r2)     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L75
            r1.close()
        L75:
            return r0
        L76:
            r12 = move-exception
        L77:
            if (r1 == 0) goto L7c
            r1.close()
        L7c:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Xa.d(java.lang.String):byte[]");
    }

    public final boolean a(Qa qa) {
        Preconditions.a(qa);
        c();
        o();
        if (d(qa.f13677a, qa.f13679c) == null) {
            if (zzfy.a(qa.f13679c)) {
                if (b("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{qa.f13677a}) >= 25) {
                    return false;
                }
            } else if (b("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{qa.f13677a, qa.f13678b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", qa.f13677a);
        contentValues.put("origin", qa.f13678b);
        contentValues.put("name", qa.f13679c);
        contentValues.put("set_timestamp", Long.valueOf(qa.f13680d));
        a(contentValues, "value", qa.f13681e);
        try {
            if (t().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                b().q().a("Failed to insert/update user property (got -1). appId", zzas.a(qa.f13677a));
            }
        } catch (SQLiteException e2) {
            b().q().a("Error storing user property. appId", zzas.a(qa.f13677a), e2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzfx> e(java.lang.String r12) {
        /*
            r11 = this;
            r11.o()
            r11.c()
            com.google.android.gms.common.internal.Preconditions.b(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.t()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7f
            java.lang.String r3 = "audience_id"
            r9 = 0
            r2[r9] = r3     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7f
            java.lang.String r3 = "current_results"
            r10 = 1
            r2[r10] = r3     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7f
            java.lang.String r3 = "app_id=?"
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7f
            r4[r9] = r12     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7f
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7f
            boolean r1 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            if (r1 != 0) goto L36
            if (r0 == 0) goto L35
            r0.close()
        L35:
            return r8
        L36:
            android.support.v4.util.ArrayMap r1 = new android.support.v4.util.ArrayMap     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            r1.<init>()     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
        L3b:
            int r2 = r0.getInt(r9)     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            byte[] r3 = r0.getBlob(r10)     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            int r4 = r3.length     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            com.google.android.gms.internal.measurement.zzxz r3 = com.google.android.gms.internal.measurement.zzxz.zzj(r3, r9, r4)     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            com.google.android.gms.internal.measurement.zzfx r4 = new com.google.android.gms.internal.measurement.zzfx     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            r4.zza(r3)     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            r1.put(r2, r4)     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            goto L6e
        L58:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzas r4 = r11.b()     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            com.google.android.gms.measurement.internal.zzau r4 = r4.q()     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzas.a(r12)     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            r4.a(r5, r6, r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
        L6e:
            boolean r2 = r0.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L7a java.lang.Throwable -> L98
            if (r2 != 0) goto L3b
            if (r0 == 0) goto L79
            r0.close()
        L79:
            return r1
        L7a:
            r1 = move-exception
            goto L81
        L7c:
            r12 = move-exception
            r0 = r8
            goto L99
        L7f:
            r1 = move-exception
            r0 = r8
        L81:
            com.google.android.gms.measurement.internal.zzas r2 = r11.b()     // Catch: java.lang.Throwable -> L98
            com.google.android.gms.measurement.internal.zzau r2 = r2.q()     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzas.a(r12)     // Catch: java.lang.Throwable -> L98
            r2.a(r3, r12, r1)     // Catch: java.lang.Throwable -> L98
            if (r0 == 0) goto L97
            r0.close()
        L97:
            return r8
        L98:
            r12 = move-exception
        L99:
            if (r0 == 0) goto L9e
            r0.close()
        L9e:
            goto La0
        L9f:
            throw r12
        La0:
            goto L9f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Xa.e(java.lang.String):java.util.Map");
    }

    public final List<zzo> b(String str, String str2, String str3) {
        Preconditions.b(str);
        c();
        o();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return a(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01df A[Catch: SQLiteException -> 0x0212, all -> 0x023c, TryCatch #2 {SQLiteException -> 0x0212, blocks: (B:14:0x00d8, B:16:0x0135, B:20:0x013f, B:23:0x0189, B:26:0x01bf, B:28:0x01ca, B:32:0x01d4, B:34:0x01df, B:36:0x01e6, B:38:0x01fb, B:45:0x01bb, B:46:0x0184), top: B:13:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01fb A[Catch: SQLiteException -> 0x0212, all -> 0x023c, TRY_LEAVE, TryCatch #2 {SQLiteException -> 0x0212, blocks: (B:14:0x00d8, B:16:0x0135, B:20:0x013f, B:23:0x0189, B:26:0x01bf, B:28:0x01ca, B:32:0x01d4, B:34:0x01df, B:36:0x01e6, B:38:0x01fb, B:45:0x01bb, B:46:0x0184), top: B:13:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01bb A[Catch: SQLiteException -> 0x0212, all -> 0x023c, TryCatch #2 {SQLiteException -> 0x0212, blocks: (B:14:0x00d8, B:16:0x0135, B:20:0x013f, B:23:0x0189, B:26:0x01bf, B:28:0x01ca, B:32:0x01d4, B:34:0x01df, B:36:0x01e6, B:38:0x01fb, B:45:0x01bb, B:46:0x0184), top: B:13:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0184 A[Catch: SQLiteException -> 0x0212, all -> 0x023c, TryCatch #2 {SQLiteException -> 0x0212, blocks: (B:14:0x00d8, B:16:0x0135, B:20:0x013f, B:23:0x0189, B:26:0x01bf, B:28:0x01ca, B:32:0x01d4, B:34:0x01df, B:36:0x01e6, B:38:0x01fb, B:45:0x01bb, B:46:0x0184), top: B:13:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x023f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.Sa b(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 579
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Xa.b(java.lang.String):com.google.android.gms.measurement.internal.Sa");
    }

    public final List<Qa> a(String str) {
        Cursor cursor;
        Preconditions.b(str);
        c();
        o();
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursor = t().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                try {
                    if (!cursor.moveToFirst()) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    }
                    do {
                        String string = cursor.getString(0);
                        String string2 = cursor.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j = cursor.getLong(2);
                        try {
                            Object a2 = a(cursor, 3);
                            if (a2 == null) {
                                b().q().a("Read invalid user property value, ignoring it. appId", zzas.a(str));
                            } else {
                                arrayList.add(new Qa(str, str2, string, j, a2));
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                            b().q().a("Error querying user properties. appId", zzas.a(str), e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    } while (cursor.moveToNext());
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (SQLiteException e3) {
                    e = e3;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x009a, code lost:            b().q().a("Read more than the max allowed user properties, ignoring excess", 1000);     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.Qa> a(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Xa.a(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean a(zzo zzoVar) {
        Preconditions.a(zzoVar);
        c();
        o();
        if (d(zzoVar.f14073a, zzoVar.f14075c.f14052b) == null && b("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzoVar.f14073a}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzoVar.f14073a);
        contentValues.put("origin", zzoVar.f14074b);
        contentValues.put("name", zzoVar.f14075c.f14052b);
        a(contentValues, "value", zzoVar.f14075c.getValue());
        contentValues.put("active", Boolean.valueOf(zzoVar.f14077e));
        contentValues.put("trigger_event_name", zzoVar.f14078f);
        contentValues.put("trigger_timeout", Long.valueOf(zzoVar.f14080h));
        h();
        contentValues.put("timed_out_event", zzfy.a((Parcelable) zzoVar.f14079g));
        contentValues.put("creation_timestamp", Long.valueOf(zzoVar.f14076d));
        h();
        contentValues.put("triggered_event", zzfy.a((Parcelable) zzoVar.i));
        contentValues.put("triggered_timestamp", Long.valueOf(zzoVar.f14075c.f14053c));
        contentValues.put("time_to_live", Long.valueOf(zzoVar.j));
        h();
        contentValues.put("expired_event", zzfy.a((Parcelable) zzoVar.k));
        try {
            if (t().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                b().q().a("Failed to insert/update conditional user property (got -1)", zzas.a(zzoVar.f14073a));
            }
        } catch (SQLiteException e2) {
            b().q().a("Error storing conditional user property", zzas.a(zzoVar.f14073a), e2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008e, code lost:            b().q().a("Read more than the max allowed conditional properties, ignoring extra", 1000);     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzo> a(java.lang.String r40, java.lang.String[] r41) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Xa.a(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final void a(Sa sa) {
        Preconditions.a(sa);
        c();
        o();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", sa.f());
        contentValues.put("app_instance_id", sa.a());
        contentValues.put("gmp_app_id", sa.c());
        contentValues.put("resettable_device_id_hash", sa.i());
        contentValues.put("last_bundle_index", Long.valueOf(sa.p()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(sa.j()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(sa.k()));
        contentValues.put("app_version", sa.e());
        contentValues.put("app_store", sa.m());
        contentValues.put("gmp_version", Long.valueOf(sa.n()));
        contentValues.put("dev_cert_hash", Long.valueOf(sa.o()));
        contentValues.put("measurement_enabled", Boolean.valueOf(sa.d()));
        contentValues.put("day", Long.valueOf(sa.t()));
        contentValues.put("daily_public_events_count", Long.valueOf(sa.u()));
        contentValues.put("daily_events_count", Long.valueOf(sa.v()));
        contentValues.put("daily_conversions_count", Long.valueOf(sa.w()));
        contentValues.put("config_fetched_time", Long.valueOf(sa.q()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(sa.r()));
        contentValues.put("app_version_int", Long.valueOf(sa.l()));
        contentValues.put("firebase_instance_id", sa.b());
        contentValues.put("daily_error_events_count", Long.valueOf(sa.y()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(sa.x()));
        contentValues.put("health_monitor_sample", sa.z());
        contentValues.put("android_id", Long.valueOf(sa.B()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(sa.C()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(sa.D()));
        contentValues.put("admob_app_id", sa.h());
        try {
            SQLiteDatabase t = t();
            if (t.update("apps", contentValues, "app_id = ?", new String[]{sa.f()}) == 0 && t.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                b().q().a("Failed to insert/update app (got -1). appId", zzas.a(sa.f()));
            }
        } catch (SQLiteException e2) {
            b().q().a("Error storing app. appId", zzas.a(sa.f()), e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzu a(long r22, java.lang.String r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Xa.a(long, java.lang.String, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzu");
    }

    public final boolean a(com.google.android.gms.internal.measurement.zzfw zzfwVar, boolean z) {
        c();
        o();
        Preconditions.a(zzfwVar);
        Preconditions.b(zzfwVar.zztt);
        Preconditions.a(zzfwVar.zzaxm);
        x();
        long a2 = a().a();
        if (zzfwVar.zzaxm.longValue() < a2 - zzq.p() || zzfwVar.zzaxm.longValue() > zzq.p() + a2) {
            b().t().a("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzas.a(zzfwVar.zztt), Long.valueOf(a2), zzfwVar.zzaxm);
        }
        try {
            byte[] bArr = new byte[zzfwVar.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfwVar.zza(zzk);
            zzk.zzza();
            byte[] b2 = k().b(bArr);
            b().y().a("Saving bundle, size", Integer.valueOf(b2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzfwVar.zztt);
            contentValues.put("bundle_end_timestamp", zzfwVar.zzaxm);
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, b2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            Integer num = zzfwVar.zzayj;
            if (num != null) {
                contentValues.put("retry_count", num);
            }
            try {
                if (t().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                b().q().a("Failed to insert bundle (got -1). appId", zzas.a(zzfwVar.zztt));
                return false;
            } catch (SQLiteException e2) {
                b().q().a("Error storing bundle. appId", zzas.a(zzfwVar.zztt), e2);
                return false;
            }
        } catch (IOException e3) {
            b().q().a("Data loss. Failed to serialize bundle. appId", zzas.a(zzfwVar.zztt), e3);
            return false;
        }
    }

    public final List<Pair<com.google.android.gms.internal.measurement.zzfw, Long>> a(String str, int i2, int i3) {
        byte[] a2;
        c();
        o();
        Preconditions.a(i2 > 0);
        Preconditions.a(i3 > 0);
        Preconditions.b(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = t().query("queue", new String[]{"rowid", ShareConstants.WEB_DIALOG_PARAM_DATA, "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i2));
                if (!query.moveToFirst()) {
                    List<Pair<com.google.android.gms.internal.measurement.zzfw, Long>> emptyList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                do {
                    long j = query.getLong(0);
                    try {
                        a2 = k().a(query.getBlob(1));
                    } catch (IOException e2) {
                        b().q().a("Failed to unzip queued bundle. appId", zzas.a(str), e2);
                    }
                    if (!arrayList.isEmpty() && a2.length + i4 > i3) {
                        break;
                    }
                    zzxz zzj = zzxz.zzj(a2, 0, a2.length);
                    com.google.android.gms.internal.measurement.zzfw zzfwVar = new com.google.android.gms.internal.measurement.zzfw();
                    try {
                        zzfwVar.zza(zzj);
                        if (!query.isNull(2)) {
                            zzfwVar.zzayj = Integer.valueOf(query.getInt(2));
                        }
                        i4 += a2.length;
                        arrayList.add(Pair.create(zzfwVar, Long.valueOf(j)));
                    } catch (IOException e3) {
                        b().q().a("Failed to merge queued bundle. appId", zzas.a(str), e3);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } while (i4 <= i3);
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e4) {
                b().q().a("Error querying bundles. appId", zzas.a(str), e4);
                List<Pair<com.google.android.gms.internal.measurement.zzfw, Long>> emptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(List<Long> list) {
        c();
        o();
        Preconditions.a(list);
        Preconditions.a(list.size());
        if (J()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (b(sb3.toString(), (String[]) null) > 0) {
                b().t().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase t = t();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                t.execSQL(sb4.toString());
            } catch (SQLiteException e2) {
                b().q().a("Error incrementing retry count. error", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, zzfi[] zzfiVarArr) {
        boolean z;
        o();
        c();
        Preconditions.b(str);
        Preconditions.a(zzfiVarArr);
        SQLiteDatabase t = t();
        t.beginTransaction();
        try {
            o();
            c();
            Preconditions.b(str);
            SQLiteDatabase t2 = t();
            t2.delete("property_filters", "app_id=?", new String[]{str});
            t2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzfi zzfiVar : zzfiVarArr) {
                o();
                c();
                Preconditions.b(str);
                Preconditions.a(zzfiVar);
                Preconditions.a(zzfiVar.zzavg);
                Preconditions.a(zzfiVar.zzavf);
                if (zzfiVar.zzave == null) {
                    b().t().a("Audience with no ID. appId", zzas.a(str));
                } else {
                    int intValue = zzfiVar.zzave.intValue();
                    zzfj[] zzfjVarArr = zzfiVar.zzavg;
                    int length = zzfjVarArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if (zzfjVarArr[i2].zzavk == null) {
                                b().t().a("Event filter with no ID. Audience definition ignored. appId, audienceId", zzas.a(str), zzfiVar.zzave);
                                break;
                            }
                            i2++;
                        } else {
                            zzfm[] zzfmVarArr = zzfiVar.zzavf;
                            int length2 = zzfmVarArr.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 < length2) {
                                    if (zzfmVarArr[i3].zzavk == null) {
                                        b().t().a("Property filter with no ID. Audience definition ignored. appId, audienceId", zzas.a(str), zzfiVar.zzave);
                                        break;
                                    }
                                    i3++;
                                } else {
                                    zzfj[] zzfjVarArr2 = zzfiVar.zzavg;
                                    int length3 = zzfjVarArr2.length;
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 >= length3) {
                                            z = true;
                                            break;
                                        } else {
                                            if (!a(str, intValue, zzfjVarArr2[i4])) {
                                                z = false;
                                                break;
                                            }
                                            i4++;
                                        }
                                    }
                                    if (z) {
                                        zzfm[] zzfmVarArr2 = zzfiVar.zzavf;
                                        int length4 = zzfmVarArr2.length;
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 >= length4) {
                                                break;
                                            }
                                            if (!a(str, intValue, zzfmVarArr2[i5])) {
                                                z = false;
                                                break;
                                            }
                                            i5++;
                                        }
                                    }
                                    if (!z) {
                                        o();
                                        c();
                                        Preconditions.b(str);
                                        SQLiteDatabase t3 = t();
                                        t3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                                        t3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzfi zzfiVar2 : zzfiVarArr) {
                arrayList.add(zzfiVar2.zzave);
            }
            a(str, arrayList);
            t.setTransactionSuccessful();
        } finally {
            t.endTransaction();
        }
    }

    private final boolean a(String str, int i2, zzfj zzfjVar) {
        o();
        c();
        Preconditions.b(str);
        Preconditions.a(zzfjVar);
        if (TextUtils.isEmpty(zzfjVar.zzavl)) {
            b().t().a("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzas.a(str), Integer.valueOf(i2), String.valueOf(zzfjVar.zzavk));
            return false;
        }
        try {
            byte[] bArr = new byte[zzfjVar.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfjVar.zza(zzk);
            zzk.zzza();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i2));
            contentValues.put("filter_id", zzfjVar.zzavk);
            contentValues.put("event_name", zzfjVar.zzavl);
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
            try {
                if (t().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                b().q().a("Failed to insert event filter (got -1). appId", zzas.a(str));
                return true;
            } catch (SQLiteException e2) {
                b().q().a("Error storing event filter. appId", zzas.a(str), e2);
                return false;
            }
        } catch (IOException e3) {
            b().q().a("Configuration loss. Failed to serialize event filter. appId", zzas.a(str), e3);
            return false;
        }
    }

    private final boolean a(String str, int i2, zzfm zzfmVar) {
        o();
        c();
        Preconditions.b(str);
        Preconditions.a(zzfmVar);
        if (TextUtils.isEmpty(zzfmVar.zzawa)) {
            b().t().a("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzas.a(str), Integer.valueOf(i2), String.valueOf(zzfmVar.zzavk));
            return false;
        }
        try {
            byte[] bArr = new byte[zzfmVar.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfmVar.zza(zzk);
            zzk.zzza();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i2));
            contentValues.put("filter_id", zzfmVar.zzavk);
            contentValues.put("property_name", zzfmVar.zzawa);
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
            try {
                if (t().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                b().q().a("Failed to insert property filter (got -1). appId", zzas.a(str));
                return false;
            } catch (SQLiteException e2) {
                b().q().a("Error storing property filter. appId", zzas.a(str), e2);
                return false;
            }
        } catch (IOException e3) {
            b().q().a("Configuration loss. Failed to serialize property filter. appId", zzas.a(str), e3);
            return false;
        }
    }

    private final boolean a(String str, List<Integer> list) {
        Preconditions.b(str);
        o();
        c();
        SQLiteDatabase t = t();
        try {
            long b2 = b("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE, j().b(str, zzai.T)));
            if (b2 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return t.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e2) {
            b().q().a("Database error querying filters. appId", zzas.a(str), e2);
            return false;
        }
    }

    private static void a(ContentValues contentValues, String str, Object obj) {
        Preconditions.b(str);
        Preconditions.a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @VisibleForTesting
    private final Object a(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            b().q().a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i2));
        }
        if (type == 3) {
            return cursor.getString(i2);
        }
        if (type != 4) {
            b().q().a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        b().q().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    public final long a(com.google.android.gms.internal.measurement.zzfw zzfwVar) throws IOException {
        long a2;
        c();
        o();
        Preconditions.a(zzfwVar);
        Preconditions.b(zzfwVar.zztt);
        try {
            byte[] bArr = new byte[zzfwVar.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfwVar.zza(zzk);
            zzk.zzza();
            zzfu k = k();
            Preconditions.a(bArr);
            k.h().c();
            MessageDigest q = zzfy.q();
            if (q == null) {
                k.b().q().a("Failed to get MD5");
                a2 = 0;
            } else {
                a2 = zzfy.a(q.digest(bArr));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzfwVar.zztt);
            contentValues.put("metadata_fingerprint", Long.valueOf(a2));
            contentValues.put("metadata", bArr);
            try {
                t().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return a2;
            } catch (SQLiteException e2) {
                b().q().a("Error storing raw event metadata. appId", zzas.a(zzfwVar.zztt), e2);
                throw e2;
            }
        } catch (IOException e3) {
            b().q().a("Data loss. Failed to serialize event metadata. appId", zzas.a(zzfwVar.zztt), e3);
            throw e3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(long r5) {
        /*
            r4 = this;
            r4.c()
            r4.o()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.t()     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            if (r1 != 0) goto L34
            com.google.android.gms.measurement.internal.zzas r6 = r4.b()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            com.google.android.gms.measurement.internal.zzau r6 = r6.y()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.a(r1)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            if (r5 == 0) goto L33
            r5.close()
        L33:
            return r0
        L34:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            if (r5 == 0) goto L3d
            r5.close()
        L3d:
            return r6
        L3e:
            r6 = move-exception
            goto L45
        L40:
            r6 = move-exception
            r5 = r0
            goto L59
        L43:
            r6 = move-exception
            r5 = r0
        L45:
            com.google.android.gms.measurement.internal.zzas r1 = r4.b()     // Catch: java.lang.Throwable -> L58
            com.google.android.gms.measurement.internal.zzau r1 = r1.q()     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = "Error selecting expired configs"
            r1.a(r2, r6)     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L57
            r5.close()
        L57:
            return r0
        L58:
            r6 = move-exception
        L59:
            if (r5 == 0) goto L5e
            r5.close()
        L5e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Xa.a(long):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzft, java.lang.Long> a(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.c()
            r7.o()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.t()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            if (r2 != 0) goto L37
            com.google.android.gms.measurement.internal.zzas r8 = r7.b()     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            com.google.android.gms.measurement.internal.zzau r8 = r8.y()     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            java.lang.String r9 = "Main event not found"
            r8.a(r9)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            long r5 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            int r5 = r2.length     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            com.google.android.gms.internal.measurement.zzxz r2 = com.google.android.gms.internal.measurement.zzxz.zzj(r2, r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            com.google.android.gms.internal.measurement.zzft r4 = new com.google.android.gms.internal.measurement.zzft     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            r4.zza(r2)     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            android.util.Pair r8 = android.util.Pair.create(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            if (r1 == 0) goto L59
            r1.close()
        L59:
            return r8
        L5a:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzas r3 = r7.b()     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            com.google.android.gms.measurement.internal.zzau r3 = r3.q()     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzas.a(r8)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            r3.a(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8c
            if (r1 == 0) goto L71
            r1.close()
        L71:
            return r0
        L72:
            r8 = move-exception
            goto L79
        L74:
            r8 = move-exception
            r1 = r0
            goto L8d
        L77:
            r8 = move-exception
            r1 = r0
        L79:
            com.google.android.gms.measurement.internal.zzas r9 = r7.b()     // Catch: java.lang.Throwable -> L8c
            com.google.android.gms.measurement.internal.zzau r9 = r9.q()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r2 = "Error selecting main event"
            r9.a(r2, r8)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L8b
            r1.close()
        L8b:
            return r0
        L8c:
            r8 = move-exception
        L8d:
            if (r1 == 0) goto L92
            r1.close()
        L92:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Xa.a(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean a(String str, Long l, long j, com.google.android.gms.internal.measurement.zzft zzftVar) {
        c();
        o();
        Preconditions.a(zzftVar);
        Preconditions.b(str);
        Preconditions.a(l);
        try {
            byte[] bArr = new byte[zzftVar.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzftVar.zza(zzk);
            zzk.zzza();
            b().y().a("Saving complex main event, appId, data size", g().a(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j));
            contentValues.put("main_event", bArr);
            try {
                if (t().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                    return true;
                }
                b().q().a("Failed to insert complex main event (got -1). appId", zzas.a(str));
                return false;
            } catch (SQLiteException e2) {
                b().q().a("Error storing complex main event. appId", zzas.a(str), e2);
                return false;
            }
        } catch (IOException e3) {
            b().q().a("Data loss. Failed to serialize event params/data. appId, eventId", zzas.a(str), l, e3);
            return false;
        }
    }

    public final boolean a(zzab zzabVar, long j, boolean z) {
        c();
        o();
        Preconditions.a(zzabVar);
        Preconditions.b(zzabVar.f13890a);
        com.google.android.gms.internal.measurement.zzft zzftVar = new com.google.android.gms.internal.measurement.zzft();
        zzftVar.zzaxc = Long.valueOf(zzabVar.f13894e);
        zzftVar.zzaxa = new com.google.android.gms.internal.measurement.zzfu[zzabVar.f13895f.size()];
        Iterator<String> it = zzabVar.f13895f.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String next = it.next();
            com.google.android.gms.internal.measurement.zzfu zzfuVar = new com.google.android.gms.internal.measurement.zzfu();
            int i3 = i2 + 1;
            zzftVar.zzaxa[i2] = zzfuVar;
            zzfuVar.name = next;
            k().a(zzfuVar, zzabVar.f13895f.e(next));
            i2 = i3;
        }
        try {
            byte[] bArr = new byte[zzftVar.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzftVar.zza(zzk);
            zzk.zzza();
            b().y().a("Saving event, name, data size", g().a(zzabVar.f13891b), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzabVar.f13890a);
            contentValues.put("name", zzabVar.f13891b);
            contentValues.put("timestamp", Long.valueOf(zzabVar.f13893d));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (t().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                b().q().a("Failed to insert raw event (got -1). appId", zzas.a(zzabVar.f13890a));
                return false;
            } catch (SQLiteException e2) {
                b().q().a("Error storing raw event. appId", zzas.a(zzabVar.f13890a), e2);
                return false;
            }
        } catch (IOException e3) {
            b().q().a("Data loss. Failed to serialize event params/data. appId", zzas.a(zzabVar.f13890a), e3);
            return false;
        }
    }
}
