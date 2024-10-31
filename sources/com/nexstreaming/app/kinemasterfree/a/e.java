package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.LinearLayout;
import com.nexstreaming.kinemaster.ui.projectedit.AudioLevelMeter;

/* compiled from: AudioLevelMeterFragmentBinding.java */
/* loaded from: classes2.dex */
public abstract class e extends ViewDataBinding {
    public final AudioLevelMeter A;
    protected int B;
    protected int C;
    public final AudioLevelMeter y;
    public final LinearLayout z;

    public e(Object obj, View view, int i, AudioLevelMeter audioLevelMeter, LinearLayout linearLayout, AudioLevelMeter audioLevelMeter2) {
        super(obj, view, i);
        this.y = audioLevelMeter;
        this.z = linearLayout;
        this.A = audioLevelMeter2;
    }

    public abstract void a(int i);

    public abstract void b(int i);
}
