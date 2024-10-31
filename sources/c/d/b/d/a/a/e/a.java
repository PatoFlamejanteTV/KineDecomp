package c.d.b.d.a.a.e;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;

/* compiled from: LinkInfo.java */
/* loaded from: classes.dex */
public class a implements Cloneable {

    /* renamed from: a */
    public int f3688a;

    /* renamed from: b */
    public int f3689b;

    /* renamed from: c */
    public int f3690c;

    /* renamed from: d */
    public int f3691d;

    /* renamed from: e */
    public SourceItem.MediaType f3692e;

    public a(int i, int i2, int i3, int i4, SourceItem.MediaType mediaType) {
        this.f3688a = i;
        this.f3689b = i2;
        this.f3690c = i3;
        this.f3691d = i4;
        this.f3692e = mediaType;
    }

    protected Object clone() throws CloneNotSupportedException {
        return new a(this.f3688a, this.f3689b, this.f3690c, this.f3691d, this.f3692e);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n######### link #############");
        sb.append("\n    mediatype : " + this.f3692e.getMediaType());
        sb.append("\n    clipref : " + this.f3688a);
        sb.append("\n    clipIndex : " + this.f3689b);
        sb.append("\n    trackIndex : " + this.f3690c);
        sb.append("\n    groupIndex : " + this.f3691d);
        return sb.toString();
    }
}
