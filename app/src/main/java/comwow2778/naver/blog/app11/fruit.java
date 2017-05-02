package comwow2778.naver.blog.app11;

/**
 * Created by seon on 2017-04-27.
 */

public class fruit {
    static public int imglist[] = {R.drawable.abocado, R.drawable.banana,R.drawable.cherry,
            R.drawable.cranberry, R.drawable.grape,R.drawable.kiwi,R.drawable.orange,R.drawable.watermelon};
    static public int pricelist[] = {1000,2000,3000,4000,5000,6000,7000,8000};
    private String name;
    private String price;
    private int imgno;
    public fruit(String name,int imgno,String price){
        this.name = name;
        this.price = price;
        this.imgno = imgno;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImgno() {
        return imgno;
    }

    public void setImgno(int imgno) {
        this.imgno = imgno;
    }
}

