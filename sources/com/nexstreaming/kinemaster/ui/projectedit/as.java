package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f3772a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(HandwritingEditFragment handwritingEditFragment) {
        this.f3772a = handwritingEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HandwritingEditFragment.Tool tool;
        Stroke stroke;
        Stroke stroke2;
        if (this.f3772a.isAdded()) {
            int[] iArr = HandwritingEditFragment.AnonymousClass1.b;
            tool = this.f3772a.v;
            switch (iArr[tool.ordinal()]) {
                case 1:
                    com.nexstreaming.kinemaster.ui.widget.n nVar = new com.nexstreaming.kinemaster.ui.widget.n(view.getContext());
                    this.f3772a.A = new WeakReference(nVar);
                    nVar.a(86.0f, 57.0f, 38.0f, 25.0f, 17.0f, 12.0f, 7.0f, 5.0f, 3.0f);
                    stroke2 = this.f3772a.d;
                    nVar.b(stroke2.f());
                    nVar.a(new at(this));
                    nVar.a(this.f3772a.x() / 1280.0f);
                    this.f3772a.P();
                    nVar.a(view, 19);
                    nVar.a(new au(this));
                    return;
                case 2:
                    com.nexstreaming.kinemaster.ui.widget.n nVar2 = new com.nexstreaming.kinemaster.ui.widget.n(view.getContext());
                    this.f3772a.A = new WeakReference(nVar2);
                    nVar2.a(86.0f, 57.0f, 38.0f, 25.0f, 17.0f, 12.0f, 7.0f, 5.0f, 3.0f);
                    stroke = this.f3772a.e;
                    nVar2.b(stroke.f());
                    nVar2.a(new av(this));
                    nVar2.a(this.f3772a.x() / 1280.0f);
                    this.f3772a.P();
                    nVar2.a(view, 19);
                    nVar2.a(new aw(this));
                    return;
                default:
                    return;
            }
        }
    }
}
