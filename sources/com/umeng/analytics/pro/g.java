package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.c;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UMStoreManager.java */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a */
    public static final int f25876a = 2049;

    /* renamed from: b */
    public static final int f25877b = 2050;

    /* renamed from: c */
    private static final int f25878c = 1000;

    /* renamed from: d */
    private static Context f25879d = null;

    /* renamed from: e */
    private static String f25880e = null;

    /* renamed from: f */
    private static final String f25881f = "umeng+";

    /* renamed from: g */
    private static final String f25882g = "ek__id";

    /* renamed from: h */
    private static final String f25883h = "ek_key";
    private List<String> i;
    private List<Integer> j;
    private String k;
    private List<String> l;

    /* compiled from: UMStoreManager.java */
    /* loaded from: classes3.dex */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMStoreManager.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a */
        private static final g f25891a = new g();

        private b() {
        }
    }

    /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static g a(Context context) {
        g gVar = b.f25891a;
        if (f25879d == null && context != null) {
            f25879d = context.getApplicationContext();
            gVar.k();
        }
        return gVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.i.clear();
            this.l.clear();
            this.j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(f25880e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(f25879d, f25882g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = DeviceConfig.getDBencryptID(f25879d);
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(f25879d, f25882g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String substring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < substring.length(); i++) {
                        char charAt = substring.charAt(i);
                        if (Character.isDigit(charAt)) {
                            if (Integer.parseInt(Character.toString(charAt)) == 0) {
                                sb.append(0);
                            } else {
                                sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                            }
                        } else {
                            sb.append(charAt);
                        }
                    }
                    f25880e = sb.toString();
                }
                if (TextUtils.isEmpty(f25880e)) {
                    return;
                }
                f25880e += new StringBuilder(f25880e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(f25879d, f25883h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(f25879d, f25883h, c(f25881f));
                } else {
                    if (f25881f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.l.clear();
    }

    public boolean c() {
        return this.l.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:            if (r0 != null) goto L82;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:            r0.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:            if (r0 == null) goto L64;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0073, code lost:            if (r0 != null) goto L82;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            r6 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            com.umeng.analytics.pro.q r1 = com.umeng.analytics.pro.q.a()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            if (r2 == 0) goto L2b
            if (r0 == 0) goto L21
            r0.endTransaction()     // Catch: java.lang.Throwable -> L21
        L21:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            return
        L2b:
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r3 = ""
            r4 = 0
            r2[r4] = r3     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r3 = "-1"
            r5 = 1
            r2[r5] = r3     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
        L38:
            int r3 = r2.length     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            if (r4 >= r3) goto L6b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            r3.<init>()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r5 = "update __et set __i=\""
            r3.append(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            r3.append(r1)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r5 = "\" where "
            r3.append(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r5 = "__i"
            r3.append(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r5 = "=\""
            r3.append(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            r3.append(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r5 = "\""
            r3.append(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            r0.execSQL(r3)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            int r4 = r4 + 1
            goto L38
        L6b:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            if (r0 == 0) goto L78
            goto L75
        L71:
            r1 = move-exception
            goto L8b
        L73:
            if (r0 == 0) goto L78
        L75:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L78
        L78:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L8a
        L82:
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L71
            com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L78
            goto L75
        L8a:
            return
        L8b:
            if (r0 == 0) goto L90
            r0.endTransaction()     // Catch: java.lang.Throwable -> L90
        L90:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L9b
        L9a:
            throw r1
        L9b:
            goto L9a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.d():void");
    }

    public boolean e() {
        return this.i.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ac, code lost:            if (r2 != null) goto L133;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0093, code lost:            r2.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0091, code lost:            if (r2 != null) goto L133;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r5v14, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject f() {
        /*
            r7 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r7.l
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L87 java.lang.Throwable -> L8a android.database.sqlite.SQLiteDatabaseCorruptException -> La0
            com.umeng.analytics.pro.e r2 = com.umeng.analytics.pro.e.a(r2)     // Catch: java.lang.Throwable -> L87 java.lang.Throwable -> L8a android.database.sqlite.SQLiteDatabaseCorruptException -> La0
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L87 java.lang.Throwable -> L8a android.database.sqlite.SQLiteDatabaseCorruptException -> La0
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            r4.<init>()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            java.lang.String r5 = "select *  from __is where __ii=\""
            r4.append(r5)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            java.util.List<java.lang.String> r5 = r7.l     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            r6 = 0
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            r4.append(r5)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            java.lang.String r5 = "\""
            r4.append(r5)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            android.database.Cursor r4 = r2.rawQuery(r4, r3)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            if (r4 == 0) goto L62
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7d android.database.sqlite.SQLiteDatabaseCorruptException -> L80
            if (r5 == 0) goto L62
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7d android.database.sqlite.SQLiteDatabaseCorruptException -> L80
            r5.<init>()     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7d android.database.sqlite.SQLiteDatabaseCorruptException -> L80
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L81
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L81
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L81
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L81
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L81
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L81
            r3 = r5
        L62:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7d android.database.sqlite.SQLiteDatabaseCorruptException -> L80
            if (r4 == 0) goto L6a
            r4.close()
        L6a:
            if (r2 == 0) goto L6f
            r2.endTransaction()     // Catch: java.lang.Throwable -> L6f
        L6f:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            r5 = r3
            goto Laf
        L7a:
            r0 = move-exception
            r3 = r4
            goto Lb1
        L7d:
            r5 = r3
        L7e:
            r3 = r4
            goto L8c
        L80:
            r5 = r3
        L81:
            r3 = r4
            goto La2
        L83:
            r5 = r3
            goto L8c
        L85:
            r5 = r3
            goto La2
        L87:
            r0 = move-exception
            r2 = r3
            goto Lb1
        L8a:
            r2 = r3
            r5 = r2
        L8c:
            if (r3 == 0) goto L91
            r3.close()
        L91:
            if (r2 == 0) goto L96
        L93:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L96
        L96:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto Laf
        La0:
            r2 = r3
            r5 = r2
        La2:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> Lb0
            com.umeng.analytics.pro.f.a(r0)     // Catch: java.lang.Throwable -> Lb0
            if (r3 == 0) goto Lac
            r3.close()
        Lac:
            if (r2 == 0) goto L96
            goto L93
        Laf:
            return r5
        Lb0:
            r0 = move-exception
        Lb1:
            if (r3 == 0) goto Lb6
            r3.close()
        Lb6:
            if (r2 == 0) goto Lbb
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lbb
        Lbb:
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)
            r1.b()
            goto Lc6
        Lc5:
            throw r0
        Lc6:
            goto Lc5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.f():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ac, code lost:            if (r2 != null) goto L133;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0093, code lost:            r2.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0091, code lost:            if (r2 != null) goto L133;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r5v14, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject g() {
        /*
            r7 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r7.i
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L87 java.lang.Throwable -> L8a android.database.sqlite.SQLiteDatabaseCorruptException -> La0
            com.umeng.analytics.pro.e r2 = com.umeng.analytics.pro.e.a(r2)     // Catch: java.lang.Throwable -> L87 java.lang.Throwable -> L8a android.database.sqlite.SQLiteDatabaseCorruptException -> La0
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L87 java.lang.Throwable -> L8a android.database.sqlite.SQLiteDatabaseCorruptException -> La0
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            r4.<init>()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            java.lang.String r5 = "select *  from __sd where __ii=\""
            r4.append(r5)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            java.util.List<java.lang.String> r5 = r7.i     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            r6 = 0
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            r4.append(r5)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            java.lang.String r5 = "\""
            r4.append(r5)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            android.database.Cursor r4 = r2.rawQuery(r4, r3)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85 java.lang.Throwable -> Lb0
            if (r4 == 0) goto L62
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7d android.database.sqlite.SQLiteDatabaseCorruptException -> L80
            if (r5 == 0) goto L62
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7d android.database.sqlite.SQLiteDatabaseCorruptException -> L80
            r5.<init>()     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7d android.database.sqlite.SQLiteDatabaseCorruptException -> L80
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L81
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L81
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L81
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L81
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L81
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L81
            r3 = r5
        L62:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L7a java.lang.Throwable -> L7d android.database.sqlite.SQLiteDatabaseCorruptException -> L80
            if (r4 == 0) goto L6a
            r4.close()
        L6a:
            if (r2 == 0) goto L6f
            r2.endTransaction()     // Catch: java.lang.Throwable -> L6f
        L6f:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            r5 = r3
            goto Laf
        L7a:
            r0 = move-exception
            r3 = r4
            goto Lb1
        L7d:
            r5 = r3
        L7e:
            r3 = r4
            goto L8c
        L80:
            r5 = r3
        L81:
            r3 = r4
            goto La2
        L83:
            r5 = r3
            goto L8c
        L85:
            r5 = r3
            goto La2
        L87:
            r0 = move-exception
            r2 = r3
            goto Lb1
        L8a:
            r2 = r3
            r5 = r2
        L8c:
            if (r3 == 0) goto L91
            r3.close()
        L91:
            if (r2 == 0) goto L96
        L93:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L96
        L96:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto Laf
        La0:
            r2 = r3
            r5 = r2
        La2:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> Lb0
            com.umeng.analytics.pro.f.a(r0)     // Catch: java.lang.Throwable -> Lb0
            if (r3 == 0) goto Lac
            r3.close()
        Lac:
            if (r2 == 0) goto L96
            goto L93
        Laf:
            return r5
        Lb0:
            r0 = move-exception
        Lb1:
            if (r3 == 0) goto Lb6
            r3.close()
        Lb6:
            if (r2 == 0) goto Lbb
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lbb
        Lbb:
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)
            r1.b()
            goto Lc6
        Lc5:
            throw r0
        Lc6:
            goto Lc5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.g():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:            if (r0 != null) goto L63;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:            r0.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:            if (r0 == null) goto L51;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0049, code lost:            if (r0 != null) goto L63;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            java.util.List<java.lang.Integer> r1 = r4.j     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            if (r1 <= 0) goto L3c
            r1 = 0
        L17:
            java.util.List<java.lang.Integer> r2 = r4.j     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            if (r1 >= r2) goto L3c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            r2.<init>()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            java.lang.String r3 = "delete from __et where rowid="
            r2.append(r3)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            java.util.List<java.lang.Integer> r3 = r4.j     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            r2.append(r3)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            int r1 = r1 + 1
            goto L17
        L3c:
            java.util.List<java.lang.Integer> r1 = r4.j     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            r1.clear()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            if (r0 == 0) goto L4e
            goto L4b
        L47:
            r1 = move-exception
            goto L61
        L49:
            if (r0 == 0) goto L4e
        L4b:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L4e
        L4e:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L60
        L58:
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L47
            com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L4e
            goto L4b
        L60:
            return
        L61:
            if (r0 == 0) goto L66
            r0.endTransaction()     // Catch: java.lang.Throwable -> L66
        L66:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L71
        L70:
            throw r1
        L71:
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.h():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002f, code lost:            if (r0 == null) goto L38;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x001b, code lost:            if (r0 != null) goto L50;     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:            if (r0 != null) goto L50;     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:            r0.endTransaction();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i() {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L1b android.database.sqlite.SQLiteDatabaseCorruptException -> L2a
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L1b android.database.sqlite.SQLiteDatabaseCorruptException -> L2a
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L1b android.database.sqlite.SQLiteDatabaseCorruptException -> L2a
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L1b android.database.sqlite.SQLiteDatabaseCorruptException -> L2a
            java.lang.String r1 = "delete from __er"
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L1b android.database.sqlite.SQLiteDatabaseCorruptException -> L2a
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L1b android.database.sqlite.SQLiteDatabaseCorruptException -> L2a
            if (r0 == 0) goto L20
            goto L1d
        L19:
            r1 = move-exception
            goto L33
        L1b:
            if (r0 == 0) goto L20
        L1d:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L20
        L20:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L32
        L2a:
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L19
            com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L20
            goto L1d
        L32:
            return
        L33:
            if (r0 == 0) goto L38
            r0.endTransaction()     // Catch: java.lang.Throwable -> L38
        L38:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L43
        L42:
            throw r1
        L43:
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.i():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004d, code lost:            if (r1 != null) goto L70;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:            r1.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:            if (r1 == null) goto L51;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:            if (r1 == null) goto L51;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j() {
        /*
            r5 = this;
            java.lang.String r0 = "\""
            java.lang.String r1 = r5.k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L7c
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r3.<init>()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.String r4 = "delete from __er where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.String r4 = r5.k     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r3.append(r4)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r3.append(r0)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r1.execSQL(r3)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r3.<init>()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.String r4 = "delete from __et where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.String r4 = r5.k     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r3.append(r4)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r3.append(r0)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r1.execSQL(r0)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            if (r1 == 0) goto L59
            goto L56
        L50:
            r0 = move-exception
            r1 = r2
            goto L6d
        L53:
            r1 = r2
        L54:
            if (r1 == 0) goto L59
        L56:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L59
        L59:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L7c
        L63:
            r1 = r2
        L64:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L6c
            com.umeng.analytics.pro.f.a(r0)     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L59
            goto L56
        L6c:
            r0 = move-exception
        L6d:
            if (r1 == 0) goto L72
            r1.endTransaction()     // Catch: java.lang.Throwable -> L72
        L72:
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)
            r1.b()
            throw r0
        L7c:
            r5.k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.j():void");
    }

    private g() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = null;
        this.l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(longValue));
            contentValues.put("__sp", c2);
            contentValues.put("__pp", str2);
            contentValues.put("__av", UMGlobalContext.getInstance().getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(f25879d));
            sQLiteDatabase.insert(c.C0139c.f25838a, null, contentValues);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        String str2 = null;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(c.d.a.f25856e);
            if (optJSONObject != null) {
                cursor = sQLiteDatabase.rawQuery("select __d from __sd where __ii=\"" + str + "\"", null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            str2 = d(cursor.getString(cursor.getColumnIndex(c.d.a.f25856e)));
                        } catch (Throwable unused) {
                            if (cursor == null) {
                                return;
                            }
                            cursor.close();
                        }
                    }
                }
            } else {
                cursor = null;
            }
            if (optJSONObject != null) {
                JSONArray jSONArray = new JSONArray();
                if (!TextUtils.isEmpty(str2)) {
                    jSONArray = new JSONArray(str2);
                }
                jSONArray.put(optJSONObject);
                String c2 = c(jSONArray.toString());
                if (!TextUtils.isEmpty(c2)) {
                    sQLiteDatabase.execSQL("update  __sd set __d=\"" + c2 + "\" where __ii=\"" + str + "\"");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(c.d.a.f25855d);
            if (optJSONObject2 != null) {
                String c3 = c(optJSONObject2.toString());
                if (!TextUtils.isEmpty(c3)) {
                    sQLiteDatabase.execSQL("update  __sd set __c=\"" + c3 + "\" where __ii=\"" + str + "\"");
                }
            }
            sQLiteDatabase.execSQL("update  __sd set __f=\"" + String.valueOf(jSONObject.optLong(c.d.a.f25858g)) + "\" where __ii=\"" + str + "\"");
            if (cursor == null) {
                return;
            }
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        cursor.close();
    }

    public void a() {
        this.i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:            if (r3 != null) goto L84;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009d, code lost:            r3.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009b, code lost:            if (r3 == null) goto L85;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(org.json.JSONArray r11) {
        /*
            r10 = this;
            java.lang.String r0 = "__t"
            java.lang.String r1 = "__i"
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L97 java.lang.Throwable -> L9a android.database.sqlite.SQLiteDatabaseCorruptException -> Laa
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)     // Catch: java.lang.Throwable -> L97 java.lang.Throwable -> L9a android.database.sqlite.SQLiteDatabaseCorruptException -> Laa
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L97 java.lang.Throwable -> L9a android.database.sqlite.SQLiteDatabaseCorruptException -> Laa
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteDatabaseCorruptException -> L95 java.lang.Throwable -> L9b
            r4 = 0
        L13:
            int r5 = r11.length()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteDatabaseCorruptException -> L95 java.lang.Throwable -> L9b
            if (r4 >= r5) goto L8d
            org.json.JSONObject r5 = r11.getJSONObject(r4)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r6.<init>()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r7 = r5.optString(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r9 = "-1"
            if (r8 != 0) goto L34
            boolean r8 = r9.equals(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            if (r8 == 0) goto L43
        L34:
            com.umeng.analytics.pro.q r7 = com.umeng.analytics.pro.q.a()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r7 = r7.b()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            if (r8 == 0) goto L43
            r7 = r9
        L43:
            r6.put(r1, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r7 = "__e"
            java.lang.String r8 = "id"
            java.lang.String r8 = r5.optString(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            int r7 = r5.optInt(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r6.put(r0, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r5.remove(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r5.remove(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r7 = "__s"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r5 = r10.c(r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r6.put(r7, r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r5 = "__et"
            r3.insert(r5, r2, r6)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
        L8a:
            int r4 = r4 + 1
            goto L13
        L8d:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteDatabaseCorruptException -> L95 java.lang.Throwable -> L9b
            if (r3 == 0) goto La0
            goto L9d
        L93:
            r11 = move-exception
            goto Lb6
        L95:
            r2 = r3
            goto Laa
        L97:
            r11 = move-exception
            r3 = r2
            goto Lb6
        L9a:
            r3 = r2
        L9b:
            if (r3 == 0) goto La0
        L9d:
            r3.endTransaction()     // Catch: java.lang.Throwable -> La0
        La0:
            android.content.Context r11 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r11 = com.umeng.analytics.pro.e.a(r11)
            r11.b()
            goto Lb5
        Laa:
            android.content.Context r11 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L97
            com.umeng.analytics.pro.f.a(r11)     // Catch: java.lang.Throwable -> L97
            if (r2 == 0) goto La0
            r2.endTransaction()     // Catch: java.lang.Throwable -> La0
            goto La0
        Lb5:
            return
        Lb6:
            if (r3 == 0) goto Lbb
            r3.endTransaction()     // Catch: java.lang.Throwable -> Lbb
        Lbb:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto Lc6
        Lc5:
            throw r11
        Lc6:
            goto Lc5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(org.json.JSONArray):void");
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(f25880e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f25880e.getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:            if (r1 != null) goto L113;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:            r1.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:            if (r1 != null) goto L113;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007b, code lost:            if (r1 != null) goto L113;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(org.json.JSONObject r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L72 java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L8a
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L72 java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L8a
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L72 java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L8a
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            java.lang.String r2 = "select *  from __er"
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            if (r3 != 0) goto L2c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            r2.<init>()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            java.lang.String r3 = "select *  from __er where __i=\""
            r2.append(r3)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            r2.append(r6)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            java.lang.String r6 = "\""
            r2.append(r6)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
        L2c:
            android.database.Cursor r0 = r1.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            if (r0 == 0) goto L65
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            r6.<init>()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
        L37:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            if (r2 == 0) goto L5a
            java.lang.String r2 = "__a"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            if (r3 != 0) goto L37
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            java.lang.String r2 = r4.d(r2)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            r6.put(r3)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            goto L37
        L5a:
            int r2 = r6.length()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            if (r2 <= 0) goto L65
            java.lang.String r2 = "error"
            r5.put(r2, r6)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
        L65:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteDatabaseCorruptException -> L8b java.lang.Throwable -> L99
            if (r0 == 0) goto L6d
            r0.close()
        L6d:
            if (r1 == 0) goto L80
            goto L7d
        L70:
            goto L76
        L72:
            r5 = move-exception
            r1 = r0
            goto L9a
        L75:
            r1 = r0
        L76:
            if (r0 == 0) goto L7b
            r0.close()
        L7b:
            if (r1 == 0) goto L80
        L7d:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L80
        L80:
            android.content.Context r5 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r5 = com.umeng.analytics.pro.e.a(r5)
            r5.b()
            goto L98
        L8a:
            r1 = r0
        L8b:
            android.content.Context r5 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L99
            com.umeng.analytics.pro.f.a(r5)     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L95
            r0.close()
        L95:
            if (r1 == 0) goto L80
            goto L7d
        L98:
            return
        L99:
            r5 = move-exception
        L9a:
            if (r0 == 0) goto L9f
            r0.close()
        L9f:
            if (r1 == 0) goto La4
            r1.endTransaction()     // Catch: java.lang.Throwable -> La4
        La4:
            android.content.Context r6 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r6 = com.umeng.analytics.pro.e.a(r6)
            r6.b()
            goto Laf
        Lae:
            throw r5
        Laf:
            goto Lae
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.b(org.json.JSONObject, java.lang.String):void");
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(f25880e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f25880e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004e, code lost:            if (r1 != null) goto L62;     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005b, code lost:            r1.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:            if (r1 == null) goto L63;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L58 android.database.sqlite.SQLiteDatabaseCorruptException -> L68
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L58 android.database.sqlite.SQLiteDatabaseCorruptException -> L68
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L58 android.database.sqlite.SQLiteDatabaseCorruptException -> L68
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            r2.<init>()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r5 = r4.c(r6)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            if (r6 != 0) goto L4b
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r5 = "__av"
            android.content.Context r6 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r5 = "__vc"
            android.content.Context r6 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
        L4b:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            if (r1 == 0) goto L5e
            goto L5b
        L51:
            r5 = move-exception
            goto L75
        L53:
            r0 = r1
            goto L68
        L55:
            r5 = move-exception
            r1 = r0
            goto L75
        L58:
            r1 = r0
        L59:
            if (r1 == 0) goto L5e
        L5b:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L5e
        L5e:
            android.content.Context r5 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r5 = com.umeng.analytics.pro.e.a(r5)
            r5.b()
            goto L73
        L68:
            android.content.Context r5 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L55
            com.umeng.analytics.pro.f.a(r5)     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L5e
            r0.endTransaction()     // Catch: java.lang.Throwable -> L5e
            goto L5e
        L73:
            r5 = 0
            return r5
        L75:
            if (r1 == 0) goto L7a
            r1.endTransaction()     // Catch: java.lang.Throwable -> L7a
        L7a:
            android.content.Context r6 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r6 = com.umeng.analytics.pro.e.a(r6)
            r6.b()
            goto L85
        L84:
            throw r5
        L85:
            goto L84
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(java.lang.String, java.lang.String, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x00a9, code lost:            if (r1 != null) goto L147;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00c4, code lost:            r1.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c2, code lost:            if (r1 != null) goto L147;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(org.json.JSONObject r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.b(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x007d, code lost:            if (r3 != null) goto L97;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008a, code lost:            r3.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0088, code lost:            if (r3 == null) goto L98;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.g.a r9) {
        /*
            r6 = this;
            java.lang.String r0 = "__e"
            r1 = 0
            if (r8 != 0) goto L6
            return r1
        L6:
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L84 java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L97
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)     // Catch: java.lang.Throwable -> L84 java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L97
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L84 java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L97
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            com.umeng.analytics.pro.g$a r4 = com.umeng.analytics.pro.g.a.BEGIN     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r9 != r4) goto L4f
            java.lang.Object r8 = r8.opt(r0)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            long r8 = r8.longValue()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            r4.<init>()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r5 = "__ii"
            r4.put(r5, r7)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            r4.put(r0, r7)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r7 = "__sd"
            r3.insert(r7, r2, r4)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            goto L7a
        L4f:
            com.umeng.analytics.pro.g$a r0 = com.umeng.analytics.pro.g.a.INSTANTSESSIONBEGIN     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r9 != r0) goto L57
            r6.b(r7, r8, r3)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            goto L7a
        L57:
            com.umeng.analytics.pro.g$a r0 = com.umeng.analytics.pro.g.a.END     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r9 != r0) goto L5f
            r6.a(r7, r8, r3)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            goto L7a
        L5f:
            com.umeng.analytics.pro.g$a r0 = com.umeng.analytics.pro.g.a.PAGE     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r9 != r0) goto L69
            java.lang.String r9 = "__a"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            goto L7a
        L69:
            com.umeng.analytics.pro.g$a r0 = com.umeng.analytics.pro.g.a.AUTOPAGE     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r9 != r0) goto L73
            java.lang.String r9 = "__b"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            goto L7a
        L73:
            com.umeng.analytics.pro.g$a r0 = com.umeng.analytics.pro.g.a.NEWSESSION     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r9 != r0) goto L7a
            r6.c(r7, r8, r3)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
        L7a:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r3 == 0) goto L8d
            goto L8a
        L80:
            r7 = move-exception
            goto La3
        L82:
            r2 = r3
            goto L97
        L84:
            r7 = move-exception
            r3 = r2
            goto La3
        L87:
            r3 = r2
        L88:
            if (r3 == 0) goto L8d
        L8a:
            r3.endTransaction()     // Catch: java.lang.Throwable -> L8d
        L8d:
            android.content.Context r7 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r7 = com.umeng.analytics.pro.e.a(r7)
            r7.b()
            goto La2
        L97:
            android.content.Context r7 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L84
            com.umeng.analytics.pro.f.a(r7)     // Catch: java.lang.Throwable -> L84
            if (r2 == 0) goto L8d
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8d
            goto L8d
        La2:
            return r1
        La3:
            if (r3 == 0) goto La8
            r3.endTransaction()     // Catch: java.lang.Throwable -> La8
        La8:
            android.content.Context r8 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r8 = com.umeng.analytics.pro.e.a(r8)
            r8.b()
            goto Lb3
        Lb2:
            throw r7
        Lb3:
            goto Lb2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.g$a):boolean");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.opt(c.d.a.f25858g)).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", __sp=\"" + c2 + "\", __pp=\"" + str2 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0057, code lost:            r0.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0069, code lost:            if (r0 == null) goto L59;     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:            if (r0 != null) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0050, code lost:            if (r0 != null) goto L71;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(boolean r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            if (r4 == 0) goto L18
            if (r3 == 0) goto L4d
            java.lang.String r3 = "delete from __sd"
            r0.execSQL(r3)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            goto L4d
        L18:
            java.util.List<java.lang.String> r3 = r2.i     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            if (r3 <= 0) goto L4d
            r3 = 0
        L21:
            java.util.List<java.lang.String> r4 = r2.i     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            if (r3 >= r4) goto L4d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r4.<init>()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r1 = "delete from __sd where __ii=\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.util.List<java.lang.String> r1 = r2.i     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r4.append(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r1 = "\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            int r3 = r3 + 1
            goto L21
        L4d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            if (r0 == 0) goto L5a
            goto L57
        L53:
            r3 = move-exception
            goto L6d
        L55:
            if (r0 == 0) goto L5a
        L57:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L5a
        L5a:
            android.content.Context r3 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)
            r3.b()
            goto L6c
        L64:
            android.content.Context r3 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L53
            com.umeng.analytics.pro.f.a(r3)     // Catch: java.lang.Throwable -> L53
            if (r0 == 0) goto L5a
            goto L57
        L6c:
            return
        L6d:
            if (r0 == 0) goto L72
            r0.endTransaction()     // Catch: java.lang.Throwable -> L72
        L72:
            android.content.Context r4 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r4 = com.umeng.analytics.pro.e.a(r4)
            r4.b()
            goto L7d
        L7c:
            throw r3
        L7d:
            goto L7c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.b(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:            if (r3 != null) goto L63;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:            r3.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:            if (r3 != null) goto L63;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "select __f from __sd where __ii=\""
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = "\""
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r0 = 0
            r1 = 0
            android.content.Context r3 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L59
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L59
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L59
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L5a
            android.database.Cursor r0 = r3.rawQuery(r5, r0)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L5a
            if (r0 == 0) goto L39
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L5a
            java.lang.String r5 = "__f"
            int r5 = r0.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L5a
            long r1 = r0.getLong(r5)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L5a
        L39:
            if (r0 == 0) goto L3e
            r0.close()     // Catch: java.lang.Exception -> L64
        L3e:
            if (r3 == 0) goto L64
            goto L61
        L41:
            r5 = move-exception
            goto L45
        L43:
            r5 = move-exception
            r3 = r0
        L45:
            if (r0 == 0) goto L4a
            r0.close()     // Catch: java.lang.Exception -> L4f
        L4a:
            if (r3 == 0) goto L4f
            r3.endTransaction()     // Catch: java.lang.Exception -> L4f
        L4f:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            throw r5
        L59:
            r3 = r0
        L5a:
            if (r0 == 0) goto L5f
            r0.close()     // Catch: java.lang.Exception -> L64
        L5f:
            if (r3 == 0) goto L64
        L61:
            r3.endTransaction()     // Catch: java.lang.Exception -> L64
        L64:
            android.content.Context r5 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r5 = com.umeng.analytics.pro.e.a(r5)
            r5.b()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(java.lang.String):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:            r0.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:            if (r0 == null) goto L44;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0035, code lost:            if (r0 != null) goto L56;     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:            if (r0 != null) goto L56;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            if (r1 != 0) goto L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            r1.<init>()     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            java.lang.String r2 = "delete from __is where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            r1.append(r4)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            java.lang.String r4 = "\""
            r1.append(r4)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
        L2d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            if (r0 == 0) goto L3a
            goto L37
        L33:
            r4 = move-exception
            goto L4d
        L35:
            if (r0 == 0) goto L3a
        L37:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L3a
        L3a:
            android.content.Context r4 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r4 = com.umeng.analytics.pro.e.a(r4)
            r4.b()
            goto L4c
        L44:
            android.content.Context r4 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L33
            com.umeng.analytics.pro.f.a(r4)     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L3a
            goto L37
        L4c:
            return
        L4d:
            if (r0 == 0) goto L52
            r0.endTransaction()     // Catch: java.lang.Throwable -> L52
        L52:
            android.content.Context r0 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L5d
        L5c:
            throw r4
        L5d:
            goto L5c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.b(java.lang.String):void");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) throws JSONException {
        Cursor cursor;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        String str3 = null;
        try {
            if ("__a".equals(str2)) {
                jSONArray = jSONObject.optJSONArray("__a");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    return;
                }
            } else if (c.d.a.f25854c.equals(str2)) {
                jSONArray = jSONObject.optJSONArray(c.d.a.f25854c);
                if (jSONArray == null || jSONArray.length() <= 0) {
                    return;
                }
            } else {
                jSONArray = null;
            }
            cursor = sQLiteDatabase.rawQuery("select " + str2 + " from " + c.d.f25851a + " where __ii=\"" + str + "\"", null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        str3 = d(cursor.getString(cursor.getColumnIndex(str2)));
                    } catch (Throwable unused) {
                        if (cursor == null) {
                            return;
                        }
                        cursor.close();
                    }
                }
            }
            jSONArray2 = new JSONArray();
            if (!TextUtils.isEmpty(str3)) {
                jSONArray2 = new JSONArray(str3);
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        if (jSONArray2.length() > 1000) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    jSONArray2.put(jSONObject2);
                }
            } catch (JSONException unused3) {
            }
        }
        String c2 = c(jSONArray2.toString());
        if (!TextUtils.isEmpty(c2)) {
            sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + c2 + "\" where __ii=\"" + str + "\"");
        }
        if (cursor == null) {
            return;
        }
        cursor.close();
    }

    public JSONObject a(boolean z) {
        a();
        this.j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String a2 = a(jSONObject, z);
            if (!TextUtils.isEmpty(a2)) {
                b(jSONObject, a2);
                a(jSONObject, a2);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0193, code lost:            if (r1 != null) goto L218;     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0179, code lost:            if (r1 != null) goto L218;     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x016b, code lost:            if (r1 != null) goto L218;     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x017b, code lost:            r1.endTransaction();     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v0, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.json.JSONObject r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x017b, code lost:            if (r3 != null) goto L211;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0196, code lost:            r3.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0194, code lost:            if (r3 != null) goto L211;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(org.json.JSONObject r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:            r0.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:            if (r0 == null) goto L57;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004f, code lost:            if (r0 != null) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004a, code lost:            if (r0 != null) goto L71;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r4, boolean r5) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            if (r5 == 0) goto L18
            if (r4 == 0) goto L47
            java.lang.String r4 = "delete from __is"
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            goto L47
        L18:
            java.util.List<java.lang.String> r4 = r3.l     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            if (r4 <= 0) goto L47
            r5 = 0
        L21:
            if (r5 >= r4) goto L47
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            r1.<init>()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            java.lang.String r2 = "delete from __is where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            java.util.List<java.lang.String> r2 = r3.l     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            java.lang.Object r2 = r2.get(r5)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            r1.append(r2)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            java.lang.String r2 = "\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            int r5 = r5 + 1
            goto L21
        L47:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            if (r0 == 0) goto L54
            goto L51
        L4d:
            r4 = move-exception
            goto L67
        L4f:
            if (r0 == 0) goto L54
        L51:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L54
        L54:
            android.content.Context r4 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r4 = com.umeng.analytics.pro.e.a(r4)
            r4.b()
            goto L66
        L5e:
            android.content.Context r4 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L4d
            com.umeng.analytics.pro.f.a(r4)     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L54
            goto L51
        L66:
            return
        L67:
            if (r0 == 0) goto L6c
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6c
        L6c:
            android.content.Context r5 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r5 = com.umeng.analytics.pro.e.a(r5)
            r5.b()
            goto L77
        L76:
            throw r4
        L77:
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x006a, code lost:            r0.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:            if (r0 == null) goto L44;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:            if (r0 != null) goto L56;     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0063, code lost:            if (r0 != null) goto L56;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = "\""
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            if (r1 != 0) goto L60
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.<init>()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.String r2 = "delete from __er where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.append(r5)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.append(r4)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.<init>()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.String r2 = "delete from __et where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.append(r5)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.append(r4)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.util.List<java.lang.Integer> r1 = r3.j     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.clear()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.<init>()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.String r2 = "delete from __sd where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.append(r5)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.append(r4)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
        L60:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            if (r0 == 0) goto L6d
            goto L6a
        L66:
            r4 = move-exception
            goto L80
        L68:
            if (r0 == 0) goto L6d
        L6a:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6d
        L6d:
            android.content.Context r4 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r4 = com.umeng.analytics.pro.e.a(r4)
            r4.b()
            goto L7f
        L77:
            android.content.Context r4 = com.umeng.analytics.pro.g.f25879d     // Catch: java.lang.Throwable -> L66
            com.umeng.analytics.pro.f.a(r4)     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L6d
            goto L6a
        L7f:
            return
        L80:
            if (r0 == 0) goto L85
            r0.endTransaction()     // Catch: java.lang.Throwable -> L85
        L85:
            android.content.Context r5 = com.umeng.analytics.pro.g.f25879d
            com.umeng.analytics.pro.e r5 = com.umeng.analytics.pro.e.a(r5)
            r5.b()
            goto L90
        L8f:
            throw r4
        L90:
            goto L8f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(boolean, java.lang.String):void");
    }
}
