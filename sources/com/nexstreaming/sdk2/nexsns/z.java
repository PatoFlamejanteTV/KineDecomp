package com.nexstreaming.sdk2.nexsns;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;

/* compiled from: GooglePlus.java */
/* loaded from: classes.dex */
class z implements Task.TaskError {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f4445a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.f4445a = xVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getMessage() {
        return "Uri or MimeType is null";
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public Exception getException() {
        return null;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getLocalizedMessage(Context context) {
        return null;
    }
}
