package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import c.e.a.a.f;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.tf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2017tf implements f.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f22541a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22542b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2017tf(ProjectEditActivity projectEditActivity, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f22542b = projectEditActivity;
        this.f22541a = cVar;
    }

    @Override // c.e.a.a.f.e
    public void a(Bitmap bitmap) {
        this.f22542b.a(this.f22541a.getId(), this.f22541a, bitmap);
    }

    @Override // c.e.a.a.f.e
    public void a() {
        this.f22542b.a(this.f22541a.getId(), this.f22541a, (Bitmap) null);
    }
}
