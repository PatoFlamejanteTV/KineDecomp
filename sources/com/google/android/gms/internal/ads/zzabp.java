package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzabp extends RelativeLayout {
    private static final float[] zzdao = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable zzdap;

    public zzabp(Context context, zzabm zzabmVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        Preconditions.a(zzabmVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzdao, null, null));
        shapeDrawable.getPaint().setColor(zzabmVar.getBackgroundColor());
        setLayoutParams(layoutParams);
        com.google.android.gms.ads.internal.zzbv.g().setBackground(this, shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzabmVar.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzabmVar.getText());
            textView.setTextColor(zzabmVar.getTextColor());
            textView.setTextSize(zzabmVar.getTextSize());
            zzwu.zzpv();
            int zza = zzbat.zza(context, 4);
            zzwu.zzpv();
            textView.setPadding(zza, 0, zzbat.zza(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzabr> zzrp = zzabmVar.zzrp();
        if (zzrp != null && zzrp.size() > 1) {
            this.zzdap = new AnimationDrawable();
            Iterator<zzabr> it = zzrp.iterator();
            while (it.hasNext()) {
                try {
                    this.zzdap.addFrame((Drawable) ObjectWrapper.a(it.next().zzsa()), zzabmVar.zzrq());
                } catch (Exception e2) {
                    zzbbd.zzb("Error while getting drawable.", e2);
                }
            }
            com.google.android.gms.ads.internal.zzbv.g().setBackground(imageView, this.zzdap);
        } else if (zzrp.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.a(zzrp.get(0).zzsa()));
            } catch (Exception e3) {
                zzbbd.zzb("Error while getting drawable.", e3);
            }
        }
        addView(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzdap;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
