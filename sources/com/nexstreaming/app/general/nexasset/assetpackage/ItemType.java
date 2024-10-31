package com.nexstreaming.app.general.nexasset.assetpackage;

/* compiled from: ItemType.kt */
/* loaded from: classes2.dex */
public enum ItemType {
    overlay("nex.overlay"),
    lottie("nex.lottie"),
    renderitem("nex.renderitem"),
    kedl("nex.kedl"),
    audio("nex.audio"),
    font("nex.font"),
    template("nex.template"),
    lut("nex.lut"),
    media("nex.media");

    public static final a Companion = new a(null);
    private final String typeId;

    /* compiled from: ItemType.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final ItemType a(String str) {
            kotlin.jvm.internal.h.b(str, "typeId");
            for (ItemType itemType : ItemType.values()) {
                if (kotlin.jvm.internal.h.a((Object) itemType.getTypeId(), (Object) str)) {
                    return itemType;
                }
            }
            return null;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    ItemType(String str) {
        this.typeId = str;
    }

    public static final ItemType fromId(String str) {
        return Companion.a(str);
    }

    public final String getTypeId() {
        return this.typeId;
    }
}
