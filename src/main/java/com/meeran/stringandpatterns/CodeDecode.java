package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class CodeDecode {
	
	public static String code(String s) {
	    if (s == "")
	      return "";
	    int n = (int)Math.ceil(Math.sqrt(s.length()));
	    StringBuilder result = new StringBuilder(n * n + n - 1);
	    for (int i = 0; i < n; i++) {
	      for (int j = 0; j < n; j++)
	        result.append((n - j - 1) * n + i < s.length() ? s.charAt((n - j - 1) * n + i) : (char)11);
	      if (i < n - 1)
	        result.append('\n');
	    }
	    return result.toString();
	  }
	  
	  public static String decode(String s) {
	    if (s == "")
	      return "";
	    int n = (int)Math.sqrt(s.length());
	    StringBuilder result = new StringBuilder(n * n);
	    for (int i = 0; i < n; i++)
	      for (int j = 0; j < n; j++)
	        if (s.charAt(j * n + n - i - 1 + j) != (char)11)
	          result.append(s.charAt(j * n + n - i - 1 + j));
	    return result.toString();
	  }
	  
	  
	  
	///////////////////////////////////////////// 
	public static String code_X(String s) {
        if (s.equals("")) {
            return "";
        }
        int l = s.length();
        int n = (int) Math.ceil(Math.sqrt(l));
        while (s.length() < n * n) {
            s += (char) 11;
        }
        String[][] square = new String[n][n];
        for (int i = 0; i < n * n; i += n) {
            square[i / n] = s.substring(i, i + n).split("");
        }
        square = rotate90(square);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(square[i][j]);
            }
            if(i!=n-1) sb.append("\n");
        }
        return sb.toString();
    }

    public static String[][] rotate90(String[][] A) {
        A = reverse(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A[0].length; j++) {
                String temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        return A;
    }

    public static String[][] reverse(String[][] A) {
        String[][] B = new String[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                B[i][j] = A[A.length - 1 - i][j];
            }
        }
        return B;
    }
    public static String decode_X(String s) {
        // your code
    	if(s==null ||s.equals("")) return "";
    	String[] square = s.split("\n");
        for (int i = 0; i < square.length; i++) {
            square[i] = square[i].replaceAll("\r", "");
        }
        String[][] square2 = new String[square.length][square.length];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                square2[i][j] = square[i].substring(j, j + 1);
            }
        }
        String[][] square3 = new String[square.length][square.length];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                square3[i][j] = square2[j][i];
            }
        }
        String[][] square4 = new String[square.length][square.length];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                square4[i][j] = square3[square.length - 1 - i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                sb.append(square4[i][j]);
            }
        }
        String s2 = sb.toString();
        int ind = s2.length() - 1;
        while (ind >= 0) {
            if (s2.charAt(ind) == 11) {
                ind--;
            } else {
                break;
            }
        }
        return s2.substring(0, ind + 1);
    }

    public static String[][] rotate_90(String[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A[0].length; j++) {
                String temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        A = reverse(A);
        return A;
    }
    
    String data1 = "What do you remember? When I looked at his streaky glasses, I wanted " +
    	    "to leave him. And before that? He stole those cherries for me at midnight. We were walking " +
    	    "in the rain and I loved him. And before that? I saw him coming " +
    	    "toward me that time at the picnic, edgy, foreign.";
    	    String data2 = "Some say the world will end in fire, Some say in ice. From what I've tasted of desire " +
    	    "I hold with those who favor fire. But if it had to perish twice, I think I know enough of hate" +
    	    " To say that for destruction ice Is also great And would suffice.";
    	            
    	    String data3 = "And on black ground a bear-skin rug of snow. The sparks made no attempt to be the moon. " +
    	    "They were content to figure in the trees As Leo, Orion, and the Pleiades. " +
    	    "And that was what the boughs were full of soon.";
    	            
    	    String data4 = "Sky a shook poncho. Roof wrung. Mind a luna moth in a banjo." +
    	    "This weather's witty Peek-a-boo. A study in Insincerity";
    	            
    	    String data5 = "Snow would be the easy way out-that softening sky like a sigh of relief and finally being allowed" +
    	    " to yield. No dice. We stack twigs for burning in glistening patches but the rain won't give.";

    	    String data6 = "The panel found that he was loyal and discreet with atomic secrets, but did not recommend that his" +
    	    " security clearance be reinstated. This ended his role in government and policymaking. He became an academic " +
    	    "exile, cut off from his former career and the world he had helped to create.";
    	    
    	    String data1Sol =
    	    "\013ctg?.nadr d gdbW\n\013,i    lnis tl eh\n\013 mtIAakietboaara\n\013eeo nnigsoe st?t\n\013d wsddnh lfls   \n\013gaaa  gtfeoeehWd\n" +
    	    "\013ytrwbI .o rasiho\n\013, d e i rtev,se \n\013 t hflnW h e  ny\n\013fhmioo emot Is o\n\013oeemrvt eshh tIu\n\013r   eehw eaiwr  \n" +
    	    "\013eptc deea tmaelr\n\013iihot  rtc?.naoe\n\013gcamhhre h  tkom\n\013nntiaia meHAeyke\n\013.i ntmiwirend em";

    	    String data2Sol =
    	    "fa  h ttrheI ilS\nitifakw   s'irdo\nc cotnihftivce m\neAereocaihree,we\n.n   wedroe . i \n\013dIdT , es t Sls\n\013 seoe t.eIaFola\n" +
    	    "\013w s nIo   srm y\n\013oatso  Bwhtoee \n\013ulrautpuhoem nt\n\013lsuyghetold sdh\n\013doc hir  d wa e\n\013  tt niif ohyi \n\013sgihoksfawfa nw\n" +
    	    "\013uroaf h vi ti o\n\013fent I iotd nfr";

    	    String data3Sol =
    	    "\013 t e,h eb TnoA\n\013fht  etyenh un\n\013uehPO o  oernd\n\013l alrt wt  ud \n\013lbteirfehasg o\n\013 o ioeiretp an\n\013ouwanege tao  \n" +
    	    "\013fgad,su merfbb\n\013 hse  rcomk el\n\013ss saAeoopssaa\n\013o w.ns nnt nrc\n\013owh d it. mo-k\n\013neaA Lne taws \n\013.rtnte nTod.kg\n" +
    	    "\013\013e dhotth e ir";

    	    String data4Sol =
    	    "eybteamio S\nr otanonfpk\niioytjtd oy\ntn. hoh wn \ny  Pe. arca\n\013IAerTi uh \n\013n e'hnlnos\n\013ssksi ug.h\n" +
    	    "\013it- san. o\n\013nuaw  a Ro\n\013cd-iwb Mok";

    	    String data5Sol =
    	    "'tiititbf iutS\nt nnwcoe snthn\n tggie iaig-eo\ngh  g.ynng t w\niepis igdhshe \nv an We   kaaw\nert felafoytso\n" +
    	    ".acgo dlif  yu\n\013ihlrs.ln ls l\n\013nei t oariowd\n\013 ssbaNwlekfa \n\013w tucoelletyb\n\013oberk dyi e e\n\013nunn d  eano ";

    	    String data6Sol =
    	    " rc i  iseumb ahT\ntlafcbpn  reuanah\nodrr eo erinttdte\n  eoeclgnetd o   \nchemxaiodiy dmdhp\nrer imcven tiiiea\n" +
    	    "e  hleyedschdcs n\nahaie mr tla  cwe\ntans,aanhaetnsral\nedd  nkmita oees \n.  fc ieserhtce f\n\013htouann dai rtlo\n" +
    	    "\013ehrtcgtr.nsre ou\n\013lem a. o c etwyn\n\013p eod alTescsiad\n\013ewrfeHneh eo,tl \n\013do fmed ibcm h t";

    	    private static void testing(String actual, String expected) {
    	        assertEquals(expected, actual);
    	    }
    	    private static int randInt(int min, int max) {
    	        return (int)(min + Math.random() * ((max - min) + 1));
    	    }
    	    @Test
    	    public void test() {
    	        System.out.println("Fixed Tests code decode");
    	        testing(CodeDecode.code(data1), data1Sol); 
    	        testing(CodeDecode.code(data2), data2Sol); 
    	        testing(CodeDecode.code(data3), data3Sol); 
    	        testing(CodeDecode.code(data4), data4Sol); 
    	        testing(CodeDecode.code(data5), data5Sol);
    	        testing(CodeDecode.code(""), ""); 
    	        testing(CodeDecode.decode(""), ""); 
    	        
    	        testing(CodeDecode.decode(data6Sol), data6);
    	    }
    	    //...................    
    	    private static String[][] transposeMatrixSol(String[][] a) {
    	        String temp = "";
    	        for (int i = 0 ; i < a.length; i++) {
    	            for (int j = i ; j < a[0].length ; j++) {
    	                temp = a[i][j]; a[i][j] = a[j][i]; a[j][i] = temp;
    	            }
    	        }
    	        return a;
    	    }
    	    private static String[][] stringToMatrixSol(String s) {
    	        String[] arr1 = s.split("\n");
    	        int l = arr1.length;
    	        String[][] res = new String [l][l];
    	        for (int i = 0; i < l; i++)
    	            res[i] = arr1[i].split("");
    	        return res;
    	    }
    	    private static String matrixToStringSol(String[][] a) {
    	        String[] s = new String[a.length];
    	        for (int i = 0 ; i < a.length ; i++) {
    	            s[i] = String.join("", a[i]);
    	        }
    	        return String.join("\n", s);
    	    }
    	    private static String rot90ClockSol(String strng) {
    	        String[] arr = strng.split("\n");
    	        Collections.reverse(Arrays.asList(arr));
    	        return matrixToStringSol(transposeMatrixSol(stringToMatrixSol(String.join("\n", arr))));
    	    }
    	    private static String rot90CounterSol(String strng) {
    	        String[] arr = strng.split("\n");
    	        List<String> newarr = Arrays.stream(arr)
    	                .map(x -> new StringBuilder(x).reverse().toString())
    	                .collect(Collectors.toList());
    	        String s = String.join("\n", newarr);
    	        return matrixToStringSol(transposeMatrixSol(stringToMatrixSol(s)));
    	    }
    	    private static String chunkSol(String strng) {
    	        int sz = (int)Math.ceil(Math.sqrt(strng.length()));
    	        int lg = sz * sz;
    	        while (strng.length() != lg)
    	            strng += (char)11;
    	        String[] ret = new String[sz];
    	        for (int start = 0, i = 0; start < lg; start += sz, i++)
    	            ret[i] = strng.substring(start, start + sz);
    	        return String.join("\n", ret);
    	    }
    	    private static String codeSol(String s) {
    	        return rot90ClockSol(chunkSol(s));
    	    }
    	    private static String decodeSol(String s) {
    	        return String.join("", rot90CounterSol(s).split("\013")[0].split("\n"));
    	    }
    	    //...................
    	    private static String doEx(int k) {
    	        int j = 0; String res = "";
    	        while (j < k) {
    	            String s = ""; int i = 0; int u = randInt(5, 12);
    	            while (i < u) { 
    	                if (randInt(0, 100) % 2 == 0) 
    	                    s += (char)randInt(97, 122);
    	                else s += (char)randInt(65, 90);
    	                i++;
    	            }
    	            res += s + " ";
    	            j++;
    	        }
    	        return res.trim() + ".";
    	    }
    	    @Test
    	    public void test1() {
    	        System.out.println("Random Tests ****code decode");
    	        for (int i = 0; i < 200; i++) {
    	            int k = randInt(120, 200);
    	            String s1 = doEx(k);
    	            String ans = codeSol(s1);
    	            //System.out.println(ans + "\n");
    	            testing(CodeDecode.code(s1), ans);
    	            testing(CodeDecode.decode(ans), s1);
    	        }
    	    }
}
