package com.tradestation.webapi;

import com.fasterxml.jackson.core.JsonParseException;
import com.ning.http.client.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.ExecutionException;

/**
 * @author jjelinek@tradestation.com
 *         <p/>
 *         Stream the deserialized response to any observers
 */
class StreamSource<T> extends Observable implements Runnable {
    private final Request request;
    private final Class<T> entity;

    public StreamSource(Request request, Class<T> entity) {
        this.request = request;
        this.entity = entity;
    }

    private static boolean isValidJSON(String json) {
        boolean valid = false;
        try {
            final com.fasterxml.jackson.core.JsonParser parser;
            parser = TradeStationWebApi.mapper.getFactory().createParser(json);
            while (parser.nextToken() != null) {
            }
            valid = true;
        } catch (JsonParseException e) {
            // not valid json, so swallow
        } catch (IOException e) {
            e.printStackTrace();
        }

        return valid;
    }

    @Override
    public void run() {
        try {
            TradeStationWebApi.client.executeRequest(request, new AsyncHandler<Response>() {
                private String remainingPartialJsonData = "";

                private <T> T processJson(String partialJsonData, Class<T> type) throws IOException {
                    String json = "";
                    for (char c : partialJsonData.toCharArray()) {
                        json += c;
                        if (json.contains("{") && isValidJSON(json)) {
                            remainingPartialJsonData = remainingPartialJsonData.replace(json, "");
                            json = json.replace("\\/Date(", "").replace(")\\/", "");
                            return TradeStationWebApi.mapper.readValue(json, type);
                        }
                    }
                    return null;
                }

                @Override
                public void onThrowable(Throwable throwable) {
                    throwable.printStackTrace();
                }

                @Override
                public STATE onBodyPartReceived(HttpResponseBodyPart httpResponseBodyPart) throws Exception {
                    ByteArrayOutputStream responseBytes = new ByteArrayOutputStream();
                    responseBytes.write(httpResponseBodyPart.getBodyPartBytes());

                    remainingPartialJsonData += responseBytes.toString("UTF-8");
                    String partialJsonData = remainingPartialJsonData;

                    if (partialJsonData.contains("ERROR")) {
                        return STATE.ABORT;
                    }

                    Object result = processJson(partialJsonData, entity);
                    if (result != null) {
                        setChanged();
                        notifyObservers(result);
                    }

                    return STATE.CONTINUE;
                }

                @Override
                public STATE onStatusReceived(HttpResponseStatus httpResponseStatus) throws Exception {
                    return STATE.CONTINUE;
                }

                @Override
                public STATE onHeadersReceived(HttpResponseHeaders httpResponseHeaders) throws Exception {
                    return STATE.CONTINUE;
                }

                @Override
                public Response onCompleted() throws Exception {
                    return null;
                }
            }).get();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
