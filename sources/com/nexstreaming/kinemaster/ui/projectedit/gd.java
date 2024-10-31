package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class Gd implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f21874a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f21875b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gd(Bd bd, MediaStoreItemId mediaStoreItemId) {
        this.f21874a = bd;
        this.f21875b = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        Bd bd = this.f21874a;
        MediaStoreItemId mediaStoreItemId = this.f21875b;
        kotlin.jvm.internal.h.a((Object) mediaStoreItemId, "itemId");
        bd.a(mediaStoreItemId, (Bitmap) null);
        Bg.a(this.f21874a, null, 1, null);
    }
}
