package io.fabric.sdk.android.services.settings;

import com.crashlytics.android.beta.BuildConfig;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefaultSettingsJsonTransform.java */
/* loaded from: classes3.dex */
public class l implements w {
    private e b(JSONObject jSONObject) throws JSONException {
        return new e(jSONObject.getString("identifier"), jSONObject.getString("status"), jSONObject.getString("url"), jSONObject.getString("reports_url"), jSONObject.getString("ndk_reports_url"), jSONObject.optBoolean("update_required", false), (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) ? e(jSONObject.getJSONObject("icon")) : null);
    }

    private g c(JSONObject jSONObject) throws JSONException {
        return new g(jSONObject.optString("update_endpoint", v.f27063a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    private n d(JSONObject jSONObject) {
        return new n(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false), jSONObject.optBoolean("firebase_crashlytics_enabled", false));
    }

    private c e(JSONObject jSONObject) throws JSONException {
        return new c(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    private p f(JSONObject jSONObject) throws JSONException {
        return new p(jSONObject.optString("title", "Send Crash Report?"), jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    private q g(JSONObject jSONObject) throws JSONException {
        return new q(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false), jSONObject.optInt("max_complete_sessions_count", 4));
    }

    @Override // io.fabric.sdk.android.services.settings.w
    public u a(io.fabric.sdk.android.services.common.m mVar, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new u(a(mVar, optInt2, jSONObject), b(jSONObject.getJSONObject("app")), g(jSONObject.getJSONObject(com.umeng.analytics.pro.b.at)), f(jSONObject.getJSONObject("prompt")), d(jSONObject.getJSONObject("features")), a(jSONObject.getJSONObject("analytics")), c(jSONObject.getJSONObject(BuildConfig.ARTIFACT_ID)), optInt, optInt2);
    }

    private b a(JSONObject jSONObject) {
        return new b(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", io.fabric.sdk.android.a.b.c.MAX_BYTE_SIZE_PER_FILE), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("forward_to_google_analytics", false), jSONObject.optBoolean("include_purchase_events_in_forwarded_events", false), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    private long a(io.fabric.sdk.android.services.common.m mVar, long j, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return (j * 1000) + mVar.a();
    }
}
