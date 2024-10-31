package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionSplitFragment.java */
/* loaded from: classes.dex */
public class gu implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f3938a;
    final /* synthetic */ gr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gu(gr grVar, MediaStoreItem mediaStoreItem) {
        this.b = grVar;
        this.f3938a = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        this.b.b.o().a(this.b.b.m(), this.b.f3935a, this.b.b.p()).onComplete(new gx(this, bitmap)).onFailure(new gv(this));
    }
}
