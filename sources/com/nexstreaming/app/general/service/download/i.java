package com.nexstreaming.app.general.service.download;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import com.nexstreaming.app.general.service.download.m;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DownloadHelper.java */
/* loaded from: classes2.dex */
public class i extends com.nexstreaming.app.general.service.a {

    /* renamed from: b */
    private static n f19703b;

    /* renamed from: c */
    private static final Map<String, ResultTask<k>> f19704c = new HashMap();

    /* renamed from: d */
    private Task f19705d;

    /* renamed from: e */
    private ServiceConnection f19706e;

    /* renamed from: f */
    private m.a f19707f;

    public i(Context context) {
        super(context);
        this.f19705d = null;
        this.f19706e = new c(this);
        this.f19707f = new h(this);
    }

    public void f() {
        n nVar = f19703b;
        if (nVar != null) {
            try {
                nVar.b(this.f19707f);
            } catch (RemoteException e2) {
                Log.w("DownloadHelper", "onDisposeCompleted: ", e2);
            }
        }
        this.f19705d = null;
    }

    public void c() {
        NexDownloadService.a(a());
    }

    public void d() {
        f();
    }

    public Task e() {
        this.f19705d = new Task();
        if (f19703b != null) {
            this.f19705d.signalEvent(Task.Event.COMPLETE);
            a(f19703b);
        } else {
            NexDownloadService.a(a().getApplicationContext(), this.f19706e);
        }
        return this.f19705d;
    }

    public boolean b(String str) {
        n nVar = f19703b;
        if (nVar != null) {
            try {
                return nVar.a(str);
            } catch (RemoteException e2) {
                Log.w("DownloadHelper", "isDownloading: ", e2);
            }
        }
        return false;
    }

    public ResultTask<k> a(String str) {
        return f19704c.get(str);
    }

    public ResultTask<k> a(k kVar) {
        ResultTask<k> resultTask = null;
        if (kVar != null) {
            if (f19703b != null) {
                try {
                    if (f19704c.get(kVar.e()) != null) {
                        resultTask = f19704c.get(kVar.e());
                    } else {
                        ResultTask<k> resultTask2 = new ResultTask<>();
                        try {
                            f19704c.put(kVar.e(), resultTask2);
                            Log.e("DownloadHelper", "download() called with: result = [" + f19703b.a(kVar) + "]");
                            resultTask = resultTask2;
                        } catch (RemoteException e2) {
                            e = e2;
                            resultTask = resultTask2;
                            Log.e("DownloadHelper", "service connection error", e);
                            resultTask.sendFailure(new b(49, R.string.asset_download_failed, e));
                            return resultTask;
                        }
                    }
                    return resultTask;
                } catch (RemoteException e3) {
                    e = e3;
                }
            } else {
                ResultTask<k> resultTask3 = new ResultTask<>();
                Log.e("DownloadHelper", "service connection error : iDownloadService = null");
                resultTask3.sendFailure(new b(48, R.string.asset_download_failed, new Exception("Download Service connection fail")));
                return resultTask3;
            }
        } else {
            Log.e("DownloadHelper", "service connection error : downloadInfo = null");
            resultTask.sendFailure(new b(64, R.string.asset_download_failed, new Exception("download() parameter is null")));
            return null;
        }
    }

    public void a(n nVar) {
        if (f19703b == null) {
            f19703b = nVar;
        }
        try {
            f19703b.a(this.f19707f);
            if (this.f19705d != null) {
                this.f19705d.signalEvent(Task.Event.COMPLETE);
            }
        } catch (RemoteException e2) {
            Log.w("DownloadHelper", "onStartUpCompleted: ", e2);
            Task task = this.f19705d;
            if (task != null) {
                task.signalEvent(Task.Event.FAIL);
            }
        }
    }
}
