package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;

/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
public class bb implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.a f4539a;
    final /* synthetic */ ba b;

    public bb(ba baVar, com.nexstreaming.kinemaster.ui.a.a aVar) {
        this.b = baVar;
        this.f4539a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4539a.dismiss();
        this.b.startActivityForResult(FullScreenInputActivity.a(this.b.D()).a(R.string.sub_use_promotion_code).a(true).a(), R.id.fullscreen_promocode_text_input);
    }
}
