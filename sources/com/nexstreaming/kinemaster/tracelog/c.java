package com.nexstreaming.kinemaster.tracelog;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.AuthPromocodeResponse;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: APCManager.java */
/* loaded from: classes.dex */
public final class c implements ResultTask.OnResultAvailableListener<AuthPromocodeResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f3643a;
    final /* synthetic */ Context b;
    final /* synthetic */ SharedPreferences c;
    final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ResultTask resultTask, Context context, SharedPreferences sharedPreferences, String str) {
        this.f3643a = resultTask;
        this.b = context;
        this.c = sharedPreferences;
        this.d = str;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<AuthPromocodeResponse> resultTask, Task.Event event, AuthPromocodeResponse authPromocodeResponse) {
        Log.i("APCManager", "response :  result = [" + authPromocodeResponse.getResult() + "] result = [" + authPromocodeResponse.getResponseCode() + "]");
        switch (authPromocodeResponse.getResponseCode()) {
            case ALREADYINUSE_PROMOCODE:
                this.f3643a.sendResult(new a.C0073a(true, "codeApplied", R.string.apc_applied, authPromocodeResponse.getExpDate()));
                a.b(this.b, authPromocodeResponse, this.c, this.d);
                return;
            case PROMOCODE_NONE:
                this.f3643a.sendFailure(new a.C0073a(false, "verifyFail", R.string.apc_err_verify_fail, null));
                return;
            case INVALID_PROMOCODE:
                this.f3643a.sendFailure(new a.C0073a(false, "verifyFail", R.string.apc_err_verify_fail, null));
                return;
            case EXPIRED_PROMOCODE:
                this.f3643a.sendFailure(new a.C0073a(false, "expiredCode", R.string.apc_err_expired, null));
                return;
            case PROMOCODE_ALREADY:
                this.f3643a.sendFailure(new a.C0073a(false, "alreadyUsed", R.string.apc_err_already_used, null));
                return;
            case SUCCESS:
                this.f3643a.sendResult(new a.C0073a(true, "codeApplied", R.string.apc_applied, authPromocodeResponse.getExpDate()));
                a.b(this.b, authPromocodeResponse, this.c, this.d);
                return;
            default:
                this.f3643a.sendFailure(new a.C0073a(false, "verifyFail", R.string.apc_err_verify_fail, null));
                return;
        }
    }
}
