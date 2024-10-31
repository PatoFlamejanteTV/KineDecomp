package org.keyczar.interfaces;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.keyczar.DefaultKeyType;
import org.keyczar.KeyczarKey;
import org.keyczar.exceptions.KeyczarException;

/* loaded from: classes3.dex */
public interface KeyType {

    /* loaded from: classes3.dex */
    public interface Builder {
        KeyczarKey generate(int i) throws KeyczarException;

        KeyczarKey read(String str) throws KeyczarException;
    }

    /* loaded from: classes3.dex */
    public static class KeyTypeDeserializer implements JsonDeserializer<KeyType> {
        private static Map<String, KeyType> typeMap = new HashMap();

        static {
            for (DefaultKeyType defaultKeyType : DefaultKeyType.values()) {
                registerType(defaultKeyType);
            }
        }

        public static void registerType(KeyType keyType) {
            String name = keyType.getName();
            if (!typeMap.containsKey(name)) {
                typeMap.put(name, keyType);
                return;
            }
            throw new IllegalArgumentException("Attempt to map two key types to the same name " + name);
        }

        @Override // com.google.gson.JsonDeserializer
        public KeyType deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            String asString = jsonElement.getAsJsonPrimitive().getAsString();
            if (typeMap.containsKey(asString)) {
                return typeMap.get(asString);
            }
            throw new IllegalArgumentException("Cannot deserialize " + asString + " no such key has been registered.");
        }
    }

    /* loaded from: classes3.dex */
    public static class KeyTypeSerializer implements JsonSerializer<KeyType> {
        @Override // com.google.gson.JsonSerializer
        public JsonElement serialize(KeyType keyType, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(keyType.getName());
        }
    }

    int defaultSize();

    List<Integer> getAcceptableSizes();

    Builder getBuilder();

    String getName();

    int getOutputSize();

    int getOutputSize(int i);

    boolean isAcceptableSize(int i);
}
