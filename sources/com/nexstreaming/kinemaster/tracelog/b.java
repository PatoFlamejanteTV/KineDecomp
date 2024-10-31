package com.nexstreaming.kinemaster.tracelog;

import android.content.SharedPreferences;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.tracelog.APCManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: APCManager.java */
/* loaded from: classes.dex */
public class b implements ResultTask.OnResultAvailableListener<APCManager.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f21279a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f21280b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ResultTask resultTask, SharedPreferences sharedPreferences) {
        this.f21279a = resultTask;
        this.f21280b = sharedPreferences;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<APCManager.a> resultTask, Task.Event event, APCManager.a aVar) {
        if (aVar.b()) {
            this.f21279a.sendResult(APCManager.APCValidationResult.Valid);
        } else {
            this.f21280b.edit().remove("apc_check").apply();
            this.f21279a.sendResult(APCManager.APCValidationResult.Invalid);
        }
    }
}
