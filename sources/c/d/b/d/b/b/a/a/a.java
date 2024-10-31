package c.d.b.d.b.b.a.a;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.AnimationEffect;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNAnimationEffect.java */
/* loaded from: classes.dex */
public class a extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g */
    private AnimationEffect f3729g;

    public a(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("type", this.f3729g.a().getName());
        this.f3760d.put("iid", c.d.b.d.e.a.a(this.f3729g.c()));
        if (this.f3729g.b() != 0.0f) {
            this.f3760d.put("duration", c.d.b.d.e.a.a(this.f3729g.b()));
        }
        if (this.f3729g.d() != 1.0f) {
            this.f3760d.put("speed", String.valueOf(this.f3729g.d()));
        }
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "animation";
    }

    public void a(Object obj) {
        this.f3729g = (AnimationEffect) obj;
    }
}
