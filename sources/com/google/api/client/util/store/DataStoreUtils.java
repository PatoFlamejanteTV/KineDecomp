package com.google.api.client.util.store;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class DataStoreUtils {
    private DataStoreUtils() {
    }

    public static String a(DataStore<?> dataStore) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            boolean z = true;
            for (String str : dataStore.keySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append('=');
                sb.append(dataStore.a(str));
            }
            sb.append('}');
            return sb.toString();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
