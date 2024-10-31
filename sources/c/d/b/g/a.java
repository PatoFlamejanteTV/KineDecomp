package c.d.b.g;

import com.nexstreaming.kinemaster.wire.KMProto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProtoUtil.java */
/* loaded from: classes.dex */
public class a {
    public static KMProto.KMProject.StringHashMap a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        KMProto.KMProject.StringHashMap.Builder builder = new KMProto.KMProject.StringHashMap.Builder();
        builder.entries = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.entries.add(new KMProto.KMProject.StringHashMapEntry.Builder().key(entry.getKey()).value(entry.getValue()).build());
        }
        return builder.build();
    }

    public static HashMap<String, String> a(KMProto.KMProject.StringHashMap stringHashMap) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (stringHashMap != null) {
            for (KMProto.KMProject.StringHashMapEntry stringHashMapEntry : stringHashMap.entries) {
                hashMap.put(stringHashMapEntry.key, stringHashMapEntry.value);
            }
        }
        return hashMap;
    }
}
