package c.a.a.a.c.e;

import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: AdobePhotoUtils.java */
/* loaded from: classes.dex */
public class b {
    public static String a() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static JSONObject a(String str) throws AdobePhotoException {
        try {
            Matcher matcher = Pattern.compile("while \\(1\\) \\{\\}").matcher(str);
            if (matcher.find()) {
                str = matcher.replaceAll("").trim();
            }
            return new JSONObject(str);
        } catch (Exception unused) {
            throw new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, null, "Parsed collection data is not of type dictionary.");
        }
    }
}
