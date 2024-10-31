package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import java.util.HashMap;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class Pd implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Qd f22014a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f22015b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pd(Qd qd, MediaStoreItemId mediaStoreItemId) {
        this.f22014a = qd;
        this.f22015b = mediaStoreItemId;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        HashMap hashMap = new HashMap();
        hashMap.put("position", this.f22014a.f22035a.f22054g ? "Layer" : "Primary");
        hashMap.put("result", "Success");
        KMEvents.EDIT_TAKE_CAMCORDER.logEvent(hashMap);
        Rd rd = this.f22014a.f22035a;
        if (rd.f22054g) {
            Bd bd = rd.f22048a;
            MediaStoreItemId mediaStoreItemId = this.f22015b;
            kotlin.jvm.internal.h.a((Object) mediaStoreItemId, "itemId");
            bd.a(mediaStoreItemId);
            return;
        }
        Bd bd2 = rd.f22048a;
        MediaStoreItemId mediaStoreItemId2 = this.f22015b;
        kotlin.jvm.internal.h.a((Object) mediaStoreItemId2, "itemId");
        bd2.a(mediaStoreItemId2, (Bitmap) null);
        Bg.a(this.f22014a.f22035a.f22048a, null, 1, null);
    }
}
