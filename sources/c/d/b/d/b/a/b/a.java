package c.d.b.d.b.a.b;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.c;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.LayerItem;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProjectSet.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private int f3715a;

    /* renamed from: b */
    private int f3716b;

    /* renamed from: c */
    private int f3717c;

    /* renamed from: d */
    private c f3718d;

    /* renamed from: f */
    private c.d.b.d.b.a.d.a f3720f;
    private String i;

    /* renamed from: e */
    private ArrayList<c.d.b.d.b.a.a.a> f3719e = new ArrayList<>();

    /* renamed from: g */
    private ArrayList<LayerItem> f3721g = new ArrayList<>();

    /* renamed from: h */
    private ArrayList<com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a> f3722h = new ArrayList<>();

    public a(int i, int i2, int i3) {
        this.f3715a = i;
        this.f3716b = i2;
        this.f3717c = i3;
    }

    public void a(c.d.b.d.b.a.a.a aVar) {
        if (aVar == null || this.f3719e.contains(aVar)) {
            return;
        }
        this.f3719e.add(aVar);
    }

    public int b() {
        return this.f3717c;
    }

    public int c() {
        return this.f3716b;
    }

    public ArrayList<LayerItem> d() {
        return this.f3721g;
    }

    public ArrayList<c.d.b.d.b.a.a.a> e() {
        return this.f3719e;
    }

    public c f() {
        return this.f3718d;
    }

    public String g() {
        return this.i;
    }

    public c.d.b.d.b.a.d.a h() {
        return this.f3720f;
    }

    public int i() {
        return this.f3715a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nProjectSet ########################################## ");
        sb.append("\n\t width    : " + this.f3715a);
        sb.append("\n\t height   : " + this.f3716b);
        sb.append("\n\t fps      : " + this.f3717c);
        sb.append("\n\t medias   : " + this.f3719e.size());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n\t items in Sequence : ");
        c.d.b.d.b.a.d.a aVar = this.f3720f;
        sb2.append(aVar != null ? Integer.valueOf(aVar.a()) : "null");
        sb.append(sb2.toString());
        sb.append("\n\t layers   : " + this.f3721g.size());
        sb.append("\n\t audios   : " + this.f3722h.size());
        sb.append("\n########################################################\n");
        sb.append(this.f3720f);
        Iterator<LayerItem> it = this.f3721g.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        Iterator<com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a> it2 = this.f3722h.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
        }
        return sb.toString();
    }

    public void a(c.d.b.d.b.a.d.a aVar) {
        if (aVar != null) {
            this.f3720f = aVar;
        }
    }

    public void a(LayerItem layerItem) {
        this.f3721g.add(layerItem);
    }

    public ArrayList<com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a> a() {
        return this.f3722h;
    }

    public void a(com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a aVar) {
        this.f3722h.add(aVar);
    }

    public void a(String str) {
        this.i = str;
    }
}
