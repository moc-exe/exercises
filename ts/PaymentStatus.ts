type PaymentStatus = "PAID" | "PENDING" | "FAILED";

function isSuccessful(status: PaymentStatus): boolean {
    return status === "PAID";
};

type Payment =
  | { type: "card"; cardNumber: string; amount: number }
  | { type: "paypal"; email: string; amount: number };
