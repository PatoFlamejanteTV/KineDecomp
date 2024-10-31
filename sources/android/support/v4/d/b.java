package android.support.v4.d;

import android.os.AsyncTask;

/* compiled from: AsyncTaskCompatHoneycomb.java */
/* loaded from: classes.dex */
class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
