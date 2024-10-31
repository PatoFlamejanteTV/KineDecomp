package com.nexstreaming.app.general.task;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;

/* compiled from: Task.java */
/* loaded from: classes.dex */
final class h implements Task.TaskError {
    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public Exception getException() {
        return null;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getMessage() {
        return "Timeout";
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getLocalizedMessage(Context context) {
        return getMessage();
    }
}
