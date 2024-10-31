package com.google.api.client.util;

/* loaded from: classes2.dex */
public final class Objects {

    /* loaded from: classes2.dex */
    public static final class ToStringHelper {

        /* renamed from: a */
        private final String f14971a;

        /* renamed from: b */
        private a f14972b = new a();

        /* renamed from: c */
        private a f14973c = this.f14972b;

        /* renamed from: d */
        private boolean f14974d;

        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a */
            String f14975a;

            /* renamed from: b */
            Object f14976b;

            /* renamed from: c */
            a f14977c;

            private a() {
            }

            /* synthetic */ a(h hVar) {
                this();
            }
        }

        ToStringHelper(String str) {
            this.f14971a = str;
        }

        private ToStringHelper b(String str, Object obj) {
            a a2 = a();
            a2.f14976b = obj;
            Preconditions.a(str);
            a2.f14975a = str;
            return this;
        }

        public ToStringHelper a(String str, Object obj) {
            b(str, obj);
            return this;
        }

        public String toString() {
            boolean z = this.f14974d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f14971a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f14972b.f14977c; aVar != null; aVar = aVar.f14977c) {
                if (!z || aVar.f14976b != null) {
                    sb.append(str);
                    String str2 = aVar.f14975a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    sb.append(aVar.f14976b);
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private a a() {
            a aVar = new a();
            this.f14973c.f14977c = aVar;
            this.f14973c = aVar;
            return aVar;
        }
    }

    private Objects() {
    }

    public static boolean a(Object obj, Object obj2) {
        return com.google.common.base.Objects.a(obj, obj2);
    }

    public static ToStringHelper a(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }
}
