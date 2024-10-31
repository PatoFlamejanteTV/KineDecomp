package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class UserWriteRecord {

    /* renamed from: a */
    private final long f16947a;

    /* renamed from: b */
    private final Path f16948b;

    /* renamed from: c */
    private final Node f16949c;

    /* renamed from: d */
    private final CompoundWrite f16950d;

    /* renamed from: e */
    private final boolean f16951e;

    public UserWriteRecord(long j, Path path, Node node, boolean z) {
        this.f16947a = j;
        this.f16948b = path;
        this.f16949c = node;
        this.f16950d = null;
        this.f16951e = z;
    }

    public CompoundWrite a() {
        CompoundWrite compoundWrite = this.f16950d;
        if (compoundWrite != null) {
            return compoundWrite;
        }
        throw new IllegalArgumentException("Can't access merge when write is an overwrite!");
    }

    public Node b() {
        Node node = this.f16949c;
        if (node != null) {
            return node;
        }
        throw new IllegalArgumentException("Can't access overwrite when write is a merge!");
    }

    public Path c() {
        return this.f16948b;
    }

    public long d() {
        return this.f16947a;
    }

    public boolean e() {
        return this.f16949c != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UserWriteRecord.class != obj.getClass()) {
            return false;
        }
        UserWriteRecord userWriteRecord = (UserWriteRecord) obj;
        if (this.f16947a != userWriteRecord.f16947a || !this.f16948b.equals(userWriteRecord.f16948b) || this.f16951e != userWriteRecord.f16951e) {
            return false;
        }
        Node node = this.f16949c;
        if (node == null ? userWriteRecord.f16949c != null : !node.equals(userWriteRecord.f16949c)) {
            return false;
        }
        CompoundWrite compoundWrite = this.f16950d;
        return compoundWrite == null ? userWriteRecord.f16950d == null : compoundWrite.equals(userWriteRecord.f16950d);
    }

    public boolean f() {
        return this.f16951e;
    }

    public int hashCode() {
        int hashCode = ((((Long.valueOf(this.f16947a).hashCode() * 31) + Boolean.valueOf(this.f16951e).hashCode()) * 31) + this.f16948b.hashCode()) * 31;
        Node node = this.f16949c;
        int hashCode2 = (hashCode + (node != null ? node.hashCode() : 0)) * 31;
        CompoundWrite compoundWrite = this.f16950d;
        return hashCode2 + (compoundWrite != null ? compoundWrite.hashCode() : 0);
    }

    public String toString() {
        return "UserWriteRecord{id=" + this.f16947a + " path=" + this.f16948b + " visible=" + this.f16951e + " overwrite=" + this.f16949c + " merge=" + this.f16950d + "}";
    }

    public UserWriteRecord(long j, Path path, CompoundWrite compoundWrite) {
        this.f16947a = j;
        this.f16948b = path;
        this.f16949c = null;
        this.f16950d = compoundWrite;
        this.f16951e = true;
    }
}
