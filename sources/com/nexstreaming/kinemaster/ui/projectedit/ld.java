package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class Ld implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Md f21947a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f21948b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ld(Md md, MediaStoreItemId mediaStoreItemId) {
        this.f21947a = md;
        this.f21948b = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        Bd bd = this.f21947a.f21956a.f21972a.f21983a;
        MediaStoreItemId mediaStoreItemId = this.f21948b;
        kotlin.jvm.internal.h.a((Object) mediaStoreItemId, "itemId");
        bd.a(mediaStoreItemId, (Bitmap) null);
        Bg.a(this.f21947a.f21956a.f21972a.f21983a, null, 1, null);
    }
}
