package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import c.e.a.a.f;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Kf implements f.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f21923a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Lf f21924b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Kf(Lf lf, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f21924b = lf;
        this.f21923a = cVar;
    }

    @Override // c.e.a.a.f.e
    public void a(Bitmap bitmap) {
        this.f21924b.f21950a.a(this.f21923a.getId(), this.f21923a, bitmap, ProjectEditActivity.InsertPosition.BeforeSelected, true, true);
        this.f21924b.f21950a.Da();
    }

    @Override // c.e.a.a.f.e
    public void a() {
        this.f21924b.f21950a.a(this.f21923a.getId(), this.f21923a, (Bitmap) null, ProjectEditActivity.InsertPosition.BeforeSelected, true, true);
        this.f21924b.f21950a.Da();
    }
}
