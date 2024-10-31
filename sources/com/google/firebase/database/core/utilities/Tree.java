package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class Tree<T> {

    /* renamed from: a */
    private ChildKey f17067a;

    /* renamed from: b */
    private Tree<T> f17068b;

    /* renamed from: c */
    private TreeNode<T> f17069c;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface TreeFilter<T> {
        boolean a(Tree<T> tree);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface TreeVisitor<T> {
        void a(Tree<T> tree);
    }

    public Tree(ChildKey childKey, Tree<T> tree, TreeNode<T> treeNode) {
        this.f17067a = childKey;
        this.f17068b = tree;
        this.f17069c = treeNode;
    }

    private void e() {
        Tree<T> tree = this.f17068b;
        if (tree != null) {
            tree.a(this.f17067a, this);
        }
    }

    public Tree<T> a(Path path) {
        ChildKey f2 = path.f();
        Path path2 = path;
        Tree<T> tree = this;
        while (f2 != null) {
            Tree<T> tree2 = new Tree<>(f2, tree, tree.f17069c.f17070a.containsKey(f2) ? tree.f17069c.f17070a.get(f2) : new TreeNode<>());
            path2 = path2.g();
            f2 = path2.f();
            tree = tree2;
        }
        return tree;
    }

    public T b() {
        return this.f17069c.f17071b;
    }

    public boolean c() {
        return !this.f17069c.f17070a.isEmpty();
    }

    public boolean d() {
        TreeNode<T> treeNode = this.f17069c;
        return treeNode.f17071b == null && treeNode.f17070a.isEmpty();
    }

    public String toString() {
        return a("");
    }

    public void b(TreeVisitor<T> treeVisitor) {
        a(treeVisitor, false, false);
    }

    public Tree() {
        this(null, null, new TreeNode());
    }

    public void a(T t) {
        this.f17069c.f17071b = t;
        e();
    }

    public Path a() {
        Tree<T> tree = this.f17068b;
        if (tree != null) {
            return tree.a().d(this.f17067a);
        }
        ChildKey childKey = this.f17067a;
        return childKey != null ? new Path(childKey) : Path.e();
    }

    public void a(TreeVisitor<T> treeVisitor, boolean z, boolean z2) {
        if (z && !z2) {
            treeVisitor.a(this);
        }
        a((TreeVisitor) new f(this, treeVisitor, z2));
        if (z && z2) {
            treeVisitor.a(this);
        }
    }

    public boolean a(TreeFilter<T> treeFilter) {
        return a((TreeFilter) treeFilter, false);
    }

    public boolean a(TreeFilter<T> treeFilter, boolean z) {
        for (Tree<T> tree = z ? this : this.f17068b; tree != null; tree = tree.f17068b) {
            if (treeFilter.a(tree)) {
                return true;
            }
        }
        return false;
    }

    public void a(TreeVisitor<T> treeVisitor) {
        for (Object obj : this.f17069c.f17070a.entrySet().toArray()) {
            Map.Entry entry = (Map.Entry) obj;
            treeVisitor.a(new Tree<>((ChildKey) entry.getKey(), this, (TreeNode) entry.getValue()));
        }
    }

    private void a(ChildKey childKey, Tree<T> tree) {
        boolean d2 = tree.d();
        boolean containsKey = this.f17069c.f17070a.containsKey(childKey);
        if (d2 && containsKey) {
            this.f17069c.f17070a.remove(childKey);
            e();
        } else {
            if (d2 || containsKey) {
                return;
            }
            this.f17069c.f17070a.put(childKey, tree.f17069c);
            e();
        }
    }

    String a(String str) {
        ChildKey childKey = this.f17067a;
        String a2 = childKey == null ? "<anon>" : childKey.a();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(a2);
        sb.append("\n");
        sb.append(this.f17069c.a(str + "\t"));
        return sb.toString();
    }
}
