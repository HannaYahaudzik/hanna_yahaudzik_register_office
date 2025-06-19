package eu.senla.responses.getApplication;

import java.util.List;

public record GetApplicationResponse(
        String total,
        List<ApplicationData> data,
        String requestId
) {
}
