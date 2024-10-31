package org.keyczar.enums;

import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.ShareConstants;
import org.keyczar.i18n.Messages;

/* loaded from: classes3.dex */
public enum Flag {
    LOCATION(PlaceFields.LOCATION),
    NAME("name"),
    SIZE("size"),
    STATUS("status"),
    PURPOSE("purpose"),
    PADDING("padding"),
    DESTINATION(ShareConstants.DESTINATION),
    VERSION(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION),
    ASYMMETRIC("asymmetric"),
    CRYPTER("crypter"),
    PEMFILE("pemfile"),
    PASSPHRASE("passphrase");

    private final String name;

    Flag(String str) {
        this.name = str;
    }

    public static Flag getFlag(String str) {
        if (str != null) {
            if (str.equalsIgnoreCase(LOCATION.toString())) {
                return LOCATION;
            }
            if (str.equalsIgnoreCase(NAME.toString())) {
                return NAME;
            }
            if (str.equalsIgnoreCase(SIZE.toString())) {
                return SIZE;
            }
            if (str.equalsIgnoreCase(STATUS.toString())) {
                return STATUS;
            }
            if (str.equalsIgnoreCase(PURPOSE.toString())) {
                return PURPOSE;
            }
            if (str.equalsIgnoreCase(DESTINATION.toString())) {
                return DESTINATION;
            }
            if (str.equalsIgnoreCase(VERSION.toString())) {
                return VERSION;
            }
            if (str.equalsIgnoreCase(ASYMMETRIC.toString())) {
                return ASYMMETRIC;
            }
            if (str.equalsIgnoreCase(CRYPTER.toString())) {
                return CRYPTER;
            }
            if (str.equalsIgnoreCase(PEMFILE.toString())) {
                return PEMFILE;
            }
            if (str.equalsIgnoreCase(PASSPHRASE.toString())) {
                return PASSPHRASE;
            }
            if (str.equalsIgnoreCase(PADDING.toString())) {
                return PADDING;
            }
            throw new IllegalArgumentException(Messages.getString("Flag.UnknownFlag", str));
        }
        throw new NullPointerException();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
