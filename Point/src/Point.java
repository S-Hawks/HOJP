public class Point {
    private int x;
    private int y;
//constructor
    public Point(){
        this(0,0);
    }
    public Point(int x, int y){
      this.x = x;
      this.y = y;
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public double distance(int x, int y){
        return Math.sqrt(Math.pow(x-x, 2) + Math.pow(y-y, 2));
    }
    public double distance(){
        return distance(0,0);
    }
    public double distance(Point point){
        return distance(point.x, point.y);
    }

}
