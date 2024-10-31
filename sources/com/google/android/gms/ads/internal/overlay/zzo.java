package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzwu;
import javax.annotation.Nullable;

@zzark
/* loaded from: classes.dex */
public final class zzo extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final ImageButton f10138a;

    /* renamed from: b, reason: collision with root package name */
    private final zzw f10139b;

    public zzo(Context context, f fVar, @Nullable zzw zzwVar) {
        super(context);
        this.f10139b = zzwVar;
        setOnClickListener(this);
        this.f10138a = new ImageButton(context);
        this.f10138a.setImageResource(R.drawable.btn_dialog);
        this.f10138a.setBackgroundColor(0);
        this.f10138a.setOnClickListener(this);
        ImageButton imageButton = this.f10138a;
        zzwu.zzpv();
        int zza = zzbat.zza(context, fVar.f10113a);
        zzwu.zzpv();
        int zza2 = zzbat.zza(context, 0);
        zzwu.zzpv();
        int zza3 = zzbat.zza(context, fVar.f10114b);
        zzwu.zzpv();
        imageButton.setPadding(zza, zza2, zza3, zzbat.zza(context, fVar.f10116d));
        this.f10138a.setContentDescription("Interstitial close button");
        zzwu.zzpv();
        zzbat.zza(context, fVar.f10117e);
        ImageButton imageButton2 = this.f10138a;
        zzwu.zzpv();
        int zza4 = zzbat.zza(context, fVar.f10117e + fVar.f10113a + fVar.f10114b);
        zzwu.zzpv();
        addView(imageButton2, new FrameLayout.LayoutParams(zza4, zzbat.zza(context, fVar.f10117e + fVar.f10116d), 17));
    }

    public final void a(boolean z) {
        if (z) {
            this.f10138a.setVisibility(8);
        } else {
            this.f10138a.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzw zzwVar = this.f10139b;
        if (zzwVar != null) {
            zzwVar.z();
        }
    }
}
