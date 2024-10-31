package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.List;

/* compiled from: PushObserver.java */
/* loaded from: classes3.dex */
public interface z {

    /* renamed from: a */
    public static final z f25410a = new y();

    void a(int i, ErrorCode errorCode);

    boolean a(int i, List<q> list);

    boolean a(int i, List<q> list, boolean z);

    boolean a(int i, okio.i iVar, int i2, boolean z) throws IOException;
}
