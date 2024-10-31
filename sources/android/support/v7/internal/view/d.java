package android.support.v7.internal.view;

import android.support.v4.g.ad;
import android.support.v4.g.ae;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public class d extends ae {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f125a;
    private boolean b = false;
    private int c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f125a = cVar;
    }

    @Override // android.support.v4.g.ae, android.support.v4.g.ad
    public void a(View view) {
        ad adVar;
        ad adVar2;
        if (!this.b) {
            this.b = true;
            adVar = this.f125a.d;
            if (adVar != null) {
                adVar2 = this.f125a.d;
                adVar2.a(null);
            }
        }
    }

    void a() {
        this.c = 0;
        this.b = false;
        this.f125a.c();
    }

    @Override // android.support.v4.g.ae, android.support.v4.g.ad
    public void b(View view) {
        ArrayList arrayList;
        ad adVar;
        ad adVar2;
        int i = this.c + 1;
        this.c = i;
        arrayList = this.f125a.f124a;
        if (i == arrayList.size()) {
            adVar = this.f125a.d;
            if (adVar != null) {
                adVar2 = this.f125a.d;
                adVar2.b(null);
            }
            a();
        }
    }
}
