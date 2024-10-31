package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class Path implements Iterable<ChildKey>, Comparable<Path> {

    /* renamed from: a */
    private static final Path f16899a = new Path("");

    /* renamed from: b */
    private final ChildKey[] f16900b;

    /* renamed from: c */
    private final int f16901c;

    /* renamed from: d */
    private final int f16902d;

    public Path(ChildKey... childKeyArr) {
        this.f16900b = (ChildKey[]) Arrays.copyOf(childKeyArr, childKeyArr.length);
        this.f16901c = 0;
        this.f16902d = childKeyArr.length;
        for (ChildKey childKey : childKeyArr) {
        }
    }

    public static Path a(Path path, Path path2) {
        ChildKey f2 = path.f();
        ChildKey f3 = path2.f();
        if (f2 == null) {
            return path2;
        }
        if (f2.equals(f3)) {
            return a(path.g(), path2.g());
        }
        throw new DatabaseException("INTERNAL ERROR: " + path2 + " is not contained in " + path);
    }

    public static Path e() {
        return f16899a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Path)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Path path = (Path) obj;
        if (size() != path.size()) {
            return false;
        }
        int i = this.f16901c;
        for (int i2 = path.f16901c; i < this.f16902d && i2 < path.f16902d; i2++) {
            if (!this.f16900b[i].equals(path.f16900b[i2])) {
                return false;
            }
            i++;
        }
        return true;
    }

    public ChildKey f() {
        if (isEmpty()) {
            return null;
        }
        return this.f16900b[this.f16901c];
    }

    public Path g() {
        int i = this.f16901c;
        if (!isEmpty()) {
            i++;
        }
        return new Path(this.f16900b, i, this.f16902d);
    }

    public Path getParent() {
        if (isEmpty()) {
            return null;
        }
        return new Path(this.f16900b, this.f16901c, this.f16902d - 1);
    }

    public String h() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = this.f16901c; i < this.f16902d; i++) {
            if (i > this.f16901c) {
                sb.append("/");
            }
            sb.append(this.f16900b[i].a());
        }
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = this.f16901c; i2 < this.f16902d; i2++) {
            i = (i * 37) + this.f16900b[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f16901c >= this.f16902d;
    }

    @Override // java.lang.Iterable
    public Iterator<ChildKey> iterator() {
        return new C1590f(this);
    }

    public int size() {
        return this.f16902d - this.f16901c;
    }

    public String toString() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = this.f16901c; i < this.f16902d; i++) {
            sb.append("/");
            sb.append(this.f16900b[i].a());
        }
        return sb.toString();
    }

    public Path d(ChildKey childKey) {
        int size = size();
        int i = size + 1;
        ChildKey[] childKeyArr = new ChildKey[i];
        System.arraycopy(this.f16900b, this.f16901c, childKeyArr, 0, size);
        childKeyArr[size] = childKey;
        return new Path(childKeyArr, 0, i);
    }

    public Path e(Path path) {
        int size = size() + path.size();
        ChildKey[] childKeyArr = new ChildKey[size];
        System.arraycopy(this.f16900b, this.f16901c, childKeyArr, 0, size());
        System.arraycopy(path.f16900b, path.f16901c, childKeyArr, size(), path.size());
        return new Path(childKeyArr, 0, size);
    }

    @Override // java.lang.Comparable
    /* renamed from: f */
    public int compareTo(Path path) {
        int i = this.f16901c;
        int i2 = path.f16901c;
        while (i < this.f16902d && i2 < path.f16902d) {
            int compareTo = this.f16900b[i].compareTo(path.f16900b[i2]);
            if (compareTo != 0) {
                return compareTo;
            }
            i++;
            i2++;
        }
        if (i == this.f16902d && i2 == path.f16902d) {
            return 0;
        }
        return i == this.f16902d ? -1 : 1;
    }

    public boolean g(Path path) {
        if (size() > path.size()) {
            return false;
        }
        int i = this.f16901c;
        int i2 = path.f16901c;
        while (i < this.f16902d) {
            if (!this.f16900b[i].equals(path.f16900b[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public Path(List<String> list) {
        this.f16900b = new ChildKey[list.size()];
        Iterator<String> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            this.f16900b[i] = ChildKey.a(it.next());
            i++;
        }
        this.f16901c = 0;
        this.f16902d = list.size();
    }

    public List<String> a() {
        ArrayList arrayList = new ArrayList(size());
        Iterator<ChildKey> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        return arrayList;
    }

    public ChildKey d() {
        if (isEmpty()) {
            return null;
        }
        return this.f16900b[this.f16902d - 1];
    }

    public Path(String str) {
        String[] split = str.split("/", -1);
        int i = 0;
        for (String str2 : split) {
            if (str2.length() > 0) {
                i++;
            }
        }
        this.f16900b = new ChildKey[i];
        int i2 = 0;
        for (String str3 : split) {
            if (str3.length() > 0) {
                this.f16900b[i2] = ChildKey.a(str3);
                i2++;
            }
        }
        this.f16901c = 0;
        this.f16902d = this.f16900b.length;
    }

    private Path(ChildKey[] childKeyArr, int i, int i2) {
        this.f16900b = childKeyArr;
        this.f16901c = i;
        this.f16902d = i2;
    }
}
