package com.app.entites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	@OneToOne(mappedBy = "payment", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Order order;

	@NotBlank
	@Size(min = 4, message = "Payment method must contain atleast 4 characters")
	private String paymentMethod;

    @NotBlank(message = "Card number cannot be blank")
    @Size(min = 16, max = 19, message = "Card number must be between 16 and 19 digits")
    @Pattern(regexp = "\\d+", message = "Card number must contain only digits")
    private String cardNumber;

	@NotBlank(message = "CVC cannot be blank")
    @Size(min = 3, max = 3, message = "CVC must be 3 digits long")
    @Pattern(regexp = "\\d{3}", message = "CVC must contain only digits")
    private String cvc;
}
