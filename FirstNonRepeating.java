/* approcah is we store frequency of ith character and push it into queue 
if peek() element is repaeating or it's frequencty is greater than 1 
we poll() the element until q is not empty or non repeating element does not exists
if non repeating element come to the peek() of the queue then we append peek() 
element to the answer and break the loop
remember we queue is empty at the end mean no reapeating element found then we 
simply append the # to the answer
try abcaxcybxy input case */
class Solution
{
    public String FirstNonRepeating(String str)
    {
       HashMap<Character, Integer> map = new HashMap<>();
       Queue<Character> q = new LinkedList<>();
       StringBuilder ans = new StringBuilder("");
       
       for(int i = 0; i < str.length(); i++){
           char c = str.charAt(i);
           if(map.containsKey(c)){
               map.put(c, map.get(c) + 1);
           }
           else
            map.put(c, 1);
            
            q.offer(c);
            
            while(!q.isEmpty()){
                if(map.get(q.peek()) > 1){
                    q.poll();
                }
                else
                {
                    ans.append(q.peek());
                    break;
                }
            }
            if(q.isEmpty())
                ans.append('#');
       }
       
       return ans.toString();
    }
}
