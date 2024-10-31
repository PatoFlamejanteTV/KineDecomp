package com.nexstreaming.app.general.iab.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.c.a;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpLoginInfoResponse;
import com.nexstreaming.app.general.tracelog.ResponseCode;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.xiaomi.gamecenter.sdk.entry.MiAccountInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MiIABHelper.java */
/* loaded from: classes.dex */
public class l implements ResultTask.OnResultAvailableListener<CpLoginInfoResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiAccountInfo f3179a;
    final /* synthetic */ int b;
    final /* synthetic */ a.C0064a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a.C0064a c0064a, MiAccountInfo miAccountInfo, int i) {
        this.c = c0064a;
        this.f3179a = miAccountInfo;
        this.b = i;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<CpLoginInfoResponse> resultTask, Task.Event event, CpLoginInfoResponse cpLoginInfoResponse) {
        Context k;
        String f;
        String f2;
        IABHelper.e eVar;
        IABHelper.e eVar2;
        if (cpLoginInfoResponse != null) {
            switch (ResponseCode.fromValue(cpLoginInfoResponse.getResult())) {
                case SUCCESS:
                    k = a.this.k();
                    SharedPreferences.Editor putLong = PreferenceManager.getDefaultSharedPreferences(k).edit().putLong("xiaid", this.f3179a.getUid());
                    f = a.this.f(this.f3179a.getSessionId());
                    SharedPreferences.Editor putString = putLong.putString("xiasession", f);
                    f2 = a.this.f(this.f3179a.getNikename());
                    putString.putString("xianickname", f2).commit();
                    eVar = this.c.b;
                    eVar.a(true, this.b);
                    return;
                default:
                    DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_BIND_FAIL);
                    eVar2 = this.c.b;
                    eVar2.a(false, this.b);
                    Log.e("MiIABHelper", IABError.StartupError + " Xiaomi game center service failure");
                    return;
            }
        }
    }
}
