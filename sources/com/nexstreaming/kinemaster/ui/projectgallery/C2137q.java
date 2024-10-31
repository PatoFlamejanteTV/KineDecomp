package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.ui.a.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2137q implements ResultTask.OnResultAvailableListener<InterfaceC1821j> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f22969a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2137q(O o) {
        this.f22969a = o;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<InterfaceC1821j> resultTask, Task.Event event, InterfaceC1821j interfaceC1821j) {
        boolean z;
        Context context;
        boolean z2;
        z = this.f22969a.m;
        if (!z) {
            context = this.f22969a.f22866a;
            e.a aVar = new e.a(context);
            aVar.c(R.string.asset_download_popup_message);
            aVar.c(R.string.download_all_assets, new DialogInterfaceOnClickListenerC2129m(this, interfaceC1821j));
            aVar.a(R.string.button_cancel, new DialogInterfaceOnClickListenerC2131n(this));
            z2 = this.f22969a.f22873h;
            if (z2) {
                aVar.b(R.string.theme_open_basic_button, new DialogInterfaceOnClickListenerC2133o(this));
            }
            aVar.a(new DialogInterfaceOnCancelListenerC2135p(this));
            aVar.a().show();
            return;
        }
        this.f22969a.a(interfaceC1821j);
    }
}
