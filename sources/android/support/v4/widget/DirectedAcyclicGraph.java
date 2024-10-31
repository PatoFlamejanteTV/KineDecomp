package android.support.v4.widget;

import android.support.v4.util.Pools;
import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class DirectedAcyclicGraph<T> {

    /* renamed from: a */
    private final Pools.Pool<ArrayList<T>> f1961a = new Pools.SimplePool(10);

    /* renamed from: b */
    private final SimpleArrayMap<T, ArrayList<T>> f1962b = new SimpleArrayMap<>();

    /* renamed from: c */
    private final ArrayList<T> f1963c = new ArrayList<>();

    /* renamed from: d */
    private final HashSet<T> f1964d = new HashSet<>();

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (!hashSet.contains(t)) {
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.f1962b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    public void addEdge(T t, T t2) {
        if (this.f1962b.containsKey(t) && this.f1962b.containsKey(t2)) {
            ArrayList<T> arrayList = this.f1962b.get(t);
            if (arrayList == null) {
                arrayList = a();
                this.f1962b.put(t, arrayList);
            }
            arrayList.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void addNode(T t) {
        if (this.f1962b.containsKey(t)) {
            return;
        }
        this.f1962b.put(t, null);
    }

    public void clear() {
        int size = this.f1962b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> valueAt = this.f1962b.valueAt(i);
            if (valueAt != null) {
                a(valueAt);
            }
        }
        this.f1962b.clear();
    }

    public boolean contains(T t) {
        return this.f1962b.containsKey(t);
    }

    public List getIncomingEdges(T t) {
        return this.f1962b.get(t);
    }

    public List<T> getOutgoingEdges(T t) {
        int size = this.f1962b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> valueAt = this.f1962b.valueAt(i);
            if (valueAt != null && valueAt.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1962b.keyAt(i));
            }
        }
        return arrayList;
    }

    public ArrayList<T> getSortedList() {
        this.f1963c.clear();
        this.f1964d.clear();
        int size = this.f1962b.size();
        for (int i = 0; i < size; i++) {
            a(this.f1962b.keyAt(i), this.f1963c, this.f1964d);
        }
        return this.f1963c;
    }

    public boolean hasOutgoingEdges(T t) {
        int size = this.f1962b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> valueAt = this.f1962b.valueAt(i);
            if (valueAt != null && valueAt.contains(t)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<T> a() {
        ArrayList<T> acquire = this.f1961a.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1961a.release(arrayList);
    }
}
