package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.Predicate;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class S implements Predicate<UserWriteRecord> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f16925a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f16926b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Path f16927c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ WriteTree f16928d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(WriteTree writeTree, boolean z, List list, Path path) {
        this.f16928d = writeTree;
        this.f16925a = z;
        this.f16926b = list;
        this.f16927c = path;
    }

    @Override // com.google.firebase.database.core.utilities.Predicate
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean evaluate(UserWriteRecord userWriteRecord) {
        return (userWriteRecord.f() || this.f16925a) && !this.f16926b.contains(Long.valueOf(userWriteRecord.d())) && (userWriteRecord.c().g(this.f16927c) || this.f16927c.g(userWriteRecord.c()));
    }
}
