package com.google.api.client.http;

import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
@Deprecated
/* loaded from: classes2.dex */
public interface BackOffPolicy {
    long a() throws IOException;

    boolean a(int i);

    void reset();
}
