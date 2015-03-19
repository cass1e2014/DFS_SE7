import java.util.ArrayList;


public class GenerateParentheses {
	public static void main(String[] args){
		GenerateParentheses gp = new GenerateParentheses();
		ArrayList<String> res = gp.generateParenthese(2);
		for(String s : res){
			System.out.println("GenerateParentheses -- main(): " + s);
		}
	}
	public ArrayList<String> generateParenthese(int n){
		ArrayList<String> result = new ArrayList<String>();
		if(n < 0){
			return result;
		}
		
		getPair(result, "", n, n);
		return result;
	}
	
	public void getPair(ArrayList<String> result, String s, int left, int right){
		if(left > right || left < 0 || right < 0 ){
			return;
		}
		
		if(left == 0 && right == 0){
			result.add(s);
			return;
		}
		getPair(result, s + "(", left - 1, right);		
		getPair(result, s + ")", left, right - 1);
	}
}
