package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.kt */
/* loaded from: classes.dex */
public final class S implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f24168a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f24169b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(I i, com.nexstreaming.kinemaster.ui.a.e eVar) {
        this.f24168a = i;
        this.f24169b = eVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f24169b.dismiss();
        I i = this.f24168a;
        FullScreenInputActivity.a a2 = FullScreenInputActivity.a(i.u());
        a2.a(R.string.sub_use_promotion_code);
        a2.b(true);
        i.startActivityForResult(a2.a(), 8216);
    }
}
