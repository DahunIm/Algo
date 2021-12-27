package gaboza;

import java.util.ArrayList;
import java.util.Arrays;

public class Susik {

	public static long answer = Long.MIN_VALUE;
	public static ArrayList<Long> numbers = new ArrayList<>();
	public static ArrayList<String> operand_ary = new ArrayList<>();
	public static String[] operand = { "+", "-", "*" };
	public static Boolean[] visited = new Boolean[3];
	public static String[] now_oper = new String[3];
	
	public static void main(String[] args) {

		String expression = "100-200*300-500+20";
	
		Arrays.fill(visited, false);
		
		String tmp = "";
		
		for(int i = 0; i < expression.length(); i++){
			char ex_char = expression.charAt(i);
			if( ex_char  == '*' ||  ex_char  == '+' || ex_char  == '-') {				
					operand_ary.add(Character.toString(ex_char));
					numbers.add(Long.parseLong(tmp));
					tmp = "";
			}
			else {
				tmp += ex_char;
			}			
		}	
		numbers.add(Long.parseLong(tmp));
		
		op_count(0, operand.length);
		
		System.out.println(answer);
	}
	
	public static void op_count(int count, int len) {
		
		if(count == len) {
			calc();
			return;
		}
		
		for(int i = 0; i < operand.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				now_oper[count] = operand[i];
				op_count(count + 1, len);
				visited[i] = false;
			}
			
		}
		
		
	}
	public static void calc() {
		
		ArrayList<Long> cal_numbers = new ArrayList<>();
		cal_numbers.addAll(numbers);
		ArrayList<String> cal_operands = new ArrayList<>();
		cal_operands.addAll(operand_ary);
		
		for(int i = 0; i < now_oper.length; i++) {
			String now_op = now_oper[i];
			for(int j = 0; j < cal_operands.size(); j++) {
				if(cal_operands.get(j).equals(now_op)) {
					long a = cal_numbers.get(j);
					long b = cal_numbers.get(j+1);
					long tmp_val = operand_calc(a, b, now_op);
					
					cal_numbers.remove(j+1);
					cal_numbers.remove(j);
					cal_operands.remove(j);
					
					cal_numbers.add(j, tmp_val);
					j--;
				}
			
			}
		}
	
		answer = Math.max(answer, Math.abs(cal_numbers.get(0)));
	}
	
	public static long operand_calc(long a, long b, String op) {
		long result = 0;
		switch(op) {
			case "+":
				result = a + b;
				break;
			case "-":
				result = a - b;
				break;
			case "*":
				result = a * b;
				break;
		}
		return result;
	}
}
