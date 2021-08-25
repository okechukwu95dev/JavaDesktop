public class House3D {

    private  float  length;
    private float  width;
    private float  height;

    House3D(float length, float width, float height){
        this.length = length;
        this.height = height;
        this.width = width;
    }


    public static float HouseArea (float length, float width) {
        return (length * width);
    }

    public static float HouseVolume (float length, float width, float height){
        return (length * width* height);
    }



}
