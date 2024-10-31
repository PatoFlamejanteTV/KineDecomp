package c.d.b.d.d.b;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: XmlNode.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a */
    private static final String f3757a = "b";

    /* renamed from: b */
    protected String f3758b;

    /* renamed from: c */
    protected XmlSerializer f3759c;

    /* renamed from: e */
    protected String f3761e;

    /* renamed from: f */
    protected List<b> f3762f = new ArrayList();

    /* renamed from: d */
    protected LinkedHashMap<String, String> f3760d = new LinkedHashMap<>();

    public b(XmlSerializer xmlSerializer) {
        this.f3759c = xmlSerializer;
    }

    public abstract void a();

    public abstract void b();

    public abstract String c();

    public void d() throws IOException {
        this.f3758b = c();
        this.f3759c.startTag("", this.f3758b);
        Log.d(f3757a, "<" + this.f3758b + " ");
        a();
        LinkedHashMap<String, String> linkedHashMap = this.f3760d;
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String str : this.f3760d.keySet()) {
                if (str != null && this.f3760d.get(str) != null) {
                    this.f3759c.attribute("", str, this.f3760d.get(str));
                }
                Log.d(f3757a, str + "=" + this.f3760d.get(str) + " ");
            }
        }
        Log.d(f3757a, ">");
        b();
        if (this.f3762f.size() > 0) {
            Iterator<b> it = this.f3762f.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
        } else {
            String str2 = this.f3761e;
            if (str2 != null) {
                this.f3759c.text(str2);
            }
        }
        this.f3759c.endTag("", this.f3758b);
        Log.d(f3757a, "</" + this.f3758b + ">");
    }
}
