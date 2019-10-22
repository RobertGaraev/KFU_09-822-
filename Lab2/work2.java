package Kurs2;
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class work2 {
    public static void main(String[] args) {
        first(123654);
        System.out.println();
        second_Stack();
        System.out.println();
        second_Ochered();
        System.out.println();
        balans();
        System.out.println();
        formula();
        System.out.println();
        Sort();
        System.out.println();
        punkt6();
    }

    static void Stack(int chislo) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> secondstack = new Stack<>();
        int k = 0, chislodemo = chislo;
        while (chislodemo > 0) {
            chislodemo = chislodemo / 10;
            k++;
        }
        for (int i = 0; i < k; i++) {
            int a = (int) (chislo / Math.pow(10, k - i - 1));
            stack.push(a % 10);
        }
        System.out.println(stack);
        while (!stack.empty()) {
            secondstack.push(stack.peek());
            System.out.print(stack.pop());
        }
        System.out.println();
        while (!secondstack.empty()) {
            System.out.print(secondstack.pop());
        }
        System.out.println();
    }

    static void Ochered(int chislo) {
        ArrayDeque<Integer> ochered = new ArrayDeque<>();
        ArrayDeque<Integer> secondochered = new ArrayDeque<>();
        int k = 0, chislodemo = chislo;
        while (chislodemo > 0) {
            chislodemo = chislodemo / 10;
            k++;
        }
        for (int i = 0; i < k; i++) {
            int a = (int) (chislo / Math.pow(10, k - i - 1));
            ochered.add(a % 10);
            secondochered.add(a % 10);
        }
        System.out.println(ochered);
        for (int i = 0; i < k; i++) {
            System.out.print(ochered.pollFirst());
        }
        System.out.println();
        for (int i = 0; i < k; i++) {
            System.out.print(secondochered.pollLast());
        }
    }

    static void first(int chislo) {
        System.out.println("ðåøåíèå ñòåêîì");
        Stack(chislo);
        System.out.println("ðåøåíèå î÷åðåäüþ");
        Ochered(chislo);
    }

    static void second_Stack(){
        try {
            BufferedReader file = new BufferedReader( new FileReader("ÔÈÎ2.txt"));
            String line;
            int k = 0;
            FirstClass_work2[] information = new FirstClass_work2[5];
            Stack<String>  stack = new Stack<>();
            Stack<String>  stack_odl = new Stack<>();
            while ((line=file.readLine())!=null){
                information[k] = new FirstClass_work2(line);
                stack.push(line);
                k++;
            }
            System.out.println(stack);
            for (int i = information.length-1; i > -1; i--) {
                if (output(information[i])) System.out.println(stack.pop());
                else stack_odl.push(stack.pop());
            }
            while (!stack_odl.empty()){
                System.out.println(stack_odl.pop());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void second_Ochered(){
        try {
            BufferedReader file = new BufferedReader( new FileReader("ÔÈÎ2.txt"));
            String line;
            int k = 0;
            FirstClass_work2[] information = new FirstClass_work2[5];
            ArrayDeque<String>  ochered = new ArrayDeque<>();
            while ((line=file.readLine())!=null){
                information[k] = new FirstClass_work2(line);
                ochered.addLast(line);
                k++;
            }
            System.out.println(ochered);
            for (int i = information.length-1; i > -1; i--) {
                if (output(information[i])) System.out.println(ochered.pollLast());
                else ochered.addFirst(ochered.pollLast());
            }
            while(ochered.peek()!=null){
                System.out.println(ochered.pollLast());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean output (FirstClass_work2 ts) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date now = dateFormat.parse("12.10.2019");
            Date date = dateFormat.parse(ts.birthday());
            int age = (int)((now.getTime() - date.getTime())/24 /3600000/365);
            if (age<40) return true;
            else return false;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    static void balans(){
        Scanner a = new Scanner(System.in);
        System.out.println("ââåäèòå ìàòåìàòè÷åñêîå âûðàæåíèå");
        String line = a.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean t = false;
        char b;
        for (int i = 0; i < line.length(); i++) {
            b=line.charAt(i);
            if (b!='[' && b!=']' && b!='(' &&b!=')' && b!='{' && b!='}') continue;
            if (b=='['|| b=='{'||b=='('){
                stack.push(b);
            }
            else if (stack.empty())break;
            else if ((stack.peek()=='('&& b==')' )||(stack.peek()=='['&& b==']') || (stack.peek()=='{'&& b=='}'))stack.pop();
            else break;
            t=true;
        }
        if (!stack.empty())t=false;
        if (t) System.out.println("Áàëàíñ ñêîáîê ââåäåííîãî ìàòåìàòè÷åñêîãî âûðàæåíèÿ íå íàðóøåí");
        else System.out.println("Áàëàíñ ñêîáîê ââåäåííîãî ìàòåìàòè÷åñêîãî âûðàæåíèÿ íàðóøåí");
    }

    static void formula(){
        String line ="M(M(m(7,3),m(6,9)),M(m(2,1),0))";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i)==')'){
                int last = stack.pop();
                int prelast = stack.pop();
                if(stack.pop()=='M')
                    if (prelast>last) stack.push((char)prelast);
                    else stack.push((char)last);
                else if (prelast<last) stack.push((char)prelast);
                else stack.push((char)last);
            }
            else if(line.charAt(i)!=',' && line.charAt(i)!='(') stack.push(line.charAt(i));
        }
        System.out.println(stack.pop());
    }

    static void Sort(){
        try {
            BufferedReader bf = new BufferedReader( new FileReader("punkt5_work2.txt"));
            String line ;
            ArrayList<String> array = new ArrayList<>();
            while ((line=bf.readLine())!=null){
                array.add(line);
            }
            array.sort((o1, o2) -> {
                if (o1.length() != o2.length())
                    return o1.length() - o2.length();
                else
                    return o1.compareTo(o2);
            });
            System.out.println(array);
            Collections.sort(array);
            System.out.println(array);
            array.sort((o1, o2) -> {
                int k = 0, l = 0;
                for (int i = 0; i < o1.length(); i++) if (Character.isUpperCase(o1.charAt(i))) k++;
                for (int i = 0; i < o2.length(); i++) if (Character.isUpperCase(o2.charAt(i))) l++;
                if (k != l)
                    return k-l;
                else
                    return o1.compareTo(o2);
            });
            System.out.println(array);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void punkt6(){
        work_with_point plane = new work_with_point();
        plane.add_point(0,6);
        plane.add_point(-3,0);
        plane.add_point(7,4);
        plane.add_point(5,-4);
        System.out.println(plane.L(2,3));
        System.out.println(plane.S(1,3));
    }


}
