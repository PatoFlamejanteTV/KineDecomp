package com.nextreaming.nexeditorui.newproject.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.nextreaming.nexeditorui.newproject.b.s;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes.dex */
public class g extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f4669a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f4669a = fVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        s sVar;
        s sVar2;
        s.a aVar;
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            sVar = this.f4669a.k;
            if (sVar == null) {
                f fVar = this.f4669a;
                Activity activity = this.f4669a.getActivity();
                aVar = this.f4669a.s;
                fVar.k = new s(activity, aVar);
            }
            sVar2 = this.f4669a.k;
            sVar2.a(context);
        }
    }
}
