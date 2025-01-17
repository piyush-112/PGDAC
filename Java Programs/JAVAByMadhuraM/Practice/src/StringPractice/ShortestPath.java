
public class ShortestPath {

    public static float getShortestPath(String path) {
        int x = 0;
        int y = 0;
        path=path.toLowerCase();
        for (int i = 0; i <path.length();i++) {
            char dir = path.charAt(i);
            //For south calculate the distance
            if(dir=='n'){
                y++;
            }else if(dir=='s'){
                y--;
            }else if(dir=='w'){
                x--;
            }
            else{
                x--;
            }
        }
        int x2=x*x;
        int y2=y*y;
        return (float)Math.sqrt(x2+y2);
    }
    public static void main(String[] args) {
        String path="ns";
        System.out.println(getShortestPath(path));
    }
}
