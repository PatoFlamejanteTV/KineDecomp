package com.nexstreaming.kinemaster.usage;

import android.text.TextUtils;

/* compiled from: AssetStoreEnterData.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a */
    private AssetStoreEntry f23933a;

    /* renamed from: b */
    private String f23934b;

    /* renamed from: c */
    private String f23935c;

    /* renamed from: d */
    private String f23936d;

    /* renamed from: e */
    private String f23937e;

    /* compiled from: AssetStoreEnterData.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        private AssetStoreEntry f23938a = AssetStoreEntry.UNKNOWN;

        /* renamed from: b */
        private String f23939b = "unknown";

        /* renamed from: c */
        private String f23940c = "unknown";

        /* renamed from: d */
        private String f23941d = "unknown";

        /* renamed from: e */
        private String f23942e = "unknown";

        public d a() {
            return new d(this.f23938a, this.f23939b, this.f23941d, this.f23940c, this.f23942e);
        }

        public a b(String str) {
            this.f23939b = str;
            return this;
        }

        public a a(AssetStoreEntry assetStoreEntry) {
            this.f23938a = assetStoreEntry;
            return this;
        }

        public a a(String str, String str2, String str3) {
            if (!TextUtils.isEmpty(str)) {
                if (str.equalsIgnoreCase("asset")) {
                    this.f23940c = str2;
                } else if (str.equalsIgnoreCase("category")) {
                    this.f23941d = str2;
                    this.f23942e = str3;
                }
            }
            return this;
        }

        public a a(String str) {
            this.f23941d = str;
            return this;
        }
    }

    public d(AssetStoreEntry assetStoreEntry, String str, String str2, String str3, String str4) {
        this.f23933a = assetStoreEntry;
        this.f23934b = str;
        this.f23935c = str3;
        this.f23936d = str2;
        this.f23937e = str4;
    }

    public String a() {
        return this.f23935c;
    }

    public String b() {
        return this.f23936d;
    }

    public AssetStoreEntry c() {
        return this.f23933a;
    }

    public String d() {
        return this.f23937e;
    }

    public String e() {
        return this.f23934b;
    }
}
