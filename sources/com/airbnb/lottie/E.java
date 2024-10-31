package com.airbnb.lottie;

import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import com.airbnb.lottie.InterfaceC0671s;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorFactory.java */
/* loaded from: classes.dex */
public class E implements InterfaceC0671s.a<Integer> {

    /* renamed from: a */
    static final E f7605a = new E();

    E() {
    }

    @Override // com.airbnb.lottie.InterfaceC0671s.a
    public Integer a(Object obj, float f2) {
        JSONArray jSONArray = (JSONArray) obj;
        if (jSONArray.length() == 4) {
            boolean z = true;
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.optDouble(i) > 1.0d) {
                    z = false;
                }
            }
            float f3 = z ? 255.0f : 1.0f;
            double optDouble = jSONArray.optDouble(3);
            double d2 = f3;
            Double.isNaN(d2);
            int i2 = (int) (optDouble * d2);
            double optDouble2 = jSONArray.optDouble(0);
            Double.isNaN(d2);
            int i3 = (int) (optDouble2 * d2);
            double optDouble3 = jSONArray.optDouble(1);
            Double.isNaN(d2);
            int i4 = (int) (optDouble3 * d2);
            double optDouble4 = jSONArray.optDouble(2);
            Double.isNaN(d2);
            return Integer.valueOf(Color.argb(i2, i3, i4, (int) (optDouble4 * d2)));
        }
        return Integer.valueOf(ViewCompat.MEASURED_STATE_MASK);
    }
}
