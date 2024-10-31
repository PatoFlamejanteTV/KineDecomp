package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Path;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatTextView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: Slider.java */
/* loaded from: classes2.dex */
public class Kg extends AppCompatTextView {

    /* renamed from: c */
    int f21925c;

    /* renamed from: d */
    int f21926d;

    /* renamed from: e */
    private Shader f21927e;

    /* renamed from: f */
    private Path f21928f;

    /* renamed from: g */
    final /* synthetic */ Slider f21929g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Kg(Slider slider, Context context) {
        super(context);
        this.f21929g = slider;
        this.f21925c = getResources().getColor(R.color.slider_dark_value_tab_outside);
        this.f21926d = getResources().getColor(R.color.slider_dark_value_tab_inside);
        this.f21927e = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f21925c, this.f21926d, Shader.TileMode.MIRROR);
        this.f21928f = new Path();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0185  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r9) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.Kg.onDraw(android.graphics.Canvas):void");
    }
}
