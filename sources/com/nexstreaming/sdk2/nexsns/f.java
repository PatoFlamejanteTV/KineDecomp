package com.nexstreaming.sdk2.nexsns;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.nexstreaming.app.general.task.Task;

/* compiled from: Facebook.java */
/* loaded from: classes.dex */
class f implements FacebookCallback<Sharer.Result> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f4424a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.f4424a = dVar;
    }

    @Override // com.facebook.FacebookCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Sharer.Result result) {
        Task task;
        Task task2;
        ab.a("SNSFacebook", "shareDialog::onSuccess");
        task = this.f4424a.d;
        if (task != null) {
            task2 = this.f4424a.d;
            task2.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
        }
    }

    @Override // com.facebook.FacebookCallback
    public void onCancel() {
        Task task;
        Task task2;
        ab.a("SNSFacebook", "shareDialog::onCancel");
        task = this.f4424a.d;
        if (task != null) {
            task2 = this.f4424a.d;
            task2.signalEvent(Task.Event.CANCEL);
        }
    }

    @Override // com.facebook.FacebookCallback
    public void onError(FacebookException facebookException) {
        Task task;
        Task task2;
        ab.a("SNSFacebook", "shareDialog::onError : " + facebookException.toString());
        task = this.f4424a.d;
        if (task != null) {
            task2 = this.f4424a.d;
            task2.sendFailure(Task.makeTaskError(facebookException));
            this.f4424a.d = null;
        }
    }
}
