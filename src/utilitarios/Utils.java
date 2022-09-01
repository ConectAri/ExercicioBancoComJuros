package utilitarios;

import java.text.DecimalFormat;

//Para organizar os códigos, que não são de cliente nem de conta
//Para ser reaproveitado em todas as classes

import java.text.NumberFormat;

public class Utils {
	
	//Método de formatação de valores, define o modelo de como representar
	static NumberFormat formatandoValores = new DecimalFormat(" R$ #, ##0.00 ");
	// Todos os valores será de double
	
	//Método que recebe valores em double e o formato sai em String
	//Quando se faz operação matemática utiliza-se double ou int, na impressão
	//o ideal é par formatar e imprimir
	public static String doubleToString(Double valor) {
		return formatandoValores.format(valor);
	}

}
