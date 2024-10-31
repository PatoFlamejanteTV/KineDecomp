package com.nexstreaming.kinemaster.g;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: Transcoder.java */
/* loaded from: classes.dex */
final class g implements Task.OnTaskEventListener {
    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        ((i) task).g();
        KMUsage.Transcode_Result.logEvent("result", "cancel");
    }
}
