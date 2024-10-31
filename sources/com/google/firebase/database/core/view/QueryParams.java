package com.google.firebase.database.core.view;

import com.google.firebase.database.core.view.filter.IndexedFilter;
import com.google.firebase.database.core.view.filter.LimitedFilter;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.core.view.filter.RangedFilter;
import com.google.firebase.database.snapshot.BooleanNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.LongNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityIndex;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.snapshot.StringNode;
import com.google.firebase.database.util.JsonMapper;
import com.qq.e.comm.constants.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class QueryParams {

    /* renamed from: a */
    public static final QueryParams f17117a = new QueryParams();

    /* renamed from: b */
    private Integer f17118b;

    /* renamed from: c */
    private ViewFrom f17119c;

    /* renamed from: d */
    private Node f17120d = null;

    /* renamed from: e */
    private ChildKey f17121e = null;

    /* renamed from: f */
    private Node f17122f = null;

    /* renamed from: g */
    private ChildKey f17123g = null;

    /* renamed from: h */
    private Index f17124h = PriorityIndex.d();
    private String i = null;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public enum ViewFrom {
        LEFT,
        RIGHT
    }

    public Index a() {
        return this.f17124h;
    }

    public ChildKey b() {
        if (i()) {
            ChildKey childKey = this.f17123g;
            return childKey != null ? childKey : ChildKey.d();
        }
        throw new IllegalArgumentException("Cannot get index end name if start has not been set");
    }

    public Node c() {
        if (i()) {
            return this.f17122f;
        }
        throw new IllegalArgumentException("Cannot get index end value if start has not been set");
    }

    public ChildKey d() {
        if (k()) {
            ChildKey childKey = this.f17121e;
            return childKey != null ? childKey : ChildKey.e();
        }
        throw new IllegalArgumentException("Cannot get index start name if start has not been set");
    }

    public Node e() {
        if (k()) {
            return this.f17120d;
        }
        throw new IllegalArgumentException("Cannot get index start value if start has not been set");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || QueryParams.class != obj.getClass()) {
            return false;
        }
        QueryParams queryParams = (QueryParams) obj;
        Integer num = this.f17118b;
        if (num == null ? queryParams.f17118b != null : !num.equals(queryParams.f17118b)) {
            return false;
        }
        Index index = this.f17124h;
        if (index == null ? queryParams.f17124h != null : !index.equals(queryParams.f17124h)) {
            return false;
        }
        ChildKey childKey = this.f17123g;
        if (childKey == null ? queryParams.f17123g != null : !childKey.equals(queryParams.f17123g)) {
            return false;
        }
        Node node = this.f17122f;
        if (node == null ? queryParams.f17122f != null : !node.equals(queryParams.f17122f)) {
            return false;
        }
        ChildKey childKey2 = this.f17121e;
        if (childKey2 == null ? queryParams.f17121e != null : !childKey2.equals(queryParams.f17121e)) {
            return false;
        }
        Node node2 = this.f17120d;
        if (node2 == null ? queryParams.f17120d == null : node2.equals(queryParams.f17120d)) {
            return m() == queryParams.m();
        }
        return false;
    }

    public int f() {
        if (j()) {
            return this.f17118b.intValue();
        }
        throw new IllegalArgumentException("Cannot get limit if limit has not been set");
    }

    public NodeFilter g() {
        if (n()) {
            return new IndexedFilter(a());
        }
        if (j()) {
            return new LimitedFilter(this);
        }
        return new RangedFilter(this);
    }

    public Map<String, Object> h() {
        HashMap hashMap = new HashMap();
        if (k()) {
            hashMap.put("sp", this.f17120d.getValue());
            ChildKey childKey = this.f17121e;
            if (childKey != null) {
                hashMap.put("sn", childKey.a());
            }
        }
        if (i()) {
            hashMap.put("ep", this.f17122f.getValue());
            ChildKey childKey2 = this.f17123g;
            if (childKey2 != null) {
                hashMap.put("en", childKey2.a());
            }
        }
        Integer num = this.f17118b;
        if (num != null) {
            hashMap.put(Constants.LANDSCAPE, num);
            ViewFrom viewFrom = this.f17119c;
            if (viewFrom == null) {
                if (k()) {
                    viewFrom = ViewFrom.LEFT;
                } else {
                    viewFrom = ViewFrom.RIGHT;
                }
            }
            int i = c.f17146a[viewFrom.ordinal()];
            if (i == 1) {
                hashMap.put("vf", Constants.LANDSCAPE);
            } else if (i == 2) {
                hashMap.put("vf", "r");
            }
        }
        if (!this.f17124h.equals(PriorityIndex.d())) {
            hashMap.put(com.umeng.commonsdk.proguard.e.aq, this.f17124h.a());
        }
        return hashMap;
    }

    public int hashCode() {
        Integer num = this.f17118b;
        int intValue = (((num != null ? num.intValue() : 0) * 31) + (m() ? 1231 : 1237)) * 31;
        Node node = this.f17120d;
        int hashCode = (intValue + (node != null ? node.hashCode() : 0)) * 31;
        ChildKey childKey = this.f17121e;
        int hashCode2 = (hashCode + (childKey != null ? childKey.hashCode() : 0)) * 31;
        Node node2 = this.f17122f;
        int hashCode3 = (hashCode2 + (node2 != null ? node2.hashCode() : 0)) * 31;
        ChildKey childKey2 = this.f17123g;
        int hashCode4 = (hashCode3 + (childKey2 != null ? childKey2.hashCode() : 0)) * 31;
        Index index = this.f17124h;
        return hashCode4 + (index != null ? index.hashCode() : 0);
    }

    public boolean i() {
        return this.f17122f != null;
    }

    public boolean j() {
        return this.f17118b != null;
    }

    public boolean k() {
        return this.f17120d != null;
    }

    public boolean l() {
        return n() && this.f17124h.equals(PriorityIndex.d());
    }

    public boolean m() {
        ViewFrom viewFrom = this.f17119c;
        return viewFrom != null ? viewFrom == ViewFrom.LEFT : k();
    }

    public boolean n() {
        return (k() || i() || j()) ? false : true;
    }

    public String o() {
        if (this.i == null) {
            try {
                this.i = JsonMapper.a(h());
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        return this.i;
    }

    public String toString() {
        return h().toString();
    }

    public static QueryParams a(Map<String, Object> map) {
        QueryParams queryParams = new QueryParams();
        queryParams.f17118b = (Integer) map.get(Constants.LANDSCAPE);
        if (map.containsKey("sp")) {
            queryParams.f17120d = a(NodeUtilities.a(map.get("sp")));
            String str = (String) map.get("sn");
            if (str != null) {
                queryParams.f17121e = ChildKey.a(str);
            }
        }
        if (map.containsKey("ep")) {
            queryParams.f17122f = a(NodeUtilities.a(map.get("ep")));
            String str2 = (String) map.get("en");
            if (str2 != null) {
                queryParams.f17123g = ChildKey.a(str2);
            }
        }
        String str3 = (String) map.get("vf");
        if (str3 != null) {
            queryParams.f17119c = str3.equals(Constants.LANDSCAPE) ? ViewFrom.LEFT : ViewFrom.RIGHT;
        }
        String str4 = (String) map.get(com.umeng.commonsdk.proguard.e.aq);
        if (str4 != null) {
            queryParams.f17124h = Index.a(str4);
        }
        return queryParams;
    }

    private static Node a(Node node) {
        if ((node instanceof StringNode) || (node instanceof BooleanNode) || (node instanceof DoubleNode) || (node instanceof EmptyNode)) {
            return node;
        }
        if (node instanceof LongNode) {
            return new DoubleNode(Double.valueOf(((Long) node.getValue()).doubleValue()), PriorityUtilities.a());
        }
        throw new IllegalStateException("Unexpected value passed to normalizeValue: " + node.getValue());
    }
}
