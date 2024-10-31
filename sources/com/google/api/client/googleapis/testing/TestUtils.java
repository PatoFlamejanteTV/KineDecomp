package com.google.api.client.googleapis.testing;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public final class TestUtils {
    public static Map<String, String> a(String str) throws IOException {
        HashMap hashMap = new HashMap();
        Iterator<String> it = Splitter.a('&').a(str).iterator();
        while (it.hasNext()) {
            ArrayList a2 = Lists.a(Splitter.a('=').a(it.next()));
            if (a2.size() != 2) {
                throw new IOException("Invalid Query String");
            }
            hashMap.put(URLDecoder.decode((String) a2.get(0), Keyczar.DEFAULT_ENCODING), URLDecoder.decode((String) a2.get(1), Keyczar.DEFAULT_ENCODING));
        }
        return hashMap;
    }

    private TestUtils() {
    }
}
