package com.google.api.client.googleapis.testing;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class TestUtils {
    private TestUtils() {
    }

    public static Map<String, String> a(String str) throws IOException {
        HashMap hashMap = new HashMap();
        Iterator<String> it = Splitter.a('&').a((CharSequence) str).iterator();
        while (it.hasNext()) {
            ArrayList a2 = Lists.a(Splitter.a('=').a((CharSequence) it.next()));
            if (a2.size() == 2) {
                hashMap.put(URLDecoder.decode((String) a2.get(0), "UTF-8"), URLDecoder.decode((String) a2.get(1), "UTF-8"));
            } else {
                throw new IOException("Invalid Query String");
            }
        }
        return hashMap;
    }
}
