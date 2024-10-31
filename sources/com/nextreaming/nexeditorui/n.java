package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.APCManager;
import com.nexstreaming.kinemaster.ui.a.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.kt */
/* loaded from: classes.dex */
public final class N implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f24069a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f24070b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f24071c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(I i, com.nexstreaming.kinemaster.ui.a.e eVar, boolean z) {
        this.f24069a = i;
        this.f24070b = eVar;
        this.f24071c = z;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        String localizedMessage;
        this.f24070b.dismiss();
        if (taskError instanceof APCManager.a) {
            localizedMessage = ((APCManager.a) taskError).a(this.f24069a.u(), this.f24071c);
            kotlin.jvm.internal.h.a((Object) localizedMessage, "failureReason.getLocaliz…(activity, isLicenseType)");
        } else {
            localizedMessage = taskError.getLocalizedMessage(this.f24069a.u());
            kotlin.jvm.internal.h.a((Object) localizedMessage, "failureReason.getLocalizedMessage(activity)");
        }
        e.a aVar = new e.a(this.f24069a.u());
        aVar.a(localizedMessage);
        aVar.c(R.string.button_ok, M.f24066a);
        aVar.a().show();
    }
}
