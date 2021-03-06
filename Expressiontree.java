/*
    ExpressionTree.java
*/

public class ExpressionTree {
    // get closing bracket's index
    // given an expression and index of opening bracket
    public static int closingIndex(String exp, int openIndex) {
        int count = 1; // bracket counter; open: +1, close: -1
        int index = openIndex + 1;
        for (; index < exp.length(); index++) {
            char ch = exp.charAt(index);
            if (ch == '(')
                count++;
            else if (ch == ')')
                count--;

            // if count is 0, it is closing index
            if (count == 0)
                break;
        }
        return index;
    }

    // construct a tree with String expression
    // only with + - * / ( ) and a number
    // assumption:
    // 1. only two operand if no bracket. e.g. 1+2+3 will be given as (1+2)+3
    // 2. number is one-digit positive integer
    public static BinaryTree construct(String exp) {
        BinaryTree root = new BinaryTree();

        /* left operand */
        int opIndex = 1; // index of operator
        if (Character.isDigit(exp.charAt(0))) {
            root.setLeft(exp.substring(0, 1));
        } else {
            int index = closingIndex(exp, 0);
            BinaryTree left = construct(exp.substring(1, index));
            left.parent = root;
            root.left = left;

            opIndex = index + 1;
        }

        /* operator */
        root.elem = Character.toString(exp.charAt(opIndex));

        /* right operand */
        if (Character.isDigit(exp.charAt(opIndex + 1))) {
            root.setRight(exp.substring(opIndex + 1, opIndex + 2));
        } else {
            BinaryTree right = construct(exp.substring(opIndex + 2, exp.length() - 1));
            right.parent = root;
            root.right = right;
        }

        return root;
    }
    
    public static double checkDigit(String k) {
    	String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    	for (String i : digits) {
    		if (k.equals(i)) {
    			return Double.parseDouble(i);
    		}
    	}
    	return -1.0;
    }

    // calculate the constructed tree
    public static double calculate(BinaryTree tree) {
    	double leftside;
    	double rightside;
    	if (checkDigit(tree.left.elem) != -1.0) {
    		leftside = checkDigit(tree.left.elem);
    		System.out.println("X");
    	}
    	else {
    		leftside = calculate(tree.left);
    	}
    	if (checkDigit(tree.right.elem) != -1.0) {
    		rightside = checkDigit(tree.right.elem);
    		System.out.println("X");
    	}
    	else {
        	rightside = calculate(tree.right);
    	}
    	System.out.println(leftside);
    	System.out.println(tree.elem);
    	System.out.println(rightside);
        if (tree.elem.equals(String.valueOf('+'))) {
        	double out = leftside + rightside;
        	return out;
        }
        else if (tree.elem.equals(String.valueOf('-'))) {
        	double out = leftside - rightside;
        	return out;
        }
        else if (tree.elem.equals(String.valueOf('*'))) {
        	double out = leftside * rightside;
        	return out;
        }
        else if (tree.elem.equals(String.valueOf('/'))) {
        	double out = leftside / rightside;
        	return out;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = construct("1+3");
        //System.out.println(tree.left.elem);
        double result = calculate(tree);

        System.out.println(result);
    }
}
