package utils;

import io.qameta.allure.Attachment;

public class AttachmentsHelper {
    @Attachment(value = "Test Details", type = "text/plain")
    public static String attachText(String message) {
        return message;
    }

    @Attachment(value = "API Response", type = "application/json")
    public static String attachJson(String jsonResponse) {
        return jsonResponse;
    }
}
