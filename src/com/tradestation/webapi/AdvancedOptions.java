package com.tradestation.webapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jjelinek@tradestation.com
 */
public class AdvancedOptions {
    private TrailingStop TrailingStop;

    private TrailingStop getTrailingStop() {
        return TrailingStop;
    }

    @JsonProperty("TrailingStop")
    private void setTrailingStop(TrailingStop trailingStop) {
        TrailingStop = trailingStop;
    }

    private class TrailingStop {
        private boolean ByPoints;
        private String Value;

        private boolean getByPoints() {
            return ByPoints;
        }

        @JsonProperty("ByPoints")
        private void setByPoints(boolean byPoints) {
            ByPoints = byPoints;
        }

        private String getValue() {
            return Value;
        }

        @JsonProperty("Value")
        private void setValue(String value) {
            Value = value;
        }
    }
}
