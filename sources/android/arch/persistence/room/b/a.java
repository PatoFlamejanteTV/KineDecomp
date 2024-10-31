package android.arch.persistence.room.b;

import android.database.Cursor;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: TableInfo.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public final String f84a;

    /* renamed from: b */
    public final Map<String, C0001a> f85b;

    /* renamed from: c */
    public final Set<b> f86c;

    /* renamed from: d */
    public final Set<d> f87d;

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final String f93a;

        /* renamed from: b */
        public final String f94b;

        /* renamed from: c */
        public final String f95c;

        /* renamed from: d */
        public final List<String> f96d;

        /* renamed from: e */
        public final List<String> f97e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f93a = str;
            this.f94b = str2;
            this.f95c = str3;
            this.f96d = Collections.unmodifiableList(list);
            this.f97e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f93a.equals(bVar.f93a) && this.f94b.equals(bVar.f94b) && this.f95c.equals(bVar.f95c) && this.f96d.equals(bVar.f96d)) {
                return this.f97e.equals(bVar.f97e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f93a.hashCode() * 31) + this.f94b.hashCode()) * 31) + this.f95c.hashCode()) * 31) + this.f96d.hashCode()) * 31) + this.f97e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f93a + "', onDelete='" + this.f94b + "', onUpdate='" + this.f95c + "', columnNames=" + this.f96d + ", referenceColumnNames=" + this.f97e + '}';
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class c implements Comparable<c> {

        /* renamed from: a */
        final int f98a;

        /* renamed from: b */
        final int f99b;

        /* renamed from: c */
        final String f100c;

        /* renamed from: d */
        final String f101d;

        c(int i, int i2, String str, String str2) {
            this.f98a = i;
            this.f99b = i2;
            this.f100c = str;
            this.f101d = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(c cVar) {
            int i = this.f98a - cVar.f98a;
            return i == 0 ? this.f99b - cVar.f99b : i;
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a */
        public final String f102a;

        /* renamed from: b */
        public final boolean f103b;

        /* renamed from: c */
        public final List<String> f104c;

        public d(String str, boolean z, List<String> list) {
            this.f102a = str;
            this.f103b = z;
            this.f104c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f103b != dVar.f103b || !this.f104c.equals(dVar.f104c)) {
                return false;
            }
            if (this.f102a.startsWith("index_")) {
                return dVar.f102a.startsWith("index_");
            }
            return this.f102a.equals(dVar.f102a);
        }

        public int hashCode() {
            int hashCode;
            if (this.f102a.startsWith("index_")) {
                hashCode = "index_".hashCode();
            } else {
                hashCode = this.f102a.hashCode();
            }
            return (((hashCode * 31) + (this.f103b ? 1 : 0)) * 31) + this.f104c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f102a + "', unique=" + this.f103b + ", columns=" + this.f104c + '}';
        }
    }

    public a(String str, Map<String, C0001a> map, Set<b> set, Set<d> set2) {
        this.f84a = str;
        this.f85b = Collections.unmodifiableMap(map);
        this.f86c = Collections.unmodifiableSet(set);
        this.f87d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public static a a(b.a.b.a.b bVar, String str) {
        return new a(str, b(bVar, str), c(bVar, str), d(bVar, str));
    }

    private static Map<String, C0001a> b(b.a.b.a.b bVar, String str) {
        Cursor d2 = bVar.d("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (d2.getColumnCount() > 0) {
                int columnIndex = d2.getColumnIndex("name");
                int columnIndex2 = d2.getColumnIndex("type");
                int columnIndex3 = d2.getColumnIndex("notnull");
                int columnIndex4 = d2.getColumnIndex("pk");
                while (d2.moveToNext()) {
                    String string = d2.getString(columnIndex);
                    hashMap.put(string, new C0001a(string, d2.getString(columnIndex2), d2.getInt(columnIndex3) != 0, d2.getInt(columnIndex4)));
                }
            }
            return hashMap;
        } finally {
            d2.close();
        }
    }

    private static Set<b> c(b.a.b.a.b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor d2 = bVar.d("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = d2.getColumnIndex("id");
            int columnIndex2 = d2.getColumnIndex("seq");
            int columnIndex3 = d2.getColumnIndex("table");
            int columnIndex4 = d2.getColumnIndex("on_delete");
            int columnIndex5 = d2.getColumnIndex("on_update");
            List<c> a2 = a(d2);
            int count = d2.getCount();
            for (int i = 0; i < count; i++) {
                d2.moveToPosition(i);
                if (d2.getInt(columnIndex2) == 0) {
                    int i2 = d2.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : a2) {
                        if (cVar.f98a == i2) {
                            arrayList.add(cVar.f100c);
                            arrayList2.add(cVar.f101d);
                        }
                    }
                    hashSet.add(new b(d2.getString(columnIndex3), d2.getString(columnIndex4), d2.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            d2.close();
        }
    }

    private static Set<d> d(b.a.b.a.b bVar, String str) {
        Cursor d2 = bVar.d("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = d2.getColumnIndex("name");
            int columnIndex2 = d2.getColumnIndex("origin");
            int columnIndex3 = d2.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (d2.moveToNext()) {
                    if ("c".equals(d2.getString(columnIndex2))) {
                        String string = d2.getString(columnIndex);
                        boolean z = true;
                        if (d2.getInt(columnIndex3) != 1) {
                            z = false;
                        }
                        d a2 = a(bVar, string, z);
                        if (a2 == null) {
                            return null;
                        }
                        hashSet.add(a2);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            d2.close();
        }
    }

    public boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f84a;
        if (str == null ? aVar.f84a != null : !str.equals(aVar.f84a)) {
            return false;
        }
        Map<String, C0001a> map = this.f85b;
        if (map == null ? aVar.f85b != null : !map.equals(aVar.f85b)) {
            return false;
        }
        Set<b> set2 = this.f86c;
        if (set2 == null ? aVar.f86c != null : !set2.equals(aVar.f86c)) {
            return false;
        }
        Set<d> set3 = this.f87d;
        if (set3 == null || (set = aVar.f87d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f84a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, C0001a> map = this.f85b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f86c;
        return hashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "TableInfo{name='" + this.f84a + "', columns=" + this.f85b + ", foreignKeys=" + this.f86c + ", indices=" + this.f87d + '}';
    }

    private static List<c> a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* compiled from: TableInfo.java */
    /* renamed from: android.arch.persistence.room.b.a$a */
    /* loaded from: classes.dex */
    public static class C0001a {

        /* renamed from: a */
        public final String f88a;

        /* renamed from: b */
        public final String f89b;

        /* renamed from: c */
        public final int f90c;

        /* renamed from: d */
        public final boolean f91d;

        /* renamed from: e */
        public final int f92e;

        public C0001a(String str, String str2, boolean z, int i) {
            this.f88a = str;
            this.f89b = str2;
            this.f91d = z;
            this.f92e = i;
            this.f90c = a(str2);
        }

        private static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0001a.class != obj.getClass()) {
                return false;
            }
            C0001a c0001a = (C0001a) obj;
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.f92e != c0001a.f92e) {
                    return false;
                }
            } else if (a() != c0001a.a()) {
                return false;
            }
            return this.f88a.equals(c0001a.f88a) && this.f91d == c0001a.f91d && this.f90c == c0001a.f90c;
        }

        public int hashCode() {
            return (((((this.f88a.hashCode() * 31) + this.f90c) * 31) + (this.f91d ? 1231 : 1237)) * 31) + this.f92e;
        }

        public String toString() {
            return "Column{name='" + this.f88a + "', type='" + this.f89b + "', affinity='" + this.f90c + "', notNull=" + this.f91d + ", primaryKeyPosition=" + this.f92e + '}';
        }

        public boolean a() {
            return this.f92e > 0;
        }
    }

    private static d a(b.a.b.a.b bVar, String str, boolean z) {
        Cursor d2 = bVar.d("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = d2.getColumnIndex("seqno");
            int columnIndex2 = d2.getColumnIndex("cid");
            int columnIndex3 = d2.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (d2.moveToNext()) {
                    if (d2.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(d2.getInt(columnIndex)), d2.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new d(str, z, arrayList);
            }
            return null;
        } finally {
            d2.close();
        }
    }
}
