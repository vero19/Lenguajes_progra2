
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sat Oct 12 23:00:21 CST 2013
//----------------------------------------------------


import java.io.*;
import java_cup.runtime.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/** CUP v0.11a beta 20060608 generated parser.
 * @version Sun Oct 13 16:25:45 CST 2013
 */
public class parser extends java_cup.runtime.lr_parser {

 /** Default constructor. */
 public parser() {super();}

 /** Constructor which sets the default scanner. */
 public parser(java_cup.runtime.Scanner s) {super(s);}

 /** Constructor which sets the default scanner. */
 public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

 /** Production table. */
 protected static final short _production_table[][] = 
   unpackFromStrings(new String[] {
   "\000\027\000\002\002\004\000\002\002\004\000\002\002" +
   "\003\000\002\004\011\000\002\004\003\000\002\005\011" +
   "\000\002\005\003\000\002\012\003\000\002\012\005\000" +
   "\002\012\007\000\002\012\011\000\002\012\013\000\002" +
   "\011\006\000\002\007\003\000\002\007\005\000\002\007" +
   "\007\000\002\007\011\000\002\007\013\000\002\007\015" +
   "\000\002\006\003\000\002\006\002\000\002\010\004\000" +
   "\002\010\003" });

 /** Access to production table. */
 public short[][] production_table() {return _production_table;}

 /** Parse-action table. */
 protected static final short[][] _action_table = 
   unpackFromStrings(new String[] {
   "\000\060\000\006\003\005\006\004\001\002\000\004\007" +
   "\025\001\002\000\010\002\ufffb\003\ufffb\006\ufffb\001\002" +
   "\000\010\002\013\003\011\006\010\001\002\000\010\002" +
   "\uffff\003\uffff\006\uffff\001\002\000\004\007\014\001\002" +
   "\000\010\002\ufffd\003\ufffd\006\ufffd\001\002\000\010\002" +
   "\001\003\001\006\001\001\002\000\004\002\000\001\002" +
   "\000\006\005\uffed\006\015\001\002\000\010\005\uffeb\006" +
   "\uffeb\010\uffeb\001\002\000\004\005\021\001\002\000\010" +
   "\005\uffee\006\020\010\uffee\001\002\000\010\005\uffec\006" +
   "\uffec\010\uffec\001\002\000\006\006\015\010\uffed\001\002" +
   "\000\004\010\023\001\002\000\004\004\024\001\002\000" +
   "\010\002\ufffe\003\ufffe\006\ufffe\001\002\000\010\005\uffed" +
   "\006\015\010\uffed\001\002\000\006\005\051\010\ufff4\001" +
   "\002\000\004\010\030\001\002\000\004\011\031\001\002" +
   "\000\004\006\032\001\002\000\004\007\046\001\002\000" +
   "\004\004\045\001\002\000\006\004\ufffa\005\035\001\002" +
   "\000\004\006\032\001\002\000\006\004\ufff9\005\037\001" +
   "\002\000\004\006\032\001\002\000\006\004\ufff8\005\041" +
   "\001\002\000\004\006\032\001\002\000\006\004\ufff7\005" +
   "\043\001\002\000\004\006\032\001\002\000\004\004\ufff6" +
   "\001\002\000\010\002\ufffc\003\ufffc\006\ufffc\001\002\000" +
   "\010\005\uffed\006\015\010\uffed\001\002\000\004\010\050" +
   "\001\002\000\006\004\ufff5\005\ufff5\001\002\000\010\005" +
   "\uffed\006\015\010\uffed\001\002\000\006\005\053\010\ufff3" +
   "\001\002\000\010\005\uffed\006\015\010\uffed\001\002\000" +
   "\006\005\055\010\ufff2\001\002\000\010\005\uffed\006\015" +
   "\010\uffed\001\002\000\006\005\057\010\ufff1\001\002\000" +
   "\010\005\uffed\006\015\010\uffed\001\002\000\006\005\061" +
   "\010\ufff0\001\002\000\006\006\015\010\uffed\001\002\000" +
   "\004\010\uffef\001\002" });

 /** Access to parse-action table. */
 public short[][] action_table() {return _action_table;}

 /** <code>reduce_goto</code> table. */
 protected static final short[][] _reduce_table = 
   unpackFromStrings(new String[] {
   "\000\060\000\006\002\005\005\006\001\001\000\002\001" +
   "\001\000\002\001\001\000\004\004\011\001\001\000\002" +
   "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
   "\001\000\002\001\001\000\006\006\015\010\016\001\001" +
   "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
   "\002\001\001\000\006\006\021\010\016\001\001\000\002" +
   "\001\001\000\002\001\001\000\002\001\001\000\010\006" +
   "\025\007\026\010\016\001\001\000\002\001\001\000\002" +
   "\001\001\000\002\001\001\000\006\011\033\012\032\001" +
   "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
   "\000\004\011\035\001\001\000\002\001\001\000\004\011" +
   "\037\001\001\000\002\001\001\000\004\011\041\001\001" +
   "\000\002\001\001\000\004\011\043\001\001\000\002\001" +
   "\001\000\002\001\001\000\010\006\025\007\046\010\016" +
   "\001\001\000\002\001\001\000\002\001\001\000\006\006" +
   "\051\010\016\001\001\000\002\001\001\000\006\006\053" +
   "\010\016\001\001\000\002\001\001\000\006\006\055\010" +
   "\016\001\001\000\002\001\001\000\006\006\057\010\016" +
   "\001\001\000\002\001\001\000\006\006\061\010\016\001" +
   "\001\000\002\001\001" });

