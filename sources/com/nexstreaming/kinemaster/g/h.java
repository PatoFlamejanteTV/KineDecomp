package com.nexstreaming.kinemaster.g;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: Transcoder.java */
/* loaded from: classes.dex */
final class h implements Task.OnFailListener {
    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        ((i) task).g();
        KMUsage.Transcode_Result.logEvent("result", "fail", "failureReason", taskError.getMessage());
    }
}
