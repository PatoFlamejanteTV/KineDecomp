package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Survey implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public static Parcelable.Creator<Survey> f3006a = new ac();
    private final JSONObject b;
    private final int c;
    private final int d;
    private final List<a> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Survey(JSONObject jSONObject) throws BadDecideObjectException {
        try {
            this.b = jSONObject;
            this.c = jSONObject.getInt(ShareConstants.WEB_DIALOG_PARAM_ID);
            this.d = jSONObject.getJSONArray("collections").getJSONObject(0).getInt(ShareConstants.WEB_DIALOG_PARAM_ID);
            JSONArray jSONArray = jSONObject.getJSONArray("questions");
            if (jSONArray.length() == 0) {
                throw new BadDecideObjectException("Survey has no questions.");
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(new a(this, jSONArray.getJSONObject(i), null));
            }
            this.e = Collections.unmodifiableList(arrayList);
        } catch (JSONException e) {
            throw new BadDecideObjectException("Survey JSON was unexpected or bad", e);
        }
    }

    String a() {
        return this.b.toString();
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public List<a> d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(a());
    }

    /* loaded from: classes.dex */
    public enum QuestionType {
        UNKNOWN { // from class: com.mixpanel.android.mpmetrics.Survey.QuestionType.1
            @Override // java.lang.Enum
            public String toString() {
                return "*unknown_type*";
            }
        },
        MULTIPLE_CHOICE { // from class: com.mixpanel.android.mpmetrics.Survey.QuestionType.2
            @Override // java.lang.Enum
            public String toString() {
                return "multiple_choice";
            }
        },
        TEXT { // from class: com.mixpanel.android.mpmetrics.Survey.QuestionType.3
            @Override // java.lang.Enum
            public String toString() {
                return "text";
            }
        };

        /* synthetic */ QuestionType(ac acVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class a {
        private final int b;
        private final String c;
        private final String d;
        private final List<String> e;

        /* synthetic */ a(Survey survey, JSONObject jSONObject, ac acVar) throws JSONException, BadDecideObjectException {
            this(jSONObject);
        }

        private a(JSONObject jSONObject) throws JSONException, BadDecideObjectException {
            this.b = jSONObject.getInt(ShareConstants.WEB_DIALOG_PARAM_ID);
            this.c = jSONObject.getString("type");
            this.d = jSONObject.getString("prompt");
            List emptyList = Collections.emptyList();
            if (jSONObject.has("extra_data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("extra_data");
                if (jSONObject2.has("$choices")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("$choices");
                    ArrayList arrayList = new ArrayList(jSONArray.length());
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    emptyList = arrayList;
                }
            }
            this.e = Collections.unmodifiableList(emptyList);
            if (d() == QuestionType.MULTIPLE_CHOICE && this.e.size() == 0) {
                throw new BadDecideObjectException("Question is multiple choice but has no answers:" + jSONObject.toString());
            }
        }

        public int a() {
            return this.b;
        }

        public String b() {
            return this.d;
        }

        public List<String> c() {
            return this.e;
        }

        public QuestionType d() {
            if (QuestionType.MULTIPLE_CHOICE.toString().equals(this.c)) {
                return QuestionType.MULTIPLE_CHOICE;
            }
            if (QuestionType.TEXT.toString().equals(this.c)) {
                return QuestionType.TEXT;
            }
            return QuestionType.UNKNOWN;
        }
    }
}
