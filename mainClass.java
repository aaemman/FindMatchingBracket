import java.util.ArrayList;
import java.util.HashMap;

/*[3,2,1,0]
 ( ( ) )
 0 1 2 3

"(())" => [3,2,1,0]
"()()" => [1,0,3,2]*/
public class mainClass{
	
public static void main(String[] args){
	
}
public ArrayList<Integer> match(String str){
    
    HashMap<String, Integer> count = new HashMap<String, Integer>();
    ArrayList<Integer> allBrackets = new ArrayList<Integer>();
    ArrayList<Integer> openBrackets = new ArrayList<Integer>();
    
    for(int i = 0; i < str.length(); i++){
        
        if(str.substring(i).equals("(")){
            count.put(str.substring(i), count.get(str.charAt(i))+1);
            openBrackets.add(i);
        }else if(str.substring(i).equals(")")){        
             count.put(str.substring(i), count.get(str.substring(i))+1);
             int match = openBrackets.get(openBrackets.size()-1);
             allBrackets.add(match,i);
             allBrackets.add(i,match);
             openBrackets.remove(openBrackets.size()-1);
             
        }else{
            System.out.println("ERROR: string contains non parethesy charracter");
            return null;
        }
        
    }
    
    if(count.get("(") != count.get(")")){
        System.out.println("unmatching parenthesies");
        return null;
    }
    
    
    return allBrackets;
    


}
}