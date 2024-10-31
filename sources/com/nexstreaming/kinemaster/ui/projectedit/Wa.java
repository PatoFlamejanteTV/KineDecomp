package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.view.View;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes2.dex */
class Wa implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f22162a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wa(HandwritingEditFragment handwritingEditFragment) {
        this.f22162a = handwritingEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HandwritingLayer Ca;
        Rect rect;
        if (this.f22162a.isAdded()) {
            Ca = this.f22162a.Ca();
            Ca.addEraseAll();
            rect = this.f22162a.R;
            rect.set(0, 0, EditorGlobal.n(), EditorGlobal.m());
            this.f22162a.Ha();
            this.f22162a.Ja();
            this.f22162a.Y = true;
        }
    }
}
