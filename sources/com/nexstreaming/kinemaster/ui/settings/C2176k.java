package com.nexstreaming.kinemaster.ui.settings;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: AccountInfoV4Fragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2176k implements ResultTask.OnResultAvailableListener<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FragmentC2201x f23159a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2176k(FragmentC2201x fragmentC2201x) {
        this.f23159a = fragmentC2201x;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Boolean> resultTask, Task.Event event, Boolean bool) {
        this.f23159a.F.a(true);
        this.f23159a.F.B();
    }
}
