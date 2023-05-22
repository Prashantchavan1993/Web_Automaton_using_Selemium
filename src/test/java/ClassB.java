import java.sql.SQLOutput;

public class ClassB {


// Prime No between 1 to 100

    public static void main(String[] args) {


        for(int i=1; i<=10 ; i++)
        {
            boolean flag = true;
            for(int j = 2; j<i; j++){
                if(i%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                System.out.println("Prime number is " +i );
            }
        }

    }
}
