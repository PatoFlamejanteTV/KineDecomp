package com.airbnb.lottie;

import com.airbnb.lottie.InterfaceC0671s;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import org.json.JSONArray;

/* compiled from: ScaleXY.java */
/* loaded from: classes.dex */
public class La {

    /* renamed from: a */
    private final float f7639a;

    /* renamed from: b */
    private final float f7640b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScaleXY.java */
    /* loaded from: classes.dex */
    public static class a implements InterfaceC0671s.a<La> {

        /* renamed from: a */
        static final a f7641a = new a();

        private a() {
        }

        @Override // com.airbnb.lottie.InterfaceC0671s.a
        public La a(Object obj, float f2) {
            JSONArray jSONArray = (JSONArray) obj;
            return new La((((float) jSONArray.optDouble(0, 1.0d)) / 100.0f) * f2, (((float) jSONArray.optDouble(1, 1.0d)) / 100.0f) * f2);
        }
    }

    public La(float f2, float f3) {
        this.f7639a = f2;
        this.f7640b = f3;
    }

    public float a() {
        return this.f7639a;
    }

    public float b() {
        return this.f7640b;
    }

    public String toString() {
        return a() + FragmentC2201x.f23219a + b();
    }

    public La() {
        this(1.0f, 1.0f);
    }
}
