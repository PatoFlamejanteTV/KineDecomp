package android.support.v4.app;

import android.support.v4.app.x;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
public class e implements x.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f55a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Fragment fragment) {
        this.b = dVar;
        this.f55a = fragment;
    }

    @Override // android.support.v4.app.x.b
    public View a() {
        return this.f55a.getView();
    }
}
