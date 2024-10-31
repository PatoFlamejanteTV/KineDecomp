package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;

/* loaded from: classes.dex */
public interface HttpContent extends StreamingContent {
    long a() throws IOException;

    String d();

    boolean f();
}