 /** Access to <code>reduce_goto</code> table. */
 public short[][] reduce_table() {return _reduce_table;}

 /** Instance of action encapsulation class. */
 protected CUP$parser$actions action_obj;

 /** Action encapsulation object initializer. */
 protected void init_actions()
   {
     action_obj = new CUP$parser$actions(this);
   }

 /** Invoke a user supplied parse action. */
 public java_cup.runtime.Symbol do_action(
   int                        act_num,
   java_cup.runtime.lr_parser parser,
   java.util.Stack            stack,
   int                        top)
   throws java.lang.Exception
 {
   /* call code in generated class */
   return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
 }

 /** Indicates start state. */
 public int start_state() {return 0;}
 /** Indicates start production. */
 public int start_production() {return 1;}

 /** <code>EOF</code> Symbol index. */
 public int EOF_sym() {return 0;}

 /** <code>error</code> Symbol index. */
 public int error_sym() {return 1;}



	public static void main(String string) throws Exception{
		FileReader fichero = (new FileReader("/home/vero/Escritorio/nuevo"));
		new parser(new Yylex(fichero)).parse();	
	}
	public void syntax_error(Symbol s){
		try{

		String a = "Error de sintaxis. Linea: " + (s.right + 1) +
		" Columna: " + s.left + ". Texto: \"" + s.value + "\"";

		FileWriter fichero = (new FileWriter("/home/vero/Escritorio/reglas.txt",true));
		PrintWriter p = new PrintWriter(fichero);
		        p.print(a +"\n");
		        fichero.close();
		}
		
	
		catch(IOException e){}
	}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
 private final parser parser;

 /** Constructor */
 CUP$parser$actions(parser parser) {
   this.parser = parser;
 }

 /** Method with the actual generated action code. */
 public final java_cup.runtime.Symbol CUP$parser$do_action(
   int                        CUP$parser$act_num,
   java_cup.runtime.lr_parser CUP$parser$parser,
   java.util.Stack            CUP$parser$stack,
   int                        CUP$parser$top)
   throws java.lang.Exception
   {
     /* Symbol object for return from actions */
     java_cup.runtime.Symbol CUP$parser$result;

     /* select the action based on the action number */
     switch (CUP$parser$act_num)
       {
         /*. . . . . . . . . . . . . . . . . . . .*/
         case 22: // Inicializacion ::= LETRA 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Inicializacion",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 21: // Inicializacion ::= Inicializacion LETRA 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Inicializacion",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 20: // E1 ::= 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("E1",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 19: // E1 ::= Inicializacion 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("E1",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 18: // Expresion ::= E1 COMA E1 COMA E1 COMA E1 COMA E1 COMA E1 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Expresion",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-10)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 17: // Expresion ::= E1 COMA E1 COMA E1 COMA E1 COMA E1 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Expresion",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 16: // Expresion ::= E1 COMA E1 COMA E1 COMA E1 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Expresion",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 15: // Expresion ::= E1 COMA E1 COMA E1 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Expresion",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 14: // Expresion ::= E1 COMA E1 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Expresion",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 13: // Expresion ::= E1 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Expresion",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 12: // Argumento ::= LETRA PARIZQ Expresion PARDER 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Argumento",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 11: // Antecedente ::= Argumento COMA Argumento COMA Argumento COMA Argumento COMA Argumento 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Antecedente",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 10: // Antecedente ::= Argumento COMA Argumento COMA Argumento COMA Argumento 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Antecedente",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 9: // Antecedente ::= Argumento COMA Argumento COMA Argumento 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Antecedente",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 8: // Antecedente ::= Argumento COMA Argumento 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Antecedente",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 7: // Antecedente ::= Argumento 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Antecedente",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 6: // Regla ::= error 
           {
             Object RESULT =null;
		 FileWriter fichero = (new FileWriter("/home/vero/Escritorio/reglas.txt",true));
		        fichero.append("bien");
             CUP$parser$result = parser.getSymbolFactory().newSymbol("Regla",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 5: // Regla ::= LETRA PARIZQ Expresion PARDER SEPARADOR Antecedente PUNTO 
           {
             Object RESULT =null;
		 FileWriter fichero = (new FileWriter("/home/vero/Escritorio/reglas.txt",true));
		        fichero.append("bien");
             CUP$parser$result = parser.getSymbolFactory().newSymbol("Regla",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 4: // Hecho ::= error 
           {
             Object RESULT =null;
		 FileWriter fichero = (new FileWriter("/home/vero/Escritorio/reglas.txt",true));
		        fichero.append("mal"); 
             CUP$parser$result = parser.getSymbolFactory().newSymbol("Hecho",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 3: // Hecho ::= LETRA PARIZQ E1 COMA E1 PARDER PUNTO 
           {
             Object RESULT =null;
		 FileWriter fichero = (new FileWriter("/home/vero/Escritorio/reglas.txt",true));
		        fichero.append("bien");
             CUP$parser$result = parser.getSymbolFactory().newSymbol("Hecho",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 2: // Base ::= Regla 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Base",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 1: // $START ::= Base EOF 
           {
             Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
             CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         /* ACCEPT */
         CUP$parser$parser.done_parsing();
         return CUP$parser$result;

         /*. . . . . . . . . . . . . . . . . . . .*/
         case 0: // Base ::= Base Hecho 
           {
             Object RESULT =null;

             CUP$parser$result = parser.getSymbolFactory().newSymbol("Base",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
           }
         return CUP$parser$result;

         /* . . . . . .*/
         default:
           throw new Exception(
              "Invalid action number found in internal parse table");

       }
   }
}