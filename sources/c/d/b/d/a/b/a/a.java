package c.d.b.d.a.b.a;

import c.d.b.d.d.b.b;
import c.d.b.d.d.b.d;
import com.facebook.internal.ServerProtocol;
import com.nexstreaming.kinemaster.integration.fcpxml.xml.node.OperationMode;
import com.nexstreaming.kinemaster.integration.fcpxml.xml.node.v;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNXmeml.java */
/* loaded from: classes.dex */
public class a extends b implements d {

    /* renamed from: g */
    c.d.b.d.a.a.c.a f3699g;

    public a(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "4");
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        v vVar = new v(this.f3759c);
        vVar.a(this.f3699g);
        vVar.a(OperationMode.PROJECT);
        this.f3762f.add(vVar);
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "xmeml";
    }

    public void a(Object obj) {
        this.f3699g = (c.d.b.d.a.a.c.a) obj;
    }
}
