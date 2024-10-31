package com.nexstreaming.app.general.nexasset.assetpackage;

/* compiled from: ItemRatioType.kt */
/* loaded from: classes2.dex */
public enum ItemRatioType {
    RATIO_16v9("16:9"),
    RATIO_1v1("1:1"),
    RATIO_9v16("9:16");

    public static final a Companion = new a(null);
    private final String ratioString;

    /* compiled from: ItemRatioType.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final ItemRatioType a(String str) {
            if (str == null) {
                return null;
            }
            for (ItemRatioType itemRatioType : ItemRatioType.values()) {
                if (kotlin.jvm.internal.h.a((Object) itemRatioType.ratioString, (Object) str)) {
                    return itemRatioType;
                }
            }
            return null;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    ItemRatioType(String str) {
        this.ratioString = str;
    }

    public static final ItemRatioType getEnum(String str) {
        return Companion.a(str);
    }
}
