package com.umeng.analytics.filter;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class EventList extends c implements FileLockCallback {
    private static final int DELETE_LIST_DATA = 2;
    private static final int LOAD_LIST_DATA = 1;
    private static final int SAVE_LIST_DATA = 0;
    private Context mAppContext;
    protected String mEventList;
    protected String mEventListKey;
    protected String mEventListName;
    protected String mEventListVersionKey;
    private FileLockUtil mFileLock = new FileLockUtil();

    public EventList(String str, String str2) {
        this.mEventListName = str;
        this.mEventListKey = str;
        this.mEventListVersionKey = str2;
    }

    private void deleteDataFile(File file) {
        if (this.mAppContext != null) {
            synchronized (this.mFileLock) {
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean loadEventListFromFile(android.content.Context r9, java.io.File r10) {
        /*
            r8 = this;
            boolean r0 = r10.exists()
            r1 = 0
            if (r0 == 0) goto Lc9
            java.lang.String r0 = r8.mEventList
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Lc9
            r0 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lab
            r2.<init>(r10)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lab
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lab
            r10.<init>(r2)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lab
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            r0.<init>()     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
        L1f:
            java.lang.String r2 = r10.readLine()     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            if (r2 == 0) goto L29
            r0.append(r2)     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            goto L1f
        L29:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            if (r2 != 0) goto La0
            java.lang.String r2 = com.umeng.commonsdk.statistics.common.HelperUtils.getMD5(r0)     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            java.lang.String r3 = r8.mEventListVersionKey     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            java.lang.String r4 = ""
            java.lang.String r3 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r9, r3, r4)     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            r8.mEventList = r0     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            r8.eventListChange()     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            java.lang.String r4 = "MobclickRT"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            r5.<init>()     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            java.lang.String r6 = "--->>> loadEventListFromFile: mEventList = "
            r5.append(r6)     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            java.lang.String r6 = r8.mEventList     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            r5.append(r6)     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            com.umeng.commonsdk.debug.UMRTLog.i(r4, r5)     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            boolean r4 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r9)     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            r5 = 1
            if (r4 == 0) goto L83
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            if (r2 == 0) goto L77
            r8.mEventList = r0     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            r8.setMD5ClearFlag(r1)     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            r10.close()     // Catch: java.lang.Throwable -> L72
            goto L76
        L72:
            r10 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10)
        L76:
            return r5
        L77:
            r8.setMD5ClearFlag(r5)     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            r10.close()     // Catch: java.lang.Throwable -> L7e
            goto L82
        L7e:
            r10 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10)
        L82:
            return r1
        L83:
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            if (r2 == 0) goto L97
            r8.mEventList = r0     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            r8.eventListChange()     // Catch: java.lang.Throwable -> La4 java.lang.Throwable -> Lbd
            r10.close()     // Catch: java.lang.Throwable -> L92
            goto L96
        L92:
            r10 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10)
        L96:
            return r5
        L97:
            r10.close()     // Catch: java.lang.Throwable -> L9b
            goto L9f
        L9b:
            r10 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10)
        L9f:
            return r1
        La0:
            r10.close()     // Catch: java.lang.Throwable -> Lb8
            goto Lc9
        La4:
            r0 = move-exception
            goto Laf
        La6:
            r10 = move-exception
            r7 = r0
            r0 = r10
            r10 = r7
            goto Lbe
        Lab:
            r10 = move-exception
            r7 = r0
            r0 = r10
            r10 = r7
        Laf:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r0)     // Catch: java.lang.Throwable -> Lbd
            if (r10 == 0) goto Lc9
            r10.close()     // Catch: java.lang.Throwable -> Lb8
            goto Lc9
        Lb8:
            r10 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10)
            goto Lc9
        Lbd:
            r0 = move-exception
        Lbe:
            if (r10 == 0) goto Lc8
            r10.close()     // Catch: java.lang.Throwable -> Lc4
            goto Lc8
        Lc4:
            r10 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10)
        Lc8:
            throw r0
        Lc9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.filter.EventList.loadEventListFromFile(android.content.Context, java.io.File):boolean");
    }

    private void saveEventListToFile(Context context, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(this.mEventList.getBytes());
            fileOutputStream.close();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public boolean enabled() {
        synchronized (this) {
            return this.mEventList != null;
        }
    }

    protected void eventListChange() {
    }

    public boolean matchHit(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i) {
        if (i == 0) {
            synchronized (this) {
                saveEventListToFile(this.mAppContext, file);
            }
        } else if (i == 1) {
            synchronized (this) {
                if (loadEventListFromFile(this.mAppContext, file)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> find event list data file, load it.");
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> can't find event list file.");
                }
            }
        } else if (i == 2) {
            synchronized (this) {
                this.mEventList = null;
                deleteDataFile(file);
            }
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    @Override // com.umeng.analytics.filter.c, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        if (com.umeng.analytics.pro.b.ak.equals(str) && str2 == null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> disable black list for ekv.");
            this.mFileLock.doFileOperateion(new File(this.mAppContext.getFilesDir(), this.mEventListName), this, 2);
        }
        if (com.umeng.analytics.pro.b.al.equals(str) && str2 == null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> disable white list for ekv.");
            this.mFileLock.doFileOperateion(new File(this.mAppContext.getFilesDir(), this.mEventListName), this, 2);
        }
    }

    @Override // com.umeng.analytics.filter.c, com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
    public boolean onPreProcessImprintKey(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onPreProcessImprintKey: key = " + str + "; len of value=" + str2.length());
        StringBuilder sb = new StringBuilder();
        sb.append("--->>> onPreProcessImprintKey: value = ");
        sb.append(str2);
        UMRTLog.i(UMRTLog.RTLOG_TAG, sb.toString());
        this.mEventList = str2;
        eventListChange();
        File file = new File(this.mAppContext.getFilesDir(), this.mEventListName);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    file.createNewFile();
                }
            } catch (IOException e2) {
                UMCrashManager.reportCrash(this.mAppContext, e2);
            }
        }
        this.mFileLock.doFileOperateion(file, this, 0);
        setMD5ClearFlag(false);
        return true;
    }

    public void register(Context context) {
        if (this.mAppContext == null) {
            this.mAppContext = context.getApplicationContext();
        }
        File file = new File(this.mAppContext.getFilesDir(), this.mEventListName);
        if (!TextUtils.isEmpty(UMEnvelopeBuild.imprintProperty(this.mAppContext, this.mEventListVersionKey, ""))) {
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this, 1);
            } else {
                setMD5ClearFlag(true);
            }
        }
        if (UMUtils.isMainProgress(this.mAppContext)) {
            ImprintHandler.getImprintService(this.mAppContext).registPreProcessCallback(this.mEventListKey, this);
            ImprintHandler.getImprintService(this.mAppContext).registImprintCallback(this.mEventListVersionKey, this);
        }
    }

    public void setMD5ClearFlag(boolean z) {
    }

    public String toString() {
        if (TextUtils.isEmpty(this.mEventListName) || TextUtils.isEmpty(this.mEventListKey)) {
            return "Uninitialized EventList.";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append("EventListName:" + this.mEventListName + ",");
        sb.append("listKey:" + this.mEventListKey + ",");
        if (!TextUtils.isEmpty(this.mEventList)) {
            sb.append("listKeyValue:" + this.mEventList + "]");
        } else {
            sb.append("listKeyValue:empty,");
        }
        if (!TextUtils.isEmpty(this.mEventListVersionKey)) {
            sb.append("listKeyVer:" + this.mEventListVersionKey + "]");
        } else {
            sb.append("listKeyVer:empty]");
        }
        return sb.toString();
    }
}
