package com.airbnb.lottie;

import com.airbnb.lottie.C0673t;
import com.airbnb.lottie.InterfaceC0671s;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableIntegerValue.java */
/* renamed from: com.airbnb.lottie.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0650h extends AbstractC0675u<Integer, Integer> {

    /* compiled from: AnimatableIntegerValue.java */
    /* renamed from: com.airbnb.lottie.h$a */
    /* loaded from: classes.dex */
    static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static C0650h a() {
            return new C0650h();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public static C0650h a(JSONObject jSONObject, C0657ka c0657ka) {
            C0673t.a a2 = C0673t.a(jSONObject, 1.0f, c0657ka, b.f7777a).a();
            return new C0650h(a2.f7820a, (Integer) a2.f7821b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.AbstractC0675u
    public Integer b() {
        return (Integer) this.f7829b;
    }

    /* compiled from: AnimatableIntegerValue.java */
    /* renamed from: com.airbnb.lottie.h$b */
    /* loaded from: classes.dex */
    private static class b implements InterfaceC0671s.a<Integer> {

        /* renamed from: a, reason: collision with root package name */
        private static final b f7777a = new b();

        private b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.airbnb.lottie.InterfaceC0671s.a
        public Integer a(Object obj, float f2) {
            return Integer.valueOf(Math.round(C0647fa.a(obj) * f2));
        }
    }

    private C0650h() {
        super(100);
    }

    @Override // com.airbnb.lottie.InterfaceC0671s
    /* renamed from: a */
    public AbstractC0651ha<Integer> a2() {
        if (!c()) {
            return new _a(this.f7829b);
        }
        return new C0645ea(this.f7828a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0650h(List<C0649ga<Integer>> list, Integer num) {
        super(list, num);
    }
}
