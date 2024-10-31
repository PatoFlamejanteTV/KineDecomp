package c.d.b.d.a.a.e;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrackInfo.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private int f3693a;

    /* renamed from: b */
    public List<SourceItem> f3694b = new ArrayList();

    /* renamed from: c */
    private boolean f3695c = true;

    /* renamed from: d */
    private boolean f3696d = false;

    public b(int i) {
        this.f3693a = i;
    }

    public List<SourceItem> a() {
        return this.f3694b;
    }

    public int b() {
        return this.f3693a;
    }

    public boolean c() {
        for (SourceItem sourceItem : a()) {
            SourceItem.ItemType itemType = sourceItem.i;
            if (itemType == SourceItem.ItemType.SOUNDTRACK) {
                return true;
            }
            if (itemType == SourceItem.ItemType.VISUAL && ((com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) sourceItem).q.w) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        for (SourceItem sourceItem : this.f3694b) {
            SourceItem.ItemType itemType = sourceItem.i;
            if (itemType == SourceItem.ItemType.VISUAL || itemType == SourceItem.ItemType.SOUNDTRACK) {
                com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) sourceItem;
                com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar = aVar.q;
                if (aVar.u == SourceItem.MediaType.AUDIO && aVar.m && bVar.y.f20484c == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean e() {
        for (SourceItem sourceItem : a()) {
            if (sourceItem.i == SourceItem.ItemType.VISUAL) {
                com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) sourceItem;
                com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar = aVar.q;
                SourceItem.MediaType mediaType = aVar.u;
                if (mediaType == SourceItem.MediaType.SOLID || mediaType == SourceItem.MediaType.BGIMAGE || (bVar.v && mediaType != SourceItem.MediaType.AUDIO)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean f() {
        return this.f3695c;
    }

    public boolean g() {
        return this.f3696d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n********************** Track(" + this.f3693a + ") Info ************************ ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n trackId : ");
        sb2.append(this.f3693a);
        sb.append(sb2.toString());
        return sb.toString();
    }

    public List<SourceItem> a(SourceItem sourceItem) {
        List<SourceItem> list = this.f3694b;
        if (list != null) {
            list.add(sourceItem);
        }
        return this.f3694b;
    }

    public void a(boolean z) {
        this.f3695c = z;
    }

    public com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a a(b bVar) {
        for (SourceItem sourceItem : bVar.a()) {
            SourceItem.ItemType itemType = sourceItem.i;
            if (itemType == SourceItem.ItemType.VISUAL || itemType == SourceItem.ItemType.SOUNDTRACK) {
                com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) sourceItem;
                if (aVar.u == SourceItem.MediaType.AUDIO) {
                    return aVar;
                }
            }
        }
        return null;
    }
}
