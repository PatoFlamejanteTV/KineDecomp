package com.nexstreaming.app.general.iab.assist;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.internal.h;

/* compiled from: FirebaseAssistant.kt */
/* loaded from: classes2.dex */
final class b<TResult> implements OnSuccessListener<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f19433a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ kotlin.jvm.a.b f19434b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, kotlin.jvm.a.b bVar) {
        this.f19433a = aVar;
        this.f19434b = bVar;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onSuccess(byte[] bArr) {
        h.a((Object) bArr, "bytes");
        String str = new String(bArr, kotlin.text.c.f28548a);
        kotlin.jvm.a.b bVar = this.f19434b;
        if (bVar != null) {
            bVar.invoke(str);
        }
    }
}
