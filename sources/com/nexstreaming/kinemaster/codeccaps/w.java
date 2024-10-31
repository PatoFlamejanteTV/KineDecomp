package com.nexstreaming.kinemaster.codeccaps;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.UploadTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CapabilityReporter.java */
/* loaded from: classes.dex */
public class w implements OnSuccessListener<UploadTask.TaskSnapshot> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f20137a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Task task) {
        this.f20137a = task;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
        this.f20137a.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
    }
}
