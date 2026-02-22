
type PaymentStatus = "PAID" | "PENDING" | "FAILED";

function isSuccessful(status: PaymentStatus): boolean {
    return status === "PAID";
};

type Payment =
  | { type: "card"; cardNumber: string; amount: number }
  | { type: "paypal"; email: string; amount: number };

function processPayment(payment:Payment): PaymentStatus{

    if(payment.type === "card" && (payment.cardNumber.length < 4 || payment.amount > 5000)) return "FAILED";
    if (payment.type === "paypal" && !payment.email.includes("@")) return "FAILED";
    return "PAID";
};


