package c.d.b.d.b.b.a.d;

import com.facebook.share.internal.MessengerShareContentUtility;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNMedia.java */
/* loaded from: classes.dex */
public class c extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g */
    private c.d.b.d.b.a.a.a f3745g;

    public c(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("id", this.f3745g.g());
        this.f3760d.put("src", this.f3745g.a());
        this.f3760d.put("type", this.f3745g.h());
        if (!this.f3745g.h().contains(MessengerShareContentUtility.MEDIA_IMAGE)) {
            this.f3760d.put("duration", c.d.b.d.e.a.a(this.f3745g.b()));
        }
        if (this.f3745g.h().contains("video")) {
            this.f3760d.put("fps", String.valueOf(this.f3745g.e()));
        }
        if (this.f3745g.h().contains("video") || this.f3745g.h().contains(MessengerShareContentUtility.MEDIA_IMAGE)) {
            this.f3760d.put("width", String.valueOf(this.f3745g.j()));
            this.f3760d.put("height", String.valueOf(this.f3745g.f()));
            if (this.f3745g.i() != -1) {
                this.f3760d.put("orientation", String.valueOf(this.f3745g.i()));
            }
        }
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "media";
    }

    public void a(Object obj) {
        this.f3745g = (c.d.b.d.b.a.a.a) obj;
    }
}
