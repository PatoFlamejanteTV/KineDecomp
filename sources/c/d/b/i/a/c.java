package c.d.b.i.a;

import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: OnStageTemplate.java */
/* loaded from: classes.dex */
public class c extends a {

    /* renamed from: f */
    private static c.d.b.i.a f3813f;

    private c() {
        super("com.nexstreaming.kinemaster.onstage", R.string.kedl_theme_onstage, R.drawable.n2_theme_thumb_onstage, R.string.template_openingtitle_hint, R.string.template_midtitle_hint, R.string.template_closingtitle_hint);
    }

    public static c.d.b.i.a c() {
        if (f3813f == null) {
            f3813f = new c();
        }
        return f3813f;
    }

    @Override // c.d.b.i.a
    public String a(int i, int i2) {
        return "com.nexstreaming.kinemaster.onstage.transition";
    }

    @Override // c.d.b.i.a
    public int b(int i, int i2) {
        return SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE;
    }

    @Override // c.d.b.i.a
    public String c(int i, int i2) {
        return i == 0 ? "com.nexstreaming.kinemaster.onstage.opening" : i + 1 == i2 ? "com.nexstreaming.kinemaster.onstage.ending" : i == 1 ? "com.nexstreaming.kinemaster.onstage.middle" : "com.nexstreaming.kinemaster.onstage.accent";
    }

    @Override // c.d.b.i.a
    public int d(int i, int i2) {
        if (i == 0) {
            return 0;
        }
        if (i + 1 == i2) {
            return 2;
        }
        return i == 1 ? 1 : -1;
    }
}
