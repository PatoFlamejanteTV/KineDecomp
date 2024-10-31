package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

/* compiled from: FragmentAdviewAdmobBinding.java */
/* loaded from: classes2.dex */
public abstract class m extends ViewDataBinding {
    public final CardView A;
    protected View.OnClickListener B;
    public final ImageButton y;
    public final RelativeLayout z;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(Object obj, View view, int i, ImageButton imageButton, RelativeLayout relativeLayout, CardView cardView) {
        super(obj, view, i);
        this.y = imageButton;
        this.z = relativeLayout;
        this.A = cardView;
    }

    public abstract void a(View.OnClickListener onClickListener);
}
