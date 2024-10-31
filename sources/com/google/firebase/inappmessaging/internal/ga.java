package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class ga implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    private static final ga f17861a = new ga();

    private ga() {
    }

    public static Comparator a() {
        return f17861a;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int b2;
        b2 = InAppMessageStreamManager.b((CampaignProto.ThickContent) obj, (CampaignProto.ThickContent) obj2);
        return b2;
    }
}
