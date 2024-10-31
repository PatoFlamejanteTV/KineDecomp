package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.projectedit.CustomMaskEditFragment;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomMaskEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.sa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC2003sa implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomMaskEditFragment f22518a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2003sa(CustomMaskEditFragment customMaskEditFragment) {
        this.f22518a = customMaskEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomMaskEditFragment.Tool tool;
        Stroke stroke;
        Stroke stroke2;
        if (this.f22518a.isAdded()) {
            int[] iArr = C1906ha.f22361b;
            tool = this.f22518a.D;
            int i = iArr[tool.ordinal()];
            if (i == 1) {
                com.nexstreaming.kinemaster.ui.widget.r rVar = new com.nexstreaming.kinemaster.ui.widget.r(view.getContext());
                this.f22518a.I = new WeakReference(rVar);
                rVar.a(86.0f, 57.0f, 38.0f, 25.0f, 17.0f, 12.0f, 7.0f, 5.0f, 3.0f);
                stroke = this.f22518a.m;
                rVar.a(stroke.g());
                rVar.a(new C1968oa(this));
                rVar.b(this.f22518a.S().intValue() / 1280.0f);
                this.f22518a.va();
                rVar.a(view, 19);
                rVar.a(new C1977pa(this));
                return;
            }
            if (i != 2) {
                return;
            }
            com.nexstreaming.kinemaster.ui.widget.r rVar2 = new com.nexstreaming.kinemaster.ui.widget.r(view.getContext());
            this.f22518a.I = new WeakReference(rVar2);
            rVar2.a(86.0f, 57.0f, 38.0f, 25.0f, 17.0f, 12.0f, 7.0f, 5.0f, 3.0f);
            stroke2 = this.f22518a.n;
            rVar2.a(stroke2.g());
            rVar2.a(new C1986qa(this));
            rVar2.b(this.f22518a.S().intValue() / 1280.0f);
            this.f22518a.va();
            rVar2.a(view, 19);
            rVar2.a(new C1994ra(this));
        }
    }
}
