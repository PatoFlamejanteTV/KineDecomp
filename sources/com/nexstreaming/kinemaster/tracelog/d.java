package com.nexstreaming.kinemaster.tracelog;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.AuthPromocodeResponse;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.APCManager;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: APCManager.java */
/* loaded from: classes.dex */
public class d implements ResultTask.OnResultAvailableListener<AuthPromocodeResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f21282a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f21283b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f21284c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ResultTask f21285d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, SharedPreferences sharedPreferences, String str, ResultTask resultTask) {
        this.f21282a = context;
        this.f21283b = sharedPreferences;
        this.f21284c = str;
        this.f21285d = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<AuthPromocodeResponse> resultTask, Task.Event event, AuthPromocodeResponse authPromocodeResponse) {
        Log.i("APCManager", "response :  result = [" + authPromocodeResponse.getResult() + "] result = [" + authPromocodeResponse.getResponseCode() + "]");
        switch (e.f21286a[authPromocodeResponse.getResponseCode().ordinal()]) {
            case 1:
                this.f21285d.sendFailure(new APCManager.a(false, "verifyFail", R.string.apc_err_verify_fail, R.string.apc_license_err_verify_fail, (Date) null));
                return;
            case 2:
                this.f21285d.sendFailure(new APCManager.a(false, "verifyFail", R.string.apc_err_verify_fail, R.string.apc_license_err_verify_fail, (Date) null));
                return;
            case 3:
                this.f21285d.sendFailure(new APCManager.a(false, "alreadyUsed", R.string.apc_err_already_used, R.string.apc_license_err, null, 101));
                return;
            case 4:
                this.f21285d.sendFailure(new APCManager.a(false, "expiredCode", R.string.apc_err_expired, R.string.apc_license_err, null, 100));
                return;
            case 5:
                APCManager.b(this.f21282a, authPromocodeResponse, this.f21283b, this.f21284c);
                this.f21285d.sendResult(new APCManager.a(true, "codeApplied", R.string.apc_applied, R.string.apc_license_applied, authPromocodeResponse.getExpDate()));
                return;
            case 6:
                APCManager.b(this.f21282a, authPromocodeResponse, this.f21283b, this.f21284c);
                this.f21285d.sendResult(new APCManager.a(true, "codeApplied", R.string.apc_applied, R.string.apc_license_applied, authPromocodeResponse.getExpDate()));
                return;
            default:
                this.f21285d.sendFailure(new APCManager.a(false, "verifyFail", R.string.apc_err_verify_fail, R.string.apc_license_err_verify_fail, (Date) null));
                return;
        }
    }
}
