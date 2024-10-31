package com.umeng.analytics.process;

import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class DBFileTraversalUtil {

    /* renamed from: a */
    private static ExecutorService f25984a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private static FileLockUtil f25985b = new FileLockUtil();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.umeng.analytics.process.DBFileTraversalUtil$1 */
    /* loaded from: classes3.dex */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ File f25986a;

        /* renamed from: b */
        final /* synthetic */ FileLockCallback f25987b;

        /* renamed from: c */
        final /* synthetic */ a f25988c;

        AnonymousClass1(File file, FileLockCallback fileLockCallback, a aVar) {
            file = file;
            fileLockCallback = fileLockCallback;
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (File file : file.listFiles()) {
                if (file.getName().endsWith(com.umeng.analytics.process.a.f26006d)) {
                    DBFileTraversalUtil.f25985b.doFileOperateion(file, fileLockCallback);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> file: " + file.getName());
                }
            }
            a aVar = aVar;
            if (aVar != null) {
                aVar.a();
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> end *** ");
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public static void traverseDBFiles(String str, FileLockCallback fileLockCallback, a aVar) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            f25984a.execute(new Runnable() { // from class: com.umeng.analytics.process.DBFileTraversalUtil.1

                /* renamed from: a */
                final /* synthetic */ File f25986a;

                /* renamed from: b */
                final /* synthetic */ FileLockCallback f25987b;

                /* renamed from: c */
                final /* synthetic */ a f25988c;

                AnonymousClass1(File file2, FileLockCallback fileLockCallback2, a aVar2) {
                    file = file2;
                    fileLockCallback = fileLockCallback2;
                    aVar = aVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    for (File file2 : file.listFiles()) {
                        if (file2.getName().endsWith(com.umeng.analytics.process.a.f26006d)) {
                            DBFileTraversalUtil.f25985b.doFileOperateion(file2, fileLockCallback);
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> file: " + file2.getName());
                        }
                    }
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> end *** ");
                }
            });
        }
    }
}
