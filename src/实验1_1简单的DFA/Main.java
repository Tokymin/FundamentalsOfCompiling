package 实验1_1简单的DFA;

import java.util.Scanner;
//设DFA M=({S,U,V,Q},{a,b},f, S, {Q}) 其中f定义为:
//
//    f(S,a)=U  f(V,a)=U
//
//    f(S,b)=V  f(V,b)=Q
//
//    f(U,a)=Q  f(Q,a)=Q
//
//    f(U,b)=V  f(Q,b)=Q


public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      String str = s.next();
      char[] chars = str.toCharArray();
      if (identifyDFA(chars)) {
        System.out.println("accept");
      } else {
        System.out.println("not accept");
      }
    }
  }

  /*  DFA的状态转换函数
   * char S:当前状态
   * char t1:输入符号
   * */

  private static char move(char S, char t1) {
    char nextStatus = ' ';//下一个状态
    if (t1 == 'a') {
      switch (S) {
        case 'S':
          nextStatus = 'U';
          break;
        case 'U':
          nextStatus = 'Q';
          break;
        case 'V':
          nextStatus = 'U';
          break;
        case 'Q':
          nextStatus = 'Q';
          break;
      }
    } else if (t1 == 'b') {
      switch (S) {
        case 'S':
          nextStatus = 'V';
          break;
        case 'U':
          nextStatus = 'V';
          break;
        case 'V':
          nextStatus = 'Q';
          break;
        case 'Q':
          nextStatus = 'Q';
          break;
      }
    }
    return nextStatus;
  }

  /*  DFA的识别函数
   * char S:当前状态
   * char t1:输入符号
   * */
  private static boolean identifyDFA(char[] t) {
    char S = 'S';
    for (char aT : t) {//字符'\0' : ASCII码为0,表示一个字符串结束的标志
      S = move(S, aT);
    }
    return S == 'Q';
  }
}
