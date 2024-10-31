package com.nexstreaming.kinemaster.g;

import com.facebook.GraphResponse;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: Transcoder.java */
/* loaded from: classes.dex */
final class f implements Task.OnTaskEventListener {
    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        ((i) task).g();
        KMUsage.Transcode_Result.logEvent("result", GraphResponse.SUCCESS_KEY);
    }
}
