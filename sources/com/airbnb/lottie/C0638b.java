package com.airbnb.lottie;

import com.airbnb.lottie.C0673t;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableColorValue.java */
/* renamed from: com.airbnb.lottie.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0638b extends AbstractC0675u<Integer, Integer> {

    /* compiled from: AnimatableColorValue.java */
    /* renamed from: com.airbnb.lottie.b$a */
    /* loaded from: classes.dex */
    static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public static C0638b a(JSONObject jSONObject, C0657ka c0657ka) {
            C0673t.a a2 = C0673t.a(jSONObject, 1.0f, c0657ka, E.f7605a).a();
            return new C0638b(a2.f7820a, (Integer) a2.f7821b);
        }
    }

    @Override // com.airbnb.lottie.AbstractC0675u
    public String toString() {
        return "AnimatableColorValue{initialValue=" + this.f7829b + '}';
    }

    private C0638b(List<C0649ga<Integer>> list, Integer num) {
        super(list, num);
    }

    @Override // com.airbnb.lottie.InterfaceC0671s
    /* renamed from: a */
    public AbstractC0651ha<Integer> a2() {
        if (!c()) {
            return new _a(this.f7829b);
        }
        return new F(this.f7828a);
    }
}
