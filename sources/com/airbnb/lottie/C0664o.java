package com.airbnb.lottie;

import android.graphics.Path;
import com.airbnb.lottie.C0673t;
import com.airbnb.lottie.Oa;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AnimatableShapeValue.java */
/* renamed from: com.airbnb.lottie.o */
/* loaded from: classes.dex */
public class C0664o extends AbstractC0675u<Oa, Path> {

    /* renamed from: c */
    private final Path f7801c;

    /* compiled from: AnimatableShapeValue.java */
    /* renamed from: com.airbnb.lottie.o$a */
    /* loaded from: classes.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static C0664o a(JSONObject jSONObject, C0657ka c0657ka) {
            C0673t.a a2 = C0673t.a(jSONObject, c0657ka.b(), c0657ka, Oa.a.f7672a).a();
            return new C0664o(a2.f7820a, (Oa) a2.f7821b);
        }
    }

    /* synthetic */ C0664o(List list, Oa oa, C0662n c0662n) {
        this(list, oa);
    }

    private C0664o(List<C0649ga<Oa>> list, Oa oa) {
        super(list, oa);
        this.f7801c = new Path();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.InterfaceC0671s
    public AbstractC0677v<?, Path> a() {
        if (!c()) {
            return new _a(a((Oa) this.f7829b));
        }
        return new Sa(this.f7828a);
    }

    @Override // com.airbnb.lottie.AbstractC0675u
    public Path a(Oa oa) {
        this.f7801c.reset();
        C0676ua.a(oa, this.f7801c);
        return this.f7801c;
    }
}
