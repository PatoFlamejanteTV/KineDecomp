package com.nexstreaming.sdk2.nexsns;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import java.io.IOException;

/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
class r implements Task.TaskError {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IOException f4436a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, IOException iOException) {
        this.b = oVar;
        this.f4436a = iOException;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getMessage() {
        return this.f4436a.getMessage();
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public Exception getException() {
        return this.f4436a;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getLocalizedMessage(Context context) {
        return this.f4436a.getLocalizedMessage();
    }
}
