package com.nexstreaming.kinemaster.tracelog;

import android.content.SharedPreferences;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.TLP;
import com.nexstreaming.kinemaster.tracelog.APCManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: APCManager.java */
/* loaded from: classes.dex */
public class a implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f21277a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f21278b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ResultTask resultTask, SharedPreferences sharedPreferences) {
        this.f21277a = resultTask;
        this.f21278b = sharedPreferences;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        if (taskError instanceof APCManager.a) {
            APCManager.a aVar = (APCManager.a) taskError;
            if (aVar.b()) {
                this.f21277a.sendResult(APCManager.APCValidationResult.Valid);
                return;
            }
            Task.TaskError a2 = aVar.a();
            if (a2 != null && ((a2 instanceof TLP.a) || (a2 instanceof TLP.c))) {
                this.f21277a.sendResult(APCManager.APCValidationResult.Unknown);
                return;
            } else {
                this.f21278b.edit().remove("apc_check").apply();
                this.f21277a.sendResult(APCManager.APCValidationResult.Invalid);
                return;
            }
        }
        this.f21277a.sendResult(APCManager.APCValidationResult.Unknown);
    }
}
