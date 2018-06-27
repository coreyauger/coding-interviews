package io.surfkit.moderate;


public class Question16_18 {



    public static boolean tryPattern(String pattern, String value, int start,int  end){
        String a = value.substring(start, end);
        //System.out.println("s: "+start+ " e:" + end + "  a: "+ a);
        String[] bb = value.split(a);
        int numA = 0;
        int numB = 0;
        for( int i=0; i<pattern.length(); i++){
            if( pattern.charAt(i) == 'a')numA++;
            else numB++;
        }
        String[] pb = numA > numB ? pattern.split("a") : pattern.split("b");
        String b = "";
        for( int i=0; i < pb.length; i++){
            if( pb[i].length() > 0 && i <bb.length  && bb[i].length() > 0 ) {
                //System.out.println("bb:" + bb[i]);
                b = bb[i].substring(0, bb[i].length() / pb[i].length());
                break;
            }
        }
        //System.out.println("b: "+b);
        char[] pat = pattern.toCharArray();
        String forward = "";
        String backward = "";
        for( int i=0; i<pat.length; i++){
            if(pat[i] == 'a'){
                forward += a;
                backward += b;
            }else{
                forward += b;
                backward += a;
            }
        }
        //System.out.println("forward: " + forward);
        //System.out.println("backward: " + backward);
        if(value.equals(forward) || value.equals(backward))
        {
            System.out.println("A: "+ a);
            System.out.println("B: "+ b);
            return true;
        }
        return false;
    }

    public static boolean matching( String pattern, String value ){
        if( pattern.equals("a") || pattern.equals("b") || pattern.equals("ab") || pattern.equals("ba") ) return true;
        // so patern contains either 2 aa’s or 2 bb’s
        for( int i=0; i<value.length(); i++){
            int runner = i;
            for( int j=i+1; j<value.length(); j++){
                char next = value.charAt(j);
                while( value.charAt(runner) == next ){
                    if(tryPattern(pattern, value, i, runner+1) )return true;
                    runner++;
                    j++;
                    if(j == value.length())break;
                    next = value.charAt(j);
                }
                runner = i;
            }
        }
        return false;
    }








    public static void main(String[] args) {

        boolean match = matching("aabab", "catcatgocatgo");
        System.out.println("match: " + match);

        boolean match2 = matching("abb", "catfartfart");
        System.out.println("match: " + match2);

        boolean match3 = matching("aaa", "fartfartfart");
        System.out.println("match: " + match3);

        boolean match4 = matching("bbb", "fartfartfart");
        System.out.println("match: " + match4);
    }




    // SOLUTIONS
    /*

     */



}


