package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class Hd implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Id f21891a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f21892b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hd(Id id, MediaStoreItemId mediaStoreItemId) {
        this.f21891a = id;
        this.f21892b = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        Bd bd = this.f21891a.f21901a.f21912a.f21920a;
        MediaStoreItemId mediaStoreItemId = this.f21892b;
        kotlin.jvm.internal.h.a((Object) mediaStoreItemId, "itemId");
        bd.a(mediaStoreItemId, (Bitmap) null);
        Bg.a(this.f21891a.f21901a.f21912a.f21920a, null, 1, null);
    }
}
