package com.nexstreaming.kinemaster.ui.mediabrowser;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: MediaBrowserPresenter.kt */
/* loaded from: classes.dex */
final class Q<TResult> implements OnCompleteListener<GoogleSignInAccount> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f21665a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(S s) {
        this.f21665a = s;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<GoogleSignInAccount> task) {
        InterfaceC1828f interfaceC1828f;
        kotlin.jvm.internal.h.b(task, "task");
        interfaceC1828f = this.f21665a.f21668c;
        if (interfaceC1828f != null) {
            interfaceC1828f.h();
        }
    }
}
