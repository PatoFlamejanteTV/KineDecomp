package com.airbnb.lottie;

import com.airbnb.lottie.C0673t;
import com.airbnb.lottie.La;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableScaleValue.java */
/* renamed from: com.airbnb.lottie.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0660m extends AbstractC0675u<La, La> {
    private C0660m() {
        super(new La());
    }

    @Override // com.airbnb.lottie.InterfaceC0671s
    /* renamed from: a */
    public AbstractC0651ha<La> a2() {
        if (!c()) {
            return new _a(this.f7829b);
        }
        return new Ka(this.f7828a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0660m(List<C0649ga<La>> list, La la) {
        super(list, la);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatableScaleValue.java */
    /* renamed from: com.airbnb.lottie.m$a */
    /* loaded from: classes.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public static C0660m a(JSONObject jSONObject, C0657ka c0657ka) {
            C0673t.a a2 = C0673t.a(jSONObject, 1.0f, c0657ka, La.a.f7641a).a();
            return new C0660m(a2.f7820a, (La) a2.f7821b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static C0660m a() {
            return new C0660m();
        }
    }
}
