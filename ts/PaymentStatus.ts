type PaymentStatus = "PAID" | "PENDING" | "FAILED";

type CardPayment = {
  type: "card";
  cardNumber: string;
  amount: number;
};

type PaypalPayment = {
  type: "paypal";
  email: string;
  amount: number;
};

type Payment = CardPayment | PaypalPayment;

function validatePayment(payment: Payment): string | null{

    if(payment.type === "card"){

        if(payment.cardNumber.length < 4 || payment.amount <= 0 || payment.amount > 5000) return "FAILED";

    }
    else if(payment.type === "paypal"){
        if(!payment.email.includes("@") || payment.amount <= 0) return "FAILED"
    }
    return null;

};

function processPayment(payment: Payment): PaymentStatus{

    const response = validatePayment(payment);
    if(response) return "FAILED";
    if(payment.amount > 3000) return "PENDING";
    return "PAID";
};