package com.example.demo.negocio;

public class Comprimento {
	public final int milimetros;
	public int somamilimetros;
	public enum Unidade {POLEGADA, CENTIMETRO, METRO, KILOMETRO};

	public Comprimento(){
		this.milimetros=0;
	}

	public Comprimento(int mm){
		if(mm<0){
			throw new IllegalStateException("Milimetro deve ser positivo");
		}

		this.milimetros=mm;
	}

	public int milimetros() {
		return milimetros;
	}


	public Comprimento(double mm){
		if (mm < 0) {
			throw new IllegalArgumentException("Milimetro deve ser positivo");
		}

		mm=mm*1000;
		this.milimetros=(int)mm;
	}

	public static Comprimento fromPolegadas(double pol){
		pol=pol*25.4;
		return new Comprimento((int) pol);
	}

	public static Comprimento fromString(String medida){
		String tempNumeros = "";
		String tempLetras = "";
		for(int i=0;i<medida.length();i++){
			if(Character.isDigit(medida.charAt(i))){
				tempNumeros=tempNumeros+medida.charAt(i);
			}else if(Character.isLetter(medida.charAt(i))){
				tempLetras=tempLetras+medida.charAt(i);
			}else if(medida.charAt(i)=='\"'){
				tempLetras=tempLetras+medida.charAt(i);
			}else if(medida.charAt(i)==' '){
				throw new IllegalStateException("Medida não especificada");
			}
		}

		int tempNumerosInt = Integer.parseInt(tempNumeros);

		switch(tempLetras){
			case "mm":
			tempNumeros=tempNumeros;
			break;

			case "cm":
				tempNumerosInt = tempNumerosInt * 10;
			break;

			case "\"":
			double tempNumerosDouble = tempNumerosInt;
			tempNumerosDouble=tempNumerosDouble*25.4;
			tempNumerosInt=(int)tempNumerosDouble;
			break;

			case "m":
				tempNumerosInt = tempNumerosInt * 1000;
			break;

			default:
				throw new IllegalStateException("Medida não especificada");
		}

		return new Comprimento(tempNumerosInt);
	}

	public double getCentimetros(){
		double milimetroDouble = (double)this.milimetros;

		return milimetroDouble / 10;
	}

	public double getMetros() {
		double milimetroDouble = (double) this.milimetros;

		return milimetroDouble / 1000;
	}

	public double getPolegadas() {
		double milimetroDouble = (double) this.milimetros;

		return milimetroDouble / 25.4;
	}

	public int getMilimetros(){
		return this.milimetros;
	}

	@Override
	public String toString() {
		return this.milimetros + "mm";
	}

	public String toString(Unidade unidade){
		switch (unidade) {
			case POLEGADA:
				double milimetroDouble = (double) this.milimetros;

				return milimetroDouble / 25.4 + "\"";


			case CENTIMETRO:
				double milimetroDoubleCm = (double) this.milimetros;

				return milimetroDoubleCm / 10 + "cm";


			case METRO:
				double milimetroDoubleM = (double) this.milimetros;

				return milimetroDoubleM / 1000 + "m";


			case KILOMETRO:
				double milimetroDoubleKM = (double) this.milimetros;

				return milimetroDoubleKM / 100000000 + "km";

			default:
			return "Valor não especificado";
		}
	}

	public Comprimento mais(Comprimento medida){
		int tempMilimetros = this.milimetros;
		int tempSomaMilimetros = medida.milimetros;

		int newComprimento = tempMilimetros+tempSomaMilimetros;

		return new Comprimento(newComprimento);
	}

	public Comprimento mais(double medida){
		medida=medida*1000;
		int tempMedidaInt=(int)medida;
		int tempMilimetro=this.milimetros;
		int newComprimento = tempMilimetro+tempMedidaInt;

		return new Comprimento(newComprimento);
	}

	public Comprimento mais(int medida){
		int tempMilimetro=this.milimetros;
		int newComprimento= tempMilimetro+medida;

		return new Comprimento(newComprimento);
	}

	public Comprimento dobro(){
		int dobroMilimetro=this.milimetros;
		int newComprimento=dobroMilimetro*2;

		return new Comprimento(newComprimento);
	}

	public Comprimento vezes(int multiplica){
		int multiplicadoMilimetros=this.milimetros;
		int newComprimento=multiplicadoMilimetros*multiplica;

		return new Comprimento(newComprimento);
	}
}
