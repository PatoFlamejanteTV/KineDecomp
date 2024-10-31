package com.google.gson;

/* loaded from: classes2.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive((Number) l);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive(String.valueOf(l));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.LongSerializationPolicy$1 */
    /* loaded from: classes2.dex */
    public enum AnonymousClass1 extends LongSerializationPolicy {
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive((Number) l);
        }
    }

    /* renamed from: com.google.gson.LongSerializationPolicy$2 */
    /* loaded from: classes2.dex */
    enum AnonymousClass2 extends LongSerializationPolicy {
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive(String.valueOf(l));
        }
    }

    public abstract JsonElement serialize(Long l);

    /* synthetic */ LongSerializationPolicy(AnonymousClass1 anonymousClass1) {
        this();
    }
}
