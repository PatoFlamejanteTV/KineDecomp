package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import com.nexstreaming.kinemaster.ui.share.Da;
import java.io.File;

/* compiled from: ShareIntentCheckFragment.java */
/* loaded from: classes2.dex */
class xa implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ya f23399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xa(ya yaVar) {
        this.f23399a = yaVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        AndroidMediaStoreProvider z;
        MediaStoreItemId a2 = AndroidMediaStoreProvider.a(this.f23399a.f23401b.f23402a);
        if (a2 != null) {
            za zaVar = this.f23399a.f23401b;
            Aa aa = zaVar.f23403b;
            Da.d dVar = aa.f23244a;
            File file = zaVar.f23402a;
            z = aa.f23245b.z();
            dVar.a(file, z.a(a2));
        }
    }
}
