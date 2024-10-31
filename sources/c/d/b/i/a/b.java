package c.d.b.i.a;

import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: BasicTemplate.java */
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: f */
    private static c.d.b.i.a f3812f;

    private b() {
        super("com.nexstreaming.kinemaster.basic", R.string.kedl_theme_basic, R.drawable.n2_theme_thumb_none, R.string.template_openingtitle_hint, R.string.template_midtitle_hint, R.string.template_closingtitle_hint);
    }

    public static c.d.b.i.a c() {
        if (f3812f == null) {
            f3812f = new b();
        }
        return f3812f;
    }

    @Override // c.d.b.i.a
    public String a(int i, int i2) {
        return "com.nexstreaming.kinemaster.builtin.transition.crossfade";
    }

    @Override // c.d.b.i.a
    public int b(int i, int i2) {
        return SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE;
    }

    @Override // c.d.b.i.a
    public String c(int i, int i2) {
        return null;
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
