package com.nexstreaming.app.general.task;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.nexstreaming.app.general.task.Task;

/* compiled from: Task.java */
/* loaded from: classes.dex */
final class e implements Task.TaskError {
    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public Exception getException() {
        return null;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getMessage() {
        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getLocalizedMessage(Context context) {
        return getMessage();
    }
}
