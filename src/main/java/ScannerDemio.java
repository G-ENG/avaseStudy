import java.util.Scanner;
/**
 * 如果是读一行数据还是用nextLine好，读一行int 数组
 * next是一个一个读，nextInt是读一个一个int型
 * while（hasNext)是循环一直一个一个读
 * while（hasNextInt）输入不为int型会停止循环
 *
 */
public class ScannerDemio {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // next方式接收字符串,一行多个以空格分隔，有效字符前空格忽略,一次只能读一个 可以看到两个参数是两行输出的
        while (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("next方式输入的数据为：" + str1);
            if (str1.equals("nextLine")) {
                nextline(scan);
            }
            if(str1.equals("nextInt")){
                nextInt(scan);
            }
            if (str1.equals("exit")) {
                break;
            }

        }
        scan.close();

    }

    private static void nextline(Scanner scanner) {

        System.out.println("切换到nextLine");
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.println("nextLine输出为" + str);
            if (str.equals("next")) {
                return;
            }
            if(str.equals("nextInt")){
                nextInt(scanner);
            }
        }

    }

    //nextInt方式，类似还有nextByte、nextDouble while也只读一行的数据，读的是多个参数
    private static void nextInt(Scanner scanner) {
        System.out.println("切换到nextInt方式");
        while (scanner.hasNextInt()) {
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            System.out.println("nextInt方式：a="+a+",b="+b);
        }
    }
}