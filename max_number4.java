/*
  Time Complexity: O(N)
  Space Complexity: O(1)
  HOW TO FIND MAX NUMBER IN 4 DIGIT
  INPUT: 5438 -> 543, 548, 538, 438 
  output is 548 ( MAX )
*/
int max = 0;
        int i = 1;
        while( n / i > 0 ){
            int new_num = (n / (i*10)) * i+n%i;
            i *= 10;
            if(max < new_num)
                    max = new_num;
        }
        System.out.println(max);
