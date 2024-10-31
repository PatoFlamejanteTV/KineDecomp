package org.apache.commons.io.filefilter;

import java.util.ArrayList;
import java.util.List;

/* compiled from: FileFilterUtils.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    private static final d f29320a = a(a(a(), a("CVS")));

    /* renamed from: b */
    private static final d f29321b = a(a(a(), a(".svn")));

    public static d a(String str) {
        return new NameFileFilter(str);
    }

    public static d b(d... dVarArr) {
        return new OrFileFilter(c(dVarArr));
    }

    public static List<d> c(d... dVarArr) {
        if (dVarArr != null) {
            ArrayList arrayList = new ArrayList(dVarArr.length);
            for (int i = 0; i < dVarArr.length; i++) {
                if (dVarArr[i] != null) {
                    arrayList.add(dVarArr[i]);
                } else {
                    throw new IllegalArgumentException("The filter[" + i + "] is null");
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("The filters must not be null");
    }

    public static d a() {
        return DirectoryFileFilter.DIRECTORY;
    }

    public static d a(d... dVarArr) {
        return new AndFileFilter(c(dVarArr));
    }

    public static d a(d dVar) {
        return new NotFileFilter(dVar);
    }
}
