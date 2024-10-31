package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.kinemaster.ui.share.AsyncTaskC2214da;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportAndShareActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2237v implements AsyncTaskC2214da.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportedVideoDatabase f23391a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ExportAndShareActivity f23392b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2237v(ExportAndShareActivity exportAndShareActivity, ExportedVideoDatabase exportedVideoDatabase) {
        this.f23392b = exportAndShareActivity;
        this.f23391a = exportedVideoDatabase;
    }

    @Override // com.nexstreaming.kinemaster.ui.share.AsyncTaskC2214da.a
    public void a(ArrayList<V> arrayList) {
        Executor executor;
        AsyncTaskC2214da asyncTaskC2214da = new AsyncTaskC2214da(this.f23391a, this.f23392b.H().f(), new C2207a(this.f23392b));
        executor = ExportAndShareActivity.L;
        asyncTaskC2214da.executeOnExecutor(executor, 0);
    }
}
