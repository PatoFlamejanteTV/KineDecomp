package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface HttpContent extends StreamingContent {
    boolean a();

    long getLength() throws IOException;

    String getType();
}
