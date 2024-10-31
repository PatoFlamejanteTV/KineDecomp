package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;

/* compiled from: DecoResourceWorker.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.a */
/* loaded from: classes2.dex */
public class C2020a implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ AbstractC2022c f22662a;

    public C2020a(AbstractC2022c abstractC2022c) {
        this.f22662a = abstractC2022c;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Log.e("DecoResourceWorker", "Fail : " + taskError);
    }
}
