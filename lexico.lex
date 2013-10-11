import java.lang.System;

public class Analex{
	public static int main (String dato) throws java.io.IOException{
		FileReader fr = new FileReader("/home/vero/Escritorio/archivo");
		Yylex yy = new Yylex (fr);
		if (yy.yylex() != 0){
			return yy.yychar1;
		}
		return 0;
}

class Yytoken{
	Yytoken(){};
}

%%

%eofval{
	{System.exit(0);}
%eofval}

%line
%char
%char1


PALABRAS = [a-zA-Z]+
NUMEROS = [0-9]*

%%


{PALABRAS}  {}
{NUMEROS}  {}
"("  {}
")"  {}
"."  {}
"|:" {}
","  {}
";"  {}
" "  {}

[\n] {yychar = 0;}

.
{
	yychar1 =1;
	System.out.println("error lexico en " + yyline +" , " + yychar + " No se reconoce " + yytext());
	yychar =0;
	
	
}

