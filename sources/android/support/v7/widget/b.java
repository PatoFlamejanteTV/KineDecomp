package android.support.v7.widget;

import android.support.v7.widget.a;
import android.support.v7.widget.f;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActionMenuPresenter.java */
/* loaded from: classes.dex */
public class b extends f.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f212a;
    final /* synthetic */ a.d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a.d dVar, View view, a aVar) {
        super(view);
        this.b = dVar;
        this.f212a = aVar;
    }

    @Override // android.support.v7.widget.f.b
    public f a() {
        a.e eVar;
        a.e eVar2;
        eVar = a.this.v;
        if (eVar != null) {
            eVar2 = a.this.v;
            return eVar2.c();
        }
        return null;
    }

    @Override // android.support.v7.widget.f.b
    public boolean b() {
        a.this.c();
        return true;
    }

    @Override // android.support.v7.widget.f.b
    public boolean c() {
        a.c cVar;
        cVar = a.this.x;
        if (cVar != null) {
            return false;
        }
        a.this.d();
        return true;
    }
}
