package com.google.api.client.http;

import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
@Deprecated
/* loaded from: classes.dex */
public interface BackOffPolicy {
    void a();

    boolean a(int i);

    long b() throws IOException;
}
