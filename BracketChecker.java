public class BracketChecker {
    // validate: String -> boolean
    // Validate code only with brackets (), {}, and []
    // Examples:
    //      () - valid
    //      ()[] - valid
    //      {[]((){})}() - valid
    //      {(}) - invalid
    //      }{ - invalid
    //      ({} - invalid
    public static boolean validate(String code) {
        Stack stack = new Stack();
        for (int i = 0; i < length(code); i++) {
            if (code.charAt(i).equals("(") || code.charAt(i).equals("[") || code.charAt(i).equals("{")) {
                stack.push(code.charAt(i));
            }
            else if (code.charAt(i).equals("(") || stack[Stack.size(stack)-1].equals(")")) {
                stack.pop();
            }
            else if (code.charAt(i).equals("[") || stack[Stack.size(stack)-1].equals("]")) {
                stack.pop();
            }
            else if (code.charAt(i).equals("{") || stack[Stack.size(stack)-1].equals("}")) {
                stack.pop();
            }
        }
        if (Stack.size(stack) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(BracketChecker.validate("[]"));
        System.out.println(BracketChecker.validate("[{}]"));
        System.out.println(BracketChecker.validate("[{()}]"));
        System.out.println(BracketChecker.validate("[]()"));
        System.out.println(BracketChecker.validate("[][{}{{}()()}]"));
        System.out.println(BracketChecker.validate("]["));
        System.out.println(BracketChecker.validate("[[])"));
        System.out.println(BracketChecker.validate(""));
    }
}
