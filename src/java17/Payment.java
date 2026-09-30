package java17;

public sealed interface Payment permits CreditCardPayment, UPIPayment{
}
