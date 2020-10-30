package session_2.bai_tap;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        System.out.print("Các số nguyên tố nhỏ hơn 100 là: ");
        int n = 2;
        boolean check = true;
        while (n<100){
            for(int i=2; i<=n-1; i++){
                if(n % i == 0){
                    check = false;
                    break;
                }
            }
            if (check){
                System.out.print(n + " ");
            }n++;
            check = true;
        }
    }
}
