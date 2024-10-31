package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.model.MessageType;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class InflaterConfigModule {

    /* renamed from: a */
    private int f17651a = 327938;

    /* renamed from: b */
    private int f17652b = 65824;

    public static String a(MessageType messageType, int i) {
        if (i == 1) {
            int i2 = a.f17676a[messageType.ordinal()];
            if (i2 == 1) {
                return "MODAL_PORTRAIT";
            }
            if (i2 == 2) {
                return "IMAGE_ONLY_PORTRAIT";
            }
            if (i2 != 3) {
                return null;
            }
            return "BANNER_PORTRAIT";
        }
        int i3 = a.f17676a[messageType.ordinal()];
        if (i3 == 1) {
            return "MODAL_LANDSCAPE";
        }
        if (i3 == 2) {
            return "IMAGE_ONLY_LANDSCAPE";
        }
        if (i3 != 3) {
            return null;
        }
        return "BANNER_LANDSCAPE";
    }

    public InAppMessageLayoutConfig b(DisplayMetrics displayMetrics) {
        InAppMessageLayoutConfig.Builder d2 = InAppMessageLayoutConfig.d();
        Float valueOf = Float.valueOf(0.3f);
        return d2.c(valueOf).d(valueOf).a(Integer.valueOf((int) (displayMetrics.heightPixels * 0.5f))).b(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f))).c((Integer) 48).d(Integer.valueOf(this.f17652b)).f(-1).e(-2).c((Boolean) true).a((Boolean) true).b((Boolean) true).a();
    }

    public InAppMessageLayoutConfig c(DisplayMetrics displayMetrics) {
        InAppMessageLayoutConfig.Builder b2 = InAppMessageLayoutConfig.d().a(Integer.valueOf((int) (displayMetrics.heightPixels * 0.9f))).b(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f)));
        Float valueOf = Float.valueOf(0.8f);
        return b2.d(valueOf).c(valueOf).c((Integer) 17).d(Integer.valueOf(this.f17651a)).f(-2).e(-2).c((Boolean) false).a((Boolean) false).b((Boolean) false).a();
    }

    public InAppMessageLayoutConfig d(DisplayMetrics displayMetrics) {
        InAppMessageLayoutConfig.Builder d2 = InAppMessageLayoutConfig.d();
        double d3 = displayMetrics.heightPixels;
        Double.isNaN(d3);
        InAppMessageLayoutConfig.Builder c2 = d2.a(Integer.valueOf((int) (d3 * 0.8d))).b(Integer.valueOf(displayMetrics.widthPixels)).c(Float.valueOf(1.0f));
        Float valueOf = Float.valueOf(0.4f);
        return c2.d(valueOf).a(Float.valueOf(0.6f)).b(valueOf).c((Integer) 17).d(Integer.valueOf(this.f17651a)).f(-1).e(-1).c((Boolean) false).a((Boolean) false).b((Boolean) false).a();
    }

    public InAppMessageLayoutConfig e(DisplayMetrics displayMetrics) {
        InAppMessageLayoutConfig.Builder d2 = InAppMessageLayoutConfig.d();
        double d3 = displayMetrics.heightPixels;
        Double.isNaN(d3);
        InAppMessageLayoutConfig.Builder a2 = d2.a(Integer.valueOf((int) (d3 * 0.8d))).b(Integer.valueOf((int) (displayMetrics.widthPixels * 0.7f))).c(Float.valueOf(0.6f)).a(Float.valueOf(0.1f));
        Float valueOf = Float.valueOf(0.9f);
        return a2.d(valueOf).b(valueOf).c((Integer) 17).d(Integer.valueOf(this.f17651a)).f(-1).e(-2).c((Boolean) false).a((Boolean) false).b((Boolean) false).a();
    }

    public InAppMessageLayoutConfig f(DisplayMetrics displayMetrics) {
        InAppMessageLayoutConfig.Builder b2 = InAppMessageLayoutConfig.d().a(Integer.valueOf((int) (displayMetrics.heightPixels * 0.9f))).b(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f)));
        Float valueOf = Float.valueOf(0.8f);
        return b2.d(valueOf).c(valueOf).c((Integer) 17).d(Integer.valueOf(this.f17651a)).f(-2).e(-2).c((Boolean) false).a((Boolean) false).b((Boolean) false).a();
    }

    public DisplayMetrics a(Application application) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) application.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public InAppMessageLayoutConfig a(DisplayMetrics displayMetrics) {
        InAppMessageLayoutConfig.Builder d2 = InAppMessageLayoutConfig.d();
        Float valueOf = Float.valueOf(0.3f);
        return d2.c(valueOf).d(valueOf).a(Integer.valueOf((int) (displayMetrics.heightPixels * 0.5f))).b(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f))).c((Integer) 48).d(Integer.valueOf(this.f17652b)).f(-1).e(-2).c((Boolean) true).a((Boolean) true).b((Boolean) true).a();
    }
}
