package tech.techsete.utmify_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {
    WAITING_PAYMENT("waiting_payment"),
    PAID("paid"),
    REFUSED("refused"),
    REFUNDED("refunded"),
    CHARGEBACK("chargeback"),;

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static OrderStatus fromValue(String value) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status do pedido inválido: " + value);
    }
}
