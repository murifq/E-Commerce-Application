package com.app.payloads;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PaymentCreditCardDTO {
    private String cardNumber;
    private String cvc;
}
