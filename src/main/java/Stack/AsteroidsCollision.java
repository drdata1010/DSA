package Stack;

import java.util.Stack;

public class AsteroidsCollision {

    /**
     * We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the
     * array represent their relative position in space.
     *
     * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning
     * right, negative meaning left). Each asteroid moves at the same speed.
     *
     * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If
     * both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
     * */
    public static void main(String[] args) {
        int[] asteroids = {10,2,-5, -11};

        //Stack to maintain the state of collisions
        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids){
            //handling right moving objects (positive)
            if(asteroid > 0) {
                st.push(asteroid);
            }else{ //handling left moving objects
                //3 scenarios
                //1 - remove smaller right moving asteroid which collides with current left moving asteroid
                while(!st.empty() && st.peek() > 0 && st.peek() < Math.abs(asteroid)){
                    st.pop();
                }
                //2 - No collision or no remaining right moving asteroid to collide
                if(st.empty() || st.peek() < 0){
                    st.push(asteroid);
                }
                //3 - Equal sized asteroids coming from opposite directions collide and destroy each other
                else if(asteroid + st.peek() == 0){
                    st.pop();
                }
            }
        }

        //Whatever remains in Stack add it to a array in reverse to maintain the order
        int remains[] = new int[st.size()];
        for(int i = remains.length-1; i >= 0; i--){
            remains[i] = st.pop();
        }
        for(int i: remains){
            System.out.println(i);
        }
    }
}
