import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {

    public List<BigDecimal> split (BigDecimal money, int parts) {

        List<BigDecimal> split= new ArrayList<>();
        BigDecimal centsBig = money.multiply(new BigDecimal("100"));
        centsBig = centsBig.setScale(0, BigDecimal.ROUND_HALF_EVEN);

        int cents = centsBig.intValue();
        System.out.println("cents : "+cents);
        int[] people = new int[parts];
        Arrays.fill(people, 0);
        int  men =0;

        while(cents>0){
                people[men]=people[men]+1;
                men++;
                cents--;
                if(men == parts){
                    men =0;
            }
        }

        for (int i =0; i< parts; i++ ){
            BigDecimal moneyForperson = new BigDecimal(people[i]);
            moneyForperson = moneyForperson.divide(new BigDecimal(100));
            moneyForperson = moneyForperson.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            split.add(moneyForperson);
        }
        return split;
    }


    public static void main(String[] args) {

        Main main = new Main();
        BigDecimal money = new BigDecimal(3.4);
        List<BigDecimal> split = main.split(money, 2);

        for (BigDecimal bd   :split){
            System.out.println(bd );
        }


    }




}
