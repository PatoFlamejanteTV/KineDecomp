package com.airbnb.lottie;

import com.airbnb.lottie.C0673t;
import com.airbnb.lottie.InterfaceC0671s;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableFloatValue.java */
/* renamed from: com.airbnb.lottie.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0642d extends AbstractC0675u<Float, Float> {

    /* compiled from: AnimatableFloatValue.java */
    /* renamed from: com.airbnb.lottie.d$a */
    /* loaded from: classes.dex */
    static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static C0642d a() {
            return new C0642d();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static C0642d a(JSONObject jSONObject, C0657ka c0657ka) {
            return a(jSONObject, c0657ka, true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public static C0642d a(JSONObject jSONObject, C0657ka c0657ka, boolean z) {
            C0673t.a a2 = C0673t.a(jSONObject, z ? c0657ka.b() : 1.0f, c0657ka, b.f7763a).a();
            return new C0642d(a2.f7820a, (Float) a2.f7821b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatableFloatValue.java */
    /* renamed from: com.airbnb.lottie.d$b */
    /* loaded from: classes.dex */
    public static class b implements InterfaceC0671s.a<Float> {

        /* renamed from: a, reason: collision with root package name */
        static final b f7763a = new b();

        private b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.airbnb.lottie.InterfaceC0671s.a
        public Float a(Object obj, float f2) {
            return Float.valueOf(C0647fa.a(obj) * f2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.AbstractC0675u
    public Float b() {
        return (Float) this.f7829b;
    }

    @Override // com.airbnb.lottie.InterfaceC0671s
    public AbstractC0651ha<Float> a() {
        if (!c()) {
            return new _a(this.f7829b);
        }
        return new Q(this.f7828a);
    }

    private C0642d() {
        super(Float.valueOf(0.0f));
    }

    private C0642d(List<C0649ga<Float>> list, Float f2) {
        super(list, f2);
    }
}
