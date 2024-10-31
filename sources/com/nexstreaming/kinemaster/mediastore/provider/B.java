package com.nexstreaming.kinemaster.mediastore.provider;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.provider.GoogleDriveProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveProvider.java */
/* loaded from: classes.dex */
public class B implements GoogleDriveProvider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C f20950a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(C c2) {
        this.f20950a = c2;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.GoogleDriveProvider.a
    public void a(double d2) {
        this.f20950a.publishProgress(Double.valueOf(d2));
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.GoogleDriveProvider.a
    public void onCancel() {
        this.f20950a.f20952b = true;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.GoogleDriveProvider.a
    public void onFailure(Exception exc) {
        this.f20950a.f20951a = Task.makeTaskError(exc);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.GoogleDriveProvider.a
    public void onSuccess() {
        this.f20950a.f20951a = null;
    }
}
