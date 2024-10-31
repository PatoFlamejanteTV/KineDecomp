package com.nexstreaming.kinemaster.ui.settings;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.util.Log;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsActivity.java */
/* loaded from: classes2.dex */
public class bb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f23122a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f23123b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(SettingsActivity settingsActivity, Intent intent) {
        this.f23123b = settingsActivity;
        this.f23122a = intent;
    }

    public /* synthetic */ void a(com.nexstreaming.app.general.iab.b.c cVar) throws Exception {
        this.f23123b.O();
    }

    @Override // java.lang.Runnable
    public void run() {
        Toolbar toolbar;
        io.reactivex.disposables.a aVar;
        List<String> pathSegments = this.f23122a.getData().getPathSegments();
        if (pathSegments == null || pathSegments.size() <= 0) {
            return;
        }
        String str = pathSegments.get(pathSegments.size() - 1);
        char c2 = 65535;
        if (str.hashCode() == -1127535031 && str.equals("kmprch")) {
            c2 = 0;
        }
        if (c2 != 0) {
            return;
        }
        if (this.f23123b.y() == null || this.f23123b.y().n() == null) {
            toolbar = this.f23123b.H;
            toolbar.a(this.f23123b.getString(R.string.pref_information_about_account), 1);
            FragmentTransaction beginTransaction = this.f23123b.getFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.container, FragmentC2201x.a(this.f23123b.y()), FragmentC2201x.f23219a);
            beginTransaction.addToBackStack(FragmentC2201x.f23219a);
            beginTransaction.commitAllowingStateLoss();
            return;
        }
        aVar = this.f23123b.I;
        aVar.b(this.f23123b.y().n().t().b(io.reactivex.g.b.b()).a(io.reactivex.a.b.b.a()).a(new io.reactivex.c.e() { // from class: com.nexstreaming.kinemaster.ui.settings.h
            @Override // io.reactivex.c.e
            public final void accept(Object obj) {
                bb.this.a((com.nexstreaming.app.general.iab.b.c) obj);
            }
        }, new io.reactivex.c.e() { // from class: com.nexstreaming.kinemaster.ui.settings.g
            @Override // io.reactivex.c.e
            public final void accept(Object obj) {
                Log.d("SettingsActivity", "checkIntent onError: " + ((Throwable) obj).getMessage());
            }
        }));
    }
}
