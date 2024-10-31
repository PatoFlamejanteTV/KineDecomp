package com.nexstreaming.sdk2.nexsns;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import java.io.IOException;

/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
class w implements Task.TaskError {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IOException f4441a;
    final /* synthetic */ u b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, IOException iOException) {
        this.b = uVar;
        this.f4441a = iOException;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getMessage() {
        return this.f4441a.getMessage();
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public Exception getException() {
        return this.f4441a;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getLocalizedMessage(Context context) {
        return this.f4441a.getLocalizedMessage();
    }
}
