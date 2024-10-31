package c.d.b.d.b.a.d;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.items.SourceItem;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Sequence.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    ArrayList<SourceItem> f3726a = new ArrayList<>();

    public void a(SourceItem sourceItem) {
        if (sourceItem != null) {
            this.f3726a.add(sourceItem);
        }
    }

    public ArrayList<SourceItem> b() {
        return this.f3726a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nSequence Start ------------------------------------------ ");
        Iterator<SourceItem> it = this.f3726a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        sb.append("\nSequence End -------------------------------------------- ");
        return sb.toString();
    }

    public int a() {
        return this.f3726a.size();
    }
}
