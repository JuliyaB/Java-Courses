public enum Operation {

    ADDITION {
        public float action(float firstNumber, float secondNumber) {
            return firstNumber + secondNumber;
        }
    },
    SUBTRACTION {
        public float action(float firstNumber, float secondNumber) {
            return firstNumber - secondNumber;
        }
    },
    DIVISION {
        public float action(float firstNumber, float secondNumber) {
            if (secondNumber==0) {
                throw new ArithmeticException("You cannot divide by zero!");
            }
            return firstNumber / secondNumber;
        }
    },
    MULTIPLICATION {
        public float action(float firstNumber, float secondNumber) {
            return firstNumber * secondNumber;
        }
    };

    public abstract float action(float firstNumber, float secondNumber);
}