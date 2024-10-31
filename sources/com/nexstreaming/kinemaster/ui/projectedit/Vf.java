package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Vf extends Animation {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f22155a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f22156b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f22157c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f22158d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22159e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Vf(ProjectEditActivity projectEditActivity, int i, int i2, int i3, int i4) {
        this.f22159e = projectEditActivity;
        this.f22155a = i;
        this.f22156b = i2;
        this.f22157c = i3;
        this.f22158d = i4;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f2, Transformation transformation) {
        InterfaceC2025f interfaceC2025f;
        InterfaceC2025f interfaceC2025f2;
        InterfaceC2025f interfaceC2025f3;
        interfaceC2025f = this.f22159e.T;
        interfaceC2025f.getLayoutParams().height = (int) (this.f22155a + ((this.f22156b - r0) * f2));
        interfaceC2025f2 = this.f22159e.T;
        interfaceC2025f2.getLayoutParams().width = (int) (this.f22157c + ((this.f22158d - r0) * f2));
        interfaceC2025f3 = this.f22159e.T;
        interfaceC2025f3.requestLayout();
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }
}
