package com.nexstreaming.kinemaster.tracelog;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.ResponseCode;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.APCManager;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: APCManager.java */
/* loaded from: classes.dex */
public class c implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f21281a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ResultTask resultTask) {
        this.f21281a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        if (taskError instanceof ResponseCode) {
            int i = e.f21286a[((ResponseCode) taskError).ordinal()];
            if (i == 1 || i == 2) {
                this.f21281a.sendFailure(new APCManager.a(false, "verifyFail", R.string.apc_err_verify_fail, R.string.apc_license_err_verify_fail, (Date) null));
                return;
            }
            if (i == 3) {
                this.f21281a.sendFailure(new APCManager.a(false, "alreadyUsed", R.string.apc_err_already_used, R.string.apc_license_err, null, 101));
                return;
            } else if (i != 4) {
                this.f21281a.sendFailure(new APCManager.a(false, "verifyFail", R.string.apc_err_verify_fail, R.string.apc_license_err_verify_fail, (Date) null));
                return;
            } else {
                this.f21281a.sendFailure(new APCManager.a(false, "expiredCode", R.string.apc_err_expired, R.string.apc_license_err, null, 100));
                return;
            }
        }
        this.f21281a.sendFailure(new APCManager.a(false, "verifyFail", R.string.apc_err_network, (Date) null, taskError));
    }
}
