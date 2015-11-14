package com.droibit.automanaged.gac.utils;

import com.google.android.gms.common.ConnectionResult;

import static com.google.android.gms.common.ConnectionResult.*;
import static com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks.*;

/**
 * Google Play Servicesから戻る定数をわかりやすいように文字列に変換する。
 * 文字列は定数を宣言しているフィールド名と同じ。
 *
 * @author kumagai
 */
public final class GmsStrings {

    private GmsStrings() {
    }

    /**
     * 切断の原因に対する定数を文字列に変換する。
     * @param cause
     * @return
     */
    public static String toSuspendedString(int cause) {
        switch (cause) {
            case CAUSE_NETWORK_LOST:
                return "CAUSE_NETWORK_LOST";
            case CAUSE_SERVICE_DISCONNECTED:
                return "CAUSE_SERVICE_DISCONNECTED";
            default:
                return "UNKNOWN";
        }
    }

    /**
     * 接続失敗の原因に対する定数を文字列に変換する。
     * @param result
     * @return
     */
    public static String toConnectionErrorString(ConnectionResult result) {
        switch (result.getErrorCode()) {
            case SUCCESS:
                return "SUCCESS";
            case SERVICE_MISSING:
                return "SERVICE_MISSING";
            case SERVICE_VERSION_UPDATE_REQUIRED:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case SERVICE_DISABLED:
                return "SERVICE_DISABLED";
            case SIGN_IN_REQUIRED:
                return "SIGN_IN_REQUIRED";
            case INVALID_ACCOUNT:
                return "INVALID_ACCOUNT";
            case RESOLUTION_REQUIRED:
                return "RESOLUTION_REQUIRED";
            case NETWORK_ERROR:
                return "NETWORK_ERROR";
            case INTERNAL_ERROR:
                return "INTERNAL_ERROR";
            case SERVICE_INVALID:
                return "SERVICE_INVALID";
            case DEVELOPER_ERROR:
                return "DEVELOPER_ERROR";
            case LICENSE_CHECK_FAILED:
                return "LICENSE_CHECK_FAILED";
            case CANCELED:
                return "CANCELED";
            case TIMEOUT:
                return "TIMEOUT";
            case INTERRUPTED:
                return "INTERRUPTED";
            case API_UNAVAILABLE:
                return "API_UNAVAILABLE";
            case SIGN_IN_FAILED:
                return "SIGN_IN_FAILED";
            case SERVICE_UPDATING:
                return "SERVICE_UPDATING";
            case SERVICE_MISSING_PERMISSION:
                return "SERVICE_MISSING_PERMISSION";
            default:
                return "UNKNOWN_ERROR";
        }
    }
}
