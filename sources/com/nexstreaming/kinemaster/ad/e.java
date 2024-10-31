package com.nexstreaming.kinemaster.ad;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/* compiled from: AdManager.java */
/* loaded from: classes.dex */
public class e implements OnCompleteListener {

    /* renamed from: a */
    final /* synthetic */ AdManager f19950a;

    public e(AdManager adManager) {
        this.f19950a = adManager;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        boolean z;
        boolean z2;
        String str;
        String c2 = c.d.b.b.i.d().c();
        Gson create = new GsonBuilder().create();
        this.f19950a.j = c.d.b.b.i.d().i();
        z = this.f19950a.j;
        if (z) {
            this.f19950a.i = (List) create.fromJson(c2, new d(this).getType());
            z2 = this.f19950a.m;
            if (z2) {
                AdManager adManager = this.f19950a;
                str = adManager.n;
                adManager.d(str);
                this.f19950a.m = false;
                this.f19950a.n = null;
            }
        }
    }
}
