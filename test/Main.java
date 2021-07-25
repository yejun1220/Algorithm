class Main {
  public static void main(String[] args) {
      for(int i=1; i<100001; i++){
        String s1 = i + "";
        String s2 = "";
        for(int j=0; j<s1.length(); j++) {
          if(s1.charAt(j) =='3' || s1.charAt(j) =='6' || s1.charAt(j) =='9')
            s2 += "짝"; // 문자열로 변환 후 한글자씩 조회해서 갯수만큼 추가한다.
        }
        System.out.println(i + " 박수 "+ s2);
    }
  }
}