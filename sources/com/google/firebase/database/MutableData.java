package com.google.firebase.database;

import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.SnapshotHolder;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class MutableData {

    /* renamed from: a */
    private final SnapshotHolder f16640a;

    /* renamed from: b */
    private final Path f16641b;

    public MutableData(Node node) {
        this(new SnapshotHolder(node), new Path(""));
    }

    Node a() {
        return this.f16640a.a(this.f16641b);
    }

    @PublicApi
    public Object b() {
        return a().getValue();
    }

    public boolean equals(Object obj) {
        if (obj instanceof MutableData) {
            MutableData mutableData = (MutableData) obj;
            if (this.f16640a.equals(mutableData.f16640a) && this.f16641b.equals(mutableData.f16641b)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        ChildKey f2 = this.f16641b.f();
        StringBuilder sb = new StringBuilder();
        sb.append("MutableData { key = ");
        sb.append(f2 != null ? f2.a() : "<none>");
        sb.append(", value = ");
        sb.append(this.f16640a.a().a(true));
        sb.append(" }");
        return sb.toString();
    }

    private MutableData(SnapshotHolder snapshotHolder, Path path) {
        this.f16640a = snapshotHolder;
        this.f16641b = path;
        ValidationPath.a(this.f16641b, b());
    }
}
