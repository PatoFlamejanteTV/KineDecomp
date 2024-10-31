package c.d.b.d.d.b;

import java.util.LinkedHashMap;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: XmlLeaf.java */
/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: g */
    private String f3756g;

    public a(XmlSerializer xmlSerializer, String str, long j) {
        super(xmlSerializer);
        this.f3756g = str;
        this.f3761e = String.valueOf(j);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return this.f3756g;
    }

    public a(XmlSerializer xmlSerializer, String str, float f2) {
        super(xmlSerializer);
        this.f3756g = str;
        this.f3761e = String.valueOf(f2);
    }

    public a(XmlSerializer xmlSerializer, String str, double d2) {
        super(xmlSerializer);
        this.f3756g = str;
        this.f3761e = String.valueOf(d2);
    }

    public a(XmlSerializer xmlSerializer, String str, boolean z) {
        super(xmlSerializer);
        this.f3756g = str;
        this.f3761e = z ? "TRUE" : "FALSE";
    }

    public a(XmlSerializer xmlSerializer, String str, String str2) {
        super(xmlSerializer);
        this.f3756g = str;
        this.f3761e = str2;
    }

    public a(XmlSerializer xmlSerializer, String str, String str2, String str3, String str4) {
        this(xmlSerializer, str, str4);
        this.f3760d.put(str2, str3);
    }

    public a(XmlSerializer xmlSerializer, String str, LinkedHashMap<String, String> linkedHashMap, String str2) {
        this(xmlSerializer, str, str2);
        this.f3760d = linkedHashMap;
    }
}
