package android.support.v7.internal.widget;

import android.support.v7.internal.widget.SpinnerCompat;
import android.support.v7.widget.f;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpinnerCompat.java */
/* loaded from: classes.dex */
public class u extends f.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SpinnerCompat.c f191a;
    final /* synthetic */ SpinnerCompat b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(SpinnerCompat spinnerCompat, View view, SpinnerCompat.c cVar) {
        super(view);
        this.b = spinnerCompat;
        this.f191a = cVar;
    }

    @Override // android.support.v7.widget.f.b
    public android.support.v7.widget.f a() {
        return this.f191a;
    }

    @Override // android.support.v7.widget.f.b
    public boolean b() {
        SpinnerCompat.d dVar;
        SpinnerCompat.d dVar2;
        dVar = this.b.G;
        if (!dVar.b()) {
            dVar2 = this.b.G;
            dVar2.c();
            return true;
        }
        return true;
    }
}
