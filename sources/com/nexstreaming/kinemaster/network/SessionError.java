package com.nexstreaming.kinemaster.network;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;

/* compiled from: SessionError.kt */
/* loaded from: classes.dex */
public enum SessionError implements Task.TaskError {
    AUTH_BAD_SERVER_RESPONSE,
    EXPIRATION_TOO_SHORT,
    TOKEN_EXPIRED,
    NO_TOKEN,
    SERVER_MAINTENANCE,
    APP_UPDATE_REQUIRED_BY_SERVER;

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public Exception getException() {
        return null;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getLocalizedMessage(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        return name();
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getMessage() {
        return name();
    }
}
