package com.airbnb.lottie;

import android.graphics.Color;
import android.util.Log;
import com.airbnb.lottie.C0673t;
import com.airbnb.lottie.InterfaceC0671s;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableGradientColorValue.java */
/* renamed from: com.airbnb.lottie.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0646f extends AbstractC0675u<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatableGradientColorValue.java */
    /* renamed from: com.airbnb.lottie.f$a */
    /* loaded from: classes.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public static C0646f a(JSONObject jSONObject, C0657ka c0657ka) {
            C0673t.a a2 = C0673t.a(jSONObject, 1.0f, c0657ka, new b(jSONObject.optInt("p"))).a();
            return new C0646f(a2.f7820a, (T) a2.f7821b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatableGradientColorValue.java */
    /* renamed from: com.airbnb.lottie.f$b */
    /* loaded from: classes.dex */
    public static class b implements InterfaceC0671s.a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final int f7769a;

        private b(int i) {
            this.f7769a = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.airbnb.lottie.InterfaceC0671s.a
        public T a(Object obj, float f2) {
            JSONArray jSONArray = (JSONArray) obj;
            int i = this.f7769a;
            float[] fArr = new float[i];
            int[] iArr = new int[i];
            T t = new T(fArr, iArr);
            if (jSONArray.length() != this.f7769a * 4) {
                Log.w("LOTTIE", "Unexpected gradient length: " + jSONArray.length() + ". Expected " + (this.f7769a * 4) + ". This may affect the appearance of the gradient. Make sure to save your After Effects file before exporting an animation with gradients.");
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < this.f7769a * 4; i4++) {
                int i5 = i4 / 4;
                double optDouble = jSONArray.optDouble(i4);
                int i6 = i4 % 4;
                if (i6 == 0) {
                    fArr[i5] = (float) optDouble;
                } else if (i6 == 1) {
                    i2 = (int) (optDouble * 255.0d);
                } else if (i6 == 2) {
                    i3 = (int) (optDouble * 255.0d);
                } else if (i6 == 3) {
                    iArr[i5] = Color.argb(255, i2, i3, (int) (optDouble * 255.0d));
                }
            }
            a(t, jSONArray);
            return t;
        }

        private void a(T t, JSONArray jSONArray) {
            int i = this.f7769a * 4;
            if (jSONArray.length() <= i) {
                return;
            }
            int length = (jSONArray.length() - i) / 2;
            double[] dArr = new double[length];
            double[] dArr2 = new double[length];
            int i2 = 0;
            while (i < jSONArray.length()) {
                if (i % 2 == 0) {
                    dArr[i2] = jSONArray.optDouble(i);
                } else {
                    dArr2[i2] = jSONArray.optDouble(i);
                    i2++;
                }
                i++;
            }
            for (int i3 = 0; i3 < t.c(); i3++) {
                int i4 = t.a()[i3];
                t.a()[i3] = Color.argb(a(t.b()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }

        private int a(double d2, double[] dArr, double[] dArr2) {
            double d3;
            int i = 1;
            while (true) {
                if (i < dArr.length) {
                    int i2 = i - 1;
                    double d4 = dArr[i2];
                    double d5 = dArr[i];
                    if (dArr[i] >= d2) {
                        d3 = C0676ua.a(dArr2[i2], dArr2[i], (d2 - d4) / (d5 - d4));
                        break;
                    }
                    i++;
                } else {
                    d3 = dArr2[dArr2.length - 1];
                    break;
                }
            }
            return (int) (d3 * 255.0d);
        }
    }

    private C0646f(List<C0649ga<T>> list, T t) {
        super(list, t);
    }

    @Override // com.airbnb.lottie.InterfaceC0671s
    /* renamed from: a */
    public AbstractC0651ha<T> a2() {
        if (!c()) {
            return new _a(this.f7829b);
        }
        return new U(this.f7828a);
    }
}
