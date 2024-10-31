package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.nexstreaming.kinemaster.ui.projectedit.AudioLevelMeter;

/* compiled from: CamcorderMainActivityBinding.java */
/* loaded from: classes2.dex */
public abstract class g extends ViewDataBinding {
    public final ImageButton A;
    public final View B;
    public final FrameLayout C;
    public final TextView D;
    public final LinearLayout E;
    public final AudioLevelMeter F;
    public final LinearLayout G;
    public final ImageView H;
    public final TextView I;
    public final LinearLayout J;
    public final ListView K;
    public final AudioLevelMeter L;
    public final ImageView M;
    public final View N;
    protected int O;
    protected int P;
    public final ImageButton y;
    public final ImageButton z;

    public g(Object obj, View view, int i, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, View view2, FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, AudioLevelMeter audioLevelMeter, LinearLayout linearLayout2, ImageView imageView, TextView textView2, LinearLayout linearLayout3, ListView listView, AudioLevelMeter audioLevelMeter2, ImageView imageView2, View view3) {
        super(obj, view, i);
        this.y = imageButton;
        this.z = imageButton2;
        this.A = imageButton3;
        this.B = view2;
        this.C = frameLayout;
        this.D = textView;
        this.E = linearLayout;
        this.F = audioLevelMeter;
        this.G = linearLayout2;
        this.H = imageView;
        this.I = textView2;
        this.J = linearLayout3;
        this.K = listView;
        this.L = audioLevelMeter2;
        this.M = imageView2;
        this.N = view3;
    }

    public abstract void a(int i);

    public abstract void b(int i);
}
