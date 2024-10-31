package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nextreaming.a.a.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class is implements e.InterfaceC0082e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f3989a;
    final /* synthetic */ KMIntentData.VisualClip b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Task d;
    final /* synthetic */ ProjectEditActivity e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public is(ProjectEditActivity projectEditActivity, MediaStoreItem mediaStoreItem, KMIntentData.VisualClip visualClip, boolean z, Task task) {
        this.e = projectEditActivity;
        this.f3989a = mediaStoreItem;
        this.b = visualClip;
        this.c = z;
        this.d = task;
    }

    @Override // com.nextreaming.a.a.e.InterfaceC0082e
    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.e.a(this.f3989a.c(), this.f3989a, bitmap, ProjectEditActivity.InsertPosition.CurrentTime, false, false, (ProjectEditActivity.c) new it(this));
        }
        if (this.c) {
            this.d.signalEvent(Task.Event.COMPLETE);
        }
    }
}
