package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ChildKey implements Comparable<ChildKey> {

    /* renamed from: a */
    private static final ChildKey f17178a = new ChildKey("[MIN_KEY]");

    /* renamed from: b */
    private static final ChildKey f17179b = new ChildKey("[MAX_KEY]");

    /* renamed from: c */
    private static final ChildKey f17180c = new ChildKey(".priority");

    /* renamed from: d */
    private static final ChildKey f17181d = new ChildKey(".info");

    /* renamed from: e */
    private final String f17182e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class a extends ChildKey {

        /* renamed from: f */
        private final int f17183f;

        a(String str, int i) {
            super(str);
            this.f17183f = i;
        }

        @Override // com.google.firebase.database.snapshot.ChildKey, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ChildKey childKey) {
            return super.compareTo(childKey);
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        protected int g() {
            return this.f17183f;
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        protected boolean h() {
            return true;
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        public String toString() {
            return "IntegerChildName(\"" + ((ChildKey) this).f17182e + "\")";
        }
    }

    /* synthetic */ ChildKey(String str, com.google.firebase.database.snapshot.a aVar) {
        this(str);
    }

    public static ChildKey e() {
        return f17178a;
    }

    public static ChildKey f() {
        return f17180c;
    }

    public String a() {
        return this.f17182e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChildKey)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.f17182e.equals(((ChildKey) obj).f17182e);
    }

    protected int g() {
        return 0;
    }

    protected boolean h() {
        return false;
    }

    public int hashCode() {
        return this.f17182e.hashCode();
    }

    public boolean i() {
        return equals(f17180c);
    }

    public String toString() {
        return "ChildKey(\"" + this.f17182e + "\")";
    }

    private ChildKey(String str) {
        this.f17182e = str;
    }

    public static ChildKey a(String str) {
        Integer d2 = Utilities.d(str);
        if (d2 != null) {
            return new a(str, d2.intValue());
        }
        if (str.equals(".priority")) {
            return f17180c;
        }
        return new ChildKey(str);
    }

    public static ChildKey d() {
        return f17179b;
    }

    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(ChildKey childKey) {
        ChildKey childKey2;
        if (this == childKey) {
            return 0;
        }
        ChildKey childKey3 = f17178a;
        if (this == childKey3 || childKey == (childKey2 = f17179b)) {
            return -1;
        }
        if (childKey == childKey3 || this == childKey2) {
            return 1;
        }
        if (h()) {
            if (!childKey.h()) {
                return -1;
            }
            int a2 = Utilities.a(g(), childKey.g());
            return a2 == 0 ? Utilities.a(this.f17182e.length(), childKey.f17182e.length()) : a2;
        }
        if (childKey.h()) {
            return 1;
        }
        return this.f17182e.compareTo(childKey.f17182e);
    }
}
