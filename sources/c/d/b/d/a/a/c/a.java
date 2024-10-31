package c.d.b.d.a.a.c;

import c.d.b.d.a.a.b.b;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProjectSet.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private int f3668a;

    /* renamed from: b */
    private int f3669b;

    /* renamed from: c */
    private int f3670c;

    /* renamed from: d */
    private String f3671d;

    /* renamed from: e */
    public b f3672e;

    /* renamed from: g */
    private long f3674g;

    /* renamed from: f */
    public c.d.b.d.a.a.b.a f3673f = new c.d.b.d.a.a.b.a(2, 16, 48000);

    /* renamed from: h */
    public List<com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b> f3675h = new ArrayList();
    public List<c.d.b.d.a.a.e.b> i = new ArrayList();

    public a(int i, int i2, int i3) {
        this.f3668a = i;
        this.f3669b = i2;
        this.f3670c = i3;
        this.f3672e = new b(i, i2, i3);
    }

    public void a(com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar) {
        bVar.a(this.f3675h.size() + 1);
        this.f3675h.add(bVar);
    }

    public com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b b(int i) {
        return this.f3675h.get(i);
    }

    public int c() {
        return this.i.size() + 1;
    }

    public long d() {
        return this.f3674g;
    }

    public String e() {
        return this.f3671d;
    }

    public List<c.d.b.d.a.a.e.b> f() {
        return this.i;
    }

    public b g() {
        return this.f3672e;
    }

    public List<com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b> b() {
        return this.f3675h;
    }

    public c.d.b.d.a.a.b.a a() {
        return this.f3673f;
    }

    public void b(String str) {
        this.f3671d = str;
    }

    public void a(long j) {
        this.f3674g = j;
    }

    public int a(String str) {
        for (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar : this.f3675h) {
            if (bVar.s.equals(str)) {
                return this.f3675h.indexOf(bVar);
            }
        }
        return -1;
    }

    public c.d.b.d.a.a.e.b a(int i) {
        for (c.d.b.d.a.a.e.b bVar : this.i) {
            if (i == bVar.b()) {
                return bVar;
            }
        }
        return null;
    }

    public c.d.b.d.a.a.e.b a(int i, SourceItem sourceItem) {
        c.d.b.d.a.a.e.b a2 = a(i);
        if (a2 == null) {
            a2 = new c.d.b.d.a.a.e.b(i);
            this.i.add(a2);
        }
        if (sourceItem.i == SourceItem.ItemType.SOUNDTRACK && sourceItem.l) {
            a2.a(false);
        }
        a2.a(sourceItem);
        return a2;
    }

    public static boolean a(com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar, int i, int i2) {
        if (bVar.w) {
            long j = bVar.y.f20484c;
            if (j == 1) {
                if (i != 0) {
                    return true;
                }
            } else if (j == 2 && (i != -100 || i2 != 100)) {
                return true;
            }
        }
        return false;
    }
}
