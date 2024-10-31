package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class Sd implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22078a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f22079b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sd(Bd bd, MediaStoreItemId mediaStoreItemId) {
        this.f22078a = bd;
        this.f22079b = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        Bd bd = this.f22078a;
        MediaStoreItemId mediaStoreItemId = this.f22079b;
        kotlin.jvm.internal.h.a((Object) mediaStoreItemId, "itemId");
        bd.a(mediaStoreItemId, (Bitmap) null);
        Bg.a(this.f22078a, null, 1, null);
    }
}
