package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.C0673t;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatablePointValue.java */
/* renamed from: com.airbnb.lottie.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0656k extends AbstractC0675u<PointF, PointF> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatablePointValue.java */
    /* renamed from: com.airbnb.lottie.k$a */
    /* loaded from: classes.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public static C0656k a(JSONObject jSONObject, C0657ka c0657ka) {
            C0673t.a a2 = C0673t.a(jSONObject, c0657ka.b(), c0657ka, Ca.f7600a).a();
            return new C0656k(a2.f7820a, (PointF) a2.f7821b);
        }
    }

    private C0656k(List<C0649ga<PointF>> list, PointF pointF) {
        super(list, pointF);
    }

    @Override // com.airbnb.lottie.InterfaceC0671s
    /* renamed from: a */
    public AbstractC0651ha<PointF> a2() {
        if (!c()) {
            return new _a(this.f7829b);
        }
        return new Da(this.f7828a);
    }
}
