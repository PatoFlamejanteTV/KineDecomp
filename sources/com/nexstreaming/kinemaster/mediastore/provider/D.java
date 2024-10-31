package com.nexstreaming.kinemaster.mediastore.provider;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveProvider.java */
/* loaded from: classes.dex */
public class D implements Task.TaskError {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IOException f20959a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ GoogleDriveProvider f20960b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(GoogleDriveProvider googleDriveProvider, IOException iOException) {
        this.f20960b = googleDriveProvider;
        this.f20959a = iOException;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public Exception getException() {
        return this.f20959a;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getLocalizedMessage(Context context) {
        return this.f20959a.getLocalizedMessage();
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getMessage() {
        return this.f20959a.getMessage();
    }
}
