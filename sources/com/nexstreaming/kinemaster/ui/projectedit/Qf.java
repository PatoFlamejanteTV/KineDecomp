package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import c.e.a.a.f;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Qf implements f.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f22038a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Rf f22039b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qf(Rf rf, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f22039b = rf;
        this.f22038a = cVar;
    }

    @Override // c.e.a.a.f.e
    public void a(Bitmap bitmap) {
        this.f22039b.f22069a.a(this.f22038a.getId(), this.f22038a, bitmap, ProjectEditActivity.InsertPosition.AfterSelected, true, true);
        this.f22039b.f22069a.Da();
    }

    @Override // c.e.a.a.f.e
    public void a() {
        this.f22039b.f22069a.a(this.f22038a.getId(), this.f22038a, (Bitmap) null, ProjectEditActivity.InsertPosition.AfterSelected, true, true);
        this.f22039b.f22069a.Da();
    }
}
