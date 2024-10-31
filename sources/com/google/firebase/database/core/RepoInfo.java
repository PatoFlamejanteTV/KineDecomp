package com.google.firebase.database.core;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class RepoInfo {

    /* renamed from: a */
    public String f16919a;

    /* renamed from: b */
    public boolean f16920b;

    /* renamed from: c */
    public String f16921c;

    /* renamed from: d */
    public String f16922d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RepoInfo.class != obj.getClass()) {
            return false;
        }
        RepoInfo repoInfo = (RepoInfo) obj;
        if (this.f16920b == repoInfo.f16920b && this.f16919a.equals(repoInfo.f16919a)) {
            return this.f16921c.equals(repoInfo.f16921c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f16919a.hashCode() * 31) + (this.f16920b ? 1 : 0)) * 31) + this.f16921c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("http");
        sb.append(this.f16920b ? com.umeng.commonsdk.proguard.e.ap : "");
        sb.append("://");
        sb.append(this.f16919a);
        return sb.toString();
    }
}
