package com.nexstreaming.kinemaster.network;

import java.util.ArrayList;
import java.util.List;

/* compiled from: SubscriptionInfo.kt */
/* loaded from: classes.dex */
public final class SubscriptionInfo {
    private String edition = "";
    private String version = "";
    private List<SubscriptionProductInfo> list = new ArrayList();

    /* compiled from: SubscriptionInfo.kt */
    /* loaded from: classes.dex */
    public final class SubscriptionItemInfo {
        private int idx = 1;
        private String productId = "";
        private String payFee = "";
        private long fee = 1000;
        private String description = "";

        public SubscriptionItemInfo() {
        }

        public final String getDescription() {
            return this.description;
        }

        public final long getFee() {
            return this.fee;
        }

        public final int getIdx() {
            return this.idx;
        }

        public final String getPayFee() {
            return this.payFee;
        }

        public final String getProductId() {
            return this.productId;
        }

        public final void setDescription(String str) {
            kotlin.jvm.internal.h.b(str, "<set-?>");
            this.description = str;
        }

        public final void setFee(long j) {
            this.fee = j;
        }

        public final void setIdx(int i) {
            this.idx = i;
        }

        public final void setPayFee(String str) {
            kotlin.jvm.internal.h.b(str, "<set-?>");
            this.payFee = str;
        }

        public final void setProductId(String str) {
            kotlin.jvm.internal.h.b(str, "<set-?>");
            this.productId = str;
        }
    }

    /* compiled from: SubscriptionInfo.kt */
    /* loaded from: classes.dex */
    public final class SubscriptionProductInfo {
        private String productName = "";
        private int display = 1;
        private List<SubscriptionItemInfo> items = new ArrayList();

        public SubscriptionProductInfo() {
        }

        public final int getDisplay() {
            return this.display;
        }

        public final List<SubscriptionItemInfo> getItems() {
            return this.items;
        }

        public final String getProductName() {
            return this.productName;
        }

        public final void setDisplay(int i) {
            this.display = i;
        }

        public final void setItems(List<SubscriptionItemInfo> list) {
            kotlin.jvm.internal.h.b(list, "<set-?>");
            this.items = list;
        }

        public final void setProductName(String str) {
            kotlin.jvm.internal.h.b(str, "<set-?>");
            this.productName = str;
        }
    }

    public final String getEdition() {
        return this.edition;
    }

    public final List<SubscriptionProductInfo> getList() {
        return this.list;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setEdition(String str) {
        kotlin.jvm.internal.h.b(str, "<set-?>");
        this.edition = str;
    }

    public final void setList(List<SubscriptionProductInfo> list) {
        kotlin.jvm.internal.h.b(list, "<set-?>");
        this.list = list;
    }

    public final void setVersion(String str) {
        kotlin.jvm.internal.h.b(str, "<set-?>");
        this.version = str;
    }
}
