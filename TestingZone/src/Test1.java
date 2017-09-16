public class Test1 {
    public static void main(String[] args) {
        System.out.println("E " + (6+3)%26);
        System.out.println("D " + (9-3)%26);
        char a = 'a';
        int let = (int)a;
        System.out.println(let);
        let = (let+3)%26;
        let = 26 - let;
        System.out.println(let);
        a = (char)let;
        System.out.println(a);
    }
}
