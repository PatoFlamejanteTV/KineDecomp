package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.pro.w;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.a;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    /* loaded from: classes3.dex */
    private class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.f26005c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.f26005c, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.f26006d, ""), (JSONArray) obj);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    private class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.f26005c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.f26005c, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.f26006d, ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        int f25995a;

        /* renamed from: b, reason: collision with root package name */
        String f25996b;

        /* renamed from: c, reason: collision with root package name */
        String f25997c;

        /* renamed from: d, reason: collision with root package name */
        String f25998d;

        /* renamed from: e, reason: collision with root package name */
        int f25999e;

        /* renamed from: f, reason: collision with root package name */
        String f26000f;

        /* renamed from: g, reason: collision with root package name */
        String f26001g;

        /* renamed from: h, reason: collision with root package name */
        String f26002h;

        private a() {
        }
    }

    private UMProcessDBHelper() {
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.f25997c = jSONObject.optString("id");
                aVar.f26001g = UMUtils.getAppVersionName(this.mContext);
                aVar.f26002h = UMUtils.getAppVersionCode(this.mContext);
                aVar.f25996b = jSONObject.optString("__i");
                aVar.f25999e = jSONObject.optInt("__t");
                aVar.f26000f = str;
                if (jSONObject.has(com.umeng.analytics.pro.b.ac)) {
                    jSONObject.remove(com.umeng.analytics.pro.b.ac);
                }
                jSONObject.put(com.umeng.analytics.pro.b.ac, getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.f25998d = w.a().a(jSONObject.toString());
                jSONObject.remove(com.umeng.analytics.pro.b.ac);
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable th) {
            throw th;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(String str, List<a> list) {
        SQLiteDatabase sQLiteDatabase;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        try {
            sQLiteDatabase = c.a(this.mContext).a(str);
        } catch (Exception unused) {
            sQLiteDatabase = null;
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            try {
                sQLiteDatabase.beginTransaction();
                for (a aVar : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__i", aVar.f25996b);
                        contentValues.put("__e", aVar.f25997c);
                        contentValues.put("__t", Integer.valueOf(aVar.f25999e));
                        contentValues.put(a.InterfaceC0140a.f26016f, aVar.f26000f);
                        contentValues.put("__av", aVar.f26001g);
                        contentValues.put("__vc", aVar.f26002h);
                        contentValues.put("__s", aVar.f25998d);
                        sQLiteDatabase.insert(a.InterfaceC0140a.f26011a, null, contentValues);
                    } catch (Exception unused2) {
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused3) {
                    }
                }
                c.a(this.mContext).b(str);
                return true;
            } catch (Exception unused4) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                c.a(this.mContext).b(str);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused6) {
                }
            }
            c.a(this.mContext).b(str);
            throw th;
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.f26010h, readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x008c, code lost:            if (r3 != null) goto L28;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a9, code lost:            r3.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a7, code lost:            if (r3 != null) goto L28;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "select *  from __et_p"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            android.content.Context r3 = r7.mContext     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9b
            com.umeng.analytics.process.c r3 = com.umeng.analytics.process.c.a(r3)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9b
            android.database.sqlite.SQLiteDatabase r3 = r3.a(r8)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9b
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L92
            android.database.Cursor r0 = r3.rawQuery(r0, r2)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L92
            if (r0 == 0) goto L87
        L1b:
            boolean r4 = r0.moveToNext()     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            if (r4 == 0) goto L87
            com.umeng.analytics.process.UMProcessDBHelper$a r4 = new com.umeng.analytics.process.UMProcessDBHelper$a     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            r4.<init>()     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            r5 = 0
            int r5 = r0.getInt(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            r4.f25995a = r5     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = "__i"
            int r5 = r0.getColumnIndex(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = r0.getString(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            r4.f25996b = r5     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = "__e"
            int r5 = r0.getColumnIndex(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = r0.getString(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            r4.f25997c = r5     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = "__s"
            int r5 = r0.getColumnIndex(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = r0.getString(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            r4.f25998d = r5     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = "__t"
            int r5 = r0.getColumnIndex(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            int r5 = r0.getInt(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            r4.f25999e = r5     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = "__pn"
            int r5 = r0.getColumnIndex(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = r0.getString(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            r4.f26000f = r5     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = "__av"
            int r5 = r0.getColumnIndex(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = r0.getString(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            r4.f26001g = r5     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = "__vc"
            int r5 = r0.getColumnIndex(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            java.lang.String r5 = r0.getString(r5)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            r4.f26002h = r5     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            r1.add(r4)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Lb6
            goto L1b
        L85:
            r2 = move-exception
            goto L9f
        L87:
            if (r0 == 0) goto L8c
            r0.close()     // Catch: java.lang.Exception -> Lac
        L8c:
            if (r3 == 0) goto Lac
            goto La9
        L8f:
            r1 = move-exception
            r0 = r2
            goto Lb7
        L92:
            r0 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L9f
        L97:
            r1 = move-exception
            r0 = r2
            r3 = r0
            goto Lb7
        L9b:
            r0 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
        L9f:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> Lb6
            if (r0 == 0) goto La7
            r0.close()     // Catch: java.lang.Exception -> Lac
        La7:
            if (r3 == 0) goto Lac
        La9:
            r3.endTransaction()     // Catch: java.lang.Exception -> Lac
        Lac:
            android.content.Context r0 = r7.mContext
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a(r0)
            r0.b(r8)
            return r1
        Lb6:
            r1 = move-exception
        Lb7:
            if (r0 == 0) goto Lbc
            r0.close()     // Catch: java.lang.Exception -> Lc1
        Lbc:
            if (r3 == 0) goto Lc1
            r3.endTransaction()     // Catch: java.lang.Exception -> Lc1
        Lc1:
            android.content.Context r0 = r7.mContext
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a(r0)
            r0.b(r8)
            goto Lcc
        Lcb:
            throw r1
        Lcc:
            goto Lcb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:            if (r0 != null) goto L28;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:            com.umeng.analytics.process.c.a(r4.mContext).b(r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:            r0.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:            if (r0 == null) goto L29;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteEventDatas(java.lang.String r5, java.lang.String r6, java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> r7) {
        /*
            r4 = this;
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L7
            return
        L7:
            r6 = 0
            android.content.Context r0 = r4.mContext     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L60
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a(r0)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L60
            android.database.sqlite.SQLiteDatabase r0 = r0.a(r5)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L60
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            int r1 = r7.size()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r7 == 0) goto L3f
            if (r1 <= 0) goto L3f
            r6 = 0
        L1e:
            if (r6 >= r1) goto L44
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r2.<init>()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r3 = "delete from __et_p where rowid="
            r2.append(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.Object r3 = r7.get(r6)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            com.umeng.analytics.process.UMProcessDBHelper$a r3 = (com.umeng.analytics.process.UMProcessDBHelper.a) r3     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            int r3 = r3.f25995a     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r2.append(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            int r6 = r6 + 1
            goto L1e
        L3f:
            java.lang.String r7 = "__et_p"
            r0.delete(r7, r6, r6)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
        L44:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r0 == 0) goto L66
            goto L63
        L4a:
            r6 = move-exception
            goto L51
        L4c:
            goto L61
        L4e:
            r7 = move-exception
            r0 = r6
            r6 = r7
        L51:
            if (r0 == 0) goto L56
            r0.endTransaction()
        L56:
            android.content.Context r7 = r4.mContext
            com.umeng.analytics.process.c r7 = com.umeng.analytics.process.c.a(r7)
            r7.b(r5)
            throw r6
        L60:
            r0 = r6
        L61:
            if (r0 == 0) goto L66
        L63:
            r0.endTransaction()
        L66:
            android.content.Context r6 = r4.mContext
            com.umeng.analytics.process.c r6 = com.umeng.analytics.process.c.a(r6)
            r6.b(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteEventDatas(java.lang.String, java.lang.String, java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004e, code lost:            com.umeng.analytics.process.c.a(r7.mContext).b(com.umeng.analytics.process.a.f26010h);     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0057, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:            r1.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:            if (r1 == null) goto L18;     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:            if (r1 != null) goto L17;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteMainProcessEventDatasByIds(java.util.List<java.lang.Integer> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "_main_"
            r1 = 0
            android.content.Context r2 = r7.mContext     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            android.database.sqlite.SQLiteDatabase r1 = r2.a(r0)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
        L14:
            boolean r2 = r8.hasNext()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            if (r2 == 0) goto L32
            java.lang.Object r2 = r8.next()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.lang.String r3 = "__et_p"
            java.lang.String r4 = "id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r6 = 0
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r5[r6] = r2     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r1.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            goto L14
        L32:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            if (r1 == 0) goto L4e
            goto L4b
        L38:
            r8 = move-exception
            if (r1 == 0) goto L3e
            r1.endTransaction()
        L3e:
            android.content.Context r1 = r7.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r0)
            throw r8
        L48:
            if (r1 == 0) goto L4e
        L4b:
            r1.endTransaction()
        L4e:
            android.content.Context r8 = r7.mContext
            com.umeng.analytics.process.c r8 = com.umeng.analytics.process.c.a(r8)
            r8.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteMainProcessEventDatasByIds(java.util.List):void");
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0142, code lost:            if (r5 != null) goto L81;     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0156, code lost:            r5.endTransaction();     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0154, code lost:            if (r5 != null) goto L81;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r3v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.database.sqlite.SQLiteDatabase, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r6v1, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject readMainEvents(long r19, java.util.List<java.lang.Integer> r21) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    public JSONObject readVersionInfoFromColumId(Integer num) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        String str = "select *  from __et_p where rowid=" + num;
        Cursor cursor2 = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        cursor2 = null;
        cursor2 = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.f26010h);
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    cursor = sQLiteDatabase.rawQuery(str, null);
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = cursor.getString(cursor.getColumnIndex("__av"));
                                        String string2 = cursor.getString(cursor.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e2) {
                                        e = e2;
                                        cursor2 = cursor;
                                        e.printStackTrace();
                                        if (cursor2 != null) {
                                            try {
                                                cursor2.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.f26010h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f26010h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception unused2) {
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f26010h);
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                }
                                c.a(this.mContext).b(com.umeng.analytics.process.a.f26010h);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            jSONObject = null;
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.f26010h);
                    return jSONObject2;
                } catch (Exception e4) {
                    e = e4;
                    jSONObject = null;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursor2;
            }
        } catch (Exception e5) {
            e = e5;
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            sQLiteDatabase = null;
        }
    }

    private UMProcessDBHelper(Context context) {
        w.a().a(context);
    }
}
