package Kurs2;

public class FirstClass_work2 {
        String [] data;
        String line;
        public FirstClass_work2(String  line) {
            this.line=line;
            this.data=line.split(" ");
        }
        public String surname(){
            return data[0];
        }
        public String name(){
            return data[1];
        }
        public String birthday(){
            return data[2];
        }
        public String pol(){
            return data[3];
        }
}
