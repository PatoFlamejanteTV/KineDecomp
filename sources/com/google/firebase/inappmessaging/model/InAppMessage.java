package com.google.firebase.inappmessaging.model;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.google.auto.value.AutoValue;
import com.google.firebase.inappmessaging.model.b;
import com.google.firebase.inappmessaging.model.d;
import com.google.firebase.inappmessaging.model.f;
import com.google.firebase.inappmessaging.model.i;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@Keep
@AutoValue
/* loaded from: classes2.dex */
public abstract class InAppMessage {

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    @Keep
    @AutoValue
    /* loaded from: classes2.dex */
    public static abstract class Action {

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        @AutoValue.Builder
        /* loaded from: classes2.dex */
        public static abstract class Builder {
            public abstract Builder a(String str);

            public abstract Action a();
        }

        public static Builder builder() {
            return new d.a();
        }

        @Nullable
        public abstract String getActionUrl();
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class Builder {
        public abstract Builder a(Action action);

        public abstract Builder a(Button button);

        public abstract Builder a(Text text);

        public abstract Builder a(MessageType messageType);

        public abstract Builder a(Boolean bool);

        public abstract Builder a(String str);

        public abstract InAppMessage a();

        public abstract Builder b(Text text);

        public abstract Builder b(String str);

        public abstract Builder c(String str);

        public abstract Builder d(String str);
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    @Keep
    @AutoValue
    /* loaded from: classes2.dex */
    public static abstract class Button {

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        @AutoValue.Builder
        /* loaded from: classes2.dex */
        public static abstract class Builder {
            public abstract Builder a(Text text);

            public abstract Builder a(String str);

            public abstract Button a();
        }

        public static Builder builder() {
            return new f.a();
        }

        @Nullable
        public abstract String getButtonHexColor();

        @Nullable
        public abstract Text getText();
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    @Keep
    @AutoValue
    /* loaded from: classes2.dex */
    public static abstract class ImageData {

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        @AutoValue.Builder
        /* loaded from: classes2.dex */
        public static abstract class Builder {
        }

        public static Builder builder() {
            return new g();
        }

        @Nullable
        public abstract Bitmap getBitmapData();

        public abstract String getImageUrl();
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    @Keep
    @AutoValue
    /* loaded from: classes2.dex */
    public static abstract class Text {

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        @AutoValue.Builder
        /* loaded from: classes2.dex */
        public static abstract class Builder {
            public abstract Builder a(String str);

            public abstract Text a();

            public abstract Builder b(String str);
        }

        public static Builder builder() {
            return new i.a();
        }

        @Nullable
        public abstract String getHexColor();

        @Nullable
        public abstract String getText();
    }

    public static Builder builder() {
        return new b.a();
    }

    @Nullable
    public abstract Action getAction();

    @Nullable
    public abstract Button getActionButton();

    @Nullable
    public abstract String getBackgroundHexColor();

    @Nullable
    public abstract Text getBody();

    public abstract String getCampaignId();

    public abstract String getCampaignName();

    @Nullable
    public abstract ImageData getImageData();

    @Nullable
    public abstract String getImageUrl();

    public abstract Boolean getIsTestMessage();

    public abstract MessageType getMessageType();

    @Nullable
    public abstract Text getTitle();
}
