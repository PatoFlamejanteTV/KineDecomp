package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class zzm extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final ImageButton f606a;
    private final zzo b;

    public zzm(Context context, int i, zzo zzoVar) {
        super(context);
        this.b = zzoVar;
        setOnClickListener(this);
        this.f606a = new ImageButton(context);
        this.f606a.setImageResource(R.drawable.btn_dialog);
        this.f606a.setBackgroundColor(0);
        this.f606a.setOnClickListener(this);
        this.f606a.setPadding(0, 0, 0, 0);
        this.f606a.setContentDescription("Interstitial close button");
        int a2 = com.google.android.gms.ads.internal.client.zzl.a().a(context, i);
        addView(this.f606a, new FrameLayout.LayoutParams(a2, a2, 17));
    }

    public void a(boolean z, boolean z2) {
        if (!z2) {
            this.f606a.setVisibility(0);
        } else if (z) {
            this.f606a.setVisibility(4);
        } else {
            this.f606a.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null) {
            this.b.c();
        }
    }
}
