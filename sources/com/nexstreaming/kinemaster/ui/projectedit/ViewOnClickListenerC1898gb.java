package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandwritingEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.gb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC1898gb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f22348a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1898gb(HandwritingEditFragment handwritingEditFragment) {
        this.f22348a = handwritingEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HandwritingEditFragment.Tool tool;
        Stroke stroke;
        Stroke stroke2;
        if (this.f22348a.isAdded()) {
            int[] iArr = Ta.f22097b;
            tool = this.f22348a.Z;
            int i = iArr[tool.ordinal()];
            if (i == 1) {
                com.nexstreaming.kinemaster.ui.widget.r rVar = new com.nexstreaming.kinemaster.ui.widget.r(view.getContext());
                this.f22348a.ea = new WeakReference(rVar);
                rVar.a(86.0f, 57.0f, 38.0f, 25.0f, 17.0f, 12.0f, 7.0f, 5.0f, 3.0f);
                stroke = this.f22348a.H;
                rVar.a(stroke.g());
                rVar.a(new C1862cb(this));
                rVar.b(this.f22348a.S().intValue() / EditorGlobal.n());
                this.f22348a.Aa();
                rVar.a(view, 19);
                rVar.a(new C1871db(this));
                return;
            }
            if (i != 2) {
                return;
            }
            com.nexstreaming.kinemaster.ui.widget.r rVar2 = new com.nexstreaming.kinemaster.ui.widget.r(view.getContext());
            this.f22348a.ea = new WeakReference(rVar2);
            rVar2.a(86.0f, 57.0f, 38.0f, 25.0f, 17.0f, 12.0f, 7.0f, 5.0f, 3.0f);
            stroke2 = this.f22348a.I;
            rVar2.a(stroke2.g());
            rVar2.a(new C1880eb(this));
            rVar2.b(this.f22348a.S().intValue() / EditorGlobal.n());
            this.f22348a.Aa();
            rVar2.a(view, 19);
            rVar2.a(new C1889fb(this));
        }
    }
}
